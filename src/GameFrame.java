import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame implements Runnable {
	Thread t;
	CandyRush cr;
	static String gameBackgroundImage;

	public GameFrame() {
		t = new Thread(this, "Dispose");

		cr = new CandyRush(this);
		cr.start();

		try {
			cr.JPanelWithBackground(gameBackgroundImage);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		this.getContentPane().add(cr);

		//  add(cr);
		addKeyListener(cr);
		setTitle("Candy Rush"); // Title Frame
		setResizable(false);
		getContentPane().setBackground(Color.white);
		setSize(1200, 700); // frame size
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
	}

	public void run() {
		dispose();
	}



}