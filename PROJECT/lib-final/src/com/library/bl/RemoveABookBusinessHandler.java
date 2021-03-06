package com.library.bl;

import com.library.entity.Books;
import com.library.ui.AddABookUI;
import com.library.ui.LibraryHomeUI;
import com.library.ui.RemoveABookUI;
import com.library.util.ConnectionDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RemoveABookBusinessHandler implements ActionListener {

    Connection theConnectionDB;
    Statement statement;
    ResultSet resultSet;
    RemoveABookUI removeABookGui;

    public RemoveABookBusinessHandler(RemoveABookUI removeABookUI) {
        try {
            removeABookGui = removeABookUI;
            theConnectionDB = ConnectionDB.getConnectionDB();
            statement = theConnectionDB.createStatement();
        }
        catch (SQLException s) {
            s.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Remove")){
            String strBookID = removeABookGui.getTxtBookID().getText().toString();
            int option = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete the book with ID "+
                    strBookID+" ?","Delete Book",2 );
            if(option == 0){
                int status = deleteBooks(strBookID);
                if (status != 0){
                    JOptionPane.showMessageDialog(null,"Book Record Deleted Successfully!");
                    clearFields();
                }
                else {
                    JOptionPane.showMessageDialog(null,"Book Record Not Found!");
                }
           }
        }

        else if(e.getActionCommand().equals("Cancel")){
            removeABookGui.dispose();
        }

        else if(e.getActionCommand().equals("Back")){
            new LibraryHomeUI().setVisible(true);
            removeABookGui.dispose();

        }
    }
    public void clearFields() {
        removeABookGui.getTxtBookID().setText("");
    }

    public int deleteBooks(String bookId){
        try {
            String strRemoveQuery = "DELETE  FROM Books  WHERE book_id = '"+bookId+"'"; //If want to make ID to be deleted case sensitive add BINARY after WHERE
            int status = statement.executeUpdate(strRemoveQuery); //executeUpdate returns INT value ... https://stackoverflow.com/questions/29521554/how-to-get-true-or-false-using-execute-in-java-statement
            System.out.println(status + "WORK");
            return status;
        }
        catch (SQLException s){
            s.printStackTrace();
        }
        return 0;
    }
}
