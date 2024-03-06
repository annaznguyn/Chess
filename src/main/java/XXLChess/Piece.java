package XXLChess;

import java.util.ArrayList;
import processing.core.*;


public abstract class Piece extends Sprite {

    protected String name;
    protected double value;
    protected String player;

    protected int darkBlue = 0xFFAAD2DD;
    protected int lightBlue = 0xFFC4E0E8;
    protected int lightRed = 0xFFFFA466;

    protected boolean isLightBlue;

    protected int startXCoordinate;
    protected int startYCoordinate;

    private boolean moved;

    protected ArrayList<Rect> oppAllPossibleMoves;
    
    public Piece(int x, int y, PImage image, String name, double value, String player) {
        super(x, y, image);
        this.name = name;
        this.value = value;
        this.player = player;

        this.startXCoordinate = x;
        this.startYCoordinate = y;

        this.moved = false;
    }

    /**
     * @param arrayList
     * An array list storing all the possible moves of opponent to be set.
     * Set the arrar list storing all the possible moves of opponent to the given array.
     */
    public void setAllPossibleMoves(ArrayList<Rect> arrayList) {
        this.oppAllPossibleMoves = arrayList;
    }

    /**
     * @return boolean
     * Returns true if the piece has being moved.
     */
    public boolean hasBeingMoved() {
        return this.moved;
    }

    /**
     * @param b
     * The boolean indicating of the piece has being moved before.
     * Set the boolean value to indicate if the piece has being moved.
     */
    public void setMoved(boolean b) {
        this.moved = b;
    }

    /**
     * @return int
     * Return the original x coordinate.
     */
    public int getStartXCoor() {
        return this.startXCoordinate;
    }

    /**
     * @return int
     * Return the original y coordinate.
     */
    public int getStartYCoor() {
        return this.startYCoordinate;
    }

    /**
     * @return name
     * Return the name of the piece.
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return value
     * Return the value of the piece.
     */
    public double getValue() {
        return this.value;
    }

    /**
     * @return player
     * Return which player the piece belongs to.
     */
    public String getPlayer() {
        return this.player;
    }

    /** 
     * @param xToMoveTo
     * The x coordinate of the tile we want to move to.
     * @param yToMoveTo
     * The y coordinate of the tile we want to move to.
     * @param xSpeed
     * Speed to move the x coordinate to the destination.
     * @param ySpeed
     * Speed to move the y coordinate to the destination.
     * Move the x, y coordinates by the given speed to the given destination.
     */
    public void tick(int xToMoveTo, int yToMoveTo, double xSpeed, double ySpeed) {
        // going right or left
        if ((xSpeed < 0 && this.x - xSpeed > xToMoveTo)
        || (xSpeed > 0 && this.x - xSpeed < xToMoveTo)) {
            this.x = xToMoveTo;
        }
        // going up or down
        if ((ySpeed > 0 && this.y - ySpeed < yToMoveTo)
        || (ySpeed < 0 && this.y - ySpeed > yToMoveTo)) {
            this.y = yToMoveTo;
        }
    
        if (this.x != xToMoveTo) {
            this.x -= xSpeed;
        }
        if (this.y != yToMoveTo)
            this.y -= ySpeed;
    }

    /**
     * @return boolean
     * Returns true if the piece belongs to human player.
     */
    public boolean isHumanPiece() {
        if (this.player.equals("human"))
            return true;
        return false;
    }

    /**
     * @param ourPieces
     * An array list storing the pieces of allie side.
     * @param opponentPieces
     * An array list storing the pieces of opponent side.
     * @param tiles
     * An array list storing the tiles of the board.
     * @return an array list of possible moves
     * An abtract method to get an array list storing the possible and valid moves of the piece.
     */
    public abstract ArrayList<Rect> getPossibleMoves(ArrayList<Piece> ourPieces, ArrayList<Piece> opponentPieces, ArrayList<Rect> tiles);

    /**
     * @param tiles
     * An array list storing the tiles of the board.
     * @param x
     * The x coordinate of the tile we want to get.
     * @param y
     * The y coordinate of the tile we want to get.
     * @return tile
     * Return the tile with the given coordinates.
     */
    public Rect getTile(ArrayList<Rect> tiles, int x, int y) {
        Rect rect = tiles.get(0);
        for (Rect r : tiles) {
            if (r.getX() == x && r.getY() == y) {
                rect = r;
                break;
            }
        }
        return rect;
    }
}
