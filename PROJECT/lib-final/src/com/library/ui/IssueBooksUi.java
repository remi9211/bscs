package com.library.ui;

import com.library.bl.IssueBussinessHandler;
import com.library.util.ConnectionDB;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;


public class IssueBooksUi extends JFrame {
    JLabel title;
    //JLabel lblIssueId;
    JLabel lblStudentName;
    JLabel lblTotalPeriod;



    JLabel lblBookName;
    JLabel lblIssueDate;
    //JLabel lblReturnDate;
    JButton btnIssue;
    JLabel bookName;
    JLabel bookQuantity;

    JTextField txtReturnDate;


    private JTable table;

    public JLabel getLblStudentName() {
        return lblStudentName;
    }

    public void setLblStudentName(JLabel lblStudentName) {
        this.lblStudentName = lblStudentName;
    }



    JButton btnCancel;





    JTextField txtStudentName;
    //JTextField txtIssueId;
    //JTextField txtTotalPeriod;
    JTextField txtIssueDate;
    JTextField txtBookName;

    public IssueBooksUi() throws HeadlessException {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);



        String data[][]=null;
        String column[]=null;
        try{
            Connection con= ConnectionDB.getConnectionDB();
            PreparedStatement ps=con.prepareStatement("select book_name,book_quantity from books",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs=ps.executeQuery();

            ResultSetMetaData rsmd=rs.getMetaData();
            int cols=rsmd.getColumnCount();
            column=new String[cols];
            for(int i=1;i<=cols;i++){
                column[i-1]=rsmd.getColumnName(i);
            }

            rs.last();
            int rows=rs.getRow();
            rs.beforeFirst();

            data=new String[rows][cols];
            int count=0;
            while(rs.next()){
                for(int i=1;i<=cols;i++){
                    data[count][i-1]=rs.getString(i);
                }
                count++;
            }
            con.close();
        }catch(Exception e){System.out.println(e);}

        table = new JTable(data,column);
        JScrollPane sp=new JScrollPane(table);
        table.setBounds(470,70,300,350);

        this.getContentPane().add(table);


        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);


        init();
    }

    public void init(){
        bookName= new JLabel();
        bookName.setText("Books Availbale");
        bookName.setBounds(495,42,120,30);
        this.getContentPane().add(bookName);

        bookQuantity=new JLabel();
        bookQuantity.setText("Quantity");
        bookQuantity.setBounds(660,42,120,30);
        this.getContentPane().add(bookQuantity);

        title = new JLabel();
        title.setText("Issue A Book");
        title.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD, 23));
        title.setBounds(190,20,300,40);

       /* lblIssueId = new JLabel();
        lblIssueId.setText("Issue ID : ");
        lblIssueId.setBounds(30,90,120,30);*/

       // txtIssueId = new JTextField();
        //txtIssueId.setBounds(180,90,250,30);

        lblBookName = new JLabel();
        lblBookName.setText("Book Name : ");
        lblBookName.setBounds(30,90,120,30);

        txtBookName = new JTextField();
        txtBookName.setBounds(180,90,250,30);

        lblStudentName = new JLabel();
        lblStudentName.setText("Student Name : ");
        lblStudentName.setBounds(30,150,120,30);

        txtStudentName= new JTextField();
        txtStudentName.setBounds(180,150,250,30);

        lblIssueDate = new JLabel();
        lblIssueDate.setText("Issue Date : ");
        lblIssueDate.setBounds(30,210,120,30);

        txtIssueDate = new JTextField();
        txtIssueDate.setBounds(180,210,250,30);



        btnIssue = new JButton();
        btnIssue.setText("Issue");
        btnIssue.setBounds(140,330,100,40);
        btnIssue.setBackground(Color.darkGray);
        btnIssue.setForeground(Color.white);
        btnIssue.setOpaque(true);
        btnIssue.setBorderPainted(false);   //NEEDED ON MAC

        btnCancel = new JButton();
        btnCancel.setText("Cancel");
        btnCancel.setBounds(270,330,100,40);
        btnCancel.setBackground(Color.gray);
        btnCancel.setForeground(Color.white);
        btnCancel.setOpaque(true);
        btnCancel.setBorderPainted(false);   //NEEDED ON MAC

        this.getContentPane().setLayout(null);
       // this.getContentPane().add(txtIssueId);
       // this.getContentPane().add(lblIssueId);
        this.getContentPane().add(lblIssueDate);
        this.getContentPane().add(txtIssueDate);
        this.getContentPane().add(lblBookName);
        this.getContentPane().add(txtBookName);
        this.getContentPane().add(lblStudentName);
        this.getContentPane().add(txtStudentName);
        this.getContentPane().add(title);
        this.getContentPane().add(btnIssue);
        this.getContentPane().add(btnCancel);


        IssueBussinessHandler issueBussinessHandler = new IssueBussinessHandler(this);
        btnIssue.addActionListener(issueBussinessHandler);
        btnCancel.addActionListener(issueBussinessHandler);

        JFrame.setDefaultLookAndFeelDecorated(true);
        this.setSize(800,500);
        this.show();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }

    /*public JLabel getLblBookId() {
        return lblBookId;
    }

    public void setLblBookId(JLabel lblBookId) {
        this.lblBookId = lblBookId;
    }*/

    public JButton getBtnIssue() {
        return btnIssue;
    }

    public void setBtnIssue(JButton btnIssue) {
        this.btnIssue = btnIssue;
    }

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public void setBtnCancel(JButton btnCancel) {
        this.btnCancel = btnCancel;
    }

    /*public JTextField getTxtBookId() {
        return txtBookId;
    }

    public void setTxtBookId(JTextField txtBookId) {
        this.txtBookId = txtBookId;
    }*/

    public  static void main(String[] args){
        IssueBooksUi issueBooksUi = new IssueBooksUi();

    }
