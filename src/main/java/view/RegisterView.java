package view;

import javax.swing.*;
import java.awt.*;

public class RegisterView extends JFrame{
    JLabel title = new JLabel("REGISTER");
    JLabel email = new JLabel("Email: ");
    JLabel firstName = new JLabel("First name: ");
    JLabel lastName = new JLabel("Last name: ");
    JLabel username = new JLabel("Username: ");
    JLabel password = new JLabel("Password: ");

    JTextField usernameField = new JTextField();
    JTextField emailField = new JTextField();
    JTextField firstNameField = new JTextField();
    JTextField lastNameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();

    JButton registerB = new JButton("Register");

    public RegisterView(){
        title.setFont(new Font("Serif", Font.BOLD, 24));
        title.setHorizontalAlignment(JLabel.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10,1,50,5));
        panel.setBackground(new Color(176, 211, 230));

        panel.add(firstName);
        panel.add(firstNameField);
        panel.add(lastName);
        panel.add(lastNameField);
        panel.add(email);
        panel.add(emailField);
        panel.add(username);
        panel.add(usernameField);
        panel.add(password);
        panel.add(passwordField);


        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(1, 1, 100, 50));
        bottom.add(registerB);

        registerB.setPreferredSize(new Dimension(150,30));
        registerB.setBackground(Color.PINK);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(100, 10));
        this.setSize(800, 500);
        this.setVisible(true);
        this.add(title, BorderLayout.NORTH);
        this.add(bottom, BorderLayout.SOUTH);
        this.add(panel, BorderLayout.CENTER);
        this.pack();

        title.setForeground(new Color(221,31,88));
        registerB.setForeground(new Color(34,47,223));
        this.getContentPane().setBackground(new Color(176, 211, 230));

    }

    public JTextField getEmailField() {
        return emailField;
    }

    public JTextField getFirstNameField() {
        return firstNameField;
    }

    public JTextField getLastNameField(){
        return lastNameField;
    }
    public JTextField getUsernameField() {
        return usernameField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JButton getRegisterB() {
        return registerB;
    }
}
