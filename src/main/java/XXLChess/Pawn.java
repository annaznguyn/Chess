package XXLChess;

import processing.core.*;
import java.util.*;

public class Pawn extends Piece {

    private int secondRank;
    private int thirteenthRank;

    public Pawn(int x, int y, String player, PImage image) {
        super(x, y, image, "pawn", 1, player);
        // y-coordinate of the ranks
        this.secondRank = 1;
        this.thirteenthRank = 12;
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
        // going up or down
        if ((ySpeed > 0 && this.y - ySpeed < yToMoveTo) 
        || (ySpeed < 0 && this.y + ySpeed > yToMoveTo)) {
            this.y = yToMoveTo;
        }
        if ((xSpeed > 0 && this.x - xSpeed < xToMoveTo) 
        || (xSpeed < 0 && this.x + xSpeed > xToMoveTo)) {
            this.x = xToMoveTo;
        } 
        if (this.x != xToMoveTo)
            this.x -= xSpeed;
        if (this.y != yToMoveTo) 
            this.y -= ySpeed;
    }

    /** 
     * @param ourPieces
     * An array list storing ally's pieces.
     * @param opponentPieces
     * An array list storing opponent's pieces.
     * @param tiles
     * An array list storing all the tiles of the board.
     * @return tiles
     * Return an array list storing the possible and valid moves of the piece.
     */
    public ArrayList<Rect> getPossibleMoves(ArrayList<Piece> ourPieces, ArrayList<Piece> opponentPieces, ArrayList<Rect> tiles) {
        ArrayList<Rect> possibleMoves = new ArrayList<Rect>();
        // if is in the second row from the bottom
        boolean hasToBreak = false;
        if (this.getY() == this.thirteenthRank * CELLSIZE
            && this.isHumanPiece()) {
                for (int j = 1; j < 3; j++) {
                    for (Piece p : ourPieces) {
                        if (this.getY() - CELLSIZE*j == p.getY()
                        && this.getX() == p.getX()) {
                            hasToBreak = true;
                            break;      
                        }
                    }
                    for (Piece p : opponentPieces) {
                        if (this.getY() - CELLSIZE*j == p.getY()
                        && this.getX() == p.getX()) {
                            hasToBreak = true;
                            break;      
                        }
                    }
                    if (hasToBreak)
                        break;
                    Rect rect = getTile(tiles, this.x, this.y - CELLSIZE*j);
                    if (isHumanPiece()) {
                        if (j == 1)
                            rect.changeColor(darkBlue);
                        else if (j == 2)
                            rect.changeColor(lightBlue);
                    }
                    possibleMoves.add(rect);
                }
        }
        // if is in the second row from the top
        else if (this.getY() == this.secondRank * CELLSIZE
            && !this.isHumanPiece()) {
            hasToBreak = false;
            for (int j = 1; j <= 2; j++) {
                for (Piece p : ourPieces) {
                    if (this.getY() + CELLSIZE*j == p.getY()
                    && this.getX() == p.getX()) {
                        hasToBreak = true;
                        break;      
                    }
                }
                for (Piece p : opponentPieces) {
                    if (this.getY() + CELLSIZE*j == p.getY()
                    && this.getX() == p.getX()) {
                        hasToBreak = true;
                        break;      
                    }
                }
                if (hasToBreak)
                    break;
                Rect rect = getTile(tiles, this.x, this.y + CELLSIZE*j);
                possibleMoves.add(rect);
            }
        }
        else {
            if (this.isHumanPiece()) {
                boolean isBlocked = false;
                for (Piece p : ourPieces) {
                    if (p.getX() == this.x && p.getY() == this.y - CELLSIZE) {
                        isBlocked = true;
                        break;
                    }
                }
                for (Piece p : opponentPieces) {
                    if (p.getX() == this.x && p.getY() == this.y - CELLSIZE) {
                        isBlocked = true;
                        break;
                    }
                }
                if (!isBlocked) {
                    Rect rect = getTile(tiles, this.x, this.y - CELLSIZE);
                    rect.changeColor(darkBlue);
                    possibleMoves.add(rect);
                }
            }
            else {
                boolean isBlocked = false;
                for (Piece p : ourPieces) {
                    if (p.getX() == this.x && p.getY() == this.y + CELLSIZE) {
                        isBlocked = true;
                        break;
                    }
                }
                for (Piece p : opponentPieces) {
                    if (p.getX() == this.x && p.getY() == this.y + CELLSIZE) {
                        isBlocked = true;
                        break;
                    }
                }
                if (!isBlocked) {
                    Rect rect = getTile(tiles, this.x, this.y + CELLSIZE);
                    possibleMoves.add(rect);
                }
            }
        }
        for (Piece p : opponentPieces) {
            // TOP LEFT DIAGONAL TILE
            if (p.getX() == this.x - CELLSIZE && p.getY() == this.y - CELLSIZE) {
                Rect rect = getTile(tiles, this.x - CELLSIZE, this.y - CELLSIZE);
                if (isHumanPiece())
                    rect.changeColor(lightRed);
                possibleMoves.add(rect);
            }
            // BOTTOM LEFT 
            if (p.getX() == this.x - CELLSIZE && p.getY() == this.y + CELLSIZE) {
                Rect rect = getTile(tiles, this.x - CELLSIZE, this.y + CELLSIZE);
                if (isHumanPiece())
                    rect.changeColor(lightRed);
                possibleMoves.add(rect);
            }
            // TOP RIGHT
            if (p.getX() == this.x + CELLSIZE && p.getY() == this.y - CELLSIZE) {
                Rect rect = getTile(tiles, this.x + CELLSIZE, this.y - CELLSIZE);
                if (isHumanPiece())
                    rect.changeColor(lightRed);
                possibleMoves.add(rect);
            }
            // BOTTOM RIGHT
            if (p.getX() == this.x + CELLSIZE && p.getY() == this.y + CELLSIZE) {
                Rect rect = getTile(tiles, this.x + CELLSIZE, this.y + CELLSIZE);
                if (isHumanPiece())
                    rect.changeColor(lightRed);
                possibleMoves.add(rect);
            }
        }
        return possibleMoves;
    }
}