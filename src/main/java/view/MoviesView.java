package view;

import dao.MoviesDAO;
import model.Movies;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class MoviesView extends JFrame{
    JLabel title = new JLabel("Movies list");
    JLabel message = new JLabel("These are the movies you can watch at our cinema:");
    JLabel messageFinal = new JLabel("You saw something interesting? Book a seat right now!");
    JButton reservationsB = new JButton("Take your ticket!");

    public MoviesView(){
        title.setFont(new Font("Serif", Font.BOLD, 24));
        title.setHorizontalAlignment(JLabel.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,1,50,5));

        String[] columns = {"ID", "Title", "Release Year", "Producer", "Genre ID"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(message);
        panel.add(scrollPane);

        /*Movies movies = MoviesDAO.viewAll();
        for (i = 0; i< movies.getId_movies()) {
            Movies movie = movies.get(i);
            model.addRow(new Object[]{movie.getId_movies(), movie.getTitle(), movie.getRelease_year(), movie.getProducer(), movie.getId_genre()});
        }
*/    //TODO: list of movies; that table
        panel.add(messageFinal);
        panel.add(reservationsB);
        panel.setBackground(new Color(176, 211, 230));

        reservationsB.setPreferredSize(new Dimension(150,30));
        reservationsB.setBackground(Color.PINK);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(100, 10));
        this.setSize(800, 500);
        this.setVisible(true);
        this.add(title, BorderLayout.NORTH);
        this.add(panel, BorderLayout.SOUTH);
        this.pack();

        title.setForeground(new Color(221,31,88));
        reservationsB.setForeground(new Color(34,47,223));
        this.getContentPane().setBackground(new Color(176, 211, 230));

    }

    public JButton getReservationsB() {
        return reservationsB;
    }

}
