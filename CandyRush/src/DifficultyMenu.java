import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    
public class DifficultyMenu extends JFrame {
    
    public boolean easyHandler;
    public boolean mediumHandler;
    public boolean hardHandler;
    public boolean easyButton;
    public boolean mediumButton;
    public boolean hardButton;
    DifficultyMenu() {

        // EASY BUTTON
        JButton easyButton = new JButton();
        easyButton.setBounds(150, 100, 100, 50);
        ImageIcon easy =new ImageIcon("images/easy.gif");
        easyButton.setIcon(easy);
        easyButton.setBorder(BorderFactory.createEmptyBorder());
        // EASY Event Handler
       EventHandler easyHandler = new EventHandler(50);
        easyButton.addActionListener(easyHandler);
        this.add(easyButton);
        

        JButton mediumButton = new JButton();
        mediumButton.setBounds(145, 150, 130, 50);
        ImageIcon medium =new ImageIcon("images/medium.gif");
        mediumButton.setIcon(medium);
        EventHandler mediumHandler = new EventHandler(30);
        mediumButton.addActionListener(mediumHandler);
        mediumButton.setBorder(BorderFactory.createEmptyBorder());
         this.add(mediumButton);

         JButton hardButton = new JButton();
         hardButton.setBounds(150, 200, 100, 50);
         ImageIcon hard =new ImageIcon("images/hard.gif");
        hardButton.setIcon(hard);
         EventHandler hardHandler = new EventHandler(20);
         hardButton.addActionListener(hardHandler);
         hardButton.setBorder(BorderFactory.createEmptyBorder());
          this.add(hardButton);

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



    this.setLayout(null);
    this.setTitle("Difficulty Menu");
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(300,500);
    this.setVisible(true);
    this.setLocationRelativeTo(null);
    //lock frame
    this.setResizable(false);
}
    private class EventHandler implements ActionListener {
        int dropSpeed;

        //Constructor
        EventHandler(int speed){
            this.dropSpeed = speed;
        }

        public void actionPerformed(ActionEvent event){
            CandyRush cr = new CandyRush(null);
            Candy candy = new Candy(cr);
            candy.candySpeed = dropSpeed;

            new PlayerMenu().setVisible(true);

            dispose();
        }
    }


}