package load;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import characters.Items;

public class LoadItem {
	
	public String loadItem(String string) throws IOException{
		String filePath = "/Users/grey/Desktop/Test/Items.txt";
		BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
		
		String string2 = null;
		String newString = null;
		while((string2 = bufferedReader.readLine())!= null){
			String[] strings = string2.split(" ");
			if(string.equals(strings[0]))
			newString = string2;
		}
		
		bufferedReader.close();
		return newString;
		
	}
	
	public ArrayList<Items> readItem() throws IOException{
		ArrayList<Items> arrayList = new ArrayList<Items>();
		Items items;
		String filePath = "/Users/grey/Desktop/Test/Items.txt";
		BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
		
		String string = null;
		while((string = bufferedReader.readLine())!= null){
			String[] strings = string.split(" ");
			items = new Items(strings[0], Integer.parseInt(strings[1]));
			arrayList.add(items);
		}
		
		bufferedReader.close();
		return arrayList;
		
	}

}
