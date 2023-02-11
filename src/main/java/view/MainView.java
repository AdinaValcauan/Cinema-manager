package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainView extends JFrame{
    JLabel title = new JLabel("LOGIN");
    JLabel username = new JLabel("Username: ");
    JLabel password = new JLabel("Password: ");

    JTextField usernameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();

    JButton loginB = new JButton("Login");
    JButton registerB = new JButton("Register");

    public MainView(){
        title.setFont(new Font("Serif", Font.BOLD, 24));
        title.setHorizontalAlignment(JLabel.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,1,50,5));
        panel.setBackground(new Color(176, 211, 230));

        panel.add(username);
        panel.add(usernameField);
        panel.add(password);
        panel.add(passwordField);


        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(1, 2, 100, 50));
        bottom.setBackground(new Color(176, 211, 230));
        bottom.add(loginB);
        bottom.add(registerB);

        loginB.setPreferredSize(new Dimension(150,30));
        registerB.setPreferredSize(new Dimension(150,30));
        loginB.setBackground(Color.PINK);
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
        username.setFont(new Font("Serif", Font.BOLD, 17));
        password.setFont(new Font("Serif", Font.BOLD, 17));
        username.setForeground(new Color(0,0,119));
        password.setForeground(new Color(0,0,119));
        loginB.setForeground(new Color(34,47,223));
        registerB.setForeground(new Color(34,47,223));
        usernameField.setBackground(new Color(	237, 237, 255));
        passwordField.setBackground(new Color(	237, 237, 255));
        this.getContentPane().setBackground(new Color(176, 211, 230));

        /*final Color colorB = new Color(34,47,223);
        loginB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                colorB = (colorB == new Color(34,47,223)) ? Color.LIGHT_GRAY : new Color(34,47,223);
                loginB.setBackground(colorB);
            }
        });*/

    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JButton getLoginB() {
        return loginB;
    }

    public JButton getRegisterB() {
        return registerB;
    }

}
