package KillerBot.Onda;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
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
//	static String[] nombres = {"Julio","Nacho","Fernando","Roni","Mark","Darlyn",
//		"Carlos","Oscar","Naxo","Cervello","Pedro","Ivan","Juanjo","Perolo","Sarasa",
//		"David","Lluis","Contreras","Rober","Ismael"};
	
	Map<String, String> mape = new HashMap<String, String>(100);
	String[] nombres = new String[100];
	
    
	
	public Tarea(){
		mape.put("Julio Perez", "@julio_vcf");
		mape.put("Nekane Iserte", "@Nekaneiserte");
		mape.put("Pedro Berrocal", "@pedrorck16");
		mape.put("Rafa Perez", "@rafetaonda");
		mape.put("Fernando Villegas", "@fernando_RCK");
		mape.put("Anna Romero", "@anna_romero9");
		mape.put("Claudia Catalan", "@catalanclaudia9");
		mape.put("Laura Ortiz", "@lau_dsn");
		mape.put("Sergio Castillo", "@Sergio35444057");
		mape.put("Marta Fores", "@mforesinsa");
		mape.put("Cesar Pascual", "@cesaronda96");
		mape.put("Claudia Moya", "@claudiamoya1999");
		mape.put("Mireia", "@Miireiaa20");
		mape.put("Michelle", "@MichelleDsn1");
		mape.put("Juan Vives", "@Juuan92");
		mape.put("Cristina Blazquez", "@crisblazquez98");
		mape.put("Yael Huget", "@yaelhm10");
		mape.put("Cristina Gallego", "@crisgallego99");
		mape.put("Alex Valero", "@Valero5_rck");
		mape.put("Oscar Jimenez", "@oskiki_etk");
		mape.put("Reyes Peris", "@reyesnlx");
		mape.put("Mark Garcia", "@mark_RCK"); //22
		mape.put("Nacho Davila", "@nacho_7_rck");
		mape.put("Javi Sol", "@javi96sol");
		mape.put("Carlos Cruz", "@CarlosRck");
		mape.put("Juan Silvestre", "@Juansilvestree");
		mape.put("Kike Garcia", "@Kikegarcia_7");
		mape.put("Darlyn", "@DARLYN_RCK");
		mape.put("Juanjo Herrero", "@juanjoo_rck");
		mape.put("Josep Gomez", "@Pajo_9");
		mape.put("Mar Leones", "@marleonesfolch");
		mape.put("Emilo Feliu", "@emiliofeliu");
		mape.put("Nacho Hernandez", "@nachogym94");
		mape.put("Borja Garcia", "@BorjaaGarciaa");
		mape.put("Pedro Ecamez", "@PedroEscamezG");
		mape.put("Javi Ortells", "@ortells95");
		mape.put("Anna Castillo", "@annacastillo99");
		mape.put("Alberto Garcia", "@Alberto_Sofok");
		mape.put("Sergio Juarez", "@SergioJuarez10");
		mape.put("Elena Monzonis", "@ElenaMonzonis");
		mape.put("Carlos Alejandro", "@carlos051097"); //41
		mape.put("Ruben Vizcaino", "@tito_vizcaino14");
		mape.put("Sergio Lopez", "@slopezmanuel");
		mape.put("Alex Molina", "@Aleex_molinaa");
		mape.put("Ana Belen", "@_anabelen00");//45
		mape.put("Alex Molina", "@alexmoli_95");
		mape.put("Andrea Benages", "@andreabenages");
		mape.put("Antonio Gimeno", "@_antoniogimeno");
		mape.put("Javier Vicent", "@javivicent97");
		mape.put("Lluis Castañ", "@lluiscasfer");//50
		mape.put("Alexandra Campos", "@alexandraraigad");
		mape.put("Abel Navarro", "@Abel24Navarro");
		mape.put("Claudia Gimeno", "@ClauSLP3");
		mape.put("Jorge Ten", "@jorgeten10");
		mape.put("Eric Llorens", "@llorens23");//55
		mape.put("Naxo Leon", "@naxo_rck");
		mape.put("Ivan Reboll", "@rckivan");
		mape.put("Eric Sansano", "@Eric_sansano8");
		mape.put("David Gomez", "@96davidgomez");
		mape.put("Roberto Martinez", "@RobertoRck");//60
		mape.put("Eric Cervello", "@cerve_rck");
		mape.put("Rocio Anaya", "@RociioAnaya12");
		mape.put("Aida Fernandez", "@aiidafernandez");
		mape.put("Juanjo Piquer", "@juanjopiquer21");
		mape.put("Andrea Cruzado", "@andreacruzaado");//65
		mape.put("Ana Castillo", "@Anacastiillo9");
		mape.put("Andrea Benages", "@andreabenages");
		mape.put("Carmen Mallen", "@Carmen_Mallen");
		mape.put("Maria Ortells", "@Maria_Ortells");
		mape.put("Ines Gea", "@ineesgea");//70
		mape.put("Iris Perez", "@iris_pv13");
		mape.put("Paula Piquer", "@paula_piquer_");
		mape.put("Lucia Romero", "@Lu_romero98");
		mape.put("Adrian Guillamon", "@adri_guillamon");
		mape.put("Lidia Soler", "@lidiasoler1");
		mape.put("Sandra Muñoz", "@sandrita_est");
		mape.put("Enric Borrás", "@EnricBR10");
		mape.put("Alberto Lopez", "@LoperaRPK");
		mape.put("Sara Martinez", "@sara_mt12");
		mape.put("Aiman", "@aimanrbs17"); //80
		mape.put("Elena Moya", "@elenyclau24");
		mape.put("Esther Vicent", "@esthervicent");
		mape.put("Aida Escudero", "@Aida878");
		mape.put("Sonia Belmonte", "@sonia_slp");
		mape.put("Laia Solsona", "Laia_sg_99");//85
		mape.put("Elena Blanco", "@Elena_Nlx");
		mape.put("Jordi Ramos", "@jordiramos_rtsk");
		mape.put("Roberto Lozar", "@robertolozar");
		mape.put("David Alarcon", "@Dave_Alarcon");
		mape.put("Eva Badenes", "@evabadenes05");
		
		nombres = listaDeNombres(mape);
		
		
		
		
		
		
		
		
		
		
		
	}
	@Override
	public void run() {
		
//		nombres = duelo(nombres);
//		if(nombres.length == 1) {
////			twitterServicio(nombres[0],null,1);
//			System.out.println(nombres[0]+" se los ha cargado a todos");
//			
//			cancel();
//		}
		
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
				System.out.println(x + " ha matado a " + y + " quedan " + cont + " ondenses. #OndaWarBot");
			}
			else if(xt == null){
				System.out.println(x + " ha matado a " + y + " " + yt + " quedan " + cont + " ondenses. #OndaWarBot");
			}
			else if(yt == null){
				System.out.println(x + " " + xt + " ha matado a " + y + " quedan " + cont + " ondenses. #OndaWarBot");
			}
			else System.out.println(x + " " + xt + " ha matado a " + y + " " + yt + " quedan " + cont + " ondenses. #OndaWarBot");
			}
		else System.out.println(x + " " + xt +" ha matado a " + y + " " + yt +", " + x + " se los ha cargado a todos. #OndaWarBot");
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
	
//	public void crearImagen(){
//		if(image==null) return;
//		try{
//			Graphics g = image.getGraphics();
//			g.setColor(Color.red);	
//			g.drawString(nombres[0], 100, 100);
//			g.drawString(nombres[1], 100, 100);
////			g.drawImage(ImageIO.read(new File("C:/Users/Julio/Desktop/prueba.jpg")), 300, 300, null);
//			ImageIO.write(image, "png", new File("prueba.png"));
//		}catch (IOException e) {e.printStackTrace();}
//	}
	public static String[] listaDeNombres(Map<String,String> lista){
		String[] claves = lista.keySet().toArray(new String[0]);
		 
//		System.out.println(claves.length);
		Arrays.sort(claves);
		for (String clave: claves)
			  System.out.println(clave);
		
		return claves;
		
	}
}
