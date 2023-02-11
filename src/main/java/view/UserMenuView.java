package view;

import javax.swing.*;
import java.awt.*;

public class UserMenuView extends JFrame{
    JLabel title = new JLabel("Main menu");
    JLabel message = new JLabel("Now that you are here, choose what you want to do next:");
    JButton buyB = new JButton("Book your seat");
    JButton moviesB = new JButton("Here are the movies you can watch");
    JButton reservationsB = new JButton("See all your reservations");

    public UserMenuView(){
        title.setFont(new Font("Serif", Font.BOLD, 24));
        title.setHorizontalAlignment(JLabel.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,1,50,5));

        panel.add(message);
        panel.add(buyB);
        panel.add(moviesB);
        panel.add(reservationsB);
        panel.setBackground(new Color(176, 211, 230));

        buyB.setPreferredSize(new Dimension(150,30));
        moviesB.setPreferredSize(new Dimension(150,30));
        reservationsB.setPreferredSize(new Dimension(150,30));
        buyB.setBackground(Color.PINK);
        moviesB.setBackground(Color.PINK);
        reservationsB.setBackground(Color.PINK);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(100, 10));
        this.setSize(800, 500);
        this.setVisible(true);
        this.add(title, BorderLayout.NORTH);
        this.add(panel, BorderLayout.SOUTH);
        this.pack();

        title.setForeground(new Color(221,31,88));
        buyB.setForeground(new Color(34,47,223));
        moviesB.setForeground(new Color(34,47,223));
        reservationsB.setForeground(new Color(34,47,223));
        this.getContentPane().setBackground(new Color(176, 211, 230));

    }

    public JButton getBuyB() {
        return buyB;
    }

    public JButton getMoviesB() {
        return moviesB;
    }

    public JButton getReservationsB() {
        return reservationsB;
    }

}
