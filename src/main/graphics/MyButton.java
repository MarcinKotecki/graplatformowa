package main.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyButton extends JButton {

    private Color c = new Color(245,245,245);
    private Color s = new Color(220,220,220);
    private Color f = new Color(90,90,90);

    public MyButton(String text) {
        super(text);
        setFont(new Font("droidsans", Font.BOLD, 12));
        //setBorderPainted(false);
        setFocusPainted(false);
        setBackground(c);
        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, s));
        setForeground(f);
        //setBorder(BorderFactory.createLineBorder(Const.color2));
        //setContentAreaFilled(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                super.mouseEntered(mouseEvent);
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                super.mouseExited(mouseEvent);
            }
        });
    }

}

