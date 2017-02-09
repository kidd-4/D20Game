package map;


import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;


public class Map {
	
//	private static final int numRows = 25;
//	private static final int numCols = 30;
//	
//	private int[][] grids = new int[numRows][numCols];
	
	private int width,height;
	private String title;
	private JFrame jFrame;
	private Canvas canvas;
	
	
	public Map(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		init();
	}
	
	
	

	private void init() {
		
		jFrame = new JFrame(title);
		jFrame.setBounds(0, 0, width, height);
		jFrame.setVisible(true);
		jFrame.setLocationRelativeTo(null);//put the screen in the center
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		
		jFrame.add(canvas);
		jFrame.pack();//fully display canvas
//		JPanel panel = new JPanel();
//		JPanel panel2 = new JPanel();
		
		
//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//		int width = screenSize.width;
//		int height = screenSize.height;

		
		
//		panel.setBounds(0, 0, width*4/5, height);
//		panel2.setBounds(width*4/5, 0, width/5, height);
//		panel.setBackground(Color.BLUE);
//		panel2.setBackground(Color.GREEN);
		
		
//		panel.setLayout(new FlowLayout());
//		Button button = new Button("Nice");
//		button.setBounds(100, height/5, 100, 100);
		
		
		
		
//		frame.add(panel);
//		frame.add(panel2);
//		panel.add(button);
		
		
//		frame.addWindowListener(new WindowAdapter() {
//			
//			@Override
//			public void windowClosing(WindowEvent e) {
//				// TODO Auto-generated method stub
//				System.exit(0);
//			}
//		});
		
	}




	public Canvas getCanvas() {
		return canvas;
	}
	
	


}
