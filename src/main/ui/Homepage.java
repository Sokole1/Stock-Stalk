package main.ui;

import main.model.Stock;

import javax.swing.*;
import java.awt.*;


public class Homepage extends JFrame {

    HomeTop homeTop = new HomeTop(this);
    GridBagConstraints gbc;
    JPanel home;
    Favourites favourites;
    JScrollPane favScrollArea;

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    final int WIDTH = (int) screenSize.getWidth();
    final int HEIGHT = (int) screenSize.getHeight();

    Homepage(Stock[] stocks) {
        home = new JPanel();
        home.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        home.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.weightx = 1.0;
        gbc.weighty = 0.2;
        gbc.gridx = 0;
        gbc.gridy = 0;

        favourites = new Favourites(stocks, this);

        favScrollArea = new JScrollPane(favourites);
        favScrollArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        favScrollArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        favScrollArea.setFocusable(false);

        home.add(homeTop, gbc);

        gbc.gridy++;
        gbc.weighty = 0.8;
        gbc.insets = new Insets(0,0,20,5);
        home.add(favScrollArea, gbc);

        this.add(home);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
}
