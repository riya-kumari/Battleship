package Battleship;

/**
 * This object represents the specification of each button the GUI Window
 * 
 * @author Tanav
 * @version May 30, 2019
 * @author Period: 5
 * @author Assignment: Batttleship_APCSFinalProject
 *
 * @author Sources:
 */
public class Location
{
    /**
     * The X-Coordinate of each specfic location on the grid
     */
    private int xCoordinate;

    /**
     * The Y-Coordinate of each specific location on the grid
     */
    private int yCoordinate;

    /**
     * The name of the Board this Location is present on
     */
    private String userName;


    /**
     * The constructor
     * 
     * @param x
     *            The X coordinate of this object on the grid
     * @param y
     *            The Y coordinate of this object on the grid
     * @param name
     *            the board this is button is present on
     */
    public Location( int x, int y, String name )
    {
        xCoordinate = x;
        yCoordinate = y;

        userName = name;
    }


    /**
     * No-Args Constructor, Sets x and y to 0
     */
    public Location()
    {
        xCoordinate = 0;
        yCoordinate = 0;
    }


    /**
     * Returns the X coordinate of this button
     * 
     * @return the x coordinate
     */
    public int getX()
    {
        return xCoordinate;
    }


    /**
     * Returns the Y coordinate of this button
     * 
     * @return the Y coordinate
     */
    public int getY()
    {
        return yCoordinate;
    }


    /**
     * Returns the name of this board
     * 
     * @return the board name
     */
    public String getName()
    {
        return userName;
    }


    /**
     * Sets the xCoords to the one passed through the parameter
     * 
     * @param xCoord
     *            the xCoord to set
     */
    public void setX( int xCoord )
    {
        xCoordinate = xCoord;
    }


    /**
     * Sets the YCoords to the one passed through the parameter
     * 
     * @param yCoord
     *            the YCoord to set
     */
    public void setY( int yCoord )
    {
        yCoordinate = yCoord;
    }
}
