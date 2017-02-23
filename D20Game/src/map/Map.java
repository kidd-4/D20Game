package map;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import actionListener.MapListener;
import characters.Cells;
import enumclass.TileType;

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
	JButton[][] jButtons = new JButton[100][100];
	Cells[][] map;
	Cells[][] loadMapCells;
	Player player;
	private String mapName;
	
	
	

	public int width, height;
	public String title;
	public JFrame jFrame;
	public Canvas canvas;
	public JButton jButton;
	public JPanel panel = new JPanel();
	public JPanel panel2 = new JPanel();
	public JPanel panel3 = new JPanel();
	public JMenuBar jMenuBar = new JMenuBar();
	public JMenu jMenu = new JMenu("Menu");
	public JMenu jMenuHelp = new JMenu("Help");
	public JMenu jMenuSave = new JMenu("Save");
	public JMenuItem saveMap = new JMenuItem("Save Map");
//	public JMenuItem saveCharacter = new JMenuItem("Save Character");
//	public JMenuItem saveItem = new JMenuItem("Save Item");
	public JMenu jMenuLoad = new JMenu("Load");
	public JMenuItem loadMap = new JMenuItem("Load Map");
	public JMenuItem loadCharacter = new JMenuItem("Load Character");
	public JMenuItem loadItem = new JMenuItem("Load Item");
	public JMenuItem jMenuMap = new JMenuItem("Create a map");
	public JMenuItem jMenuCharacter = new JMenuItem("Create a character");
	public JMenuItem jMenuItem = new JMenuItem("Create an item");
	public JMenuItem jMenuCampaign = new JMenuItem("Create a compaign");
	public JMenuItem jMenuInstruction = new JMenuItem("Instruction");
	
	public Cells[][] getLoadMapCells() {
		return loadMapCells;
	}

	public void setLoadMapCells(Cells[][] loadMapCells) {
		this.loadMapCells = loadMapCells;
	}

	public String getMapName() {
		return mapName;
	}

	public void setMapName(String mapName) {
		this.mapName = mapName;
	}

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



	public Map(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		init();
	}

	public void setNumRows(int numRows) {
		this.numRows = numRows;
	}

	public void setNumCols(int numCols) {
		this.numCols = numCols;
	}

	/**
	 * This method is used to draw the map in a panel according to different
	 * rows and columns.
	 */

	public void drawMap(int k) {

		panel.setBounds(0, 0, numCols * 33,numRows * 33);// rows represents height, cols represents width
		// System.out.println(numRows*32+"--"+numCols*32);
		panel.setLayout(new GridLayout(numRows, numCols));
		panel2.setBounds(width * 4 / 5, 0, width / 5, height);
		panel3.setBounds(0, 0, width * 4 / 5, height);
//		 System.out.println("numRows: "+numRows);
//		 System.out.println("numCols: "+numCols);
		
		
		

		if (k == 1) {
			map = new Cells[numRows][numCols];
			for (int rows = 0; rows < numRows; rows++)
				for (int cols = 0; cols < numCols; cols++) {
						map[rows][cols] = new Cells(TileType.Ground,numRows,numCols);
					
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
				if (map[i][j].getTileType() == TileType.Ground)
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
				
				jButton.putClientProperty("Rows", i);
				jButton.putClientProperty("Cols", j);
				jButton.setBorderPainted(false);
				jButton.setBounds(j * 33, i * 33, 32, 32); // j represents width, i represent height
				jButton.addActionListener(new MapListener(Map.this));

				jButtons[i][j] = jButton;
				panel.add(jButtons[i][j]);
				
				if(k==2)
					panel.repaint();
				
			}

	
		
//		player = new Player(Map.this, panel);
//		player.update();
	}

	public void init() {

		jFrame = new JFrame(title);
		jFrame.setBounds(0, 0, width, height);

		// canvas = new Canvas();
		// canvas.setPreferredSize(new Dimension(width, height));
		// canvas.setMaximumSize(new Dimension(width, height));
		// canvas.setMinimumSize(new Dimension(width, height));

		// jFrame.add(canvas);
		// jFrame.pack();//fully display canvas

		// Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		// int width = screenSize.width;
		// int height = screenSize.height;

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
				new RowColFrame(Map.this);

			}
		});

		jMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ItemFrame(Map.this);
			}
		});

		jMenuCharacter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new CharacterFrame(Map.this);
			}
		});
		
		saveMap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new SaveMapFrame(map,numRows,numCols);
				System.out.println();
				
				
				
			}
			
		});
		
		loadMap.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new LoadMapFrame(Map.this,map);
				
				
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
//		jMenuSave.add(saveCharacter);
//		jMenuSave.add(saveItem);
		jMenuLoad.add(loadMap);
		jMenuLoad.add(loadCharacter);
		jMenuLoad.add(loadItem);
		jMenuBar.add(jMenu);
		jMenuBar.add(jMenuSave);
		jMenuBar.add(jMenuLoad);
		jMenuBar.add(jMenuHelp);
		jFrame.setJMenuBar(jMenuBar);

		panel.setBackground(Color.gray);
		panel2.setBackground(Color.GREEN);
		
		panel3.setLayout(new BorderLayout());
		panel3.add(panel, BorderLayout.CENTER);// add more panels to solve the problem
												 

		jFrame.add(panel);
		jFrame.add(panel2);
		jFrame.add(panel3);

		jFrame.setPreferredSize(new Dimension(width, height));
		// jFrame.pack();
		jFrame.setVisible(true);
		jFrame.setLocationRelativeTo(null);// put the screen in the center
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public Canvas getCanvas(){
		return canvas;
		
	}
	

}
