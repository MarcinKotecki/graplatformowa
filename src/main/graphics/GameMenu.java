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
    private MyButton exit;
    private BufferedImage bg;

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
        bg = ResourceLoader.loadImage("/menuBg.png");
        //setBackground(new Color(80, 40, 40));
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // paint the background image and scale it to fill the entire space
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }

}
