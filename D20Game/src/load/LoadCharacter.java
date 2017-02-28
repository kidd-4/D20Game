package load;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import characters.Characters;
import characters.Items;
/**
 * LoadCharacter class contains method which return the variable in the character
 * @author grey
 *@version 1.0
 */
public class LoadCharacter {
	ArrayList<Items> inventory = new ArrayList<Items>();
	ArrayList<Items> backpack = new ArrayList<Items>();
	Characters characters;
	Items weapon;
	Items shield;
	Items helmet;
	Items armor;
	Items ring;
	Items belt;
	Items boot;
	Items backpack1;
	Items backpack2;
	Items backpack3;
	Items backpack4;
	Items backpack5;
	Items backpack6;
	Items backpack7;
	Items backpack8;
	Items backpack9;
	Items backpack10;

	/**
	 * when we create the map, we need to add specific character with the name on the JComBox by using this method
	 * @param string  name
	 * @param characterArrayList  ArrayList<Characters>
	 * @return Characters object
	 * @throws IOException  IOException
	 */
	//在创建地图时，需要加入创建好的人物，这个时候需要将下拉框的名字和文件中的名字对应，返回对应的人物对象。(MapListener)
	public Characters loadcharacter(String string, ArrayList<Characters> characterArrayList) throws IOException{
//		String filePath = "/Users/grey/Desktop/Test/Characters.txt";
//		BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
//		
//		String string2 = null;
//		while((string2 = bufferedReader.readLine())!= null){
//			String[] strings = string2.split(" ");
//			if(string.equals(strings[0])){
//				weapon = new Items(strings[20], Integer.parseInt(strings[21]));
//				shield = new Items(strings[22], Integer.parseInt(strings[23]));
//				helmet = new Items(strings[24], Integer.parseInt(strings[25]));
//				armor = new Items(strings[26], Integer.parseInt(strings[27]));
//				ring = new Items(strings[28], Integer.parseInt(strings[29]));
//				belt = new Items(strings[30], Integer.parseInt(strings[31]));
//				boot = new Items(strings[32], Integer.parseInt(strings[33]));
//				inventory.add(weapon);
//				inventory.add(shield);
//				inventory.add(helmet);
//				inventory.add(armor);
//				inventory.add(ring);
//				inventory.add(belt);
//				inventory.add(boot);
//				
//				backpack1 = new Items(strings[34], Integer.parseInt(strings[35]));
//				backpack2 = new Items(strings[36], Integer.parseInt(strings[37]));
//				backpack3 = new Items(strings[38], Integer.parseInt(strings[39]));
//				backpack4 = new Items(strings[40], Integer.parseInt(strings[41]));
//				backpack5 = new Items(strings[42], Integer.parseInt(strings[43]));
//				backpack6 = new Items(strings[44], Integer.parseInt(strings[45]));
//				backpack7 = new Items(strings[46], Integer.parseInt(strings[47]));
//				backpack8 = new Items(strings[48], Integer.parseInt(strings[49]));
//				backpack9 = new Items(strings[50], Integer.parseInt(strings[51]));
//				backpack10 = new Items(strings[52], Integer.parseInt(strings[53]));
//				
//				backpack.add(backpack1);
//				backpack.add(backpack2);
//				backpack.add(backpack3);
//				backpack.add(backpack4);
//				backpack.add(backpack5);
//				backpack.add(backpack6);
//				backpack.add(backpack7);
//				backpack.add(backpack8);
//				backpack.add(backpack9);
//				backpack.add(backpack10);
//				
//				characters = new Characters(strings[0], Integer.parseInt(strings[1]), Integer.parseInt(strings[2]), 
//						Integer.parseInt(strings[3]), Integer.parseInt(strings[4]), Integer.parseInt(strings[5]),
//						Integer.parseInt(strings[6]),Integer.parseInt(strings[7]), Integer.parseInt(strings[8]),
//						Integer.parseInt(strings[9]), Integer.parseInt(strings[10]), Integer.parseInt(strings[11]), 
//						Integer.parseInt(strings[12]),Integer.parseInt(strings[13]),Integer.parseInt(strings[14]), 
//						Integer.parseInt(strings[15]),Enum.valueOf(Orientation.class, strings[16]),Integer.parseInt(strings[17]), 
//						Integer.parseInt(strings[18]), Integer.parseInt(strings[19]), inventory,backpack);
//			}
//			
//		}
//		
//		bufferedReader.close();
		for(Characters characters2:characterArrayList){
			if(characters2.getName().equals(string)){
				characters = characters2;
				break;
			}
		}
		return characters;
	}
	
