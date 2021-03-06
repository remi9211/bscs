package com.library.entity;

public class BookLog {
    private static String bookName;

    public BookLog() {
    }

    public BookLog(String bookName) {
        this.bookName = bookName;
    }

    public static String getBookName() {
        return bookName;
    }

    public static void setBookName(String bookName) {
        BookLog.bookName = bookName;
    }

    @Override
    public String toString() {
        return "BookIssued{" +
                "bookId='" + bookName + '\'' +
                '}';
    }
}
