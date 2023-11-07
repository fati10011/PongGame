import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * The type Right bar that is instantiated as a player in the Game class
 */
public class RightBar extends Bar{

    //set initial coordinates to the right center of the game frame
    public static final int INITIAL_X = Game.getGameWidth() - 30 - getBarWidth();
    public static final int INITIAL_Y = Game.getGameHeight() / 2 - Bar.getBarHeight() / 2;

    public RightBar() {
        super(INITIAL_X, INITIAL_Y, Color.BLUE);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    //reads the keyboard keystrokes to move the bar accordingly
    @Override
    public void keyPressed(KeyEvent e) {
        int keyStroke = e.getKeyCode();
        if (keyStroke == KeyEvent.VK_UP) {
            moveUp();
        } else if (keyStroke == KeyEvent.VK_DOWN) {
            moveDown();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
