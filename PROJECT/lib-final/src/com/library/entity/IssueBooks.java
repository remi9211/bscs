package com.library.entity;


public class IssueBooks {
    private String StudentName;
    private String IssueDate;
    private String IssuedTill;
    private String BookName;
    private String IssueId;

    public IssueBooks(String studentName, String issueDate, String issuedTill, String bookName, String issueId, String returnDate) {
        StudentName = studentName;
        IssueDate = issueDate;
        IssuedTill = issuedTill;
        BookName = bookName;
        IssueId = issueId;
        ReturnDate = returnDate;
    }

    public String getReturnDate() {
        return ReturnDate;
    }

    public void setReturnDate(String returnDate) {
        ReturnDate = returnDate;
    }

    private String ReturnDate;



    public String getIssueId() {
        return IssueId;
    }

    public void setIssueId(String issueId) {
        IssueId = issueId;
    }


    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public IssueBooks(){

    }



    public String getIssueDate() {
        return IssueDate;
    }

    @Override
    public String toString() {
        return "IssueBooks{" +
                "StudentName='" + StudentName + '\'' +
                ", IssueDate='" + IssueDate + '\'' +
                ", IssuedTill='" + IssuedTill + '\'' +
                ", BookName='" + BookName + '\'' +
                ", IssueId='" + IssueId + '\'' +
                ", ReturnDate='" + ReturnDate + '\'' +
                '}';
    }

    public void setIssueDate(String issueDate) {
        IssueDate = issueDate;
    }

    public String getIssuedTill() {
        return IssuedTill;
    }

    public void setIssuedTill(String issuedTill) {
        IssuedTill = issuedTill;
    }


}
