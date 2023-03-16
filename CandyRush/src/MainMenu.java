import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu extends JFrame {
    MainMenu(){
        //JButton START
        JButton startButton = new JButton();
        startButton.setBounds(75, 250, 150, 50);
        ImageIcon start =new ImageIcon("images/start.png");
        startButton.setIcon(start);
        startButton.setBorder(BorderFactory.createEmptyBorder());
        this.add(startButton);

        EventHandler handler = new EventHandler();
        startButton.addActionListener(handler);
        this.add(startButton);


        //background image
        JLabel background;
        setSize(300,500);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon img =new ImageIcon("images/MainMenu.jpg");
    
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
    //Event Handler
    private class EventHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            new ColorMenu();

            //Close main menu frame       
            dispose();
    
}
}
}
