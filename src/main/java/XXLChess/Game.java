package XXLChess;

import processing.core.*;
import java.util.*;

public class Game {

    private final int CELLSIZE;
    private final int BOARD_WIDTH;
    private final int WIDTH;
    private final int HEIGHT;
    private final int SIDEBAR;
    private static final int SECOND = 60;

    private final int FPS;
    private double pieceMovementSpeed;
    private int maxMovementTime;

    private static final int DARK_GREEN = 0xFFAAA23A;
    private static final int LIGHT_GREEN = 0xFFCDD26A;
    private static final int DARK_RED = 0xFFFF0000;
    private static final int GREY = 178;

    private ArrayList<Rect> tiles;
    private ArrayList<Piece> humanPieces;
    private ArrayList<Piece> cpuPieces;

    // tile selected and piece selected of human player
    private Rect tileSelected;
    private Piece pieceSelected;

    // cpu's selected piece
    private Piece cpuSelectedPiece;

    private boolean isClicked;
    private int xClicked;
    private int yClicked;

    private ArrayList<PImage> queenImages;

    private Piece leftRook;
    private Piece rightRook;

    // support movement
    private double totalFrame;
    private double xSpeed;
    private double ySpeed;
    private int startFrameCount;
    // human's player's movement
    private int moveCounter;
    // cpu's movement
    private int cpuMoveCounter;
    private int randomMove;
    private Rect cpuSelectedTile;

    // true if is human's turn first
    private boolean humanTurn;

    private ArrayList<Rect> humanPossibleMoves = new ArrayList<Rect>();
    private ArrayList<Rect> cpuPossibleMoves = new ArrayList<Rect>();

    private ArrayList<Rect> humanAllPossibleMoves = new ArrayList<Rect>();
    private ArrayList<Rect> cpuAllPossibleMoves = new ArrayList<Rect>();

    private Piece humanKingPiece;
    private Piece cpuKingPiece;

    private int playerTime;
    private int playerInc;
    private int cpuTime;
    private int cpuInc;

    // mark the previous move with yellow
    private boolean changeBackCol;  // for human only
    private Rect humanPrevTile;
    private Rect humanTileMoveTo;
    private Rect cpuPrevTile;
    private Rect cpuTileMoveTo;

    private boolean restart;

    // timer
    private int humanTimeCounter;
    private int cpuTimeCounter;
    private int humanTimerHeight;
    private int cpuTimerHeight;
    
    public Game(int SIDEBAR, int WIDTH, int HEIGHT, int CELLSIZE, int BOARD_WIDTH, int FPS, ArrayList<Rect> tiles, 
        ArrayList<Piece> humanPieces, ArrayList<Piece> cpuPieces, 
        ArrayList<PImage> queenImages) {
            this.CELLSIZE = CELLSIZE;
            this.BOARD_WIDTH = BOARD_WIDTH;
            this.WIDTH = WIDTH;
            this.HEIGHT = HEIGHT;
            this.SIDEBAR = SIDEBAR;

            this.FPS = FPS;
            
            this.tiles = tiles;
            this.humanPieces = humanPieces;
            this.cpuPieces = cpuPieces;
            
            this.queenImages = queenImages;

            this.moveCounter = 0;
            this.cpuMoveCounter = 0;

            this.changeBackCol = false;

            this.restart = false;

            this.humanTimeCounter = 0;
            this.cpuTimeCounter = 0;

            this.humanTimerHeight = HEIGHT/2 + 270;
            this.cpuTimerHeight = HEIGHT/2 - 250;
    }

    /**
     * @param time
     * The time to be set.
     * Set the timer for human player.
     */
    public void setPlayerTime(int time) {
        this.playerTime = time;
    }

    /**
     * @param increment
     * The time increment to be set.
     * Set the increment time for human player.
     */
    public void setPlayerInc(int increment) {
        this.playerInc = increment;
    }

    /**
     * @param time
     * The time to be set.
     * Set the timer for cpu player.
     */
    public void setCPUTime(int time) {
        this.cpuTime = time;
    }

    /**
     * @param increment
     * The time increment to be set.
     * Set the increment time for cpu player.
     */
    public void setCPUInc(int increment) {
        this.cpuInc = increment;
    }

