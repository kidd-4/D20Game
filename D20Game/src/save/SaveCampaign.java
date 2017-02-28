package save;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import characters.Campaigns;

public class SaveCampaign {
	
public void saveCampaign(ArrayList<Campaigns> campaignArraylist) throws IOException{
		
		File output = new File("/Users/grey/Desktop/Test/Campaigns.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(output));
        objectOutputStream.writeObject(campaignArraylist);
        objectOutputStream.flush();
        objectOutputStream.close();
}

}
