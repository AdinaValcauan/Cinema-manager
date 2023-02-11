package controller;

import connection.ConnectionFactory;
import dao.PersonDAO;
import view.MainView;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;


public class MainController implements ActionListener {
    private final MainView mainView = new MainView();

    public MainController() {
        mainView.getRegisterB().addActionListener(this);
        mainView.getLoginB().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == mainView.getRegisterB()) {
           RegisterController registerController = new RegisterController();
           mainView.dispose();
        } else {
            String username = mainView.getUsernameField().getText();
            char[] password = mainView.getPasswordField().getPassword();

           if (PersonDAO.checkCredentials(username, password)) {
               // Open the menu page
               UserMenuController menuController = new UserMenuController();
               mainView.dispose();
           } else {
               // Show an error message
               JOptionPane.showMessageDialog(mainView, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
           }

            Connection connection = ConnectionFactory.getConnection();

           //MenuController menuController = new MenuController();
           mainView.dispose();

            ConnectionFactory.close(connection);
        }
    }
}

