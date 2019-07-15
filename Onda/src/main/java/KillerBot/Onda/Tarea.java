package KillerBot.Onda;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;

import javax.imageio.ImageIO;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Tarea extends TimerTask{
	public BufferedImage image;
	static String[] nombres = {"Julio","Nacho","Fernando","Roni","Mark","Darlyn",
		"Carlos","Oscar","Naxo","Cervello","Pedro","Ivan","Juanjo","Perolo","Sarasa",
		"David","Lluis","Contreras","Rober","Ismael"};
	Map<String, String> mape = new HashMap<String, String>(20);
	
    
	
	public Tarea(){
		mape.put("Julio", "@julio_vcf");
	}
	@Override
	public void run() {
		crearImagen();
		nombres = duelo(nombres);
		if(nombres.length == 1) {
//			twitterServicio(nombres[0],null,1);
//			System.out.println(nombres[0]+" se los ha cargado a todos");
			
			cancel();
		}
		
	} 
	
	public String[] duelo(String[] lista) {
		int n = (int) (Math.random() * lista.length) + 1;
		int n1 = (int) (Math.random() * lista.length) + 1;
		int cont = lista.length;
		String x = lista[n - 1];
		String xt= mape.get(x);
		String y = lista[n1 - 1];
		while (n == n1) {
			n1 = (int) (Math.random() * lista.length) + 1;
			y = lista[n1 - 1];
		}
		String yt = mape.get(y);
		if (cont>2){	
			cont--;
			if(xt == null && yt == null){
				System.out.println(x + " ha matado a " + y + " quedan " + cont + " en la peña");
			}
			else if(xt == null){
				System.out.println(x + " ha matado a " + y + " " + yt + " quedan " + cont + " en la peña");
			}
			else if(yt == null){
				System.out.println(x + " " + xt + " ha matado a " + y + " quedan " + cont + " en la peña");
			}
			else System.out.println(x + " " + xt + " ha matado a " + y + " " + yt + " quedan " + cont + " en la peña");
			}
		else System.out.println(x + " ha matado a " + y + ", " + x + " se los ha cargado a todos");
//		while (n == n1) {
//			n1 = (int) (Math.random() * lista.length) + 1;
//			y = lista[n1 - 1];
//		}
		
		
//		twitterServicio(x,y,cont);
		
		return asesinado(lista, n1-1);

	}

	public static String[] asesinado(String[] arr, int index) {

		if (arr == null || index < 0 || index >= arr.length) {
			return arr;
		}

		// Create another array of size one less
		String[] anotherArray = new String[arr.length - 1];

		// Copy the elements except the index
		// from original array to the other array
		for (int i = 0, k = 0; i < arr.length; i++) {

			// if the index is
			// the removal element index
			if (i == index) {
				continue;
			}

			// if the index is not
			// the removal element index
			anotherArray[k++] = arr[i];
		}

		// return the resultant array
		return anotherArray;
	}
  
	public static void twitterServicio(String asesino, String asesinado,int conta){
		String consumerKey = "JIEmn6zRpq9Dyx9UpmOI58tLm";
		String consumerSecret = "GnDPXEqZS2at5WYyfYDYqIb8zXEMQ7OxZzHXPETXTbnoS8uGpB";
		String accessToken = "1149316675877167104-28J4wL2i34CgHWUR2dQrcJ4Zf6EUly";
		String accessTokenSecret = "gLVo84n8L5lLMoexLpih8Ae73esZauFzdL4uyki2vemX8";
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(consumerKey).setOAuthConsumerSecret(consumerSecret)
				.setOAuthAccessToken(accessToken).setOAuthAccessTokenSecret(accessTokenSecret);
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		
		try {
			if(conta > 1)twitter.updateStatus(asesino+" ha asesinado a "+asesinado+" quedan "+ conta + " en la peña");
			else twitter.updateStatus(asesino+" ha asesinado a "+asesinado+", se los ha cargado a todos");
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}
	
	public void crearImagen(){
		if(image==null) return;
		try{
			Graphics g = image.getGraphics();
			g.setColor(Color.red);	
			g.drawString(nombres[0], 100, 100);
			g.drawString(nombres[1], 100, 100);
//			g.drawImage(ImageIO.read(new File("C:/Users/Julio/Desktop/prueba.jpg")), 300, 300, null);
			ImageIO.write(image, "png", new File("prueba.png"));
		}catch (IOException e) {e.printStackTrace();}
	}
	
}
