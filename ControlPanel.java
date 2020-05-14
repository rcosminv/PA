package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JLabel classLabel;
    JTextField classField;
    JButton findBtn=new JButton("Creare");
    JLabel textLabel;
    JTextField textField;
    JLabel orizontal;
    JLabel vertical;
    JTextField xText;
    JTextField yText;


    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        vertical=new JLabel("vertical");
        yText=new JTextField();
        yText.setPreferredSize(new Dimension(40,35));
        yText.setEditable(true);

        orizontal=new JLabel("orizontal");
        xText=new JTextField();
        xText.setPreferredSize(new Dimension(40,35));
        xText.setEditable(true);

        classLabel = new JLabel("Nume clasa:");
        classField = new JTextField();
        classField.setPreferredSize(new Dimension(100,35));
        classField.setEditable(true);

        textLabel= new JLabel("Text");
        textField=new JTextField();
        textField.setPreferredSize(new Dimension(100,35));
        textField.setEditable(true);

        findBtn.addActionListener(this::find);
        add(orizontal);
        add(textField);
        add(vertical);
        add(xText);
        add(classLabel);
        add(classField);
        add(textLabel);
        add(yText);
        add(findBtn);
    }
    private void find(ActionEvent e){
        try {
            Class userComp = Class.forName(classField.getText());

            Class[] init= new Class[]{String.class};
            Constructor constructor=userComp.getConstructor(init);
            Component c;
            if(constructor==null)
                c = (Component) userComp.getConstructor().newInstance();
            else
                c = (Component) userComp.getConstructor(init).newInstance(textField.getText());
            int posX=0,posY=0;
            try {
                posX = Integer.parseInt(xText.getText(), 10);
                posY = Integer.parseInt(yText.getText(), 10);
            }catch(NumberFormatException ex){
                posX=-1;
                posY=-1;
            }
            if( posX > -1 && posY > -1)
                frame.panou.updatePanel(c,posX,posY);
            else
                frame.panou.updatePanel(c);
        } catch (ClassNotFoundException |
                NoSuchMethodException |
                InstantiationException |
                IllegalAccessException |
                InvocationTargetException |
                ClassCastException ex){
            System.out.println("exceptie");
        }
    }

}

