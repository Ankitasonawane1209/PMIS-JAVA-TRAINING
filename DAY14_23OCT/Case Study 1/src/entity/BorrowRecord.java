package entity;

import java.sql.Date;

public class BorrowRecord {
    private int recordId;
    private int memberId;
    private int bookId;
    private Date borrowDate;
    private Date dueDate;
    private Date returnDate;
    private String status;

    public BorrowRecord(int recordId, int memberId,
                        int bookId, Date borrowDate,
                        Date dueDate, Date returnDate,
                        String status) {
        this.recordId = recordId;
        this.memberId = memberId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public int getRecordId() {
        return recordId;
    }

    public int getMemberId() {
        return memberId;
    }

    public int getBookId() {
        return bookId;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public String getStatus() {
        return status;
    }
}