package XXLChess;

import processing.core.*;

public class Sprite {
    
    protected int x;
    protected int y;

    protected int CELLSIZE = 48;
    protected int BOARD_WIDTH = 14;

    protected PImage image;

    public Sprite(int x, int y, PImage image) {
        this.x = x;
        this.y = y;
        this.image = image;
    }

    public Sprite(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /** 
     * @return int
     * Return the x coordinate.
     */
    public int getX() {
        return this.x;
    }

    /** 
     * @return int
     * Return the y coordinate.
     */
    public int getY() {
        return this.y;
    }

    /** 
     * @param x
     * The x coordinate to be set.
     * Set the x coordinate to the given x.
     */
    public void setX(int x) {
        this.x = x;
    }

    /** 
     * @param y
     * The y coordinate to be set.
     * Set the y coordinate to the given y.
     */
    public void setY(int y) {
        this.y = y;
    }

    /** 
     * @param app
     * The app which we display everything of the game.
     * Display the image on the app.
     */
    public void draw(PApplet app) {
        app.image(this.image, this.x, this.y, this.CELLSIZE, this.CELLSIZE);
    }
}
