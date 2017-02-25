package map;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import actionListener.MapListener;
import characters.Cells;
import characters.Characters;
import characters.Ground;
import characters.Items;
import enumclass.TileType;
import load.LoadCharacter;
import load.LoadItem;

/**
 * 
 * Map class to initialize the map, menu bar, menu items and panels 
 * 
 * @author grey
 * @version 1.0
 *
 */

public class Map {

	

	private int numRows = 0;
	private int numCols = 1;
	public JButton[][] jButtons = new JButton[100][100];
	public Cells[][] map;// the 2 dimensions Cells array
	public ArrayList<Items> itemArrayList = new ArrayList<Items>();
	public ArrayList<Characters> characterArrayList = new ArrayList<Characters>();
	
	
	

	public int width, height;
	public String title;
	public JFrame jFrame;
	public JButton jButton;
	public JPanel panel = new JPanel();
//	public JPanel panelShow = new JPanel();
	public JPanel panelContainer = new JPanel(); // contain the panel which contains the map
	public JPanel showPanel = new JPanel(); //contain the item and character combo box 
	public JPanel characterPanel = new JPanel();
	public JComboBox<String> itemBox = new JComboBox<String>();// show created item in the file
	public JComboBox<String> characterBox = new JComboBox<String>();// show created character in the file
	public JMenuBar jMenuBar = new JMenuBar();
	public JMenu jMenu = new JMenu("Menu");
	public JMenu jMenuHelp = new JMenu("Help");
	public JMenu jMenuSave = new JMenu("Save");
	public JMenuItem saveMap = new JMenuItem("Save Map");
	public JMenu jMenuLoad = new JMenu("Load");
	public JMenuItem loadMap = new JMenuItem("Load Map");
	public JMenuItem jMenuMap = new JMenuItem("Create a map");
	public JMenuItem jMenuCharacter = new JMenuItem("Create a character");
	public JMenuItem jMenuItem = new JMenuItem("Create an item");
	public JMenuItem jMenuCampaign = new JMenuItem("Create a compaign");
	public JMenuItem jMenuInstruction = new JMenuItem("Instruction");
	
	/**
	 *  get map method
	 * @return  2 dimension Cells array
	 */
	public Cells[][] getMap() {
		return map;
	}

	/**
	 * set map method
	 * @param map      2 dimension Cells array
	 * @param numRows  the total rows of map
	 * @param numCols  the total cols of map
	 */
	public void setMap(Cells[][] map, int numRows,int numCols) {
		this.map = map;
		this.numRows = numRows;
		this.numCols = numCols;
	}
	/**
	 * get rows
	 * @return rows of map
	 */

	public int getNumRows() {
		return numRows;
	}
	/**
	 * get cols
	 * @return cols of map
	 */
	public int getNumCols() {
		return numCols;
	}
	
	public void setNumRows(int numRows) {
		this.numRows = numRows;
	}

	public void setNumCols(int numCols) {
		this.numCols = numCols;
	}
	/**
	 *  initialize the map
	 * @param title 	name of frame
	 * @param width		width of frame
	 * @param height	height of frame
	 */

	public Map(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		init();
	}

	

	/**
	 * This method is used to draw the map in a panel according to different rows and columns.
	 * @param k  k=1 create the new map, k=2 load a map
	 */
	