    /**
     * @param b
     * The boolean value to set restart to.
     * Set the boolean value for restart.
     */
    public void setRestart(boolean b) {
        this.restart = b;
    }

    /**
     * @return human pieces
     * Return a list of human pieces.
     */
    public ArrayList<Piece> getHumanPieces() {
        return this.humanPieces;
    }

    /**
     * @param s
     * The string that indicates the color of the human player's pieces.
     * If player color is "white", then it's human's turn first since white pieces can move first.
     * Else if the player color is "black", then it's the AI's turn first.
     */
    public void setFirstPlayer(String s) {
        if (s.equals("white"))
            humanTurn = true;
        else if (s.equals("black"))
            humanTurn = false;
    }   

    /**
     * @param speed
     * The movement speed to be set.
     * Set the movement speed of the piece.
     */
    public void setPieceMovementSpeed(double speed) {
        this.pieceMovementSpeed = speed;
    }

    /**
     * @param maxTime
     * The maximum time of movement to be set.
     * Set the maximum movement time of movement for a piece.
     */
    public void setMaxMovementTime(int maxTime) {
        this.maxMovementTime = maxTime;
    }

    
    /** 
     * @param xClick
     * The x coordinate of the pixel that is being clicked.
     * Set the x coordinate of the pixel that is being clicked.
     */
    public void setXClicked(int xClick) {
        this.xClicked = xClick;
    }

    /**
     * @param yCLick
     * The y coordinate of the pixel that is being clicked.
     * Set the y coordinate of the pixel that is being clicked.
     */
    public void setYClicked(int yCLick) {
        this.yClicked = yCLick;
    }

    /**
     * @param bool
     * The boolean indicating whether a mouse click event happens or not.
     * Set the boolean value to indicate if there is a mouse click event happening.
     */
    public void setIsClicked(boolean bool) {
        this.isClicked = bool;
    }

    /**
     * @param x
     * The x coordinate of the selected tile.
     * @param y
     * The y coordinate of the selected tile.
     * @return boolean
     * Check if the selected tile contains a human piece and set the current 
     * selected piece to be the human piece.
     */
    public boolean hasHumanPiece(int x, int y) {
        for (Piece p : humanPieces) {
            if (p.getX() == x && p.getY() == y) {
                return true;
            }
        }
        return false;
    }

    /**
     * The y coordinate of the tile that is used to get the piece. Find the piece that 
     * is being selected by human player using the coordinate of the tile 
     * that is being clicked.
     */
    public void setSelectedHumanPiece() {
        for (Piece p : humanPieces) {
            if (p.getX() == tileSelected.getX() && p.getY() == tileSelected.getY()) {
                this.pieceSelected = p;
                break;
            }
        }
    }

    /**
     * @param app
     * The app which we display everything of the game.
     * Change the colors of the possible moves of human player's selected piece.
     */
    public void changeToBlue(PApplet app) {
        for (Rect tile : tiles) {
            for (Rect move : humanPossibleMoves) {
                // if the tile is one of the possible moves of the piece
                if (tile.getX() == move.getX() && tile.getY() == move.getY()) {
                    // change tile's color to move tile's color
                    tile.changeColor(move.getColor());
                }
            }
        }
    }
    
    /**
     * @param x
     * The x coordinate of the tile that is being checked.
     * @param y
     * The y coordinate of the tile that is being checked.
     * @return boolean
     * Check if the tile with the given coordinate is being clicked. Returns 
     * true if it is.
     */
    public boolean tileIsClicked(int x, int y) {
        /*
            * if the x, y coordinates of the place where we click is in one
            * of our tiles, then the x, y coordinates must be within the two x, y
            * coordinates of the tiles
        */
        int xRange = this.xClicked - x;
        int yRange = this.yClicked - y;
        if (xRange < this.CELLSIZE && xRange > 0 
            && yRange < this.CELLSIZE && yRange > 0) {
                return true;
        }
        return false;
    }

    /**
     * @return tile
     * Get the tile that is being clicked on.
     */
    public Rect getTileClicked() {
        int xRange;
        int yRange;
        Rect rect = tiles.get(0);
        for (Rect r : tiles) {
            xRange = xClicked - r.getX();
            yRange = yClicked - r.getY();
            if (xRange < CELLSIZE && xRange > 0 
            && yRange < CELLSIZE && yRange > 0) {
                rect = r;
                break;
            }
        }
        return rect;
    }

