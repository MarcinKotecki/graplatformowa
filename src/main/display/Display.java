package main.graphics;

import main.GameEngine;

import javax.swing.*;
import java.awt.*;

public class Display {

    private JFrame frame;
    private Canvas canvas;
    private String title = "GraPlatformowa";
    private int width, height;

    public Display(int width, int height) {
        this.height = height;
        this.width = width;
        createDisplay();
    }

    private void createDisplay() {
        frame = new JFrame(title);
        frame.setSize(width * GameEngine.scale, height * GameEngine.scale);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width * GameEngine.scale, height * GameEngine.scale));
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.pack();
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public JFrame getFrame() {
        return frame;
    }

}