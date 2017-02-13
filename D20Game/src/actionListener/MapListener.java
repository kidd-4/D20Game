package actionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import map.Map;

public class MapListener implements ActionListener{
	public Map map;
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton jButton = (JButton) e.getSource();
		System.out.println(jButton.getClientProperty("Rows")+" "+jButton.getClientProperty("Cols"));
	}

}
