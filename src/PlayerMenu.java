import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PlayerMenu extends JFrame {

    JTextField textField;

    PlayerMenu() {
        // Player Name
        JLabel pName = new JLabel();
        pName.setBounds(0, 100, 300, 50);
        ImageIcon name =new ImageIcon("images/name.png");
        pName.setIcon(name);


        // JTextField
        textField = new JTextField(20);
        textField.setBounds(170, 150, 100, 25);
        // Adds event to textfield
        EventHandler handler = new EventHandler();
        textField.addKeyListener(handler);

        // Add components to frame
        this.add(pName);
        this.add(textField);


     //background image
     JLabel background;
     setSize(300,500);
     setLayout(null);
     setDefaultCloseOperation(EXIT_ON_CLOSE);
     ImageIcon img =new ImageIcon("images/bg.jpg");
 
     background = new JLabel(img,JLabel.CENTER); 
     background.setBounds(0,0,300,500);
     add(background);
     setVisible(true);
     
    this.setTitle("Player Name");
    this.setLayout(null);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(300,500);
    this.setVisible(true);
    this.setLocationRelativeTo(null);

    //lock frame
    this.setResizable(false);
    }

    private class EventHandler implements KeyListener {

        public void keyPressed(KeyEvent event) {

            CandyRush cr = new CandyRush(null);

            // If ENTER button is pressed, do this
            if (event.getKeyCode() == KeyEvent.VK_ENTER) {

                cr.playerName = textField.getText();

                // Close playermenu frame
                dispose();

                // Go to game frame
                new GameFrame().setVisible(true);
            }
        }

        public void keyTyped(KeyEvent event) {
            

        }

        public void keyReleased(KeyEvent event) {
            //
        }
    }
}