package XXLChess;


import processing.core.PApplet;
import processing.core.PImage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.io.*;

public class SampleTest {

// gradle jacocoTestReport
// gradle test

    // PIECES
    @Test
    public void drawRectTest() {
        int BROWN = 0xFFB58863;
        int YELLOW = 0xFFF0D9B5;
        Rect tile = new Rect(0, 0, BROWN);
        assertTrue(tile.getOriginalColor() == BROWN);
        tile.changeColor(YELLOW);
        assertTrue(tile.getColor() == YELLOW);
    }

    @Test
    public void pawnTickTest() {
        Pawn pawn = new Pawn(0, 0, "player", null);
        assertTrue(pawn.getX() == 0);
        assertTrue(pawn.getY() == 0);
        int tempXDist = 48;
        int tempYDist = 48;
        int xSpeed = 6;
        int ySpeed = 6;
        double xTotalFrame = tempXDist/xSpeed;
        for (int i = 0; i < xTotalFrame; i++) {
            pawn.tick(tempXDist, tempYDist, xSpeed, ySpeed);
        }
        assertTrue(pawn.getX() == 48);
        assertTrue(pawn.getY() == 48);
    }

    @Test
    public void amazonTickTest() {
        Amazon amazon = new Amazon(0, 0, "player", null);
        assertTrue(amazon.getX() == 0);
        assertTrue(amazon.getY() == 0);
        int tempXDist = 48;
        int tempYDist = 48;
        int xSpeed = 6;
        int ySpeed = 6;
        double xTotalFrame = tempXDist/xSpeed;
        for (int i = 0; i < xTotalFrame; i++) {
            amazon.tick(tempXDist, tempYDist, xSpeed, ySpeed);
        }
        assertTrue(amazon.getX() == 48);
        assertTrue(amazon.getY() == 48);
    }

    @Test
    public void archbishopTickTest() {
        Archbishop arch = new Archbishop(0, 0, "player", null);
        assertTrue(arch.getX() == 0);
        assertTrue(arch.getY() == 0);
        int tempXDist = 48;
        int tempYDist = 48;
        int xSpeed = 6;
        int ySpeed = 6;
        double xTotalFrame = tempXDist/xSpeed;
        for (int i = 0; i < xTotalFrame; i++) {
            arch.tick(tempXDist, tempYDist, xSpeed, ySpeed);
        }
        assertTrue(arch.getX() == 48);
        assertTrue(arch.getY() == 48);
    }

    @Test
    public void bishopTickTest() {
        Bishop bishop = new Bishop(0, 0, "player", null);
        assertTrue(bishop.getX() == 0);
        assertTrue(bishop.getY() == 0);
        int tempXDist = 48;
        int tempYDist = 48;
        int xSpeed = 6;
        int ySpeed = 6;
        double xTotalFrame = tempXDist/xSpeed;
        for (int i = 0; i < xTotalFrame; i++) {
            bishop.tick(tempXDist, tempYDist, xSpeed, ySpeed);
        }
        assertTrue(bishop.getX() == 48);
        assertTrue(bishop.getY() == 48);
    }

    @Test
    public void camelTickTest() {
        Camel camel = new Camel(0, 0, "player", null);
        assertTrue(camel.getX() == 0);
        assertTrue(camel.getY() == 0);
        int tempXDist = 48;
        int tempYDist = 48;
        int xSpeed = 6;
        int ySpeed = 6;
        double xTotalFrame = tempXDist/xSpeed;
        for (int i = 0; i < xTotalFrame; i++) {
            camel.tick(tempXDist, tempYDist, xSpeed, ySpeed);
        }
        assertTrue(camel.getX() == 48);
        assertTrue(camel.getY() == 48);
    }

    @Test
    public void chancellorTickTest() {
        Chancellor chanc = new Chancellor(0, 0, "player", null);
        assertTrue(chanc.getX() == 0);
        assertTrue(chanc.getY() == 0);
        int tempXDist = 48;
        int tempYDist = 48;
        int xSpeed = 6;
        int ySpeed = 6;
        double xTotalFrame = tempXDist/xSpeed;
        for (int i = 0; i < xTotalFrame; i++) {
            chanc.tick(tempXDist, tempYDist, xSpeed, ySpeed);
        }
        assertTrue(chanc.getX() == 48);
        assertTrue(chanc.getY() == 48);
    }

    @Test
    public void guardTickTest() {
        Guard guard = new Guard(0, 0, "player", null);
        assertTrue(guard.getX() == 0);
        assertTrue(guard.getY() == 0);
        int tempXDist = 48;
        int tempYDist = 48;
        int xSpeed = 6;
        int ySpeed = 6;
        double xTotalFrame = tempXDist/xSpeed;
        for (int i = 0; i < xTotalFrame; i++) {
            guard.tick(tempXDist, tempYDist, xSpeed, ySpeed);
        }
        assertTrue(guard.getX() == 48);
        assertTrue(guard.getY() == 48);
    }

    @Test
    public void kingTickTest() {
        King king = new King(0, 0, "player", null);
        assertTrue(king.getX() == 0);
        assertTrue(king.getY() == 0);
        int tempXDist = 48;
        int tempYDist = 48;
        int xSpeed = 6;
        int ySpeed = 6;
        double xTotalFrame = tempXDist/xSpeed;
        for (int i = 0; i < xTotalFrame; i++) {
            king.tick(tempXDist, tempYDist, xSpeed, ySpeed);
        }
        assertTrue(king.getX() == 48);
        assertTrue(king.getY() == 48);
    }

    @Test
    public void knightTickTest() {
        Knight knight = new Knight(0, 0, "player", null);
        assertTrue(knight.getX() == 0);
        assertTrue(knight.getY() == 0);
        int tempXDist = 48;
        int tempYDist = 48;
        int xSpeed = 6;
        int ySpeed = 6;
        double xTotalFrame = tempXDist/xSpeed;
        for (int i = 0; i < xTotalFrame; i++) {
            knight.tick(tempXDist, tempYDist, xSpeed, ySpeed);
        }
        assertTrue(knight.getX() == 48);
        assertTrue(knight.getY() == 48);
    }

    @Test
    public void pawpawTickTest() {
        Pawpaw pawpaw = new Pawpaw(0, 0, "player", null);
        assertTrue(pawpaw.getX() == 0);
        assertTrue(pawpaw.getY() == 0);
        int tempXDist = 48;
        int tempYDist = 48;
        int xSpeed = 6;
        int ySpeed = 6;
        double xTotalFrame = tempXDist/xSpeed;
        for (int i = 0; i < xTotalFrame; i++) {
            pawpaw.tick(tempXDist, tempYDist, xSpeed, ySpeed);
        }
        assertTrue(pawpaw.getX() == 48);
        assertTrue(pawpaw.getY() == 48);
    }

    @Test
    public void queenTickTest() {
        Queen queen = new Queen(0, 0, "player", null);
        assertTrue(queen.getX() == 0);
        assertTrue(queen.getY() == 0);
        int tempXDist = 48;
        int tempYDist = 48;
        int xSpeed = 6;
        int ySpeed = 6;
        double xTotalFrame = tempXDist/xSpeed;
        for (int i = 0; i < xTotalFrame; i++) {
            queen.tick(tempXDist, tempYDist, xSpeed, ySpeed);
        }
        assertTrue(queen.getX() == 48);
        assertTrue(queen.getY() == 48);
    }

