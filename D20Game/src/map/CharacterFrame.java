package map;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import characters.Characters;
import characters.Items;
import enumclass.Orientation;
import load.LoadItem;
import save.SaveCharacter;


public class CharacterFrame {

	public Map map;
	public ArrayList<Items> itemArrayList = new ArrayList<Items>();//显示创建人物时的物品下拉框
	
//	public ArrayList<Characters> characterArrayList = new ArrayList<Characters>();
	private JTextField name = new JTextField();
	private JTextField level = new JTextField();
	private JTextField hitpoints = new JTextField();
	private JTextField movement = new JTextField();
	private JTextField strength = new JTextField();
	private JTextField defence = new JTextField();
	private JTextField dexterity = new JTextField();
	private JTextField wisdom = new JTextField();
	private JTextField orient = new JTextField();
	
	private JTextField weapon = new JTextField();
	private JTextField shield = new JTextField();
	private JTextField helmet = new JTextField();
	private JTextField armor = new JTextField();
	private JTextField ring = new JTextField();
	private JTextField belt = new JTextField();
	private JTextField boot = new JTextField();
	
	private JTextField weaponName = new JTextField();
	private JTextField shieldName = new JTextField();
	private JTextField helmetName = new JTextField();
	private JTextField armorName = new JTextField();
	private JTextField ringName= new JTextField();
	private JTextField beltName = new JTextField();
	private JTextField bootName = new JTextField();

	
	public CharacterFrame(Map map, JFrame jFrame2, JComboBox<String> characterBox){
		JFrame jFrame = new JFrame("Character");
		JButton save = new JButton("Save");
		JButton roll = new JButton("Roll");
		JButton loadItem = new JButton("Load an item");
		JComboBox<String> jComboBox = new JComboBox<String>();
		JLabel nameLabel = new JLabel("Name");
		JLabel levelLabel = new JLabel("Level");
		JLabel hitpointsLabel = new JLabel("Hitpoint");
		JLabel movementLabel = new JLabel("Movement");
		JLabel strengthLabel = new JLabel("Strength");
		JLabel defenceLabel = new JLabel("Defence");
		JLabel dexterityLabel = new JLabel("Dexterity");
		JLabel wisdomLabel = new JLabel("Wisdom");
		JLabel orientLabel = new JLabel("Orient");
		
		JLabel weaponLabel = new JLabel("Weapon");
		JLabel shieldLabel = new JLabel("Shield");
		JLabel helmetLabel = new JLabel("Helmet");
		JLabel armorLabel = new JLabel("Armor");
		JLabel ringLabel = new JLabel("Ring");
		JLabel beltLabel = new JLabel("Belt");
		JLabel bootLabel = new JLabel("Boot");
		
		weaponName.setSize(new Dimension(50, 30));
		weaponName.setColumns(10);
		weapon.setSize(new Dimension(50, 30));
		weapon.setColumns(10);
		
		shieldName.setSize(new Dimension(50, 30));
		shieldName.setColumns(10);
		shield.setSize(new Dimension(50, 30));
		shield.setColumns(10);
		
		helmetName.setSize(new Dimension(50, 30));
		helmetName.setColumns(10);
		helmet.setSize(new Dimension(50, 30));
		helmet.setColumns(10);
		
		armorName.setSize(new Dimension(50, 30));
		armorName.setColumns(11);
		armor.setSize(new Dimension(50, 30));
		armor.setColumns(11);
		
		ringName.setSize(new Dimension(50, 30));
		ringName.setColumns(11);
		ring.setSize(new Dimension(50, 30));
		ring.setColumns(11);
		
		beltName.setSize(new Dimension(50, 30));
		beltName.setColumns(11);
		belt.setSize(new Dimension(50, 30));
		belt.setColumns(11);
		
		bootName.setSize(new Dimension(50, 30));
		bootName.setColumns(11);
		boot.setSize(new Dimension(50, 30));
		boot.setColumns(11);
		
		
		loadItem.setSize(new Dimension(50, 30));
		
		name.setSize(new Dimension(50, 30));
		name.setColumns(8);
		
		level.setSize(new Dimension(50, 30));
		level.setColumns(8);

		hitpoints.setSize(new Dimension(50, 30));
		hitpoints.setColumns(8);
		
		movement.setSize(new Dimension(50, 30));
		movement.setColumns(8);
		
		strength.setSize(new Dimension(50, 30));
		strength.setColumns(8);
		
		defence.setSize(new Dimension(50, 30));
		defence.setColumns(8);
		
		dexterity.setSize(new Dimension(50, 30));
		dexterity.setColumns(8);
		
		wisdom.setSize(new Dimension(50, 30));
		wisdom.setColumns(8);
		
		orient.setSize(new Dimension(50, 30));
		orient.setColumns(20);
		
		
		jFrame.setLayout(new FlowLayout());
		jFrame.add(nameLabel);
		jFrame.add(name);
		jFrame.add(levelLabel);
		jFrame.add(level);
		jFrame.add(hitpointsLabel);
		jFrame.add(hitpoints);
		jFrame.add(movementLabel);
		jFrame.add(movement);
		jFrame.add(strengthLabel);
		jFrame.add(strength);
		jFrame.add(defenceLabel);
		jFrame.add(defence);
		jFrame.add(dexterityLabel);
		jFrame.add(dexterity);
		jFrame.add(wisdomLabel);
		jFrame.add(wisdom);
		jFrame.add(orientLabel);
		jFrame.add(orient);
		
		jFrame.add(weaponLabel);
		jFrame.add(weaponName);
		jFrame.add(weapon);
		jFrame.add(shieldLabel);
		jFrame.add(shieldName);
		jFrame.add(shield);
		jFrame.add(helmetLabel);
		jFrame.add(helmetName);
		jFrame.add(helmet);
		jFrame.add(armorLabel);
		jFrame.add(armorName);
		jFrame.add(armor);
		jFrame.add(ringLabel);
		jFrame.add(ringName);
		jFrame.add(ring);
		jFrame.add(beltLabel);
		jFrame.add(beltName);
		jFrame.add(belt);
		jFrame.add(bootLabel);
		jFrame.add(bootName);
		jFrame.add(boot);
		
		jFrame.add(loadItem);
		jFrame.add(jComboBox);
		jFrame.add(roll);
		jFrame.add(save);
		
		try {
			itemArrayList = new LoadItem().readItem();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(Items items : itemArrayList)
		{
			jComboBox.addItem(items.getName());
			
		}
		
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
		
		
		loadItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String string = jComboBox.getSelectedItem().toString();
				int num1,num2;
				try {
					String newString = new LoadItem().loadItem(string);
					String[] strings =newString.split(" ");
					String name = strings[0];
					String value = strings[1];
					if(name.startsWith("W")||name.startsWith("w"))//大小写问题 正则表达式
					{
						weaponName.setText(name);
						weapon.setText(value);
						
						num1 = Integer.parseInt(value);
						num2 = Integer.parseInt(strength.getText());
						strength.setText(String.valueOf(num1+num2));
					}
					else if(name.startsWith("S")||name.startsWith("s"))
					{
						shieldName.setText(name);
						shield.setText(value);
						
						num1 = Integer.parseInt(value);
						num2 = Integer.parseInt(defence.getText());
						defence.setText(String.valueOf(num1+num2));
					}
					else if(name.startsWith("H")||name.startsWith("h"))
					{
						helmetName.setText(name);
						helmet.setText(value);
						
						num1 = Integer.parseInt(value);
						num2 = Integer.parseInt(strength.getText());
						strength.setText(String.valueOf(num1+num2));
					}
					else if(name.startsWith("A")||name.startsWith("a"))
					{
						armorName.setText(name);
						armor.setText(value);
						
						num1 = Integer.parseInt(value);
						num2 = Integer.parseInt(defence.getText());
						defence.setText(String.valueOf(num1+num2));
					}
					else if(name.startsWith("R")||name.startsWith("r"))
					{
						ringName.setText(name);
						ring.setText(value);
						
						num1 = Integer.parseInt(value);
						num2 = Integer.parseInt(wisdom.getText());
						wisdom.setText(String.valueOf(num1+num2));
					}
					else if(name.startsWith("BELT")||name.startsWith("belt"))
					{
						beltName.setText(name);
						belt.setText(value);
						
						num1 = Integer.parseInt(value);
						num2 = Integer.parseInt(wisdom.getText());
						wisdom.setText(String.valueOf(num1+num2));
					}
					else if(name.startsWith("BOOT")||name.startsWith("boot"))
					{
						bootName.setText(name);
						boot.setText(value);
						
						num1 = Integer.parseInt(value);
						num2 = Integer.parseInt(dexterity.getText());
						dexterity.setText(String.valueOf(num1+num2));
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			ArrayList<Items> newItemArrayList = new ArrayList<Items>();
			newItemArrayList.add(new Items(weaponName.getText(), Integer.parseInt(weapon.getText())));
			newItemArrayList.add(new Items(shieldName.getText(), Integer.parseInt(shield.getText())));
			newItemArrayList.add(new Items(helmetName.getText(), Integer.parseInt(helmet.getText())));
			newItemArrayList.add(new Items(armorName.getText(), Integer.parseInt(armor.getText())));
			newItemArrayList.add(new Items(ringName.getText(), Integer.parseInt(ring.getText())));
			newItemArrayList.add(new Items(beltName.getText(), Integer.parseInt(belt.getText())));
			newItemArrayList.add(new Items(bootName.getText(), Integer.parseInt(boot.getText())));
			Characters characters = new Characters(name.getText(),Integer.parseInt(level.getText()), Integer.parseInt(hitpoints.getText()),
					Integer.parseInt(movement.getText()), Integer.parseInt(strength.getText()), Integer.parseInt(defence.getText()),
					Integer.parseInt(dexterity.getText()), Integer.parseInt(wisdom.getText()),Enum.valueOf(Orientation.class, orient.getText()),
					newItemArrayList);
			
//			characterArrayList.add(characters);
			
			try {
				new SaveCharacter().saveCharacter(characters);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			};
			
			map.drawcharacterBox();
			
				jFrame2.setEnabled(true);
				jFrame.dispose();
				
//				jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				
			}
		});
		
		roll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int values = getValues();
				strength.setText(String.valueOf(values));
				values = getValues();
				dexterity.setText(String.valueOf(values));
				values = getValues();
				wisdom.setText(String.valueOf(values));
				values = getValues();
				defence.setText(String.valueOf(values));
				
			}

			private int getValues() {
				Random random = new Random();
				int[] array = new int[4];
				
				for (int i = 0; i < 4; i++) {
					array[i] = random.nextInt(6)+1;

				}
				Arrays.sort(array);
				
				return array[1]+array[2]+array[3];				
			}
		});

		
	}



}
