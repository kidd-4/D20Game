package save;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import characters.Characters;
/**
 * SaveCharacter class is used to save the characters to the file
 * @author grey
 * @version 1.0
 */
public class SaveCharacter {
	/**
	 * save method
	 * @param arrayList ArrayList<Characters>
	 * @throws IOException
	 */
	public void saveCharacter(ArrayList<Characters> arrayList) throws IOException{
		File output = new File("/Users/grey/Desktop/Test/Characters.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(output));
        objectOutputStream.writeObject(arrayList);
        objectOutputStream.flush();
        objectOutputStream.close();
	}
	


}
