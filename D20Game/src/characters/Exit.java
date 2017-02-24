package characters;

import enumclass.TileType;

public class Exit {
	boolean pass;
	TileType tileType;
	
	public Exit(TileType tileType){
		this.tileType = tileType;
	}
	
	public String getName(){
		return tileType.toString();
		
	}
}
