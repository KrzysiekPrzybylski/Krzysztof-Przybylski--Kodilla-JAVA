package com.kodilla.testing.osobiste;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.BLUE;

public class PanejJeden {

    public static void main(String[] args) {

        JFrame frame1 = new JFrame("krowa");
       frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame1.setBounds(200,200,1000,500);
        frame1.setVisible(true);
        frame1.getContentPane();
        frame1.getAccessibleContext();
        frame1.getJMenuBar();
        frame1.getGraphics();
        frame1.getLayeredPane();
        frame1.setLocation(500,300);
        frame1.setSize(500,500);
        frame1.setBackground(BLUE);
        frame1.setName("Kupa");
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(1000,200));
        panel.setBackground(BLUE);
        frame1.getContentPane().add(panel);
        frame1.pack();

        frame1.getGlassPane();

    }
}
