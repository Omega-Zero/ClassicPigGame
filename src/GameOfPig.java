import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Random;

public class GameOfPig extends JFrame{

	public static void main(String[] args) {
		
		new GameOfPig();
		 
	}
	
	
	//Main window call that generates GUI
	public GameOfPig() {

		super("Pig Game");

		JButton computerPlayButton = new JButton("Play Computer");
		add(computerPlayButton);
		computerPlayButton.setBounds(275, 735, 150, 20);
		
		JButton rollDiceButton = new JButton("Roll Dice"); 
		add(rollDiceButton);
		rollDiceButton.setBounds(250, 500, 200, 80);
//		rollDiceButton.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//            	diceValueLabel.setText("\rollDice");
//            	}
//		});
            
            
		JLabel mainFrameLabel = new JLabel();
		add(mainFrameLabel, BorderLayout.CENTER);
	
		JLabel diceTitleLabel = new JLabel();	
	    mainFrameLabel.add(diceTitleLabel);
	    diceTitleLabel.setFont(new Font("Serif", Font.PLAIN, 35));
	    diceTitleLabel.setBounds(275, 0, 200, 700);
	    diceTitleLabel.setText("Dice Value");
		
	    JLabel diceValueLabel = new JLabel();	
	    mainFrameLabel.add(diceValueLabel);
	    diceValueLabel.setFont(new Font("Serif", Font.PLAIN, 70));
		diceValueLabel.setBounds(335, 50, 200, 700);
		diceValueLabel.setText("0");
		
		JLabel player1ScoreTitleLabel = new JLabel();
		mainFrameLabel.add(player1ScoreTitleLabel);
		player1ScoreTitleLabel.setFont(new Font("Serif", Font.PLAIN, 35));
		player1ScoreTitleLabel.setBounds(30, 100, 200, 700);
		player1ScoreTitleLabel.setText("Player One");

		JLabel player1ScoreLabel = new JLabel();
		mainFrameLabel.add(player1ScoreLabel);
		player1ScoreLabel.setFont(new Font("Serif", Font.PLAIN, 100));
		player1ScoreLabel.setBounds(75, 100, 200, 900);
		player1ScoreLabel.setText("0");
		
		JLabel player2ScoreTitleLabel = new JLabel();
		mainFrameLabel.add(player2ScoreTitleLabel);
		player2ScoreTitleLabel.setFont(new Font("Serif", Font.PLAIN, 35));
		player2ScoreTitleLabel.setBounds(500, 100, 800, 700);
		player2ScoreTitleLabel.setText("Player Two");
		
		JLabel player2ScoreLabel = new JLabel();
		mainFrameLabel.add(player2ScoreLabel);
		player2ScoreLabel.setFont(new Font("Serif", Font.PLAIN, 100));
		player2ScoreLabel.setBounds(550, 100, 200, 900);
		player2ScoreLabel.setText("0");
		
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

	public int rollDice() {
		
		Random rand = new Random();
		
		int randomInt = rand.nextInt(5);
		
		return randomInt;
	
	}
}
