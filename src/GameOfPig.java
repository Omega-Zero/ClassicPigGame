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

		JButton computerPlayButton = new JButton("Play Computer");
		add(computerPlayButton);
		computerPlayButton.setBounds(525, 730, 150, 20);
		
		JButton rollDiceButton = new JButton("Roll Dice"); 
		add(rollDiceButton);
		rollDiceButton.setBounds(250, 650, 200, 80);
		
		JLabel mainFrameLabel = new JLabel();
		add(mainFrameLabel, BorderLayout.CENTER);
	
		super.setSize(700, 800); 
		setVisible(true);
			
		//fully close when exit
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				dispose();        		 
			}
		});

		
	}

}
