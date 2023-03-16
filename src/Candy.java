import javax.swing.*;
import java.util.*;

public class Candy extends JLabel implements Runnable
{
	private Thread t;
	private CandyRush cr;
	private Random rand;
	private static int diff=10;
	static int candySpeed;

	public Candy(CandyRush cr){
		this.cr=cr;
		
		t = new Thread(this);
		rand = new Random();
		setIcon(new ImageIcon("images\\"+rand.nextInt(10)+".png"));
		t.start();
	}

	public void run(){
		int x=rand.nextInt(cr.getBounds().width-150)+50;
		int y=35;
		int bowlX,bowlY;
		boolean f=true;
		try{
			while(cr.life>0 && getY()<=cr.getBounds().height-20){
				setBounds(x,y,150,150);
				bowlX=cr.bowl.getX();
				bowlY=cr.bowl.getY();
				if(y+24>=bowlY && y+24<=bowlY+10 && x>bowlX && bowlX+200>x+48){
					cr.score++;
					cr.labelScore.setText(cr.score+"");
					f=false;
					break;
				}
				Thread.sleep(candySpeed);
				y+=diff;
			}
			if(f){
				cr.life--;
				cr.remove(cr.labelLife[cr.life]);
			}
			cr.remove(this);
			cr.validate();
			cr.repaint();
		}catch(Exception ex){}
	}
}