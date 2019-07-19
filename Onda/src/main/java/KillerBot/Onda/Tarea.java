package KillerBot.Onda;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;

import javax.imageio.ImageIO;

import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Tarea extends TimerTask{
	public BufferedImage image;
 //	static String[] nombres = {"Julio","Nacho","Fernando","Roni","Mark","Darlyn",
//		"Carlos","Oscar","Naxo","Cervello","Pedro","Ivan","Juanjo","Perolo","Sarasa",
//		"David","Lluis","Contreras","Rober","Ismael"};
	
	static Map<String, String> mape = new HashMap<String, String>(100);
	String[] nombres = new String[105];
	
    
	
	public Tarea(){
//		mape.put("Julio Perez", "@julio_vcf");
//		mape.put("Nekane Iserte", "@Nekaneiserte10");
//		mape.put("Pedro Berrocal", "@pedrorck16");
//		mape.put("Rafa Perez", "@rafetaonda");
//		mape.put("Fernando Villegas", "@fernando_RCK");
//		mape.put("Anna Romero", "@anna_romero9");
//		mape.put("Claudia Catalan", "@catalanclaudia9");
//		mape.put("Roger Mondragon", "@rogerrmc17");
//		mape.put("Sergio Castillo", "@Sergio35444057");
//		mape.put("Marta Fores", "@mforesinsa");
//		mape.put("Salva Cabedo", "@Cabedo_17");
//		mape.put("Claudia Moya", "@claudiamoya1999");
//		mape.put("Mireia Marti", "@Miireiaa20");
//		mape.put("Anna Marco", "@AnnaMarco01");
//		mape.put("Juan Vives", "@Juuan92");
//		mape.put("Cristina Blazquez", "@crisblazquez98");
//		mape.put("Yael Huget", "@yaelhm10");
//		mape.put("Cristina Gallego", "@crisgallego99");
//		mape.put("Alex Valero", "@Valero5_rck");
//		mape.put("Mousin", null);
//		mape.put("Reyes Peris", "@reyesnlx");
//		mape.put("Mark Garcia", "@mark_RCK"); //22
//		mape.put("Nacho Davila", "@NachettoXx");
//		mape.put("Susana Garcia", "@SusanaGarcia99");
//		mape.put("Carlos Cruz", "@CarlosRck");
//		mape.put("Juan Silvestre", "@Juansilvestree");
//		mape.put("Kike Garcia", "@Kikegarcia_7");
//		mape.put("Darlyn", "@DARLYN_RCK");
//		mape.put("Juanjo Herrero", "@juanjoo_rck");
//		mape.put("Josep Gomez", "@Pajo_9");
////		mape.put("Mar Leones", "@marleonesfolch");
//		mape.put("Emilo Feliu", "@emiliofeliu");
//		mape.put("Nacho Hernandez", "@_nachogym");
//		mape.put("Denis Valentin", "@Denis10Valentin");
//		mape.put("Alba Sorní", "@albaOnda");
//		mape.put("Aitana Julve", "@Aitanajulve");
//		mape.put("Anna Castillo", "@annacastillo99");
//		mape.put("Ainoa Martinez", "@Ainoaa_11");
//		mape.put("Elena Blanco", "@Elena_Nlx");
//		mape.put("Javi Garcia", "@javi_mas14");
//		mape.put("Carlos Alejandro", "@carlos051097"); //41
//		mape.put("Ruben Vizcaino", "@tito_vizcaino14");
//		mape.put("Vicente Varella", "@VicenVD");
//		mape.put("Alex Molina", "@Aleex_molinaa");
//		mape.put("Vicente Muñoz", "@Vicentemg97");//45
//		mape.put("Ivan Caparros", "@Ivancaparros21");
//		mape.put("Laura Ortiz", "@lau_dsn");
//		mape.put("Lluna Mir", "@llu_knx");
//		mape.put("Javier Vicent", "@javivicent97");
//		mape.put("Lluis Castañ", "@lluiscasfer");//50
//		mape.put("Clara Chiva", "@ClaraChiva");
//		mape.put("Paula Lucena", "@_paulalucena_");
//		mape.put("Claudia Gimeno", "@ClauSLP3");
//		mape.put("Jorge Ten", "@jorgeten10");
//		mape.put("Carmina Franch", "@carmina_est");//55
//		mape.put("Naxo Leon", "@naxo_rck");
//		mape.put("Ivan Reboll", "@rckivan");
//		mape.put("Eric Sansano", "@Eric_sansano8");
//		mape.put("David Gomez", "@96davidgomez");
//		mape.put("Roberto Martinez", "@RobertoRck");//60
//		mape.put("Eric Cervello", "@cerve_rck");
////		mape.put("Rocio Anaya", "@RociioAnaya12");
//		mape.put("Aida Fernandez", "@aiidafernandez");
//		mape.put("Juanjo Piquer", "@juanjopiquer21");
//		mape.put("Andrea Cruzado", "@andreacruzaado");//65
//		mape.put("Ana Castillo", "@Anacastiillo9");
//		mape.put("Andrea Benages", "@andreabenages");
//		mape.put("Carmen Mallen", "@Carmen_Mallen");
//		mape.put("Maria Ortells", "@Maria_Ortells17");
//		mape.put("Ines Gea", "@ineesgea");//70
//		mape.put("Iris Perez", "@iris_pv13");
//		mape.put("Paula Piquer", "@paula_piquer_");
//		mape.put("Lucia Romero", "@Lu_romero98");
//		mape.put("Adrian Guillamon", "@adri_guillamon");
//		mape.put("Lidia Soler", "@lidiasoler1");
//		mape.put("Sandra Muñoz", "@sandrita_est");
//		mape.put("Enric Borrás", "@EnricBR10");
//		mape.put("Alberto Lopez", "@LoperaRPK");
//		mape.put("Sara Martinez", "@sara_mt12");
//		mape.put("Aiman", "@aimanrbs17"); //80
//		mape.put("Elena Moya", "@elenyclau24");
//		mape.put("Esther Vicent", "@esthervicent");
//		mape.put("Aida Escudero", "@Aida878");
//		mape.put("Sonia Belmonte", "@sonia_slp");
//		mape.put("Laia Solsona", "@Laia_sg_99");//85
////		mape.put("Elena Blanco", "@Elena_Nlx");
//		mape.put("Jordi Ramos", "@jordiramos_rtsk");
//		mape.put("Roberto Lozar", "@robertolozar");
//		mape.put("David Alarcon", "@Dave_Alarcon");
//		mape.put("Eva Badenes", "@evabadenes05");
//		mape.put("Ruben Segura", "@rubensegura98");
//		mape.put("El Churro", null);
//		mape.put("Ester Jimenez", "@ester_nlx");
//		mape.put("Franciso Hurtado", "@hurtado9296");
//		mape.put("Sara Guirau", "@Sarag01_");
//		mape.put("Rafa Palanques", "@rafa_palanques");
//		mape.put("Pau Colonques", "@PauColonques");
//		mape.put("Elena Huertas", "@EleenaknxOnda");
//		mape.put("Javier Hurtado", "@hurtadazo5");
//		mape.put("Andrea Ruiz", "@andrearuizz15");
//		mape.put("Maria Esteller", "@mariaestellerf");
//		mape.put("Carlos Mas", "@carlos_rpk");
//		mape.put("Eva Martinez", "@evinlx99");
		

		mape.put("Julio Perez", "julio_vcf");
		mape.put("Nekane Iserte", null);
		mape.put("Pedro Berrocal", null);
//		mape.put("Rafa Perez", null);
//		mape.put("Fernando Villegas", "fernando_RCK");
//		mape.put("Anna Romero", "anna_romero9");
//		mape.put("Claudia Catalan", "catalanclaudia9");
		
		nombres = listaDeNombres(mape);
			
	}
	@Override
	public void run() {
//		try {
//			crearImagen(nombres);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
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
		String [] aux = asesinado(lista,n1-1);
		try {
			crearImagen(aux);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		String[]
		if (cont>2){	
			cont--;
			if(xt == null && yt == null){
				twitterServicio(x,y,cont);
				System.out.println(x + " ha matado a " + y + " quedan " + cont + " ondenses. #OndaWarBot");
			}
			else if(xt == null){
				twitterServicio(x,y,cont);
				System.out.println(x + " ha matado a " + y + " " + yt + " quedan " + cont + " ondenses. #OndaWarBot");
			}
			else if(yt == null){
				twitterServicio(x,y,cont);
				System.out.println(x + " " + xt + " ha matado a " + y + " quedan " + cont + " ondenses. #OndaWarBot");
			}
			else{ System.out.println(x + " " + xt + " ha matado a " + y + " " + yt + " quedan " + cont + " ondenses. #OndaWarBot");
			twitterServicio(x,y,cont);
				}
			}
		else{ 
			cont--;
			System.out.println(x + " " + xt +" ha matado a " + y + " " + yt +", " + x + " se los ha cargado a todos. #OndaWarBot");
		twitterServicio(x,y,cont);
		}
		
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
//		String consumerKey = "OXd5oPvVPhXqE1i856SZSeZ9R";
//		String consumerSecret = "XRT9sdX4Q35wNGDIwRSX5QrMcjPqrm5lUIS6jJvNeDKyAOAQ0g";
//		String accessToken = "1149316675877167104-ZIOKZAH7SZ361PVsGTMucFDh11xk9v";
//		String accessTokenSecret = "2kvJHQ2uwPFro5ZBlw1bu2J7UGJnpWSMkhogmbrYu2u6J";
		
		String consumerKey = "KdpN6MZxxQy1dKbQPOuruSfxT";
		String consumerSecret = "Zw2FfKtbZqzjIcWebiAG0rDPkXkczplpg7ojHUHifI7J3dnI68";
		String accessToken = "1151775525062479872-WrvedHQYmQIDlag9o9ZvjCqPTHtJG5";
		String accessTokenSecret = "Ux4PobRTXL5j7meKdEhaFElAVlzJN8KxZI1qreBA2u4wp";
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(consumerKey).setOAuthConsumerSecret(consumerSecret)
				.setOAuthAccessToken(accessToken).setOAuthAccessTokenSecret(accessTokenSecret);
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		String statusMessage;
		
		String xt = mape.get(asesino);
		if (xt==null)xt="";
		String yt = mape.get(asesinado);
		if (yt==null)yt="";
		
		try {
			if(conta > 1){
				File file = new File("C:/Users/Julio/workspace/github/Onda/Text.jpg");
				statusMessage = (asesino+ " " + xt +" ha matado a "+ asesinado + " " + yt + " quedan "+ conta + " ondenses. #OndaWarBot");
				StatusUpdate status = new StatusUpdate(statusMessage);
				status.setMedia(file);
				twitter.updateStatus(status);
			}
			else{
				File file = new File("C:/Users/Julio/workspace/github/Onda/win.png");
				statusMessage = (asesino+" "+ xt +" ha matado a "+asesinado + " "+ yt + ", se los ha cargado a todos. #OndaWarBot ");
				StatusUpdate status = new StatusUpdate(statusMessage);
				status.setMedia(file);
				twitter.updateStatus(status);
				
			} 
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
//		for (String clave: claves)
//			  System.out.println(clave);
		
		return claves;
		
	}
	
	public void crearImagen(String nombres[]) throws IOException{
		BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2d = img.createGraphics();
	    Font font = new Font("Arial", Font.BOLD, 12);
	   
	    g2d.setFont(font);
	    FontMetrics fm = g2d.getFontMetrics();
//	    int width = fm.stringWidth(text);
//	    int height = fm.getHeight();
	    if(nombres.length>=20){
	    int width = 555;
	    int height = 305;
	    g2d.dispose();

	    img = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
	    g2d = img.createGraphics();
	    g2d.setFont(font);
	    fm = g2d.getFontMetrics();
	    
	    g2d.setColor(Color.WHITE);
	    g2d.setBackground(Color.WHITE);
	    
	    
	    int i = 0;
	    for(int k=1; k<=20; k++){
	    	if(i==nombres.length)break;
	    	g2d.drawString(nombres[i],10, k*15);
	        i++;
	        
	        for(int l=1; l<5; l++){
	        	if(i==nombres.length)break;
	        	g2d.drawString(nombres[i], l*115, k*15);
	            i++;
	            
	        }
//	        g2d.fillRect(x, y, width, height);
	        ImageIO.write(img, "jpg", new File("Text.jpg"));
	    }
	}
	    else if (nombres.length > 12){
		    int width = 450;
		    int height = 150;
		    g2d.dispose();

		    img = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		    g2d = img.createGraphics();
		    g2d.setFont(font);
		    fm = g2d.getFontMetrics();
		    
		    g2d.setColor(Color.WHITE);
		    g2d.setBackground(Color.WHITE);
		    
		    
		    int i = 0;
		    for(int k=1; k<=5; k++){
		    	if(i==nombres.length)break;
		    	g2d.drawString(nombres[i],10, k*15);
		        i++;
		        
		        for(int l=1; l<4; l++){
		        	if(i==nombres.length)break;
		        	g2d.drawString(nombres[i], l*115, k*15);
		            i++;
		            
		        }
//		        g2d.fillRect(x, y, width, height);
		        ImageIO.write(img, "jpg", new File("Text.jpg"));
	    }
	}
	    else{
	    	 int width = 350;
			    int height = 150;
			    g2d.dispose();

			    img = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
			    g2d = img.createGraphics();
			    g2d.setFont(font);
			    fm = g2d.getFontMetrics();
			    
			    g2d.setColor(Color.WHITE);
			    g2d.setBackground(Color.WHITE);
			    
			    
			    int i = 0;
			    for(int k=1; k<=5; k++){
			    	if(i==nombres.length)break;
			    	g2d.drawString(nombres[i],10, k*15);
			        i++;
			        
			        for(int l=1; l<3; l++){
			        	if(i==nombres.length)break;
			        	g2d.drawString(nombres[i], l*115, k*15);
			            i++;
			            
			        }
//			        g2d.fillRect(x, y, width, height);
			        ImageIO.write(img, "jpg", new File("Text.jpg"));
		    }
	    	
	    }
	}
}