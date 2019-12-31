package Battleship;

import java.awt.Color;


/**
 * This class keeps track of all the operations necessary for the player. It
 * randomly sets up the player's ships.
 *
 * @author Tanav
 * @version May 30, 2019
 * @author Period: 5
 * @author Assignment: Batttleship_APCSFinalProject
 *
 * @author Sources:
 */
public class Player implements User
{
    /**
     * A 2D Color array to keep track of where the player's ships are located.
     * If Color at the grid is equal to the gridColor, then nothing is present,
     * otherwise the grid is filled with ship's colors.
     */
    public static Color[][] playerLocation;

    /**
     * Color object to keep track of different types of colors present in the
     * game
     */
    Colors colors;


    /**
     * Constructor. Initializes the color object. In a 2D array sets all the
     * colors to the grid colors.
     */
    public Player()
    {
        colors = new Colors();
        playerLocation = new Color[10][10];
        for ( int i = 0; i < 10; i++ )
        {
            for ( int j = 0; j < 10; j++ )
            {
                playerLocation[i][j] = colors.getGridColor();
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
        // int HV;

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
            randomCol = GameHelper.random( 10 );
            randomRow = GameHelper.random( 10 );
            HV = GameHelper.random( 100 );

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
                    if ( i >= 10 || !playerLocation[randomRow][i].equals( colors.getGridColor() ) )
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
                        playerLocation[randomRow][i] = s.getColor();
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
                    if ( i >= 10 || !playerLocation[i][randomCol].equals( colors.getGridColor() ) )
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
                        playerLocation[i][randomCol] = s.getColor();
                    }
                    placed = true;
                }
            }
        }
    }
}
