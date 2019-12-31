package Battleship;

/**
 * 
 *  This interface is inherited all the players that are playing. Currently only Computer and Player have it.
 *  It's main purpose is organization because it only has 1 method that the instances of this interface have to implement. 
 *
 *  @author  Santosh
 *  @version May 30, 2019
 *  @author  Period: 5
 *  @author  Assignment: Batttleship_APCSFinalProject
 *
 *  @author  Sources: 
 */
public interface User
{
    /**
     * This abstract method is to be defined by each User for its own needs. 
     * @param ships Ship[] that contains all the ships that needs to be placed
     */
    void setShips(Ship[] ships );
    
    /**
     * This method randomly generates a number between 0 and 1. If the number is
     * 1, the ships are placed horizontally. It generates another random
     * location and if the ships are placed outside the bounds, it will
     * calculate a new location for the ships to be placed at. If 0, it will
     * place ships vertically with the same logic.
     * @param s the ship to be placed
     */
void setShipsHelper(Ship s);
}
