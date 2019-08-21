package KillerBot.Onda;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
	
	static Map<String, String> mape = new HashMap<String, String>(200); //HashMap donde vinculo cada nombre con su cuenta
	String[] nombres = new String[200]; //lista de los que estan vivos (nombres), muertos y formas de morir y lugares
	List<String> muertos = new ArrayList<String>();
	Date fecha = new Date();
	int hora;
	static String[] muertes = {" le ha metido una puñalada por la espalda", " le ha dado un cubata envenenado", " ha atropellado con el coche", 
						" ha matado con un palo", " le ha metido 20 navajazos en el pecho", " le ha dado una paliza", " le ha dado un botellazo en la cabeza", " ha asfixiado mientras dormía",
						" ha matado por exceso de sexo", " ha matado de un susto", " ha descuartizado y enterrado",
						" le ha reventado la cabeza con un bate", " le ha comido la cara", " ha matado de asco", " se ha comido",
						" ha hecho cosquillas hasta matar", " ha prendido fuego", " ha enterrado vivo", " ha arrancado la piel a tiras",
						" le ha metido un escopetazo", " sentía demasiada envidia y ha matado", " quería probar su nuevo revolver y ha disparado",
						" le ha metido una patada voladora", " le ha partido el cuello", " ha empalado",
						" le ha partido las piernas", " ha hecho un sacrificio a sus dioses quemando", " se ha tirado tal pedo que ha matado",
						" ha invitado a chupitos de Jaggermeister, y ha hecho que le de un coma etilico", " quería probar sus nuevos masclets y se los ha metido por el culo",
						" le ha puesto una bomba en el coche", " allahu akbar", " ha torturado hasta la muerte", " ha ahogado", " ha estrangulado",
						" ha matado con su belleza", " es tan feo que ha matado al mirar", " le ha perreado hasta morir", " ha asfixiado de un abrazo",
						" le ha metido una barra de fuet hasta la traquea", " le ha metido un flechazo en el ojo", " ha ayudado a ahorcarse",
						" ha asfixiado con su propio vomito", " ha dado de comer a sus perros despues de descuartizar", " le ha puesto la zancadilla",
						" ha ganado en un combate a muerte", " ha decapitado", " le ha clavado un tenedor en el ojo", " ha degollado como a un pollo",
						" ha matado con el mocho"};
	
	static String[] lugares = {" en el Mercadona"," en el Castillo", " debajo un punte", " en el museo del Taulell", " en el instituto",
						" en el Salvador", " en el calvario", " en los Carmelitas", " en la piazzeta", " en las 3 Culturas", " en su casa", " volviendo de Artesa",
						" en las fiestas de su pueblo", " en la Moreria", " en la Font de Dins", " en su casal", " durante Fira D'Onda", 
						" en el ecoparque", " por un ajuste de cuentas", " en la Panderola", " en la Plaza España", " en el encierro", " en su sotano",
						" mientras bebian juntos", " por hereje", " por capull@", " por borrach@", " en la plaza del pueblo", " por empanao", " por pesao"};
    

	public Tarea(){
		mape.put("Julio Perez", "@julio_vcf");
		mape.put("Nekane Iserte", "@Nekaneiserte10");
		mape.put("Pedro Berrocal", "@pedrorck16");
		mape.put("Rafa Perez", "@rafetaonda");
		mape.put("Fernando Villegas", "@fernando_RCK");
		mape.put("Raquel Rubio", "");
		mape.put("Claudia Catalan", "@catalanclaudia9");
		mape.put("Roger Mondragon", "@rogerrmc17");
		mape.put("Sergio Castillo", "@Sergio35444057");
		mape.put("Marta Fores", "@mforesinsa");
		mape.put("Salva Cabedo", "@Cabedo_17");
		mape.put("Claudia Moya", "@claudiamoya1999");
		mape.put("Mireia Marti", "@Miireiaa20");
		mape.put("Anna Marco", "@AnnaMarco01");
		mape.put("Juan Vives", "@Juuan92");
		mape.put("Cristina Blazquez", "@crisblazquez98");
		mape.put("Yael Huget", "@yaelhm10");
		mape.put("Cristina Gallego", "@crisgallego99");
		mape.put("Andrada Huzsa", "@andradahz");
		mape.put("Mousin", null);
		mape.put("Reyes Peris", "@reyesnlx");
		mape.put("Mark Garcia", "@mark_RCK"); //22
		mape.put("Nacho Davila", "@NachettoXx");
		mape.put("Susana Garcia", "@SusanaGarcia99");
		mape.put("Carlos Cruz", "@CarlosRck");
		mape.put("Raquel Rubio", "@racrubio14");
		mape.put("Camila Ortiz", "@CamilaCastano25");
		mape.put("Darlyn Jose", "@DARLYN_RCK");
		mape.put("Juanjo Herrero", "@juanjoo_rck");
		mape.put("Josep Gomez", "@Pajo_9");
		mape.put("Nuria Piquer", "@2299Nuria");
		mape.put("Emilo Feliu", "@emiliofeliu");
		mape.put("Nacho Hernandez", "@_nachogym");
		mape.put("Denis Valentin", "@Denis10Valentin");
		mape.put("Alba Sorní", "@albaOnda");
		mape.put("Aitana Julve", "@Aitanajulve");
		mape.put("Anna Castillo", "@annacastillo99");
		mape.put("Ainoa Martinez", "@Ainoaa_11");
		mape.put("Elena Blanco", "@Elena_Nlx");
		mape.put("Javi Garcia", "@javi_mas14");
		mape.put("Sara Chorda", "@SaraChorda_99"); //41
		mape.put("Jordi Muñoz", "@Marsaleta_");
		mape.put("Vicente Varella", "@VicenVD");
		mape.put("Alex Molina", "@Aleex_molinaa");
		mape.put("Vicente Muñoz", "@Vicentemg97");//45
		mape.put("Ivan Caparros", "@Ivancaparros21");
		mape.put("Laura Ortiz", "@lau_dsn");
		mape.put("Lluna Mir", "@llu_knx");
		mape.put("Javier Vicent", "@javivicent97");
		mape.put("Lluis Castañ", "@lluiscasfer");//50
		mape.put("Clara Chiva", "@ClaraChiva");
		mape.put("Paula Lucena", "@_paulalucena_");
		mape.put("Claudia Gimeno", "@ClauSLP3");
		mape.put("Jorge Ten", "@jorgeten10");
		mape.put("Carmina Franch", "@carmina_est");//55
		mape.put("Naxo Leon", "@naxo_rck");
		mape.put("Ivan Reboll", "@IvanReboll");
		mape.put("Eric Sansano", "@Eric_sansano8");
		mape.put("David Gomez", "@96davidgomez");
		mape.put("Roberto Martinez", "@RobertoRck");//60
		mape.put("Eric Cervello", "@cerve_rck");
		mape.put("Ximo Alós", "@AlosXimo");
		mape.put("Aida Fernandez", "@aiidafernandez");
		mape.put("Juanjo Piquer", "@juanjopiquer21");
		mape.put("Andrea Cruzado", "@andreacruzaado");//65
		mape.put("Yeray Boix", "@MrBoixCoix");
		mape.put("Andrea Benages", "@andreabenages");
		mape.put("Carmen Mallen", "@Carmen_Mallen");
		mape.put("Maria Ortells", "@Maria_Ortells17");
		mape.put("Ines Gea", "@ineesgea");//70
		mape.put("Iris Perez", "@iris_pv13");
		mape.put("Paula Piquer", "@paula_piquer_");
		mape.put("Lucia Romero", "@Lu_romero98");
		mape.put("Adrian Guillamon", "@adri_guillamon");
		mape.put("Lidia Soler", "@lidiasoler1");
		mape.put("Sandra Muñoz", "@sandrita_est");
		mape.put("Enric Borrás", "@EnricBR10");
		mape.put("Nuria Garcia", "@ngarciamas");
		mape.put("Sara Martinez", "@sara_mt12");
		mape.put("Aiman", "@aimanrbs17"); //80
		mape.put("Elena Moya", "@elenyclau24");
		mape.put("Esther Vicent", "@esthervicent");
		mape.put("Aida Escudero", "@Aida878");
		mape.put("Sonia Belmonte", "@sonia_slp");
		mape.put("Laia Solsona", "@Laia_sg_99");//85
		mape.put("Carlos Ruiz", "@Carlos_RM00");
		mape.put("M.Sánchez", "@__migueliko__");
		mape.put("Roberto Lozar", "@robertolozar");
		mape.put("David Alarcon", "@Dave_Alarcon");
		mape.put("Eva Badenes", "@evabadenes05");
		mape.put("Ruben Segura", "@rubensegura98");
		mape.put("El Churro", null);
		mape.put("Ester Jimenez", "@ester_nlx");
		mape.put("Franciso Hurtado", "@hurtado9296");
		mape.put("Sara Guirau", "@Sarag01_");
		mape.put("Rafa Palanques", "@rafa_palanques");
		mape.put("Pau Colonques", "@PauColonques");
		mape.put("Elena Huertas", "@EleenaknxOnda");
		mape.put("Javier Hurtado", "@hurtadazo5");
		mape.put("Andrea Ruiz", "@andrearuizz15");
		mape.put("Maria Esteller", "@mariaestellerf");
		mape.put("Carlos Mas", "@carlos_rpk");
		mape.put("Eva Martinez", "@evinlx99");
		mape.put("Raquel Mezquita", "@raquel_mezquita");
		mape.put("Juan Pa Ortiz", "@Juanpa_kls");
		mape.put("Maria Gallego","@maria_galleg0");
		mape.put("Panadero","@panaderoentask");
		mape.put("Esther Fernández","@estiwifdez");
		mape.put("Javi Olucha","@JaviOlucha");
		mape.put("Nuria Aguilella","@NuriaAguilella");
		mape.put("Paula Gallen","@paulagpoles99");
		mape.put("Patricia Albalat","@patrialbalat20");
		mape.put("Raúl Cruzado","@cruzadoaltk");
		mape.put("Beatriz Castillo", "@beatrixcastle");
		mape.put("Juan Melero", "@Melero_2000");
		mape.put("Lydia Vicent", "@lydiavicent_");
		mape.put("María Zapata", "@meery_zapata");
		mape.put("Belen Cabedo", "@snakkkkke");
		mape.put("Patricia Albalat", "@patrialbalat20");
		mape.put("Luis Castillo", "@Luis12Castillo");
		mape.put("Sara Usó", "@sarauso02");
		mape.put("Laura Castelló","@Laura15castello");
		mape.put("Jorge Chaume", "@JorgeChaume");
		mape.put("Paula Viñes", "@PaulaVC00");
		mape.put("Carmen Guillamon", "@Cg_carmen_00");
		mape.put("María Martinez", "@mariamartt01");
		mape.put("Mireia Cervello", "@mireiacerve08");
		mape.put("Gaizka Ojeda", "@gaizzka07");
		mape.put("Samuel Toledo", "@SamuToledo4");
		mape.put("Carla Asensio", "@alracoisnesa");
		mape.put("Pablo Martínez", "@Pablomb10_");
		mape.put("Merche Sanchez", "@merche_msm");
		mape.put("María Gil", "@Mariaruiizg_");
		mape.put("Iris Valero", "@iirisvm");
		mape.put("Rubén Castillo", "@Rubenikas99");
		mape.put("Angela Sebastián", "@Angela_12200");
		mape.put("Rubén Marco", "@rubenmarco_10");
		mape.put("Carla Feliu", "@carla_feliu");
		mape.put("Adrián Feliu", "@Adrian_Feliu");
		mape.put("Nacho Ribes", "@nachoribess");
		mape.put("Lucia Benages", "@luciabenages");
		mape.put("Victor García", "@garcia_victor00");
		mape.put("Rubén Marco", "@rubenmarco_10");
		mape.put("Jose Montiel", "@josma100");
		mape.put("Paloma Muñoz", "@paloma_munyoz");
		mape.put("Juan Silvestre", "@Juansilvestree");
		mape.put("Elián Contreras", "@elianco84460590");
		mape.put("Maria Fabregat", "@Maria_F200");
		mape.put("Ana Ibañez", "@AniitaI2001");
		mape.put("M. Angel Cruz", "@mixi_sfk");
		mape.put("Manu Garrido", "@Manusofok");
		mape.put("Marina Seco", "@MarinaSeco");
		mape.put("Sergio Juarez", "@SergioJuarez10");
		

//		mape.put("Juliio Perez", "julio_vcf");
//		mape.put("Nekkane Iserte", null);
//		mape.put("Pedrro Berrocal", null);
//		mape.put("Raffa Perez", null);
//		mape.put("Ferrnando Villegas", "fernando_RCK");
//		mape.put("Annna Romero", "anna_romero9");
//		mape.put("Clauudia Catalan", "catalanclaudia9");
		
//		muertos.add("Evaristo");
//		muertos.add("Matias");
//		muertos.add("Evaristo");
//		muertos.add("Evaisto");
//		muertos.add("Evaro");
//		muertos.add("Evarto");

		
		
		nombres = listaDeNombres(mape); //La lista nombres coge los nombres del Map
		
	}
	@Override
	public void run() {
		try {
			crearImagen(nombres);
		} catch (IOException e) {
			// TODO Auto-generated catch block					/*Con esto creo la primera imagen cuando voy a empezar*/
			e.printStackTrace();
		} 
//		hora = fecha.getHours();
//		if(hora==2||hora==3||hora==4||hora==5){
//			System.out.println("Estoy durmiendo porque son las " + hora);
//		}
//		else{
//			if(resucitar()==true){
//			if(muertos.isEmpty()){duelo(nombres);}
//				resurreccion(nombres, muertos);
//		} else{
//			duelo(nombres);
//		}		
//			if(nombres.length == 1) {		/*el metodo run ejecuta el metodo duelo hasta que solo queda un superviviente*/
//			cancel();
//			}
//		}

			System.out.println(nombres.length);
			cancel();
//		}
	
	} 
	
	public void duelo(String[] lista) { //Metodo principal que enfrente a la gente y llama al resto de metodos

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
		System.out.println("En 5 mins se van a enfrentar " + x + " vs " + y + " solo uno de los dos seguirá con vida. Suerte!");
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
			TimeUnit.MINUTES.sleep(5);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		String [] aux = asesinado(lista,n1-1);
		muertos.add(asesinado);
		nombres = aux;
		try {
			crearImagen(aux);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(cont>2){	
			cont--;
				
			System.out.println(asesino + " ha matado a " + asesinado + " quedan " + cont + " ondenses.");
			twitterServicio(asesino,asesinado,cont);
		}
		else{ 
			cont--;
			System.out.println(asesino + " " + xt +" ha matado a " + asesinado + " " + yt + " " + asesino + " se los ha cargado a todos. #OndaWarBot");
		twitterServicio(asesino,asesinado,cont);
		}
//		return asesinado(lista, n1-1);
		
	}
	
	public void resurreccion(String[] vivos, List<String> muert){ 	//Metodo que resucita a alguien
		String[] array = (String[]) muert.toArray(new String[muert.size()]); //convertimos el ArrayList muertos en array
		
		try {
			crearImagen(array);		//creamos la imagen con los muertos
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("En 5 minutos alguien va a resucitar de entre los muertos");
		twitterAvisoR();		//Avisa de que alguien va a resucitar
		try {
		TimeUnit.MINUTES.sleep(5);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		int n = (int) (Math.random() * muert.size());
		String resucitado = muert.get(n); 	//coge al elegido
		nombres = haResucitado(vivos,resucitado); 		//lo resucita y quita de la lista de muertos
		muertos.remove(resucitado);
//		try {
//			crearImagen(nombres);		//creamos la imagen con los muertos
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println(resucitado + " ha resucitado!");
	    twitterResucita(resucitado);		//lo anuncia en twitter
		
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
				File file = new File("C:/Users/Julio/workspace/github/Onda/Text1.jpg");
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
	
	public static void twitterAvisoR(){
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
				
		try {
			File file = new File("C:/Users/Julio/workspace/github/Onda/Text1.jpg");
			statusMessage = ("En 5 minutos va a resucitar alguien de entre los muertos!");
			StatusUpdate status = new StatusUpdate(statusMessage);
			status.setMedia(file);
			twitter.updateStatus(status);
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}
	
	public static void twitterResucita(String resucitado){
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
		String xt = mape.get(resucitado);	
		if (xt==null)xt="";
		try {
			File file = new File("C:/Users/Julio/workspace/github/Onda/Text1.jpg");
			statusMessage = (resucitado + " " + xt + " ha resucitado de entre los muertos!");
			StatusUpdate status = new StatusUpdate(statusMessage);
			status.setMedia(file);
			twitter.updateStatus(status);
//			twitter.updateStatus(resucitado + " " + xt + " ha resucitado de entre los muertos!");
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
	    if(nombres.length>100){
	    	int width = 685;
		    int height = 380;
		    g2d.dispose();

		    img = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		    g2d = img.createGraphics();
		    g2d.setFont(font);
		    fm = g2d.getFontMetrics();
		    
		    g2d.setColor(Color.WHITE);
		    g2d.setBackground(Color.WHITE);
		    
		    
		    int i = 0;
		    for(int k=1; k<=25; k++){
		    	if(i==nombres.length)break;
		    	g2d.drawString(nombres[i],5, k*15);
		        i++;
		        
		        for(int l=1; l<6; l++){
		        	if(i==nombres.length)break;
		        	g2d.drawString(nombres[i], l*115, k*15);
		            i++;
		        }
//		        g2d.fillRect(x, y, width, height);
		        ImageIO.write(img, "jpg", new File("Text1.jpg"));
		    }
	    } 
	    else if(nombres.length>=20){
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
	    	g2d.drawString(nombres[i],5, k*15);
	        i++;
	        
	        for(int l=1; l<5; l++){
	        	if(i==nombres.length)break;
	        	g2d.drawString(nombres[i], l*115, k*15);
	            i++;
	            
	        }
//	        g2d.fillRect(x, y, width, height);
	        ImageIO.write(img, "jpg", new File("Text1.jpg"));
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
		    	g2d.drawString(nombres[i],5, k*15);
		        i++;
		        
		        for(int l=1; l<4; l++){
		        	if(i==nombres.length)break;
		        	g2d.drawString(nombres[i], l*115, k*15);
		            i++;
		            
		        }
//		        g2d.fillRect(x, y, width, height);
		        ImageIO.write(img, "jpg", new File("Text1.jpg"));
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
			    	g2d.drawString(nombres[i],5, k*15);
			        i++;
			        
			        for(int l=1; l<3; l++){
			        	if(i==nombres.length)break;
			        	g2d.drawString(nombres[i], l*115, k*15);
			            i++;
			            
			        }
//			        g2d.fillRect(x, y, width, height);
			        ImageIO.write(img, "jpg", new File("Text1.jpg"));
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
	   if (Math.random() <= 0.2) {//3% de probabilidad de que alguien resucite
	     resucita = true; 
	   }
	   else {    
	     resucita = false; 
	   }
	   return resucita;
	 }
	 
	 public static String[] haResucitado(String[] lista, String muerto){ //metodo que genera los nombres a partir del Map
//		 String[] aux  = new String[200];
//		for(int i = 0; i<muertos.length; i++){
//			aux[i]=muertos[i];
//		}
//		aux[muertos.length] = muerto;
////		Arrays.sort(aux);
//		return aux;
		 
		 ArrayList<String> myList = new ArrayList<String>(Arrays.asList(lista));
		 myList.add(muerto);
		 lista = myList.toArray(lista);
		 Arrays.sort(lista);
		 return lista;
		}
}