    @Test
    public void rookTickTest() {
        Rook rook = new Rook(0, 0, "player", null);
        assertTrue(rook.getX() == 0);
        assertTrue(rook.getY() == 0);
        int tempXDist = 48;
        int tempYDist = 48;
        int xSpeed = 6;
        int ySpeed = 6;
        double xTotalFrame = tempXDist/xSpeed;
        for (int i = 0; i < xTotalFrame; i++) {
            rook.tick(tempXDist, tempYDist, xSpeed, ySpeed);
        }
        assertTrue(rook.getX() == 48);
        assertTrue(rook.getY() == 48);
    }

    @Test
    public void amazonGetPossibleMovesTest() {
        ArrayList<Piece> ourPieces = new ArrayList<Piece>();
        ArrayList<Piece> opponentPieces = new ArrayList<Piece>();
        ArrayList<Rect> tiles = new ArrayList<Rect>();
        Amazon amazon = new Amazon(48*7, 48*7, "player", null);
        assertTrue(amazon.getX() == 48*7);
        assertTrue(amazon.getY() == 48*7);
        // our pieces
        // horizontal left
        Pawn pawn = new Pawn(48*5, 48*7, "player", null);
        assertTrue(pawn.getX() == 48*5);
        assertTrue(pawn.getY() == 48*7);
        // horizontal right
        Pawn pawn1 = new Pawn(48*9, 48*7, "player", null);
        assertTrue(pawn1.getX() == 48*9);
        assertTrue(pawn1.getY() == 48*7);
        // top left diagonal
        Pawn pawn2 = new Pawn(48*5, 48*5, "player", null);
        assertTrue(pawn2.getX() == 48*5);
        assertTrue(pawn2.getY() == 48*5);
        // top right diagonal
        Pawn pawn8 = new Pawn(48*9, 48*5, "player", null);
        assertTrue(pawn8.getX() == 48*9);
        assertTrue(pawn8.getY() == 48*5);
        // bottom left diagonal
        Pawn pawn9 = new Pawn(48*6, 48*8, "player", null);
        assertTrue(pawn9.getX() == 48*6);
        assertTrue(pawn9.getY() == 48*8);
        // bottom right diagonal
        Pawn pawn10 = new Pawn(48*8, 48*8, "player", null);
        assertTrue(pawn10.getX() == 48*8);
        assertTrue(pawn10.getY() == 48*8);
        // knight's moves
        // higher top left
        Pawn pawn3 = new Pawn(48*6, 48*5, "player", null);
        assertTrue(pawn3.getX() == 48*6);
        assertTrue(pawn3.getY() == 48*5);
        // lower top left
        Pawn pawn4 = new Pawn(48*5, 48*6, "player", null);
        assertTrue(pawn4.getX() == 48*5);
        assertTrue(pawn4.getY() == 48*6);
        // opponent pieces
        // higher top right
        Pawn pawn5 = new Pawn(48*8, 48*5, "cpu", null);
        assertTrue(pawn5.getX() == 48*8);
        assertTrue(pawn5.getY() == 48*5);
        // lower top right
        Pawn pawn6 = new Pawn(48*9, 48*6, "cpu", null);
        assertTrue(pawn6.getX() == 48*9);
        assertTrue(pawn6.getY() == 48*6);
        // higher bottom left
        Pawn pawn7 = new Pawn(48*5, 48*8, "player", null);
        assertTrue(pawn7.getX() == 48*5);
        assertTrue(pawn7.getY() == 48*8);
        // higher bottom right
        Pawn pawn11 = new Pawn(48*9, 48*8, "player", null);
        assertTrue(pawn11.getX() == 48*9);
        assertTrue(pawn11.getY() == 48*8);
        // up vertical
        Rook rook = new Rook(48*7, 48*5, "cpu", null);
        assertTrue(rook.getX() == 48*7);
        assertTrue(rook.getY() == 48*5);
        // down vertical
        Rook rook1 = new Rook(48*7, 48*9, "cpu", null);
        assertTrue(rook1.getX() == 48*7);
        assertTrue(rook1.getY() == 48*9);
        for (int i = 5; i < 10; i++) {
            for (int j = 5; j < 10; j++) {
                tiles.add(new Rect(48*i, 48*j, 0));
            }
        }
        ourPieces.add(pawn);
        ourPieces.add(pawn1);
        ourPieces.add(pawn2);
        ourPieces.add(pawn3);
        ourPieces.add(pawn4);
        ourPieces.add(pawn8);
        ourPieces.add(pawn9);
        ourPieces.add(pawn10);
        opponentPieces.add(rook);
        opponentPieces.add(rook1);
        opponentPieces.add(pawn5);
        opponentPieces.add(pawn6);
        opponentPieces.add(pawn7);
        ArrayList<Rect> possibleMoves = amazon.getPossibleMoves(ourPieces, opponentPieces, tiles);
        // min -> max
        Collections.sort(possibleMoves, (a, b) -> a.getX() - b.getX());
        assertTrue(possibleMoves.get(0).getX() == pawn7.getX());
        assertTrue(possibleMoves.get(0).getY() == pawn7.getY());
        assertTrue(possibleMoves.get(13).getX() == pawn11.getX());
        assertTrue(possibleMoves.get(13).getY() == pawn11.getY());
        assertTrue(possibleMoves.size() == 14);
    }
    
