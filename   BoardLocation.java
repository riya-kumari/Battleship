package Battleship;

/**
 * 
 * This objects help convert pixel values of the GUI to the Board's X and Y
 * Coordinates.
 *
 * @author Tanav, Riya
 * @version May 30, 2019
 * @author Period: 5
 * @author Assignment: Batttleship_APCSFinalProject
 *
 * @author Sources:
 */
public class BoardLocation
{
    /**
     * The Row of the clicked pixel
     */
    private int row;

    /**
     * The Column of the clicked pixel
     */
    private int col;

    /**
     * The Pixel spacing between each button
     */
    private int space = 2;


    /**
     * Constructor sets row and column to the inputted values
     * 
     * @param row
     *            The Row that is clicked
     * @param col
     *            The Column that is clicked
     */
    public BoardLocation( int row, int col )
    {
        this.row = row;
        this.col = col;
    }


    /**
     * Constructor sets row and column to 0
     */
    public BoardLocation()
    {
        row = 0;
        col = 0;
    }


    /**
     * 
     * Through an algorithm, changes the clicked pixel value to a row and column
     * value on the board
     * 
     * @param XPix
     *            the X pixel that is clicked
     * @param YPix
     *            the Y pixel that is clicked
     * @param boardType
     *            the board it is clicked on, wither red or blue
     * @return an int[] where int[0] is the row and int[1] is the column on the
     *         board
     */
    public int[] ConvertToBoardLoc( int XPix, int YPix, String boardType )
    {
        int[] a = new int[2];
        if ( boardType.equals( "RED" ) )
        {
            a[0] = ( YPix - 114 ) / ( 40 );
            a[1] = ( XPix - 52 ) / ( 40 );
        }
        else if ( boardType.equals( "BLUE" ) )
        {
            a[0] = ( YPix - 114 ) / ( 40 );
            a[1] = ( XPix - 479 ) / ( 40 );
        }

        return a;

    }

    /**
     * Returns the Row that was clicked on
     * 
     * @return the row
     */
    public int getRow()
    {
        return row;
    }

    /**
     * Returns the Column that was clicked on
     * 
     * @return the column
     */
    public int getCol()
    {
        return col;
    }

}
