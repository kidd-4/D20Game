package characters;

import java.io.Serializable;

import enumclass.TileType;

@SuppressWarnings("serial")
public class Ground implements Serializable{
	boolean through;
	TileType tileType;
	
	public Ground(TileType tileType){
		this.tileType = tileType;
		
	}
	
	public String getName(){
		return tileType.toString();
		
	}

}
