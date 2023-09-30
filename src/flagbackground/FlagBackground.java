package flagbackground;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FlagBackground {
	
	private static final int WIDTH = 1920;
	private static final int HEIGHT = 1080;
	private static final double SIZE = .4;
	private static final int[] COLORS = {0xe9e162, 0xf6eeeb, 0x956db3, 0x373332};
	
	public static void main(String[] args) {
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	    Graphics2D graphics = image.createGraphics();
	    double flagHeight = HEIGHT * SIZE;
	    int stripeHeight = (int) (flagHeight / COLORS.length);
	    int start = (int) ((HEIGHT - flagHeight) / 2);
	    for (int i = 0; i < COLORS.length; i++) {
	    	for (int x = 0; x < WIDTH; x++) {
	    		for (int y = 0; y < stripeHeight; y++) {
	    			image.setRGB(x, start + y, COLORS[i]);
	    		}
	    	}
	    	start += stripeHeight;
	    }
	    
	    try {
	    	File file = new File("tmp.png");
	    ImageIO.write(image, "png", file);
	    }catch (IOException e) { 
	       e.printStackTrace();
	    }
	}
}
