package characters;

import enumclass.TileType;

public class Cells {
	
	TileType tileType;
	int xCoord, yCoord;
	boolean isVisited;
	
	public Cells(TileType tileType){
		this.tileType = tileType;
	}
	
	public TileType getTileType(){
		return tileType;
	}
	
	public void setTileType(TileType tileType){
		this.tileType = tileType;
	}
	
	
	

}
