package characters;

import enumclass.TileType;

public class Entry {
	boolean pass;
	TileType tileType;
	
	public Entry(TileType tileType){
		this.tileType = tileType;
	}
	
	public String getName(){
		return tileType.toString();
		
	}

}
