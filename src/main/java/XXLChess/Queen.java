package XXLChess;

import processing.core.*;
import java.util.*;

public class Queen extends Piece {
    
    public Queen(int x, int y, String player, PImage image) {
        super(x, y, image, "queen", 9.5, player);
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
        // VERTICAL UPWARD
        isLightBlue = false;
        xTemp = this.x;
        yTemp = this.y;
        hasToBreak = false;
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