package Battleship;

import java.awt.Color;

import Battleship.ShipInstances.Battleship;
import Battleship.ShipInstances.Carrier;
import Battleship.ShipInstances.Cruiser;
import Battleship.ShipInstances.Destroyer;
import Battleship.ShipInstances.Submarine;


/**
 * This class helps run the Game Logic. It's primary job is to keep track of the
 * Ships that have been hit.
 *
 * @author Tanav, Riya
 * @version May 30, 2019
 * @author Period: 5
 * @author Assignment: Batttleship_APCSFinalProject
 *
 * @author Sources:
 */
public class GameHelper
{
    /**
     * A Ship Array that holds the different types of ship instances. This is
     * helpful to iterate through the ships and to check if any of the ship's
     * colors are the ones that have been hit.
     */
    public static Ship[] shipsArray = new Ship[5];

    /**
     * Number of remaining hits available on the ship until it sinks: Player's
     * Submarine
     */
    private int subSizeP;

    /**
     * Number of remaining hits available on the ship until it sinks: Player's
     * Destroyer
     */
    private int destSizeP;

    /**
     * Number of remaining hits available on the ship until it sinks: Player's
     * Carrier
     */
    private int carrSizeP;

    /**
     * Number of remaining hits available on the ship until it sinks: Player's
     * Battleship
     */
    private int battSizeP;

    /**
     * Number of remaining hits available on the ship until it sinks: Player's
     * Cruiser
     */
    private int cruiSizeP;

    /**
     * Number of remaining hits available on the ship until it sinks: Player's
     * Subamrine
     */
    private int subSizeC;

    /**
     * Number of remaining hits available on the ship until it sinks: Computer's
     * Subamrine
     */
    private int destSizeC;

    /**
     * Number of remaining hits available on the ship until it sinks: Computer's
     * Destroyer
     */
    private int carrSizeC;

    /**
     * Number of remaining hits available on the ship until it sinks: Computer's
     * Battleship
     */
    private int battSizeC;

    /**
     * Number of remaining hits available on the ship until it sinks: Computer's
     * Cruiser
     */
    private int cruiSizeC;

    /**
     * int variable to keep score of the Player's points.
     */
    public static int scoreP;

    /**
     * int variable to keep score of the Computer's points.
     */
    public static int scoreC;

    /**
     * This Object puts all the constant colors that are always used in one
     * class so they are readily accessible everywhere.
     */
    Colors colors;


    /**
     * Constructor for Game Helper. Initializes the Colors object, initializes
     * the ShipArray[] and sets Player and Computer score to 0.
     */
    public GameHelper()
    {
        colors = new Colors();
        shipsArray = createShipsArray();
        initializeValues();
        scoreP = 0;
        scoreC = 0;
    }


    /**
     * Returns the Computer Score
     * 
     * @return Computer Score
     */
    public int getScoreC()
    {

        return scoreC;
    }


    /**
     * Returns the Player Score
     * 
     * @return Player Score
     */
    public int getScoreP()
    {

        return scoreP;
    }


    // 1- player
    // 0 = computer
    /**
     * This method updates the score for the computer or player. Depending on
     * whether the entered integer corresponded with player or computer, the
     * method called findShipForColor(Color c) and tried to find which ship had
     * just been hit. Depending on which ship had been hit, the method adds
     * points to the player or computer's score.
     * 
     * @param c
     *            The Ship Color which had just been hit
     * @param who
     *            Who the score needs to be updated for. 1 For player, 0 for
     *            Computer.
     */
    public void updateScore( Color c, int who )
    {
        if ( who == 1 )
        {
            Ship s = findShipForColor( c );
            String shipType = s.getType();

            if ( shipType.equals( "Battleship" ) )
            {
                battSizeP--;
                scoreP += s.getPartialScore();
            }
            else if ( shipType.equals( "Destroyer" ) )
            {
                destSizeP--;
                scoreP += s.getPartialScore();
            }
            else if ( shipType.equals( "Cruiser" ) )
            {
                cruiSizeP--;
                scoreP += s.getPartialScore();
            }
            else if ( shipType.equals( "Carrier" ) )
            {
                carrSizeP--;
                scoreP += s.getPartialScore();
            }
            else if ( shipType.equals( "Submarine" ) )
            {
                subSizeP--;
                scoreP += s.getPartialScore();
            }

            else
            {
                scoreP += 0;
            }
        }
        else
        {
            Ship s = findShipForColor( c );
            String shipType = s.getType();

            if ( shipType.equals( "Battleship" ) )
            {
                battSizeC--;
                scoreC += s.getPartialScore();
            }
            else if ( shipType.equals( "Destroyer" ) )
            {
                destSizeC--;
                scoreC += s.getPartialScore();
            }
            else if ( shipType.equals( "Cruiser" ) )
            {
                cruiSizeC--;
                scoreC += s.getPartialScore();
            }
            else if ( shipType.equals( "Carrier" ) )
            {
                carrSizeC--;
                scoreC += s.getPartialScore();
            }
            else if ( shipType.equals( "Submarine" ) )
            {
                subSizeC--;
                scoreC += s.getPartialScore();
            }

            else
            {
                scoreC += 0;
            }
        }
    }


