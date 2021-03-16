/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palindromos_capicuas;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JPanel;

/**
 *
 * @author obed
 */
public class Pile extends JPanel{
    
    private Node top;
    private int totalNodes;
    private int spaceToDraw = 0;
    
    public Pile(){
        this.top = null;
        this.totalNodes = 0;
        this.setSize(400, 400);
        this.setBackground(Color.cyan);
        this.setLayout(null);
        this.setVisible(true);
    }
    
    public void push(Node newNode){
        if(isEmpty()){
            top = newNode;
        }else{
            newNode.setNext(top);
            top = newNode;
        }
        this.add(newNode);
        newNode.setLocation(0, spaceToDraw);
        spaceToDraw += 40;
        totalNodes++;
    }
    
    public Node pop(){
        Node temporaly = top;
        top = temporaly.getNext();
        temporaly.setNext(null);
        totalNodes--;
        
        temporaly.move(spaceToDraw);
        spaceToDraw -=40;
        this.repaint();
        
        return temporaly;
    }
    
    public boolean isEmpty(){
        return (top==null);
    }
    
    public int getTotalNodes(){
        return this.totalNodes;
    }
    
}
