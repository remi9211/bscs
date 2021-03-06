package com.library.bl;

import com.library.entity.UserIssuedBooks;
import com.library.ui.UserIssuedBooksUI;
import com.library.ui.ViewUserIssuedBooks;
import com.library.util.ConnectionDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserIssuedBooksBusinessHandler implements ActionListener {
    private JPanel contentPane;
    private JTable table;

    Connection theConnectionDB;
    Statement statement;
    ResultSet resultSet;
    UserIssuedBooksUI theGui;
    ViewUserIssuedBooks viewUserIssuedBooks;

    public UserIssuedBooksBusinessHandler(UserIssuedBooksUI userIssuedBooksUI) {
        theGui = userIssuedBooksUI;
        theConnectionDB = ConnectionDB.getConnectionDB();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Confirm")) {
            try {
                UserIssuedBooks userIssuedBooks = new UserIssuedBooks();
                userIssuedBooks.setStudentName(theGui.getTxtStudentName().getText().toString());
                System.out.println(userIssuedBooks);
                viewUserIssuedBooks = new ViewUserIssuedBooks(userIssuedBooks);
                viewUserIssuedBooks.setVisible(true);
                clearFields();
            }
            catch (Exception s){
                s.printStackTrace();
            }
        }
        if(e.getActionCommand().equals("Cancel")){
            theGui.dispose();
        }
    }
    public void clearFields() {
        theGui.getTxtStudentName().setText("");
    }

}
