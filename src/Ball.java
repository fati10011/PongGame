import java.awt.*;

/**
 * @author : FZF
 * @version : v01.1
 */

/**
 * Can be instantiated as an object with a rectangle body that will be displayed as an oval
 * The ball implements the interface of a moving object so, it can change location inside the game frame
 * It allows to check collisions with the edges or with other components of the game frame
 */
public class Ball extends Component implements MovingObject {
    private static final int DIMENSION = 30;
    private static final int INITIAL_X = Game.getGameWidth() / 2 - DIMENSION / 2;
    private static final int INITIAL_Y = Game.getGameHeight() / 2 - DIMENSION / 2;
    /**
     * Int used to increment or decrement the ball position on the x-axis and thus moving it right or left
     */
    public int movementX;
    /**
     * Int used to increment or decrement the ball position on the y-axis and thus moving it up or down
     */
    public int movementY;
    /**
     * Constant integer used to control the moving of the ball by a quarter of the movement rate indicated in the interface
     */
    public static final int MOVEMENT_UNIT = MOVEMENT_RATE/4;


    /**
     * Instantiates a new Ball.
     *
     * @param direction string that control the initial direction of the ball when created
     */
    public Ball(String direction) {
        super(INITIAL_X, INITIAL_Y, DIMENSION, DIMENSION, Color.GREEN);
        if (direction.equals("RIGHT")) {
            moveUp();
            moveRight();
        } else {
            moveUp();
            moveLeft();
        }
    }

    /**
     * Check collision with the upper edge of the game frame
     *
     * @return a boolean accordingly
     */
    public boolean checkUpperEdgeCollision() {
        return body.y <= 0;
    }

    /**
     *  Check collision with the lower edge of the game frame
     *
     * @return a boolean accordingly
     */
    public boolean checkLowerEdgeCollision() {
        return body.y + DIMENSION >= Game.getGameHeight();
    }

    /**
     * Check collision with the right edge of the game frame
     *
     * @return whether it is a point for the player 1 or not
     */
    public boolean checkPlayer1point() {
        return (body.x + DIMENSION >= Game.getGameWidth());
    }

    /**
     * Check collision with the left edge of the game frame
     *
     * @return whether it is a point for the player 2 or not
     */
    public boolean checkPlayer2point() {
        return (body.x <= 0);
    }

    /**
     * Moves the ball according to the occurred collision
     *
     * @param g the game to which the collisions belong
     */
    public void manageCollisions(Game g) {
        if (checkUpperEdgeCollision()) {
            moveDown();
        } else if (checkLowerEdgeCollision()) {
            moveUp();
        }
        if (checkLeftBarCollision(g.player1)) {
            moveRight();
        } else if (checkRightBarCollision(g.player2)) {
            moveLeft();
        }
    }

    /**
     * Check left bar collision boolean.
     *
     * @param bar the left bar
     * @return the boolean accordingly
     */
    public boolean checkLeftBarCollision(LeftBar bar) {
        return bar.body.contains(body.x + DIMENSION, body.y + DIMENSION) ||
                bar.body.contains(body.x, body.y);
    }

    /**
     * Check right bar collision boolean.
     *
     * @param bar the right bar
     * @return the boolean accordingly
     */
    public boolean checkRightBarCollision(RightBar bar) {
        return bar.body.contains(body.x + DIMENSION, body.y + DIMENSION) ||
                bar.body.contains(body.x + DIMENSION, body.y);
    }

    /**
     * Keeps the ball in a straight movement by changing its body coordinates statically
     */
    public void moveStraight() {
        body.setLocation(body.x + movementX, body.y + movementY);
    }

    @Override
    public void moveUp() {
        movementY = -MOVEMENT_UNIT;
    }

    @Override
    public void moveDown() {
        movementY = MOVEMENT_UNIT;
    }

    @Override
    public void moveLeft() {
        movementX = -MOVEMENT_UNIT;
    }

    @Override
    public void moveRight() {
        movementX = MOVEMENT_UNIT;
    }
}
