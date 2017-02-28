package save;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import characters.Items;
/**
 * SaveItem class is used to save the items to the file
 * @author grey
 *	@version 1.0
 */
public class SaveItem {

	/**
	 * save method
	 * @param arrayList  ArrayList<Items>
	 * @throws IOException
	 */
	public void saveItem(ArrayList<Items> arrayList) throws IOException{
		
		File output = new File("/Users/grey/Desktop/Test/Items.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(output));
        objectOutputStream.writeObject(arrayList);
        objectOutputStream.flush();
        objectOutputStream.close();
        
//		String filePath = "/Users/grey/Desktop/Test/Items.txt"; //save different maps
//		BufferedWriter bufferedWriter  = new BufferedWriter(new FileWriter(filePath));
//		
//		for(Items items:arrayList){
//			bufferedWriter.write(items.getName()+" "+items.getValue());
//			bufferedWriter.flush();
//			bufferedWriter.newLine();
//		}
//		
//		
//		bufferedWriter.close();
		
	}
}
