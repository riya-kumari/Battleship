package Battleship;

import java.awt.Color;

/**
 * 
 *  This Interface is to be implemented by all different types of ship where they have to define how each method works for its own specifications.
 *
 *  @author  Santosh
 *  @version May 30, 2019
 *  @author  Period: 5
 *  @author  Assignment: Batttleship_APCSFinalProject
 *
 *  @author  Sources: 
 */
public interface Ship
{
    /**
     * Returns the size for each ship
     * @return the size
     */
    int getSize();

    /**
     * Returns the color for each ship
     * @return the color of each ship
     */
    Color getColor();

    /**
     * Returns the partial score for each ships
     * @return the partial score which is the number of points per ship part
     */
    public int getPartialScore();   

    /**
     * Returns the type of ship it is
     * @return the type of ship
     */
    String getType();

    /**
     * returns the number of points earned if the ship is sunk
     * @return the points of the ship
     */
    int getScore();
}
