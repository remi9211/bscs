package com.library.ui;

import com.library.bl.BookLogHandler;

import javax.swing.*;
import java.awt.*;

public class BookslLogUI extends JFrame {
    JLabel lblBookName;
    JLabel lblTitle;

    JTextField txtBookName;

    JButton btnConfirm;
    JButton btnCancel;

    public BookslLogUI() throws HeadlessException {
        init();
    }

    public void init(){

        lblTitle = new JLabel();
        lblTitle.setText("Details against Book Name");
        lblTitle.setFont(new Font("Times New Roman", Font.ITALIC, 22));
        lblTitle.setBounds(120,40,280,80);

        lblBookName = new JLabel();
        lblBookName.setText("Book Name :");
        lblBookName.setBounds(40,140,150,40);

        txtBookName = new JTextField();
        txtBookName.setBounds(180,144,250,30);

        btnConfirm = new JButton();
        btnConfirm.setText("Confirm");
        btnConfirm.setBounds(100,220,100,50);
        btnConfirm.setBackground(Color.darkGray);
        btnConfirm.setForeground(Color.white);
        btnConfirm.setOpaque(true);
        btnConfirm.setBorderPainted(false);   //NEEDED ON MAC

        btnCancel = new JButton();
        btnCancel.setText("Cancel");
        btnCancel.setBounds(240,220,100,50);
        btnCancel.setBackground(Color.gray);
        btnCancel.setForeground(Color.white);
        btnCancel.setOpaque(true);
        btnCancel.setBorderPainted(false);   //NEEDED ON MAC

        this.getContentPane().setLayout(null);
        this.getContentPane().add(lblTitle);
        this.getContentPane().add(lblBookName);
        this.getContentPane().add(txtBookName);
        this.getContentPane().add(btnConfirm);
        this.getContentPane().add(btnCancel);

        BookLogHandler bHandler = new BookLogHandler(this);
        btnConfirm.addActionListener(bHandler);
        btnCancel.addActionListener(bHandler);

        this.setSize(500,400);
        this.show();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

    }
    public static void main(String[] args){
        BookslLogUI bookslLogUI = new BookslLogUI();
    }

    public JLabel getLblBookName() {
        return lblBookName;
    }

    public void setLblBookName(JLabel lblBookName) {
        this.lblBookName = lblBookName;
    }

    public JLabel getLblTitle() {
        return lblTitle;
    }

    public void setLblTitle(JLabel lblTitle) {
        this.lblTitle = lblTitle;
    }

    public JTextField getTxtBookName() {
        return txtBookName;
    }

    public void setTxtBookName(JTextField txtBookName) {
        this.txtBookName = txtBookName;
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
}