    /**
     * @param app
     * The app which we display everything of the game.
     * @param tile
     * The tile that we want to change color.
     * Change the color of the tile that contains the selected piece to dark green.
     */
    public void changeTileColourWhenClicked(PApplet app, Rect tile) {
        tile.changeColor(DARK_GREEN);
        tile.drawRect(app);
    }

    /**
     * @param app
     * The app which we display everything of the game.
     * @param tile
     * The tile that we want to change color.
     * @param possibleMoves
     * An array list that stores the possible moves of the tile.
     * Change the colors of the tiles back to their original colours when the 
     * piece finishes its move or the player unselects the piece.
     */
    public void changeBackColourWhenCLicked(PApplet app, Rect tile, ArrayList<Rect> possibleMoves) {
        tile.changeColor(tile.getOriginalColor());
        tile.drawRect(app);
        for (int i = 0; i < possibleMoves.size(); i++) {
            possibleMoves.get(i).changeColor(possibleMoves.get(i).getOriginalColor());
            possibleMoves.get(i).drawRect(app);
        }
    }

    /**
     * @param tile
     * The tile we want to check if it is a possible move of a piece.
     * @param possibleMoves
     * An array list containing the possible moves of a piece.
     * @return boolean
     * Check if the tile is one of the possible moves.
     */
    public boolean isPossibleMove(Rect tile, ArrayList<Rect> possibleMoves) {
        for (Rect r : possibleMoves) {
            if (tile == r) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param pieces
     * An array list of pieces.
     * @param p
     * The piece we want to remove from the list of pieces.
     * Remove a piece from a list of pieces.
     */
    public void removePiece(ArrayList<Piece> pieces, Piece p) {
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getX() == p.getX() 
                && pieces.get(i).getY() == p.getY()) {
                    pieces.remove(i);
            }
        }
    } 

    /**
     * @param isHumanPiece
     * A boolean indicates whether it is the human or the AI player.
     * @param x
     * The x coordinate of the destination tile we want to spawn the queen.
     * @param y
     * The y coordinate of the destination tile we want to spawn the queen.
     * Promote pawn to queen when the pawn reaches 8th rank.
     */
    public void changeToQueen(boolean isHumanPiece, int x, int y) {
        /*
         * make a queen object with the same coordinates,
         * add to the whitePiece or blackPiece list,
         * remove this piece from the whitePiece or blackPiece list
         */
        Piece queen;
        if (isHumanPiece) {
            removePiece(humanPieces, pieceSelected);
            queen = new Queen(x, y, pieceSelected.getPlayer(), queenImages.get(1));
            humanPieces.add(queen);
        }
        else {
            removePiece(cpuPieces, pieceSelected);
            queen = new Queen(x, y, pieceSelected.getPlayer(), queenImages.get(0));
            cpuPieces.add(queen);
        }
        pieceSelected = queen;
    }

    /**
     * @param x
     * The x coordinate to check for the AI piece.
     * @param y
     * The y coordinate to check for the AI piece.
     * @return boolean
     * Check if the tile with the given coordinate has an AI piece on it. Returns
     * true if it does.
     */
    public boolean hasCPUPiece(int x, int y) {
        for (int i = 0; i < cpuPieces.size(); i++) {
            if (cpuPieces.get(i).getX() == x
                && cpuPieces.get(i).getY() == y) {
                    return true;
            }
        }
        return false;
    }

    /**
     * @param opponentPieces
     * An array list containing the pieces of opponent player.
     * @param x
     * The x coordinate that we want to check if the opponent piece has it.
     * @param y
     * The y coordinate that we want to check if the opponent piece has it.
     * @return piece
     * Return the piece that is being captured from a list of opponent's pieces.
     */
    public Piece getCapturedPiece(ArrayList<Piece> opponentPieces, int x, int y) {
        Piece p = opponentPieces.get(0);
        for (int i = 0; i < opponentPieces.size(); i++) {
            if (opponentPieces.get(i).getX() == x
                && opponentPieces.get(i).getY() == y) {
                    p = opponentPieces.get(i);
            }
        }
        return p;
    }

