package save;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import characters.Characters;
import characters.Items;

public class SaveCharacter {
	
	public void saveCharacter(Characters characters) throws IOException{
		String filePath = "/Users/grey/Desktop/Test/Characters.txt"; //save different maps
		BufferedWriter bufferedWriter  = new BufferedWriter(new FileWriter(filePath,true));
		
			bufferedWriter.write(characters.getName()+" ");
			bufferedWriter.write(String.valueOf(characters.getLevel())+" ");
			bufferedWriter.write(String.valueOf(characters.getHitpoints())+" ");
			bufferedWriter.write(String.valueOf(characters.getMovement())+" ");
			bufferedWriter.write(String.valueOf(characters.getStrength())+" ");
			bufferedWriter.write(String.valueOf(characters.getDefence())+" ");
			bufferedWriter.write(String.valueOf(characters.getDexterity())+" ");
			bufferedWriter.write(String.valueOf(characters.getWisdom())+" ");
			bufferedWriter.write(characters.getOrient().toString()+" ");
			
			for(Items items: characters.getArrayList()){
				bufferedWriter.write(items.getName()+" "+items.getValue()+" ");
			}
			
			bufferedWriter.flush();
			bufferedWriter.newLine();
		
		
		
		bufferedWriter.close();
		
	}

}
