import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
/*from  w ww  . j a v  a 2s.c  o m*/
import javax.imageio.ImageIO;

public class Clase1 {
  public static void main(String[] args) throws Exception {
	  String[] nombres = {"Julio","Nacho","Fernando","Roni","Mark","Darlyn",
				"Carlos","Oscar","Naxo","Cervello","Pedro","Ivan","Juanjo","Perolo","Sarasa",
				"David","Lluis","Contreras","Rober","Ismael"};
	  String text = "";

//	  String text = "java2s.com";
	  for(String s : nombres ){
		  text += s + "\n" + "  ";
	  }
	  
	  
//	  String text = nombres.toString();

    BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = img.createGraphics();
    Font font = new Font("Arial", Font.PLAIN, 12);
    g2d.setFont(font);
    FontMetrics fm = g2d.getFontMetrics();
//    int width = fm.stringWidth(text);
//    int height = fm.getHeight();
    int width = nombres.length *10;
    int height = nombres.length *10;
    g2d.dispose();

    img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    g2d = img.createGraphics();
//    g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
//        RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
//    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
//        RenderingHints.VALUE_ANTIALIAS_ON);
//    g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING,
//        RenderingHints.VALUE_COLOR_RENDER_QUALITY);
//    g2d.setRenderingHint(RenderingHints.KEY_DITHERING,
//        RenderingHints.VALUE_DITHER_ENABLE);
//    g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS,
//        RenderingHints.VALUE_FRACTIONALMETRICS_ON);
//    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
//        RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//    g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
//        RenderingHints.VALUE_RENDER_QUALITY);
//    g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,
//        RenderingHints.VALUE_STROKE_PURE);
    g2d.setFont(font);
    fm = g2d.getFontMetrics();
    g2d.setColor(Color.BLACK);
//    g2d.drawString(text, 0, fm.getAscent());
//    for(int i=0; i<nombres.length; i++){
//    	for(int j=0; j<2; j++)
//    g2d.drawString(nombres[i], 0, i*10);
//    g2d.drawString(" una dos y tres palabras-2", 200, 200);
//    g2d.dispose();
//    }
    
    for(int k=0; k<nombres.length/2; k+=2){
        g2d.drawString(nombres[k], 0, k*10);
    }
    for(int l=1; l<nombres.length/2; l+=2){
        g2d.drawString(nombres[l], 100, l*10);
    }
    
    ImageIO.write(img, "png", new File("Text.png"));

  }

}