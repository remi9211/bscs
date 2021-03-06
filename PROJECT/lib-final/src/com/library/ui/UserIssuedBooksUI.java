package com.library.ui;
import com.library.bl.UserIssuedBooksBusinessHandler;

import javax.swing.*;
import java.awt.*;

public class UserIssuedBooksUI extends JFrame {

    JLabel lblStudentName;
    JLabel lblTitle;

    JTextField txtStudentName;

    JButton btnConfirm;
    JButton btnCancel;

    public UserIssuedBooksUI() throws HeadlessException {
        init();
    }

    public void init(){
        lblTitle = new JLabel();
        lblTitle.setText("Books Issued to Student");
        lblTitle.setFont(new Font("Times New Roman", Font.ITALIC + Font.BOLD, 22));
        lblTitle.setBounds(120,40,280,80);

        lblStudentName = new JLabel();
        lblStudentName.setText("Student Name :");
        lblStudentName.setBounds(40,140,150,40);

        txtStudentName = new JTextField();
        txtStudentName.setBounds(180,144,250,30);

        btnConfirm = new JButton();
        btnConfirm.setText("Confirm");
        btnConfirm.setBounds(120,220,100,50);
        btnConfirm.setBackground(Color.darkGray);
        btnConfirm.setForeground(Color.white);
        btnConfirm.setOpaque(true);
        btnConfirm.setBorderPainted(false);   //NEEDED ON MAC


        btnCancel = new JButton();
        btnCancel.setText("Cancel");
        btnCancel.setBounds(260,220,100,50);
        btnCancel.setBackground(Color.gray);
        btnCancel.setForeground(Color.white);
        btnCancel.setOpaque(true);
        btnCancel.setBorderPainted(false);   //NEEDED ON MAC

        this.getContentPane().setLayout(null);
        this.getContentPane().add(lblTitle);
        this.getContentPane().add(lblStudentName);
        this.getContentPane().add(txtStudentName);
        this.getContentPane().add(btnConfirm);
        this.getContentPane().add(btnCancel);

        UserIssuedBooksBusinessHandler bookBusinessHandler = new UserIssuedBooksBusinessHandler(this);
        btnConfirm.addActionListener(bookBusinessHandler);
        btnCancel.addActionListener(bookBusinessHandler);

        this.setSize(500,350);
        this.show();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);



    }

    public static void main(String[] args){
        UserIssuedBooksUI userIssuedBooksUI = new UserIssuedBooksUI();

    }
   /* public JLabel getLblStudentId() {
        return lblStudentName;
    }

    public void setLblStudentId(JLabel lblStudentId) {
        this.lblStudentName = lblStudentId;
    }

    public JLabel getLblTitle() {
        return lblTitle;
    }

    public void setLblTitle(JLabel lblTitle) {
        this.lblTitle = lblTitle;
    }

    public JTextField getTxtStudentName(){
        return getTxtStudentName();
    }

    public void setTxtStudentName(JTextField txtStudentName) {
        this.txtStudentName = txtStudentName;
    }



    public JButton getBtnConfirm() {
        return btnConfirm;
    }

    public void setBtnConfirm(JButton btnConfirm) {
        this.btnConfirm = btnConfirm;
    }

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public void setBtnCancel(JButton btnCancel) {
        this.btnCancel = btnCancel;
    }*/

    public JLabel getLblStudentName() {
        return lblStudentName;
    }

    public void setLblStudentName(JLabel lblStudentName) {
        this.lblStudentName = lblStudentName;
    }

    public JLabel getLblTitle() {
        return lblTitle;
    }

    public void setLblTitle(JLabel lblTitle) {
        this.lblTitle = lblTitle;
    }

    public JTextField getTxtStudentName() {
        return txtStudentName;
    }

    public void setTxtStudentName(JTextField txtStudentName) {
        this.txtStudentName = txtStudentName;
    }

    public JButton getBtnConfirm() {
        return btnConfirm;
    }

    public void setBtnConfirm(JButton btnConfirm) {
        this.btnConfirm = btnConfirm;
    }

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public void setBtnCancel(JButton btnCancel) {
        this.btnCancel = btnCancel;
    }

    @Override
    public String toString() {
        return "UserIssuedBooksUI{" +
                "txtStudentName=" + txtStudentName +
                '}';
    }
}

