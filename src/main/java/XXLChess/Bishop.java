package XXLChess;

import processing.core.*;
import java.util.*;

public class Bishop extends Piece {
    
    public Bishop(int x, int y, String player, PImage image) {
        super(x, y, image, "bishop", 3.625, player);
    }
    
    /** 
     * @param ourPieces
     * An array list storing ally's pieces.
     * @param opponenPieces
     * An array list storing opponent's pieces.
     * @param tiles
     * An array list storing all the tiles of the board.
     * @return an array list of possible moves
     * Return an array list storing the possible and valid moves of the piece.
     */
    public ArrayList<Rect> getPossibleMoves(ArrayList<Piece> ourPieces, ArrayList<Piece> opponenPieces, ArrayList<Rect> tiles) {
        ArrayList<Rect> possibleMoves = new ArrayList<Rect>();
        // TOP LEFT DIAGONAL
        int i = 1;
        int xTemp = this.x;
        int yTemp = this.y;
        // if true, break the outer loop
        boolean hasToBreak = false;
        while (yTemp > 0 && xTemp > 0) {
            // if see our piece, break
            for (int j = 0; j < ourPieces.size(); j++) {
                if (ourPieces.get(j).getX() == this.x - CELLSIZE*i
                && ourPieces.get(j).getY() == this.y - CELLSIZE*i) {
                    hasToBreak = true;
                    break;
                }
            }
            for (int j = 0; j < opponenPieces.size(); j++) {
                if (opponenPieces.get(j).getX() == this.x - CELLSIZE*i
                && opponenPieces.get(j).getY() == this.y - CELLSIZE*i) {
                    Rect rect = getTile(tiles, this.x - CELLSIZE*i, this.y - CELLSIZE*i);
                    if (isHumanPiece())
                        rect.changeColor(lightRed);
                    possibleMoves.add(rect);
                    hasToBreak = true;
                    break;
                }
            }
            if (hasToBreak) {
                break;
            }
            Rect rect = getTile(tiles, this.x - CELLSIZE*i, this.y - CELLSIZE*i);
            if (isHumanPiece())
                rect.changeColor(lightBlue);
            possibleMoves.add(rect);
            xTemp -= CELLSIZE;
            yTemp -= CELLSIZE;
            i++;
        }
        // BOTTOM LEFT DIAGONAL
        i = 1;
        hasToBreak = false;
        xTemp = this.x;
        yTemp = this.y;
        while (xTemp > 0 && yTemp < CELLSIZE * (BOARD_WIDTH-1)) {
            // if see our piece, break
            for (int j = 0; j < ourPieces.size(); j++) {
                if (ourPieces.get(j).getX() == this.getX() - CELLSIZE*i
                && ourPieces.get(j).getY() == this.getY() + CELLSIZE*i) {
                    hasToBreak = true;
                    break;
                }
            }
            for (int j = 0; j < opponenPieces.size(); j++) {
                if (opponenPieces.get(j).getX() == this.x - CELLSIZE*i
                && opponenPieces.get(j).getY() == this.y + CELLSIZE*i) {
                    Rect rect = getTile(tiles, this.x - CELLSIZE*i, this.y + CELLSIZE*i);
                    if (isHumanPiece())
                        rect.changeColor(lightRed);
                    possibleMoves.add(rect);
                    hasToBreak = true;
                    break;
                }
            }
            if (hasToBreak) {
                break;
            }
            Rect rect = getTile(tiles, this.x - CELLSIZE*i, this.y + CELLSIZE*i);
            if (isHumanPiece())
                rect.changeColor(lightBlue);
            possibleMoves.add(rect);
            xTemp -= CELLSIZE;
            yTemp += CELLSIZE;
            i++;
        }
        // TOP RIGHT DIAGONAL
        i = 1;
        hasToBreak = false;
        xTemp = this.x;
        yTemp = this.y;
        while (xTemp < CELLSIZE * (BOARD_WIDTH-1) && yTemp > 0) {
            // if see our piece, break
            for (int j = 0; j < ourPieces.size(); j++) {
                if (ourPieces.get(j).getX() == this.x + CELLSIZE*i
                && ourPieces.get(j).getY() == this.y - CELLSIZE*i) {
                    hasToBreak = true;
                    break;
                }
            }
            for (int j = 0; j < opponenPieces.size(); j++) {
                if (opponenPieces.get(j).getX() == this.x + CELLSIZE*i
                && opponenPieces.get(j).getY() == this.y - CELLSIZE*i) {
                    Rect rect = getTile(tiles, this.x + CELLSIZE*i, this.y - CELLSIZE*i);
                    if (isHumanPiece())
                        rect.changeColor(lightRed);
                    possibleMoves.add(rect);
                    hasToBreak = true;
                    break;
                }
            }
            if (hasToBreak) {
                break;
            }
            Rect rect = getTile(tiles, this.x + CELLSIZE*i, this.y - CELLSIZE*i);
            if (isHumanPiece())
                rect.changeColor(lightBlue);
            possibleMoves.add(rect);
            xTemp += CELLSIZE;
            yTemp -= CELLSIZE;
            i++;
        }
        // BOTTOM RIGHT DIAGONAL
        i = 1;
        hasToBreak = false;
        xTemp = this.x;
        yTemp = this.y;
        while (xTemp < CELLSIZE * (BOARD_WIDTH-1)
            && yTemp < CELLSIZE * (BOARD_WIDTH-1)) {
                // if see our piece, break
                for (int j = 0; j < ourPieces.size(); j++) {
                    if (ourPieces.get(j).getX() == this.x + CELLSIZE*i
                    && ourPieces.get(j).getY() == this.y + CELLSIZE*i) {
                        hasToBreak = true;
                        break;
                    }
                }
                for (int j = 0; j < opponenPieces.size(); j++) {
                    if (opponenPieces.get(j).getX() == this.x + CELLSIZE*i
                    && opponenPieces.get(j).getY() == this.y + CELLSIZE*i) {
                        Rect rect = getTile(tiles, this.x + CELLSIZE*i, this.y + CELLSIZE*i);
                        if (isHumanPiece())
                            rect.changeColor(lightRed);
                        possibleMoves.add(rect);
                        hasToBreak = true;
                        break;
                    }
                }
                if (hasToBreak) {
                    break;
                }
                Rect rect = getTile(tiles, this.x + CELLSIZE*i, this.y + CELLSIZE*i);
                if (isHumanPiece())
                    rect.changeColor(lightBlue);
                possibleMoves.add(rect);
                xTemp += CELLSIZE;
                yTemp += CELLSIZE;
                i++;
        }
        return possibleMoves;
    }
}