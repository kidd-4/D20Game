package actionListener;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import map.Map;

public class MenuListener implements ActionListener {
	private JTextField jTextRows = new JTextField();
	private JTextField jTextColumns = new JTextField();
	public Map map;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand()=="Create a map")
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
			
			jButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getActionCommand()=="Comfirm")
					jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					//没有设置行和列  comfirm无效，无法关闭窗口
					
				}
			});

		}
		
	}
	public JTextField getjTextRows() {
		return jTextRows;
	}
	public JTextField getjTextColumns() {
		return jTextColumns;
	}
	

}
