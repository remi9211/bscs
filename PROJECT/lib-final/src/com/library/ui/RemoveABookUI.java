package com.library.ui;

import com.library.bl.AddABookBusinessHandler;
import com.library.bl.RemoveABookBusinessHandler;

import javax.swing.*;
import java.awt.*;

public class RemoveABookUI extends JFrame {
    private JLabel lblCaption;
    private JLabel lblBookID;
    private JTextField txtBookID;

    private JButton btnRemove;
    private JButton btnCancel;
    private JButton btnBack;


    public RemoveABookUI() throws HeadlessException {
        init();
    }

    public void init(){
        lblCaption = new JLabel();
        lblCaption.setText("Remove A Book");
        lblCaption.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD, 22));
        lblCaption.setBounds(150,20,300,40);

        lblBookID = new JLabel();
        lblBookID.setText("Book ID: ");
        lblBookID.setBounds(30,80,120,30);
        txtBookID = new JTextField();
        txtBookID.setBounds(160,80,250,30);

        btnRemove = new JButton();
        btnRemove.setText("Remove");
        btnRemove.setBounds(130,150,100,40);
        btnRemove.setBackground(Color.darkGray);
        btnRemove.setForeground(Color.white);
        btnRemove.setOpaque(true);
        btnRemove.setBorderPainted(false);   //NEEDED ON MAC


        btnCancel = new JButton();
        btnCancel.setText("Cancel");
        btnCancel.setBounds(260,150,100,40);
        btnCancel.setBackground(Color.gray);
        btnCancel.setForeground(Color.white);
        btnCancel.setOpaque(true);
        btnCancel.setBorderPainted(false);   //NEEDED ON MAC

        btnBack = new JButton();
        btnBack.setText("Back");
        btnBack.setBounds(300,140,100,40);

        this.getContentPane().setLayout(null);
        this.getContentPane().add(lblCaption);
        this.getContentPane().add(lblBookID);
        this.getContentPane().add(txtBookID);
        this.getContentPane().add(btnRemove);
        this.getContentPane().add(btnCancel);
        this.setSize(500,270);
        this.show();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);



        RemoveABookBusinessHandler removeABookBusinessHandler = new RemoveABookBusinessHandler (this);
        btnRemove.addActionListener(removeABookBusinessHandler);
        btnCancel.addActionListener(removeABookBusinessHandler);
    }

    public static void main(String[] args) { RemoveABookUI removeABookUI = new RemoveABookUI();
    }

    public JTextField getTxtBookID() {
        return txtBookID;
    }
}
