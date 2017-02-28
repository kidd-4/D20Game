package load;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import characters.Campaigns;

public class LoadCampaign {
	
	Campaigns campaigns;
	
	@SuppressWarnings("unchecked")
	public ArrayList<Campaigns> readCampaign() throws IOException, ClassNotFoundException{
		
		ArrayList<Campaigns> arrayList = new ArrayList<Campaigns>();
		File input = new File("/Users/grey/Desktop/Test/Campaigns.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(input));
        arrayList = (ArrayList<Campaigns>) objectInputStream.readObject();
        objectInputStream.close();
        
        return arrayList;
	}
	
	
	public Campaigns loadCampaign(ArrayList<Campaigns> allMaps, String name){
		
		for(Campaigns c: allMaps)
		{
			if(c.getName().equals(name)){
				campaigns = c;
				break;
			}
		}
		return campaigns;
	}

}
