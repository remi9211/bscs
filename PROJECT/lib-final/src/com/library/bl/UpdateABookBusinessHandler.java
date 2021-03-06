package com.library.bl;

import com.library.entity.Books;
import com.library.entity.ReturnBooks;
import com.library.ui.ReturnBookUi;
import com.library.ui.UpdateABook;
import com.library.util.ConnectionDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateABookBusinessHandler implements ActionListener {
    Connection theConnectionDB;
    Statement statement;
    UpdateABook theGui;
    public UpdateABookBusinessHandler(UpdateABook updateABook){
        try {
            theGui = updateABook;
            theConnectionDB = ConnectionDB.getConnectionDB();
            statement = theConnectionDB.createStatement();
        }catch (SQLException s){
            s.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Update")){
            try{
                Books books = new Books();
                books.setBookId(theGui.getTxtBookID().getText().toString());
                String bookQuantity = (theGui.getTxtBookQuantity().getText().toString());
                int intBookQuantity = Integer.parseInt(bookQuantity);
                books.setBookQuantity(intBookQuantity);

                String strUpdateQuery = "UPDATE library.books SET book_quantity  = "+books.getBookQuantity()+" WHERE book_id = '"+books.getBookId()+"';";
                statement.execute(strUpdateQuery);
                JOptionPane.showMessageDialog(null,"Book Quantity has been updated");

            }catch (SQLException s){
                s.printStackTrace();
            }
        }
        else if(e.getActionCommand().equals("Cancel")){
            theGui.dispose();
        }
    }
}
