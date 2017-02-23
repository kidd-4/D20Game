package map;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import characters.Cells;
import load.LoadMap;

public class LoadMapFrame {
	
	Cells[][] mapCells;
	int numRows;
	int numCols;
			
	public LoadMapFrame(Map map, Cells[][] map2, JFrame jFrame2){
		JFrame jFrame = new JFrame("Load the map");
		JButton jButton = new JButton("Load");
		JLabel jLabelName = new JLabel("Input a map name");
		JTextField mapName = new JTextField();
		
		mapName.setSize(new Dimension(50, 30));
		mapName.setColumns(8);
		
		jFrame.setLayout(new FlowLayout());
		jFrame.add(jLabelName);
		jFrame.add(mapName);
		jFrame.add(jButton);
		
		jFrame.setLocationRelativeTo(null);//put the screen in the center
		jFrame.setSize(new Dimension(300, 300));
		jFrame.setVisible(true);
//		jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				jFrame.dispose();
				jFrame2.setEnabled(true);
			}
		});
		
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				

				try {
					Cells[][] cells;
					cells = new LoadMap().loadMap(map,mapName.getText());
//					System.out.println(mapName.getText());
					numRows = cells[0][0].getX();
					numCols = cells[0][0].getY();
					map.setMap(cells,numRows,numCols);
					map.drawMap(2);
//					System.out.println("-----");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				jFrame2.setEnabled(true);
				jFrame.dispose();
				
			}
		});
	}

}