    @Test
    public void archbishopGetPossibleMovesTest() {
        ArrayList<Piece> ourPieces = new ArrayList<Piece>();
        ArrayList<Piece> opponentPieces = new ArrayList<Piece>();
        ArrayList<Rect> tiles = new ArrayList<Rect>();
        Archbishop arch = new Archbishop(48*7, 48*7, "player", null);
        assertTrue(arch.getX() == 48*7);
        assertTrue(arch.getY() == 48*7);
        // our pieces
        // top left diagonal
        Pawn pawn2 = new Pawn(48*5, 48*5, "player", null);
        assertTrue(pawn2.getX() == 48*5);
        assertTrue(pawn2.getY() == 48*5);
        // top right diagonal
        Pawn pawn8 = new Pawn(48*9, 48*5, "player", null);
        assertTrue(pawn8.getX() == 48*9);
        assertTrue(pawn8.getY() == 48*5);
        // bottom left diagonal
        Pawn pawn9 = new Pawn(48*5, 48*9, "player", null);
        assertTrue(pawn9.getX() == 48*5);
        assertTrue(pawn9.getY() == 48*9);
        // bottom right diagonal
        Pawn pawn10 = new Pawn(48*8, 48*8, "player", null);
        assertTrue(pawn10.getX() == 48*8);
        assertTrue(pawn10.getY() == 48*8);
        // knight's moves
        // higher bottom right
        Pawn pawn = new Pawn(48*9, 48*8, "player", null);
        // higher top left
        Pawn pawn3 = new Pawn(48*6, 48*5, "player", null);
        assertTrue(pawn3.getX() == 48*6);
        assertTrue(pawn3.getY() == 48*5);
        // OPPONENT PIECES
        // lower top left
        Pawn pawn4 = new Pawn(48*5, 48*6, "player", null);
        assertTrue(pawn4.getX() == 48*5);
        assertTrue(pawn4.getY() == 48*6);
        // lower bottom right
        Pawn pawn1 = new Pawn(48*8, 48*9, "player", null);
        // higher top right
        Pawn pawn5 = new Pawn(48*8, 48*5, "cpu", null);
        assertTrue(pawn5.getX() == 48*8);
        assertTrue(pawn5.getY() == 48*5);
        // lower top right
        Pawn pawn6 = new Pawn(48*9, 48*6, "cpu", null);
        assertTrue(pawn6.getX() == 48*9);
        assertTrue(pawn6.getY() == 48*6);
        // higher bottom left
        Pawn pawn7 = new Pawn(48*5, 48*8, "cpu", null);
        assertTrue(pawn7.getX() == 48*5);
        assertTrue(pawn7.getY() == 48*8);
        // higher bottom left
        Pawn pawn11 = new Pawn(48*6, 48*9, "cpu", null);
        assertTrue(pawn11.getX() == 48*6);
        assertTrue(pawn11.getY() == 48*9);
        for (int i = 5; i < 10; i++) {
            for (int j = 5; j < 10; j++) {
                tiles.add(new Rect(48*i, 48*j, 0));
            }
        }
        ourPieces.add(pawn);
        ourPieces.add(pawn2);
        ourPieces.add(pawn3);
        ourPieces.add(pawn8);
        ourPieces.add(pawn9);
        ourPieces.add(pawn10);
        opponentPieces.add(pawn1);
        opponentPieces.add(pawn4);
        opponentPieces.add(pawn5);
        opponentPieces.add(pawn6);
        opponentPieces.add(pawn7);
        opponentPieces.add(pawn11);
        ArrayList<Rect> possibleMoves = arch.getPossibleMoves(ourPieces, opponentPieces, tiles);
        // min -> max
        Collections.sort(possibleMoves, (a, b) -> a.getX() - b.getX());
        assertTrue(possibleMoves.get(0).getX() == pawn4.getX());
        assertTrue(possibleMoves.get(0).getY() == pawn4.getY());
        assertTrue(possibleMoves.get(8).getX() == pawn6.getX());
        assertTrue(possibleMoves.get(8).getY() == pawn6.getY());
        assertTrue(possibleMoves.size() == 9);
    }

    @Test
    public void bishopGetPossibleMovesTest() {
        ArrayList<Piece> ourPieces = new ArrayList<Piece>();
        ArrayList<Piece> opponentPieces = new ArrayList<Piece>();
        ArrayList<Rect> tiles = new ArrayList<Rect>();
        Bishop bishop = new Bishop(48*7, 48*7, "player", null);
        assertTrue(bishop.getX() == 48*7);
        assertTrue(bishop.getY() == 48*7);
        // top left diagonal
        Pawn pawn = new Pawn(48*5, 48*5, "player", null);
        assertTrue(pawn.getX() == 48*5);
        assertTrue(pawn.getY() == 48*5);
        // top right diagonal
        Pawn pawn1 = new Pawn(48*9, 48*5, "player", null);
        assertTrue(pawn1.getX() == 48*9);
        assertTrue(pawn1.getY() == 48*5);
        // bottom left diagonal
        Pawn pawn2 = new Pawn(48*5, 48*9, "player", null);
        assertTrue(pawn2.getX() == 48*5);
        assertTrue(pawn2.getY() == 48*9);
        // bottom right diagonal
        Pawn pawn3 = new Pawn(48*9, 48*9, "player", null);
        assertTrue(pawn3.getX() == 48*9);
        assertTrue(pawn3.getY() == 48*9);
        for (int i = 5; i < 10; i++) {
            for (int j = 5; j < 10; j++) {
                tiles.add(new Rect(48*i, 48*j, 0));
            }
        }
        ourPieces.add(pawn);
        opponentPieces.add(pawn1);
        opponentPieces.add(pawn2);
        opponentPieces.add(pawn3);
        ArrayList<Rect> possibleMoves = bishop.getPossibleMoves(ourPieces, opponentPieces, tiles);
        // min -> max
        Collections.sort(possibleMoves, (a, b) -> a.getX() - b.getX());
        assertTrue(possibleMoves.get(0).getX() == pawn2.getX());
        assertTrue(possibleMoves.get(0).getY() == pawn2.getY());
        assertTrue(possibleMoves.get(6).getX() == pawn3.getX());
        assertTrue(possibleMoves.get(6).getY() == pawn3.getY());
        assertTrue(possibleMoves.size() == 7);
    }

    @Test
    public void CamelGetPossibleMovesTest() {
        ArrayList<Piece> ourPieces = new ArrayList<Piece>();
        ArrayList<Piece> opponentPieces = new ArrayList<Piece>();
        ArrayList<Rect> tiles = new ArrayList<Rect>();
        Camel camel = new Camel(48*7, 48*7, "player", null);
        assertTrue(camel.getX() == 48*7);
        assertTrue(camel.getY() == 48*7);
        // top left
        Pawn pawn = new Pawn(48*6, 48*4, "player", null);
        assertTrue(pawn.getX() == 48*6);
        assertTrue(pawn.getY() == 48*4);
        // lower right
        Pawn pawn1 = new Pawn(48*10, 48*8, "player", null);
        assertTrue(pawn1.getX() == 48*10);
        assertTrue(pawn1.getY() == 48*8);
        // top right
        Pawn pawn2 = new Pawn(48*8, 48*4, "player", null);
        assertTrue(pawn2.getX() == 48*8);
        assertTrue(pawn2.getY() == 48*4);
        // higher left
        Pawn pawn3 = new Pawn(48*4, 48*6, "player", null);
        assertTrue(pawn3.getX() == 48*4);
        assertTrue(pawn3.getY() == 48*6);
        // lower left
        Pawn pawn4 = new Pawn(48*4, 48*8, "player", null);
        assertTrue(pawn4.getX() == 48*4);
        assertTrue(pawn4.getY() == 48*8);
        // higher right
        Pawn pawn5 = new Pawn(48*10, 48*6, "player", null);
        assertTrue(pawn5.getX() == 48*10);
        assertTrue(pawn5.getY() == 48*6);
        // bottom right
        Pawn pawn6 = new Pawn(48*8, 48*10, "player", null);
        assertTrue(pawn6.getX() == 48*8);
        assertTrue(pawn6.getY() == 48*10);
        // bottom left
        Pawn pawn7 = new Pawn(48*6, 48*10, "player", null);
        assertTrue(pawn7.getX() == 48*6);
        assertTrue(pawn7.getY() == 48*10);
        for (int i = 5; i < 10; i++) {
            for (int j = 5; j < 10; j++) {
                tiles.add(new Rect(48*i, 48*j, 0));
            }
        }
        tiles.add(new Rect(48*4, 48*6, 0));
        tiles.add(new Rect(48*4, 48*8, 0));
        tiles.add(new Rect(48*6, 48*4, 0));
        tiles.add(new Rect(48*6, 48*10, 0));
        tiles.add(new Rect(48*8, 48*4, 0));
        tiles.add(new Rect(48*8, 48*10, 0));
        tiles.add(new Rect(48*10, 48*6, 0));
        tiles.add(new Rect(48*10, 48*8, 0));
        ourPieces.add(pawn);
        ourPieces.add(pawn1);
        ourPieces.add(pawn6);
        opponentPieces.add(pawn2);
        opponentPieces.add(pawn3);
        opponentPieces.add(pawn4);
        opponentPieces.add(pawn5);
        opponentPieces.add(pawn7);
        ArrayList<Rect> possibleMoves = camel.getPossibleMoves(ourPieces, opponentPieces, tiles);
        // min -> max
        Collections.sort(possibleMoves, (a, b) -> a.getX() - b.getX());
        assertTrue(possibleMoves.get(0).getX() == pawn3.getX());
        assertTrue(possibleMoves.get(0).getY() == pawn3.getY());
        assertTrue(possibleMoves.get(4).getX() == pawn5.getX());
        assertTrue(possibleMoves.get(4).getY() == pawn5.getY());
        assertTrue(possibleMoves.size() == 5);
    }

