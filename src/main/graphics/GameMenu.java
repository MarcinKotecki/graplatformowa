package main.graphics;

import main.GameEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMenu extends JPanel {

    private MyButton start;
    private MyButton exit;

    public GameMenu(int w, int h, GameEngine ge, Display d) {
        setLayout(null);
        start = new MyButton("Start");
        start.setBounds(w / 2 - 50 ,h / 2 - 100,100,25);
        start.addActionListener(actionEvent -> {
            ge.pause(false);
            d.getCanvas().setVisible(true);
            d.getFrame().requestFocus();
            setVisible(false);
        });
        exit = new MyButton(("Exit"));
        exit.setBounds(w/2-50,h/2-65,100,25);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        add(start);
        add(exit);
        setBackground(new Color(80, 40, 40));
    }

}
