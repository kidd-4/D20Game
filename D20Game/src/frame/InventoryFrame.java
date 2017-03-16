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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import load.LoadCharacter;
import objects.Characters;
import objects.Items;
import observer.CharacterObserver;
import save.SaveCharacter;

public class InventoryFrame {
	public JComboBox<String> backpackBox= new JComboBox<String>();// show backpack of Player
	public JLabel backpackBoxLabel =  new JLabel("Backpack");
	public JButton equip = new JButton("Equip item");
	public ArrayList<Items> backpack = new ArrayList<Items>();
	public ArrayList<Characters> characterArrayList = new ArrayList<Characters>();
	public Characters character;
	
	public InventoryFrame(Map map, JFrame jFrame2, ArrayList<Characters> characterArrayList, Characters character){
		
		this.characterArrayList = characterArrayList;
		this.character = character;
		JFrame jFrame = new JFrame("Backpack");
		drawBackpackBox();
		
		jFrame.setLayout(new FlowLayout());
		jFrame.add(backpackBoxLabel);
		jFrame.add(backpackBox);
		jFrame.add(equip);
		jFrame.setLocationRelativeTo(null);//put the screen in the center
		jFrame.setSize(new Dimension(300, 300));
		jFrame.setVisible(true);
		jFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				jFrame.dispose();
				jFrame2.setEnabled(true);
			}
		});
		
		//把backpack中的装备换到inventory中，并改变人物的属性
		 // equip selected item in the backpack to the inventory
		 equip.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String backpackString = backpackBox.getSelectedItem().toString();
				String invetoryString = null;
				
				//eliminate number using regular expression
				String[] strings = backpackString.split("\\d");//正则表达式去除数字
				
				int backpackValue = 0;
				int inventoryValue = 0;
				Characters oldCharacter = null;
				
				//必须是玩家的名字
				// it must be the Player's name
				if(character.getName().startsWith("P")||character.getName().startsWith("p"))
					oldCharacter = character;
				else
					JOptionPane.showMessageDialog(null, "Please choose a player", "Alert", JOptionPane.ERROR_MESSAGE);
				
				if(oldCharacter != null){
				
				// 获得backpack物品的value
				// get value of selected item in the backpack
				for(Items backpack: oldCharacter.getBackpack()){
					if(backpack.getName().equals(backpackString)){
						backpackValue = backpack.getValue();
					}
				}
				
				// 在inventory中寻找和backpack中对应的物品，如果有，则返回对应物品，如果无，就返回空
				/* search corresponding item in the inventory with the same type of selected one.
				 * if exsit, return the item. if not, return empty
				*/
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
				// change the the item in the backpack to the item of inventory
				for(Items backpack:oldCharacter.getBackpack()){
					//如果有两个相同名字的物品，则会出问题 break可以解决问题
					if(backpack.getName().equals(backpackString)){
						backpack.setName(invetoryString);
						backpack.setValue(inventoryValue);
						break;
					}
				}
				
				//将inventory中的物品换成backpack中的物品，并修改对应的属性
				// change the item in the inventory to the item of backpack and change the attribute of player
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
				// delete original player and save the edited one
//				for(Characters characters: characterArrayList){
//					if(characters.getName().startsWith("P")||characters.getName().startsWith("p")){
//						
////						characterArrayList.remove(characters);
//						break;
//					}
//				}
				
				//替代原有的character
				int index = characterArrayList.indexOf(oldCharacter);
				characterArrayList.set(index,oldCharacter);
				
				try {
					new SaveCharacter().saveCharacter(characterArrayList);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				}
				
				CharacterObserver characterObserver = new CharacterObserver(map);
				characterObserver.start();
//				map.drawInformation();
				drawBackpackBox();
				
			}
		});
		 
		
		
		
	}
	
	 /**
	 * show the backpack of Player
	 */
	
	public void drawBackpackBox() {
		backpackBox.removeAllItems(); // remove original item list
		
		try {
			backpack = new LoadCharacter().readBackpack(characterArrayList,character); // get the item list from file
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(Items items:backpack)
		{
			backpackBox.addItem(items.getName());
		}
	}
	
	

}
