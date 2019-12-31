package Battleship;

import javax.swing.JFrame;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.*;


/**
 * 
 * Creates the GameOverWindow which pops up when the the player either wins or
 * loses.
 *
 * @author Riya Kumari
 * @version May 30, 2019
 * @author Period: 5
 * @author Assignment: Batttleship_APCSFinalProject
 *
 * @author Sources:
 */
public class GameOverWindow extends JFrame
{

    /**
     * winner : stores what is displayed when the player wins or loses
     */
    String winner = PlayerWindow.winner;


    /**
     * Constructs the window that will display game over.
     */
    public GameOverWindow()
    {

        this.setSize( 400, 400 );
        this.setVisible( true );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        TextInside text = new TextInside();
        this.setContentPane( text );

        // JLabel gameOver = new JLabel("GAME OVER");
        // this.add(gameOver);

    }


    /**
     * Sets the winner of the game. 
     * 
     * @param x
     *            is a boolean value that is passed in Gamers. If the player has
     *            won then it is true and vice-versa.
     */
    public void setWinner( boolean x )
    {
        if ( x )
        {
            winner = "You Won!!!";
        }
        else
        {
            winner = "You Lost :(";
        }
    }


    /**
     * Displays the Text Inside the JPanel.
     * 
     * @author riyakumari
     *
     */
    public class TextInside extends JPanel
    {

        /**
         * Paints the text inside the GameOver Window
         * 
         * @param g
         *            is default
         * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
         * 
         */

        protected void paintComponent( Graphics g )
        {
            g.setFont( ( new Font( "Serif", Font.BOLD, 20 ) ) );
            g.drawString( "GAME OVER", 400 / 2 - 100, 400 / 2 - 100 );
            g.setFont( ( new Font( "Serif", Font.BOLD, 10 ) ) );
            // System.out.println("Winner : "+winner);
            g.drawString( "" + winner, 400 / 2, 400 / 2 + 50 );

        }

    }

}
