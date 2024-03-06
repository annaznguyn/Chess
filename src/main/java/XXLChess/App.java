package XXLChess;


import processing.core.PApplet;
import processing.core.PImage;
import processing.data.JSONObject;
import processing.event.MouseEvent;

import java.io.*;
import java.util.*;

public class App extends PApplet {

    public static final int SPRITESIZE = 480;
    public static final int CELLSIZE = 48;
    public static final int SIDEBAR = 120;
    public static final int BOARD_WIDTH = 14;

    public static int WIDTH = CELLSIZE*BOARD_WIDTH+SIDEBAR;
    public static int HEIGHT = BOARD_WIDTH*CELLSIZE;

    public static final int FPS = 60;
	
    public String configPath;

    public static final int BROWN = 0xFFB58863;
    public static final int YELLOW = 0xFFF0D9B5;
    public static final int GREY = 178;

    // stores the tiles in the background
    public ArrayList<Rect> tiles = new ArrayList<Rect>();

    // store black and white pieces
    public ArrayList<Piece> humanPlayer = new ArrayList<Piece>();
    public ArrayList<Piece> cpuPlayer = new ArrayList<Piece>();

    // stores the images of the queen to use when we change pawn to queen
    // black (index 0) and white (index 1) images
    public ArrayList<PImage> queenImages;

    // information of player and cpu from config.json
    public int playerTime;
    public int playerInc;

    public int cpuTime;
    public int cpuInc;

    public String playerColour;
    public double pieceMovementSpeed;
    public int maxMovementTime;

    // mouse event part
    public boolean mouseClicked;
    public boolean whitePieceClicked;

    public Game game;

    public boolean resign;
    public boolean restart;

    public App() {
        this.configPath = "config.json";
        this.queenImages = new ArrayList<PImage>();
        
        this.game = new Game(SIDEBAR, WIDTH, HEIGHT, CELLSIZE, BOARD_WIDTH, FPS, tiles, humanPlayer, cpuPlayer, queenImages);

        this.mouseClicked = true;
        this.whitePieceClicked = true;

        this.resign = false;
        this.restart = false;
    }

    /**
     * Initialise the setting of the window size.
    */
    public void settings() {
        size(WIDTH, HEIGHT);
    }

