//Jeffrey Marple's implementation of the classic game, Pass the Pigs

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Random;

public class GameOfPig extends JFrame {

	int currentTurnValue = 0;
	boolean player1Turn = true;
	boolean player2Turn = false;
	boolean computerPlayer = false;

	public static void main(String[] args) {

		new GameOfPig();

	}

	// Main window call that generates GUI
	public GameOfPig() {

		super("Pig Game");

		JButton computerPlayButton = new JButton("Play Computer");
		add(computerPlayButton);
		computerPlayButton.setBounds(125, 590, 150, 20);

		JButton rollDiceButton = new JButton("Roll Dice");
		add(rollDiceButton);
		rollDiceButton.setBounds(75, 500, 200, 80);

		JButton passPigsButton = new JButton("Pass Pigs");
		add(passPigsButton);
		passPigsButton.setBounds(325, 500, 200, 80);

		JButton newGameButton = new JButton("New Game");
		add(newGameButton);
		newGameButton.setBounds(325, 590, 150, 20);
		
		JLabel mainFrameLabel = new JLabel();
		add(mainFrameLabel, BorderLayout.CENTER);

		JLabel titleLabel = new JLabel();
		mainFrameLabel.add(titleLabel);
		titleLabel.setText("Pass the Pigs");
		titleLabel.setBackground(Color.red);
	//	titleLabel.setOpaque(true);
		titleLabel.setForeground(Color.pink);
		titleLabel.setBounds(140, 5, 350, 70);
		titleLabel.setFont(new Font("Serif", Font.BOLD, 60));
		
		JLabel diceTitleLabel = new JLabel();
		mainFrameLabel.add(diceTitleLabel);
		diceTitleLabel.setFont(new Font("Serif", Font.PLAIN, 35));
		diceTitleLabel.setBounds(210, 345, 175, 50);
		diceTitleLabel.setText("Dice Value");
		diceTitleLabel.setHorizontalAlignment(JLabel.CENTER);
		diceTitleLabel.setBackground(Color.red);
		diceTitleLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));

		//diceTitleLabel.setOpaque(true);
		
		JLabel diceValueLabel = new JLabel();
		mainFrameLabel.add(diceValueLabel);
		diceValueLabel.setFont(new Font("Serif", Font.PLAIN, 70));
		diceValueLabel.setHorizontalAlignment(JLabel.CENTER);
		diceValueLabel.setVerticalAlignment(JLabel.CENTER);
		diceValueLabel.setBounds(272, 400, 60, 70);
		diceValueLabel.setText("0");
		diceValueLabel.setBackground(Color.blue);
		//diceValueLabel.setOpaque(true);

		JLabel currentTurnScoreLabel = new JLabel();
		mainFrameLabel.add(currentTurnScoreLabel);
		currentTurnScoreLabel.setFont(new Font("Serif", Font.PLAIN, 70));
		currentTurnScoreLabel.setBounds(260, 250, 80, 70);
		currentTurnScoreLabel.setText("0");
		currentTurnScoreLabel.setHorizontalAlignment(JLabel.CENTER);
		currentTurnScoreLabel.setVerticalAlignment(JLabel.CENTER);
		//currentTurnScoreLabel.setBackground(Color.green);
		currentTurnScoreLabel.setOpaque(true);

		JLabel turnScoreTitleLabel = new JLabel();
		mainFrameLabel.add(turnScoreTitleLabel);
		turnScoreTitleLabel.setFont(new Font("Serif", Font.PLAIN, 40));
		turnScoreTitleLabel.setBounds(200, 200, 200, 50);
		turnScoreTitleLabel.setHorizontalAlignment(JLabel.CENTER);
		turnScoreTitleLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		turnScoreTitleLabel.setText("Turn Score");
		turnScoreTitleLabel.setHorizontalAlignment(mainFrameLabel.CENTER);

		
		
		
		JLabel player1ScoreTitleLabel = new JLabel();
		mainFrameLabel.add(player1ScoreTitleLabel);
		player1ScoreTitleLabel.setFont(new Font("Serif", Font.PLAIN, 35));
		player1ScoreTitleLabel.setBounds(45, 90, 175, 50);
		player1ScoreTitleLabel.setHorizontalAlignment(JLabel.CENTER);
		player1ScoreTitleLabel.setText("Player 1");
		player1ScoreTitleLabel.setBackground(Color.pink);
		player1ScoreTitleLabel.setBorder(BorderFactory.createLineBorder(Color.black));

		
		JLabel player1ScoreLabel = new JLabel();
		mainFrameLabel.add(player1ScoreLabel);
		player1ScoreLabel.setFont(new Font("Serif", Font.PLAIN, 100));
	    player1ScoreLabel.setHorizontalAlignment(JLabel.CENTER);
		player1ScoreLabel.setBounds(80, 138, 110, 100);
		player1ScoreLabel.setText("0");
		player1ScoreLabel.setBorder(BorderFactory.createLineBorder(Color.black));

		JLabel player2ScoreTitleLabel = new JLabel();
		mainFrameLabel.add(player2ScoreTitleLabel);
		player2ScoreTitleLabel.setFont(new Font("Serif", Font.PLAIN, 35));
		player2ScoreTitleLabel.setBounds(380, 90, 185, 50);
		player2ScoreTitleLabel.setText("Player 2");
		player2ScoreTitleLabel.setHorizontalAlignment(JLabel.CENTER);
		player2ScoreTitleLabel.setBackground(Color.gray);
		player2ScoreTitleLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel player2ScoreLabel = new JLabel();
		mainFrameLabel.add(player2ScoreLabel);
		player2ScoreLabel.setFont(new Font("Serif", Font.PLAIN, 100));
		player2ScoreLabel.setBounds(420, 138, 110, 100);
	    player2ScoreLabel.setHorizontalAlignment(JLabel.CENTER);
		player2ScoreLabel.setText("0");
		player2ScoreLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		player1ScoreLabel.setBackground(Color.pink);
		player2ScoreLabel.setBackground(Color.gray);
		player2ScoreLabel.setOpaque(true);
		player1ScoreLabel.setOpaque(true);

		player1ScoreTitleLabel.setOpaque(true);
		player2ScoreTitleLabel.setOpaque(true);

		setResizable(false);

		
		// ROLL DICE BUTTON
		rollDiceButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int diceValue = rollDice();

				// Pig out if check
				diceValueLabel.setText(Integer.toString(diceValue));
				if (diceValue != 1) {
					currentTurnValue = currentTurnValue + diceValue;
					currentTurnScoreLabel.setText(Integer.toString(currentTurnValue));

				} else {

					if (player1Turn) {

						JOptionPane.showMessageDialog(mainFrameLabel, "OINK OINK! PLAYER 1 PIGGED OUT!");
						player2ScoreLabel.setBackground(Color.pink);
						player2ScoreTitleLabel.setBackground(Color.pink);
						player1ScoreLabel.setBackground(Color.gray);
						player1ScoreTitleLabel.setBackground(Color.gray);
						
					} else {

						JOptionPane.showMessageDialog(mainFrameLabel, "OINK OINK! PLAYER 2 PIGGED OUT!");
						player2ScoreLabel.setBackground(Color.gray);
						player2ScoreTitleLabel.setBackground(Color.gray);
						player1ScoreLabel.setBackground(Color.pink);
						player1ScoreTitleLabel.setBackground(Color.pink);					}

					swapTurn();
					currentTurnScoreLabel.setText("0");
				}

			}
		});
		// END ROLL BUTTON

		// PASS PIGS BUTTON
		passPigsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (player1Turn) {

					player1ScoreLabel.setText(
							Integer.toString(Integer.parseInt(player1ScoreLabel.getText()) + currentTurnValue));
					currentTurnValue = 0;
					currentTurnScoreLabel.setText("0");
					// Win check
					if (Integer.parseInt(player1ScoreLabel.getText()) >= 100) {
						JOptionPane.showMessageDialog(mainFrameLabel, "Congratulaions! Player 1 Wins!!!");

					}
					player2ScoreLabel.setBackground(Color.pink);
					player2ScoreTitleLabel.setBackground(Color.pink);
					player1ScoreLabel.setBackground(Color.gray);
					player1ScoreTitleLabel.setBackground(Color.gray);
					player2ScoreLabel.setOpaque(true);
					player1ScoreLabel.setOpaque(true);
					player2ScoreTitleLabel.setOpaque(true);
					player1ScoreTitleLabel.setOpaque(true);
					swapTurn();

				} else {

					player2ScoreLabel.setText(
							Integer.toString(Integer.parseInt(player2ScoreLabel.getText()) + currentTurnValue));
					currentTurnValue = 0;
					currentTurnScoreLabel.setText("0");

					// Win Check
					if (Integer.parseInt(player2ScoreLabel.getText()) >= 100) {
						JOptionPane.showMessageDialog(mainFrameLabel, "Congratulaions! Player 2 Wins!!!");

					}

					player2ScoreLabel.setBackground(Color.gray);
					player2ScoreTitleLabel.setBackground(Color.gray);
					player1ScoreLabel.setBackground(Color.pink);
					player1ScoreTitleLabel.setBackground(Color.pink);
					player2ScoreLabel.setOpaque(true);
					player1ScoreLabel.setOpaque(true);
					player2ScoreTitleLabel.setOpaque(true);
					player1ScoreTitleLabel.setOpaque(true);
				
					swapTurn();

				}

			}
		});// END PASS BUTTON

		super.setSize(620, 650);

		setVisible(true);

		// fully close when exit
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

	}// END GameOfPig()

	public void swapTurn() {
		if (player1Turn) {
			player1Turn = false;
			player2Turn = true;

		} else {
			player1Turn = true;
			player2Turn = false;
		}
		currentTurnValue = 0;

	}

	public int rollDice() {
		Random rand = new Random();
		int randomInt = rand.nextInt(5) + 1;
		return randomInt;

	}// END rollDice()

}// END GameOfPig class