    /**
     * @param x
     * The x coordinate of the tile we want to check.
     * @param y
     * The y coordinate of the tile we want to check.
     * @return boolean
     * Check if the tile with the given coordinate contains a piece of human player.
     * Returns true if it does.
     */
    public boolean containsHumanPiece(int x, int y) {
        for (int i = 0; i < humanPieces.size(); i++) {
            if (humanPieces.get(i).getX() == x
            && humanPieces.get(i).getY() == y)
                return true;
        }
        return false;
    }

    /**
     * @param frameCount
     * The number of frames when the move happens
     * @param xMoveTo
     * The x coordinate of the destination tile.
     * @param yMoveTo
     * The y coordinate of the destination tile.
     * @param selectedPiece
     * The piece that is being selected and moved.
     * Calculate the suitable speed to move a piece so the total time taken to 
     * move the piece never exceeds the maximum time allowed, set the total
     * number of frames needed to move and get the number of frames when the move
     * happens.
     */
    public void calSpeed(int frameCount, int xMoveTo, int yMoveTo, Piece selectedPiece) {
        int xDist = selectedPiece.getX() - xMoveTo;
        int yDist = selectedPiece.getY() - yMoveTo;
        int tempXDist = xDist;
        int tempYDist = yDist;
        if (xDist < 0)
            tempXDist *= -1;
        if (yDist < 0)
            tempYDist *= -1;
        xSpeed = pieceMovementSpeed;
        ySpeed = pieceMovementSpeed;
        double xTotalFrame = tempXDist/xSpeed;
        double yTotalFrame = tempYDist/ySpeed;

        double xTotalTimeTaken = xTotalFrame/FPS;
        double yTotalTimeTaken = yTotalFrame/FPS;
        /*
        * increment speed until the total time taken is no longer larger
        * than the max time
        */
        if (xTotalTimeTaken > maxMovementTime) {
            while (xTotalTimeTaken > maxMovementTime) {
                xSpeed++;
                xTotalFrame = tempXDist/xSpeed;
                xTotalTimeTaken = xTotalFrame/FPS;
            }
        }
        if (yTotalTimeTaken > maxMovementTime) {
            while (yTotalTimeTaken > maxMovementTime) {
                ySpeed++;
                yTotalFrame = tempYDist/ySpeed;
                yTotalTimeTaken = yTotalFrame/FPS;
            }
        }
        // get the total frames needed
        if (xTotalFrame >= yTotalFrame)
            this.totalFrame = xTotalFrame;
        else
            this.totalFrame = yTotalFrame;
        // get the speed
        // move to the right
        if (xDist < 0)
            xSpeed *= -1;
        // move down
        if (yDist < 0)
            ySpeed *= -1;
        // get the frame count when we start moving
        this.startFrameCount = frameCount;
    }

    /**
     * @param ourPieces
     * An array list of ally's pieces
     * @return tile
     * Return the tile that has a king piece on it.
     */
    public Rect getKingTile(ArrayList<Piece> ourPieces) {
        for (Rect r : tiles) {
            for (Piece p : ourPieces) {
                if (p.getName().equals("king")
                && r.getX() == p.getX() && r.getY() == p.getY()) {
                    return r;
                }
            }
        }
        /*
         * this will never be reached unless the king is captured,
         * which is not happening since we already lose when our king is 
         * checkmated 
         */
        return null;
    }

    /**
     * @param app
     * The app which we display everything of the game.
     * @param tile
     * The tile to change color.
     * Change the color of the tile back to original.
     */
    public void changeBackColor(PApplet app, Rect tile) {
        tile.changeColor(tile.getOriginalColor());
        tile.drawRect(app);
    }

    /**
     * @param x
     * The x coordinate of the tile we want to get.
     * @param y
     * The y coordinate of the tile we want to get.
     * @return tile
     * Return the tile with the given coordinate.
     */
    public Rect getTile(int x, int y) {
        Rect rect = tiles.get(0);
        for (Rect r : tiles) {
            if (r.getX() == x && r.getY() == y) {
                rect = r;
                break;
            }
        }
        return rect;
    }

