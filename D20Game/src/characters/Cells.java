package characters;

import enumclass.TileType;

public class Cells {
	
	TileType tileType;
	int x, y;//the total length of x and y
	boolean isVisited;
	Characters characters;
	Entry entry;
	Exit exit;
	Ground ground;
	Items items;
	Wall wall;
	
	

	public Cells(TileType tileType,int x, int y,Wall wall){
		this.tileType = tileType;
		this.x = x;
		this.y = y;
		this.wall = wall;
	}
	
	public Cells(TileType tileType,int x, int y,Entry entry){
		this.tileType = tileType;
		this.x = x;
		this.y = y;
		this.entry = entry;
	}
	public Cells(TileType tileType,int x, int y,Exit exit){
		this.tileType = tileType;
		this.x = x;
		this.y = y;
		this.exit = exit;
	}
	public Cells(TileType tileType,int x, int y,Ground ground){
		this.tileType = tileType;
		this.x = x;
		this.y = y;
		this.ground = ground;
		}
	public Cells(TileType tileType,int x, int y,Items items){
		this.tileType = tileType;
		this.x = x;
		this.y = y;
		this.items = items;
	}

	public Cells(TileType tileType,int x, int y,Characters characters){
		this.tileType = tileType;
		this.x = x;
		this.y = y;
		this.characters = characters;
	}
	
	
	
	public Characters getCharacters() {
		return characters;
	}

	public Entry getEntry() {
		return entry;
	}

	public Exit getExit() {
		return exit;
	}

	public Ground getGround() {
		return ground;
	}

	public Items getItems() {
		return items;
	}

	public Wall getWall() {
		return wall;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public TileType getTileType(){
		return tileType;
	}
	
	public void setTileType(TileType tileType){
		this.tileType = tileType;
	}
	
	
	

}
