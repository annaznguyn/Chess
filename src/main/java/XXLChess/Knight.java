package XXLChess;

import processing.core.*;
import java.util.*;

public class Knight extends Piece {
    
    public Knight(int x, int y, String player, PImage image) {
        super(x, y, image, "knight", 2, player);
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