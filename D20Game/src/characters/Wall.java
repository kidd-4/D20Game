package characters;

import java.io.Serializable;

import enumclass.TileType;

@SuppressWarnings("serial")
public class Wall implements Serializable{
	boolean through;
	TileType tileType;
	
	public Wall(TileType tileType){
		this.tileType = tileType;
		
	}
	
	public String getName(){
		return tileType.toString();
		
	}

}
