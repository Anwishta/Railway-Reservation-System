package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton submit, reset, close;
    JTextField tusername;
    JPasswordField tpassword;

    // Login constructor
    public Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(20, 20, 100, 20);
        add(lblusername);

        tusername = new JTextField();
        tusername.setBounds(130, 20, 200, 20);
        add(tusername);

        JLabel lblpassword = new JLabel("password");
        lblpassword.setBounds(20, 60, 100, 20);
        add(lblpassword);

        tpassword = new JPasswordField();
        tpassword.setBounds(130, 60, 200, 20);
        add(tpassword);

        reset = new JButton("Reset");
        reset.setBounds(40, 120, 120, 20);
        reset.addActionListener(this);
        add(reset);

        submit = new JButton("Submit");
        submit.setBounds(190, 120, 120, 20);
        submit.addActionListener(this);
        add(submit);

        close = new JButton("Close");
        close.setBounds(120, 160, 120, 20);
        close.addActionListener(this);
        add(close);

        setSize(400, 250);
        setLocation(600,250);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent actionevent){
        if (actionevent.getSource() == submit){
            String username = tusername.getText();
            String password = tpassword.getText();
            try{
                ConnectDB c = new ConnectDB();
                String query = "select * from login where username = '" + username +"' and password = '"+ password +"'";
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()){
                    new Home();
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                    setVisible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (actionevent.getSource()==close) {
            setVisible(false);
        }else if (actionevent.getSource()==reset){
            tusername.setText("");
            tpassword.setText("");
        }
    }
    public static void main(String[] args){

        new Login();
    }
}
