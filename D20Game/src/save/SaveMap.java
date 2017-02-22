package save;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import characters.Cells;

public class SaveMap {
	
	
	
	public void saveMap(Cells[][] cells, int rows,int cols,int count) throws IOException{
		String filePath = "/Users/grey/Desktop/Test/Map/Map"+count+".txt"; //save different maps
		BufferedWriter bufferedWriter  = new BufferedWriter(new FileWriter(filePath));
		
		bufferedWriter.write(rows + " "+ cols);
		bufferedWriter.newLine();
	
	for(int i=0;i<rows;i++)
	{
		for(int j=0;j<cols;j++)
		{
			bufferedWriter.write(cells[i][j].getTileType().toString()+" ");
		}
		bufferedWriter.newLine();
		bufferedWriter.flush();
	}
	bufferedWriter.close();
		
	}

}
