package characters;

import java.io.Serializable;

import enumclass.TileType;

@SuppressWarnings("serial")
public class Exit implements Serializable{
	boolean pass;
	TileType tileType;
	
	public Exit(TileType tileType){
		this.tileType = tileType;
	}
	
	public String getName(){
		return tileType.toString();
		
	}
}