    /**
     * Load all resources such as images. Initialise the elements such as the player, enemies and map elements.
    */
    public void setup() {
        frameRate(FPS);

        for (int x = 0; x < BOARD_WIDTH; x++) {
            for (int y = 0; y < BOARD_WIDTH; y++) {
                if (x % 2 == 0) {
                    if (y % 2 == 0)
                        tiles.add(new Rect(x * CELLSIZE, y * CELLSIZE, YELLOW));
                    else
                        tiles.add(new Rect(x * CELLSIZE, y * CELLSIZE, BROWN));
                }
                else {
                    if (y % 2 == 0)
                        tiles.add(new Rect(x * CELLSIZE, y * CELLSIZE, BROWN));
                    else 
                        tiles.add(new Rect(x * CELLSIZE, y * CELLSIZE, YELLOW));
                }
            }
        }

        // Load images during setup
        PImage bAmaz = loadImage("src/main/resources/XXLChess/b-amazon.png");
        PImage bArch = loadImage("src/main/resources/XXLChess/b-archbishop.png");
        PImage bBish = loadImage("src/main/resources/XXLChess/b-bishop.png");
        PImage bCame = loadImage("src/main/resources/XXLChess/b-camel.png");
        PImage bChan = loadImage("src/main/resources/XXLChess/b-chancellor.png");
        PImage bKing = loadImage("src/main/resources/XXLChess/b-king.png");
        PImage bKnightKing = loadImage("src/main/resources/XXLChess/b-knight-king.png");
        PImage bKnight = loadImage("src/main/resources/XXLChess/b-knight.png");
        PImage bPawn = loadImage("src/main/resources/XXLChess/b-pawn.png");
        PImage bQueen = loadImage("src/main/resources/XXLChess/b-queen.png");
        PImage bRook = loadImage("src/main/resources/XXLChess/b-rook.png");
        PImage bPawpaw = loadImage("src/main/resources/XXLChess/b-pawpaw.png");
        PImage wAmaz = loadImage("src/main/resources/XXLChess/w-amazon.png");
        PImage wArch = loadImage("src/main/resources/XXLChess/w-archbishop.png");
        PImage wBish = loadImage("src/main/resources/XXLChess/w-bishop.png");
        PImage wCame = loadImage("src/main/resources/XXLChess/w-camel.png");
        PImage wChan = loadImage("src/main/resources/XXLChess/w-chancellor.png");
        PImage wKing = loadImage("src/main/resources/XXLChess/w-king.png");
        PImage wKnightKing = loadImage("src/main/resources/XXLChess/w-knight-king.png");
        PImage wKnight = loadImage("src/main/resources/XXLChess/w-knight.png");
        PImage wPawn = loadImage("src/main/resources/XXLChess/w-pawn.png");
        PImage wQueen = loadImage("src/main/resources/XXLChess/w-queen.png");
        PImage wRook = loadImage("src/main/resources/XXLChess/w-rook.png");
        PImage wPawpaw = loadImage("src/main/resources/XXLChess/w-pawpaw.png");

        // stores the queen images
        queenImages.add(bQueen);
        queenImages.add(wQueen);

        // load config
        JSONObject conf = loadJSONObject(new File(this.configPath));

        // extract config file
        String layoutFile = conf.getString("layout");

        // extract information of player and cpu
        JSONObject timeControl = conf.getJSONObject("time_controls");

        playerTime = timeControl.getJSONObject("player").getInt("seconds");
        playerInc = timeControl.getJSONObject("player").getInt("increment");
        
        cpuTime = timeControl.getJSONObject("cpu").getInt("seconds");
        cpuInc = timeControl.getJSONObject("cpu").getInt("increment");

        playerColour = conf.getString("player_colour");
        pieceMovementSpeed = conf.getDouble("piece_movement_speed");
        maxMovementTime = conf.getInt("max_movement_time");

        game.setFirstPlayer(playerColour);
        game.setPieceMovementSpeed(pieceMovementSpeed);
        game.setMaxMovementTime(maxMovementTime);

        game.setPlayerTime(playerTime);
        game.setPlayerInc(playerInc);
        game.setCPUTime(cpuTime);
        game.setCPUInc(cpuInc);

        /* array stores lines in the file with key "layout" in config.json
         * including empty lines
        */
        ArrayList<String> array = new ArrayList<String>();

        try {
            // IF CANNOT RUN, PLEASE CHANGE THE FILE PATH BEFORE RUN
            File f = new File(layoutFile);
            Scanner scan = new Scanner(f);

            while (scan.hasNext())
                array.add(scan.nextLine());

            scan.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int y = 0; y < array.size(); y++) {
            if (array.get(y).equals(""))
                continue;
            if (playerColour.equals("black")) {
                for (int x = 0; x < array.get(y).length(); x++) {
                    char letter = array.get(y).charAt(x);
                    if (letter == 'R')
                        humanPlayer.add(new Rook(x * CELLSIZE, y * CELLSIZE, "human", bRook));
                    else if (letter == 'N')
                        humanPlayer.add(new Knight(x * CELLSIZE, y * CELLSIZE, "human", bKnight));
                    else if (letter == 'B')
                        humanPlayer.add(new Bishop(x * CELLSIZE, y * CELLSIZE, "human", bBish));
                    else if (letter == 'H')
                        humanPlayer.add(new Archbishop(x * CELLSIZE, y * CELLSIZE, "human", bArch));
                    else if (letter == 'C')
                        humanPlayer.add(new Camel(x * CELLSIZE, y * CELLSIZE, "human", bCame));
                    else if (letter == 'G')
                        humanPlayer.add(new Guard(x * CELLSIZE, y * CELLSIZE, "human", bKnightKing));
                    else if (letter == 'A')
                        humanPlayer.add(new Amazon(x * CELLSIZE, y * CELLSIZE, "human", bAmaz));
                    else if (letter == 'K')
                        humanPlayer.add(new King(x * CELLSIZE, y * CELLSIZE, "human", bKing));
                    else if (letter == 'E')
                        humanPlayer.add(new Chancellor(x * CELLSIZE, y * CELLSIZE, "human", bChan));
                    else if (letter == 'P')
                        humanPlayer.add(new Pawn(x * CELLSIZE, y * CELLSIZE, "human", bPawn));
                    else if (letter == 'W')
                        humanPlayer.add(new Pawpaw(x * CELLSIZE, y * CELLSIZE, "human", bPawpaw));
                    else if (letter == 'p')
                        cpuPlayer.add(new Pawn(x * CELLSIZE, y * CELLSIZE, "cpu", wPawn));
                    else if (letter == 'r')
                        cpuPlayer.add(new Rook(x * CELLSIZE, y * CELLSIZE, "cpu", wRook));
                    else if (letter == 'n')
                        cpuPlayer.add(new Knight(x * CELLSIZE, y * CELLSIZE, "cpu", wKnight));
                    else if (letter == 'b')
                        cpuPlayer.add(new Bishop(x * CELLSIZE, y * CELLSIZE, "cpu", wBish));
                    else if (letter == 'h')
                        cpuPlayer.add(new Archbishop(x * CELLSIZE, y * CELLSIZE, "cpu", wArch));
                    else if (letter == 'c')
                        cpuPlayer.add(new Camel(x * CELLSIZE, y * CELLSIZE, "cpu", wCame));
                    else if (letter == 'g')
                        cpuPlayer.add(new Guard(x * CELLSIZE, y * CELLSIZE, "cpu", wKnightKing));
                    else if (letter == 'a')
                        cpuPlayer.add(new Amazon(x * CELLSIZE, y * CELLSIZE, "cpu", wAmaz));
                    else if (letter == 'k')
                        cpuPlayer.add(new King(x * CELLSIZE, y * CELLSIZE, "cpu", wKing));
                    else if (letter == 'e')
                        cpuPlayer.add(new Chancellor(x * CELLSIZE, y * CELLSIZE, "cpu", wChan));
                    else if (letter == 'w')
                        cpuPlayer.add(new Pawpaw(x * CELLSIZE, y * CELLSIZE, "cpu", wPawpaw));
                }
            }
            else if (playerColour.equals("white")) {
                for (int x = 0; x < array.get(y).length(); x++) {
                    char letter = array.get(y).charAt(x);
                    if (letter == 'R')
                        cpuPlayer.add(new Rook(x * CELLSIZE, y * CELLSIZE, "cpu", bRook));
                    else if (letter == 'N')
                        cpuPlayer.add(new Knight(x * CELLSIZE, y * CELLSIZE, "cpu", bKnight));
                    else if (letter == 'B')
                        cpuPlayer.add(new Bishop(x * CELLSIZE, y * CELLSIZE, "cpu", bBish));
                    else if (letter == 'H')
                        cpuPlayer.add(new Archbishop(x * CELLSIZE, y * CELLSIZE, "cpu", bArch));
                    else if (letter == 'C')
                        cpuPlayer.add(new Camel(x * CELLSIZE, y * CELLSIZE, "cpu", bCame));
                    else if (letter == 'G')
                        cpuPlayer.add(new Guard(x * CELLSIZE, y * CELLSIZE, "cpu", bKnightKing));
                    else if (letter == 'A')
                        cpuPlayer.add(new Amazon(x * CELLSIZE, y * CELLSIZE, "cpu", bAmaz));
                    else if (letter == 'K')
                        cpuPlayer.add(new King(x * CELLSIZE, y * CELLSIZE, "cpu", bKing));
                    else if (letter == 'E')
                        cpuPlayer.add(new Chancellor(x * CELLSIZE, y * CELLSIZE, "cpu", bChan));
                    else if (letter == 'P')
                        cpuPlayer.add(new Pawn(x * CELLSIZE, y * CELLSIZE, "cpu", bPawn));
                    else if (letter == 'W')
                        cpuPlayer.add(new Pawpaw(x * CELLSIZE, y * CELLSIZE, "cpu", bPawpaw));
                    else if (letter == 'p')
                        humanPlayer.add(new Pawn(x * CELLSIZE, y * CELLSIZE, "human", wPawn));
                    else if (letter == 'r')
                        humanPlayer.add(new Rook(x * CELLSIZE, y * CELLSIZE, "human", wRook));
                    else if (letter == 'n')
                        humanPlayer.add(new Knight(x * CELLSIZE, y * CELLSIZE, "human", wKnight));
                    else if (letter == 'b')
                        humanPlayer.add(new Bishop(x * CELLSIZE, y * CELLSIZE, "human", wBish));
                    else if (letter == 'h')
                        humanPlayer.add(new Archbishop(x * CELLSIZE, y * CELLSIZE, "human", wArch));
                    else if (letter == 'c')
                        humanPlayer.add(new Camel(x * CELLSIZE, y * CELLSIZE, "human", wCame));
                    else if (letter == 'g')
                        humanPlayer.add(new Guard(x * CELLSIZE, y * CELLSIZE, "human", wKnightKing));
                    else if (letter == 'a')
                        humanPlayer.add(new Amazon(x * CELLSIZE, y * CELLSIZE, "human", wAmaz));
                    else if (letter == 'k')
                        humanPlayer.add(new King(x * CELLSIZE, y * CELLSIZE, "human", wKing));
                    else if (letter == 'e')
                        humanPlayer.add(new Chancellor(x * CELLSIZE, y * CELLSIZE, "human", wChan));
                    else if (letter == 'w')
                        humanPlayer.add(new Pawpaw(x * CELLSIZE, y * CELLSIZE, "human", wPawpaw));
                }
            }
        }
    }