    @Test
    public void chancellorGetPossibleMovesTest() {
        ArrayList<Piece> ourPieces = new ArrayList<Piece>();
        ArrayList<Piece> opponentPieces = new ArrayList<Piece>();
        ArrayList<Rect> tiles = new ArrayList<Rect>();
        Chancellor chanc = new Chancellor(48*7, 48*7, "player", null);
        assertTrue(chanc.getX() == 48*7);
        assertTrue(chanc.getY() == 48*7);
        // higher top left
        Pawn pawn = new Pawn(48*6, 48*5, "player", null);
        assertTrue(pawn.getX() == 48*6);
        assertTrue(pawn.getY() == 48*5);
        // horizontal left
        Pawn pawn1 = new Pawn(48*5, 48*7, "player", null);
        assertTrue(pawn1.getX() == 48*5);
        assertTrue(pawn1.getY() == 48*7);
        // vertical down
        Pawn pawn2 = new Pawn(48*7, 48*9, "player", null);
        assertTrue(pawn2.getX() == 48*7);
        assertTrue(pawn2.getY() == 48*9);
        // lower top left
        Pawn pawn3 = new Pawn(48*5, 48*6, "player", null);
        assertTrue(pawn3.getX() == 48*5);
        assertTrue(pawn3.getY() == 48*6);
        // higher bottom left
        Pawn pawn4 = new Pawn(48*5, 48*8, "player", null);
        assertTrue(pawn4.getX() == 48*5);
        assertTrue(pawn4.getY() == 48*8);
        // lower bottom left
        Pawn pawn5 = new Pawn(48*6, 48*9, "player", null);
        assertTrue(pawn5.getX() == 48*6);
        assertTrue(pawn5.getY() == 48*9);
        // lower bottom right
        Pawn pawn6 = new Pawn(48*8, 48*9, "player", null);
        assertTrue(pawn6.getX() == 48*8);
        assertTrue(pawn6.getY() == 48*9);
        // higher bottom right
        Pawn pawn7 = new Pawn(48*9, 48*8, "player", null);
        assertTrue(pawn7.getX() == 48*9);
        assertTrue(pawn7.getY() == 48*8);
        // horizontal right
        Pawn pawn8 = new Pawn(48*9, 48*7, "player", null);
        assertTrue(pawn8.getX() == 48*9);
        assertTrue(pawn8.getY() == 48*7);
        // higher top right
        Pawn pawn9 = new Pawn(48*8, 48*5, "player", null);
        assertTrue(pawn9.getX() == 48*8);
        assertTrue(pawn9.getY() == 48*5);
        // vertical up
        Pawn pawn10 = new Pawn(48*7, 48*5, "player", null);
        assertTrue(pawn10.getX() == 48*7);
        assertTrue(pawn10.getY() == 48*5);
        // lower top right
        Pawn pawn11 = new Pawn(48*9, 48*6, "player", null);
        assertTrue(pawn11.getX() == 48*9);
        assertTrue(pawn11.getY() == 48*6);
        for (int i = 5; i < 10; i++) {
            for (int j = 5; j < 10; j++) {
                tiles.add(new Rect(48*i, 48*j, 0));
            }
        }
        ourPieces.add(pawn);
        ourPieces.add(pawn1);
        ourPieces.add(pawn2);
        ourPieces.add(pawn9);
        opponentPieces.add(pawn3);
        opponentPieces.add(pawn4);
        opponentPieces.add(pawn5);
        opponentPieces.add(pawn6);
        opponentPieces.add(pawn7);
        opponentPieces.add(pawn8);
        opponentPieces.add(pawn10);
        opponentPieces.add(pawn11);
        ArrayList<Rect> possibleMoves = chanc.getPossibleMoves(ourPieces, opponentPieces, tiles);
        // min -> max
        Collections.sort(possibleMoves, (a, b) -> a.getX() - b.getX());
        assertTrue(possibleMoves.get(0).getX() == pawn3.getX());
        assertTrue(possibleMoves.get(0).getY() == pawn3.getY());
        assertTrue(possibleMoves.get(11).getX() == pawn8.getX());
        assertTrue(possibleMoves.get(11).getY() == pawn8.getY());
        assertTrue(possibleMoves.size() == 12);
    }

    @Test
    public void knightGetPossibleMovesTest() {
        ArrayList<Piece> ourPieces = new ArrayList<Piece>();
        ArrayList<Piece> opponentPieces = new ArrayList<Piece>();
        ArrayList<Rect> tiles = new ArrayList<Rect>();
        Knight knight = new Knight(48*7, 48*7, "player", null);
        // higher top left
        Pawn pawn = new Pawn(48*6, 48*5, "player", null);
        // lower top left
        Pawn pawn3 = new Pawn(48*5, 48*6, "player", null);
        // higher bottom left
        Pawn pawn4 = new Pawn(48*5, 48*8, "player", null);
        // lower bottom left
        Pawn pawn5 = new Pawn(48*6, 48*9, "player", null);
        // lower bottom right
        Pawn pawn6 = new Pawn(48*8, 48*9, "player", null);
        // higher bottom right
        Pawn pawn7 = new Pawn(48*9, 48*8, "player", null);
        // higher top right
        Pawn pawn9 = new Pawn(48*8, 48*5, "player", null);
        // lower top right
        Pawn pawn11 = new Pawn(48*9, 48*6, "player", null);
        for (int i = 5; i < 10; i++) {
            for (int j = 5; j < 10; j++) {
                tiles.add(new Rect(48*i, 48*j, 0));
            }
        }
        ourPieces.add(pawn);
        ourPieces.add(pawn9);
        opponentPieces.add(pawn3);
        opponentPieces.add(pawn4);
        opponentPieces.add(pawn5);
        opponentPieces.add(pawn6);
        opponentPieces.add(pawn7);
        opponentPieces.add(pawn11);
        ArrayList<Rect> possibleMoves = knight.getPossibleMoves(ourPieces, opponentPieces, tiles);
        // min -> max
        Collections.sort(possibleMoves, (a, b) -> a.getX() - b.getX());
        assertTrue(possibleMoves.get(0).getX() == pawn3.getX());
        assertTrue(possibleMoves.get(0).getY() == pawn3.getY());
        assertTrue(possibleMoves.get(5).getX() == pawn7.getX());
        assertTrue(possibleMoves.get(5).getY() == pawn7.getY());
        assertTrue(possibleMoves.size() == 6);
    }

