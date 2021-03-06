package com.library.entity;

public class ReturnBooks {
    private String issuedTill;
    private String IssueId;
    private String bookName;


    public ReturnBooks(String issuedTill, String issueId, String bookName) {
        this.issuedTill = issuedTill;
        IssueId = issueId;
        this.bookName = bookName;
    }

    public ReturnBooks() {

    }



    public String getIssuedTill() {
        return issuedTill;
    }

    public void setIssuedTill(String issuedTill) {
        this.issuedTill = issuedTill;
    }

    public String getIssueId() {
        return IssueId;
    }

    public void setIssueId(String issueId) {
        IssueId = issueId;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "ReturnBooks{" +
                "issuedTill='" + issuedTill + '\'' +
                ", IssueId='" + IssueId + '\'' +
                ", bookName='" + bookName + '\'' +
                '}';
    }
}
