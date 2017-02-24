package load;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import characters.Characters;
import characters.Items;
import enumclass.Orientation;

public class LoadCharacter {
	ArrayList<Characters> arrayList = new ArrayList<Characters>();
	ArrayList<Items> arrayList2 = new ArrayList<Items>();
	Items weapon;
	Items shield;
	Items helmet;
	Items armor;
	Items ring;
	Items belt;
	Items boot;
	Characters characters;
	//在创建地图时，需要加入创建好的人物，这个时候需要将下拉框的名字和文件中的名字对应，回返对应的人物对象。(MapListener)
	public Characters loadcharacter(String string) throws IOException{
		String filePath = "/Users/grey/Desktop/Test/Characters.txt";
		BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
		
		String string2 = null;
		while((string2 = bufferedReader.readLine())!= null){
			String[] strings = string2.split(" ");
			if(string.equals(strings[0])){
				weapon = new Items(strings[9], Integer.parseInt(strings[10]));
				shield = new Items(strings[11], Integer.parseInt(strings[12]));
				helmet = new Items(strings[13], Integer.parseInt(strings[14]));
				armor = new Items(strings[15], Integer.parseInt(strings[16]));
				ring = new Items(strings[17], Integer.parseInt(strings[18]));
				belt = new Items(strings[19], Integer.parseInt(strings[20]));
				boot = new Items(strings[21], Integer.parseInt(strings[22]));
				arrayList2.add(weapon);
				arrayList2.add(shield);
				arrayList2.add(helmet);
				arrayList2.add(armor);
				arrayList2.add(ring);
				arrayList2.add(belt);
				arrayList2.add(boot);
				
				characters = new Characters(strings[0], Integer.parseInt(strings[1]), Integer.parseInt(strings[2]), 
						Integer.parseInt(strings[3]), Integer.parseInt(strings[4]), Integer.parseInt(strings[5]),
						Integer.parseInt(strings[6]),Integer.parseInt(strings[7]), Enum.valueOf(Orientation.class, strings[8]), arrayList2);
			}
			
		}
		
		bufferedReader.close();
		return characters;
	}
	
	//显示主界面中的下拉框中的人物列表
	public ArrayList<Characters> readCharacter() throws IOException{
		
		String filePath = "/Users/grey/Desktop/Test/Characters.txt";
		BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
		
		String string = null;
		while((string = bufferedReader.readLine())!= null){
			String[] strings = string.split(" ");
			
			weapon = new Items(strings[9], Integer.parseInt(strings[10]));
			shield = new Items(strings[11], Integer.parseInt(strings[12]));
			helmet = new Items(strings[13], Integer.parseInt(strings[14]));
			armor = new Items(strings[15], Integer.parseInt(strings[16]));
			ring = new Items(strings[17], Integer.parseInt(strings[18]));
			belt = new Items(strings[19], Integer.parseInt(strings[20]));
			boot = new Items(strings[21], Integer.parseInt(strings[22]));
			arrayList2.add(weapon);
			arrayList2.add(shield);
			arrayList2.add(helmet);
			arrayList2.add(armor);
			arrayList2.add(ring);
			arrayList2.add(belt);
			arrayList2.add(boot);
			
			characters = new Characters(strings[0], Integer.parseInt(strings[1]), Integer.parseInt(strings[2]), 
					Integer.parseInt(strings[3]), Integer.parseInt(strings[4]), Integer.parseInt(strings[5]),
					Integer.parseInt(strings[6]),Integer.parseInt(strings[7]),Enum.valueOf(Orientation.class, strings[8]), arrayList2);
			
			arrayList.add(characters);
		}
		
		bufferedReader.close();
		return arrayList;
		
	}

}
