package Battleship;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


// import com.sun.media.sound.SF2Layer;
//
// import net.arikia.dev.drpc.DiscordRPC;

/**
 * 
 * Creates the Battleship Window on which the player plays the game.
 *
 * @author Riya Kumari
 * @version May 30, 2019
 * @author Period: 5
 * @author Assignment: Batttleship_APCSFinalProject
 *
 * @author Sources:
 */

public class PlayerWindow extends JFrame
{

    /**
     * spacing : the spacing between the squares on each of the grids
     */
    private static int spacing = 2;

    /**
     * myX : the X coordinate on the window that has been accessed
     */
    private int myX = 0;

    /**
     * myY: the Y coordinate on the window that has been accessed
     */
    private int myY = 0;

    /**
     * boardType: String value that stores what type of board it is -
     * Blue(Player) or Red(Computer)
     */
    private String boardType;

    /**
     * ifClickedRed: an array that stores the locations of the places already
     * played on computer board
     */
    static boolean[][] ifClickedRed = new boolean[10][10];

    /**
     * ifClickedBlue: an array that stores the locations of the places already
     * played on player board
     */
    static boolean[][] ifClickedBlue = new boolean[10][10];

    /**
     * c : is a Computer class object
     */
    private Computer c = new Computer();

    /**
     * p : is a Player class Object
     */
    private Player p = new Player();

    /**
     * gh : is an object of GameHelper class
     */
    private GameHelper gh = new GameHelper();

    /**
     * startPressed : holds true when start(JButton) is clicked
     */
    private boolean startPressed = false;

    /**
     * CompshipArray : array of Computer's ships
     */
    private Ship[] compShipArray;

    /**
     * playerShipArray : array of Player's ships
     */
    private Ship[] playerShipArray;

    /**
     * colors : is a Colors Object
     */
    private Colors colors;

    /**
     * playerTurn : holds true when it is players turn
     */
    private boolean playerTurn = true;

    /**
     * computerTurn : holds true when it is computers turn
     */
    private boolean computerTurn = false;

    /**
     * winner : holds the winner of the game
     */
    public static String winner;

    /**
     * the Player score
     */
    private static int playerScore = 0;

    /**
     * the computer score
     */
    private static int computerScore = 0;

    private int readyToShow = 0;


