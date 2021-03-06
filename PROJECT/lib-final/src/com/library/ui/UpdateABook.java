package com.library.ui;

import com.library.bl.AddABookBusinessHandler;
import com.library.bl.UpdateABookBusinessHandler;

import javax.swing.*;
import java.awt.*;

public class UpdateABook extends JFrame{
    private JLabel lblCaption;
    private JLabel lblBookID;
    private JLabel lblBookQuantity;
    private JTextField txtBookID;
    private JTextField txtBookQuantity;
    private JButton btnUpdate;
    private JButton btnCancel;

    public UpdateABook() throws HeadlessException {
        init();
    }

    public void init(){
        lblCaption = new JLabel();
        lblCaption.setText("Update A Book");
        lblCaption.setFont(new Font("Times New Roman", Font.ITALIC+Font.BOLD, 23));
        lblCaption.setBounds(220,20,300,40);

        lblBookID = new JLabel();
        lblBookID.setText("Book ID: ");
        lblBookID.setBounds(30,80,120,30);
        txtBookID = new JTextField();
        txtBookID.setBounds(180,80,250,30);

        lblBookQuantity = new JLabel();
        lblBookQuantity.setText("Book Quantity: ");
        lblBookQuantity.setBounds(30,130,120,30);
        txtBookQuantity = new JTextField();
        txtBookQuantity.setBounds(180,130,250,30);

        btnUpdate = new JButton();
        btnUpdate.setText("Update");
        btnUpdate.setBounds(170,200,100,40);
        btnUpdate.setBackground(Color.darkGray);
        btnUpdate.setForeground(Color.white);
        btnUpdate.setOpaque(true);
        btnUpdate.setBorderPainted(false);   //NEEDED ON MAC

        btnCancel = new JButton();
        btnCancel.setText("Cancel");
        btnCancel.setBounds(300,200,100,40);
        btnCancel.setBackground(Color.gray);
        btnCancel.setForeground(Color.white);
        btnCancel.setOpaque(true);
        btnCancel.setBorderPainted(false);   //NEEDED ON MAC

        this.getContentPane().setLayout(null);
        this.getContentPane().add(btnCancel);
        this.getContentPane().add(btnUpdate);
        this.getContentPane().add(lblBookQuantity);
        this.getContentPane().add(lblBookID);
        this.getContentPane().add(lblCaption);
        this.getContentPane().add(txtBookQuantity);
        this.getContentPane().add(txtBookID);

        this.setSize(550,300);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        this.show();

        UpdateABookBusinessHandler updateABookBusinessHandler = new UpdateABookBusinessHandler (this);
        btnUpdate.addActionListener(updateABookBusinessHandler);
        btnCancel.addActionListener(updateABookBusinessHandler);
    }

    public static void main(String[] args) {
        UpdateABook updateABook = new UpdateABook();
    }

    public JTextField getTxtBookID() {
        return txtBookID;
    }

    public void setTxtBookID(JTextField txtBookID) {
        this.txtBookID = txtBookID;
    }

    public JTextField getTxtBookQuantity() {
        return txtBookQuantity;
    }

    public void setTxtBookQuantity(JTextField txtBookQuantity) {
        this.txtBookQuantity = txtBookQuantity;
    }
}
