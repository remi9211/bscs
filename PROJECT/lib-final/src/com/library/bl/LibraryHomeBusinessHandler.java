package com.library.bl;
import com.library.entity.Books;
import com.library.ui.*;
import com.library.util.ConnectionDB;

import javax.naming.directory.SearchResult;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LibraryHomeBusinessHandler implements ActionListener {

    LibraryHomeUI libraryHomeGui;

    public LibraryHomeBusinessHandler(LibraryHomeUI libraryHomeUI) {
            libraryHomeGui = libraryHomeUI;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add A Book")) {
            new AddABookUI().setVisible(true);
        }
        else if (e.getActionCommand().equals("Remove A Book")) {
            new RemoveABookUI().setVisible(true);
        }
        else if (e.getActionCommand().equals("View All Books")) {
            new ViewAllBooks().setVisible(true);
        }
        else if (e.getActionCommand().equals("Issue A Book")) {
            new IssueBooksUi().setVisible(true);
        }
        else if (e.getActionCommand().equals("Return A Book")) {
            new ReturnBookUi().setVisible(true);
        }
        else if (e.getActionCommand().equals("View All Issued Books")) {
            new ViewIssuedBooks().setVisible(true);
        }
        else if (e.getActionCommand().equals("View All Returned Books")) {
            new ViewReturnBooks().setVisible(true);
        }
        else if (e.getActionCommand().equals("Student Logs")) {
            new UserIssuedBooksUI().setVisible(true);
        }
        else if (e.getActionCommand().equals("Search A Book")) {
            new SearchBookUI().setVisible(true);
        }
        else if (e.getActionCommand().equals("Book Logs")) {
            new BookslLogUI().setVisible(true);
        }
        else if (e.getActionCommand().equals("Update A Book")) {
            new UpdateABook().setVisible(true);
        }

    }
}