/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palindromos_capicuas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author obed
 */
public class Node extends JPanel{
    
    private Node next;
    private String letter;
    private JLabel label;
    
    /*@Override
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.black);
        g2.drawString(letter, 400, 0);
    }*/
    
    public Node(String letter){
        this.letter = letter;
        this.label = new JLabel(this.letter);
        this.label.setFont(new Font("Arial", 0, 18));
        this.label.setBounds(0, 0, 40, 40);
        
        this.add(this.label);
        this.setSize(40, 40);
        this.setBackground(generateRandomColor());
    }
    
    public void setNext(Node next){
        this.next = next;
    }
    
    public Node getNext(){
        return this.next;
    }
    
    public String getLetter(){
        return this.letter;
    }
    
    public void move(int spaceToDraw){
        int x = this.getX();
        int y = this.getY();
        
        while(x < 200){
            try {
                Thread.sleep(50);
                x += 100;
                this.setLocation(x, y);
            } catch (InterruptedException ex) {
                Logger.getLogger(Node.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        while (y <= spaceToDraw) {
            try {
                Thread.sleep(50);
                y += 40;
                this.setLocation(x, y);
            } catch (InterruptedException ex) {
                Logger.getLogger(Node.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public Color generateRandomColor(){
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        Color color = new Color(r,g,b);
        System.out.println(color.toString());
        return color;
    }
    
}
