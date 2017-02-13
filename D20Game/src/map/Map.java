package map;


import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import actionListener.MapListener;
import actionListener.MenuListener;



public class Map {
	
	private static int numRows = 0 ;
	private static int numCols = 1;
	JButton[][] jButtons = new JButton[100][100];
	public MenuListener menuListener;
	
//	private int[][] grids = new int[numRows][numCols];
	
	private int width,height;
	private String title;
	private JFrame jFrame;
	private Canvas canvas;
	private JPanel panel = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	
	
	
	public Map(String title, int width, int height){
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
	
	

	public void drawMap(){
		
		panel.setBounds(0, 0,numRows*33,numCols*33);// 不知道为什么width是rows，而height是cols
		System.out.println(numRows*32+"--"+numCols*32);
		panel.setLayout(new GridLayout(numRows,numCols));
		panel2.setBounds(width*4/5,0, width/5, height);
		panel3.setBounds(0, 0, width*4/5, height);
		System.out.println(numRows+"--"+numCols);
		
		
		for(int i=0;i<numRows;i++)
			for(int j=0;j<numCols;j++)
			{
//				panel.setLayout(new GridLayout(numRows,numCols));
				JButton jButton= new JButton("",new ImageIcon(Image.class.getResource("/textures/02.png")));
				
//				jButtons[i][j].setBackground(Color.yellow);
				jButton.putClientProperty("Rows", j);//不知道为什么rows对应j，cols对应i
				jButton.putClientProperty("Cols", i);
				jButton.setBorderPainted(false);
				jButton.setBounds(i*33, j*33, 32, 32);
				jButton.addActionListener(new MapListener());
				jButtons[i][j] = jButton;
				panel.add(jButtons[i][j]);
			}
		
		panel3.setLayout(new BorderLayout());
		panel3.add(panel,BorderLayout.CENTER);//add more panels to solve the problem
		
		jFrame.add(panel);
		jFrame.add(panel2);
		jFrame.add(panel3);
	}


	public void init() {
		
		
		jFrame = new JFrame(title);
		jFrame.setBounds(0, 0, width, height);
		
//		canvas = new Canvas();
//		canvas.setPreferredSize(new Dimension(width, height));
//		canvas.setMaximumSize(new Dimension(width, height));
//		canvas.setMinimumSize(new Dimension(width, height));
		
//		jFrame.add(canvas);
//		jFrame.pack();//fully display canvas
		
		JMenuBar jMenuBar = new JMenuBar();
		JMenu jMenu = new JMenu("Menu");
		JMenu jMenu2 = new JMenu("Input");
		JMenuItem jMenuSave = new JMenuItem("Save");
		JMenuItem jMenuLoad = new JMenuItem("Load");
		JMenuItem jMenuMap = new JMenuItem("Create a map");
		JMenuItem jMenuCampaign = new JMenuItem("Create a compaign");
		JMenuItem jMenuDice = new JMenuItem("Roll a dice");
		
		
		
//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//		int width = screenSize.width;
//		int height = screenSize.height;


		
		
		
		
		
		drawMap();
		
		
		jMenuMap.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				new RowColFrame(Map.this);
				
			}
		});
		
		
		jMenu2.add(jMenuDice);
		jMenu.add(jMenuCampaign);
		jMenu.add(jMenuMap);
		jMenu.add(jMenuSave);
		jMenu.add(jMenuLoad);
		jMenuBar.add(jMenu);
		jMenuBar.add(jMenu2);
		jFrame.setJMenuBar(jMenuBar);
		
		
		
		
		
		panel.setBackground(Color.gray);
		panel2.setBackground(Color.GREEN);

		jFrame.setPreferredSize(new Dimension(width, height));
//		jFrame.pack();
		jFrame.setVisible(true);
		jFrame.setLocationRelativeTo(null);//put the screen in the center
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}




	public Canvas getCanvas() {
		return canvas;
	}
	
	


}
