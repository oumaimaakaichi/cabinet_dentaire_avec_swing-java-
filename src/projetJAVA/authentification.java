package projetJAVA;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException; 



public class authentification extends JFrame implements ActionListener {
    private JLabel nameLabel, emailLabel, passwordLabel;
    private JTextField nameField, emailField, passwordField;
    private JButton submitButton;

    public authentification() {
        nameLabel = new JLabel("Name:");
        emailLabel = new JLabel("Email:");
        passwordLabel = new JLabel("Password:");

        nameField = new JTextField();
        emailField = new JTextField();
        passwordField = new JTextField();

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(submitButton);

        getContentPane().add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String name = nameField.getText();
            String email = emailField.getText();
            String password = passwordField.getText();
            String userData = name + "," + email + "," + password;

            try {
                BufferedReader reader = new BufferedReader(new FileReader("src/projetJAVA/usernames.txt"));
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
                reader.close();

                BufferedWriter writer = new BufferedWriter(new FileWriter("src/projetJAVA/usernames.txt"));
                writer.write(content.toString() + userData);
                writer.close();

                JOptionPane.showMessageDialog(this, "User added successfully!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error adding user to file.");
            }
        }
    }

}
