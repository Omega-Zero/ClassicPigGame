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
		computerPlayButton.setBounds(275, 735, 150, 20);

		JButton rollDiceButton = new JButton("Roll Dice");
		add(rollDiceButton);
		rollDiceButton.setBounds(250, 500, 200, 80);

		JButton passPigsButton = new JButton("Pass Pigs");
		add(passPigsButton);
		passPigsButton.setBounds(250, 600, 200, 80);

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

		JLabel currentTurnScoreLabel = new JLabel();
		mainFrameLabel.add(currentTurnScoreLabel);
		currentTurnScoreLabel.setFont(new Font("Serif", Font.PLAIN, 70));
		currentTurnScoreLabel.setBounds(335, -100, 200, 700);
		currentTurnScoreLabel.setText("0");

		JLabel turnScoreTitleLabel = new JLabel();
		mainFrameLabel.add(turnScoreTitleLabel);
		turnScoreTitleLabel.setFont(new Font("Serif", Font.PLAIN, 40));
		turnScoreTitleLabel.setBounds(270, -150, 200, 700);
		turnScoreTitleLabel.setText("Turn Score");

		JLabel player1ScoreTitleLabel = new JLabel();
		mainFrameLabel.add(player1ScoreTitleLabel);
		player1ScoreTitleLabel.setFont(new Font("Serif", Font.PLAIN, 35));
		player1ScoreTitleLabel.setBounds(30, 100, 200, 700);
		player1ScoreTitleLabel.setText("Player One");

		JLabel player1ScoreLabel = new JLabel();
		mainFrameLabel.add(player1ScoreLabel);
		player1ScoreLabel.setFont(new Font("Serif", Font.PLAIN, 100));
	    player1ScoreLabel.setHorizontalAlignment(JLabel.CENTER);
		player1ScoreLabel.setBounds(75, 100, 100, 100);
		player1ScoreLabel.setText("0");
		player1ScoreLabel.setBorder(BorderFactory.createLineBorder(Color.black));

		JLabel player2ScoreTitleLabel = new JLabel();
		mainFrameLabel.add(player2ScoreTitleLabel);
		player2ScoreTitleLabel.setFont(new Font("Serif", Font.PLAIN, 35));
		player2ScoreTitleLabel.setBounds(500, 100, 800, 700);
		player2ScoreTitleLabel.setText("Player Two");

		JLabel player2ScoreLabel = new JLabel();
		mainFrameLabel.add(player2ScoreLabel);
		player2ScoreLabel.setFont(new Font("Serif", Font.PLAIN, 100));
		player2ScoreLabel.setBounds(550, 100, 100, 100);
	    player2ScoreLabel.setHorizontalAlignment(JLabel.CENTER);
		player2ScoreLabel.setText("0");
		player2ScoreLabel.setBorder(BorderFactory.createLineBorder(Color.black));

		player1ScoreLabel.setBackground(Color.pink);
		player2ScoreLabel.setBackground(Color.gray);
		player2ScoreLabel.setOpaque(true);
		player1ScoreLabel.setOpaque(true);

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
						player1ScoreLabel.setBackground(Color.gray);
					} else {

						JOptionPane.showMessageDialog(mainFrameLabel, "OINK OINK! PLAYER 2 PIGGED OUT!");
						player1ScoreLabel.setBackground(Color.pink);
						player2ScoreLabel.setBackground(Color.gray);
					}

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
					player1ScoreLabel.setBackground(Color.gray);
					player2ScoreLabel.setOpaque(true);
					player1ScoreLabel.setOpaque(true);
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

					player1ScoreLabel.setBackground(Color.pink);
					player2ScoreLabel.setBackground(Color.gray);
					swapTurn();

				}

			}
		});// END PASS BUTTON

		super.setSize(700, 800);

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
