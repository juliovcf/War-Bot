package KillerBot.Onda;
import java.util.Timer;
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
//	static String[] nombres = {"Julio","Nacho","Fernando","Roni","Mark"};
	
    public static void main( String[] args )
    {
    	
    	Timer temp = new Timer();
    	temp.schedule(new Tarea(), 1000, 1000);
//    	while (nombres.length > 1){
//			nombres = duelo(nombres);
			
//    	}
		
		// for(int i=0; i<nombres.length; i++){
//		 System.out.println(nombres[0]+" se los ha cargado a todos");
		// }

	}

//	public static String[] duelo(String[] lista) {
//		int n = (int) (Math.random() * lista.length) + 1;
//		int n1 = (int) (Math.random() * lista.length) + 1;
//		String x = lista[n - 1];
//		String y = lista[n1 - 1];
//		while (n == n1) {
//			n1 = (int) (Math.random() * lista.length) + 1;
//			y = lista[n1 - 1];
//		}
//		System.out.println(x + " ha matado a " + y);
//		twitterServicio(x,y);
//		return asesinado(lista, n1-1);
//
//	}
//
//	public static String[] asesinado(String[] arr, int index) {
//
//		if (arr == null || index < 0 || index >= arr.length) {
//			return arr;
//		}
//
//		// Create another array of size one less
//		String[] anotherArray = new String[arr.length - 1];
//
//		// Copy the elements except the index
//		// from original array to the other array
//		for (int i = 0, k = 0; i < arr.length; i++) {
//
//			// if the index is
//			// the removal element index
//			if (i == index) {
//				continue;
//			}
//
//			// if the index is not
//			// the removal element index
//			anotherArray[k++] = arr[i];
//		}
//
//		// return the resultant array
//		return anotherArray;
//	}
//  
//	public static void twitterServicio(String asesino, String asesinado){
//		String consumerKey = "CkZkvliSTTvE27sozwO2Oyo3J";
//		String consumerSecret = "Aw9r9X4MxMUbCMTFupLETfNPjGTUUGnulU56vXGJryODW1gIot";
//		String accessToken = "2387825684-fI0SWPtCqIGk9LCtYBVC5sSGnIifa3RFqm07D7j";
//		String accessTokenSecret = "VqTtmPIIFGi9766dVUA8Sd6SZ1Pkjlp42sVk74pJTQFhq";
//		
//		ConfigurationBuilder cb = new ConfigurationBuilder();
//		cb.setDebugEnabled(true).setOAuthConsumerKey(consumerKey).setOAuthConsumerSecret(consumerSecret)
//				.setOAuthAccessToken(accessToken).setOAuthAccessTokenSecret(accessTokenSecret);
//		TwitterFactory tf = new TwitterFactory(cb.build());
//		Twitter twitter = tf.getInstance();
//		
//		try {
//			twitter.updateStatus(asesino+" ha asesinado a "+asesinado);
//			
//		} catch (TwitterException e) {
//			e.printStackTrace();
//		}
//	}
    
}
