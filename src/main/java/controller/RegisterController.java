package controller;

import connection.ConnectionFactory;
import dao.PersonDAO;
import model.Person;
import view.RegisterView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class RegisterController implements ActionListener{
        private RegisterView registerView = new RegisterView();

        public RegisterController() {
                registerView.getRegisterB().addActionListener(this);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
                String username = registerView.getUsernameField().getText();
                char[] password = registerView.getPasswordField().getPassword();
                String passwordString = new String(password);
                String email = registerView.getEmailField().getText();
                String firstName = registerView.getFirstNameField().getText();
                String lastName = registerView.getLastNameField().getText();

                Connection connection = ConnectionFactory.getConnection();
                Person person = new Person(0, email, firstName, lastName, username, passwordString);

                int insertedId = PersonDAO.insert(person);
                System.out.println("Inserted id: " + insertedId);

                ConnectionFactory.close(connection);

                //TODO: make the registration process more complex
        }


}
