package main.graphics;

import main.GameEngine;
import main.resources.ResourceLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class GameMenu extends JPanel {

    private MyButton start;
    private MyButton difficulty;
    private int diff;
    private MyButton exit;
    private BufferedImage bg;

    public GameMenu(int w, int h, GameEngine ge, Display d) {
        setLayout(null);
        start = new MyButton("Start");
        start.setBounds(w / 2 - 50 ,h / 2 - 50,100,25);
        start.addActionListener(actionEvent -> {
            ge.init();
            ge.pause(false);
            ge.start();
            d.getCanvas().setVisible(true);
            d.getFrame().requestFocus();
            setVisible(false);
        });
        difficulty = new MyButton(("Difficulty: easy"));
        difficulty.setBounds(w/2 - 80, h / 2 - 12, 160 , 25);
        difficulty.addActionListener(actionEvent -> {
            switch(diff) {
                case 0:
                    diff = 1;
                    difficulty.setText("Difficulty: medium");
                    ge.setDifficulty(diff);
                    break;
                case 1:
                    diff = 2;
                    difficulty.setText("Difficulty: hard");
                    ge.setDifficulty(diff);
                    break;
                case 2:
                    diff = 3;
                    difficulty.setText("Difficulty: impossible");
                    ge.setDifficulty(diff);
                    break;
                case 3:
                    diff = 0;
                    difficulty.setText("Difficulty: easy");
                    ge.setDifficulty(diff);
                    break;
            }
        });
        exit = new MyButton(("Exit"));
        exit.setBounds(w/2-50,h/2+25,100,25);
        exit.addActionListener(actionEvent -> System.exit(0));
        add(start);
        add(difficulty);
        add(exit);
        bg = ResourceLoader.loadImage("/menuBg.png");
        //setBackground(new Color(80, 40, 40));
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // paint the background image and scale it to fill the entire space
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }

}
