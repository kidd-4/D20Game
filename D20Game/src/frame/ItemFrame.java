package frame;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import load.LoadItem;
import objects.Items;
import save.SaveItem;
/**
 * ItemFrame is used to create a new Item or edit a Item
 * @author grey
 * @version 1.0
 */
public class ItemFrame {

	public Map map;
	public Items oldItems;
	private JTextField itemValue = new JTextField();

	private JTextField itemName = new JTextField();

	// WEAPON, SHIELD, HELMET, ARMOR, RING, BELT, BOOTS,EMPTY
/**
 * constructor method
 * @param map 		Map object
 * @param jFrame2   main frame
 * @param itemArrayList  itemArrayList
 */
	public ItemFrame(Map map, JFrame jFrame2, ArrayList<Items> itemArrayList) {
		JFrame jFrame = new JFrame("Items");
		JButton save = new JButton("Save");
		JButton load = new JButton("Load an item");
		JLabel itemLabel = new JLabel("Item");

		itemName.setSize(new Dimension(100, 30));
		itemName.setColumns(10);
		itemValue.setSize(new Dimension(100, 30));
		itemValue.setColumns(10);


		jFrame.setLayout(new FlowLayout());
		jFrame.add(itemLabel);
		jFrame.add(itemName);
		jFrame.add(itemValue);
		
		jFrame.add(load);
		jFrame.add(save);
		jFrame.setLocationRelativeTo(null);// put the screen in the center
		jFrame.setSize(new Dimension(350, 500));
		jFrame.setVisible(true);
		jFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				jFrame.dispose();
				jFrame2.setEnabled(true);
			}
		});
		
		//load a item value with the input name
		load.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				oldItems = new LoadItem().loadItem(itemName.getText(), itemArrayList);
				if(oldItems == null)
					JOptionPane.showMessageDialog(null, "There is no such item", "Alert", JOptionPane.ERROR_MESSAGE);
				else
					itemValue.setText(String.valueOf(oldItems.getValue()));
			}
		});
		
		// save a item
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				oldItems = new LoadItem().loadItem(itemName.getText(), itemArrayList);
				Items items = new Items(itemName.getText(), Integer.parseInt(itemValue.getText()));
				// if the item with input name exist , remove it and add new item. if not, add item
				if (oldItems == null) {
					itemArrayList.add(items);
				}
				else {
					itemArrayList.remove(oldItems);
					itemArrayList.add(items);
				}

				try {
					new SaveItem().saveItem(itemArrayList);
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				map.drawItemBox();

				jFrame2.setEnabled(true);
				jFrame.dispose();

			}
		});

	}

}
