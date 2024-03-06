package XXLChess;

import processing.core.*;
import java.util.*;

public class King extends Piece {
    
    public King(int x, int y, String player, PImage image) {
        super(x, y, image, "king", 13, player);
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

        if (oppAllPossibleMoves != null) {
            // check for the dangerous moves
            for (Rect rect : oppAllPossibleMoves) {
                if (rect.getX() == this.x && rect.getY() == this.y - CELLSIZE) 
                    above = false;
                if (rect.getX() == this.x && rect.getY() == this.y + CELLSIZE)
                    below = false;
                if (rect.getX() == this.x - CELLSIZE && rect.getY() == this.y)
                    left = false;
                if (rect.getX() == this.x + CELLSIZE && rect.getY() == this.y)
                    right = false;
                if (rect.getX() == this.x - CELLSIZE && rect.getY() == this.y + CELLSIZE) 
                    bottomLeft = false;
                if (rect.getX() == this.x + CELLSIZE && rect.getY() == this.y + CELLSIZE) 
                    bottomRight = false;
                if (rect.getX() == this.x - CELLSIZE && rect.getY() == this.y - CELLSIZE)
                    topLeft = false;
                if (rect.getX() == this.x + CELLSIZE && rect.getY() == this.y - CELLSIZE)
                    topRight = false;
            }
        }

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
        for (int i = 0; i < opponentPieces.size(); i++) {
            if (opponentPieces.get(i).getX() == xTemp
            && opponentPieces.get(i).getY() == yTemp - CELLSIZE) {
                aboveCaptured = true;
            }
            if (opponentPieces.get(i).getX() == xTemp
            && opponentPieces.get(i).getY() == yTemp + CELLSIZE) {
                belowCaptured = true;
            }
            if (opponentPieces.get(i).getX() == xTemp - CELLSIZE
            && opponentPieces.get(i).getY() == yTemp) {
                leftCaptured = true;
            }
            if (opponentPieces.get(i).getX() == xTemp + CELLSIZE
            && opponentPieces.get(i).getY() == yTemp) {
                rightCaptured = true;
            }
            if (opponentPieces.get(i).getX() == xTemp - CELLSIZE
            && opponentPieces.get(i).getY() == yTemp + CELLSIZE) {
                bottomLeftCaptured = true;
            }
            if (opponentPieces.get(i).getX() == xTemp + CELLSIZE
            && opponentPieces.get(i).getY() == yTemp + CELLSIZE) {
                bottomRightCaptured = true;
            }
            if (opponentPieces.get(i).getX() == xTemp - CELLSIZE
            && opponentPieces.get(i).getY() == yTemp - CELLSIZE) {
                topLeftCaptured = true;
            }
            if (opponentPieces.get(i).getX() == xTemp + CELLSIZE
            && opponentPieces.get(i).getY() == yTemp - CELLSIZE) {
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
        // CASTLING
        // check if the two second tiles of king are empty and if the two rooks have moved
        boolean leftEmpty = true;
        boolean rightEmpty = true;
        boolean leftHasNotMoved = false;
        boolean rightHasNotMoved = false;
        for (Piece p : ourPieces) {
            if (p.getX() == this.x - CELLSIZE*2 && p.getY() == this.y) 
                leftEmpty = false;
            if (p.getX() == this.x + CELLSIZE*2 && p.getY() == this.y)
                rightEmpty = false;
            if (p.getName().equals("rook")) {
                if (p.getX() < this.x && p.getY() == this.y && !p.hasBeingMoved())
                    leftHasNotMoved = true;
                else if (p.getX() > this.x && p.getY() == this.y && !p.hasBeingMoved())
                    rightHasNotMoved = true;
            }
        }
        if (oppAllPossibleMoves != null) {
            for (Rect tile : oppAllPossibleMoves) {
                if (tile.getX() == this.x - CELLSIZE*2 && tile.getY() == this.y)
                    leftEmpty = false;
                if (tile.getX() == this.x + CELLSIZE*2 && tile.getY() == this.y)
                    rightEmpty = false;
            }
        }
        if (!this.hasBeingMoved()) {
            if (leftEmpty && leftHasNotMoved) {
                Rect rect = getTile(tiles, xTemp - CELLSIZE*2, yTemp);
                if (isHumanPiece())
                    rect.changeColor(darkBlue);
                possibleMoves.add(rect);
            }
            if (rightEmpty && rightHasNotMoved) {
                Rect rect = getTile(tiles, xTemp + CELLSIZE*2, yTemp);
                if (isHumanPiece())
                    rect.changeColor(darkBlue);
                possibleMoves.add(rect);
            }
        }
        return possibleMoves;
    }
}