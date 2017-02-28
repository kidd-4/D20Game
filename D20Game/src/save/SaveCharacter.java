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
	
//	public void saveCharacter(Characters characters) throws IOException{
//		String filePath = "/Users/grey/Desktop/Test/Characters.txt"; //save different maps
//		BufferedWriter bufferedWriter  = new BufferedWriter(new FileWriter(filePath,true));
//		
//			bufferedWriter.write(characters.getName()+" ");
//			bufferedWriter.write(String.valueOf(characters.getLevel())+" ");
//			bufferedWriter.write(String.valueOf(characters.getHitpoints())+" ");
//			bufferedWriter.write(String.valueOf(characters.getMovement())+" ");
//			bufferedWriter.write(String.valueOf(characters.getStrength())+" ");
//			bufferedWriter.write(String.valueOf(characters.getModStr())+" ");
//			bufferedWriter.write(String.valueOf(characters.getDexterity())+" ");
//			bufferedWriter.write(String.valueOf(characters.getModDex())+" ");
//			bufferedWriter.write(String.valueOf(characters.getConstitution())+" ");
//			bufferedWriter.write(String.valueOf(characters.getModCon())+" ");
//			bufferedWriter.write(String.valueOf(characters.getWisdom())+" ");
//			bufferedWriter.write(String.valueOf(characters.getModWis())+" ");
//			bufferedWriter.write(String.valueOf(characters.getIntelligence())+" ");
//			bufferedWriter.write(String.valueOf(characters.getModInt())+" ");
//			bufferedWriter.write(String.valueOf(characters.getCharisma())+" ");
//			bufferedWriter.write(String.valueOf(characters.getModCha())+" ");
//			bufferedWriter.write(characters.getOrient().toString()+" ");
//			bufferedWriter.write(String.valueOf(characters.getArmorClass())+" ");
//			bufferedWriter.write(String.valueOf(characters.getAttackBonus())+" ");
//			bufferedWriter.write(String.valueOf(characters.getDamageBonus())+" ");
//			
//			for(Items items: characters.getInventory()){
//				bufferedWriter.write(items.getName()+" "+items.getValue()+" ");
//			}
//			
//			for(Items items: characters.getBackpack()){
//				bufferedWriter.write(items.getName()+" "+items.getValue()+" ");
//			}
//			
//			bufferedWriter.flush();
//			bufferedWriter.newLine();
//		
//		
//		
//		bufferedWriter.close();
//		
//	}

}
