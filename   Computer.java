package Battleship;

import java.awt.Color;
import java.util.LinkedList;


/**
 * This class takes cake of all actions performed by the Computer's point of
 * view. It sets up the ships and shoots.
 *
 * @author Tanav
 * @version May 30, 2019
 * @author Period: 5
 * @author Assignment: Batttleship_APCSFinalProject
 *
 * @author Sources:
 */
public class Computer implements User
{
    // 2D array of ship's locations
    // 1 if ship present
    // 0 if ship not present
    // -1 if ship has been sunk
    /**
     * A 2D Color array to keep track of where the Comuter's ships are located.
     * If Color at the grid is equal to the gridColor, then nothing is present,
     * otherwise the grid is filled with ship's colors.
     */
    public static Color[][] computerLocation;

    /**
     * Color object to keep track of different types of colors present in the
     * game
     */
    public Colors colors;

    /**
     * a LinkedList of Location type to keep track of all the places computer
     * has previously shot.
     */
    public LinkedList<Location> computerShots;


    /**
     * Constructor. Initializes the color object. In a 2D array sets all the
     * colors to the grid colors.
     */
    public Computer()
    {
        computerShots = new LinkedList<Location>();
        colors = new Colors();
        computerLocation = new Color[10][10];
        for ( int i = 0; i < 10; i++ )
        {
            for ( int j = 0; j < 10; j++ )
            {
                // System.out.println( colors.getGridColor() );
                computerLocation[i][j] = colors.getGridColor();
            }
        }
    }


    /**
     * This method iterates through the inputed Ship[]. It calls setShips helper
     * with each ship
     * 
     * @param ships
     *            an array filled with different types of ships.
     */
    public void setShips( Ship[] ships )
    {
        // 1 - Vertical
        // 0 - Horizontal
        for ( Ship s : ships )
        {
            setShipsHelper( s );
        }
    }


    /**
     * This method randomly generates a number between 0 and 1. If the number is
     * 1, the ships are placed horizontally. It generates another random
     * location and if the ships are placed outside the bounds, it will
     * calculate a new location for the ships to be placed at. If 0, it will
     * place ships vertically with the same logic.
     * 
     * @param s
     *            The ship to be places
     */
    public void setShipsHelper( Ship s )
    {
        int randomCol;
        int randomRow;
        int HV;

        boolean placed = false;
        while ( !placed )
        {
            randomCol = (int)( Math.random() * 10 );
            randomRow = (int)( Math.random() * 10 );
            HV = (int)( Math.random() * 100 );

            // either use all he places/col it will uses
            int[] potentialPlaces = new int[s.getSize()];

            boolean taken = false;
            if ( HV < 50 )
            {

                // fill with column that is going to be filled up
                for ( int i = 0; i < s.getSize(); i++ )
                {
                    potentialPlaces[i] = randomCol + i;
                }
                for ( int i : potentialPlaces )
                {
                    if ( i >= 10
                        || !computerLocation[randomRow][i].equals( colors.getGridColor() ) )
                    {
                        taken = true;
                    }
                }
                if ( taken )
                {
                    continue;
                }
                else
                {
                    for ( int i : potentialPlaces )
                    {
                        computerLocation[randomRow][i] = s.getColor();
                    }
                    placed = true;
                }
            }

            else
            {

                for ( int i = 0; i < s.getSize(); i++ )
                {
                    potentialPlaces[i] = randomRow + i;

                }
                for ( int i : potentialPlaces )
                {
                    {
                        taken = true;

                    }
                }
                if ( taken )
                {
                    continue;
                }
                else
                {
                    for ( int i : potentialPlaces )
                    {
                        computerLocation[i][randomCol] = s.getColor();
                    }
                    placed = true;
                }
            }
        }

    }


    /**
     * This randomly generates a location. If the Location is present in the
     * computerShot linkedList, it will generate a new location to fire it.
     * 
     * @return the Location object where it shot.
     */
    public Location shoot()
    {
        Location l = new Location();

        int x = GameHelper.random( 10 );
        int y = GameHelper.random( 10 );
        boolean ready = false;

        while ( !ready )
        {
            x = GameHelper.random( 10 );
            y = GameHelper.random( 10 );

            l.setX( x );
            l.setY( y );
            if ( notInList( l ) )
            {
                computerShots.add( l );
                ready = true;
            }
        }
        return l;

    }

    int count = 0;

    int column;

    int roww;


    // true if hit
    // false if miss
    /**
     * 
     * This method evaluates if the Location the computer just shot at is a hit
     * or miss.
     * 
     * @param loc
     *            the location to check if hit or not
     * @return true of hit false if miss
     */
    public boolean evaluate( Location loc )
    {
        int col = loc.getX();
        int row = loc.getY();

        PlayerWindow.ifClickedRed[row][col] = true;

        if ( Player.playerLocation[row][col].equals( colors.getGridColor() ) )
        {
            return false;
        }
        column = col;
        roww = row;
        return true;
    }


    /**
     * Getter methods for the column shot
     * 
     * @return the column that has just been shot
     */
    public int getColumn()
    {
        return column;
    }


    /**
     * Getter methods for the row shot
     * 
     * @return the row that has just been shot
     */
    public int getRoww()
    {
        return roww;
    }


    /**
     * 
     * This method checks if the shot location is not in the LinkedList for
     * shots
     * 
     * @param loc
     *            the location that has been shot
     * @return true if location hasn't been shot, false if in the list
     */
    private boolean notInList( Location loc )
    {
        int x = loc.getX();
        int y = loc.getY();

        Location index;
        for ( int i = 0; i < computerShots.size(); i++ )
        {
            index = computerShots.get( i );
            if ( index.getX() == x && index.getY() == y )
            {
                return false;
            }
        }
        return true;
    }
}