    /**
     * This method simply initializes the shipArray, and other classes making
     * their own ShipArray[] with different instances of the ships at different
     * indexes.
     * 
     * @return instantiated shipArray which contains the different instances of
     *         ship
     */
    public Ship[] createShipsArray()
    {
        shipsArray[0] = new Battleship();
        shipsArray[1] = new Carrier();
        shipsArray[2] = new Cruiser();
        shipsArray[3] = new Destroyer();
        shipsArray[4] = new Submarine();

        return shipsArray;
    }


    /**
     * This method checks if any ships remain of a specific color on the board.
     * Since all the ships have different colors, it takes in which color has
     * been hit and iterates through the PlayerLocation or ComputerLocation 2D
     * array to find any more occurrences of the color. If there are more
     * occurrences, it returns false, otherwise it returns true.
     * 
     * @param c
     *            The Ship Color that has been just hit
     * @param who
     *            Who needs who needs to check if something has sunk or not, "p"
     *            for player and "c" for computer
     * @return The Ship object that has been sunk
     */
    public Ship hasSunk( Color c, String who )
    {
        if ( who.equals( "p" ) )
        {
            Ship s = findShipForColor( c );
            if ( battSizeP == 0 || subSizeP == 0 || carrSizeP == 0 || cruiSizeP == 0
                || destSizeP == 0 )
            {
                return s;
            }
            else
            {
                return null;

            }
        }
        else
        {
            Ship s = findShipForColor( c );
            if ( battSizeC == 0 || subSizeC == 0 || carrSizeC == 0 || cruiSizeC == 0
                || destSizeC == 0 )
            {
                return s;
            }
            else
            {
                return null;

            }
        }
    }


    /**
     * 
     * This method initializes all the size variables. It iterates through the
     * ShipArray and get's all the ships' sizes. We assign the sizes based on
     * the ship names.
     */
    private void initializeValues()
    {
        for ( Ship s : shipsArray )
        {
            if ( s.getType().equals( "Battleship" ) )
            {
                battSizeP = s.getSize();
                battSizeC = s.getSize();
            }
            else if ( s.getType().equals( "Destroyer" ) )
            {
                destSizeP = s.getSize();
                destSizeC = s.getSize();
            }
            else if ( s.getType().equals( "Cruiser" ) )
            {
                cruiSizeP = s.getSize();
                cruiSizeC = s.getSize();
            }
            else if ( s.getType().equals( "Carrier" ) )
            {
                carrSizeP = s.getSize();
                carrSizeC = s.getSize();
            }
            else if ( s.getType().equals( "Submarine" ) )
            {
                subSizeP = s.getSize();
                subSizeC = s.getSize();
            }
        }
    }


    /**
     * 
     * This method returns the ship for the given color. It iterates through the
     * shipArray and if the color of the ship in the array matches the parameter
     * color, it will return the ship. Null if no found.
     * 
     * @param c
     *            Color of the ship that has been hit
     * @return The ship that corresponds with the color passed in through the
     *         parameter.
     */
    private Ship findShipForColor( Color c )
    {
        for ( Ship ship : shipsArray )
        {
            if ( ship.getColor().equals( c ) )
            {
                return ship;
            }
        }
        return null;
    }


    /**
     * Since Math.Random() did not provide us with enough randomness, this is a
     * custom random method. It makes a size 100 array and sets all its values
     * to random values with Math.Random(). Then with Math.random, it generates
     * a random index, and multiplies that with the multiplies and returns the
     * value.
     * 
     * @param multiply
     *            the necessary multiple of the randomly generated number to
     *            return
     * @return the random number from 0-multiply
     */

    public static int random( int multiply )
    {
        double[] randoms = new double[100];
        for ( int i = 0; i < 100; i++ )
        {
            randoms[i] = Math.random();
        }
        return (int)( ( randoms[(int)( Math.random() * 100 )] ) * ( multiply ) );
    }

}