/**
 * When implemented, Gives the object the necessary methods to move and a constant for that movement
 */
public interface MovingObject {
    /**
     * The constant that manages the speed of movement of the moving components
     */
    int MOVEMENT_RATE = 20;

    /**
     * Methods that allow any MovingObject to move withing the game frame in the four directions
     */
    void moveUp();
    void moveDown();
    void moveLeft();
    void moveRight();
}
