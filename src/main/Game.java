package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Random;

import static java.awt.Color.*;

public class Game extends JPanel implements ActionListener {

    private final int[] location = new int[16];
    private final boolean[] in = new boolean[16];
    private final int[] num = new int[16];

    private final int WIDTH = 144, HEIGHT = 144;

    Random rand;

    public Game(){
        initGame();
    }

    public void initGame(){

        addKeyListener(new KeyListener());
        setFocusable(true);

        rand = new Random();


        for(int i = 0; i<16; i++){
            location[i] = i;
            in[i] = false;
            num[i] = 0;
        }

        int first = rand.nextInt(0, 15);
        int second = rand.nextInt(0, 15);

        in[first] = true;
        in[second] = true;

        num[first] = 2;
        num[second] = 2;

        System.out.println(Arrays.toString(location));
        System.out.println(Arrays.toString(in));
    }

    private void left(){
        for(int i = 15; i  >= 0; i--){
            if(in[i] && i < 3 && !in[i+1]){
                in[i] = false;
                in[i+1] = true;
                System.out.println(i);
                num[i+1] = num[i];
                num[i] = 0;
                repaint();
                i = 15;
            }

            if(in[i] && i < 7 && i > 3 && !in[i+1]){
                in[i] = false;
                in[i+1] = true;
                num[i+1] = num[i];
                num[i] = 0;
                System.out.println(i);
                repaint();
                i = 15;
            }

            if(in[i] && i < 11 && i > 7 && !in[i+1]){
                in[i] = false;
                in[i+1] = true;
                System.out.println(i);
                num[i+1] = num[i];
                num[i] = 0;
                repaint();
                i = 15;
            }

            if(in[i] && i < 15 && i > 11 && !in[i+1]){
                in[i] = false;
                in[i+1] = true;
                System.out.println(i);
                num[i+1] = num[i];
                num[i] = 0;
                repaint();
                i = 15;
            }
        }

        System.out.println(Arrays.toString(in));
    }

    private void right(){
        for(int i = 15; i > 0; i--) {
            if (in[i]  && !in[i - 1] && i < 4) {
                in[i] = false;
                in[i - 1] = true;
                num[i-1] = num[i];
                num[i] = 0;
                repaint();
                i = 15;
            }

            if (i < 8 && i > 4 && in[i] && !in[i-1]){
                in[i] = false;
                in[i - 1] = true;
                System.out.println(i);
                num[i-1] = num[i];
                num[i] = 0;
                repaint();
                i = 15;
            }

            if (i < 12 && i > 8 && in[i] && !in[i-1]){
                in[i] = false;
                in[i - 1] = true;
                System.out.println(i);
                num[i-1] = num[i];
                num[i] = 0;
                repaint();
                i = 15;
            }

            if (i < 16 && i > 12 && in[i] && !in[i-1]){
                in[i] = false;
                in[i - 1] = true;
                System.out.println(i);
                num[i-1] = num[i];
                num[i] = 0;
                repaint();
                i = 16;

            }



        }
        System.out.println(Arrays.toString(in));
    }

    private void down(){
        for(int i = 15; i >= 0; i--){
            if(i < 12 && in[i] && !in[i+4]){
                in[i] = false;
                in[i+4] = true;
                num[i+4] = num[i];
                num[i] = 0;
                System.out.println(i);
                repaint();
                i = 15;
            }
        }
    }

    private void up(){
        for(int i = 15; i >= 0; i--){
            if(i > 3 && in[i] && !in[i-4]){
                in[i] = false;
                in[i-4] = true;
                num[i-4] = num[i];
                num[i] = 0;
                System.out.println(i);
                repaint();
                i = 16;
            }
        }
    }

