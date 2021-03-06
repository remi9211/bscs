package com.library.bl;


import com.library.entity.BookLog;
import com.library.ui.BooksIssuedTable;
import com.library.ui.BookslLogUI;
import com.library.util.ConnectionDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class BookLogHandler implements ActionListener {
    private JPanel contentPane;
    private JTable table;

    Connection theConnectionDB;
    Statement statement;
    ResultSet resultSet;
    BookslLogUI theGui;
    BookLog bookLog;
    BooksIssuedTable booksIssuedTable;

    public BookLogHandler(BookslLogUI bookslLogUI){
        theGui = bookslLogUI;
        theConnectionDB = ConnectionDB.getConnectionDB();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Confirm")) {
            try {
                BookLog bookLog = new BookLog();
                bookLog.setBookName(theGui.getTxtBookName().getText().toString());
                booksIssuedTable = new BooksIssuedTable(bookLog);
            }
            catch (Exception s){
                s.printStackTrace();
            }
        }

        else if(e.getActionCommand().equals("Cancel")){
           theGui.dispose();
        }

    }
}
