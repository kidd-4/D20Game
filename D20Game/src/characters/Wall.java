package characters;

import enumclass.TileType;

public class Wall {
	boolean through;
	TileType tileType;
	
	public Wall(TileType tileType){
		this.tileType = tileType;
		
	}
	
	public String getName(){
		return tileType.toString();
		
	}

}
