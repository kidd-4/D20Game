package characters;

import enumclass.TileType;

public class Ground {
	boolean through;
	TileType tileType;
	
	public Ground(TileType tileType){
		this.tileType = tileType;
		
	}
	
	public String getName(){
		return tileType.toString();
		
	}

}
