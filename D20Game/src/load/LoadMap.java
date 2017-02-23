package load;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import characters.Cells;
import enumclass.TileType;
import map.Map;

public class LoadMap {
	Cells[][] cells;
	
	public Cells[][] loadMap(Map map, String string3) throws IOException{
		String filePath = "/Users/grey/Desktop/Test/Map/"+string3+".txt";//different maps
		BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
		
		String string = null;
		
		String string2 = bufferedReader.readLine();
		String[] strings2 = string2.split(" ");
		int rows = Integer.parseInt(strings2[0]);
		int cols = Integer.parseInt(strings2[1]);
		cells = new Cells[rows][cols];
		int i=0;
//		System.out.println("rows "+rows+" cols"+cols);
		
		while((string = bufferedReader.readLine())!=null)
		{
			String[] strings = string.split(" ");
			
				for(int j=0;j<cols;j++)
					cells[i][j] = new Cells(TileType.valueOf(strings[j]), rows,cols );
				i++;//while loop
		}
		
		
//		for(int i=0;i<rows;i++)
//			for(int j=0;j<cols;j++)
//				System.out.println(cells[i][j].getTileType());
		
		bufferedReader.close();
		return cells;
		
		
	}



}
