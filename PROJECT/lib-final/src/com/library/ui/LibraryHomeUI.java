package com.library.ui;


import com.library.bl.LibraryHomeBusinessHandler;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class LibraryHomeUI extends JFrame {
    private JLabel lblCaption;
    private JButton btnAddBook;
    private JButton btnRemoveBook;
    private JButton btnViewBook;
    private JButton btnSearchBook;
    private JButton btnUpdateBook;
    private JButton btnIssueBook;
    private JButton btnReturnBook;
    private JButton btnViewIssuedBook;
    private JButton btnViewReturnBook;
    private JButton btnViewSingleStudentBook;
    private JButton btnBookLogs;
    private JLabel imagelabel;



    public LibraryHomeUI() throws HeadlessException {
        init();
    }

    public void init() {

        JLabel background; // source for background - https://www.youtube.com/watch?v=TQEEsR559QQ
        setLayout(null);
        ImageIcon img = new ImageIcon("src/com/library/ui/bg.jpg");
        background = new JLabel("",img,JLabel.CENTER);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        pack();
        setSize(screenSize.width, screenSize.height); //to set home window to full screen

        background.setBounds(0,0,screenSize.width, screenSize.height); //line 35 - https://gist.github.com/sadeedameen/4d417ab6f0cda6e4ed7975c1bb772678

        add(background);
        setVisible(true);

        lblCaption = new JLabel();
        lblCaption.setText("Library Management System");
        lblCaption.setFont(new Font("Times New Roman", Font.BOLD + Font.ITALIC, 28));
        lblCaption.setBounds(60, 10, 400, 40);

        btnAddBook = new JButton();
        btnAddBook.setText("Add A Book");
        btnAddBook.setBounds(100, 80, 200, 40);
        btnAddBook.setBackground(Color.white);
        btnAddBook.setOpaque(true);
        btnAddBook.setBorderPainted(false);   //NEEDED ON MAC

        btnRemoveBook = new JButton();
        btnRemoveBook.setText("Remove A Book");
        btnRemoveBook.setBounds(100, 140, 200, 40);
        btnRemoveBook.setBackground(Color.white);
        btnRemoveBook.setOpaque(true);
        btnRemoveBook.setBorderPainted(false);   //NEEDED ON MAC

        btnViewBook = new JButton();
        btnViewBook.setText("View All Books");
        btnViewBook.setBounds(100, 200, 200, 40);
        btnViewBook.setBackground(Color.white);
        btnViewBook.setOpaque(true);
        btnViewBook.setBorderPainted(false);   //NEEDED ON MAC

        btnSearchBook = new JButton();
        btnSearchBook.setText("Search A Book");
        btnSearchBook.setBounds(100, 260, 200, 40);
        btnSearchBook.setBackground(Color.white);
        btnSearchBook.setOpaque(true);
        btnSearchBook.setBorderPainted(false);   //NEEDED ON MAC

        btnUpdateBook = new JButton();
        btnUpdateBook.setText("Update A Book");
        btnUpdateBook.setBounds(100, 320, 200, 40);
        btnUpdateBook.setBackground(Color.white);
        btnUpdateBook.setOpaque(true);
        btnUpdateBook.setBorderPainted(false);   //NEEDED ON MAC

        btnIssueBook = new JButton();
        btnIssueBook.setText("Issue A Book");
        btnIssueBook.setBounds(100, 380, 200, 40);
        btnIssueBook.setBackground(Color.white);
        btnIssueBook.setOpaque(true);
        btnIssueBook.setBorderPainted(false);   //NEEDED ON MAC

        btnReturnBook = new JButton();
        btnReturnBook.setText("Return A Book");
        btnReturnBook.setBounds(100, 440, 200, 40);
        btnReturnBook.setBackground(Color.white);
        btnReturnBook.setOpaque(true);
        btnReturnBook.setBorderPainted(false);   //NEEDED ON MAC

        btnViewIssuedBook = new JButton();
        btnViewIssuedBook.setText("View All Issued Books");
        btnViewIssuedBook.setBounds(100, 500, 200, 40);
        btnViewIssuedBook.setBackground(Color.white);
        btnViewIssuedBook.setOpaque(true);
        btnViewIssuedBook.setBorderPainted(false);   //NEEDED ON MAC

        btnViewReturnBook = new JButton();
        btnViewReturnBook.setText("View All Returned Books");
        btnViewReturnBook.setBounds(100, 560, 200, 40);
        btnViewReturnBook.setBackground(Color.white);
        btnViewReturnBook.setOpaque(true);
        btnViewReturnBook.setBorderPainted(false);   //NEEDED ON MAC

        btnViewSingleStudentBook = new JButton();
        btnViewSingleStudentBook.setText("Student Logs");
        btnViewSingleStudentBook.setBounds(100, 620, 200, 40);
        btnViewSingleStudentBook.setBackground(Color.white);
        btnViewSingleStudentBook.setOpaque(true);
        btnViewSingleStudentBook.setBorderPainted(false);   //NEEDED ON MAC

        btnBookLogs = new JButton();
        btnBookLogs.setText("Book Logs");
        btnBookLogs.setBounds(100, 680, 200, 40);
        btnBookLogs.setBackground(Color.white);
        btnBookLogs.setOpaque(true);
        btnBookLogs.setBorderPainted(false);   //NEEDED ON MAC

        background.add(lblCaption);
        background.add(btnAddBook);
        background.add(btnRemoveBook);
        background.add(btnViewBook);
        background.add(btnSearchBook);
        background.add(btnUpdateBook);
        background.add(btnIssueBook);
        background.add(btnReturnBook);
        background.add(btnViewIssuedBook);
        background.add(btnViewSingleStudentBook);
        background.add(btnBookLogs);
        background.add(btnViewReturnBook);

        this.show();

        LibraryHomeBusinessHandler libraryHomeBusinessHandler = new LibraryHomeBusinessHandler(this);
        btnAddBook.addActionListener(libraryHomeBusinessHandler);
        btnRemoveBook.addActionListener(libraryHomeBusinessHandler);
        btnViewBook.addActionListener(libraryHomeBusinessHandler);
        btnIssueBook.addActionListener(libraryHomeBusinessHandler);
        btnReturnBook.addActionListener(libraryHomeBusinessHandler);
        btnViewIssuedBook.addActionListener(libraryHomeBusinessHandler);
        btnViewSingleStudentBook.addActionListener(libraryHomeBusinessHandler);
        btnSearchBook.addActionListener(libraryHomeBusinessHandler);
        btnBookLogs.addActionListener(libraryHomeBusinessHandler);
        btnUpdateBook.addActionListener(libraryHomeBusinessHandler);
        btnViewReturnBook.addActionListener(libraryHomeBusinessHandler);

    }

    public static void main(String[] args) {
        LibraryHomeUI libraryHomeUI = new LibraryHomeUI();
    }

    public JLabel getLblCaption() {
        return lblCaption;
    }

    public JButton getBtnAddBook() {
        return btnAddBook;
    }

    public JButton getBtnRemoveBook() {
        return btnRemoveBook;
    }

    public JButton getBtnViewBook() {
        return btnViewBook;
    }

    public JButton getBtnSearchBook() {
        return btnSearchBook;
    }

    public JButton getBtnUpdateBook() {
        return btnUpdateBook;
    }

    public JButton getBtnIssueBook() {
        return btnIssueBook;
    }

    public JButton getBtnReturnBook() {
        return btnReturnBook;
    }

    public JButton getBtnViewIssuedBook() {
        return btnViewIssuedBook;
    }

    public JButton getBtnViewSingleStudentBook() {
        return btnViewSingleStudentBook;
    }

    public void setBtnViewIssuedBook(JButton btnViewIssuedBook) {
        this.btnViewIssuedBook = btnViewIssuedBook;
    }

    public JButton getBtnViewReturnBook() {
        return btnViewReturnBook;
    }

    public void setBtnViewReturnBook(JButton btnViewReturnBook) {
        this.btnViewReturnBook = btnViewReturnBook;
    }
}




