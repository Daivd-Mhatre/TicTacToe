import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class TicTacToeViewer extends JFrame{
    // TODO: Complete this class
    private final int WINDOW_WIDTH = 750;
    private final int WINDOW_HEIGHT = 750;
    private TicTacToe game;
    public TicTacToeViewer(TicTacToe t){
        game = t;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("TicTacToe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public void paint(Graphics g){
        for(int i=0; i < 3;i++){
            for (int j=0; j < 3;j++){
                this.game.getBoard()[i][j].draw(g);
            }
        }

        g.setColor(Color.BLACK);
        int start = 150;
        int increment = 0;
        int increment2 = 0;
        for (int i=0; i < 3;i++){
            increment = 0;
            for (int j=0; j < 3;j++){
                g.drawRect(start + increment, start + increment2, 100, 100);
                increment += 100;
            }
            increment2 += 100;
        }

        start = 200;
        increment = 0;
        for (int i=1; i < 4;i++){
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.ITALIC, 50));
            g.drawString(String.valueOf(i - 1), 175 + increment, 125);
            increment += 100;
        }

        increment = 0;
        for (int i=1; i < 4;i++){
            g.drawString(String.valueOf(i - 1), 100, 200 + increment);
            increment += 100;
        }
        g.setColor(Color.BLACK);
        if(game.getWinner().equals("O")){
            g.setFont(new Font("Arial", Font.PLAIN, 50));
            g.drawString("O Wins", 200, 500);
        }
        if(game.getWinner().equals("X")){
            g.setFont(new Font("Arial", Font.PLAIN, 50));
            g.drawString("X Wins", 200, 500);
        }

        if(game.checkTie()){
            g.setFont(new Font("Arial", Font.PLAIN, 50));
            g.drawString("It is a Tie", 200, 500);
        }

    }
}