    @Test
    public void guardGetPossibleMovesTest() {
        ArrayList<Piece> ourPieces = new ArrayList<Piece>();
        ArrayList<Piece> opponentPieces = new ArrayList<Piece>();
        ArrayList<Rect> tiles = new ArrayList<Rect>();
        Guard guard = new Guard(48*7, 48*7, "player", null);
        // left top
        Pawn pawn = new Pawn(48*6, 48*5, "player", null);
        // right top
        Pawn pawn1 = new Pawn(48*8, 48*5, "player", null);
        // second line 1st tile
        Pawn pawn2 = new Pawn(48*5, 48*6, "player", null);
        // second line 2nd tile
        Pawn pawn3 = new Pawn(48*6, 48*6, "player", null);
        // second line 3rd tile
        Pawn pawn4 = new Pawn(48*7, 48*6, "player", null);
        // second line 4th tile
        Pawn pawn5 = new Pawn(48*8, 48*6, "player", null);
        // second line 5th tile
        Pawn pawn6 = new Pawn(48*9, 48*6, "player", null);
        // third line left
        Pawn pawn7 = new Pawn(48*6, 48*7, "player", null);
        // third line right
        Pawn pawn8 = new Pawn(48*8, 48*7, "player", null);
        // fourth line first tile
        Pawn pawn9 = new Pawn(48*5, 48*8, "player", null);
        // fourth line 2nd tile
        Pawn pawn10 = new Pawn(48*6, 48*8, "player", null);
        // fourth line 3rd tile
        Pawn pawn11 = new Pawn(48*7, 48*8, "player", null);
        // fourth line 4th tile
        Pawn pawn12 = new Pawn(48*8, 48*8, "player", null);
        // fourth line 5th tile
        Pawn pawn13 = new Pawn(48*9, 48*8, "player", null);
        // left bottom
        Pawn pawn14 = new Pawn(48*6, 48*9, "player", null);
        // right bottom
        Pawn pawn15 = new Pawn(48*8, 48*9, "player", null);
        for (int i = 5; i < 10; i++) {
            for (int j = 5; j < 10; j++) {
                tiles.add(new Rect(48*i, 48*j, 0));
            }
        }
        ourPieces.add(pawn2);
        ourPieces.add(pawn12);
        opponentPieces.add(pawn);
        opponentPieces.add(pawn1);
        opponentPieces.add(pawn3);
        opponentPieces.add(pawn4);
        opponentPieces.add(pawn5);
        opponentPieces.add(pawn6);
        opponentPieces.add(pawn7);
        opponentPieces.add(pawn8);
        opponentPieces.add(pawn9);
        opponentPieces.add(pawn10);
        opponentPieces.add(pawn11);
        opponentPieces.add(pawn13);
        opponentPieces.add(pawn14);
        opponentPieces.add(pawn15);
        ArrayList<Rect> possibleMoves = guard.getPossibleMoves(ourPieces, opponentPieces, tiles);
        // min -> max
        Collections.sort(possibleMoves, (a, b) -> a.getX() - b.getX());
        assertTrue(possibleMoves.get(0).getX() == pawn9.getX());
        assertTrue(possibleMoves.get(0).getY() == pawn9.getY());
        assertTrue(possibleMoves.get(13).getX() == pawn13.getX());
        assertTrue(possibleMoves.get(13).getY() == pawn13.getY());
        assertTrue(possibleMoves.size() == 14);
    }

    @Test
    public void kingGetPossibleMovesTest() {
        ArrayList<Piece> ourPieces = new ArrayList<Piece>();
        ArrayList<Piece> opponentPieces = new ArrayList<Piece>();
        ArrayList<Rect> tiles = new ArrayList<Rect>();
        King king = new King(48*7, 48*7, "player", null);
        Rook rook1 = new Rook(48*4, 48*7, "player", null);
        Rook rook2 = new Rook(48*10, 48*7, "player", null);
        king.setMoved(false);
        rook1.setMoved(false);
        rook2.setMoved(false);
        assertFalse(king.hasBeingMoved());
        // first line 1st tile
        Pawn pawn = new Pawn(48*6, 48*6, "player", null);
        // first line 2nd tile
        Pawn pawn1 = new Pawn(48*7, 48*6, "player", null);
        // first line 3rd tile
        Pawn pawn2 = new Pawn(48*8, 48*6, "player", null);
        // second line 1st tile
        Pawn pawn3 = new Pawn(48*5, 48*7, "player", null);
        // second line 4th tile
        Pawn pawn6 = new Pawn(48*9, 48*7, "player", null);
        // third line 1st tile
        Pawn pawn7 = new Pawn(48*6, 48*8, "player", null);
        // third line 2nd tile
        Pawn pawn8 = new Pawn(48*7, 48*8, "player", null);
        // third line 3rd tile
        Pawn pawn9 = new Pawn(48*8, 48*8, "player", null);
        for (int i = 6; i < 9; i++) {
            for (int j = 6; j < 9; j++) {
                tiles.add(new Rect(48*i, 48*j, 0));
            }
        }
        tiles.add(new Rect(48*5, 48*7, 0));
        tiles.add(new Rect(48*9, 48*7, 0));
        ourPieces.add(pawn9);
        ourPieces.add(rook1);
        ourPieces.add(rook2);
        opponentPieces.add(pawn);
        opponentPieces.add(pawn1);
        opponentPieces.add(pawn2);
        opponentPieces.add(pawn3);
        opponentPieces.add(pawn6);
        opponentPieces.add(pawn7);
        opponentPieces.add(pawn8);
        ArrayList<Rect> possibleMoves = king.getPossibleMoves(ourPieces, opponentPieces, tiles);
        // min -> max
        Collections.sort(possibleMoves, (a, b) -> a.getX() - b.getX());
        assertTrue(possibleMoves.get(0).getX() == pawn3.getX());
        assertTrue(possibleMoves.get(0).getY() == pawn3.getY());
        assertTrue(possibleMoves.get(8).getX() == pawn6.getX());
        assertTrue(possibleMoves.get(8).getY() == pawn6.getY());
        assertTrue(possibleMoves.size() == 9);
    }

    @Test
    public void pawnGetPossibleMovesTestOne() {
        ArrayList<Piece> ourPieces = new ArrayList<Piece>();
        ArrayList<Piece> opponentPieces = new ArrayList<Piece>();
        ArrayList<Rect> tiles = new ArrayList<Rect>();
        // if is human player and not at 13th rank
        Pawn pawn = new Pawn(48*7, 48*7, "human", null);
        Rook rook1 = new Rook(48*7, 48*5, "human", null);
        Rook rook2 = new Rook(48*8, 48*6, "cpu", null);
        Rook rook3 = new Rook(48*6, 48*6, "cpu", null);
        ourPieces.add(rook1);
        opponentPieces.add(rook2);
        opponentPieces.add(rook3);
        tiles.add(new Rect(48*6, 48*6, 0));
        tiles.add(new Rect(48*7, 48*6, 0));
        tiles.add(new Rect(48*8, 48*6, 0));
        tiles.add(new Rect(48*7, 48*5, 0));
        ArrayList<Rect> possibleMoves = pawn.getPossibleMoves(ourPieces, opponentPieces, tiles);
        // min -> max
        Collections.sort(possibleMoves, (a, b) -> a.getX() - b.getX());
        assertTrue(possibleMoves.get(0).getX() == rook3.getX());
        assertTrue(possibleMoves.get(0).getY() == rook3.getY());
        assertTrue(possibleMoves.get(2).getX() == rook2.getX());
        assertTrue(possibleMoves.get(2).getY() == rook2.getY());
        assertTrue(possibleMoves.size() == 3);
    }

