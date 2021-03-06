package com.library.ui;


import com.library.entity.BookLog;
import com.library.util.ConnectionDB;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BooksIssuedTable {
    BookslLogUI thGui;

    private JPanel contentPane;
    private JTable table;

    public BooksIssuedTable(BookLog bookLog) throws Exception {

        BookslLogUI bookslLogUI = new BookslLogUI();

        String bookName = ( BookLog.getBookName() );
        Connection con = ConnectionDB.getConnectionDB();
        PreparedStatement ps = con.prepareStatement("select issuebooks.Issue_id,issuebooks.BookName,issuebooks.issue_date,issuebooks.return_date,student.StudentName,student.Student_dept,student.Student_school from issuebooks INNER JOIN student ON issuebooks.StudentName = student.StudentName AND BookName = ?");
        ps.setString(1, bookName);
        ResultSet rs = ps.executeQuery();
        String[] finalArray = new String[8];
        String[] storageArray = new String[8];

        int rows = 0;
        int columns = 0;

        String data[][] = new String[10][8];

        while (rs.next()) {
            String status;
            System.out.println(rs.getRow());
          //  String studentId1 = rs.getString("Student_id");
            String issueId = rs.getString("Issue_Id");
            String bName = rs.getString("BookName");
            String naam = rs.getString("StudentName");
            String stddpt = rs.getString("Student_dept");
            String school = rs.getString("Student_school");
            String issueDate = rs.getString("issue_date");
            String return_date = rs.getString("return_date");
            if(return_date != null){
                status = "Completed";
            }
            else{
                status = "Pending";
            }

            String newIssueId = String.valueOf(issueId);
            String newBookName = String.valueOf(bName);
          //  String newStudentId = String.valueOf(studentId1);

          //  data[rows][0] = newStudentId;
            data[rows][0] = newIssueId;
            data[rows][1] = newBookName;
            data[rows][2] = naam;
            data[rows][3] = stddpt;
            data[rows][4] = school;
            data[rows][5] = issueDate;
            data[rows][6] = return_date;
            data[rows][7] = status;

            rows++;
        }
        JFrame f;
        f = new JFrame();
        String column[] = {"Issue ID", "Book Name", "Student Name", "Student Dept.", "Student School", "Issue Date", "Return Date", "Status"};
        JTable jt = new JTable(data, column);
        jt.setBounds(30, 40, 1200, 600);
        JScrollPane sp = new JScrollPane(jt);
        f.add(sp);
        f.setSize(850, 400);
        f.setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);


    }

























}
