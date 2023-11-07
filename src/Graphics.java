import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * A JPanel that has all the graphical components of the game
 * Provide methods to paint them in the gameframe
 */
public class Graphics extends JPanel implements ActionListener {

    private ArrayList<Component> graphicalRectComponents = new ArrayList<>();
    private ArrayList<Component> graphicalOvalComponents = new ArrayList<>();
    private Game game;
    private final Font font = new Font("Courier New", Font.BOLD, 20);
    private String state;


    /**
     * Instantiates a new Graphics, and adds the graphical components according to their type
     * creates arraylists that contain the components that are to be painted
     *
     * @param g the Game to which the graphics belong
     */
    public Graphics(Game g){
        Timer t = new Timer(25, this);
        t.start();
        this.game = g;

        graphicalRectComponents.add(new Component(0, 0, Game.getGameWidth() + 5, Game.getGameHeight() + 5, Color.BLACK));
        graphicalRectComponents.add(g.player2);
        graphicalRectComponents.add(g.player1);

        graphicalOvalComponents.add(new Component(Game.getGameWidth() /2 - 120, Game.getGameHeight() /2 - 120, 240, 240, Color.white));
        graphicalOvalComponents.add(new Component(Game.getGameWidth() /2 - 118, Game.getGameHeight() /2 - 118, 236, 236, Color.BLACK));
        graphicalOvalComponents.add(g.ball);

        state = "PLAYING";

        this.addKeyListener(g.player1);
        this.addKeyListener(g.player2);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(java.awt.Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        if(state.equals("PLAYING")) {
            paintComponentsWhilePlaying(g2d);
        } else if (state.equals("GAME_OVER")) {
            paintGameOverComponents(g2d);
        }

    }

    /**
     * Paint components while playing according to their graphical shape
     * Paints the live score of the game
     *
     * @param g2d the Graphics2D to which the components are intended to be painted
     */
    public void paintComponentsWhilePlaying(Graphics2D g2d){
        for (Component c : graphicalRectComponents) {
            g2d.setColor(c.getColor());
            g2d.fillRect(c.getBody().x, c.getBody().y, c.width, c.height);
        }

        g2d.setColor(Color.white);
        g2d.drawLine(Game.getGameWidth() / 2, 0, Game.getGameWidth() / 2, Game.getGameHeight());

        for (Component c : graphicalOvalComponents) {
            g2d.setColor(c.getColor());
            g2d.fillOval(c.getBody().x, c.getBody().y, c.width, c.height);
        }

        g2d.setFont(font);
        g2d.setColor(Color.white);
        g2d.drawString(game.getP1Score() + "       " + game.getP2Score(), Game.getGameWidth() / 2 - 27, 50);
    }

    /**
     * Paint game over components: the winner player
     *
     * @param g2d the Graphics2D to which the components are intended to be painted
     */
    public void paintGameOverComponents(Graphics2D g2d){
        String gameOverMessage = "player " + game.checkWinner() + " won.";
        FontMetrics metrics = getFontMetrics(font);

        //center the Game Over text
        int x = (Game.getGameWidth() - metrics.stringWidth(gameOverMessage)) / 2;
        int y = ((Game.getGameHeight() - metrics.getHeight()) / 2) + metrics.getAscent();

        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, Game.getGameWidth() + 5, Game.getGameHeight() + 5);
        g2d.setFont(font);
        g2d.setColor(Color.white);
        g2d.drawString(gameOverMessage, x, y);
    }

    public void setState(String state) {
        this.state = state;
    }

    //updates the graphics of the game while playing every iteration of the Timer
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!state.equals("GAME_OVER")) {
            game.update();
            repaint();
        }
    }
}
