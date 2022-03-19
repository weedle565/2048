package main;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    private Frame(){

        setSize(587,602);
        setTitle("2048");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        add(new Game());
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String[] args){

        EventQueue.invokeLater(Frame::new);

    }

}
