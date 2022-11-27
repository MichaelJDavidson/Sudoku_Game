package Java.Sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameBoardPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    public static final int GRID_SIZE = 9;
    public static final int SUB_GRID_SIZE = 3;
    public static final int CELL_SIZE = 60;
    public static final int BOARD_WIDTH = GRID_SIZE * GRID_SIZE;
    public static final int BOARD_LENGTH = GRID_SIZE * GRID_SIZE;

    private Cell[][] cells = new Cell[GRID_SIZE][GRID_SIZE];
    private Puzzle puzzle = new Puzzle();

    public GameBoardPanel() {
        super.setLayout(new GridLayout(GRID_SIZE,GRID_SIZE));

        for(int row = 0; row < GRID_SIZE; row++) {
            for(int col = 0; col < GRID_SIZE; col++) {
                cells[row][col] = new Cell(row, col);
                super.add(cells[row][col]);
            }
        }

        CellInputListener listener = new CellInputListener();
        
        for(int row = 0; row < GRID_SIZE; row++){
            for(int col = 0; col < GRID_SIZE; col++){
                if(cells[row][col].isEditable()){
                    cells[row][col].addActionListener(listener); 
                }
            }
        }
    }


    public void newGame(){
        puzzle.newPuzzle(2);
        for(int row = 0; row < GRID_SIZE; row++) {
            for(int col = 0; col < GRID_SIZE; col++) {
                cells[row][col].newGame(puzzle.numbers[row][col], puzzle.isGiven[row][col]);
            }
        }
    }

    public boolean isSolved(){
        for(int row = 0; row < GRID_SIZE; row++) {
            for(int col = 0; col < GRID_SIZE; col++) {
                if(cells[row][col].status == CellStatus.TO_GUESS || cells[row][col].status == CellStatus.WRONG_GUESS) {
                    return false;
                }
            }
        }
        return true;
    }

    private class CellInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent inputEvent) {
            Cell sourceCell = (Cell)inputEvent.getSource();
		 
         // Retrieve the int entered
            int numberIn = Integer.parseInt(sourceCell.getText());
         // For debugging
            System.out.println("You entered " + numberIn);

            /*
          * [TODO 5]
          * Check the numberIn against sourceCell.number.
          * Update the cell status sourceCell.status,
          * and re-paint the cell via sourceCell.paint().
          */
          if (numberIn == sourceCell.number) {
            sourceCell.status = CellStatus.CORRECT_GUESS;
            } else {
                System.out.println("Guess Wrong");
            }
            sourceCell.paint();
        }
    }
}
