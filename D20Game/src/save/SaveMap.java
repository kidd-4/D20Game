package save;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import characters.Cells;
import enumclass.TileType;

public class SaveMap {
	
	
	// 在保存地图时调用，将创建好的Cells二位数组保存在mapName文件中
	public void saveMap(Cells[][] cells, int rows,int cols,String mapName) throws IOException{
		String filePath = "/Users/grey/Desktop/Test/Map/"+mapName+".txt"; //save different maps
		BufferedWriter bufferedWriter  = new BufferedWriter(new FileWriter(filePath));
		
		bufferedWriter.write(rows + " "+ cols);
		bufferedWriter.newLine();
	
	for(int i=0;i<rows;i++)
	{
		for(int j=0;j<cols;j++)
		{	//根据不同的类型，保存不同的名字，用来区分不同的对象，也便于加载地图时读取不同的对象
			if(cells[i][j].getTileType() == TileType.HERO || cells[i][j].getTileType() == TileType.MONSTER)
				bufferedWriter.write(cells[i][j].getCharacters().getName()+" ");
			else if (cells[i][j].getTileType() == TileType.CHEST)
				bufferedWriter.write(cells[i][j].getItems().getName()+" ");
			else 
				bufferedWriter.write(cells[i][j].getTileType().toString()+" ");
			
		}
		bufferedWriter.newLine();
		bufferedWriter.flush();
	}
	bufferedWriter.close();
		
	}

}
