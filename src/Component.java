import java.awt.*;

/**
 * Creates a component that will be used for graphical and functional uses
 * when instantiated, gives an object that has coordinates and dimensions
 */
public class Component {
    int width;
    int height;
    protected int initialX;
    protected int initialY;
    protected Color color;

    protected Rectangle body;


    /**
     * Instantiates a new Component.
     *
     * @param initialX the initial x coordinate of the components
     * @param initialY the initial y coordinate of the components
     * @param width    the width of the components
     * @param height   the height of the components
     * @param color    the color of the components
     */
    Component(int initialX, int initialY, int width, int height, Color color){
        body = new Rectangle(width, height);
        this.width = width;
        this.height = height;
        this.initialX = initialX;
        this.initialY= initialY;
        this.color = color;
        setInitialPosition();
    }

    /**
     * Allows access to the body of the component from other classes, and thus to its location to paint it or to check possible collisions
     *
     * @return the body of the component
     */
    public Rectangle getBody() {
        return body;
    }

    /**
     * Puts the components, or more concretely, its body, to the initial coordinates specified while initializing it
     */
    public void setInitialPosition(){
        body.setLocation(initialX, initialY);
    }

    public Color getColor() {
        return color;
    }
}
