package com.library.entity;

public class UserIssuedBooks {
    private String studentName;

    public UserIssuedBooks() {
    }

    public UserIssuedBooks(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }


    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "UserIssuedBooks{" +
                "studentName='" + studentName + '\'' +
                '}';
    }
}

