package com.techja.cocaro.gui;

import com.techja.cocaro.BanCo;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private static final int W_FRAME = 900;
    private static final int H_FRAME = 600;

    public GUI() {
        initViews();
    }

    private void initViews() {
        setSize(W_FRAME, H_FRAME);
        setTitle("Game Caro");
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new CardLayout());
        add(new BanCo(Color.BLACK, "Nam", "Hạnh"));
    }

//    @Override
//    public void paintComponents(Graphics g) {
//        super.paintComponents(g);
//        g.setColor(Color.BLACK);
//        g.drawLine();
//    }
}
