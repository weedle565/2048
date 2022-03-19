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

public class Game extends JPanel {

    //location is used to store the current location of cubes
    private final int[] location = new int[16];
    //in is used to check if a cube is in a specific location
    private final boolean[] in = new boolean[16];
    //number inside the cube
    private final int[] num = new int[16];

    //Width and height of a cube
    private final int WIDTH = 144, HEIGHT = 144;

    Random rand;

    public Game(){
        initGame();
    }

    public void initGame(){

        addKeyListener(new KeyListener());
        setFocusable(true);

        rand = new Random();

        //set all cubes to 0 and no cubes to be spawning inside the game
        for(int i = 0; i<16; i++){
            location[i] = i;
            in[i] = false;
            num[i] = 0;
        }

        //randomly select starting cubes
        int first = rand.nextInt(0, 15);
        int second = rand.nextInt(0, 15);

        if(second == first){
            second = rand.nextInt(0, 15);
        }

        in[first] = true;
        in[second] = true;

        num[first] = 2;
        num[second] = 2;

    }

    private void left() {

        for (int i = 15; i >= 0; i--) {

            //Check if a cube can move to the left, these if statements check to see where the cube is stopping (the wall or another cube)
            // First row:

            if (in[i] && i < 3 && !in[i + 1]) {
                in[i] = false;
                in[i + 1] = true;
                System.out.println(i);
                num[i + 1] = num[i];
                num[i] = 0;
                repaint();
                i = 15;
            }

            //Second row
            if (in[i] && i < 7 && i > 3 && !in[i + 1]) {
                in[i] = false;
                in[i + 1] = true;
                num[i + 1] = num[i];
                num[i] = 0;
                repaint();
                i = 15;
            }

            //Third row
            if (in[i] && i < 11 && i > 7 && !in[i + 1]) {
                in[i] = false;
                in[i + 1] = true;
                num[i + 1] = num[i];
                num[i] = 0;
                repaint();
                i = 15;
            }

            //Fourth row
            if (in[i] && i < 15 && i > 11 && !in[i + 1]) {
                in[i] = false;
                in[i + 1] = true;
                num[i + 1] = num[i];
                num[i] = 0;
                repaint();
                i = 15;
            }

            //Check if 2 cubes moving into each other are equivalent, if yes add together
            if (in[i] && i < 3 && in[i + 1] && num[i] == num[i + 1]) {
                num[i + 1] = num[i] * 2;
                in[i] = false;
                num[i] = 0;
                repaint();
                i = 15;
            }

            if (in[i] && i > 3 && i < 7 && in[i + 1] && num[i] == num[i + 1]) {
                num[i + 1] = num[i] * 2;
                in[i] = false;
                num[i] = 0;
                repaint();
                i = 15;
            }

            if (in[i] && i > 7 && i < 11 && in[i + 1] && num[i] == num[i + 1]) {
                num[i + 1] = num[i] * 2;
                in[i] = false;
                num[i] = 0;
                repaint();
                i = 15;
            }

            if (in[i] && i > 11 && i < 15 && in[i + 1] && num[i] == num[i + 1]) {
                num[i + 1] = num[i] * 2;
                in[i] = false;
                num[i] = 0;
                repaint();
                i = 15;
            }

        }

        //Create a new cube
        int newCube = rand.nextInt(0, 15);

        if (!in[newCube]) {
            in[newCube] = true;
            num[newCube] = 2;
            repaint();
        }


    }

    private void right(){
        for(int i = 15; i > 0; i--) {

            //Check where to stop cubes when moving
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
                num[i-1] = num[i];
                num[i] = 0;
                repaint();
                i = 15;
            }

            if (i < 12 && i > 8 && in[i] && !in[i-1]){
                in[i] = false;
                in[i - 1] = true;
                num[i-1] = num[i];
                num[i] = 0;
                repaint();
                i = 15;
            }

            //Checks if to add the cubes together as they have the same number
            if(in[i] && i < 4 && in[i-1] && num[i] == num[i-1]){
                num[i+1] = num[i]*2;
                in[i] = false;
                num[i] = 0;
                repaint();
                i = 15;
            }

            if(in[i] && i > 4 &&  i < 8 && in[i-1] && num[i] == num[i-1]){
                num[i-1] = num[i]*2;
                in[i] = false;
                num[i] = 0;
                repaint();
                i = 15;
            }

            if(in[i] && i > 8 &&  i < 12 && in[i-1] && num[i] == num[i-1]){
                num[i-1] = num[i]*2;
                in[i] = false;
                num[i] = 0;
                repaint();
                i = 15;
            }

            if(in[i] && i > 12 &&  i < 16 && in[i-1] && num[i] == num[i-1]){
                num[i-1] = num[i]*2;
                in[i] = false;
                num[i] = 0;
                repaint();
                i = 16;
            }

            if (i < 16 && i > 12 && in[i] && !in[i-1]){
                in[i] = false;
                in[i - 1] = true;
                num[i-1] = num[i];
                num[i] = 0;
                repaint();
                i = 16;

            }

        }

        //Creates a new cube
        int newCube = rand.nextInt(0,15);

        if (!in[newCube]) {
            in[newCube] = true;
            num[newCube] = 2;
            repaint();
        }
    }

    private void down(){
        for(int i = 15; i >= 0; i--){
            if(i < 12 && in[i] && !in[i+4]){
                in[i] = false;
                in[i+4] = true;
                num[i+4] = num[i];
                num[i] = 0;
                repaint();
                i = 15;
            }

            if(i < 12 && in[i] && in[i+4] && num[i] == num[i+4]){
                in[i] = false;
                in[i+4] = true;
                num[i+4] = num[i]*2;
                num[i] = 0;
                repaint();
                i = 15;
            }

        }
        //Creates a new cube
        int newCube = rand.nextInt(0,15);
        if (!in[newCube]) {
            in[newCube] = true;
            num[newCube] = 2;
            repaint();
        }

    }

    private void up(){
        for(int i = 15; i >= 0; i--){

            if(i > 3 && in[i] && in[i-4] && num[i] == num[i-4]){
                in[i] = false;
                in[i+4] = true;
                num[i+4] = num[i]*2;
                num[i] = 0;
                repaint();
                i = 15;
            }

            if(i > 3 && in[i] && !in[i-4]){
                in[i] = false;
                in[i-4] = true;
                num[i-4] = num[i];
                num[i] = 0;
                repaint();
                i = 16;
            }

        }
        //Creates a new cube
        int newCube = rand.nextInt(0,15);
        if (!in[newCube]) {
            in[newCube] = true;
            num[newCube] = 2;
            repaint();
        }

    }

    @Override
    public void paintComponent(Graphics g){

        g.setColor(white);
        g.fillRect(0,0,getWidth(),getHeight());

        //Draw cubes (this is foul no judgement)
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

        //Destroy the screen on victory cause funny
        for(int i = 0; i < 16; i++){
            if(num[i] == 2048){
                System.exit(1);
            }
        }
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
