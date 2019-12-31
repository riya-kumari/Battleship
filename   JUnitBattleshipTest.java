package Battleship;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;
import Battleship.ShipInstances.Battleship;
import Battleship.ShipInstances.Carrier;
import Battleship.ShipInstances.Cruiser;
import Battleship.ShipInstances.Destroyer;
import Battleship.ShipInstances.Submarine;
import junit.framework.JUnit4TestAdapter;


/**
 * JUnit Testing
 *
 * @author Santosh
 * @version May 31, 2019
 * @author Period: 5
 * @author Assignment: Batttleship_APCSFinalProject
 *
 * @author Sources: none
 */

public class JUnitBattleshipTest
{

    // -- Test Ships

    @Test
    public void testBattleshipGetSize()
    {
        Battleship battleship = new Battleship();
        assertEquals( battleship.getSize(), 4 );
    }


    @Test
    public void testBattleshipGetScore()
    {
        Battleship battleship = new Battleship();
        assertEquals( battleship.getScore(), 20 );
    }


    @Test
    public void testBattleshipPartialScore()
    {
        Battleship battleship = new Battleship();
        assertEquals( battleship.getPartialScore(), battleship.getScore() / battleship.getSize() );
    }


    @Test
    public void testBattleshipGetColor()
    {
        Battleship battleship = new Battleship();
        assertEquals( battleship.getColor(), Color.BLUE );

    }


    @Test
    public void testBattleshipGetType()
    {
        Battleship battleship = new Battleship();
        assertEquals( battleship.getType().toLowerCase(), "battleship" );
    }


    //
    @Test
    public void testCarrierGetScore()
    {
        Carrier carrier = new Carrier();
        assertEquals( carrier.getScore(), 50 );
    }


    @Test
    public void testCarrierPartialScore()
    {
        Carrier carrier = new Carrier();
        assertEquals( carrier.getPartialScore(), carrier.getScore() / carrier.getSize() );
    }


    @Test
    public void testCarrierGetColor()
    {
        Carrier carrier = new Carrier();
        assertEquals( carrier.getColor(), Color.BLUE );

    }


    @Test
    public void testCarrierGetType()
    {
        Carrier carrier = new Carrier();
        assertEquals( carrier.getType().toLowerCase(), "carrier" );
    }


    @Test
    public void testCruiserGetScore()
    {
        Cruiser cruiser = new Cruiser();
        assertEquals( cruiser.getScore(), 30 );
    }


    @Test
    public void testCruiserPartialScore()
    {
        Cruiser cruiser = new Cruiser();
        assertEquals( cruiser.getPartialScore(), cruiser.getScore() / cruiser.getSize() );
    }


    @Test
    public void testCruiserGetColor()
    {
        Cruiser cruiser = new Cruiser();
        assertEquals( cruiser.getColor(), Color.BLUE );

    }


    @Test
    public void testCruiserGetType()
    {
        Cruiser cruiser = new Cruiser();
        assertEquals( cruiser.getType().toLowerCase(), "cruiser" );
    }


    @Test
    public void testDestroyerGetScore()
    {
        Destroyer destroyer = new Destroyer();
        assertEquals( destroyer.getScore(), 40 );
    }


    @Test
    public void testDestroyerPartialScore()
    {
        Destroyer destroyer = new Destroyer();
        assertEquals( destroyer.getPartialScore(), destroyer.getScore() / destroyer.getSize() );
    }


    @Test
    public void testDestroyerGetColor()
    {
        Destroyer destroyer = new Destroyer();
        assertEquals( destroyer.getColor(), Color.BLUE );

    }


    @Test
    public void testDestroyerGetType()
    {
        Destroyer destroyer = new Destroyer();
        assertEquals( destroyer.getType().toLowerCase(), "destroyer" );
    }


    @Test
    public void testSubmarineGetScore()
    {
        Submarine submarine = new Submarine();
        assertEquals( submarine.getScore(), 40 );
    }


