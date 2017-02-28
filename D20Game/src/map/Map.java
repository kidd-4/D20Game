package map;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import actionListener.MapListener;
import characters.Campaigns;
import characters.Cells;
import characters.Characters;
import characters.Ground;
import characters.Items;
import characters.Matrix;
import enumclass.TileType;
import load.LoadCampaign;
import load.LoadCharacter;
import load.LoadItem;
import load.LoadMap;
import save.SaveCharacter;

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
	public ArrayList<Items> backpack = new ArrayList<Items>();
	public ArrayList<Matrix> allMaps = new ArrayList<Matrix>();
	public ArrayList<Campaigns> campaigns = new ArrayList<Campaigns>();

	public int width, height;
	public String title;
	public JFrame jFrame;
	public JButton jButton;
	public JButton equip = new JButton("Equip item");
	public JButton showInformation = new JButton("Show Information");
	public JPanel panel = new JPanel();
//	public JPanel panelShow = new JPanel();
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
	public JComboBox<String> backpackBox= new JComboBox<String>();// show backpack of Player
	public JLabel backpackBoxLabel =  new JLabel("Backpack of Player");
	
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
		panelContainer.setBounds(0, 0, 680, height);
		showPanel.setBounds(680, 0, width-680, height/4);
		characterPanel.setBounds(680, height/4,width-680, height*3/4);
		
		
		drawItemBox(); //show items in the file
		drawcharacterBox();// show characters in the file
		drawBackpackBox();
		drawInformation();
		drawMapBox();
		drawCampaignBox();
		
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
				jButton.addActionListener(new MapListener(Map.this,itemBox,characterBox,characterArrayList,itemArrayList));

				jButtons[i][j] = jButton;
				panel.add(jButtons[i][j]);
				
				if(k==2)
					panel.repaint(); 
				
			}

	}
	
	public void drawInformation(){
		Characters characters = null;
		try {
			//读取characters
			/* when the character box in the main frame was selected, 
			 * then we get corresponding character object from the file
			 */
			if(characterBox.getSelectedItem() !=null)//如果下拉框不为空
			characters = new LoadCharacter().loadcharacter(characterBox.getSelectedItem().toString(),characterArrayList);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//如果人物不为空
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
	
	
	public void drawBackpackBox() {
		backpackBox.removeAllItems(); // remove original item list
		
		try {
			backpack = new LoadCharacter().readBackpack(characterArrayList); // get the item list from file
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(Items items:backpack)
		{
			backpackBox.addItem(items.getName());
		}
		
	}
	
	
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
	 * show characters list in the character box
	 */
	//在面板上显示人物列表
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
	 * show items list in the item box
	 */
	//在面板上显示物品列表
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
	public void init() {

		jFrame = new JFrame(title);
		jFrame.setBounds(0, 0, width, height);

		 drawMap(1); //initialize map the first
		 
		 //显示下拉框选中的人物的信息
		 showInformation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				drawInformation();
			}
		});
		 
		 //把backpack中的装备换到inventory中，并改变人物的属性
		 equip.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String backpackString = backpackBox.getSelectedItem().toString();
				String invetoryString = null;
				String[] strings = backpackString.split("\\d");//正则表达式去除数字
				
				int backpackValue = 0;
				int inventoryValue = 0;
				Characters oldCharacter = null;
				try {
					//读取characters
					/* when the character box in the main frame was selected, 
					 * then we get corresponding character object from the file
					 */
					//必须是玩家的名字
					if(characterBox.getSelectedItem().toString().startsWith("P")||characterBox.getSelectedItem().toString().startsWith("p")){
					oldCharacter = new LoadCharacter().loadcharacter(characterBox.getSelectedItem().toString(),characterArrayList);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(oldCharacter != null){
					
				
				// 获得backpack物品的value
				for(Items backpack: oldCharacter.getBackpack()){
					if(backpack.getName().equals(backpackString)){
						backpackValue = backpack.getValue();
					}
				}
				
				// 在inventory中寻找和backpack中对应的物品，如果有，则返回对应物品，如果无，就返回空
				for(Items inventory :oldCharacter.getInventory()){
					
					String[] strings2 = inventory.getName().split("\\d");
					if(strings2[0].equalsIgnoreCase(strings[0])){
						invetoryString = inventory.getName();
						inventoryValue = inventory.getValue();
						break;
					}
					else{
						invetoryString = "EMPTY";
						inventoryValue = 0;
					}
				}
				
				//将backpack中的物品换成inventory中的物品
				for(Items backpack:oldCharacter.getBackpack()){
					//如果有两个相同名字的物品，则会出问题 break可以解决问题
					if(backpack.getName().equals(backpackString)){
						backpack.setName(invetoryString);
						backpack.setValue(inventoryValue);
						break;
					}
				}
				
				//将inventory中的物品换成backpack中的物品，并修改对应的属性
				if(strings[0].equalsIgnoreCase("WEAPON")){
					oldCharacter.getInventory().get(0).setName(backpackString);
					oldCharacter.getInventory().get(0).setValue(backpackValue);
					int value = oldCharacter.getDamageBonus();
					oldCharacter.setDamageBonus(value+backpackValue-inventoryValue);
				}
				else if(strings[0].equalsIgnoreCase("SHIELD")){
					oldCharacter.getInventory().get(1).setName(backpackString);
					oldCharacter.getInventory().get(1).setValue(backpackValue);
					int value = oldCharacter.getArmorClass();
					oldCharacter.setArmorClass(value+backpackValue-inventoryValue);
				}
				else if(strings[0].equalsIgnoreCase("HELMET")){
					oldCharacter.getInventory().get(2).setName(backpackString);
					oldCharacter.getInventory().get(2).setValue(backpackValue);
					int value = oldCharacter.getIntelligence();
					oldCharacter.setIntelligence(value+backpackValue-inventoryValue);
				}
				else if(strings[0].equalsIgnoreCase("ARMOR")){
					oldCharacter.getInventory().get(3).setName(backpackString);
					oldCharacter.getInventory().get(3).setValue(backpackValue);
					int value = oldCharacter.getArmorClass();
					oldCharacter.setArmorClass(value+backpackValue-inventoryValue);
				}
				else if(strings[0].equalsIgnoreCase("RING")){
					oldCharacter.getInventory().get(4).setName(backpackString);
					oldCharacter.getInventory().get(4).setValue(backpackValue);
					int value = oldCharacter.getWisdom();
					oldCharacter.setWisdom(value+backpackValue-inventoryValue);
				}
				else if(strings[0].equalsIgnoreCase("BELT")){
					oldCharacter.getInventory().get(5).setName(backpackString);
					oldCharacter.getInventory().get(5).setValue(backpackValue);
					int value = oldCharacter.getStrength();
					oldCharacter.setStrength(value+backpackValue-inventoryValue);
				}
				else{
					oldCharacter.getInventory().get(6).setName(backpackString);
					oldCharacter.getInventory().get(6).setValue(backpackValue);
					int value = oldCharacter.getDexterity();
					oldCharacter.setDexterity(value+backpackValue-inventoryValue);
				}
				
				//删除原有的player之后再保存现在的
				for(Characters characters: characterArrayList){
					if(characters.getName().startsWith("P")||characters.getName().startsWith("p")){
						characterArrayList.remove(characters);
						break;
					}
				}
				
				characterArrayList.add(oldCharacter);
				
				//还要保存文件，这里暂时不保存，便于查看效果
				
				try {
					new SaveCharacter().saveCharacter(characterArrayList);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				}
				
				drawBackpackBox();
				drawInformation();
				
				
			}
		});
		 
		 jMenuCampaign.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new CampaignFrame(Map.this,jFrame, allMaps,campaigns);
				jFrame.setEnabled(false);
			}
		});
		 
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
				new ItemFrame(Map.this,jFrame,itemArrayList);//open ItemFrame
				jFrame.setEnabled(false);
			}
		});

		jMenuCharacter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CharacterFrame(Map.this,jFrame,characterArrayList,itemArrayList);//open CharacterFrame
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
				new SaveMapFrame(Map.this,map,jFrame,allMaps); //open SaveMapFrame
				jFrame.setEnabled(false);
				}
				
				
			}
			
		});
		
		loadMap.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
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

		panel.setBackground(Color.gray);
//		panelShow.setBackground(Color.GREEN);
		showPanel.setBackground(Color.LIGHT_GRAY);
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
		showPanel.add(backpackBoxLabel);
		showPanel.add(backpackBox);
		showPanel.add(equip);
		showPanel.add(showInformation);
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
