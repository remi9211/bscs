package com.library.ui;

import com.library.bl.SearchBookBusinessHandler;

import javax.swing.*;
import java.awt.*;

public class SearchBookUI extends JFrame {

    private JLabel lblbookID;
    private JLabel lblbookName;
    private JLabel lblCaption;

    private JTextField txtbookID;
    private JTextField txtbookName;

    private JButton btnSave;
    private JButton btnCancel;

    public SearchBookUI() throws HeadlessException
    {
        init();
    }

    public void init() {

        lblCaption = new JLabel();
        lblCaption.setText("Search Book");
        lblCaption.setBounds(190, 10, 300, 40);
        lblCaption.setForeground(Color.BLACK);
        lblCaption.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD, 23));

        lblbookID = new JLabel();
        lblbookID.setText("Book ID: ");
        lblbookID.setBounds(30, 60, 100, 30);

        txtbookID = new JTextField();
        txtbookID.setBounds(160, 60, 250, 30);

        lblbookName = new JLabel();
        lblbookName.setText("Book Name: ");
        lblbookName.setBounds(30, 110, 100, 30);

        txtbookName = new JTextField();
        txtbookName.setBounds(160, 110, 250, 30);

        btnSave = new JButton();
        btnSave.setText("Search");
        btnSave.setBounds(150, 170, 100, 40);
        btnSave.setBackground(Color.darkGray);
        btnSave.setForeground(Color.white);
        btnSave.setOpaque(true);
        btnSave.setBorderPainted(false);

        btnCancel = new JButton();
        btnCancel.setText("Cancel");
        btnCancel.setBounds(260, 170, 100, 40);
        btnCancel.setBackground(Color.gray);
        btnCancel.setForeground(Color.white);
        btnCancel.setOpaque(true);
        btnCancel.setBorderPainted(false);

        this.getContentPane().setLayout(null);
        this.getContentPane().add(lblCaption);
        this.getContentPane().add(lblbookID);
        this.getContentPane().add(txtbookID);
        this.getContentPane().add(lblbookName);
        this.getContentPane().add(txtbookName);
        this.getContentPane().add(btnSave);
        this.getContentPane().add(btnCancel);

        SearchBookBusinessHandler searchBookBusinessHandler = new SearchBookBusinessHandler(this);
        btnSave.addActionListener(searchBookBusinessHandler);
        btnCancel.addActionListener(searchBookBusinessHandler);

        this.setSize(500, 270);
        this.show();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

    }
    public static void main (String[] args)
    {
        SearchBookUI searchBookUI = new SearchBookUI();

    }

    public JTextField getTxtbookID() {
        return txtbookID;
    }

    public JTextField getTxtbookName() {
        return txtbookName;
    }


}


