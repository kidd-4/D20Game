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
 * Map class to initialize the map
 * 
 * @author grey
 * @version 1.0
 *
 */

public class Map {

	

	private int numRows = 0;
	private int numCols = 1;
	public JButton[][] jButtons = new JButton[100][100];
	public Cells[][] map;
	public Object object;
	public ArrayList<Items> itemArrayList = new ArrayList<Items>();
	public ArrayList<Characters> characterArrayList = new ArrayList<Characters>();
	
	
	

	public int width, height;
	public String title;
	public JFrame jFrame;
	public JButton jButton;
	public JPanel panel = new JPanel();
//	public JPanel panelShow = new JPanel();
	public JPanel panel3 = new JPanel();
	public JPanel showPanel = new JPanel();
	public JPanel characterPanel = new JPanel();
	public JComboBox<String> itemBox = new JComboBox<String>();
	public JComboBox<String> characterBox = new JComboBox<String>();
	public JMenuBar jMenuBar = new JMenuBar();
	public JMenu jMenu = new JMenu("Menu");
	public JMenu jMenuHelp = new JMenu("Help");
	public JMenu jMenuSave = new JMenu("Save");
	public JMenuItem saveMap = new JMenuItem("Save Map");
	public JMenu jMenuLoad = new JMenu("Load");
	public JMenuItem loadMap = new JMenuItem("Load Map");
	public JMenuItem loadCharacter = new JMenuItem("Load Character");
	public JMenuItem loadItem = new JMenuItem("Load Item");
	public JMenuItem jMenuMap = new JMenuItem("Create a map");
	public JMenuItem jMenuCharacter = new JMenuItem("Create a character");
	public JMenuItem jMenuItem = new JMenuItem("Create an item");
	public JMenuItem jMenuCampaign = new JMenuItem("Create a compaign");
	public JMenuItem jMenuInstruction = new JMenuItem("Instruction");
	
	


	public Cells[][] getMap() {
		return map;
	}

	public void setMap(Cells[][] map, int numRows,int numCols) {
		this.map = map;
		this.numRows = numRows;
		this.numCols = numCols;
	}

	public int getNumRows() {
		return numRows;
	}

	public int getNumCols() {
		return numCols;
	}
	
	public void setNumRows(int numRows) {
		this.numRows = numRows;
	}

	public void setNumCols(int numCols) {
		this.numCols = numCols;
	}


	public Map(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		init();
	}

	

	/**
	 * This method is used to draw the map in a panel according to different
	 * rows and columns.
	 */

	public void drawMap(int k) {

		panel.setBounds(0, 0, numCols * 33,numRows * 33);// rows represents height, cols represents width
		panel.setLayout(new GridLayout(numRows, numCols));
//		panelShow.setBounds(width * 4 / 5, 0, width / 5, height);
		panel3.setBounds(0, 0, width * 4 / 5, height);
		showPanel.setBounds(width * 4 / 5, 0, width / 5, height/3);
		characterPanel.setBounds(width * 4 / 5, height/3,width / 5, height*2/3);
		
		
		drawItemBox();
		drawcharacterBox();
		
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
				
				jButton.putClientProperty("Rows", i);
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

	private void drawcharacterBox() {
		characterBox.removeAllItems();
		
		try {
			characterArrayList = new LoadCharacter().readCharacter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Characters characters:characterArrayList)
		{
			characterBox.addItem(characters.getName());
		}
		
	}

	public void drawItemBox(){
			itemBox.removeAllItems();
			
		
		 try {
				itemArrayList = new LoadItem().readItem();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for(Items items : itemArrayList)
			{
				itemBox.addItem(items.getName());
				
			}
	}
	
	public void init() {

		jFrame = new JFrame(title);
		jFrame.setBounds(0, 0, width, height);

		 drawMap(1);
		 
		
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
				new RowColFrame(Map.this,jFrame);
				jFrame.setEnabled(false);

			}
		});

		jMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ItemFrame(Map.this,jFrame,itemArrayList);
				jFrame.setEnabled(false);
			}
		});

		jMenuCharacter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CharacterFrame(Map.this,jFrame,characterArrayList);
				jFrame.setEnabled(false);
			}
		});
		
		saveMap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SaveMapFrame(map,numRows,numCols,jFrame);
				jFrame.setEnabled(false);				
				
				
			}
			
		});
		
		loadMap.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new LoadMapFrame(Map.this,map,jFrame);
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
		jMenuLoad.add(loadCharacter);
		jMenuLoad.add(loadItem);
		jMenuBar.add(jMenu);
		jMenuBar.add(jMenuSave);
		jMenuBar.add(jMenuLoad);
		jMenuBar.add(jMenuHelp);
		jFrame.setJMenuBar(jMenuBar);

		panel.setBackground(Color.gray);
//		panelShow.setBackground(Color.GREEN);
		showPanel.setBackground(Color.BLUE);
		characterPanel.setBackground(Color.white);
		
		panel3.setLayout(new BorderLayout());
		panel3.add(panel, BorderLayout.CENTER);// add more panels to solve the problem
		showPanel.add(itemBox);
		showPanel.add(characterBox);
//		panelShow.setLayout(new FlowLayout());
//		panelShow.add(itemPanel);
//		panelShow.add(characterPanel);

		jFrame.add(panel);
//		jFrame.add(panelShow);
		jFrame.add(showPanel);
		jFrame.add(characterPanel);
		jFrame.add(panel3);

		jFrame.setPreferredSize(new Dimension(width, height));
		jFrame.pack();
		jFrame.setVisible(true);
		jFrame.setLocationRelativeTo(null);// put the screen in the center
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	

}
