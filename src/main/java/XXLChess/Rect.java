package XXLChess;

import processing.core.*;

public class Rect extends Sprite {

    private int color;
    private int originalColor;

    public Rect(int x, int y, int color) {
        super(x, y);
        this.color = color;
        this.originalColor = color;
    }

    /**
     * @return int
     * Return the original color of the tile.
     */
    public int getOriginalColor() {
        return this.originalColor;
    }

    /**
     * @return int
     * Return the current color of the tile.
     */
    public int getColor() {
        return this.color;
    }

    /**
     * @param color
     * The color to be change to.
     * Change the color of the tile to the given color.
     */
    public void changeColor(int color) {
        this.color = color;
    }

    /**
     * @param app
     * The app which we display everything of the game.
     * Draw the rectangular tile on the app.
     */
    public void drawRect(PApplet app) {
        app.fill(this.color);
        app.noStroke();
        app.rect(this.getX(), this.getY(), CELLSIZE, CELLSIZE);
    }

}
