package com.library.ui;

import com.library.bl.AddABookBusinessHandler;
import com.library.bl.LibraryHomeBusinessHandler;

import javax.swing.*;
import java.awt.*;

public class AddABookUI extends JFrame {
    private JLabel lblCaption;
    private JLabel lblBookID;
    private JLabel lblBookName;
    private JLabel lblBookAuthor;
    private JLabel lblBookPublisher;
    private JLabel lblBookQuantity;
    
    private JTextField txtBookID;
    private JTextField txtBookName;
    private JTextField txtBookAuthor;
    private JTextField txtBookPublisher;
    private JTextField txtBookQuantity;

    private JButton btnSave;
    private JButton btnCancel;
    private JButton btnBack;


    public AddABookUI() throws HeadlessException {
        init();
    }

    public void init(){
        lblCaption = new JLabel();
        lblCaption.setText("Add A Book");
        lblCaption.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD, 23));
        lblCaption.setBounds(220,20,300,40);

        lblBookID = new JLabel();
        lblBookID.setText("Book ID: ");
        lblBookID.setBounds(30,80,120,30);
        txtBookID = new JTextField();
        txtBookID.setBounds(180,80,250,30);

        lblBookName = new JLabel();
        lblBookName.setText("Book Name: ");
        lblBookName.setBounds(30,120,120,30);
        txtBookName = new JTextField();
        txtBookName.setBounds(180,120,250,30);

        lblBookAuthor = new JLabel();
        lblBookAuthor.setText("Author Name: ");
        lblBookAuthor.setBounds(30,160,120,30);
        txtBookAuthor = new JTextField();
        txtBookAuthor.setBounds(180,160,250,30);

        lblBookPublisher = new JLabel();
        lblBookPublisher.setText("Book Publisher: ");
        lblBookPublisher.setBounds(30,200,120,30);
        txtBookPublisher = new JTextField();
        txtBookPublisher.setBounds(180,200,250,30);

        lblBookQuantity = new JLabel();
        lblBookQuantity.setText("Book Quantity: ");
        lblBookQuantity.setBounds(30,240,120,30);
        txtBookQuantity = new JTextField();
        txtBookQuantity.setBounds(180,240,250,30);

        btnSave = new JButton();
        btnSave.setText("Save");
        btnSave.setBounds(170,300,100,40);
        btnSave.setBackground(Color.darkGray);
        btnSave.setForeground(Color.white);
        btnSave.setOpaque(true);
        btnSave.setBorderPainted(false);   //NEEDED ON MAC


        btnCancel = new JButton();
        btnCancel.setText("Cancel");
        btnCancel.setBounds(300,300,100,40);
        btnCancel.setBackground(Color.gray);
        btnCancel.setForeground(Color.white);
        btnCancel.setOpaque(true);
        btnCancel.setBorderPainted(false);   //NEEDED ON MAC


        btnBack = new JButton();
        btnBack.setText("Back");
        btnBack.setBounds(300,300,100,40);
        // btnCancel.setBackground(Color.BLUE);
        // btnCancel.setOpaque(true);   //NEEDED ON MAC
        // btnCancel.setBorderPainted(false);   //NEEDED ON MAC
        // btnCancel.setForeground(Color.WHITE);

        this.getContentPane().setLayout(null);
        this.getContentPane().add(lblCaption);
        this.getContentPane().add(lblBookID);
        this.getContentPane().add(txtBookID);
        this.getContentPane().add(lblBookName);
        this.getContentPane().add(txtBookName);
        this.getContentPane().add(lblBookAuthor);
        this.getContentPane().add(txtBookAuthor);
        this.getContentPane().add(lblBookPublisher);
        this.getContentPane().add(txtBookPublisher);
        this.getContentPane().add(lblBookQuantity);
        this.getContentPane().add(txtBookQuantity);
        this.getContentPane().add(btnSave);
        this.getContentPane().add(btnCancel);
        //this.getContentPane().add(btnBack);

        this.setSize(550,400);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        this.show();

        AddABookBusinessHandler addABookBusinessHandler = new AddABookBusinessHandler (this);
        btnSave.addActionListener(addABookBusinessHandler);
        btnCancel.addActionListener(addABookBusinessHandler);

    }


    public static void main(String[] args) {
        AddABookUI addABookUIUI = new AddABookUI();
    }

    public JTextField getTxtBookID() {
        return txtBookID;
    }

    public void setTxtBookID(JTextField txtBookID) {
        this.txtBookID = txtBookID;
    }

    public JTextField getTxtBookName() {
        return txtBookName;
    }

    public void setTxtBookName(JTextField txtBookName) {
        this.txtBookName = txtBookName;
    }

    public JTextField getTxtBookAuthor() {
        return txtBookAuthor;
    }

    public void setTxtBookAuthor(JTextField txtBookAuthor) {
        this.txtBookAuthor = txtBookAuthor;
    }

    public JTextField getTxtBookPublisher() {
        return txtBookPublisher;
    }

    public void setTxtBookPublisher(JTextField txtBookPublisher) {
        this.txtBookPublisher = txtBookPublisher;
    }

    public JTextField getTxtBookQuantity() {
        return txtBookQuantity;
    }

    public void setTxtBookQuantity(JTextField txtBookQuantity) {
        this.txtBookQuantity = txtBookQuantity;
    }
}
