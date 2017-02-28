package map;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 *  get the image from
 * @author grey
 *@version 1.0
 */
public class Image {
	public static BufferedImage loadImage(String path){
		
		try {
			return ImageIO.read(Image.class.getResource(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
	
	
}
