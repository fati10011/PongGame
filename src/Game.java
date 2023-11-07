import javax.swing.*;
import java.awt.*;

/**
 * Instantiates the other classes and sets the structure of the
 * game; it is responsible for defining weather the game is ongoing or has stopped creates the game frame
 * and maintains the grouped operating of all the classes: contains the core program
 */
public class Game{

    private static final int GAME_HEIGHT = 600;
    private static final int GAME_WIDTH = 900;

    LeftBar player1 = new LeftBar();
    RightBar player2 = new RightBar();
    Ball ball = new Ball("RIGHT");
    private Graphics graphics;

    private int player1Score = 0;
    private int player2Score = 0;

    public Game() {

        JFrame gameFrame = new JFrame("Pong 2 Players  v1.0");
        graphics = new Graphics(this);

        gameFrame.add(graphics);

        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        gameFrame.setLocation(screenDimension.width/2- GAME_WIDTH/2, screenDimension.height/2-GAME_HEIGHT/2);

        gameFrame.setResizable(true);
        gameFrame.setSize(GAME_WIDTH, GAME_HEIGHT + 40);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);
    }

    /**
     * increments the score of the player
     * checks the end of the game to change the graphics state accordingly
     * moves the ball
     */
    public void update(){
        if (ball.checkPlayer1point()){
            player1Score ++;
            ball.setInitialPosition();
        } else if (ball.checkPlayer2point()){
            player2Score ++;
            ball.setInitialPosition();
        }
        if (checkWinner() != 0) graphics.setState("GAME_OVER");

        ball.manageCollisions(this);
        ball.moveStraight();
    }


    /**
     * Check which one of the players has scored 7 points first and assign it as a winner
     *
     * @return the number of the winner player
     */
    public int checkWinner() {
        int winner = 0;
        if (player1Score == 7) winner = 1;
        else if (player2Score == 7) winner = 2;

        return winner;
    }


    /**
     * Getter for the height of the game frame
     *
     * @return the int GAME_HEIGHT
     */
    public static int getGameHeight(){
        return GAME_HEIGHT;
    }

    /**
     * Getter for the width of the game frame
     *
     * @return the int GAME_WIDTH
     */
    public static int getGameWidth() {
        return GAME_WIDTH;
    }

    /**
     * Gets the score of the player number 1
     *
     * @return the int player1Score
     */
    public int getP1Score() {
        return player1Score;
    }

    /**
     * Gets the score of the player number 2
     *
     * @return the int player2Score
     */
    public int getP2Score() {
        return player2Score;
    }

    /**
     * The entry point of application:
     * set the opengl property to true to avoid graphical lag in linux based systems due to the keyListener
     * creates a new instance of the Game Class
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        System.setProperty("sun.java2d.opengl", "true");
        new Game();
    }
}