	/**
	 * read all characters which are created
	 * @return ArrayList<Characters> 
	 * @throws IOException  IOException
	 * @throws ClassNotFoundException ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Characters> readCharacter() throws IOException, ClassNotFoundException{
		
		ArrayList<Characters> arrayList = new ArrayList<Characters>();
		File input = new File("/Users/grey/Desktop/Test/Characters.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(input));
        arrayList = (ArrayList<Characters>) objectInputStream.readObject();
        objectInputStream.close();
        
        return arrayList;
	}
	
	//显示主界面中的下拉框中的人物列表
//	public ArrayList<Characters> readCharacter() throws IOException{
//		
//		String filePath = "/Users/grey/Desktop/Test/Characters.txt";
//		BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
//		
//		String string = null;
//		while((string = bufferedReader.readLine())!= null){
//			String[] strings = string.split(" ");
//			
//			weapon = new Items(strings[20], Integer.parseInt(strings[21]));
//			shield = new Items(strings[22], Integer.parseInt(strings[23]));
//			helmet = new Items(strings[24], Integer.parseInt(strings[25]));
//			armor = new Items(strings[26], Integer.parseInt(strings[27]));
//			ring = new Items(strings[28], Integer.parseInt(strings[29]));
//			belt = new Items(strings[30], Integer.parseInt(strings[31]));
//			boot = new Items(strings[32], Integer.parseInt(strings[33]));
//			inventory.add(weapon);
//			inventory.add(shield);
//			inventory.add(helmet);
//			inventory.add(armor);
//			inventory.add(ring);
//			inventory.add(belt);
//			inventory.add(boot);
//			
//			backpack1 = new Items(strings[34], Integer.parseInt(strings[35]));
//			backpack2 = new Items(strings[36], Integer.parseInt(strings[37]));
//			backpack3 = new Items(strings[38], Integer.parseInt(strings[39]));
//			backpack4 = new Items(strings[40], Integer.parseInt(strings[41]));
//			backpack5 = new Items(strings[42], Integer.parseInt(strings[43]));
//			backpack6 = new Items(strings[44], Integer.parseInt(strings[45]));
//			backpack7 = new Items(strings[46], Integer.parseInt(strings[47]));
//			backpack8 = new Items(strings[48], Integer.parseInt(strings[49]));
//			backpack9 = new Items(strings[50], Integer.parseInt(strings[51]));
//			backpack10 = new Items(strings[52], Integer.parseInt(strings[53]));
//			
//			backpack.add(backpack1);
//			backpack.add(backpack2);
//			backpack.add(backpack3);
//			backpack.add(backpack4);
//			backpack.add(backpack5);
//			backpack.add(backpack6);
//			backpack.add(backpack7);
//			backpack.add(backpack8);
//			backpack.add(backpack9);
//			backpack.add(backpack10);
//			
//			characters = new Characters(strings[0], Integer.parseInt(strings[1]), Integer.parseInt(strings[2]), 
//					Integer.parseInt(strings[3]), Integer.parseInt(strings[4]), Integer.parseInt(strings[5]),
//					Integer.parseInt(strings[6]),Integer.parseInt(strings[7]), Integer.parseInt(strings[8]),
//					Integer.parseInt(strings[9]), Integer.parseInt(strings[10]), Integer.parseInt(strings[11]), 
//					Integer.parseInt(strings[12]),Integer.parseInt(strings[13]),Integer.parseInt(strings[14]), 
//					Integer.parseInt(strings[15]),Enum.valueOf(Orientation.class, strings[16]),Integer.parseInt(strings[17]), 
//					Integer.parseInt(strings[18]), Integer.parseInt(strings[19]), inventory,backpack);
//			
//			arrayList.add(characters);
//		}
//		
//		bufferedReader.close();
//		return arrayList;
//		
//	}
	/**
	 * display all the items in the backpack of Player
	 * @param characterArrayList
	 * @return ArrayList<Items>
	 * @throws IOException
	 */
	//显示主界面的backpack items
	public ArrayList<Items> readBackpack(ArrayList<Characters> characterArrayList) throws IOException{
		
		for(Characters characters: characterArrayList){
			if(characters.getName().startsWith("P")||characters.getName().startsWith("p")){
				backpack = characters.getBackpack();
				break;
			}
		}
		return backpack;
		
//		String filePath = "/Users/grey/Desktop/Test/Characters.txt";
//		BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
//		
//		String string = null;
//		while((string = bufferedReader.readLine())!= null){
//			String[] strings = string.split(" ");
//			if(strings[0].startsWith("P")||strings[0].startsWith("p"))
//			{
//				backpack1 = new Items(strings[34], Integer.parseInt(strings[35]));
//				backpack2 = new Items(strings[36], Integer.parseInt(strings[37]));
//				backpack3 = new Items(strings[38], Integer.parseInt(strings[39]));
//				backpack4 = new Items(strings[40], Integer.parseInt(strings[41]));
//				backpack5 = new Items(strings[42], Integer.parseInt(strings[43]));
//				backpack6 = new Items(strings[44], Integer.parseInt(strings[45]));
//				backpack7 = new Items(strings[46], Integer.parseInt(strings[47]));
//				backpack8 = new Items(strings[48], Integer.parseInt(strings[49]));
//				backpack9 = new Items(strings[50], Integer.parseInt(strings[51]));
//				backpack10 = new Items(strings[52], Integer.parseInt(strings[53]));
//				
//				backpack.add(backpack1);
//				backpack.add(backpack2);
//				backpack.add(backpack3);
//				backpack.add(backpack4);
//				backpack.add(backpack5);
//				backpack.add(backpack6);
//				backpack.add(backpack7);
//				backpack.add(backpack8);
//				backpack.add(backpack9);
//				backpack.add(backpack10);
//				
//			}
//		}
//		
//		bufferedReader.close();
		
		
	}

}
