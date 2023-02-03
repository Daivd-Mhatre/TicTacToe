import javax.swing.*;
import java.awt.*;

/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

public class Square {

    private String marker;
    private int row;
    private int col;
    private boolean isWinningSquare;

    private Image O;
    private Image X;

    TicTacToeViewer board;

    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col, TicTacToeViewer board) {
        this.row = row;
        this.col = col;
        O = new ImageIcon("Resources/O.png").getImage();
        X = new ImageIcon("Resources/X.png").getImage();
        this.board = board;
        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;
    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }

    public void draw(Graphics g){
        if (isWinningSquare == true){
            g.setColor(Color.GREEN);
            g.fillRect((col * 100) + 150, (row * 100) + 150,100, 100);
        }
        if (marker.equals("X")){
            g.drawImage(X, (col * 100) + 150, (row * 100) + 150,100, 100, board);
        }
        if (marker.equals("O")){
            g.drawImage(O, (col * 100) + 150, (row * 100) + 150,100,100, board);
        }
    }
}
