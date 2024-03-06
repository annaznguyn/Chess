package XXLChess;

import processing.core.*;
import java.util.*;
 
public class Rook extends Piece {
    
    public Rook(int x, int y, String player, PImage image) {
        super(x, y, image, "rook", 5.25, player);
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
        // VERTICAL UPWARD
        boolean isLightBlue = false;
        int xTemp = this.x;
        int yTemp = this.y;
        boolean hasToBreak = false;
        while (yTemp > 0) {
            // if see our piece, break
            for (int j = 0; j < ourPieces.size(); j++) {
                if (ourPieces.get(j).getX() == xTemp
                && ourPieces.get(j).getY() == yTemp - CELLSIZE) {
                    hasToBreak = true;
                    break;
                }
            }
            for (int j = 0; j < opponenPieces.size(); j++) {
                if (opponenPieces.get(j).getX() == xTemp
                && opponenPieces.get(j).getY() == yTemp - CELLSIZE) {
                    Rect rect = getTile(tiles, xTemp, yTemp - CELLSIZE);
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
            Rect rect = getTile(tiles, xTemp, yTemp - CELLSIZE);
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
            yTemp -= CELLSIZE;
        }
        // VERTICAL DOWNWARD
        isLightBlue = false;
        xTemp = this.x;
        yTemp = this.y;
        hasToBreak = false;
        while (yTemp < CELLSIZE * (BOARD_WIDTH-1)) {
            // if see our piece, break
            for (int j = 0; j < ourPieces.size(); j++) {
                if (ourPieces.get(j).getX() == xTemp
                && ourPieces.get(j).getY() == yTemp + CELLSIZE) {
                    hasToBreak = true;
                    break;
                }
            }
            for (int j = 0; j < opponenPieces.size(); j++) {
                if (opponenPieces.get(j).getX() == xTemp
                && opponenPieces.get(j).getY() == yTemp + CELLSIZE) {
                    Rect rect = getTile(tiles, xTemp, yTemp + CELLSIZE);
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
            Rect rect = getTile(tiles, xTemp, yTemp + CELLSIZE);
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
            yTemp += CELLSIZE;
        }
        // HORIZONTAL LEFT
        isLightBlue = false;
        xTemp = this.x;
        yTemp = this.y;
        hasToBreak = false;
        while (xTemp > 0) {
            // if see our piece, break
            for (int j = 0; j < ourPieces.size(); j++) {
                if (ourPieces.get(j).getX() == xTemp - CELLSIZE
                && ourPieces.get(j).getY() == yTemp) {
                    hasToBreak = true;
                    break;
                }
            }
            for (int j = 0; j < opponenPieces.size(); j++) {
                if (opponenPieces.get(j).getX() == xTemp - CELLSIZE
                && opponenPieces.get(j).getY() == yTemp) {
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
            for (int j = 0; j < opponenPieces.size(); j++) {
                if (opponenPieces.get(j).getX() == xTemp + CELLSIZE
                && opponenPieces.get(j).getY() == yTemp) {
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