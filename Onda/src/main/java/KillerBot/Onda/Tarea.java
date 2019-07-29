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
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Tarea extends TimerTask{
	public BufferedImage image;
	
	static Map<String, String> mape = new HashMap<String, String>(100); //HashMap donde vinculo cada nombre con su cuenta
	String[] nombres = new String[200]; //lista de los que estan vivos (nombres), muertos y formas de morir y lugares
	String[] muertos = new String[200];
	static String[] muertes = {"  ha matado de una apuñalada por la espalda", " ha matado con un cubata envenenado", " ha atropellado con el coche", 
						" ha matado con un palo", " le ha metido 20 navajazos", " le ha dado una paliza", " le ha dado un botellazo en la cabeza", " mientras dormía",
						" ha matado por exceso de sexo", " ha matado de un susto", " le ha desmembrado las extremidades",
						" le ha reventado la cabeza con un bate", " le ha comido el cuello", " le ha matado de asco", " se ha comido",
						" le ha hecho cosquillas hasta morir", " ha prendido fuego", " ha enterrado vivo"};
	static String[] lugares = {" en el Mercadona"," en el Castillo", " debajo un punte", " en el museo del Taulell", " en el instituto",
						" en el Salvador", " en el calvario", " en los Carmelitas", " en la piazzeta", " en las 3 Culturas", " en su casa"};
    
	
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
		mape.put("Rafa Perez", null);
		mape.put("Fernando Villegas", "fernando_RCK");
		mape.put("Anna Romero", "anna_romero9");
		mape.put("Claudia Catalan", "catalanclaudia9");
		
		nombres = listaDeNombres(mape); //La lista nombres coge los nombres del Map

	}
	@Override
	public void run() {
//		try {
//			crearImagen(nombres);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block					/*Con esto creo la primera imagen cuando voy a empezar*/
//			e.printStackTrace();
//		} 
		nombres = duelo(nombres);
		if(nombres.length == 1) {		/*el metodo run ejecuta el metodo duelo hasta que solo queda un superviviente*/
			cancel();
		}
//		int contV =0; 
//		int contF = 0;
//		for(int i=0;i<200;i++){
//			
//			if(resucitar() == true)contV++;
//			else contF++;
//			
//		}
//		System.out.println(contV);
//		System.out.println(contF);
//		cancel();
		
	} 
	
	public String[] duelo(String[] lista) { //Metodo principal que enfrente a la gente y llama al resto de metodos
		int n = (int) (Math.random() * lista.length) + 1;
		int n1 = (int) (Math.random() * lista.length) + 1;
		int m = (int) (Math.random() * muertes.length) + 1;			/*se elige a los dos oponentes y la forma de morir y lugar*/
		int l = (int) (Math.random() * lugares.length) + 1;
		int cont = lista.length;
		String x = lista[n-1];
		String asesino, xt;			/*Con la mejora de que avise 5 mins antes ahora x no siempre es el asesino*/
		String asesinado, yt;
		
		String y = lista[n1 - 1];
		while (n == n1) {
			n1 = (int) (Math.random() * lista.length) + 1;
			y = lista[n1 - 1];
		}
		twitterAviso(x,y);
		xt = mape.get(x);
		yt = mape.get(y);
		System.out.println("En 5 mins se van a enfrentar " + x + " " + xt + " vs " + y + " " + yt + " solo uno de los dos seguirá con vida. Suerte!");
		if(headsOrTails()== true){
			asesino = x;
			asesinado = y;
			xt= mape.get(asesino);
			yt= mape.get(asesinado);
		}
		else{
			asesino = y;
			asesinado = x;
			n1 = n;
			yt= mape.get(asesino);
			xt= mape.get(asesinado);
		}
		if(xt == null) xt="";
		if(yt == null) yt="";
		
		
		try {
			TimeUnit.MINUTES.sleep(1);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		String muerte = muertes[m-1];
		String lugar = lugares[l-1];
		String [] aux = asesinado(lista,n1-1);
		try {
			crearImagen(aux);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(cont>2){	
			cont--;
			
			
			System.out.println(asesino + " " + xt + " ha matado a " + asesinado + " " + yt + muerte + lugar + " quedan " + cont + " ondenses. #OndaWarBot");
			twitterServicio(asesino,asesinado,cont);
		}
		else{ 
			cont--;
			System.out.println(asesino + " " + xt +" ha matado a " + asesinado + " " + yt + muerte + lugar + ", " + x + " se los ha cargado a todos. #OndaWarBot");
		twitterServicio(asesino,asesinado,cont);
		}
		
		return asesinado(lista, n1-1);
		
	}

	public static String[] asesinado(String[] arr, int index) { //Metodo que elimina al asesinado de la lista 

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
//	public static String[] resucitado(String[] lista, String[] muertos){
//		String[] aux = new String[lista.length-1];							/*el metodo de resucitar esta por desarrollar*/
//		return aux;
//	}
  
	public static void twitterServicio(String asesino, String asesinado,int conta){ //metodo que usa twitter para pubicar quien muere
//		String consumerKey = "OXd5oPvVPhXqE1i856SZSeZ9R";
//		String consumerSecret = "XRT9sdX4Q35wNGDIwRSX5QrMcjPqrm5lUIS6jJvNeDKyAOAQ0g";
//		String accessToken = "1149316675877167104-ZIOKZAH7SZ361PVsGTMucFDh11xk9v";		/*Acceso a la cuenta principal*/
//		String accessTokenSecret = "2kvJHQ2uwPFro5ZBlw1bu2J7UGJnpWSMkhogmbrYu2u6J";
		
		String consumerKey = "KdpN6MZxxQy1dKbQPOuruSfxT";
		String consumerSecret = "Zw2FfKtbZqzjIcWebiAG0rDPkXkczplpg7ojHUHifI7J3dnI68";
		String accessToken = "1151775525062479872-WrvedHQYmQIDlag9o9ZvjCqPTHtJG5";		/*Acceso a la cuenta de pruebas*/
		String accessTokenSecret = "Ux4PobRTXL5j7meKdEhaFElAVlzJN8KxZI1qreBA2u4wp";
		
		int m = (int) (Math.random() * muertes.length) + 1;			/*se elige a los dos oponentes y la forma de morir y lugar*/
		int l = (int) (Math.random() * lugares.length) + 1;
		String muerte = muertes[m-1];
		String lugar = lugares[l-1];
		
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
				statusMessage = (asesino + " " + xt + muerte + " a " + asesinado + " " + yt + lugar + ", quedan " + conta + " ondenses. #OndaWarBot");
				StatusUpdate status = new StatusUpdate(statusMessage);
				status.setMedia(file);
				twitter.updateStatus(status);
			}
			else{
				File file = new File("C:/Users/Julio/workspace/github/Onda/win.png");
				statusMessage = (asesino + " " + xt + muerte + " a " + asesinado + " " + yt + lugar + ", se los ha cargado a todos. #OndaWarBot ");
				StatusUpdate status = new StatusUpdate(statusMessage);
				status.setMedia(file);
				twitter.updateStatus(status);
				
			} 
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}
	
	public static void twitterAviso(String asesino, String asesinado){
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
				
		String xt = mape.get(asesino);
		if (xt==null)xt="";
		String yt = mape.get(asesinado);
		if (yt==null)yt="";
		
		try {
			twitter.updateStatus("En 5 mins se van a enfrentar " + asesino + " " + xt + " vs " + asesinado + " " + yt + " solo uno de los dos seguirá con vida. Suerte!");
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}
	

	
	public static String[] listaDeNombres(Map<String,String> lista){ //metodo que genera los nombres a partir del Map
		String[] claves = lista.keySet().toArray(new String[0]);
		Arrays.sort(claves);
	
		return claves;
	}
	
	public void crearImagen(String nombres[]) throws IOException{ //metodo que crea la imagen de la gente que queda viva
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
	
	 public static boolean headsOrTails() //metodo cara o cruz que elige si muere x o y
	 {
	   boolean coinState;
	   if (Math.random() <= 0.5) {//heads 50% of the time 
	     coinState = true; //heads
	   }
	   else {    
	     coinState = false; //tails
	   }
	   return coinState;
	 }
	 
	 public static boolean resucitar() //metodo que dice si alguien va a resucitar en esta hora
	 {
	   boolean resucita;
	   if (Math.random() <= 0.03) {//3% de probabilidad de que alguien resucite
	     resucita = true; 
	   }
	   else {    
	     resucita = false; 
	   }
	   return resucita;
	 }
}