    @Override
    public void paintComponent(Graphics g){

        g.setColor(white);
        g.fillRect(0,0,getWidth(),getHeight());

        for(int i : location)
            if(in[i]) {
                g.setColor(black);
                g.setFont(new Font("Arial", Font.BOLD, 20));
                switch (i) {
                    case 0 -> {
                        g.drawRect(0, 0, WIDTH, HEIGHT);
                        g.drawString(String.valueOf(num[i]), (WIDTH/2),HEIGHT/2);
                    }
                    case 1 -> {
                        g.drawRect(144, 0, WIDTH, HEIGHT);
                        g.drawString(String.valueOf(num[i]), (WIDTH/2)*3,HEIGHT/2);
                    }
                    case 2 -> {
                        g.drawRect(144 * 2, 0, WIDTH, HEIGHT);
                        g.drawString(String.valueOf(num[i]), (WIDTH/2)*5,HEIGHT/2);
                    }
                    case 3 -> {
                        g.drawRect(144 * 3, 0, WIDTH, HEIGHT);
                        g.drawString(String.valueOf(num[i]), (WIDTH/2*7),(HEIGHT/2));
                    }
                    case 4 -> {
                        g.drawRect(0, 144, WIDTH, HEIGHT);
                        g.drawString(String.valueOf(num[i]), (WIDTH/2),(HEIGHT/2)*3);
                    }
                    case 5 -> {
                        g.drawRect(144, 144, WIDTH, HEIGHT);
                        g.drawString(String.valueOf(num[i]), (WIDTH/2)*3,(HEIGHT/2)*3);
                    }
                    case 6 -> {
                        g.drawRect(144 * 2, 144, WIDTH, HEIGHT);
                        g.drawString(String.valueOf(num[i]), (WIDTH/2)*5,(HEIGHT/2)*3);
                    }
                    case 7 -> {
                        g.drawRect(144 * 3, 144, WIDTH, HEIGHT);
                        g.drawString(String.valueOf(num[i]), (WIDTH/2)*7,(HEIGHT/2)*3);
                    }
                    case 8 -> {
                        g.drawRect(0, 144 * 2, WIDTH, HEIGHT);
                        g.drawString(String.valueOf(num[i]), (WIDTH/2),(HEIGHT/2)*5);
                    }
                    case 9 -> {
                        g.drawRect(144, 144 * 2, WIDTH, HEIGHT);
                        g.drawString(String.valueOf(num[i]), (WIDTH/2)*3,(HEIGHT/2)*5);
                    }
                    case 10 -> {
                        g.drawRect(144 * 2, 144 * 2, WIDTH, HEIGHT);
                        g.drawString(String.valueOf(num[i]), (WIDTH/2)*5,(HEIGHT/2)*5);
                    }
                    case 11 -> {
                        g.drawRect(144 * 3, 144 * 2, WIDTH, HEIGHT);
                        g.drawString(String.valueOf(num[i]), (WIDTH/2)*7,(HEIGHT/2)*5);
                    }
                    case 12 -> {
                        g.drawRect(0, 144 * 3, WIDTH, HEIGHT);
                        g.drawString(String.valueOf(num[i]), (WIDTH/2),(HEIGHT/2)*7);
                    }
                    case 13 -> {
                        g.drawRect(144, 144 * 3, WIDTH, HEIGHT);
                        g.drawString(String.valueOf(num[i]), (WIDTH/2)*3,(HEIGHT/2)*7);
                    }
                    case 14 -> {
                        g.drawRect(144 * 2, 144 * 3, WIDTH, HEIGHT);
                        g.drawString(String.valueOf(num[i]), (WIDTH/2)*5,(HEIGHT/2)*7);
                    }
                    case 15 -> {
                        g.drawRect(144 * 3, 144 * 3, WIDTH, HEIGHT);
                        g.drawString(String.valueOf(num[i]), (WIDTH/2)*7,(HEIGHT/2)*7);
                    }
                }
           }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private class KeyListener extends KeyAdapter{

        @Override
        public void keyPressed(KeyEvent e){

            switch(e.getKeyCode()){
                case KeyEvent.VK_W ->
                        up();
                case KeyEvent.VK_S ->
                        down();
                case KeyEvent.VK_D ->
                        left();
                case KeyEvent.VK_A ->
                        right();
            }

        }

    }
}
