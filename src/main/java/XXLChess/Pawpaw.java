package XXLChess;

import processing.core.*;
import java.util.*;

public class Pawpaw extends Piece {
    
    public Pawpaw(int x, int y, String player, PImage image) {
        super(x, y, image, "pawpaw", 5, player);
    }

    /** 
     * @param ourPieces
     * An array list storing ally's pieces.
     * @param opponentPieces
     * An array list storing opponent's pieces.
     * @param tiles
     * An array list storing all the tiles of the board.
     * @return an array list of possible moves
     * Return an array list storing the possible and valid moves of the piece.
     */
    public ArrayList<Rect> getPossibleMoves(ArrayList<Piece> ourPieces, ArrayList<Piece> opponentPieces, ArrayList<Rect> tiles) {
        ArrayList<Rect> possibleMoves = new ArrayList<Rect>();
        // tile above and below
        boolean above = true;
        boolean below = true;

        if (oppAllPossibleMoves != null) {
            // check for dangerous moves
            for (Rect rect : oppAllPossibleMoves) {
                if (rect.getX() == this.x && rect.getY() == this.y - CELLSIZE) 
                    above = false;
                if (rect.getX() == this.x && rect.getY() == this.y + CELLSIZE)
                    below = false;
            }
        }

        // check for block pieces
        for (int i = 0; i < ourPieces.size(); i++) {
            if (ourPieces.get(i).getX() == this.x
            && ourPieces.get(i).getY() == this.y - CELLSIZE) {
                above = false;
            }
            if (ourPieces.get(i).getX() == this.x
            && ourPieces.get(i).getY() == this.y + CELLSIZE) {
                below = false;
            }
        }

        // check for opponent's pieces on the way to capture
        boolean aboveCap = false;
        boolean belowCap = false;

        for (int i = 0; i < opponentPieces.size(); i++) {
            if (opponentPieces.get(i).getX() == this.x
            && opponentPieces.get(i).getY() == this.y - CELLSIZE) {
                aboveCap = true;
            }
            if (opponentPieces.get(i).getX() == this.x
            && opponentPieces.get(i).getY() == this.y + CELLSIZE) {
                belowCap = true;
            }
        }

        // ABOVE
        if (above && this.y - CELLSIZE >= 0) {
            Rect rect = getTile(tiles, this.x, this.y - CELLSIZE);
            if (isHumanPiece()) {
                if (aboveCap)
                    rect.changeColor(lightRed);
                else
                    rect.changeColor(darkBlue);
            }
            possibleMoves.add(rect);
        }
        // BELOW
        if (below && this.y + CELLSIZE <= CELLSIZE * (BOARD_WIDTH-1)) {
            Rect rect = getTile(tiles, this.x, this.y + CELLSIZE);
            if (isHumanPiece()) {
                if (belowCap)
                    rect.changeColor(lightRed);
                else
                    rect.changeColor(darkBlue);
            }
            possibleMoves.add(rect);
        }

        // HORIZONTAL LEFT
        boolean isLightBlue = false;
        int xTemp = this.x;
        int yTemp = this.y;
        boolean hasToBreak = false;
        while (xTemp > 0) {
            // if see our piece, break
            for (int j = 0; j < ourPieces.size(); j++) {
                if (ourPieces.get(j).getX() == xTemp - CELLSIZE
                && ourPieces.get(j).getY() == yTemp) {
                    hasToBreak = true;
                    break;
                }
            }
            for (int j = 0; j < opponentPieces.size(); j++) {
                if (opponentPieces.get(j).getX() == xTemp - CELLSIZE
                && opponentPieces.get(j).getY() == yTemp) {
                    Rect rect = getTile(tiles, xTemp - CELLSIZE, yTemp);
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
            Rect rect = getTile(tiles, xTemp - CELLSIZE, yTemp);
            if (isHumanPiece()) {
                if (isLightBlue) {
                    rect.changeColor(lightBlue);
                    isLightBlue = false;
                }
                else {
                    rect.changeColor(darkBlue);
                    isLightBlue = true;
                }
            }
            possibleMoves.add(rect);
            xTemp -= CELLSIZE;
        }
        // HORIZONTAL RIGHT
        isLightBlue = false;
        xTemp = this.x;
        yTemp = this.y;
        hasToBreak = false;
        while (xTemp < CELLSIZE * (BOARD_WIDTH-1)) {
            // if see our piece, break
            for (int j = 0; j < ourPieces.size(); j++) {
                if (ourPieces.get(j).getX() == xTemp + CELLSIZE
                && ourPieces.get(j).getY() == yTemp) {
                    hasToBreak = true;
                    break;
                }
            }
            for (int j = 0; j < opponentPieces.size(); j++) {
                if (opponentPieces.get(j).getX() == xTemp + CELLSIZE
                && opponentPieces.get(j).getY() == yTemp) {
                    Rect rect = getTile(tiles, xTemp + CELLSIZE, yTemp);
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
            Rect rect = getTile(tiles, xTemp + CELLSIZE, yTemp);
            if (isHumanPiece()) {
                if (isLightBlue) {
                    rect.changeColor(lightBlue);
                    isLightBlue = false;
                }
                else {
                    rect.changeColor(darkBlue);
                    isLightBlue = true;
                }
            }
            possibleMoves.add(rect);
            xTemp += CELLSIZE;
        }
        return possibleMoves;
    }
}
