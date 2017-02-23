package actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import characters.Cells;
import map.Map;
import enumclass.TileType;

public class MapListener implements ActionListener{
	public Map map;
//	int[][] newMap;
	Cells[][] newMap;
	
	int x,y,numRows,numCols;
	public MapListener(Map map) {
		this.map = map;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();
		jButton.addKeyListener(new KeyAdapter() {
			 
			public void keyPressed(KeyEvent e){
				if(e.getKeyCode()==KeyEvent.VK_0){
					 x = (int) jButton.getClientProperty("Rows");
					 y = (int) jButton.getClientProperty("Cols");
					newMap = map.getMap();
					numRows = newMap[0][0].getX();
					numCols = newMap[0][0].getY();
					newMap[x][y].setTileType(TileType.Ground);
					map.setMap(newMap,numRows,numCols);
					map.drawMap(2);
					}
			else if(e.getKeyCode()==KeyEvent.VK_1){
				 x = (int) jButton.getClientProperty("Rows");
				 y = (int) jButton.getClientProperty("Cols");
				newMap = map.getMap();
				numRows = newMap[0][0].getX();
				numCols = newMap[0][0].getY();
				newMap[x][y].setTileType(TileType.WALL);
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
				newMap[x][y].setTileType(TileType.CHEST);
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
				newMap[x][y].setTileType(TileType.HERO);
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
				newMap[x][y].setTileType(TileType.MONSTER);
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
				newMap[x][y].setTileType(TileType.EXIT);
				map.setMap(newMap,numRows,numCols);
				map.drawMap(2);
			}
			}
			});
	
	}

	
}


