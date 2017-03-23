package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import actionListener.PanelListener;
import actionListener.MapListener;
import enumclass.TileType;
import load.LoadCampaign;
import load.LoadCharacter;
import load.LoadItem;
import load.LoadMap;
import objects.Campaigns;
import objects.Cells;
import objects.Characters;
import objects.Ground;
import objects.Items;
import objects.Matrix;
import observer.CharacterObserver;
import play.Adaptor;

/**
 * 
 * Map class to initialize the map, menu bar, menu items and panels.
 * When the map was changed, the map will be repainted.
 * When player create or edit a map, character, item or campaign, then show the information on the panel
 *

 * @author grey,Tann
 * @version 2.0

 */

public class Map {

	private int numRows = 0;
	private int numCols = 1;
	public JButton[][] jButtons = new JButton[100][100];
	public Cells[][] map;// the 2 dimensions Cells array
	public ArrayList<Items> itemArrayList = new ArrayList<Items>();
	public ArrayList<Characters> characterArrayList = new ArrayList<Characters>();
	public ArrayList<Characters> characterMapArrayList = new ArrayList<>();
	
	public ArrayList<Matrix> allMaps = new ArrayList<Matrix>();
	public ArrayList<Campaigns> campaigns = new ArrayList<Campaigns>();

	public int width, height;
	public String title;
	public JFrame jFrame;
	public JButton jButton;
	public JButton startGame = new JButton("Start Game");
	public JButton inventoryInformation = new JButton("Inventory Information");
	public JPanel panel = new JPanel();
	public JPanel panelContainer = new JPanel(); // contain the panel which contains the map
	public JPanel showPanel = new JPanel(); //contain the item and character combo box 
	public JPanel characterPanel = new JPanel();
	
	public JComboBox<String> itemBox = new JComboBox<String>();// show created item in the file
	public JLabel itemBoxLabel =  new JLabel("Created Items");
	public JComboBox<String> characterBox = new JComboBox<String>();// show created character in the file
	public JLabel characterBoxLabel =  new JLabel("Created Characters");
	public JComboBox<String> mapBox = new JComboBox<String>();// show created map in the file
	public JLabel mapBoxLabel =  new JLabel("Created Maps");
	public JComboBox<String> campaignBox = new JComboBox<String>();// show created character in the file
	public JLabel campaignBoxLabel =  new JLabel("Created Campaigns");
	public JComboBox<String> characterMapBox = new JComboBox<String>();// show created character in the map
	public JLabel characterMapLabel =  new JLabel("Characters in the map");
	
	public JMenuBar jMenuBar = new JMenuBar();
	public JMenu jMenu = new JMenu("Menu");
	public JMenu jMenuHelp = new JMenu("Help");
	public JMenu jMenuSave = new JMenu("Save");
	public JMenuItem saveMap = new JMenuItem("Save Map");
	public JMenu jMenuLoad = new JMenu("Load");
	public JMenuItem loadMap = new JMenuItem("Load Map");
	public JMenuItem jMenuMap = new JMenuItem("Create a map");
	public JMenuItem jMenuCharacter = new JMenuItem("Create/Edit a character");
	public JMenuItem jMenuItem = new JMenuItem("Create/Edit an item");
	public JMenuItem jMenuCampaign = new JMenuItem("Create/Edit a compaign");
	public JMenuItem jMenuInstruction = new JMenuItem("Instruction");
	
	public JLabel name = new JLabel("Name");
	public JLabel level = new JLabel("Level");
	public JLabel hitpoints = new JLabel("Hitpoints");
	public JLabel movement = new JLabel("Movement");
	public JLabel strength = new JLabel("Strength");
	public JLabel dexterity = new JLabel("Dexterity");
	public JLabel consititution = new JLabel("Consititution");
	public JLabel wisdom = new JLabel("Wisdom");
	public JLabel intelligence = new JLabel("Intelligence");
	public JLabel charisma = new JLabel("Charisma");
	public JLabel orient = new JLabel("Orientation");
	public JLabel armorClass = new JLabel("armorClass");
	public JLabel attackBonus = new JLabel("attackBonus");
	public JLabel damageBonus = new JLabel("damageBonus");
	
