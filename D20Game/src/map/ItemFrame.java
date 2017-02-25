package map;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import characters.Items;
import save.SaveItem;

public class ItemFrame {
	
	public Map map;
	private JTextField weapon = new JTextField();
//	private JTextField shield = new JTextField();
//	private JTextField helmet = new JTextField();
//	private JTextField armor = new JTextField();
//	private JTextField ring = new JTextField();
//	private JTextField belt = new JTextField();
//	private JTextField boot = new JTextField();
	
	private JTextField weaponName = new JTextField();
//	private JTextField shieldName = new JTextField();
//	private JTextField helmetName = new JTextField();
//	private JTextField armorName = new JTextField();
//	private JTextField ringName= new JTextField();
//	private JTextField beltName = new JTextField();
//	private JTextField bootName = new JTextField();
	
	//WEAPON, SHIELD, HELMET, ARMOR, RING, BELT, BOOTS,EMPTY
	
	public ItemFrame(Map map, JFrame jFrame2, ArrayList<Items> itemArrayList, JComboBox<String> itemBox){
		JFrame jFrame = new JFrame("Items");
		JButton jButton = new JButton("Save");
		JLabel weaponLabel = new JLabel("Item");
//		JLabel shieldLabel = new JLabel("Shield");
//		JLabel helmetLabel = new JLabel("Helmet");
//		JLabel armorLabel = new JLabel("Armor");
//		JLabel ringLabel = new JLabel("Ring");
//		JLabel beltLabel = new JLabel("Belt");
//		JLabel bootLabel = new JLabel("Boot");
		
		weaponName.setSize(new Dimension(100, 30));
		weaponName.setColumns(10);
		weapon.setSize(new Dimension(100, 30));
		weapon.setColumns(10);
		
//		shieldName.setSize(new Dimension(100, 30));
//		shieldName.setColumns(10);
//		shield.setSize(new Dimension(100, 30));
//		shield.setColumns(10);
//		
//		helmetName.setSize(new Dimension(100, 30));
//		helmetName.setColumns(10);
//		helmet.setSize(new Dimension(100, 30));
//		helmet.setColumns(10);
//		
//		armorName.setSize(new Dimension(100, 30));
//		armorName.setColumns(11);
//		armor.setSize(new Dimension(100, 30));
//		armor.setColumns(11);
//		
//		ringName.setSize(new Dimension(100, 30));
//		ringName.setColumns(11);
//		ring.setSize(new Dimension(100, 30));
//		ring.setColumns(11);
//		
//		beltName.setSize(new Dimension(100, 30));
//		beltName.setColumns(11);
//		belt.setSize(new Dimension(100, 30));
//		belt.setColumns(11);
//		
//		bootName.setSize(new Dimension(100, 30));
//		bootName.setColumns(11);
//		boot.setSize(new Dimension(100, 30));
//		boot.setColumns(11);
		
		
		jFrame.setLayout(new FlowLayout());
		jFrame.add(weaponLabel);
		jFrame.add(weaponName);
		jFrame.add(weapon);
//		jFrame.add(shieldLabel);
//		jFrame.add(shieldName);
//		jFrame.add(shield);
//		jFrame.add(helmetLabel);
//		jFrame.add(helmetName);
//		jFrame.add(helmet);
//		jFrame.add(armorLabel);
//		jFrame.add(armorName);
//		jFrame.add(armor);
//		jFrame.add(ringLabel);
//		jFrame.add(ringName);
//		jFrame.add(ring);
//		jFrame.add(beltLabel);
//		jFrame.add(beltName);
//		jFrame.add(belt);
//		jFrame.add(bootLabel);
//		jFrame.add(bootName);
//		jFrame.add(boot);
		jFrame.add(jButton);
		jFrame.setLocationRelativeTo(null);//put the screen in the center
		jFrame.setSize(new Dimension(350, 500));
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
				
//				String wName = weaponName.getText();
//				String weaponValue = weapon.getText();
//				String sName = shieldName.getText();
//				String shieldValue = shield.getText();
//				String hName = helmetName.getText();
//				String helmetValue = helmet.getText();
//				String aName = armorName.getText();
//				String armorValue = armor.getText();
//				String rName = ringName.getText();
//				String ringValue = ring.getText();
//				String beName = beltName.getText();
//				String beltValue = belt.getText();
//				String boName = bootName.getText();
//				String bootValue = boot.getText();
				
				itemArrayList.add(new Items(weaponName.getText(), Integer.parseInt(weapon.getText())));
//				arrayList.add(shieldName.getText());
//				arrayList.add(shield.getText());
//				arrayList.add(helmetName.getText());
//				arrayList.add(helmet.getText());
//				arrayList.add(armorName.getText());
//				arrayList.add(armor.getText());
//				arrayList.add(ringName.getText());
//				arrayList.add(ring.getText());
//				arrayList.add(beltName.getText());
//				arrayList.add(belt.getText());
//				arrayList.add(bootName.getText());
//				arrayList.add(boot.getText());
				
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