	//根据地图的行和列，以及其中的对象来画地图
	public void drawMap(int k) {

		panel.setBounds(0, 0, numCols * 33,numRows * 33);// rows represents height, cols represents width
		panel.setLayout(new GridLayout(numRows, numCols));
//		panelShow.setBounds(width * 4 / 5, 0, width / 5, height);
		panelContainer.setBounds(0, 0, width * 4 / 5, height);
		showPanel.setBounds(width * 4 / 5, 0, width / 5, height/3);
		characterPanel.setBounds(width * 4 / 5, height/3,width / 5, height*2/3);
		
		
		drawItemBox(); //show items in the file
		drawcharacterBox();// show characters in the file
		
//		 System.out.println("numRows: "+numRows);
//		 System.out.println("numCols: "+numCols);
		
		
		

		if (k == 1) {
			map = new Cells[numRows][numCols];
			for (int rows = 0; rows < numRows; rows++)
			for (int cols = 0; cols < numCols; cols++) {
			map[rows][cols] = new Cells(TileType.GROUND,numRows,numCols,new Ground(TileType.GROUND));
					
				}
		}
		
//		for(int i=0;i<numRows;i++)
//			for(int j=0;j<numCols;j++)
//				System.out.println(map[i][j]);
		
		if(k==2)
			panel.removeAll();

		for (int i = 0; i < numRows; i++)
			for (int j = 0; j < numCols; j++) {

				// panel.setLayout(new GridLayout(numRows,numCols));
				if (map[i][j].getTileType() == TileType.GROUND)
					jButton = new JButton("", new ImageIcon(Image.class.getResource("/textures/Ground.png")));
				else if (map[i][j].getTileType() == TileType.WALL) 
					jButton = new JButton("", new ImageIcon(Image.class.getResource("/textures/Wall.png")));
				 else if (map[i][j].getTileType() == TileType.CHEST)
					jButton = new JButton("", new ImageIcon(Image.class.getResource("/textures/Chest.png")));
				else if (map[i][j].getTileType() == TileType.HERO)
					jButton = new JButton("", new ImageIcon(Image.class.getResource("/textures/Hero.png")));
				else if (map[i][j].getTileType() == TileType.MONSTER)
					jButton = new JButton("", new ImageIcon(Image.class.getResource("/textures/Monster.png")));
				else if (map[i][j].getTileType() == TileType.EXIT)
					jButton = new JButton("", new ImageIcon(Image.class.getResource("/textures/Exit.png")));
				else if (map[i][j].getTileType() == TileType.ENTRY)
					jButton = new JButton("", new ImageIcon(Image.class.getResource("/textures/Entry.png")));
				
				jButton.putClientProperty("Rows", i);// set a attribute for every button
				jButton.putClientProperty("Cols", j);
				jButton.setBorderPainted(false);
				jButton.setBounds(j * 33, i * 33, 32, 32); // j represents width, i represent height
				jButton.addActionListener(new MapListener(Map.this,itemBox,characterBox));

				jButtons[i][j] = jButton;
				panel.add(jButtons[i][j]);
				
				if(k==2)
					panel.repaint(); 
				
			}

	}
	/**
	 * show characters list in the character box
	 */
	//在面板上显示人物列表
	public void drawcharacterBox() {
		characterBox.removeAllItems(); // remove original character list
		
		try {
			characterArrayList = new LoadCharacter().readCharacter(); // get the character list from file
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(Characters characters:characterArrayList)
		{
			characterBox.addItem(characters.getName());
		}
		
	}
	/**
	 * show items list in the item box
	 */
	//在面板上显示物品列表
	public void drawItemBox(){
			itemBox.removeAllItems();// remove original item list
			
		
		 try {
				itemArrayList = new LoadItem().readItem();// get the item list from file
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			for(Items items : itemArrayList)
			{
				itemBox.addItem(items.getName());
				
			}
	}
	/**
	 * initialize whole frame and add listener for every menu items
	 */
	//初始化整个frame，并对菜单项添加相应的监听
	public void init() {

		jFrame = new JFrame(title);
		jFrame.setBounds(0, 0, width, height);

		 drawMap(1); //initialize map the first
		 
		
		// panel was covered by buttons
		// panel.addMouseListener(new MouseAdapter() {
		//
		// @Override
		// public void mouseClicked ( MouseEvent e )
		// {
		//
		// System.out.println(numCols+"--"+ numRows);
		// System.out.println("X- "+(int) Math.floor(e.getX()/33));
		// System.out.println("Y- "+(int) Math.floor(e.getY()/33));
		// map[(int) Math.floor(e.getX()/33)][(int) Math.floor(e.getY()/33)] =1;
		//// jButtons[(int) Math.floor(e.getX()/33)][(int)
		// Math.floor(e.getY()/33)]
		//// .setIcon(new ImageIcon("/textures/Wall.png"));
		// drawMap(3);
		// }
		// });
		 
		 
		jMenuMap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				new RowColFrame(Map.this,jFrame); //open RowColFrame
				jFrame.setEnabled(false);

			}
		});

		jMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ItemFrame(Map.this,jFrame,itemArrayList,itemBox);//open ItemFrame
				jFrame.setEnabled(false);
			}
		});

		jMenuCharacter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CharacterFrame(Map.this,jFrame,characterBox);//open CharacterFrame
				jFrame.setEnabled(false);
			}
		});
		
		saveMap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int flagEntry = 0;
				int flagExit = 0;
				int flagHero = 0;
				//遍历整个地图，判断是否有出口，入口和人物
				// traverse whole map to judge whether there is exit, entry or Hero
				for(int i=0;i<numRows;i++){
					for(int j=0;j<numCols;j++){
						if(map[i][j].getTileType().equals(TileType.ENTRY))
							flagEntry = 1;
						 if (map[i][j].getTileType().equals(TileType.EXIT))
							flagExit = 1;	
						 if (map[i][j].getTileType().equals(TileType.HERO))
							flagHero = 1;
						
					}
					
				}
				
				if(flagEntry==0)
				JOptionPane.showMessageDialog(null, "There is no Entry", "Alert", JOptionPane.ERROR_MESSAGE);
				if(flagExit==0)
					JOptionPane.showMessageDialog(null, "There is no Exit", "Alert", JOptionPane.ERROR_MESSAGE);
				if(flagHero==0)
					JOptionPane.showMessageDialog(null, "There is no Player", "Alert", JOptionPane.ERROR_MESSAGE);
				
				//如果三者都有，则存储地图
				// if the map has entry, exit and hero, then save the map
				if(flagEntry==1 && flagExit==1 && flagHero==1){
				new SaveMapFrame(map,numRows,numCols,jFrame); //open SaveMapFrame
				jFrame.setEnabled(false);
				}
				
				
			}
			
		});
		
		loadMap.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new LoadMapFrame(Map.this,map,jFrame); //open LoadMapFrame
				jFrame.setEnabled(false);
				
//				Cells[][] cells;
//				cells = new LoadMap().loadMap(Map.this,"Map1");
//				numRows = cells[0][0].getX();
//				numCols = cells[0][0].getY();
//				map = new Cells[numRows][numCols];
//				map = cells;
//				drawMap(2);
				
				
				
			}
			
			
		});

		jMenuHelp.add(jMenuInstruction);
		jMenu.add(jMenuCampaign);
		jMenu.add(jMenuMap);
		jMenu.add(jMenuCharacter);
		jMenu.add(jMenuItem);
		jMenuSave.add(saveMap);
		jMenuLoad.add(loadMap);
		jMenuBar.add(jMenu);
		jMenuBar.add(jMenuSave);
		jMenuBar.add(jMenuLoad);
		jMenuBar.add(jMenuHelp);
		jFrame.setJMenuBar(jMenuBar);

		panel.setBackground(Color.gray);
//		panelShow.setBackground(Color.GREEN);
		showPanel.setBackground(Color.BLUE);
		characterPanel.setBackground(Color.white);
		
		panelContainer.setLayout(new BorderLayout());
		panelContainer.add(panel, BorderLayout.CENTER);// add more panels to solve the problem
		showPanel.add(itemBox);
		showPanel.add(characterBox);
//		panelShow.setLayout(new FlowLayout());
//		panelShow.add(itemPanel);
//		panelShow.add(characterPanel);

		jFrame.add(panel);
//		jFrame.add(panelShow);
		jFrame.add(showPanel);
		jFrame.add(characterPanel);
		jFrame.add(panelContainer);

		jFrame.setPreferredSize(new Dimension(width, height));
		jFrame.pack();
		jFrame.setVisible(true);
		jFrame.setLocationRelativeTo(null);// put the screen in the center
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	

}
