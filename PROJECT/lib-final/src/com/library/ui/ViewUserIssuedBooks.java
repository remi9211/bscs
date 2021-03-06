package com.library.ui;
import com.library.entity.UserIssuedBooks;
import com.library.ui.UserIssuedBooksUI;
import com.library.util.ConnectionDB;
import java.lang.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class ViewUserIssuedBooks extends JFrame {
    ViewUserIssuedBooks theGui;

    private JPanel contentPane;
    private JTable table;

    public ViewUserIssuedBooks(UserIssuedBooks userIssuedBooks) throws SQLException {

        UserIssuedBooksUI userIssuedBooksUI = new UserIssuedBooksUI();
        String studentName = userIssuedBooks.getStudentName();
        Connection con= ConnectionDB.getConnectionDB();
        PreparedStatement ps=con.prepareStatement("select *  from issuebooks where StudentName =?");
        ps.setString(1,studentName);
        ResultSet rs=ps.executeQuery();
        // UserIssuedBooks userIssuedBooks = new UserIssuedBooks();

        String[] finalArray = new String[5];
        String[] storageArray = new String[5];
        //String testString = "";
        int rows = 0;
        int columns = 0;
        String data[][]= new String[10][6];

        while(rs.next()){
            String status;
            System.out.println(rs.getRow());
            String issueId = rs.getString("Issue_id");
            String bookName = rs.getString("BookName");
            String studentNamee = rs.getString("StudentName");
            String issueDate= rs.getString("issue_date");
            String return_date = rs.getString("return_date");
            if(return_date != null){
                status = "Completed";
            }
            else{
                status = "Pending";
            }
            String newIssueId = String.valueOf(issueId);
            String newBookName = String.valueOf(bookName);
            String newStudentNamee = String.valueOf(studentNamee);

            System.out.println(issueId+bookName+studentName+issueDate+return_date);

            data[rows][0]= newStudentNamee;
            data[rows][1]= newIssueId;
            data[rows][2]= newBookName;
            data[rows][3] =issueDate;
            data[rows][4] = return_date;
            data[rows][5] = status;

            rows++;
        }
        JFrame f;
        f=new JFrame();
        String column[]={"Student Name","Issue ID","Book Name", "Issue Date", "Return Date", "Status"};
        JTable jt=new JTable(data,column);
        jt.setBounds(30,40,400,600);
        JScrollPane sp=new JScrollPane(jt);
        f.add(sp);
        f.setSize(800,400);
        f.setVisible(true);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);


    }
}