	public JLabel namevValue = new JLabel(" ");
	public JLabel levelValue = new JLabel(" ");
	public JLabel hitpointsValue = new JLabel(" ");
	public JLabel movementValue = new JLabel(" ");
	public JLabel strengthValue = new JLabel(" ");
	public JLabel dexterityValue = new JLabel(" ");
	public JLabel consititutionValue = new JLabel(" ");
	public JLabel wisdomValue = new JLabel(" ");
	public JLabel intelligenceValue = new JLabel(" ");
	public JLabel charismaValue = new JLabel(" ");
	public JLabel orientValue = new JLabel(" ");
	public JLabel armorClassValue = new JLabel(" ");
	public JLabel attackBonusValue = new JLabel(" ");
	public JLabel damageBonusValue = new JLabel(" ");
	
	public JLabel inventory1 = new JLabel("Inventory1");
	public JLabel inventory2 = new JLabel("Inventory2");
	public JLabel inventory3 = new JLabel("Inventory3");
	public JLabel inventory4 = new JLabel("Inventory4");
	public JLabel inventory5 = new JLabel("Inventory5");
	public JLabel inventory6 = new JLabel("Inventory6");
	public JLabel inventory7 = new JLabel("Inventory7");

	/*playing game*/
	public Characters playingHero;
	public Campaigns playingCampaign;
	public int numberMap; //record the maps num of selected campaign
	public int playingIndex; //recoed the index of map the player is playing,start with 0
	
	public ActionListener actionListener;
	public KeyListener keyListener ;

	/**
	 * The getter to get the playing index
	 * @return the index of playing map in the campaign
	 */
	public int getPlayingIndex(){
		return playingIndex;
	}

	/**
	 * get map method
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
	public void setMap(Cells[][] map, int numRows,int numCols) {//不需要rows
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
	/**
	 * 
	 * @param numRows numRows
	 */
	public void setNumRows(int numRows) {
		this.numRows = numRows;
	}
	/**
	 * 
	 * @param numCols numCols
	 */
	public void setNumCols(int numCols) {
		this.numCols = numCols;
	}

	/**
	 * The setter to set the index of playing map in the campaign
	 */
	public void setPlayingIndex(int playingIndex) {
		this.playingIndex = playingIndex;
	}

	/**
	 * initialize the map
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
	 * @param k  k=1 create the new map, k=2 load an existed map
	 */
	public void drawMap(int k) {

		panel.setBounds(0, 0, numCols * 33,numRows * 33);// rows represents height, cols represents width
		panel.setLayout(new GridLayout(numRows, numCols));
		panelContainer.setBounds(0, 0, 680, height);
		showPanel.setBounds(680, 0, width-680, height/4);
		characterPanel.setBounds(680, height/4,width-680, height*3/4);
		
		
		drawItemBox(); //show items in the file
		drawcharacterBox();// show characters in the file
//		drawInformation();
		drawMapBox();
		drawCampaignBox();
		

		if (k == 1) {
			map = new Cells[numRows][numCols];
			for (int rows = 0; rows < numRows; rows++)
			for (int cols = 0; cols < numCols; cols++) {
			map[rows][cols] = new Cells(TileType.GROUND,numRows,numCols,new Ground(TileType.GROUND));
					
			}
		}
		
		
		if(k==2)
			panel.removeAll();
//		if(k==3){
//			panel.removeAll();
//			panelContainer.removeAll();
//			panelContainer.requestFocus();
////			panel.updateUI();
////			panelContainer.updateUI();
//			System.out.println("333 "+playingIndex);
//			System.out.println("333 "+numRows);
//			System.out.println("333 "+numCols);
//		}


		for (int i = 0; i < numRows; i++)
			for (int j = 0; j < numCols; j++) {
				// draw the map according to different kind of TileType
				if (map[i][j].getTileType() == TileType.GROUND)
					jButton = new JButton("", new ImageIcon("res/textures/Ground.png"));
				else if (map[i][j].getTileType() == TileType.WALL) 
					jButton = new JButton("", new ImageIcon("res/textures/Wall.png"));
				 else if (map[i][j].getTileType() == TileType.CHEST)
					jButton = new JButton("", new ImageIcon("res/textures/Chest.png"));
				else if (map[i][j].getTileType() == TileType.HERO)
					jButton = new JButton("", new ImageIcon("res/textures/Hero.png"));
				else if (map[i][j].getTileType() == TileType.MONSTER)
					jButton = new JButton("", new ImageIcon("res/textures/Monster.png"));
				else if (map[i][j].getTileType() == TileType.EXIT)
					jButton = new JButton("", new ImageIcon("res/textures/Exit.jpg"));
				else if (map[i][j].getTileType() == TileType.ENTRY)
					jButton = new JButton("", new ImageIcon("res/textures/Entry.jpg"));
				
				jButton.putClientProperty("Rows", i);// set a attribute for every button
				jButton.putClientProperty("Cols", j);
				jButton.setBorderPainted(false);
				jButton.setBounds(j * 33, i * 33, 32, 32); // j represents width, i represent height
				jButton.addActionListener(new MapListener(Map.this,itemBox,characterBox,characterArrayList,itemArrayList));

				jButtons[i][j] = jButton;
				panel.add(jButtons[i][j]);
				
				if(k==2)
					panel.repaint(); 
			}
	}
	
