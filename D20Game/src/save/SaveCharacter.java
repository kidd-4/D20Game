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
			bufferedWriter.write(String.valueOf(characters.getModStr())+" ");
			bufferedWriter.write(String.valueOf(characters.getDexterity())+" ");
			bufferedWriter.write(String.valueOf(characters.getModDex())+" ");
			bufferedWriter.write(String.valueOf(characters.getConstitution())+" ");
			bufferedWriter.write(String.valueOf(characters.getModCon())+" ");
			bufferedWriter.write(String.valueOf(characters.getWisdom())+" ");
			bufferedWriter.write(String.valueOf(characters.getModWis())+" ");
			bufferedWriter.write(String.valueOf(characters.getIntelligence())+" ");
			bufferedWriter.write(String.valueOf(characters.getModInt())+" ");
			bufferedWriter.write(String.valueOf(characters.getCharisma())+" ");
			bufferedWriter.write(String.valueOf(characters.getModCha())+" ");
			bufferedWriter.write(characters.getOrient().toString()+" ");
			bufferedWriter.write(String.valueOf(characters.getArmorClass())+" ");
			bufferedWriter.write(String.valueOf(characters.getAttackBonus())+" ");
			bufferedWriter.write(String.valueOf(characters.getDamageBonus())+" ");
			
			for(Items items: characters.getInventory()){
				bufferedWriter.write(items.getName()+" "+items.getValue()+" ");
			}
			
			for(Items items: characters.getBackpack()){
				bufferedWriter.write(items.getName()+" "+items.getValue()+" ");
			}
			
			bufferedWriter.flush();
			bufferedWriter.newLine();
		
		
		
		bufferedWriter.close();
		
	}

}
