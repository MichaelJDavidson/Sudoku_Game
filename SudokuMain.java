package Java.Sudoku;

import java.awt.*;
import javax.swing.*;

public class SudokuMain extends JFrame {
    private static final long serialVersionUID = 1L;

    GameBoardPanel gamePanel = new GameBoardPanel();
    JButton newGameButton = new JButton("New Game");

    public SudokuMain() {
        Container cp = getContentPane();
        cp.setLayout(new GridLayout());
        cp.add(gamePanel, BorderLayout.CENTER);
        /**
         * Add buttons for re-start game and recursive solve here
         */
        gamePanel.newGame();
        pack();
        setMinimumSize(new Dimension(500, 500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SudokuMain game = new SudokuMain();
    }
}