	/**
	 * show the information of selected character
	 */
	public void drawInformation(){
		Characters characters = null;
		//读取characters
		/* when the character box in the main frame was selected, 
		 * then we get corresponding character object from the file
		 */
//		try {
//			if(characterMapBox.getSelectedItem() !=null)
//			characters = new LoadCharacter().loadcharacter(characterMapBox.getSelectedItem().toString(),characterArrayList);
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		characters = getCharacterMap();
		
		
		

		if(characters!=null){
			namevValue.setText(characters.getName());
			levelValue.setText(String.valueOf(characters.getLevel()));
			hitpointsValue.setText(String.valueOf(characters.getHitpoints()));
			movementValue.setText(String.valueOf(characters.getMovement()));
			strengthValue.setText(String.valueOf(characters.getStrength()));
			dexterityValue.setText(String.valueOf(characters.getDexterity()));
			consititutionValue.setText(String.valueOf(characters.getConstitution()));
			wisdomValue.setText(String.valueOf(characters.getWisdom()));
			intelligenceValue.setText(String.valueOf(characters.getIntelligence()));
			charismaValue.setText(String.valueOf(characters.getCharisma()));
			orientValue.setText(String.valueOf(characters.getOrient()));
			armorClassValue.setText(String.valueOf(characters.getArmorClass()));
			attackBonusValue.setText(String.valueOf(characters.getAttackBonus()));
			damageBonusValue.setText(String.valueOf(characters.getDamageBonus()));
			inventory1.setText(characters.getInventory().get(0).getName());
			inventory2.setText(characters.getInventory().get(1).getName());
			inventory3.setText(characters.getInventory().get(2).getName());
			inventory4.setText(characters.getInventory().get(3).getName());
			inventory5.setText(characters.getInventory().get(4).getName());
			inventory6.setText(characters.getInventory().get(5).getName());
			inventory7.setText(characters.getInventory().get(6).getName());
		
		}
	}


	/**
	 * show the created campaigns
	 */
	public void drawCampaignBox(){
		campaignBox.removeAllItems(); // remove original campaign list
		
		try {
			campaigns = new LoadCampaign().readCampaign();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Campaigns c:campaigns ){
			campaignBox.addItem(c.getName());
		}
		
	}
	
