import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;

public class ColorMenu extends JFrame {

    JList bgList;

    private String[] backgroundNameArray = { "     PINK","    TEAL","  WHITE", "BROWN"   };
    private String[] backgroundClassArray = { "images/Pink.png", "images/Teal.png", "images/White.png", "images/Brown.png"}; 

    ColorMenu() {

        // Jlist 
        bgList = new JList(backgroundNameArray);
        bgList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        bgList.setBounds(150, 120, 200, 200);
        bgList.setForeground(Color.PINK);        
        bgList.setBorder(BorderFactory.createEmptyBorder());
        bgList.setBackground(new Color(0, 0, 0, 0));

        bgList.setFont(new Font("Arial", Font.BOLD, 25));

        // Add event
        bgColorEventHandler handler = new bgColorEventHandler();
        bgList.addListSelectionListener(handler);
        this.add(bgList);

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
        this.setTitle("Candy Rush");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(300,500);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        //lock frame
        this.setResizable(false);

    }

    // Event handler
    private class bgColorEventHandler implements ListSelectionListener {

        public void valueChanged(ListSelectionEvent event) {

            GameFrame.gameBackgroundImage = backgroundClassArray[bgList.getSelectedIndex()];

            new DifficultyMenu();

            // closes color menu
            pack();
            dispose();
        }
    }
}
