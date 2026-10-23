package service;


import dao.BorrowRecordDAO;
import entity.BorrowRecord;

import java.sql.SQLException;
import java.util.List;

public class BorrowService {
    private final BorrowRecordDAO dao = new BorrowRecordDAO();

    public void borrowBook(int memberId, int bookId)
            throws SQLException {
        dao.borrowBook(memberId, bookId);
    }

    public void returnBook(int memberId, int recordId)
            throws SQLException {
        dao.returnBook(memberId, recordId);
    }

    public List<BorrowRecord> getHistory(int memberId)
            throws SQLException {
        return dao.getHistory(memberId);
    }

    public void viewAllRecords() throws SQLException {
        dao.viewAllRecords();
    }
}