package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCustomer extends JFrame implements ActionListener {
    JTextField tfname, tfnationality, tfaadhar, tfaddress, tfphone;
    JRadioButton rbmale, rbfemale;

    AddCustomer(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
        heading.setBounds(220, 20, 500, 35);
        heading.setFont(new Font("Times New Roman", Font.PLAIN, 32));
        heading.setForeground(Color.BLUE);
        add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 100   , 150, 25);
        lblname.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(220, 100, 200, 25);
        add(tfname);

        JLabel nationality = new JLabel("Nationality");
        nationality.setBounds(60, 150 , 150, 25);
        nationality.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        add(nationality);

        tfnationality = new JTextField();
        tfnationality.setBounds(220, 150, 200, 25);
        add(tfnationality);

        JLabel aadhar = new JLabel("Aadhaar");
        aadhar.setBounds(60, 200 , 150, 25);
        aadhar.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        add(aadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(220, 200, 200, 25);
        add(tfaadhar);

        JLabel address = new JLabel("Address");
        address.setBounds(60, 250 , 150, 25);
        address.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        add(address);

        tfaddress = new JTextField();
        tfaddress.setBounds(220, 250, 200, 25);
        add(tfaddress);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(60, 300 , 150, 25);
        gender.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        add(gender);

        ButtonGroup gendergroup = new ButtonGroup();

        rbmale = new JRadioButton("Male");
        rbmale.setBounds(220,300, 90, 25);
        rbmale.setBackground(Color.WHITE);
        add(rbmale);

        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(340,300, 90, 25);
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);

        gendergroup.add(rbmale);
        gendergroup.add(rbfemale);

        JLabel phone = new JLabel("phone");
        phone.setBounds(60, 350 , 150, 25);
        phone.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        add(phone);

        tfphone = new JTextField();
        tfphone.setBounds(220, 350, 200, 25);
        add(tfphone);

        JButton save = new JButton("SAVE");
        save.setBackground(Color.BLACK);
        save.setBounds(250, 420, 150, 30);
        save.setForeground(Color.WHITE);
        save.addActionListener(this);
        add(save);

        ImageIcon image = new ImageIcon(getClass().getResource("/asset/front.jpg"));
        JLabel lblimg = new JLabel(image);
        lblimg.setBounds(500, 80, 280, 400);
        add(lblimg);

        setSize(900, 600);
        setLocation(300, 150);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String name = tfname.getText();
        String nationality = tfnationality.getText();
        String phone = tfphone.getText();
        String aadhaar = tfaadhar.getText();
        String address = tfaddress.getText();
        String gender = null;
        if (rbmale.isSelected()){
            gender = "Male";
        }
        else {
            gender = "Female";
        }
        if (name.isEmpty() || nationality.isEmpty() || phone.isEmpty() || aadhaar.isEmpty() || address.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill all the fields");
            return;
        }
        try{
            ConnectDB con = new ConnectDB();
            String query = "insert into passenger values('"+name+"','"+nationality+"','"+phone+"','"+address+"','"+aadhaar+"','"+gender+"')";
            con.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Customer Details is added successfully");
            setVisible(false);

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error! Unable to save customer details. Please try again.");
            e.printStackTrace();

        }
    }
    public static void main(String[] args){
       new AddCustomer();
    }
}
