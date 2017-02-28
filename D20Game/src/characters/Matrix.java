package characters;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Matrix implements Serializable{
	
	Cells[][] map ;
	String name;
	
	public Matrix(Cells[][] map,String name){
		this.map = map;
		this.name = name;
	}

	public Cells[][] getMap() {
		return map;
	}

	public void setMap(Cells[][] map) {
		this.map = map;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
