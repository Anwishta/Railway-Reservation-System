package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Home extends JFrame {

    public Home() {
        setLayout(null);

        ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/asset/img.png"));
        JLabel backgroundLabel = new JLabel(backgroundImage);
        add(backgroundLabel);

        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                Dimension size = getSize();
                Image scaledImage = backgroundImage.getImage().getScaledInstance(size.width, size.height, Image.SCALE_SMOOTH);
                backgroundLabel.setIcon(new ImageIcon(scaledImage));
                backgroundLabel.setSize(size);
            }
        });

        // Add a heading label
        JLabel heading = new JLabel("Welcome to Railway India...");
        heading.setBounds(500, 40, 1000, 40);
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 36));
        backgroundLabel.add(heading);

        // Create a menu bar
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);

        // Add a menu to the menu bar with a label
        JMenu details = new JMenu("Details");
        menubar.add(details);

        JMenuItem trainDetails = new JMenuItem("Train Details");
        details.add(trainDetails);

        JMenuItem passengerDetails = new JMenuItem("Add Passenger Details");
        details.add(passengerDetails);

        JMenuItem bookSeat = new JMenuItem("Book Seats");
        details.add(bookSeat);

        JMenuItem journeyDetails = new JMenuItem("Journey Details");
        details.add(journeyDetails);

        JMenuItem ticketCancel = new JMenuItem("Cancel Ticket");
        details.add(ticketCancel);

        JMenu ticket = new JMenu("Ticket");
        menubar.add(ticket);

        JMenuItem boardingPass = new JMenuItem("Boarding Pass");
        ticket.add(boardingPass);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Home();
    }
}
