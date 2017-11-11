import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.util.Arrays;

import javax.swing.JButton;
import java.awt.event.MouseEvent;

public class BoardFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, scoreBoard;
	private Square[][] panels = new Square[12][12];
	private boolean isX;
	private int xScore, oScore;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoardFrame frame = new BoardFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public BoardFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 800);
		setTitle("Tic Tac Toe on Mines!");
		contentPane = createBoard();
		scoreBoard = createScoreBoard();
		setUpMines();
		setUpSigns();
		add(contentPane, BorderLayout.CENTER);
		add(scoreBoard, BorderLayout.EAST);
		System.out.println(Arrays.toString(shuffleBoard()));

	}
	
	/**
	 * Create a score board. If a player step to a mine, other players gain a point
	 * @return a JPanel contains score of 2 players
	 */
	private JPanel createScoreBoard() {
		return null;
	}

	/**
	 * Create a 10x10 board
	 * @return JPanel object of that board
	 */
	private JPanel createBoard() {
		JPanel board = new JPanel();
		board.setLayout(new GridLayout(12, 12));
		
		int color = 0;
		
		MouseListener listener = new CreateSquareListener();
		
		for (int i = 0; i < 12; i++){
			for (int j = 0; j < 12; j++){
				panels[i][j] = new Square(i, j);
				if (color % 2 == 0)
					panels[i][j].setBackground(new Color(188, 143, 143));
				color++;
				panels[i][j].addMouseListener(listener);
				board.add(panels[i][j]);
			}
			color++;
		}
		return board;
	}
	
	/**
	 * Set up the mines to some panels in the field.
	 */
	private void setUpMines() {
		Square[] positionsWithMines = shuffleBoard();
		//change the sign of the square with mines in it
		for (int i = 0; i < positionsWithMines.length; i++){
			positionsWithMines[i].setSign(-1);
		}
	}
	/**
	 * Set up the signs to every panels in the field.
	 */
	private void setUpSigns() {
		for (int i = 0; i < panels.length; i++){
			for (int j = 0; j < panels.length; j++){
				int sign = 0;
				Square s = panels[i][j];
				if (s.getSign() != -1){
					if (i != 0 && j != 0 && isMine(panels[i - 1][j - 1]))
						sign++;
					if (i != 0 && isMine(panels[i - 1][j]))
						sign++;
					if (i != 0 && j != 11 && isMine(panels[i - 1][j + 1]))
						sign++;
					if (j != 0 && isMine(panels[i][j - 1]))
						sign++;
					if (j != 11 && isMine(panels[i][j + 1]))
						sign++;
					if (i != 11 && j != 0 && isMine(panels[i + 1][j - 1]))
						sign++;
					if (i != 11 && isMine(panels[i + 1][j]))
						sign++;
					if (i != 11 && j != 11 && isMine(panels[i + 1][j + 1]))
						sign++;
					s.setSign(sign);
				}
			}
		}
	}
	
	/**
	 * Check if a panel contains mine
	 * @param s the panel
	 * @return true if the panel has mine, false otherwise
	 */
	private boolean isMine (Square s){
		if (s.getSign() == -1)
			return true;
		return false;
	}
	
	/**
	 * Shuffle the board using modern Fisher-Yates shuffle algorithm.
	 * @return the new 2-D array of the shuffled board
	 */
	private Square[] shuffleBoard() {
		Square[][] copyOfPanels = new Square[12][12];
		for (int i = 0; i < 12; i++){
			for (int j = 0; j < 12; j++){
				copyOfPanels[i][j] = panels[i][j];
			}
		}
		Square[] result = new Square[16];
		int length = 0;
		//go through the array, random choosing an item an swap that with the previous items.
		for (int i = 0; i < 12; i++){
			for (int j = 0; j < 12; j++){
				int randI = (int) (Math.random()*(12 - i) + i);
				int randJ = (int) (Math.random()*(12 - j) + j);
				if (length < 16){
					result[length] = copyOfPanels[randI][randJ];
					//swap 2 Square
					Square temp = copyOfPanels[i][j];
					copyOfPanels[i][j] = copyOfPanels[randI][randJ];
					copyOfPanels[randI][randJ] = temp;
				}
				
				length++;
			}
		}
		return result;
	}

	class CreateSquareListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			Square item = (Square) e.getSource();
			int i = item.getI();
			int j = item.getJ();
			Component[] components = panels[i][j].getComponents();
			if (components.length == 0){
				isX = !isX;
				int sign = item.getSign();
				if (sign == -1){
					panels[i][j].setBackground(Color.red);
				}
				else{
					if (isX)
						panels[i][j].add(new JLabel("X/" + sign));
					else
						panels[i][j].add(new JLabel("O/" + sign));
				}
				
			}
			panels[i][j].revalidate();
			panels[i][j].repaint();
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}
		@Override
		public void mouseReleased(MouseEvent e) {
		}
		@Override
		public void mouseEntered(MouseEvent e) {
		}
		@Override
		public void mouseExited(MouseEvent e) {
		}
		
	}

}