    /**
     * @param tileOne
     * The first tile to be checked if is consecutive to the second tile.
     * @param tileTwo
     * The second tile to be checked if is consecutive to the first tile.
     * @return boolean
     * Check if tileOne and tileTwo are two consecutive tiles (vertically/horizontally).
     * Returns true if they are.
     */
    public boolean isConsecutiveTile(Rect tileOne, Rect tileTwo) {
        // check horizontally
        if (tileOne.getY() == tileTwo.getY()) {
            if (tileOne.getX() - tileTwo.getX() == 48 || tileTwo.getX() - tileOne.getX() == 48)
                return true;
        }
        // check vertically
        if (tileOne.getX() == tileTwo.getX()) {
            if (tileOne.getY() - tileTwo.getY() == 48 || tileTwo.getY() - tileOne.getY() == 48)
                return true;
        }
        return false;
    }

    /**
     * @param x
     * The x coordinate of the tile we want to check.
     * @param y
     * The y coordinate of the tile we want to check.
     * @param allPossibleMoves
     * An array list of all the possible moves of a player.
     * @return boolean
     * Check if there is a tile with the given coordinate already in the list
     * that stores all the possible moves of a player. Returns true if there is.
     */
    public boolean isDup(int x, int y, ArrayList<Rect> allPossibleMoves) {
        for (Rect m : allPossibleMoves) {
            if (m.getX() == x && m .getY() == y) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param ourPieces
     * An array list of the pieces of ally.
     * @param opponentPieces
     * An array list of the pieces of opponent.
     * @return array list of tiles
     * Return an array list containing all the possible moves of a player.
     */
    public ArrayList<Rect> getAllPossibleMoves(ArrayList<Piece> ourPieces, ArrayList<Piece> opponentPieces) {
        ArrayList<Rect> allPossibleMoves = new ArrayList<Rect>();
        ArrayList<Rect> possibleMoves;
        for (Piece p : ourPieces) {
            possibleMoves = p.getPossibleMoves(ourPieces, opponentPieces, tiles);
            if (p.getName().equals("pawn")) {
                for (Rect tile : tiles) {
                    if ((tile.getX() == p.getX() - CELLSIZE && tile.getY() == p.getY() - CELLSIZE)
                    || (tile.getX() == p.getX() - CELLSIZE && tile.getY() == p.getY() + CELLSIZE)
                    || (tile.getX() == p.getX() + CELLSIZE && tile.getY() == p.getY() - CELLSIZE)
                    || (tile.getX() == p.getX() + CELLSIZE && tile.getY() == p.getY() + CELLSIZE))
                        allPossibleMoves.add(tile);
                }
            }
            for (Rect tile : possibleMoves) {
                // since getPossibleMoves changes the color of the tiles
                tile.changeColor(tile.getOriginalColor());
                /*
                * if a piece moves to the tile in front of a pawn,
                * the piece won't be captured since pawn cannot capture
                * pieces that way
                * so we need to exclude those possible moves of pawn from
                * our allPossibleMoves list
                */
                if (p.getName().equals("pawn")) {
                    if ((tile.getX() == p.getX() && tile.getY() == p.getY() - CELLSIZE)
                    || (tile.getX() == p.getX() && tile.getY() == p.getY() - CELLSIZE*2)) {
                        continue;
                    }
                    if ((tile.getX() == p.getX() && tile.getY() == p.getY() + CELLSIZE)
                    || (tile.getX() == p.getX() && tile.getY() == p.getY() + CELLSIZE*2)) {
                        continue;
                    }
                }
                // if the tile is not already added in allPossibleMoves
                if (!isDup(tile.getX(), tile.getY(), allPossibleMoves)) {
                    allPossibleMoves.add(tile);
                }
            }
        }
        return allPossibleMoves;
    }

    /**
     * @param ourPieces
     * An array list of the pieces of ally.
     * @return piece
     * Return the king from the list of pieces.
     */
    public Piece getKingPiece(ArrayList<Piece> ourPieces) {
        Piece king = ourPieces.get(0);
        for (Piece p : ourPieces) {
            if (p.getName().equals("king")) {
                king = p;
                break;
            }
        }
        return king;
    }

    /**
     * Restart the game, change all the tiles' colours back to original, set
     * all the pieces to be back to their original location.
     */
    public void restartGame() {
        for (Rect tile : tiles) {
            tile.changeColor(tile.getOriginalColor());
        }
        for (Piece p : humanPieces) {
            p.setX(p.getStartXCoor());
            p.setY(p.getStartYCoor());
        }
        for (Piece p : cpuPieces) {
            p.setX(p.getStartXCoor());
            p.setY(p.getStartYCoor());
        }
    }

    /**
     * @param app
     * The app which we display everything of the game.
     * Display and decrease the timer of both players.
     */
    public void timer(PApplet app) {
        // clear the old time by overlaying the number
        app.fill(GREY);
        app.rect(WIDTH - SIDEBAR, 0, SIDEBAR, HEIGHT);
        // TIME
        String playerTimer = String.format("%d:%02d", playerTime/60, playerTime % 60);
        String cpuTimer = String.format("%d:%02d", cpuTime/60, cpuTime % 60);
        app.textSize(30);
        app.fill(DARK_RED);
        // display time of both human and cpu players
        app.text(playerTimer, WIDTH - 100, humanTimerHeight);
        app.text(cpuTimer, WIDTH - 100, cpuTimerHeight);
        /*
         * counter to only decrement time by one second not one frame
         * since FPS = 60
         */
        if (humanTurn)
            humanTimeCounter++;
        else 
            cpuTimeCounter++;
        if (humanTurn) {
            if (humanTimeCounter == SECOND) {
                playerTime--;
                humanTimeCounter = 0;
            }
        }
        else {
            if (cpuTimeCounter == SECOND) {
                cpuTime--;
                cpuTimeCounter = 0;
            }
        }
    }

    /**
     * @param app
     * The app which we display everything of the game.
     * @return boolean
     * Display the text if the human player wins or if the human player loses
     * on time. Returns true if the time of either the players run out.
     */
    public boolean isOutOfTime(PApplet app) {
        if (playerTime <= 0) {
            app.textSize(13);
            app.fill(DARK_RED);
            app.text("You lost on time", WIDTH - 110, HEIGHT/2);
            return true;
        }
        if (cpuTime <= 0) {
            app.textSize(13);
            app.fill(DARK_RED);
            app.text("You won on time", WIDTH - 110, HEIGHT/2);
            return true;
        }
        return false;
    }

    /**
     * @param app
     * The app which we display everything of the game.
     * @param frameCount
     * The current number of frames.
     * Restart the game, checks if one of the player runs out of time and displays
     * the text, displays the timer, draw the chess board and pieces, account for 
     * the movements of the pieces of both the players.
     */
    public void draw(PApplet app, int frameCount) {
        // if player restart game
        if (restart) {
            restartGame();
            restart = false;
            // change the color of the tiles that mark the previous move back to original color
            humanPrevTile.changeColor(humanPrevTile.getOriginalColor());
            cpuPrevTile.changeColor(cpuPrevTile.getOriginalColor());
            humanTileMoveTo.changeColor(humanTileMoveTo.getOriginalColor());
            cpuTileMoveTo.changeColor(cpuTileMoveTo.getOriginalColor());
        }
        if (isOutOfTime(app)) {
            return;
        }
        // TIMER
        timer(app);
        // draw tiles
        for (int i = 0; i < tiles.size(); i++) {
            tiles.get(i).drawRect(app);
        }
        if (humanTurn) {
            /*
            if tile is clicked -> change color

            note that isClicked checks if the mouse is clicked while
            tileIsClicked checks if the tile we are checking is clicked
            */
            if (isClicked) {
                // if the tile contains a white piece
                if (hasHumanPiece(getTileClicked().getX(), getTileClicked().getY())) {
                    tileSelected = getTileClicked();
                    // from the tile selected, set the piece selected for human player
                    setSelectedHumanPiece();
                    // change the selected tile to green
                    changeTileColourWhenClicked(app, tileSelected);
                    // king does not move to dangerous tiles
                    cpuAllPossibleMoves = getAllPossibleMoves(cpuPieces, humanPieces);
                    humanKingPiece = getKingPiece(humanPieces);
                    humanKingPiece.setAllPossibleMoves(cpuAllPossibleMoves);
                    // get the possible moves
                    humanPossibleMoves = pieceSelected.getPossibleMoves(humanPieces, cpuPieces, tiles);
                    // change the possible moves tiles colors
                    changeToBlue(app);
                    moveCounter = 0;
                    cpuMoveCounter = 0;
                    changeBackCol = false;
                    humanPrevTile = tileSelected;
                }
            }
            else if (!isClicked) {
                /*
                    if the selected tile is unselected 
                    -> change back color and draw the piece back
                */
                Rect tileClicked = getTileClicked();
                humanTileMoveTo = tileClicked;
                if (tileClicked == tileSelected) {
                    changeBackColourWhenCLicked(app, tileSelected, pieceSelected.getPossibleMoves(humanPieces, cpuPieces, tiles));
                }
                /*
                    if the tile selected is blue
                    -> change coordinates of the selected white piece
                    -> change the tiles colors back to original
                */
                else if (isPossibleMove(tileClicked, humanPossibleMoves)) {
                    /*
                    * if move to a castling tile
                    * -> move king and rook
                    */
                    if (pieceSelected.getName().equals("king") && !pieceSelected.hasBeingMoved()) {
                        for (Piece p : humanPieces) {
                            if (p.getName().equals("rook") && p.getX() < pieceSelected.getX() 
                            && p.getY() == pieceSelected.getY())
                                leftRook = p;
                            else if (p.getName().equals("rook") && p.getX() > pieceSelected.getX() 
                            && p.getY() == pieceSelected.getY())
                                rightRook = p;
                        }
                        /*
                            if we move to the second tile on the right
                            -> move the right rook to the left side of the king
                        */
                        if (tileClicked.getX() == pieceSelected.getX()+CELLSIZE*2 && tileClicked.getY() == pieceSelected.getY()) {
                            calSpeed(frameCount, tileClicked.getX()-CELLSIZE, tileClicked.getY(), pieceSelected);
                            rightRook.tick(tileClicked.getX()-CELLSIZE, tileClicked.getY(), xSpeed, ySpeed);
                        }
                        /*
                            if we move to the second tile on the left
                            -> move the left rook to the right of the king
                        */
                        else if (tileClicked.getX() == pieceSelected.getX()-CELLSIZE*2 && tileClicked.getY() == pieceSelected.getY()) {
                            calSpeed(frameCount, tileClicked.getX()+CELLSIZE, tileClicked.getY(), pieceSelected);
                            leftRook.tick(tileClicked.getX()+CELLSIZE, tileClicked.getY(), xSpeed, ySpeed);
                        }
                    }
                    // move
                    if (moveCounter == 0) {
                        if (cpuPrevTile != null && cpuTileMoveTo != null) {
                            cpuPrevTile.changeColor(cpuPrevTile.getOriginalColor());
                            cpuTileMoveTo.changeColor(cpuTileMoveTo.getOriginalColor());
                        }
                        /* calculate the total frame needed
                        * use counter so this is only done once for a move
                        */
                        changeBackColourWhenCLicked(app, tileSelected, humanPossibleMoves);
                        calSpeed(frameCount, tileClicked.getX(), tileClicked.getY(), pieceSelected);
                        moveCounter++;
                        playerTime += playerInc;
                    }
                    if (!changeBackCol) {
                        // mark the previous move by changing the tile color to yellow
                        if (isConsecutiveTile(humanPrevTile, humanTileMoveTo)) {
                            humanPrevTile.changeColor(LIGHT_GREEN);
                            humanTileMoveTo.changeColor(DARK_GREEN);
                        }
                        else {
                            humanPrevTile.changeColor(DARK_GREEN);
                            humanTileMoveTo.changeColor(DARK_GREEN);   
                        }
                    }
                    if (startFrameCount + totalFrame >= frameCount) {
                        pieceSelected.tick(tileClicked.getX(), tileClicked.getY(), xSpeed, ySpeed);
                    }
                    // finish moving
                    else {
                        // switch to cpu's turn
                        humanTurn = false;
                        /* 
                        * check if the piece is a pawn at rank 8th from bottom
                        * -> change to queen
                        *
                        * change to queen after arriving at the destination
                        */
                        if (pieceSelected.getName().equals("pawn") 
                        && tileClicked.getY() <= CELLSIZE*(BOARD_WIDTH-8))
                            changeToQueen(true, tileClicked.getX(), tileClicked.getY());
                    }
                    /*
                        * if the piece's coordinate is not the same as the 
                        * original one, then it has being moved
                        * 
                        * we only set 'moved' to true but don't set it to false
                        * to ensure that this only happens once
                        * 
                        * so if the piece moves from another place back 
                        * to its place, it's still considered as 'moved'
                    */
                    if (pieceSelected.getX() != pieceSelected.getStartXCoor()
                    || pieceSelected.getY() != pieceSelected.getStartYCoor())
                        pieceSelected.setMoved(true);
                    /*
                    * if captures an opponent's piece
                    * -> remove the opponent's piece from cpuPieces
                    */
                    if (hasCPUPiece(tileClicked.getX(), tileClicked.getY())) {
                        removePiece(cpuPieces, getCapturedPiece(cpuPieces, tileClicked.getX(), tileClicked.getY()));
                    }
                }
                // other deselected tiles or click elsewhere
                else {
                    /* 
                     * change the tiles colors back to original when 
                     * unselect by clicking elsewhere not the selected piece
                     * 
                     * tileSelected != null since there must be a tile selected
                     * to change color back
                     */
                    if (tileSelected != null)
                        changeBackColourWhenCLicked(app, tileSelected, pieceSelected.getPossibleMoves(humanPieces, cpuPieces, tiles));
                }
            }
        }
        // CPU's turn
        if (!humanTurn) {
            Random random = new Random();
            if (true) {
                // animation of cpu pieces
                /*
                * choose a random piece from cpuPieces to move
                * -> piece should have a possible and valid move 
                */
                if (this.cpuMoveCounter == 0) {
                    changeBackCol = true;
                    // change the color of the tiles that mark the previous moves back
                    if (humanPrevTile != null && humanTileMoveTo != null && changeBackCol) {
                        humanPrevTile.changeColor(humanPrevTile.getOriginalColor());
                        humanTileMoveTo.changeColor(humanTileMoveTo.getOriginalColor()); 
                    }
                    // select a random piece
                    while (true) {
                        int randomPiece = random.nextInt(0, cpuPieces.size());
                        if (!cpuPieces.get(randomPiece).getPossibleMoves(cpuPieces, humanPieces, tiles).isEmpty()) {
                            cpuSelectedPiece = cpuPieces.get(randomPiece);
                            cpuPrevTile = getTile(cpuSelectedPiece.getX(), cpuSelectedPiece.getY());
                            break;
                        }
                    }
                    // king does not move to dangerous tiles
                    humanAllPossibleMoves = getAllPossibleMoves(humanPieces, cpuPieces);
                    cpuKingPiece = getKingPiece(cpuPieces);
                    cpuKingPiece.setAllPossibleMoves(humanAllPossibleMoves);


                    // list of possible moves of the selected piece
                    cpuPossibleMoves = cpuSelectedPiece.getPossibleMoves(cpuPieces, humanPieces, tiles);
                    // select a random move
                    randomMove = random.nextInt(0, cpuPossibleMoves.size());
                    cpuSelectedTile = cpuPossibleMoves.get(randomMove);
                    cpuTileMoveTo = cpuSelectedTile;
                    calSpeed(frameCount, cpuSelectedTile.getX(), cpuSelectedTile.getY(), cpuSelectedPiece);
                    cpuMoveCounter++;
                    cpuTime += cpuInc;
                }
                // mark the previous move by changing the tile color to yellow
                if (isConsecutiveTile(cpuPrevTile, cpuTileMoveTo)) {
                    cpuPrevTile.changeColor(LIGHT_GREEN);
                    cpuTileMoveTo.changeColor(DARK_GREEN);
                }
                else {
                    cpuPrevTile.changeColor(DARK_GREEN);
                    cpuTileMoveTo.changeColor(DARK_GREEN);   
                }
                // start moving
                if ((startFrameCount + totalFrame >= frameCount)) {
                    cpuSelectedPiece.tick(cpuSelectedTile.getX(), cpuSelectedTile.getY(), xSpeed, ySpeed);
                } 
                else {
                    // switch to human's turn
                    humanTurn = true;
                }
            }
            // if the destination has a piece of human player, then capture it
            if (hasHumanPiece(cpuSelectedTile.getX(), cpuSelectedTile.getY())) {
                removePiece(humanPieces, getCapturedPiece(humanPieces, cpuSelectedTile.getX(), cpuSelectedTile.getY()));
            }
        }
        for (int j = 0; j < cpuPieces.size(); j++) {
            cpuPieces.get(j).draw(app);
        }
        for (int k = 0; k < humanPieces.size(); k++) {
            humanPieces.get(k).draw(app);
        }
    }
}