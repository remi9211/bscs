package com.library.bl;

import com.library.entity.Books;
import com.library.ui.AddABookUI;
import com.library.ui.LibraryHomeUI;
import com.library.util.ConnectionDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddABookBusinessHandler implements ActionListener {

    Connection theConnectionDB;
    Statement statement;
    ResultSet resultSet;
    AddABookUI addABookGui;

    public AddABookBusinessHandler(AddABookUI addABookUI) {
        try {
            addABookGui = addABookUI;
            theConnectionDB = ConnectionDB.getConnectionDB();
            statement = theConnectionDB.createStatement();
        } catch (SQLException s) {
            s.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Save")){
            try {
                Books books = new Books();
                books.setBookId(addABookGui.getTxtBookID().getText().toString().toUpperCase());
                books.setBookName(addABookGui.getTxtBookName().getText().toString());
                books.setBookAuthor(addABookGui.getTxtBookAuthor().getText().toString());
                books.setBookPublisher(addABookGui.getTxtBookPublisher().getText().toString());
                String bookQuantity = (addABookGui.getTxtBookQuantity().getText().toString());
                int intBookQuantity = Integer.parseInt(bookQuantity);
                books.setBookQuantity(intBookQuantity);
                String strInsertQuery = "INSERT INTO Books (book_id,book_name,book_author,book_publisher,book_quantity) " +
                        "VALUES ('" + books.getBookId() + "','" + books.getBookName() + "','" + books.getBookAuthor() + "','" + books.getBookPublisher() + "','" + books.getBookQuantity() + "')";
                statement.execute(strInsertQuery);
                JOptionPane.showMessageDialog(null,"Book Added Successfully!");
                clearFields();
                //displayStudents();
            }
            catch (SQLException s){
                s.printStackTrace();
            }

        }
        else if(e.getActionCommand().equals("Cancel")){
            addABookGui.dispose();
        }
        else if(e.getActionCommand().equals("Back")){
            new LibraryHomeUI().setVisible(true);
            addABookGui.dispose();

        }
    }
    public void clearFields(){
        addABookGui.getTxtBookID().setText("");
        addABookGui.getTxtBookName().setText("");
        addABookGui.getTxtBookAuthor().setText("");
        addABookGui.getTxtBookPublisher().setText("");
        addABookGui.getTxtBookQuantity().setText("");

    }
}
