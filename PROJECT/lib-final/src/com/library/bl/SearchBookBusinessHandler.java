package com.library.bl;

import com.library.entity.Books;
import com.library.ui.SearchBookUI;
import com.library.util.ConnectionDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SearchBookBusinessHandler implements ActionListener {

    Connection theConnectionDB;
    SearchBookUI theGui;
    Statement statement;
    ResultSet resultSet;

    public SearchBookBusinessHandler(SearchBookUI searchBookUI) {
        try {
            theGui = searchBookUI;
            theConnectionDB = ConnectionDB.getConnectionDB();
            statement = theConnectionDB.createStatement();

        } catch
        (SQLException sqlException) {
            sqlException
                    .printStackTrace();
        }
    }

    public SearchBookBusinessHandler() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Search" -> {
                String strBookId = theGui.getTxtbookID().getText().toString();
                // String strBookName = theGui.getTxtbookName().getText().toString();
                Books book = getBook(strBookId);
                // book = getBook2(strBookName);
                theGui.getTxtbookID().setText(book.getBookId());
                theGui.getTxtbookName().setText(book.getBookName());
                //clearFields();

            }

            case "Cancel" -> theGui.dispose();
            case "Back" -> JOptionPane.showMessageDialog(null, "Back Press");
        }

    }

    public void clearFields()
    {
        theGui.getTxtbookID().setText("");
        theGui.getTxtbookName().setText("");
    }

    public Books getBook(String strBookId) {
        Books book = null;
        try{
            String strSelectQuery = "SELECT * FROM books WHERE book_id = '" +strBookId+"'";
            ResultSet resultSet = statement.executeQuery(strSelectQuery);
            if(resultSet.next())
            {
                String bookID = resultSet.getString("book_id");
                String bookNAME = resultSet.getString("book_name");
                book = new Books(bookID, bookNAME);
            }
            return book;
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return  book;
    }
}