    /**
     * Constructs the window on which the player sees the battleship board. The
     * start and set up button are created here as well.
     */
    public PlayerWindow()
    {
        JPanel panel = new JPanel();
        panel.setBackground( Color.LIGHT_GRAY );
        colors = new Colors();
        // Creating the Battleship window
        this.setTitle( "Battleship" );
        this.setSize( 1000, 600 );
        this.setBackground( colors.getBoardBG() );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        Board board = new Board();
        this.setContentPane( board );
        JButton setUpShips = new JButton( "Set Up Ships" );
        JButton start = new JButton( "Start" );

        setUpShips.addActionListener( new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                Gamers.updatePresence( "Player Has Set Up Their Ships", "" );
                readyToShow++;
                compShipArray = gh.createShipsArray();
                c.setShips( compShipArray );
                playerShipArray = gh.createShipsArray();
                p.setShips( playerShipArray );
                ( (JButton)( e.getSource() ) ).setVisible( false );

            }
        } );
        start.addActionListener( new ActionListener()
        {
            public void actionPerformed( ActionEvent e )
            {
                readyToShow++;
                startPressed = true;
                Gamers.updatePresence( "Wish them the Best of Luck!",
                    "Player has Started the Game" );
                ( (JButton)( e.getSource() ) ).setVisible( false );

            }
        } );

        panel.add( setUpShips );
        panel.add( start );
        this.add( panel );

        // Gives the user the ability to see which square they are hovering over
        MouseAction moved = new MouseAction();
        this.addMouseMotionListener( moved );

        // Gives the user the ability to click or do something with the mouse
        // pressed
        PlayerAction click = new PlayerAction();
        this.addMouseListener( click );

    }


    /**
     * Checks whether the game is over or not based on the scores of player and
     * computer.
     * 
     * @return true if the Game is Over.
     */
    public boolean GameOver()
    {
        if ( gh.getScoreC() == 80 || gh.getScoreP() == 80 )
        {
            return true;
        }
        return false;
    }


    /**
     * Checks to see who has won the game - Player or Computer
     * 
     * @return a String that is the name of the Winner
     */
    public String getWinner()
    {
        if ( gh.getScoreC() > gh.getScoreP() )
        {
            winner = "Computer";
        }
        else
        {

            winner = "Player";
        }
        return winner;
    }


    /**
     * 
     * Creates and displays the two boards which are used to play the game. Also
     * displays the titles such as Player, Computer, and the scores of both
     * player and computer.
     * 
     *
     * @author Riya Kumari
     * @version May 30, 2019
     * @author Period: 5
     * @author Assignment: Batttleship_APCSFinalProject
     *
     * @author Sources:
     */
    public class Board extends JPanel
    {
        int redTopLeftX = 64;

        int redTopLeftY = 84;

        int boardWidth = 400, boardHeight = 400;

        int blueTopLeftX = 480;

        int blueTopLeftY = 84;

        int squareDim = 40;


        /**
         * Paints the player board and the computer board as the game is being
         * played. Also displays the scores of the player and computer. It also
         * updates the Discord Status
         * 
         * 
         * @param g
         *            default
         *            javax.swing.JComponent#paintComponent(java.awt.Graphics)
         */
        protected void paintComponent( Graphics g )
        {
            if ( readyToShow == 2 )
            {
                Gamers.updatePresence( "Computer Score: " + computerScore,
                    "Player Score: " + playerScore );

                if ( playerScore == 80 )
                {
                    Gamers.updatePresence( "This Player is OP!", "Player Won!" );
                }
                else if ( computerScore == 80 )
                {
                    Gamers.updatePresence( "This Player is Trash!", "Player Somehow Lost!!" );
                }
            }

            // ..........................
            // Red Board
            // ...........................................................

            // Sets background of board Red
            // String score = Integer.toString(score);
            g.setFont( new Font( "Serif", Font.BOLD, 45 ) );
            g.drawString( "Player", 200, 50 );
            g.drawString( "Computer", 585, 50 );
            g.setFont( new Font( "Monospaced", Font.BOLD, 25 ) );
            g.drawString( "Player Score : " + gh.getScoreP(), 158, 525 );
            g.drawString( "Computer Score : " + gh.getScoreC(), 558, 525 );
            g.setColor( colors.getRedBoard() );
            g.fillRect( redTopLeftX, redTopLeftY, boardWidth, boardHeight );

            for ( int row = 0; row < 10; row++ )
                for ( int col = 0; col < 10; col++ )
                {
                    g.setColor( Player.playerLocation[row][col] );

                    if ( startPressed && computerTurn )
                    {

                        Location loc = c.shoot();

                        boolean works = c.evaluate( loc );
                        if ( works == true )
                        {
                            gh.updateScore( Player.playerLocation[c.getRoww()][c.getColumn()], 0 );
                            computerScore = GameHelper.scoreC;
                        }

                    }

                    if ( ifClickedRed[row][col] )
                    {
                        if ( !Player.playerLocation[row][col].equals( colors.getGridColor() ) )

                        {
                            g.setColor( colors.getHit() );
                            // System.out.println( "1" );

                        }

                        else
                        {
                            g.setColor( colors.getMiss() );
                            // System.out.println( "2" );

                        }
                    }

                    g.fillRect( redTopLeftX + spacing + row * squareDim,
                        redTopLeftY + spacing + col * squareDim,
                        squareDim - 2 * spacing,
                        squareDim - 2 * spacing );
                    playerTurn = true;
                    computerTurn = false;

                }

            // ...........................................................
            // Blue Board
            // ...........................................................

            g.setColor( colors.getBlueBoard() );
            g.fillRect( blueTopLeftX, blueTopLeftY, 400, 400 );
            for ( int row = 0; row < 10; row++ )
            {
                for ( int col = 0; col < 10; col++ )
                {

                    g.setColor( colors.getGridColor() );

                    if ( startPressed )
                    {
                        // if there is something in computer loc and u have
                        // clicked blue
                        if ( ifClickedBlue[row][col] && !Computer.computerLocation[row][col]
                            .equals( colors.getGridColor() ) )

                        {
                            g.setColor( colors.getHit() );

                        }

                        // ******************************************//
                        else if ( ifClickedBlue[row][col] == true
                            && Computer.computerLocation[row][col].equals( colors.getGridColor() ) )
                        {

                            g.setColor( colors.getMiss() );

                        }
                        // *******************************************//
                        // When you hover over the square, it makes it green
                        else if ( ( myX >= blueTopLeftX + row * squareDim
                            && myX <= blueTopLeftX + row * squareDim + squareDim + spacing )
                            && ( myY >= 111 + spacing + col * squareDim
                                && myY <= 111 + col * squareDim + squareDim ) )
                        {
                            g.setColor( colors.getHover() );

                        }
                    }

                    g.fillRect( blueTopLeftX + spacing + row * squareDim,
                        blueTopLeftY + spacing + col * squareDim,
                        squareDim - 2 * spacing,
                        squareDim - 2 * spacing );
                }
            }

        }
    }


    /**
     * 
     * The Class implements java.awt.event.MouseMotionListener to get input from
     * when the mouse is moved.
     *
     * @author Riya Kumari
     * @version May 30, 2019
     * @author Period: 5
     * @author Assignment: Batttleship_APCSFinalProject
     *
     * @author Sources:
     */
    public class MouseAction implements MouseMotionListener
    {

        /**
         * When the player moves their mouse over the Player Window, this method
         * gets the X and Y coordinates of each position that the mouse is on
         * and saves it in the variables myX and myY.
         * 
         * @param e
         *            detects the mouse
         * 
         */
        @Override
        public void mouseMoved( MouseEvent e )
        {

            myX = e.getX();
            myY = e.getY();
        }


        /**
         * Had to Implement Method
         */
        @Override
        public void mouseDragged( MouseEvent e )
        {
            // TODO Auto-generated method stub

        }
    }


    /**
     * 
     * This class implements java.awt.event.MouseListener which takes input from
     * the player when they click on the Player Window.
     *
     * @author Riya Kumari
     * @version May 30, 2019
     * @author Period: 5
     * @author Assignment: Batttleship_APCSFinalProject
     *
     * @author Sources:
     */
    public class PlayerAction implements MouseListener
    {
        int[] coord = new int[2];


        /**
         * When the player plays on the Computer board in the Player Window,
         * this method stores the x and y coordinates. It determines whether a
         * ship has been hit or if the player missed. It also updates the score
         * for Player.
         * 
         * @param e
         *            MouseEvent detects the mouse
         *            java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
         */
        @Override
        public void mouseClicked( MouseEvent e )
        {

            if ( startPressed && playerTurn )
            {
                // System.out.println(e.getX() + " , " + e.getY());
                myX = e.getX();
                myY = e.getY();

                BoardLocation a1 = new BoardLocation();
                // Converts the pixel values to board location and updates
                // isClicked

                if ( playerTurn && myX >= 473 && myX <= 868 && myY >= 111 && myY <= 505 )
                {
                    boardType = "BLUE";
                    coord = a1.ConvertToBoardLoc( myX, myY, boardType );
                    int col = coord[0];
                    int row = coord[1];
                    // check if location has already been played on
                    if ( ifClickedBlue[row][col] == true )
                    {
                        playerTurn = true;
                        computerTurn = false;
                        return;
                    }
                    Color c;

                    ifClickedBlue[row][col] = true;

                    // if the comp board has something in that square then it
                    // updates the score
                    if ( !Computer.computerLocation[row][col].equals( colors.getGridColor() ) )
                    {
                        c = Computer.computerLocation[row][col];
                        gh.updateScore( c, 1 );
                        playerScore = GameHelper.scoreP;

                    }

                    playerTurn = !playerTurn;
                    computerTurn = !computerTurn;
                }
            }
        }


        /**
         * Had to Implement Method
         */
        @Override
        public void mousePressed( MouseEvent e )
        {
            // TODO Auto-generated method stub

        }


        /**
         * Had to Implement Method
         */
        @Override
        public void mouseReleased( MouseEvent e )
        {
            // TODO Auto-generated method stub

        }


        /**
         * Had to Implement Method
         */
        @Override
        public void mouseEntered( MouseEvent e )
        {
            // TODO Auto-generated method stub

        }


        /**
         * Had to Implement Method
         */
        @Override
        public void mouseExited( MouseEvent e )
        {
            // TODO Auto-generated method stub

        }

    }
}