    @Test
    public void pawnGetPossibleMovesTestTwo() {
        ArrayList<Piece> ourPieces = new ArrayList<Piece>();
        ArrayList<Piece> opponentPieces = new ArrayList<Piece>();
        ArrayList<Rect> tiles = new ArrayList<Rect>();
        // if is human player and at 13th rank
        Pawn pawn = new Pawn(48*7, 48*12, "human", null);
        Rook rook1 = new Rook(48*7, 48*10, null, null);
        Rook rook2 = new Rook(48*8, 48*11, "cpu", null);
        Rook rook3 = new Rook(48*6, 48*11, "cpu", null);
        ourPieces.add(rook1);
        opponentPieces.add(rook2);
        opponentPieces.add(rook3);
        tiles.add(new Rect(48*7, 48*10, 0));
        tiles.add(new Rect(48*6, 48*11, 0));
        tiles.add(new Rect(48*8, 48*11, 0));
        tiles.add(new Rect(48*7, 48*12, 0));
        ArrayList<Rect> possibleMoves = pawn.getPossibleMoves(ourPieces, opponentPieces, tiles);
        // min -> max
        Collections.sort(possibleMoves, (a, b) -> a.getX() - b.getX());
        assertTrue(possibleMoves.get(0).getX() == rook3.getX());
        assertTrue(possibleMoves.get(0).getY() == rook3.getY());
        assertTrue(possibleMoves.get(2).getX() == rook2.getX());
        assertTrue(possibleMoves.get(2).getY() == rook2.getY());
        assertTrue(possibleMoves.size() == 3);
    }

    @Test
    public void pawnGetPossibleMovesTestThree() {
        ArrayList<Piece> ourPieces = new ArrayList<Piece>();
        ArrayList<Piece> opponentPieces = new ArrayList<Piece>();
        ArrayList<Rect> tiles = new ArrayList<Rect>();
        // if is cpu player and not at 2nd rank
        Pawn pawn = new Pawn(48*7, 48*7, "cpu", null);
        Rook rook2 = new Rook(48*6, 48*8, "human", null);
        Rook rook3 = new Rook(48*8, 48*8, "human", null);
        opponentPieces.add(rook2);
        opponentPieces.add(rook3);
        tiles.add(new Rect(48*7, 48*7, 0));
        tiles.add(new Rect(48*8, 48*8, 0));
        tiles.add(new Rect(48*6, 48*8, 0));
        ArrayList<Rect> possibleMoves = pawn.getPossibleMoves(ourPieces, opponentPieces, tiles);
        // min -> max
        Collections.sort(possibleMoves, (a, b) -> a.getX() - b.getX());
        assertTrue(possibleMoves.get(0).getX() == rook2.getX());
        assertTrue(possibleMoves.get(0).getY() == rook2.getY());
        assertTrue(possibleMoves.get(2).getX() == rook3.getX());
        assertTrue(possibleMoves.get(2).getY() == rook3.getY());
        assertTrue(possibleMoves.size() == 3);
    }

    @Test
    public void pawnGetPossibleMovesTestFour() {
        ArrayList<Piece> ourPieces = new ArrayList<Piece>();
        ArrayList<Piece> opponentPieces = new ArrayList<Piece>();
        ArrayList<Rect> tiles = new ArrayList<Rect>();
        // if is cpu player and at 2nd rank
        Pawn pawn = new Pawn(48*7, 48, "cpu", null);
        Rook rook1 = new Rook(48*7, 48*3, "cpu", null);
        Rook rook2 = new Rook(48*6, 48*2, "human", null);
        Rook rook3 = new Rook(48*8, 48*2, "human", null);
        ourPieces.add(rook1);
        opponentPieces.add(rook2);
        opponentPieces.add(rook3);
        tiles.add(new Rect(48*7, 48*3, 0));
        tiles.add(new Rect(48*7, 48, 0));
        tiles.add(new Rect(48*8, 48*2, 0));
        tiles.add(new Rect(48*6, 48*2, 0));
        ArrayList<Rect> possibleMoves = pawn.getPossibleMoves(ourPieces, opponentPieces, tiles);
        // min -> max
        Collections.sort(possibleMoves, (a, b) -> a.getX() - b.getX());
        assertTrue(possibleMoves.get(0).getX() == rook2.getX());
        assertTrue(possibleMoves.get(0).getY() == rook2.getY());
        assertTrue(possibleMoves.get(2).getX() == rook3.getX());
        assertTrue(possibleMoves.get(2).getY() == rook3.getY());
        assertTrue(possibleMoves.size() == 3);
    }

    @Test
    public void pawpawGetPossibleMovesTest() {
        ArrayList<Piece> ourPieces = new ArrayList<Piece>();
        ArrayList<Piece> opponentPieces = new ArrayList<Piece>();
        ArrayList<Rect> tiles = new ArrayList<Rect>();
        Pawpaw pawpaw = new Pawpaw(48*7, 48*7, "human", null);
        Pawn pawn = new Pawn(48*3, 48*7, "cpu", null);
        Pawn pawn1 = new Pawn(48*11, 48*7, "cpu", null);
        opponentPieces.add(pawn);
        opponentPieces.add(pawn1);
        for (int i = 3; i < 12; i++) {
            tiles.add(new Rect(48*i, 48*7, 0));
        }
        tiles.add(new Rect(48*7, 48*6, 0));
        tiles.add(new Rect(48*7, 48*8, 0));
        ArrayList<Rect> possibleMoves = pawpaw.getPossibleMoves(ourPieces, opponentPieces, tiles);
        // min -> max
        Collections.sort(possibleMoves, (a, b) -> a.getX() - b.getX());
        assertTrue(possibleMoves.get(0).getX() == pawn.getX());
        assertTrue(possibleMoves.get(0).getY() == pawn.getY());
        assertTrue(possibleMoves.get(9).getX() == pawn1.getX());
        assertTrue(possibleMoves.get(9).getY() == pawn1.getY());
        assertTrue(possibleMoves.size() == 10);
    }

