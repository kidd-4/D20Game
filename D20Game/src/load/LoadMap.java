package load;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import characters.Cells;
import characters.Characters;
import characters.Entry;
import characters.Exit;
import characters.Ground;
import characters.Items;
import characters.Wall;
import enumclass.TileType;
import map.Map;

public class LoadMap {
	Cells[][] cells;
	//在读取地图时调用，根据输入的名字，加载不同的地图
	public Cells[][] loadMap(Map map, String string3) throws IOException{
		String filePath = "/Users/grey/Desktop/Test/Maps.txt";//different maps
		BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
		
		String string = null;
		String string2 = null;
		int i=0;
		while((string2 = bufferedReader.readLine())!=null){
			//读取文件第一行，判断是否有对应的地图名称
			String[] strings2 = string2.split(" ");
			if(strings2[0].equals(string3))
			{	//如果有，则读取整个地图
				int rows = Integer.parseInt(strings2[1]);
				int cols = Integer.parseInt(strings2[2]);
				cells = new Cells[rows][cols];
				while((string = bufferedReader.readLine())!=null){
					//读取整个地图，直到下一个地图
					String[] strings = string.split(" ");
					if(strings[0].startsWith("M")||strings[0].startsWith("m"))
						break;
					for(int j=0;j<cols;j++)
					{
						//判断每一列的每一个数据，创建新的对象，赋给地图对应的Cells
						if(strings[j].equals("WALL"))
							cells[i][j] = new Cells(TileType.valueOf(strings[j]), rows,cols,new Wall(TileType.WALL));
						else if(strings[j].equals("GROUND"))
							cells[i][j] = new Cells(TileType.valueOf(strings[j]), rows,cols,new Ground(TileType.GROUND));
						else if(strings[j].equals("ENTRY"))
							cells[i][j] = new Cells(TileType.valueOf(strings[j]), rows,cols,new Entry(TileType.ENTRY));
						else if(strings[j].equals("EXIT"))
							cells[i][j] = new Cells(TileType.valueOf(strings[j]), rows,cols,new Exit(TileType.EXIT));
						else if(strings[j].startsWith("W")||strings[j].startsWith("w")||strings[j].startsWith("S")||strings[j].startsWith("s")||
								strings[j].startsWith("A")||strings[j].startsWith("a")||strings[j].startsWith("H")||strings[j].startsWith("h")||
								strings[j].startsWith("R")||strings[j].startsWith("r")||strings[j].startsWith("BOOT")||strings[j].startsWith("boot")||
								strings[j].startsWith("BELT")||strings[j].startsWith("belt"))
						{
							String newString = new LoadItem().loadItem(strings[j]);
							String[] strings3 =newString.split(" ");
							String name = strings3[0];
							String value = strings3[1];
							Items items = new Items(name, Integer.parseInt(value));
							cells[i][j] = new Cells(TileType.CHEST, rows,cols,items);
						}
						else if(strings[j].startsWith("M")||strings[j].startsWith("m")){
							Characters characters = new LoadCharacter().loadcharacter(strings[j]);
							cells[i][j] = new Cells(TileType.MONSTER, rows,cols,characters);
						}
						else {
							Characters characters = new LoadCharacter().loadcharacter(strings[j]);
							cells[i][j] = new Cells(TileType.HERO, rows,cols,characters);
						}
					}
						i++;//while loop, i represents rows.
				}
			}
		}
		//读取地图的行和列
//		String string2 = bufferedReader.readLine();
//		String[] strings2 = string2.split(" ");
//		int rows = Integer.parseInt(strings2[0]);
//		int cols = Integer.parseInt(strings2[1]);
//		cells = new Cells[rows][cols];
//		int i=0;
//		System.out.println("rows "+rows+" cols"+cols);
		//读取地图的每一行
//		while((string = bufferedReader.readLine())!=null)
//		{
//			
//			String[] strings = string.split(" ");
//			
//			for(int j=0;j<cols;j++)
//			{
//				//判断每一列的每一个数据，创建新的对象，赋给地图对应的Cells
//				if(strings[j].equals("WALL"))
//					cells[i][j] = new Cells(TileType.valueOf(strings[j]), rows,cols,new Wall(TileType.WALL));
//				else if(strings[j].equals("GROUND"))
//					cells[i][j] = new Cells(TileType.valueOf(strings[j]), rows,cols,new Ground(TileType.GROUND));
//				else if(strings[j].equals("ENTRY"))
//					cells[i][j] = new Cells(TileType.valueOf(strings[j]), rows,cols,new Entry(TileType.ENTRY));
//				else if(strings[j].equals("EXIT"))
//					cells[i][j] = new Cells(TileType.valueOf(strings[j]), rows,cols,new Exit(TileType.EXIT));
//				else if(strings[j].startsWith("W")||strings[j].startsWith("w")||strings[j].startsWith("S")||strings[j].startsWith("s")||
//						strings[j].startsWith("A")||strings[j].startsWith("a")||strings[j].startsWith("H")||strings[j].startsWith("h")||
//						strings[j].startsWith("R")||strings[j].startsWith("r")||strings[j].startsWith("BOOT")||strings[j].startsWith("boot")||
//						strings[j].startsWith("BELT")||strings[j].startsWith("belt"))
//				{
//					String newString = new LoadItem().loadItem(strings[j]);
//					String[] strings3 =newString.split(" ");
//					String name = strings3[0];
//					String value = strings3[1];
//					Items items = new Items(name, Integer.parseInt(value));
//					cells[i][j] = new Cells(TileType.CHEST, rows,cols,items);
//				}
//				else if(strings[j].startsWith("M")||strings[j].startsWith("m")){
//					Characters characters = new LoadCharacter().loadcharacter(strings[j]);
//					cells[i][j] = new Cells(TileType.MONSTER, rows,cols,characters);
//				}
//				else {
//					Characters characters = new LoadCharacter().loadcharacter(strings[j]);
//					cells[i][j] = new Cells(TileType.HERO, rows,cols,characters);
//				}
//			}
//				i++;//while loop, i represents rows.
//		}
		
		
//		for(int i=0;i<rows;i++)
//			for(int j=0;j<cols;j++)
//				System.out.println(cells[i][j].getTileType());
		
		bufferedReader.close();
		return cells;
		
		
	}



}
