
package palindromos_capicuas;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author obed
 */
public class processWord extends JFrame{
    
    private String word;
    private String typeWord;
    Pile wordPile;
    
    public processWord(String word, String typeWord){
        this.typeWord = typeWord;
        this.word = word;
        this.wordPile = new Pile();
        
        this.setTitle(word);
        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        this.add(this.wordPile);
        
        this.setVisible(true);
        
        try {
            this.setVisible(false);
            splitWord();
            Thread.sleep(1500);
            this.setVisible(true);
        } catch (InterruptedException ex) {
            
        }
        int option = JOptionPane.showConfirmDialog(rootPane, "¿Evaluar?");
        if(option == 0) compareWords();
    }
    
    public void splitWord(){
        for (int i = this.word.length()-1; i >= 0; i--) {
          //System.out.println(this.word.length()); //reconocer => 9
                                                    //012345678 => 9
            char character = this.word.charAt(i);
            String letter = String.valueOf(character);
            
            this.wordPile.push(new Node(letter));
        }
    }
    
    public void compareWords(){
        
        String backwardWord = "";
        
        while (!this.wordPile.isEmpty()) {
            backwardWord += this.wordPile.pop().getLetter();
            this.repaint();
        }
        
        if(this.word.equals(backwardWord)){
            JOptionPane.showMessageDialog(rootPane, "Es "+this.typeWord);
        }else{
            JOptionPane.showMessageDialog(rootPane, "No es "+this.typeWord);
        }
    }



    
}
