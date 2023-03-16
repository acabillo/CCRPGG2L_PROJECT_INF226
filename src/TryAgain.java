import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TryAgain extends JFrame {

    TryAgain(){

        //JButton Try again
        JButton tryAgainbutton = new JButton();
        tryAgainbutton.setBounds(10, 200, 150, 50);
        ImageIcon againButton =new ImageIcon("images/again.gif");
        tryAgainbutton.setIcon(againButton);
        tryAgainbutton.setBorder(BorderFactory.createEmptyBorder());
      
        tryAgainEventHandler again = new tryAgainEventHandler();
        tryAgainbutton.addActionListener(again);
        this.add(tryAgainbutton);

        //JButton Exit
        JButton exitButton = new JButton();
        exitButton.setBounds(140, 200, 150, 50);
        ImageIcon ex =new ImageIcon("images/exit.gif");
        exitButton.setIcon(ex);
        exitButton.setBorder(BorderFactory.createEmptyBorder());

        ExitEventHandler exit = new ExitEventHandler();
        exitButton.addActionListener(exit);
        this.add(exitButton);


        //background image
        JLabel background;
        // setSize(300,500);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon img =new ImageIcon("images/try.jpg");
    
        background = new JLabel(img,JLabel.CENTER); 
        background.setBounds(0,0,300,500);
        add(background);
        setVisible(true);

        this.setLayout(null);
        this.setTitle("Candy Rush");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(300,500);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        //lock frame
        this.setResizable(false);

       
    } 
    private class tryAgainEventHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            
            new GameFrame().setVisible(true);
            dispose();

        }
}
private class ExitEventHandler implements ActionListener{
    public void actionPerformed(ActionEvent event){

        dispose();
    }
}
}