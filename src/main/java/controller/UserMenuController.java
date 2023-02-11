package controller;

import view.UserMenuView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserMenuController implements ActionListener {
    private final UserMenuView userMenuView = new UserMenuView();

    public UserMenuController() {
        userMenuView.getBuyB().addActionListener(this);
        userMenuView.getMoviesB().addActionListener(this);
        userMenuView.getReservationsB().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == userMenuView.getBuyB()) {
            BuyController buyController = new BuyController();
            userMenuView.dispose();
        } else if (e.getSource() == userMenuView.getMoviesB()) {
            MoviesController moviesController = new MoviesController();
            userMenuView.dispose();
        } else if (e.getSource() == userMenuView.getReservationsB()) {
            ReservationsController reservationsController = new ReservationsController();
            userMenuView.dispose();
        }
    }
}
