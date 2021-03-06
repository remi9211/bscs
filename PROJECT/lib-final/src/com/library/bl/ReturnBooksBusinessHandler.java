package com.library.bl;

import com.library.entity.ReturnBooks;
import com.library.ui.ReturnBookUi;
import com.library.util.ConnectionDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ReturnBooksBusinessHandler implements ActionListener {
    Connection theConnectionDB;
    Statement statement;
    ReturnBookUi theGui;
    public ReturnBooksBusinessHandler(ReturnBookUi returnBookUi){
        try {
            theGui = returnBookUi;
            theConnectionDB = ConnectionDB.getConnectionDB();
            statement = theConnectionDB.createStatement();
        }catch (SQLException s){
            s.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Return")){
            try{
                JOptionPane.showMessageDialog(null,"Book has been returned");
                ReturnBooks returnBooks= new ReturnBooks();

                returnBooks.setBookName(theGui.getTxtBookName().getText().toString());
                returnBooks.setIssuedTill(theGui.getTxtTotalPeriod().getText().toString());
                returnBooks.setIssueId(theGui.getTxtIssueId().getText().toString());
                theGui.table.revalidate();
                System.out.println(returnBooks);

                String strUpdateQuery = "UPDATE library.issuebooks SET return_date  = '"+returnBooks.getIssuedTill()+"' WHERE Issue_id = '"+returnBooks.getIssueId()+"';";
                String strUpdateQuery2 = "UPDATE library.books SET book_quantity  = book_quantity+1 WHERE book_name = '"+returnBooks.getBookName()+"';";
               // String strUpdateQuery3= "DELETE FROM library.issuebooks WHERE Issue_id ='"+returnBooks.getIssueId()+"';";

                statement.execute(strUpdateQuery2);
                statement.execute(strUpdateQuery);
                //statement.execute(strUpdateQuery3);
                clearFields();


            }catch (SQLException s){
                s.printStackTrace();
            }
        }
        else if(e.getActionCommand().equals("Cancel")){
            theGui.dispose();
        }
    }
    private void clearFields() {
        theGui.getTxtBookName().setText("");
        theGui.getTxtIssueId().setText("");
        theGui.getTxtTotalPeriod().setText("");
    }
}
