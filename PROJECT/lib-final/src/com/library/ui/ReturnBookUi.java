package com.library.ui;

import com.library.bl.ReturnBooksBusinessHandler;
import com.library.util.ConnectionDB;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class ReturnBookUi extends JFrame {

    //public static DefaultListCellRenderer table;
    JLabel title;

    JLabel lblTotalPeriod;
    JLabel lblIssueId;
    JLabel lblBookName;
    JLabel bookName;
    JLabel issueID;

     public JTable table;

    JButton btnReturn;
    JButton btnCancel;

    JTextField txtTotalPeriod;
    JTextField txtIssueId;
    JTextField txtBookName;

    public ReturnBookUi() throws HeadlessException{

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);



        String data[][]=null;
        String column[]=null;
        try{
            Connection con= ConnectionDB.getConnectionDB();
            PreparedStatement ps=con.prepareStatement("select Issue_id,BookName from issuebooks", ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
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
        Font font1 = new Font("cursive", Font.BOLD, 12);
        Font font2 = new Font("Arial", Font.ITALIC, 14);
        Font font3 = new Font("Arial", Font.BOLD, 22);

        bookName= new JLabel();
        bookName.setText("Issue ID");
        bookName.setBounds(495,42,120,30);
        this.getContentPane().add(bookName);

        issueID=new JLabel();
        issueID.setText("Book Name");
        issueID.setBounds(660,42,120,30);
        this.getContentPane().add(issueID);

        title = new JLabel();
        title.setText("Return A Book");
        title.setBounds(180,20,300,40);
        title.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD, 22));

        lblBookName=  new JLabel();
        lblBookName.setText("Book Name : ");
        lblBookName.setBounds(30,90,120,30);

        txtBookName = new JTextField();
        txtBookName.setBounds(180,90,250,30);

        lblIssueId = new JLabel();
        lblIssueId.setText("Issue ID : ");
        lblIssueId.setBounds(30,150,120,30);

        txtIssueId = new JTextField();
        txtIssueId.setBounds(180,150,250,30);

        lblTotalPeriod = new JLabel();
        lblTotalPeriod.setText("Return Date : ");
        lblTotalPeriod.setBounds(30,210,120,30);

        txtTotalPeriod = new JTextField();
        txtTotalPeriod.setBounds(180,210,250,30);

        table.revalidate();

        btnReturn = new JButton();
        btnReturn.setText("Return");
        btnReturn.setBounds(150,270,100,40);
        btnReturn.setBackground(Color.darkGray);
        btnReturn.setForeground(Color.white);
        btnReturn.setOpaque(true);
        btnReturn.setBorderPainted(false);

        btnCancel = new JButton();
        btnCancel.setText("Cancel");
        btnCancel.setBounds(270,270,100,40);
        btnCancel.setBackground(Color.gray);
        btnCancel.setForeground(Color.white);
        btnCancel.setOpaque(true);
        btnCancel.setBorderPainted(false);

        this.getContentPane().setLayout(null);
        this.getContentPane().add(lblIssueId);
        this.getContentPane().add(txtIssueId);
        this.getContentPane().add(lblTotalPeriod);
        this.getContentPane().add(txtTotalPeriod);
        this.getContentPane().add(title);
        this.getContentPane().add(btnReturn);
        this.getContentPane().add(btnCancel);
        this.getContentPane().add(lblBookName);
        this.getContentPane().add(txtBookName);

        ReturnBooksBusinessHandler returnBooksBusinessHandler= new ReturnBooksBusinessHandler(this);
        btnReturn.addActionListener(returnBooksBusinessHandler);
        btnCancel.addActionListener(returnBooksBusinessHandler);

        JFrame.setDefaultLookAndFeelDecorated(true);
        this.setSize(800,500);
        this.show();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

    }

    public  static void main(String[] args){
        ReturnBookUi returnBookUi = new ReturnBookUi();

    }


    public void setTitle(JLabel title) {
        this.title = title;
    }

    public JLabel getLblTotalPeriod() {
        return lblTotalPeriod;
    }

    public void setLblTotalPeriod(JLabel lblTotalPeriod) {
        this.lblTotalPeriod = lblTotalPeriod;
    }

    public JLabel getLblIssueId() {
        return lblIssueId;
    }

    public void setLblIssueId(JLabel lblIssueId) {
        this.lblIssueId = lblIssueId;
    }

    public JButton getBtnReturn() {
        return btnReturn;
    }

    public void setBtnReturn(JButton btnReturn) {
        this.btnReturn = btnReturn;
    }

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public void setBtnCancel(JButton btnCancel) {
        this.btnCancel = btnCancel;
    }

    public JTextField getTxtTotalPeriod() {
        return txtTotalPeriod;
    }

    public void setTxtTotalPeriod(JTextField txtTotalPeriod) {
        this.txtTotalPeriod = txtTotalPeriod;
    }

    public JTextField getTxtIssueId() {
        return txtIssueId;
    }

    public void setTxtIssueId(JTextField txtIssueId) {
        this.txtIssueId = txtIssueId;
    }

    public JLabel getLblBookName() {
        return lblBookName;
    }

    public void setLblBookName(JLabel lblBookName) {
        this.lblBookName = lblBookName;
    }

    public JTextField getTxtBookName() {
        return txtBookName;
    }

    public void setTxtBookName(JTextField txtBookName) {
        this.txtBookName = txtBookName;
    }
}
