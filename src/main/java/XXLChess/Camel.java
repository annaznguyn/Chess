package XXLChess;

import java.util.ArrayList;

import processing.core.PImage;

public class Camel extends Piece {
    
    public Camel(int x, int y, String player, PImage image) {
        super(x, y, image, "camel", 2, player);
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
        // the squares above the piece
        boolean aboveLeft = true;
        boolean aboveRight = true;

        // the squares on the left side of the piece
        boolean leftHigher = true;
        boolean leftLower = true;

        // the squares on the right side of the piece
        boolean rightHigher = true;
        boolean rightLower = true;

        // the squares below the the piece
        boolean belowLeft = true;
        boolean belowRight = true;

        for (int j = 0; j < ourPieces.size(); j++) {
            if (ourPieces.get(j).getX() == this.getX() - CELLSIZE
            && ourPieces.get(j).getY() == this.getY() - CELLSIZE*3) {
                aboveLeft = false;
            }
            if (ourPieces.get(j).getX() == this.getX() + CELLSIZE
            && ourPieces.get(j).getY() == this.getY() - CELLSIZE*3) {
                aboveRight = false;
            }
            if (ourPieces.get(j).getX() == this.getX() - CELLSIZE*3
            && ourPieces.get(j).getY() == this.getY() - CELLSIZE) {
                leftHigher = false;
            }
            if (ourPieces.get(j).getX() == this.getX() - CELLSIZE*3
            && ourPieces.get(j).getY() == this.getY() + CELLSIZE) {
                leftLower = false;
            }
            if (ourPieces.get(j).getX() == this.getX() + CELLSIZE*3
            && ourPieces.get(j).getY() == this.getY() - CELLSIZE) {
                rightHigher = false;
            }
            if (ourPieces.get(j).getX() == this.getX() + CELLSIZE*3
            && ourPieces.get(j).getY() == this.getY() + CELLSIZE) {
                rightLower = false;
            }
            if (ourPieces.get(j).getX() == this.getX() - CELLSIZE
            && ourPieces.get(j).getY() == this.getY() + CELLSIZE*3) {
                belowLeft = false;
            }
            if (ourPieces.get(j).getX() == this.getX() + CELLSIZE
            && ourPieces.get(j).getY() == this.getY() + CELLSIZE*3) {
                belowRight = false;
            }
        }
        // the squares above the piece
        boolean aboveLeftCaptured = false;
        boolean aboveRightCaptured = false;

        // the squares on the left side of the piece
        boolean leftHigherCaptured = false;
        boolean leftLowerCaptured = false;

        // the squares on the right side of the piece
        boolean rightHigherCaptured = false;
        boolean rightLowerCaptured = false;

        // the squares below the the piece
        boolean belowLeftCaptured = false;
        boolean belowRightCaptured = false;

        for (int j = 0; j < opponenPieces.size(); j++) {
            if (opponenPieces.get(j).getX() == this.getX() - CELLSIZE
            && opponenPieces.get(j).getY() == this.getY() - CELLSIZE*3) {
                aboveLeftCaptured = true;
            }
            if (opponenPieces.get(j).getX() == this.getX() + CELLSIZE
            && opponenPieces.get(j).getY() == this.getY() - CELLSIZE*3) {
                aboveRightCaptured = true;
            }
            if (opponenPieces.get(j).getX() == this.getX() - CELLSIZE*3
            && opponenPieces.get(j).getY() == this.getY() - CELLSIZE) {
                leftHigherCaptured = true;
            }
            if (opponenPieces.get(j).getX() == this.getX() - CELLSIZE*3
            && opponenPieces.get(j).getY() == this.getY() + CELLSIZE) {
                leftLowerCaptured = true;
            }
            if (opponenPieces.get(j).getX() == this.getX() + CELLSIZE*3
            && opponenPieces.get(j).getY() == this.getY() - CELLSIZE) {
                rightHigherCaptured = true;
            }
            if (opponenPieces.get(j).getX() == this.getX() + CELLSIZE*3
            && opponenPieces.get(j).getY() == this.getY() + CELLSIZE) {
                rightLowerCaptured = true;
            }
            if (opponenPieces.get(j).getX() == this.getX() - CELLSIZE
            && opponenPieces.get(j).getY() == this.getY() + CELLSIZE*3) {
                belowLeftCaptured = true;
            }
            if (opponenPieces.get(j).getX() == this.getX() + CELLSIZE
            && opponenPieces.get(j).getY() == this.getY() + CELLSIZE*3) {
                belowRightCaptured = true;
            }
        }
        if (aboveLeft && this.x - CELLSIZE >= 0 && this.y - CELLSIZE*3 >= 0) {
            Rect rect = getTile(tiles, this.x - CELLSIZE, this.y - CELLSIZE*3);
            if (isHumanPiece()) {
                if (aboveLeftCaptured)
                    rect.changeColor(lightRed);
                else
                    rect.changeColor(darkBlue);
            }
            possibleMoves.add(rect);
        }
        if (aboveRight && this.x + CELLSIZE <= CELLSIZE * (BOARD_WIDTH-1)
        && this.y - CELLSIZE*3 >= 0) {
            Rect rect = getTile(tiles, this.x + CELLSIZE, this.y - CELLSIZE*3);
            if (isHumanPiece()) {
                if (aboveRightCaptured)
                    rect.changeColor(lightRed);
                else
                    rect.changeColor(darkBlue);
            }
            possibleMoves.add(rect);
        }
        if (leftHigher && this.x - CELLSIZE*3 >= 0 && this.y - CELLSIZE >= 0) {
            Rect rect = getTile(tiles, this.x - CELLSIZE*3, this.y - CELLSIZE);
            if (isHumanPiece()) {
                if (leftHigherCaptured)
                    rect.changeColor(lightRed);
                else
                    rect.changeColor(darkBlue);
            }
            possibleMoves.add(rect);
        }
        if (leftLower && this.x - CELLSIZE*3 >= 0 && this.y + CELLSIZE <= CELLSIZE * (BOARD_WIDTH-1)) {
            Rect rect = getTile(tiles, this.x - CELLSIZE*3, this.y + CELLSIZE);
            if (isHumanPiece()) {
                if (leftLowerCaptured)
                    rect.changeColor(lightRed);
                else
                    rect.changeColor(darkBlue);
            }
            possibleMoves.add(rect);
        }
        if (rightHigher && this.x + CELLSIZE*3 <= CELLSIZE * (BOARD_WIDTH-1)
        && this.y - CELLSIZE >= 0) {
            Rect rect = getTile(tiles, this.x + CELLSIZE*3, this.y - CELLSIZE);
            if (isHumanPiece()) {
                if (rightHigherCaptured)
                    rect.changeColor(lightRed);
                else
                    rect.changeColor(darkBlue);
            }
            possibleMoves.add(rect);
        }
        if (rightLower && this.x + CELLSIZE*3 <= CELLSIZE * (BOARD_WIDTH-1)
        && this.y + CELLSIZE <= CELLSIZE * (BOARD_WIDTH-1)) {
            Rect rect = getTile(tiles, this.x + CELLSIZE*3, this.y + CELLSIZE);
            if (isHumanPiece()) {
                if (rightLowerCaptured)
                    rect.changeColor(lightRed);
                else
                    rect.changeColor(darkBlue);
            }
            possibleMoves.add(rect);
        }
        if (belowLeft && this.x - CELLSIZE >= 0 && this.y + CELLSIZE*3 <= CELLSIZE * (BOARD_WIDTH-1)) {
            Rect rect = getTile(tiles, this.x - CELLSIZE, this.y + CELLSIZE*3);
            if (isHumanPiece()) {
                if (belowLeftCaptured)
                    rect.changeColor(lightRed);
                else
                    rect.changeColor(darkBlue);
            }
            possibleMoves.add(rect);
        }
        if (belowRight && this.x + CELLSIZE <= CELLSIZE * (BOARD_WIDTH-1)
        && this.y + CELLSIZE*3 <= CELLSIZE * (BOARD_WIDTH-1)) {
            Rect rect = getTile(tiles, this.x + CELLSIZE, this.y + CELLSIZE*3);
            if (isHumanPiece()) {
                if (belowRightCaptured)
                    rect.changeColor(lightRed);
                else
                    rect.changeColor(darkBlue);
            }
            possibleMoves.add(rect);
        }
        return possibleMoves;
    }
}