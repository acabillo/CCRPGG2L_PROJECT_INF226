import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class CandyRush extends JPanel implements Runnable, KeyListener {
	private Thread t;
	private Candy candy;
	JLabel bowl;
	Rectangle r;
	JLabel labelScore,labelName, labelLife[];
	public int score = 0;
	public  int life = 5;
	static String playerName;
	//static Color gameBGColor;

	private Image backgroundImage;

	
	public CandyRush(GameFrame main) {
		
		setLayout(null); 
		setSize(1200, 700); // frame size
		r = getBounds();

		// Bowl label
		bowl = new JLabel(new ImageIcon("images\\Bowl.png"));
		bowl.setBounds(5, getBounds().height - 116, 200, 80);
		add(bowl);

		// life labels
		labelLife = new JLabel[5];
		for (int i = 0; i < 5; i++) {
			labelLife[i] = new JLabel(new ImageIcon("images\\heart.png"));
			labelLife[i].setBounds(i * 40, 2, 30, 30);
			add(labelLife[i]);
		}

		// Score Label
		labelScore = new JLabel("0");
		labelScore.setBounds(getBounds().width - 70, 2, 150, 30);
		labelScore.setFont(new Font("Arial", Font.BOLD, 32));
		add(labelScore);

		// Player Name
		labelName = new JLabel("Player: " + playerName);
		labelName.setBounds(500, 2, 500, 30);
		labelName.setFont(new Font("Arial", Font.BOLD, 25));
		add(labelName);



		// candys Thread
		t = new Thread(this, "candy");
	}

	public void start() {
		t.start();
	}

	public void run() {

		try {
			while (life > 0) {
					candy = new Candy(this);
					add(candy);
					Thread.sleep(3000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Something Wrong");
		}
		JFrame parentFrame = (JFrame) this.getTopLevelAncestor();
		parentFrame.dispose();
		new TryAgain();
		
		
	}

	public void keyTyped(java.awt.event.KeyEvent evt) {
	}

	public void keyPressed(java.awt.event.KeyEvent evt) {
		int x = bowl.getX();
		int y = bowl.getY();
		if (evt.getKeyCode() == 37 && x - 25 >= 0)
			bowl.setBounds(x - 25, y, 200, 80);
		else if (evt.getKeyCode() == 39 && x + 25 < r.width - 203)
			bowl.setBounds(x + 25, y, 200, 80);
	}

	public void keyReleased(java.awt.event.KeyEvent evt) {
	}

	public void JPanelWithBackground(String fileName) throws IOException {
    	backgroundImage = ImageIO.read(new File(fileName));
  	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Draw the background image.
		g.drawImage(backgroundImage, 0, 0, this);
	}

	
}