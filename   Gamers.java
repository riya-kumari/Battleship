package Battleship;

// import net.arikia.dev.drpc.*;


/**
 * 
 * The Main Class where the PlayerWindow and GameOverWindow are declared. It
 * decides when to display PlayerWindow and GameOverWindow. Also deals with
 * Discord Rich Presence.
 *
 * @author Riya Kumari, Tanav Ohal
 * @version May 30, 2019
 * @author Period: 5
 * @author Assignment: Batttleship_APCSFinalProject
 *
 * @author Sources:
 */
public class Gamers implements Runnable
{

    /**
     * Constructor
     */
    public Gamers() {}
    
    /**
     * Makes a newOver Window behind the main window
     */
    GameOverWindow b = new GameOverWindow();

    /**
     * Thr Flag to check if the game is over
     */
    private boolean flag = false;

    /**
     * Rich presence to check if the system this game is running on is windows
     */
    // for Discord Rich Presence
    public static boolean runDiscord = System.getProperty( "os.name" )
        .toLowerCase()
        .indexOf( "win" ) >= 0;

    /**
     * Makes a playerwindow to show the game content
     */
    PlayerWindow a = new PlayerWindow();


    /**
     * Main Method
     * 
     * @param args the thread of the system
     */
    public static void main( String[] args )
    {
         if ( runDiscord )
         {
             // DiscordRPC.discordInitialize( "582734573255786507", new DiscordEventHandlers(), true );
            // Gamers.updatePresence( "Please appreciate this!", "Hey," );
             //Gamers.updatePresence( "Getting Ready to Play", "Title Screen" );
         }
        new Thread( new Gamers() ).start();

    }


    /**
     * Updates the Rich Presence in discord to show the game status
     * 
     * @param header
     *            the title of the status
     * @param details
     *            the status detials
     */
    // public static void updatePresence( String header, String details )
    // {
    //     if ( Gamers.runDiscord )
    //     {
    //         DiscordRPC.discordUpdatePresence(
    //             new DiscordRichPresence.Builder( header ).setDetails( details ).build() );
    //     }
    // }


    /**
     * Runs the game as long as neither user wins. When a user wins, then the
     * game pauses and a Game Over window opens up which also displays whether
     * current user won or lost.
     */
    public void run()
    {

        while ( a.GameOver() == false )
        {
            a.setVisible( true );

            a.repaint();

        }
        String str = a.getWinner();
        if ( str.equals( "Player" ) )
        {
            flag = true;
        }
        b.setWinner( flag );
        a.setVisible( true );
        while ( true )
        {
            b.repaint();
            b.setVisible( true );

        }

    }
}
