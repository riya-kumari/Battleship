package Battleship;

import java.awt.Color;


/**
 * This object is a way to coordinate all the colors present on the GUI. It
 * represents the board color, hit color, miss color and many more constants.
 *
 * @author Tanav
 * @version May 30, 2019
 * @author Period: 5
 * @author Assignment: Batttleship_APCSFinalProject
 *
 * @author Sources:
 */
public class Colors
{
    /**
     * This color shows the color each other buttons are when the game is
     * started
     */
    private Color gridColor = Color.BLACK;

    /**
     * this color is the background of the red board.
     */
    private Color redBoardBG = Color.DARK_GRAY;

    /**
     * this color is the background of the blue board.
     */
    private Color blueBoardBG = Color.DARK_GRAY;

    /**
     * this color is the color that shows up when the player hovers over the
     * grid
     */
    private Color hover = Color.GREEN;

    /**
     * this color is the color behind the boards
     */
    private Color boardBG = Color.LIGHT_GRAY;

    /**
     * this color is displayed when the computer or the player manages to hit a
     * shot
     */
    private Color hitColor = Color.red;

    /**
     * this color is shown when the computer or player miss a shot
     */
    private Color missColor = new Color( 255, 255, 153 );


    /**
     * Constructor
     */
    public Colors()
    {
    }

    /**
     * Returns the grid color
     * 
     * @return grid color at the start of the game
     */
    public Color getGridColor()
    {
        return gridColor;
    }


    /**
     * Returns the red button color
     * 
     * @return red button color
     */
    public Color getRedBoard()
    {
        return redBoardBG;
    }


    /**
     * Returns the blue button color
     * 
     * @return red button color
     */
    public Color getBlueBoard()
    {
        return blueBoardBG;
    }


    /**
     * 
     * Returns the color that is shown when the Player hovers on the Grid
     * 
     * @return hover color
     */
    public Color getHover()
    {
        return hover;
    }


    /**
     * Returns the color behind the player and computer grid
     * 
     * @return the background color for the GUI
     */
    public Color getBoardBG()
    {
        return boardBG;
    }


    /**
     * Returns the color if the shot hit
     * 
     * @return the hit color
     */
    public Color getHit()
    {
        return hitColor;
    }


    /**
     * Returns the color if the shot missed
     * 
     * @return the miss color
     */
    public Color getMiss()
    {
        return missColor;
    }

}
