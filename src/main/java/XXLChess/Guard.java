package XXLChess;

import processing.core.*;
import java.util.*;

public class Guard extends Piece {
    
    public Guard(int x, int y, String player, PImage image) {
        super(x, y, image, "guard", 5, player);
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
        // KNIGHT'S MOVE
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

        for (int j = 0; j < opponenPieces.size(); j++) {
            if (opponenPieces.get(j).getX() == this.getX() - CELLSIZE
            && opponenPieces.get(j).getY() == this.getY() - CELLSIZE*2) {
                higherTopLeftCaptured = true;
            }
            if (opponenPieces.get(j).getX() == this.getX() - CELLSIZE*2
            && opponenPieces.get(j).getY() == this.getY() - CELLSIZE) {
                lowerTopLeftCaptured = true;
            }
            if (opponenPieces.get(j).getX() == this.getX() + CELLSIZE
            && opponenPieces.get(j).getY() == this.getY() - CELLSIZE*2) {
                higherTopRightCaptured = true;
            }
            if (opponenPieces.get(j).getX() == this.getX() + CELLSIZE*2
            && opponenPieces.get(j).getY() == this.getY() - CELLSIZE) {
                lowerTopRightCaptured = true;
            }
            if (opponenPieces.get(j).getX() == this.getX() - CELLSIZE*2
            && opponenPieces.get(j).getY() == this.getY() + CELLSIZE) {
                higherBottomLeftCaptured = true;
            }
            if (opponenPieces.get(j).getX() == this.getX() - CELLSIZE
            && opponenPieces.get(j).getY() == this.getY() + CELLSIZE*2) {
                lowerBottomLeftCaptured = true;
            }
            if (opponenPieces.get(j).getX() == this.getX() + CELLSIZE*2
            && opponenPieces.get(j).getY() == this.getY() + CELLSIZE) {
                higherBottomRightCaptured = true;
            }
            if (opponenPieces.get(j).getX() == this.getX() + CELLSIZE
            && opponenPieces.get(j).getY() == this.getY() + CELLSIZE*2) {
                lowerBottomRightCaptured = true;
            }
        }
        if (higherTopLeft && this.x - CELLSIZE >= 0 && this.y - CELLSIZE*2 >= 0) {
            Rect rect = getTile(tiles, this.x - CELLSIZE, this.y - CELLSIZE*2);
            if (isHumanPiece()) {
                if (higherTopLeftCaptured)
                    rect.changeColor(lightRed);
                else
                    rect.changeColor(lightBlue);
            }
            possibleMoves.add(rect);
        }
        if (lowerTopLeft && this.x - CELLSIZE*2 >= 0 && this.y - CELLSIZE >= 0) {
            Rect rect = getTile(tiles, this.x - CELLSIZE*2, this.y - CELLSIZE);
            if (isHumanPiece()) {
                if (lowerTopLeftCaptured)
                    rect.changeColor(lightRed);
                else
                    rect.changeColor(lightBlue);
            }
            possibleMoves.add(rect);
        }
        if (higherTopRight && this.x + CELLSIZE <= CELLSIZE * (BOARD_WIDTH-1) && this.y - CELLSIZE*2 >= 0) {
            Rect rect = getTile(tiles, this.x + CELLSIZE, this.y - CELLSIZE*2);
            if (isHumanPiece()) {
                if (higherTopRightCaptured)
                    rect.changeColor(lightRed);
                else
                    rect.changeColor(lightBlue);
            }
            possibleMoves.add(rect);
        }
        if (lowerTopRight && this.x + CELLSIZE*2 <= CELLSIZE * (BOARD_WIDTH-1) && this.y - CELLSIZE >= 0) {
            Rect rect = getTile(tiles, this.x + CELLSIZE*2, this.y - CELLSIZE);
            if (isHumanPiece()) {
                if (lowerTopRightCaptured)
                    rect.changeColor(lightRed);
                else
                    rect.changeColor(lightBlue);
            }
            possibleMoves.add(rect);
        }
        if (higherBottomLeft && this.x - CELLSIZE*2 >= 0 && this.y + CELLSIZE <= CELLSIZE * (BOARD_WIDTH-1)) {
            Rect rect = getTile(tiles, this.x - CELLSIZE*2, this.y + CELLSIZE);
            if (isHumanPiece()) {
                if (higherBottomLeftCaptured)
                    rect.changeColor(lightRed);
                else
                    rect.changeColor(lightBlue);
            }
            possibleMoves.add(rect);
        }
        if (lowerBottomLeft && this.x - CELLSIZE >= 0 && this.y + CELLSIZE*2 <= CELLSIZE * (BOARD_WIDTH-1)) {
            Rect rect = getTile(tiles, this.x - CELLSIZE, this.y + CELLSIZE*2);
            if (isHumanPiece()) {
                if (lowerBottomLeftCaptured)
                    rect.changeColor(lightRed);
                else
                    rect.changeColor(lightBlue);
            }
            possibleMoves.add(rect);
        }
        if (higherBottomRight && this.x + CELLSIZE*2 <= CELLSIZE * (BOARD_WIDTH-1) && this.y + CELLSIZE <= CELLSIZE * (BOARD_WIDTH-1)) {
            Rect rect = getTile(tiles, this.x + CELLSIZE*2, this.y + CELLSIZE);
            if (isHumanPiece()) {
                if (higherBottomRightCaptured)
                    rect.changeColor(lightRed);
                else
                    rect.changeColor(lightBlue);
            }
            possibleMoves.add(rect);
        }
        if (lowerBottomRight && this.x + CELLSIZE <= CELLSIZE * (BOARD_WIDTH-1) && this.y + CELLSIZE*2 <= CELLSIZE * (BOARD_WIDTH-1)) {
            Rect rect = getTile(tiles, this.x + CELLSIZE, this.y + CELLSIZE*2);
            if (isHumanPiece()) {
                if (lowerBottomRightCaptured)
                    rect.changeColor(lightRed);
                else
                    rect.changeColor(lightBlue);
            }
            possibleMoves.add(rect);
        }
        // KING'S MOVE
        /*
         * if the boolean of the square is false
         * -> means that there's a piece that blocks the way
         */
        // SQUARES ABOVE AND BELOW
        boolean above = true;
        boolean below = true;

        // LEFT AND RIGHT SQUARES
        boolean left = true;
        boolean right = true;

        // BOTTOM LEFT AND BOTTOM RIGHT SQUARES
        boolean bottomLeft = true;
        boolean bottomRight = true;

        //  TOP LEFT AND TOP RIGHT SQUARES
        boolean topLeft = true;
        boolean topRight = true;

        // check for our pieces that block the way
        int xTemp = this.x;
        int yTemp = this.y;
        for (int i = 0; i < ourPieces.size(); i++) {
            if (ourPieces.get(i).getX() == xTemp
            && ourPieces.get(i).getY() == yTemp - CELLSIZE) {
                above = false;
            }
            if (ourPieces.get(i).getX() == xTemp
            && ourPieces.get(i).getY() == yTemp + CELLSIZE) {
                below = false;
            }
            if (ourPieces.get(i).getX() == xTemp - CELLSIZE
            && ourPieces.get(i).getY() == yTemp) {
                left = false;
            }
            if (ourPieces.get(i).getX() == xTemp + CELLSIZE
            && ourPieces.get(i).getY() == yTemp) {
                right = false;
            }
            if (ourPieces.get(i).getX() == xTemp - CELLSIZE
            && ourPieces.get(i).getY() == yTemp + CELLSIZE) {
                bottomLeft = false;
            }
            if (ourPieces.get(i).getX() == xTemp + CELLSIZE
            && ourPieces.get(i).getY() == yTemp + CELLSIZE) {
                bottomRight = false;
            }
            if (ourPieces.get(i).getX() == xTemp - CELLSIZE
            && ourPieces.get(i).getY() == yTemp - CELLSIZE) {
                topLeft = false;
            }
            if (ourPieces.get(i).getX() == xTemp + CELLSIZE
            && ourPieces.get(i).getY() == yTemp - CELLSIZE) {
                topRight = false;
            }
        }

        // SQUARES ABOVE AND BELOW
        boolean aboveCaptured = false;
        boolean belowCaptured = false;

        // LEFT AND RIGHT SQUARES
        boolean leftCaptured = false;
        boolean rightCaptured = false;

        // BOTTOM LEFT AND BOTTOM RIGHT SQUARES
        boolean bottomLeftCaptured = false;
        boolean bottomRightCaptured = false;

        //  TOP LEFT AND TOP RIGHT SQUARES
        boolean topLeftCaptured = false;
        boolean topRightCaptured = false;

        // check for opponent's pieces on the way to capture
        for (int i = 0; i < opponenPieces.size(); i++) {
            if (opponenPieces.get(i).getX() == xTemp
            && opponenPieces.get(i).getY() == yTemp - CELLSIZE) {
                aboveCaptured = true;
            }
            if (opponenPieces.get(i).getX() == xTemp
            && opponenPieces.get(i).getY() == yTemp + CELLSIZE) {
                belowCaptured = true;
            }
            if (opponenPieces.get(i).getX() == xTemp - CELLSIZE
            && opponenPieces.get(i).getY() == yTemp) {
                leftCaptured = true;
            }
            if (opponenPieces.get(i).getX() == xTemp + CELLSIZE
            && opponenPieces.get(i).getY() == yTemp) {
                rightCaptured = true;
            }
            if (opponenPieces.get(i).getX() == xTemp - CELLSIZE
            && opponenPieces.get(i).getY() == yTemp + CELLSIZE) {
                bottomLeftCaptured = true;
            }
            if (opponenPieces.get(i).getX() == xTemp + CELLSIZE
            && opponenPieces.get(i).getY() == yTemp + CELLSIZE) {
                bottomRightCaptured = true;
            }
            if (opponenPieces.get(i).getX() == xTemp - CELLSIZE
            && opponenPieces.get(i).getY() == yTemp - CELLSIZE) {
                topLeftCaptured = true;
            }
            if (opponenPieces.get(i).getX() == xTemp + CELLSIZE
            && opponenPieces.get(i).getY() == yTemp - CELLSIZE) {
                topRightCaptured = true;
            }
        }

        // SQUARE ABOVE
        if (above && yTemp - CELLSIZE >= 0) {
            Rect rect = getTile(tiles, xTemp, yTemp - CELLSIZE);
            if (isHumanPiece()) {
                if (aboveCaptured)
                    rect.changeColor(lightRed);
                else
                    rect.changeColor(lightBlue);
            }
            possibleMoves.add(rect);
        }
        // SQUARE BELOW
        if (below && yTemp + CELLSIZE <= CELLSIZE * (BOARD_WIDTH-1)) {
            Rect rect = getTile(tiles, xTemp, yTemp + CELLSIZE);
            if (isHumanPiece()) {
                if (belowCaptured)
                    rect.changeColor(lightRed);
                else
                    rect.changeColor(lightBlue);
            }
            possibleMoves.add(rect);
        }
        // LEFT SQUARE 
        if (left && xTemp - CELLSIZE >= 0) {
            Rect rect = getTile(tiles, xTemp - CELLSIZE, yTemp);
            if (isHumanPiece()) {
                if (leftCaptured)
                    rect.changeColor(lightRed);
                else
                    rect.changeColor(lightBlue);
            }
            possibleMoves.add(rect);
        }
        // RIGHT SQUARE
        if (right && xTemp + CELLSIZE <= CELLSIZE * (BOARD_WIDTH-1)) {
            Rect rect = getTile(tiles, xTemp + CELLSIZE, yTemp);
            if (isHumanPiece()) {
                if (rightCaptured)
                    rect.changeColor(lightRed);
                else
                    rect.changeColor(lightBlue);
            }
            possibleMoves.add(rect);
        }
        // BOTTOM LEFT SQUARE 
        if (bottomLeft && xTemp - CELLSIZE >= 0 && yTemp + CELLSIZE <= CELLSIZE * (BOARD_WIDTH-1)) {
            Rect rect = getTile(tiles, xTemp - CELLSIZE, yTemp + CELLSIZE);
            if (isHumanPiece()) {
                if (bottomLeftCaptured)
                    rect.changeColor(lightRed);
                else
                    rect.changeColor(darkBlue);
            }
            possibleMoves.add(rect);
        }
        // BOTTOM RIGHT SQUARE
        if (bottomRight && xTemp + CELLSIZE <= CELLSIZE * (BOARD_WIDTH-1) && yTemp + CELLSIZE <= CELLSIZE * (BOARD_WIDTH-1)) {
            Rect rect = getTile(tiles, xTemp + CELLSIZE, yTemp + CELLSIZE);
            if (isHumanPiece()) {
                if (bottomRightCaptured)
                    rect.changeColor(lightRed);
                else
                    rect.changeColor(darkBlue);
            }
            possibleMoves.add(rect);
        }
        // TOP LEFT SQUARE
        if (topLeft && xTemp - CELLSIZE >= 0 && yTemp - CELLSIZE >= 0) {
            Rect rect = getTile(tiles, xTemp - CELLSIZE, yTemp - CELLSIZE);
            if (isHumanPiece()) {
                if (topLeftCaptured)
                    rect.changeColor(lightRed);
                else
                    rect.changeColor(darkBlue);
            }
            possibleMoves.add(rect);
        }
        // TOP RIGHT SQUARE
        if (topRight && xTemp + CELLSIZE <= CELLSIZE * (BOARD_WIDTH-1) && yTemp - CELLSIZE >= 0) {
            Rect rect = getTile(tiles, xTemp + CELLSIZE, yTemp - CELLSIZE);
            if (isHumanPiece()) {
                if (topRightCaptured)
                    rect.changeColor(lightRed);
                else
                    rect.changeColor(darkBlue);
            }
            possibleMoves.add(rect);
        }
        return possibleMoves;
    }
}