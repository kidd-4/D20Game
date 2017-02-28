package characters;

import java.io.Serializable;

import enumclass.TileType;
/**
 * Wall class represents an wall object
 * @author grey
 *@version 1.0
 */
@SuppressWarnings("serial")
public class Wall implements Serializable{
	boolean through;
	TileType tileType;
	/**
	 * constructor method
	 * @param tileType tileType
	 */
	public Wall(TileType tileType){
		this.tileType = tileType;
		
	}
	/**
	 * 
	 * @return tileType
	 */
	public String getName(){
		return tileType.toString();
		
	}

}
