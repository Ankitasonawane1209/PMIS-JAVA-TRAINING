package dao;

import entity.BorrowRecord;
import util.DBConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BorrowRecordDAO {

    public void borrowBook(int memberId, int bookId)
            throws SQLException {

        try (Connection con = DBConnection.getConnection()) {
            con.setAutoCommit(false);

            try {
                String userSql =
                        "SELECT role FROM Users WHERE user_id=?";

                try (PreparedStatement ps =
                             con.prepareStatement(userSql)) {
                    ps.setInt(1, memberId);

                    try (ResultSet rs = ps.executeQuery()) {
                        if (!rs.next() ||
                                !"MEMBER".equals(rs.getString("role"))) {
                            throw new SQLException(
                                    "Invalid member ID.");
                        }
                    }
                }

                String bookSql =
                        "SELECT available_copies FROM Books " +
                                "WHERE book_id=? FOR UPDATE";

                try (PreparedStatement ps =
                             con.prepareStatement(bookSql)) {
                    ps.setInt(1, bookId);

                    try (ResultSet rs = ps.executeQuery()) {
                        if (!rs.next()) {
                            throw new SQLException("Book not found.");
                        }
                        if (rs.getInt("available_copies") <= 0) {
                            throw new SQLException(
                                    "No copies available.");
                        }
                    }
                }

                int recordId;
                try (Statement st = con.createStatement();
                     ResultSet rs = st.executeQuery(
                             "SELECT COALESCE(MAX(record_id),0)+1 " +
                                     "FROM BorrowRecords")) {
                    rs.next();
                    recordId = rs.getInt(1);
                }

                LocalDate today = LocalDate.now();
                LocalDate due = today.plusDays(14);

                String insertSql =
                        "INSERT INTO BorrowRecords " +
                                "(record_id,member_id,book_id,borrow_date," +
                                "due_date,return_date,status) " +
                                "VALUES (?,?,?,?,?,NULL,'BORROWED')";

                try (PreparedStatement ps =
                             con.prepareStatement(insertSql)) {
                    ps.setInt(1, recordId);
                    ps.setInt(2, memberId);
                    ps.setInt(3, bookId);
                    ps.setDate(4, Date.valueOf(today));
                    ps.setDate(5, Date.valueOf(due));
                    ps.executeUpdate();
                }

                try (PreparedStatement ps = con.prepareStatement(
                        "UPDATE Books SET available_copies=" +
                                "available_copies-1 WHERE book_id=?")) {
                    ps.setInt(1, bookId);
                    ps.executeUpdate();
                }

                con.commit();
                System.out.println("Book borrowed successfully!");
                System.out.println("Record ID: " + recordId);
                System.out.println("Due date: " + due);

            } catch (SQLException | RuntimeException e) {
                con.rollback();
                throw e;
            } finally {
                con.setAutoCommit(true);
            }
        }
    }

    public void returnBook(int memberId, int recordId)
            throws SQLException {

        try (Connection con = DBConnection.getConnection()) {
            con.setAutoCommit(false);

            try {
                String findSql =
                        "SELECT book_id FROM BorrowRecords " +
                                "WHERE record_id=? AND member_id=? " +
                                "AND status='BORROWED' FOR UPDATE";

                int bookId;
                try (PreparedStatement ps =
                             con.prepareStatement(findSql)) {
                    ps.setInt(1, recordId);
                    ps.setInt(2, memberId);

                    try (ResultSet rs = ps.executeQuery()) {
                        if (!rs.next()) {
                            throw new SQLException(
                                    "Active borrowing record not found.");
                        }
                        bookId = rs.getInt("book_id");
                    }
                }

                try (PreparedStatement ps = con.prepareStatement(
                        "UPDATE BorrowRecords SET return_date=?, " +
                                "status='RETURNED' WHERE record_id=?")) {
                    ps.setDate(1, Date.valueOf(LocalDate.now()));
                    ps.setInt(2, recordId);
                    ps.executeUpdate();
                }

                try (PreparedStatement ps = con.prepareStatement(
                        "UPDATE Books SET available_copies=" +
                                "available_copies+1 WHERE book_id=?")) {
                    ps.setInt(1, bookId);
                    ps.executeUpdate();
                }

                con.commit();
                System.out.println("Book returned successfully!");

            } catch (SQLException | RuntimeException e) {
                con.rollback();
                throw e;
            } finally {
                con.setAutoCommit(true);
            }
        }
    }

    public List<BorrowRecord> getHistory(int memberId)
            throws SQLException {
        List<BorrowRecord> records = new ArrayList<>();

        String sql = "SELECT * FROM BorrowRecords " +
                "WHERE member_id=? ORDER BY record_id";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, memberId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    records.add(new BorrowRecord(
                            rs.getInt("record_id"),
                            rs.getInt("member_id"),
                            rs.getInt("book_id"),
                            rs.getDate("borrow_date"),
                            rs.getDate("due_date"),
                            rs.getDate("return_date"),
                            rs.getString("status")
                    ));
                }
            }
        }
        return records;
    }

    public void viewAllRecords() throws SQLException {
        String sql = "SELECT br.record_id,u.name,b.title," +
                "br.borrow_date,br.due_date,br.return_date," +
                "br.status FROM BorrowRecords br " +
                "JOIN Users u ON br.member_id=u.user_id " +
                "JOIN Books b ON br.book_id=b.book_id " +
                "ORDER BY br.record_id";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println(
                        "Record: " + rs.getInt("record_id") +
                                " | Member: " + rs.getString("name") +
                                " | Book: " + rs.getString("title") +
                                " | Borrow date: " + rs.getDate("borrow_date") +
                                " | Due date: " + rs.getDate("due_date") +
                                " | Return date: " + rs.getDate("return_date") +
                                " | Status: " + rs.getString("status"));
            }
        }
    }
}