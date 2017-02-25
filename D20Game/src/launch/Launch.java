package launch;


import map.Map;

/**
 * Main class to launch the program
 * New a Map object to initialize the frame
 * 
 * @author grey
 * @version 1.0
 *  
 */

public class Launch {
	public static void main(String[] args)  {
//		Game game = new Game("D20Game",1280,800);
//		game.start();
		
		new Map("D20Game",850,800);
	}

}
