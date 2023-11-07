import java.awt.*;
import java.awt.event.KeyListener;

/**
 * An abstract component that is moved by the players using the keyboard
 */
public abstract class Bar extends Component implements MovingObject, KeyListener {

    private static final int BAR_HEIGHT = 100;
    private static final int BAR_WIDTH = 5;

    /**
     * Instantiates a new Bar.
     *
     * @param initialX the initial x of the bar
     * @param initialY the initial y of the bar
     * @param color    the color of the bar
     */
    Bar(int initialX, int initialY, Color color) {
        super(initialX, initialY, BAR_WIDTH, BAR_HEIGHT, color);
    }


    public static int getBarHeight() {
        return BAR_HEIGHT;
    }

    public static int getBarWidth() {
        return BAR_WIDTH;
    }

    @Override
    public void moveUp() {
        if (body.y >= 0) {
            body.setLocation(body.x, body.y - MOVEMENT_RATE);
        }
    }

    @Override
    public void moveDown() {
        if (body.y <= Game.getGameHeight() - BAR_HEIGHT) {
            body.setLocation(body.x, body.y + MOVEMENT_RATE);
        }
    }

    @Override
    public void moveLeft() {

    }

    @Override
    public void moveRight() {

    }
}