    @Test
    public void queenGetPossibleMovesTest() {
        ArrayList<Piece> ourPieces = new ArrayList<Piece>();
        ArrayList<Piece> opponentPieces = new ArrayList<Piece>();
        ArrayList<Rect> tiles = new ArrayList<Rect>();
        Queen queen = new Queen(48*7, 48*7, "human", null);
        Pawn pawn =  new Pawn(48*3, 48*7, "cpu", null);
        Pawn pawn1 =  new Pawn(48*12, 48*7, "human", null);
        Pawn pawn2 =  new Pawn(48*4, 48*4, "cpu", null);
        Pawn pawn3 =  new Pawn(48*9, 48*5, "cpu", null);
        Pawn pawn4 =  new Pawn(48*7, 48*3, "cpu", null);
        Pawn pawn5 =  new Pawn(48*7, 48*12, "cpu", null);
        Pawn pawn6 =  new Pawn(48*5, 48*9, "cpu", null);
        Pawn pawn7 =  new Pawn(48*11, 48*11, "cpu", null);
        opponentPieces.add(pawn);
        ourPieces.add(pawn1);
        opponentPieces.add(pawn2);
        opponentPieces.add(pawn3);
        opponentPieces.add(pawn4);
        opponentPieces.add(pawn5);
        opponentPieces.add(pawn6);
        opponentPieces.add(pawn7);
        for (int i = 3; i < 13; i++) {
            tiles.add(new Rect(48*i, 48*7, 0));
            tiles.add(new Rect(48*7, 48*i, 0));
        }
        for (int i = 4; i < 12; i++) {
            tiles.add(new Rect(48*i, 48*i, 0));
        }
        tiles.add(new Rect(48*5, 48*9, 0));
        tiles.add(new Rect(48*6, 48*8, 0));
        tiles.add(new Rect(48*7, 48*7, 0));
        tiles.add(new Rect(48*8, 48*6, 0));
        tiles.add(new Rect(48*9, 48*5, 0));
        ArrayList<Rect> possibleMoves = queen.getPossibleMoves(ourPieces, opponentPieces, tiles);
        // min -> max
        Collections.sort(possibleMoves, (a, b) -> a.getX() - b.getX());
        assertTrue(possibleMoves.get(0).getX() == pawn.getX());
        assertTrue(possibleMoves.get(0).getY() == pawn.getY());
        assertTrue(possibleMoves.get(27).getX() == pawn1.getX() - 48);
        assertTrue(possibleMoves.get(27).getY() == pawn1.getY());
        assertTrue(possibleMoves.size() == 28);
    }

    @Test
    public void rookGetPossibleMovesTest() {
        ArrayList<Piece> ourPieces = new ArrayList<Piece>();
        ArrayList<Piece> opponentPieces = new ArrayList<Piece>();
        ArrayList<Rect> tiles = new ArrayList<Rect>();
        Rook rook = new Rook(48*7, 48*7, "human", null);
        Pawn pawn = new Pawn(48*3, 48*7, "human", null);
        Pawn pawn1 = new Pawn(48*10, 48*7, "cpu", null);
        Pawn pawn2 = new Pawn(48*7, 48*4, "cpu", null);
        Pawn pawn3 = new Pawn(48*7, 48*11, "cpu", null);
        ourPieces.add(pawn);
        opponentPieces.add(pawn1);
        opponentPieces.add(pawn2);
        opponentPieces.add(pawn3);
        for (int i = 3; i < 11; i++) {
            tiles.add(new Rect(48*i, 48*7, 0));
        }
        for (int i = 4; i < 12; i++) {
            tiles.add(new Rect(48*7, 48*i, 0));
        }
        ArrayList<Rect> possibleMoves = rook.getPossibleMoves(ourPieces, opponentPieces, tiles);
        // min -> max
        Collections.sort(possibleMoves, (a, b) -> a.getX() - b.getX());
        assertTrue(possibleMoves.get(0).getX() == pawn.getX() + 48);
        assertTrue(possibleMoves.get(0).getY() == pawn.getY());
        assertTrue(possibleMoves.get(12).getX() == pawn1.getX());
        assertTrue(possibleMoves.get(12).getY() == pawn1.getY());
        assertTrue(possibleMoves.size() == 13);
    }

    // GAME
    @Test
    public void hasHumanPieceTest() {
        ArrayList<Piece> humanPieces = new ArrayList<Piece>();
        humanPieces.add(new Pawn(48, 48, "player", null));
        Game game = new Game(120, 14, 48*14+120, 48, 14, 60, null, humanPieces, null, null);
        assertTrue(game.hasHumanPiece(48, 48));
    }

    @Test
    public void tileIsClickedTest() {
        Game game = new Game(120, 14, 48*14+120, 48, 14, 60, null, null, null, null);
        game.setXClicked(24);
        game.setYClicked(24);
        assertTrue(game.tileIsClicked(0, 0));
    }

    @Test
    public void getTileClickedTest() {
        ArrayList<Rect> tiles = new ArrayList<Rect>();
        Rect tile1 = new Rect(0, 0, 0);
        Rect tile2 = new Rect(48, 48, 0);
        tiles.add(tile1);
        tiles.add(tile2);
        Game game = new Game(120, 14, 48*14+120, 48, 14, 60, tiles, null, null, null);
        game.setXClicked(24);
        game.setYClicked(24);
        assertTrue(game.getTileClicked() == tile1);
    }

    @Test
    public void isPossibleMoveTest() {
        Rect tile = new Rect(0, 0, 0);
        Rect tile1 = new Rect(48, 0, 0);
        Rect tile2 = new Rect(96, 48, 0);
        ArrayList<Rect> possibleMoves = new ArrayList<Rect>();
        possibleMoves.add(tile);
        possibleMoves.add(tile1);
        possibleMoves.add(tile2);
        Game game = new Game(120, 14, 48*14+120, 48, 14, 60, null, null, null, null);
        assertTrue(game.isPossibleMove(tile, possibleMoves));
    }

    @Test
    public void removePieceTest() {
        Pawn pawn = new Pawn(0, 0, "player", null);
        Pawn pawn1 = new Pawn(48, 0, "player", null);
        Pawn pawn2 = new Pawn(0, 48, "player", null);
        ArrayList<Piece> pieces = new ArrayList<Piece>();
        pieces.add(pawn);
        pieces.add(pawn1);
        pieces.add(pawn2);
        Game game = new Game(120, 14, 48*14+120, 48, 14, 60, null, null, null, null);
        game.removePiece(pieces, pawn);
        assertTrue(!pieces.contains(pawn));
    }

    @Test
    public void hasCPUPieceTest() {
        ArrayList<Piece> cpuPieces = new ArrayList<Piece>();
        Pawn pawn = new Pawn(0, 0, "cpu", null);
        Pawn pawn1 = new Pawn(48, 0, "cpu", null);
        Pawn pawn2 = new Pawn(0, 48, "cpu", null);
        cpuPieces.add(pawn);
        cpuPieces.add(pawn1);
        cpuPieces.add(pawn2);
        Game game = new Game(120, 14, 48*14+120, 48, 14, 60, null, null, cpuPieces, null);
        assertTrue(game.hasCPUPiece(0, 0));
    }

    @Test
    public void getCapturedPieceTest() {
        ArrayList<Piece> opponentPieces = new ArrayList<Piece>();
        Pawn pawn = new Pawn(0, 0, "cpu", null);
        Pawn pawn1 = new Pawn(48, 0, "cpu", null);
        Pawn pawn2 = new Pawn(0, 48, "cpu", null);
        opponentPieces.add(pawn);
        opponentPieces.add(pawn1);
        opponentPieces.add(pawn2);
        Game game = new Game(120, 14, 48*14+120, 48, 14, 60, null, null, null, null);
        assertTrue(game.getCapturedPiece(opponentPieces, 0, 0) == pawn);
    }

