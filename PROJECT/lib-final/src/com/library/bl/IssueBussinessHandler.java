package com.library.bl;


import com.library.entity.IssueBooks;
import com.library.ui.IssueBooksUi;
import com.library.ui.LibraryHomeUI;
import com.library.util.ConnectionDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IssueBussinessHandler implements ActionListener {

    Connection theConnectionDB;
    Statement statement;
    ResultSet resultSet;
    IssueBooksUi theGui;
    public IssueBussinessHandler(IssueBooksUi issueBooksUi) {
        try {
            theGui = issueBooksUi;
            theConnectionDB = ConnectionDB.getConnectionDB();
            statement = theConnectionDB.createStatement();
        }
        catch (SQLException s){
            s.printStackTrace();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Issue")){
            try {
                JOptionPane.showMessageDialog(null,"Book Issued!");

                IssueBooks issueBooks = new IssueBooks();

                issueBooks.setStudentName(theGui.getTxtStudentName().getText().toString());
                issueBooks.setIssueDate(theGui.getTxtIssueDate().getText().toString());
                issueBooks.setBookName(theGui.getTxtBookName().getText().toString());
               // issueBooks.setIssueId(theGui.getTxtIssueId().getText().toString());
               // issueBooks.setReturnDate(theGui.getTxtReturnDate().getText().toString());
                System.out.println(issueBooks);

                String strInsertQuery = "INSERT INTO issuebooks(BookName,StudentName,issue_date)" +
                        "VALUES ('"+issueBooks.getBookName()+"','" + issueBooks.getStudentName() + "','" + issueBooks.getIssueDate() + "');";
                String strUpdateQuery = "UPDATE library.books SET book_quantity  = book_quantity-1 WHERE book_name = '"+issueBooks.getBookName()+"';";
                //String strSetStuIDQuery = "UPDATE library4.issuebooks SET BookID  = books.book_id WHERE BookName = books.book_name;";
                clearFields();
                statement.execute(strInsertQuery);
                statement.execute(strUpdateQuery);

                //statement.execute((strSetStuIDQuery));
            }catch (SQLException s){
                s.printStackTrace();
            }
        }
        else if(e.getActionCommand().equals("Cancel")){
            theGui.dispose();
        }
    }

    private void clearFields() {
        theGui.getTxtStudentName().setText("");
        theGui.getTxtIssueDate().setText("");
        theGui.getTxtBookName().setText("");

    }
}
