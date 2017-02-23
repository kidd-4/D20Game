package load;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import characters.Characters;
import characters.Items;
import enumclass.Orientation;

public class LoadCharacter {
	
//	public String loadcharacter(String string) throws IOException{
//		String filePath = "/Users/grey/Desktop/Test/Characters.txt";
//		BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
//		
//		String string2 = null;
//		String newString = null;
//		while((string2 = bufferedReader.readLine())!= null){
//			String[] strings = string2.split(" ");
//			if(string.equals(strings[0]))
//			newString = string2;
//		}
//		
//		bufferedReader.close();
//		return newString;
//	}
	
	
	public ArrayList<Characters> readCharacter() throws IOException{
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
		String filePath = "/Users/grey/Desktop/Test/Characters.txt";
		BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
		
		String string = null;
		while((string = bufferedReader.readLine())!= null){
			String[] strings = string.split(" ");
			for(int i=0;i<=20;i++)
				System.out.println(strings[i]);
			weapon = new Items(strings[7], Integer.parseInt(strings[8]));
			shield = new Items(strings[9], Integer.parseInt(strings[10]));
			helmet = new Items(strings[11], Integer.parseInt(strings[12]));
			armor = new Items(strings[13], Integer.parseInt(strings[14]));
			ring = new Items(strings[15], Integer.parseInt(strings[16]));
			belt = new Items(strings[17], Integer.parseInt(strings[18]));
			boot = new Items(strings[19], Integer.parseInt(strings[20]));
			arrayList2.add(weapon);
			arrayList2.add(shield);
			arrayList2.add(helmet);
			arrayList2.add(armor);
			arrayList2.add(ring);
			arrayList2.add(belt);
			arrayList2.add(boot);
			
			characters = new Characters(strings[0], Integer.parseInt(strings[1]), Integer.parseInt(strings[2]), 
					Integer.parseInt(strings[3]), Integer.parseInt(strings[4]), Integer.parseInt(strings[5]),
					Enum.valueOf(Orientation.class, strings[6]), arrayList2);
			
			arrayList.add(characters);
		}
		
		bufferedReader.close();
		return arrayList;
		
	}

}
