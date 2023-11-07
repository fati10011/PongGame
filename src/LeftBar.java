import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * The type Left bar that is instantiated as a player in the Game class
 */
public class LeftBar extends Bar{


    //set initial coordinates to the left center of the game frame
    public static final int INITIAL_X = 30;
    public static final int INITIAL_Y = Game.getGameHeight() / 2 - Bar.getBarHeight() / 2;

    public LeftBar() {
        super(INITIAL_X, INITIAL_Y, Color.RED);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    //reads the keyboard keystrokes to move the bar accordingly
    @Override
    public void keyPressed(KeyEvent e) {
        int keyStroke = e.getKeyCode();
        if (keyStroke == KeyEvent.VK_W) {
            moveUp();
        } else if (keyStroke == KeyEvent.VK_S) {
            moveDown();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