    /**
     * Receive key pressed signal from the keyboard.
    */
    public void keyPressed(){
        // resign from game
        if (this.keyCode == 69)
            resign = true;
        // restart game
        if (this.keyCode == 82) {
            resign = false;
            restart = true;
        }
    }

    
    /** 
     * @param e
     * Toggle the boolean to indicate if a tile/piece is being clicked, set the
     * x, y coordinate of the pixel that is being clicked.
     */
    @Override
    public void mousePressed(MouseEvent e) {
        game.setXClicked(e.getX());
        game.setYClicked(e.getY());

        if (this.mouseClicked) {
            // check if we click on a human player piece
            for (int i = 0; i < game.getHumanPieces().size(); i++) {
                if (game.tileIsClicked(game.getHumanPieces().get(i).getX(), game.getHumanPieces().get(i).getY())) {
                    if (this.whitePieceClicked) {
                        game.setIsClicked(true);
                        this.mouseClicked = false;
                        this.whitePieceClicked = false;
                        break;
                    }
                    // unselect
                    else {
                        game.setIsClicked(false);
                        this.mouseClicked = true;
                        this.whitePieceClicked = true;
                        break;
                    }
                }
                // if we don't click on tile containing a white piece
                else if (i == game.getHumanPieces().size() - 1) {
                    game.setIsClicked(true);
                    this.mouseClicked = false;
                    this.whitePieceClicked = true;
                }
            }
        }
        else {
            // check if we click on a white piece
            for (int i = 0; i < game.getHumanPieces().size(); i++) {
                if (game.tileIsClicked(game.getHumanPieces().get(i).getX(), game.getHumanPieces().get(i).getY())) {
                    if (this.whitePieceClicked) {
                        game.setIsClicked(true);
                        this.mouseClicked = false;
                        this.whitePieceClicked = false;
                        break;
                    }
                    // unselect
                    else {
                        game.setIsClicked(false);
                        this.mouseClicked = true;
                        this.whitePieceClicked = true;
                        break;
                    }
                }
                // if we don't click on tile containing a white piece
                else if (i == game.getHumanPieces().size() - 1) {
                    game.setIsClicked(false);
                    this.mouseClicked = true;
                    this.whitePieceClicked = true;
                }
            }
        }
    }

    /**
     * Draw all elements in the game by current frame. 
    */
    public void draw() {
        if (resign) {
            textSize(15);
            fill(BROWN);
            text("You resigned", WIDTH - 110, HEIGHT/2);
        }
        else {
            fill(GREY);
            rect(WIDTH - SIDEBAR, 0, SIDEBAR, HEIGHT);
            if (restart) {
                game.setRestart(true);
                restart = false;
            }
            game.draw(this, frameCount);
        }
    }
	
	// Add any additional methods or attributes you want. Please put classes in different files.
    

    public static void main(String[] args) {
        PApplet.main("XXLChess.App");
    }

}
