package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DesignPanel extends JPanel {
    final MainFrame frame;
    final static int W = 1000, H = 800;

    public DesignPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
    }

    protected void updatePanel(Component p){
        try {
            int orizontal=new Random().nextInt(getWidth());
            int vertical=new Random().nextInt(getHeight());
            int w=p.getPreferredSize().width;
            int h=p.getPreferredSize().height;
            p.setBounds(orizontal,vertical,w,h);
            add(p);
            frame.repaint();
        }catch(IllegalArgumentException ex) {
            System.out.println("Eroare");
        }
    }
    protected void updatePanel(Component p,int posX,int posY){
        try {
            int w=p.getPreferredSize().width;
            int h=p.getPreferredSize().height;
            p.setBounds(posX,posY,w,h);
            add(p);
            frame.repaint();
        }catch(IllegalArgumentException ex) {
            System.out.println("Eroare");
        }
    }
}


