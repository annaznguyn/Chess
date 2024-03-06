package XXLChess;

import processing.core.*;
import java.util.*;

public class Amazon extends Piece {
    
    public Amazon(int x, int y, String player, PImage image) {
        super(x, y, image, "amazon", 12, player);
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
            for (int j = 0; j < opponentPieces.size(); j++) {
                if (opponentPieces.get(j).getX() == this.x - CELLSIZE*i
                && opponentPieces.get(j).getY() == this.y - CELLSIZE*i) {
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
            for (int j = 0; j < opponentPieces.size(); j++) {
                if (opponentPieces.get(j).getX() == this.x - CELLSIZE*i
                && opponentPieces.get(j).getY() == this.y + CELLSIZE*i) {
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
            for (int j = 0; j < opponentPieces.size(); j++) {
                if (opponentPieces.get(j).getX() == this.x + CELLSIZE*i
                && opponentPieces.get(j).getY() == this.y - CELLSIZE*i) {
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
                for (int j = 0; j < opponentPieces.size(); j++) {
                    if (opponentPieces.get(j).getX() == this.x + CELLSIZE*i
                    && opponentPieces.get(j).getY() == this.y + CELLSIZE*i) {
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
            for (int j = 0; j < opponentPieces.size(); j++) {
                if (opponentPieces.get(j).getX() == xTemp
                && opponentPieces.get(j).getY() == yTemp - CELLSIZE) {
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
            for (int j = 0; j < opponentPieces.size(); j++) {
                if (opponentPieces.get(j).getX() == xTemp
                && opponentPieces.get(j).getY() == yTemp + CELLSIZE) {
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
        // KNIGHT'S MOVES
        boolean higherTopLeft = true;
        boolean lowerTopLeft = true;

        boolean higherTopRight = true;
        boolean lowerTopRight = true;

        boolean higherBottomLeft = true;
        boolean lowerBottomLeft = true;

        boolean higherBottomRight = true;
        boolean lowerBottomRight = true;

        for (int j = 0; j < ourPieces.size(); j++) {
            if (ourPieces.get(j).getX() == this.getX() - CELLSIZE
            && ourPieces.get(j).getY() == this.getY() - CELLSIZE*2) {
                higherTopLeft = false;
            }
            if (ourPieces.get(j).getX() == this.getX() - CELLSIZE*2
            && ourPieces.get(j).getY() == this.getY() - CELLSIZE) {
                lowerTopLeft = false;
            }
            if (ourPieces.get(j).getX() == this.getX() + CELLSIZE
            && ourPieces.get(j).getY() == this.getY() - CELLSIZE*2) {
                higherTopRight = false;
            }
            if (ourPieces.get(j).getX() == this.getX() + CELLSIZE*2
            && ourPieces.get(j).getY() == this.getY() - CELLSIZE) {
                lowerTopRight = false;
            }
            if (ourPieces.get(j).getX() == this.getX() - CELLSIZE*2
            && ourPieces.get(j).getY() == this.getY() + CELLSIZE) {
                higherBottomLeft = false;
            }
            if (ourPieces.get(j).getX() == this.getX() - CELLSIZE
            && ourPieces.get(j).getY() == this.getY() + CELLSIZE*2) {
                lowerBottomLeft = false;
            }
            if (ourPieces.get(j).getX() == this.getX() + CELLSIZE*2
            && ourPieces.get(j).getY() == this.getY() + CELLSIZE) {
                higherBottomRight = false;
            }
            if (ourPieces.get(j).getX() == this.getX() + CELLSIZE
            && ourPieces.get(j).getY() == this.getY() + CELLSIZE*2) {
                lowerBottomRight = false;
            }
        }
        boolean higherTopLeftCaptured = false;
        boolean lowerTopLeftCaptured = false;

        boolean higherTopRightCaptured = false;
        boolean lowerTopRightCaptured = false;

        boolean higherBottomLeftCaptured = false;
        boolean lowerBottomLeftCaptured = false;

        boolean higherBottomRightCaptured = false;
        boolean lowerBottomRightCaptured = false;

        for (int j = 0; j < opponentPieces.size(); j++) {
            if (opponentPieces.get(j).getX() == this.getX() - CELLSIZE
            && opponentPieces.get(j).getY() == this.getY() - CELLSIZE*2) {
                higherTopLeftCaptured = true;
            }
            if (opponentPieces.get(j).getX() == this.getX() - CELLSIZE*2
            && opponentPieces.get(j).getY() == this.getY() - CELLSIZE) {
                lowerTopLeftCaptured = true;
            }
            if (opponentPieces.get(j).getX() == this.getX() + CELLSIZE
            && opponentPieces.get(j).getY() == this.getY() - CELLSIZE*2) {
                higherTopRightCaptured = true;
            }
            if (opponentPieces.get(j).getX() == this.getX() + CELLSIZE*2
            && opponentPieces.get(j).getY() == this.getY() - CELLSIZE) {
                lowerTopRightCaptured = true;
            }
            if (opponentPieces.get(j).getX() == this.getX() - CELLSIZE*2
            && opponentPieces.get(j).getY() == this.getY() + CELLSIZE) {
                higherBottomLeftCaptured = true;
            }
            if (opponentPieces.get(j).getX() == this.getX() - CELLSIZE
            && opponentPieces.get(j).getY() == this.getY() + CELLSIZE*2) {
                lowerBottomLeftCaptured = true;
            }
            if (opponentPieces.get(j).getX() == this.getX() + CELLSIZE*2
            && opponentPieces.get(j).getY() == this.getY() + CELLSIZE) {
                higherBottomRightCaptured = true;
            }
            if (opponentPieces.get(j).getX() == this.getX() + CELLSIZE
            && opponentPieces.get(j).getY() == this.getY() + CELLSIZE*2) {
                lowerBottomRightCaptured = true;
            }
        }
        if (higherTopLeft && this.x - CELLSIZE >= 0 && this.y - CELLSIZE*2 >= 0) {
            Rect rect = getTile(tiles, this.x - CELLSIZE, this.y - CELLSIZE*2);
            if (isHumanPiece()) {
                if (higherTopLeftCaptured)
                    rect.changeColor(lightRed);
                else
                    rect.changeColor(darkBlue);
            }
            possibleMoves.add(rect);
        }
        if (lowerTopLeft && this.x - CELLSIZE*2 >= 0 && this.y - CELLSIZE >= 0) {
            Rect rect = getTile(tiles, this.x - CELLSIZE*2, this.y - CELLSIZE);
            if (isHumanPiece()) {
                if (lowerTopLeftCaptured)
                    rect.changeColor(lightRed);
                else
                    rect.changeColor(darkBlue);
            }
            possibleMoves.add(rect);
        }
        if (higherTopRight && this.x + CELLSIZE <= CELLSIZE * (BOARD_WIDTH-1) && this.y - CELLSIZE*2 >= 0) {
            Rect rect = getTile(tiles, this.x + CELLSIZE, this.y - CELLSIZE*2);
            if (isHumanPiece()) {
                if (higherTopRightCaptured)
                    rect.changeColor(lightRed);
                else
                    rect.changeColor(darkBlue);
            }
            possibleMoves.add(rect);
        }
        if (lowerTopRight && this.x + CELLSIZE*2 <= CELLSIZE * (BOARD_WIDTH-1) && this.y - CELLSIZE >= 0) {
            Rect rect = getTile(tiles, this.x + CELLSIZE*2, this.y - CELLSIZE);
            if (isHumanPiece()) {
                if (lowerTopRightCaptured)
                    rect.changeColor(lightRed);
                else
                    rect.changeColor(darkBlue);
            }
            possibleMoves.add(rect);
        }
        if (higherBottomLeft && this.x - CELLSIZE*2 >= 0 && this.y + CELLSIZE <= CELLSIZE * (BOARD_WIDTH-1)) {
            Rect rect = getTile(tiles, this.x - CELLSIZE*2, this.y + CELLSIZE);
            if (isHumanPiece()) {
                if (higherBottomLeftCaptured)
                    rect.changeColor(lightRed);
                else
                    rect.changeColor(darkBlue);
            }
            possibleMoves.add(rect);
        }
        if (lowerBottomLeft && this.x - CELLSIZE >= 0 && this.y + CELLSIZE*2 <= CELLSIZE * (BOARD_WIDTH-1)) {
            Rect rect = getTile(tiles, this.x - CELLSIZE, this.y + CELLSIZE*2);
            if (isHumanPiece()) {
                if (lowerBottomLeftCaptured)
                    rect.changeColor(lightRed);
                else
                    rect.changeColor(darkBlue);
            }
            possibleMoves.add(rect);
        }
        if (higherBottomRight && this.x + CELLSIZE*2 <= CELLSIZE * (BOARD_WIDTH-1) && this.y + CELLSIZE <= CELLSIZE * (BOARD_WIDTH-1)) {
            Rect rect = getTile(tiles, this.x + CELLSIZE*2, this.y + CELLSIZE);
            if (isHumanPiece()) {
                if (higherBottomRightCaptured)
                    rect.changeColor(lightRed);
                else
                    rect.changeColor(darkBlue);
            }
            possibleMoves.add(rect);
        }
        if (lowerBottomRight && this.x + CELLSIZE <= CELLSIZE * (BOARD_WIDTH-1) && this.y + CELLSIZE*2 <= CELLSIZE * (BOARD_WIDTH-1)) {
            Rect rect = getTile(tiles, this.x + CELLSIZE, this.y + CELLSIZE*2);
            if (isHumanPiece()) {
                if (lowerBottomRightCaptured)
                    rect.changeColor(lightRed);
                else
                    rect.changeColor(darkBlue);
            }
            possibleMoves.add(rect);
        }
        return possibleMoves;
    }
}