	/**
	 * show the created maps
	 */
	public void drawMapBox(){
		mapBox.removeAllItems(); // remove original map list
		try {
			allMaps = new LoadMap().readMap();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		for(Matrix matrix: allMaps)
		{
			mapBox.addItem(matrix.getName());
		}
	}
	
	/**
	 * show created characters in the character box
	 */
	//show the characters list in jcombobox
	public void drawcharacterBox() {
		characterBox.removeAllItems(); // remove original character list
		try {
			characterArrayList = new LoadCharacter().readCharacter();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Characters characters:characterArrayList)
		{
			characterBox.addItem(characters.getName());
		}
		
	}
	
	/**
	 * show created items in the item box
	 */
	//show items list in  jcombobox
	public void drawItemBox(){
			itemBox.removeAllItems();// remove original item list
		
				try {
					itemArrayList = new LoadItem().readItem();// get the item list from file
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
	//initialize the frame and add action listener
	public void init() {

		jFrame = new JFrame(title);
		jFrame.setBounds(0, 0, width, height);

		 drawMap(1); //initialize map the first
		 
		
		 
		 startGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//initialization
				playingHero=null;
				playingCampaign=null;
//				numberMap=0;
				playingIndex=0;

				String selectedCharacter=characterBox.getSelectedItem().toString();
				String selectedCampaign=campaignBox.getSelectedItem().toString();

				try {
					Map.this.playingHero=new LoadCharacter().loadcharacter(selectedCharacter, characterArrayList);
					Map.this.playingCampaign=new LoadCampaign().loadCampaign(campaigns,selectedCampaign);
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				initCampaign();
				System.out.println("playingIndex "+playingIndex);
				System.out.println("numberMap "+numberMap);

			}
		});
		 
		 CharacterObserver characterObserver = new CharacterObserver(Map.this);
		 
		  actionListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				characterObserver.start();
				panelContainer.requestFocus();
			}
		};
		
			characterMapBox.addActionListener(actionListener);;
			
		 
		 //显示下拉框选中的人物的信息
		 // show the information of selected character
		inventoryInformation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Characters character = null;
				
				for(int i=0;i<numRows;i++)
					for(int j=0;j<numCols;j++){
						//把所有地图中的人物加到arraylist中去
						//add all characters on the map into arrayList
						if(map[i][j].getTileType()==TileType.MONSTER||map[i][j].getTileType()==TileType.HERO)
						{	
							characterMapArrayList.add(map[i][j].getCharacters());
						}
					}
				
				character = getCharacterMap();
				
//				try {
//					character = new LoadCharacter().loadcharacter(characterMapBox.getSelectedItem().toString(), characterArrayList);
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
				
				new InventoryFrame(Map.this, jFrame,characterMapArrayList,character);
				characterMapArrayList.clear();;
				jFrame.setEnabled(false);
				panelContainer.requestFocus();
			}
		});
		 
		 
		 
		 //open the CampaignFrame
		 jMenuCampaign.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new CampaignFrame(Map.this,jFrame, allMaps,campaigns);
				jFrame.setEnabled(false);
				panelContainer.requestFocus();
			}
		});
		 
		 //open the RowColFrame
		jMenuMap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				panel.removeAll();
				new RowColFrame(Map.this,jFrame); //open RowColFrame
				jFrame.setEnabled(false);
				panelContainer.requestFocus();
			}
		});
		
		//open the ItemFrame
		jMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ItemFrame(Map.this,jFrame,itemArrayList);//open ItemFrame
				jFrame.setEnabled(false);
				panelContainer.requestFocus();
			}
		});

		//open the CharacterFrame
		jMenuCharacter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CharacterFrame(Map.this,jFrame,characterArrayList,itemArrayList);//open CharacterFrame
				jFrame.setEnabled(false);
				panelContainer.requestFocus();
			}
		});
		
		//open the SaveMapFrame
		saveMap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int flagEntry = 0;
				int flagExit = 0;
				int flagHero = 0;
				
				int[] flag = verifyMap(flagEntry,flagExit,flagHero);
				
				flagEntry = flag[0];
				flagExit = flag[1];
				flagHero = flag[2];
				
				if(flagEntry==0)
					JOptionPane.showMessageDialog(null, "There is no Entry", "Alert", JOptionPane.ERROR_MESSAGE);
				if(flagExit==0)
					JOptionPane.showMessageDialog(null, "There is no Exit", "Alert", JOptionPane.ERROR_MESSAGE);
				if(flagHero==0)
					JOptionPane.showMessageDialog(null, "There is no Player", "Alert", JOptionPane.ERROR_MESSAGE);
				
				//如果三者都有，则存储地图
				// if the map has entry, exit and hero, then save the map
				if(flagEntry==1 && flagExit==1 && flagHero==1){
				new SaveMapFrame(Map.this,map,jFrame,allMaps); //open SaveMapFrame
				jFrame.setEnabled(false);
				}
				
				
			}

		});
		
		//open the LoadMapFrame
		loadMap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				panel.setVisible(true);
				new LoadMapFrame(Map.this,jFrame,allMaps); //open LoadMapFrame
				jFrame.setEnabled(false);
				
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

		panel.setBackground(Color.GRAY);
		panelContainer.setBackground(Color.GRAY);