    @Test
    public void containsHumanPieceTest() {
        ArrayList<Piece> humanPieces = new ArrayList<Piece>();
        Pawn pawn = new Pawn(0, 0, "cpu", null);
        Pawn pawn1 = new Pawn(48, 0, "cpu", null);
        Pawn pawn2 = new Pawn(0, 48, "cpu", null);
        humanPieces.add(pawn);
        humanPieces.add(pawn1);
        humanPieces.add(pawn2);
        Game game = new Game(120, 14, 48*14+120, 48, 14, 60, null, humanPieces, null, null);
        assertTrue(game.containsHumanPiece(0, 0));
    }

    @Test
    public void calSpeedTest() {
        ArrayList<Piece> ourPieces = new ArrayList<Piece>();
        King king = new King(0, 0, "player", null);
        Pawn pawn = new Pawn(0, 48, "player", null);
        Pawpaw pawpaw = new Pawpaw(48, 0, "player", null);
        ourPieces.add(pawn);
        ourPieces.add(king);
        ourPieces.add(pawpaw);
        Rect tile = new Rect(0, 0, 0);
        Rect tile1 = new Rect(48, 0, 0);
        Rect tile2 = new Rect(96, 48, 0);
        ArrayList<Rect> tiles = new ArrayList<Rect>();
        tiles.add(tile);
        tiles.add(tile1);
        tiles.add(tile2);
        Game game = new Game(120, 14, 48*14+120, 48, 14, 60, tiles, null, null, null);
        assertTrue(game.getKingTile(ourPieces) == tile);
    }

    @Test
    public void getTileTest() {
        Rect tile = new Rect(0, 0, 0);
        Rect tile1 = new Rect(48, 0, 0);
        Rect tile2 = new Rect(96, 48, 0);
        ArrayList<Rect> tiles = new ArrayList<Rect>();
        tiles.add(tile);
        tiles.add(tile1);
        tiles.add(tile2);
        Game game = new Game(120, 14, 48*14+120, 48, 14, 60, tiles, null, null, null);
        assertTrue(game.getTile(0, 0) == tile);
    }

    @Test
    public void isConsecutiveTileTest() {
        Rect tile = new Rect(0, 0, 0);
        Rect tile1 = new Rect(48, 0, 0);
        Game game = new Game(120, 14, 48*14+120, 48, 14, 60, null, null, null, null);
        assertTrue(game.isConsecutiveTile(tile, tile1));
    }

    @Test
    public void isDupTest() {
        Rect tile = new Rect(0, 0, 0);
        Rect tile1 = new Rect(48, 0, 0);
        Rect tile2 = new Rect(96, 48, 0);
        ArrayList<Rect> allPossibleMoves = new ArrayList<Rect>();
        allPossibleMoves.add(tile);
        allPossibleMoves.add(tile1);
        allPossibleMoves.add(tile2);
        Game game = new Game(120, 14, 48*14+120, 48, 14, 60, null, null, null, null);
        assertTrue(game.isDup(0, 0, allPossibleMoves));
    }

    @Test
    public void getAllPossibleMovesTest() {
        ArrayList<Piece> ourPieces = new ArrayList<Piece>();
        ArrayList<Piece> opponentPieces = new ArrayList<Piece>();
        ArrayList<Rect> tiles = new ArrayList<Rect>();
        Pawn pawn = new Pawn(48*8, 48*6, "human", null);
        Pawn pawn1 = new Pawn(48*5, 48*8, "human", null);
        Pawn pawn2 = new Pawn(48*7, 48*8, "human", null);
        Pawn pawn3 = new Pawn(48*9, 48*6, "human", null);
        Pawn pawn4 = new Pawn(48*7, 48*5, "human", null);
        Pawn pawn5 = new Pawn(48*9, 48*5, "human", null);
        Camel camel = new Camel(48*6, 48*5, "human", null);
        ourPieces.add(pawn);
        ourPieces.add(camel);
        opponentPieces.add(pawn1);
        opponentPieces.add(pawn2);
        opponentPieces.add(pawn3);
        opponentPieces.add(pawn4);
        opponentPieces.add(pawn5);
        for (int i = 5; i < 10; i++) {
            for (int j = 5; j < 10; j++) {
                tiles.add(new Rect(48*i, 48*j, 0));
            }
        }
        Game game = new Game(120, 14, 48*14+120, 48, 14, 60, tiles, null, null, null);
        ArrayList<Rect> allPossibleMoves = game.getAllPossibleMoves(ourPieces, opponentPieces);
        // min -> max
        Collections.sort(allPossibleMoves, (a, b) -> a.getX() - b.getX());
        assertTrue(allPossibleMoves.get(0).getX() == 48*5);
        assertTrue(allPossibleMoves.get(0).getY() == 48*5);
        assertTrue(allPossibleMoves.get(7).getX() == pawn3.getX());
        assertTrue(allPossibleMoves.get(7).getY() == pawn3.getY());
        assertTrue(allPossibleMoves.size() == 8);
    }

    @Test
    public void getKingPieceTest() {
        ArrayList<Piece> ourPieces = new ArrayList<Piece>();
        Pawn pawn = new Pawn(0, 0, null, null);
        King king = new King(48, 48, null, null);
        Rook rook = new Rook(96, 0, null, null);
        ourPieces.add(pawn);
        ourPieces.add(king);
        ourPieces.add(rook);
        Game game = new Game(120, 14, 48*14+120, 48, 14, 60, null, null, null, null);
        assertTrue(game.getKingPiece(ourPieces) == king);
    }

    @Test
    public void restartGameTest() {
        ArrayList<Piece> humanPieces = new ArrayList<Piece>();
        ArrayList<Piece> cpuPieces = new ArrayList<Piece>();
        ArrayList<Rect> tiles = new ArrayList<Rect>();
        Pawn pawn = new Pawn(0, 0, null, null);
        King king = new King(48, 48, null, null);
        Rook rook = new Rook(96, 0, null, null);
        Pawn pawn1 = new Pawn(48, 0, null, null);
        King king1 = new King(0, 48, null, null);
        Rook rook1 = new Rook(0, 96, null, null);
        humanPieces.add(pawn);
        humanPieces.add(king);
        humanPieces.add(rook);
        cpuPieces.add(pawn1);
        cpuPieces.add(king1);
        cpuPieces.add(rook1);
        tiles.add(new Rect(0, 0, 0));
        Game game = new Game(120, 14, 48*14+120, 48, 14, 60, tiles, humanPieces, cpuPieces, null);
        game.restartGame();
        for (Piece p : humanPieces) {
            assertTrue(p.getX() == p.getStartXCoor());
            assertTrue(p.getY() == p.getStartYCoor());
        }
        for (Piece p : cpuPieces) {
            assertTrue(p.getX() == p.getStartXCoor());
            assertTrue(p.getY() == p.getStartYCoor());
        }
    }

    // APP
    @Test
    public void settingsTest() {
        App app = new App();
        PApplet.runSketch(new String[] {"App"}, app);
        assertNotNull(app);
        app.setup();
        assertTrue(app.queenImages.size() == 4);
        assertTrue(app.tiles.size() == 392);
    }



}
