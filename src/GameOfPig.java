import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class GameOfPig extends JFrame{

	public static void main(String[] args) {
		
		new GameOfPig();
		 
	}
	
	public GameOfPig() {

		super("Pig Game");

		JButton rollDiceButton = new JButton("Roll Dice"); 
		JLabel mainFrameLabel = new JLabel();
		
		
		add(rollDiceButton);
		rollDiceButton.setBounds(100, 100, 100, 80);
		add(mainFrameLabel, BorderLayout.CENTER);
		super.setSize(700, 800); 

		setVisible(true);
				
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		this.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				dispose();        		 
			}
		});

		
	}

}