//		panelShow.setBackground(Color.GREEN);
		showPanel.setBackground(Color.white);
		characterPanel.setBackground(Color.white);
		
		panelContainer.setLayout(new BorderLayout());
		panelContainer.add(panel, BorderLayout.CENTER);// add more panels to solve the problem
		showPanel.add(itemBoxLabel);
		showPanel.add(itemBox);
		showPanel.add(characterBoxLabel);
		showPanel.add(characterBox);
		showPanel.add(mapBoxLabel);
		showPanel.add(mapBox);
		showPanel.add(campaignBoxLabel);
		showPanel.add(campaignBox);
		showPanel.add(startGame);
		showPanel.add(characterMapLabel);
		showPanel.add(characterMapBox);
		showPanel.add(inventoryInformation);
		characterPanel.setLayout(new FlowLayout(0, 30, 30));//0向左对齐，30代表左右间距，30代表上下间距
		characterPanel.add(name);
		characterPanel.add(namevValue);
		characterPanel.add(level);
		characterPanel.add(levelValue);
		characterPanel.add(hitpoints);
		characterPanel.add(hitpointsValue);
		characterPanel.add(movement);
		characterPanel.add(movementValue);
		characterPanel.add(strength);
		characterPanel.add(strengthValue);
		characterPanel.add(dexterity);
		characterPanel.add(dexterityValue);
		characterPanel.add(consititution);
		characterPanel.add(consititutionValue);
		characterPanel.add(wisdom);
		characterPanel.add(wisdomValue);
		characterPanel.add(intelligence);
		characterPanel.add(intelligenceValue);
		characterPanel.add(charisma);
		characterPanel.add(charismaValue);
		characterPanel.add(orient);
		characterPanel.add(orientValue);
		characterPanel.add(armorClass);
		characterPanel.add(armorClassValue);
		characterPanel.add(attackBonus);
		characterPanel.add(attackBonusValue);
		characterPanel.add(damageBonus);
		characterPanel.add(damageBonusValue);
		characterPanel.add(inventory1);
		characterPanel.add(inventory2);
		characterPanel.add(inventory3);
		characterPanel.add(inventory4);
		characterPanel.add(inventory5);
		characterPanel.add(inventory6);
		characterPanel.add(inventory7);
		
		

		jFrame.add(panel);
		jFrame.add(showPanel);
		jFrame.add(characterPanel);
		jFrame.add(panelContainer);

		jFrame.setPreferredSize(new Dimension(width, height));
		jFrame.pack();
		jFrame.setVisible(true);
		jFrame.setLocationRelativeTo(null);// put the screen in the center
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public Characters getCharacterMap() {
		Characters characters = null;
		for(int i=0;i<numRows;i++)
			for(int j=0;j<numCols;j++){
				//把所有地图中的人物加到arraylist中去
				//add all characters on the map into arrayList
				if(map[i][j].getTileType()==TileType.MONSTER||map[i][j].getTileType()==TileType.HERO)
				{	
					//获取选中的人物对象
					//obtain the character object
					if(map[i][j].getCharacters().getName().equals(characterMapBox.getSelectedItem().toString()))
						characters = map[i][j].getCharacters();
				}
			}
		return characters;
	}
	
	
	
	/**
	 *  * The method is used to verify the map
	 * in the creation of maps, an entry,exit,hero should be existed
	 * @param flagEntry  number of entry
	 * @param flagExit	number of exit
	 * @param flagHero	number of hero
	 * @return  int array contains 3 numbers
	 */
	public int[] verifyMap(int flagEntry, int flagExit, int flagHero) {
		
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
		int[] flag = {flagEntry,flagExit,flagHero};
		return flag;
	}
	
	

	public boolean exitGlobal(Cells[][] map2){
		for (int i = 0; i < map2.length; i++) {
			for (int j = 0; j < map2[i].length; j++) {
				if (this.map[i][j].getTileType().equals(TileType.EXIT)) {
					return true;
				}
			}
		}
		
		return false;
		
	}
	
	public boolean entryGlobal(Cells[][] map2){
		for (int i = 0; i < map2.length; i++) {
			for (int j = 0; j < map2[i].length; j++) {
				if (this.map[i][j].getTileType().equals(TileType.ENTRY)) {
					return true;
				}
			}
		}
		
		return false;
		
	}
	
	public boolean playerGlobal(Cells[][] map2){
		for (int i = 0; i < map2.length; i++) {
			for (int j = 0; j < map2[i].length; j++) {
				if (this.map[i][j].getTileType().equals(TileType.HERO)) {
					return true;
				}
			}
		}
		
		return false;
		
	}

	/**
	 * The method is to initialize the game
	 */
	public void initCampaign(){

		//set
		Cells[][] newMap = playingCampaign.getCampaign().get(playingIndex).getMap();
//		System.out.println("enter to map :"+playingCampaign.getCampaign().get(playingIndex).getName());
		
		numRows = newMap[0][0].getX();
		numCols = newMap[0][0].getY();
		setMap(newMap, numRows, numCols);

		//adapt the items and character,based on the level of hero
		Adaptor adaptor=new Adaptor(newMap,this.playingHero);
		adaptor.adapting();

		updateCharacterList();

		numberMap = playingCampaign.getCampaign().size()-1;
		keyListener = new PanelListener(Map.this,numberMap);
		panelContainer.addKeyListener(keyListener);
		panelContainer.requestFocus();
		//character show on the entry
		showOnMap();
		drawMap(2);

	}

	/**
	 * The method is used to show the hero on the map in the beginning
	 */
	public void showOnMap(){

		for(int r=0; r<numRows;r++){
			for(int c=0; c<numCols;c++){
				if(this.map[r][c].getTileType()==TileType.ENTRY){
					//Playing hero 要改变
					//Playing hero should change
					this.map[r][c]=new Cells(TileType.HERO,numRows,numCols,this.playingHero);
				}

				else if(this.map[r][c].getTileType()==TileType.HERO){
					this.map[r][c]=new Cells(TileType.GROUND,numRows, numCols,new Ground(TileType.GROUND));
				}

			}
		}

	}

	/**
	 * The method is used to change map from exit
	 */
	public void changeMap(){
		this.playingIndex+=1;
		Cells[][] newMap = playingCampaign.getCampaign().get(playingIndex).getMap();
		System.out.println("change to"+playingCampaign.getCampaign().get(playingIndex).getName()+"map");
		numRows = newMap[0][0].getX();
		numCols = newMap[0][0].getY();
		setMap(newMap, numRows, numCols);
		System.out.println("playingIndex- "+playingIndex);
		System.out.println(""+numRows);
		System.out.println(""+numCols);
		//adapt the items and character, based on hero's level
		Adaptor adaptor=new Adaptor(newMap,this.playingHero);
		adaptor.adapting();
		updateCharacterList();
		drawMap(2);
	}

	/**
	 * The method is to update the Jcombobox of character, according to the characters in the map
	 */
	public void updateCharacterList(){

		characterMapBox.removeActionListener(actionListener);
		//在消除所有的选项之前，需要先去除监听，因为选项为空时，监听会有问题
		//before deleting all items in jcombobox,need to delete the listener firstly
		characterMapBox.removeAllItems();
		
		

		for(int i=0;i<numRows;i++)
			for(int j=0;j<numCols;j++){
				if(map[i][j].getTileType() == TileType.MONSTER ||map[i][j].getTileType() == TileType.HERO){
					characterMapBox.addItem(map[i][j].getCharacters().getName());
//					System.out.println("character Jcombobox update");
				}
			}
		
		characterMapBox.addActionListener(actionListener);
	}

	/**
	 * The method is to remove the components in the panel to show the main page after playing of a campaign
	 */
	//没有使用
	public void removePanelContainer(){

//		System.out.println("the campaign is finshed");
		setPlayingIndex(0);
		setNumRows(0);
		setNumCols(1);
		panel.removeAll();
		drawMap(3);
	}



}