    @Test
    public void testSubmarinePartialScore()
    {
        Submarine submarine = new Submarine();
        assertEquals( submarine.getPartialScore(), submarine.getScore() / submarine.getSize() );
    }


    @Test
    public void testSubmarineGetColor()
    {
        Submarine submarine = new Submarine();
        assertEquals( submarine.getColor(), Color.BLUE );

    }


    @Test
    public void testSubmarineGetType()
    {
        Submarine submarine = new Submarine();
        assertEquals( submarine.getType().toLowerCase(), "submarine" );
    }


    // test Player

    @Test
    public void testPlayerConstructor()
    {
        Player player = new Player();
        assertNotNull( player.colors );
        assertNotNull( Player.playerLocation );
    }


    // test Computer

    @Test
    public void testComputerConstructor()
    {
        Computer computer = new Computer();
        assertNotNull( computer.computerShots );
        assertNotNull( computer.colors );
        assertNotNull( Computer.computerLocation );
    }


    @Test
    public void testComputerShoot()
    {
        Computer computer = new Computer();
        Location location = computer.shoot();
        assertNotNull( location );
    }


    // test GameHelper

    @Test
    public void testGameHelperGetScoreCandP()
    {
        GameHelper gamer = new GameHelper();
        assertEquals( gamer.getScoreC(), 0 );
        assertEquals( gamer.getScoreP(), 0 );
    }


    @Test
    public void testGameHelperUpdateScore()
    {
        GameHelper gamer = new GameHelper();
        gamer.updateScore( Color.BLUE, 1 );
        assertEquals( GameHelper.scoreP, 5 );
    }


    @Test
    public void testGameHelperCreateShipsArray()
    {
        GameHelper gamer = new GameHelper();
        assertNotNull( GameHelper.shipsArray );
    }


    // test Location

    @Test
    public void testLocationConstructor()
    {
        Location location = new Location( 5, 5, null );
        assertNull( location.getName() );
    }


    @Test
    public void testLocationGetX()
    {
        Location location = new Location( 5, 4, "location" );
        assertEquals( location.getX(), 5 );
    }


    @Test
    public void testLocationGetY()
    {
        Location location = new Location( 5, 6, "location" );
        assertEquals( location.getY(), 6 );
    }


    @Test
    public void testLocationGetName()
    {
        Location location = new Location( 5, 5, "location" );
        assertEquals( location.getName(), "location" );
    }


    @Test
    public void testLocationSetX()
    {
        Location location = new Location( 5, 5, "location" );
        location.setX( 3 );
        assertEquals( location.getX(), 3 );
    }


    @Test
    public void testLocationSetY()
    {
        Location location = new Location( 5, 5, "location" );
        location.setY( 7 );
        assertEquals( location.getY(), 7 );
    }


    // test BoardLocation

    @Test
    public void testBoardLocationConstructor()
    {
        BoardLocation location = new BoardLocation( 3, 3 );
        assertNotNull( location.getCol() );
    }


    @Test
    public void testBoardLocationConvert()
    {
        BoardLocation location = new BoardLocation( 3, 5 );
        int[] conversion = location.ConvertToBoardLoc( 52, 114, "RED" );
        assertEquals( conversion[0], 0 );
        assertEquals( conversion[1], 0 );
    }


    @Test
    public void testBoardLocationGetRow()
    {
        BoardLocation location = new BoardLocation( 3, 5 );
        assertEquals( location.getRow(), 3 );
    }


    @Test
    public void testBoardLocationGetCol()
    {
        BoardLocation location = new BoardLocation( 3, 5 );
        assertEquals( location.getCol(), 5 );
    }


    // To Run
    public static junit.framework.Test suite()
    {
        return new JUnit4TestAdapter( JUnitBattleshipTest.class );
    }


    public static void main( String args[] )
    {
        org.junit.runner.JUnitCore.main( "Battleship.JUnitBattleshipTest" );
    }

}