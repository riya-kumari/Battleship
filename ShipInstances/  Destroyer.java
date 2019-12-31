package Battleship.ShipInstances;

import java.awt.Color;

import Battleship.Ship;


/**
 * 
 * The class is an instance of the Ship Interface. This ship is a Destroyer
 * which has a Green Color. This Destroyer will give 40 points when you sink it.
 *
 * @author Santosh
 * @version May 30, 2019
 * @author Period: 5
 * @author Assignment: Batttleship_APCSFinalProject
 *
 * @author Sources:
 */
public class Destroyer implements Ship
{
    /**
     * The type of ship it is
     */
    private String type;

    /**
     * The color of the ship
     */
    private Color color;

    /**
     * the size of the ship
     */
    private int size;

    /**
     * the points this ship will yield after sinking it
     */
    private int scorePoints;
    /**
     * Constructor for Destroyer. Instantiates the Ship Name, its Color, its
     * Size and its total Points.
     */
    public Destroyer()
    {
        type = "Destroyer";
        color = color.BLUE;
        size = 2;
        scorePoints = 40;
    }



    /**
     * returns the size for this type of ship.
     * 
     * @return the size of the ship.
     */
    public int getSize()
    {
        return size;
    }


    /**
     * returns the score for this type of ship.
     * 
     * @return the score of the ship.
     */
    public int getScore()
    {
        return scorePoints;
    }


    /**
     * returns the partial points for this type of ship. partialPoints returns
     * how many points is awarded per hit on each location of the ship,
     * 
     * @return the partial points of the ship.
     */
    public int getPartialScore()
    {
        return scorePoints / size;
    }

    /**
     * returns the color for this type of ship.
     * 
     * @return the color of the ship.
     */
    public Color getColor()
    {
        return color;
    }

    /**
     * returns the type, or its name, of this type of ship.
     * 
     * @return the name of the ship.
     */
    public String getType()
    {
        return type;
    }
}
