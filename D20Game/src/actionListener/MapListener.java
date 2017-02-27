package actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;

import characters.Cells;
import characters.Characters;
import characters.Entry;
import characters.Exit;
import characters.Ground;
import characters.Items;
import characters.Wall;
import map.Map;
import enumclass.TileType;
import load.LoadCharacter;
import load.LoadItem;

/**
 * Maplistener class implements actionlisener, 
 * when button on the map was clicked, then we call this class
 * @author grey
 * @version 1.0
 */
public class MapListener implements ActionListener{
	public Map map;
	Cells[][] newMap;
	JComboBox<String> itemBox;
	JComboBox<String> characterBox;
	String item ;
	String[] strings;
	Items items;
	Characters characters;
	ArrayList<Characters> characterArrayList;
	
	int x,y,numRows,numCols;
	/**
	 * map listener constructor method
	 * @param map 	the map object from the main frame
	 * @param itemBox	the item box object from the main frame
	 * @param characterBox	the character box object from the main frame
	 * @param characterArrayList 
	 */
	public MapListener(Map map, JComboBox<String> itemBox, JComboBox<String> characterBox, ArrayList<Characters> characterArrayList) {
		this.map = map;
		this.itemBox = itemBox;
		this.characterBox = characterBox;
		this.characterArrayList = characterArrayList;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();
//		System.out.println(itemBox.getSelectedItem().toString());
//		System.out.println(characterBox.getSelectedItem().toString());
		try {
			 //读取items
			 /* when the item box in the main frame was selected, 
			  * then we get corresponding item String from the file
			 */ 
			 item = new LoadItem().loadItem(itemBox.getSelectedItem().toString());
			 strings = item.split(" ");
			 items = new Items(strings[0], Integer.parseInt(strings[1]));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			//读取characters
			/* when the character box in the main frame was selected, 
			 * then we get corresponding character object from the file
			 */
			characters = new LoadCharacter().loadcharacter(characterBox.getSelectedItem().toString(),characterArrayList);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		jButton.addKeyListener(new KeyAdapter() {
			 /* when we press the number on the keyboard, 
			  * then change the corresponding button to new Cells object, and repaint the map
			  */
			public void keyPressed(KeyEvent e){
				if(e.getKeyCode()==KeyEvent.VK_0){
					 x = (int) jButton.getClientProperty("Rows");
					 y = (int) jButton.getClientProperty("Cols");
					newMap = map.getMap();
					numRows = newMap[0][0].getX();// the total rows of map
					numCols = newMap[0][0].getY();
//					newMap[x][y].setTileType(TileType.Ground);
					newMap[x][y] = new Cells(TileType.GROUND, numRows, numCols, new Ground(TileType.GROUND));
					map.setMap(newMap,numRows,numCols);
					map.drawMap(2);
					}
			else if(e.getKeyCode()==KeyEvent.VK_1){
				 x = (int) jButton.getClientProperty("Rows");
				 y = (int) jButton.getClientProperty("Cols");
				newMap = map.getMap();
				numRows = newMap[0][0].getX();
				numCols = newMap[0][0].getY();
//				newMap[x][y].setTileType(TileType.WALL);
				newMap[x][y] = new Cells(TileType.WALL, numRows, numCols, new Wall(TileType.WALL));
				map.setMap(newMap,numRows,numCols);
				map.drawMap(2);
				}
			else if(e.getKeyCode()==KeyEvent.VK_2)
			{
				 x = (int) jButton.getClientProperty("Rows");
				 y = (int) jButton.getClientProperty("Cols");
				newMap = map.getMap();
				numRows = newMap[0][0].getX();
				numCols = newMap[0][0].getY();
//				newMap[x][y].setTileType(TileType.CHEST);
				newMap[x][y] = new Cells(TileType.CHEST, numRows, numCols, items);
				map.setMap(newMap,numRows,numCols);
				map.drawMap(2);
			}
			else if(e.getKeyCode()==KeyEvent.VK_3)
			{
				 x = (int) jButton.getClientProperty("Rows");
				 y = (int) jButton.getClientProperty("Cols");
				newMap = map.getMap();
				numRows = newMap[0][0].getX();
				numCols = newMap[0][0].getY();
//				newMap[x][y].setTileType(TileType.HERO);
				newMap[x][y] = new Cells(TileType.HERO, numRows, numCols, characters);
				map.setMap(newMap,numRows,numCols);
				map.drawMap(2);
			}
			else if(e.getKeyCode()==KeyEvent.VK_4)
			{
				 x = (int) jButton.getClientProperty("Rows");
				 y = (int) jButton.getClientProperty("Cols");
				newMap = map.getMap();
				numRows = newMap[0][0].getX();
				numCols = newMap[0][0].getY();
//				newMap[x][y].setTileType(TileType.MONSTER);
				newMap[x][y] = new Cells(TileType.MONSTER, numRows, numCols, characters);
				map.setMap(newMap,numRows,numCols);
				map.drawMap(2);
			}
			else if(e.getKeyCode()==KeyEvent.VK_5)
			{
				 x = (int) jButton.getClientProperty("Rows");
				 y = (int) jButton.getClientProperty("Cols");
				newMap = map.getMap();
				numRows = newMap[0][0].getX();
				numCols = newMap[0][0].getY();
//				newMap[x][y].setTileType(TileType.EXIT);
				newMap[x][y] = new Cells(TileType.EXIT, numRows, numCols, new Exit(TileType.EXIT));
				map.setMap(newMap,numRows,numCols);
				map.drawMap(2);
			}
			else if(e.getKeyCode()==KeyEvent.VK_6)
			{
				 x = (int) jButton.getClientProperty("Rows");
				 y = (int) jButton.getClientProperty("Cols");
				newMap = map.getMap();
				numRows = newMap[0][0].getX();
				numCols = newMap[0][0].getY();
//				newMap[x][y].setTileType(TileType.ENTRY);
				newMap[x][y] = new Cells(TileType.ENTRY, numRows, numCols, new Entry(TileType.ENTRY));
				map.setMap(newMap,numRows,numCols);
				map.drawMap(2);
			}
			}
			});
	
	}

	
}


