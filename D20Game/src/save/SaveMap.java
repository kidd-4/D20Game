package save;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import characters.Matrix;
/**
 * SaveMap class is used to save the maps to the file
 * @author grey
 *	@version 1.0
 */
public class SaveMap {
	/**
	 * save method
	 * @param allMaps  ArrayList<Matrix>
	 * @throws IOException
	 */
	// 在保存地图时调用，将创建好的Cells二位数组保存在mapName文件中
	public void saveMap(ArrayList<Matrix> allMaps) throws IOException{
		
		File output = new File("/Users/grey/Desktop/Test/Maps.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(output));
        objectOutputStream.writeObject(allMaps);
        objectOutputStream.flush();
        objectOutputStream.close();
		
		
//		String filePath = "/Users/grey/Desktop/Test/Maps.txt"; //save different maps
//		BufferedWriter bufferedWriter  = new BufferedWriter(new FileWriter(filePath,true));
//		
//		bufferedWriter.write(matrix.getName()+" ");
//		bufferedWriter.write(matrix.getMap()[0][0].getX()  + " "+ matrix.getMap()[0][0].getY());
//		bufferedWriter.newLine();
//	
//	for(int i=0;i<matrix.getMap()[0][0].getX();i++)
//	{
//		for(int j=0;j<matrix.getMap()[0][0].getY();j++)
//		{	//根据不同的类型，保存不同的名字，用来区分不同的对象，也便于加载地图时读取不同的对象
//			if(matrix.getMap()[i][j].getTileType() == TileType.HERO || matrix.getMap()[i][j].getTileType() == TileType.MONSTER)
//				bufferedWriter.write(matrix.getMap()[i][j].getCharacters().getName()+" ");
//			else if (matrix.getMap()[i][j].getTileType() == TileType.CHEST)
//				bufferedWriter.write(matrix.getMap()[i][j].getItems().getName()+" ");
//			else 
//				bufferedWriter.write(matrix.getMap()[i][j].getTileType().toString()+" ");
//			
//		}
//		bufferedWriter.newLine();
//		bufferedWriter.flush();
//	}
//	bufferedWriter.close();
//		
	}

}
