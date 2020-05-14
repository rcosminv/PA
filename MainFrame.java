package com.company;
import javax.swing.*;

import java.awt.*;

import static java.awt.BorderLayout.*;

public class MainFrame extends JFrame {
    DesignPanel panou;
    ControlPanel controlPanel;



    public MainFrame() {
        super("Laborator 12");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panou = new DesignPanel(this);
        controlPanel =new ControlPanel(this);
        panou.setBackground(Color.green);
        controlPanel.setBackground(Color.CYAN);
        add(panou, CENTER);
        add(controlPanel,SOUTH);
        pack();
    }

}


