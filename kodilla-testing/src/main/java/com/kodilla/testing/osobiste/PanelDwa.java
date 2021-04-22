package com.kodilla.testing.osobiste;

import javax.swing.*;
import java.awt.*;

public class PanelDwa extends JFrame{

    public PanelDwa() {
        this.setTitle("NOWOSTWORZONYPANEL");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(500,400);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(300,300));
        panel.setBackground(Color.red);
        this.getContentPane().add(panel);

        this.pack();
        this.setVisible(true);

        Button start = new Button("KAKAO");
        start.setBackground(Color.BLUE);
        start.setLabel("JUTRZENKA");

        start.setBounds(550,450,20,20);

        this.add(start);



    }

    public static void main(String[] args) {
      PanelDwa panelDwa = new PanelDwa();
    }
}
