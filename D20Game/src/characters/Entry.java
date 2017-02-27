package characters;

import java.io.Serializable;

import enumclass.TileType;

@SuppressWarnings("serial")
public class Entry implements Serializable{
	boolean pass;
	TileType tileType;
	
	public Entry(TileType tileType){
		this.tileType = tileType;
	}
	
	public String getName(){
		return tileType.toString();
		
	}

}