/*
    public JLabel getLblStudentId() {
        return lblStudentId;
    }

    public void setLblStudentId(JLabel lblStudentId) {
        this.lblStudentId = lblStudentId;
    }

 */

    public JLabel getLblIssueDate() {
        return lblIssueDate;
    }

    public void setLblIssueDate(JLabel lblIssueDate) {
        this.lblIssueDate = lblIssueDate;
    }

   /* public JTextField getTxtStudentId() {
        return txtStudentId;
    }

    public void setTxtStudentId(JTextField txtStudentId) {
        this.txtStudentId = txtStudentId;
    }*/

    public JTextField getTxtIssueDate() {
        return txtIssueDate;
    }

    public void setTxtIssueDate(JTextField txtIssueDate) {
        this.txtIssueDate = txtIssueDate;
    }

    public void setTitle(JLabel title) {
        this.title = title;
    }




    public JTextField getTxtReturnDate() {
        return txtReturnDate;
    }

    public void setTxtReturnDate(JTextField txtReturnDate) {
        this.txtReturnDate = txtReturnDate;
    }

    public JLabel getLblTotalPeriod() {
        return lblTotalPeriod;
    }

    public void setLblTotalPeriod(JLabel lblTotalPeriod) {
        this.lblTotalPeriod = lblTotalPeriod;
    }

    public JLabel getLblBookName() {
        return lblBookName;
    }

    public void setLblBookName(JLabel lblBookName) {
        this.lblBookName = lblBookName;
    }

    public JTextField getTxtStudentName() {
        return txtStudentName;
    }

    public void setTxtStudentName(JTextField txtStudentName) {
        this.txtStudentName = txtStudentName;
    }


    public JTextField getTxtBookName() {
        return txtBookName;
    }

    public void setTxtBookName(JTextField txtBookName) {
        this.txtBookName = txtBookName;
    }
/*
    public JLabel getLblIssueId() {
        return lblIssueId;
    }

    public void setLblIssueId(JLabel lblIssueId) {
        this.lblIssueId = lblIssueId;
    }

 */

   // public JTextField getTxtIssueId() {
   //     return txtIssueId;
   // }


}






