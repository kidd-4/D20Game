package map;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RowColFrame {
	
	private JTextField jTextRows = new JTextField();
	private JTextField jTextColumns = new JTextField();
	public Map map;
	
	public RowColFrame(Map map)
	{
		JFrame jFrame = new JFrame("Rows and Columns");
		JButton jButton = new JButton("Comfirm");
		JLabel jLabelRows = new JLabel("Input a row(<=20)");
		JLabel jLabelColumns = new JLabel("Input a column(<=20)");
		
		jTextRows.setSize(new Dimension(100, 30));
		jTextRows.setColumns(10);
		jTextColumns.setSize(new Dimension(100, 30));
		jTextColumns.setColumns(10);
		
		
		jFrame.setLayout(new FlowLayout());
		jFrame.add(jLabelRows);
		jFrame.add(jTextRows);
		jFrame.add(jLabelColumns);
		jFrame.add(jTextColumns);
		jFrame.add(jButton);
		jFrame.setLocationRelativeTo(null);//put the screen in the center
		jFrame.setSize(new Dimension(300, 300));
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jTextRows.requestFocus();
		
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				String rows = jTextRows.getText();
//				String columns = jTextColumns.getText();
				
//				map.drawMap();
				
				
				map.setNumRows(Integer.parseInt(jTextColumns.getText()));
				map.setNumCols(Integer.parseInt(jTextRows.getText()));
				System.out.println(jTextRows.getText());
				System.out.println(jTextColumns.getText());
				map.drawMap();
				jFrame.dispose();
//				jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				//行和列的设置有问题，窗口出现没有聚焦
				
			}
		});

	
	}

}
