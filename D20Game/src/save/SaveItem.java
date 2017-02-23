package save;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import characters.Items;

public class SaveItem {

	public void saveItem(ArrayList<Items> arrayList) throws IOException{
		String filePath = "/Users/grey/Desktop/Test/Items.txt"; //save different maps
		BufferedWriter bufferedWriter  = new BufferedWriter(new FileWriter(filePath));
		
		for(Items items:arrayList){
			bufferedWriter.write(items.getName()+" "+items.getValue());
			bufferedWriter.flush();
			bufferedWriter.newLine();
		}
		
		
		bufferedWriter.close();
		
	}
}
