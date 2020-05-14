package KillerBot.Onda;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
    	
    	Timer temp = new Timer();
    	Date fecha = new Date();
    	int minuto = fecha.getMinutes();
    	int delay = (55-minuto)*60000;
        temp.schedule(new Tarea(), delay, 3600000)

     }
    
}
