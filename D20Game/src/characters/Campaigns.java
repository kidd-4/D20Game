package characters;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Campaigns implements Serializable{
	
	public ArrayList<Matrix> campaign;
	public String name;
	

	public Campaigns(ArrayList<Matrix> campaign,String name){
		this.campaign = campaign;
		this.name = name;
	}

	public ArrayList<Matrix> getCampaign() {
		return campaign;
	}

	public void setCampaign(ArrayList<Matrix> campaign) {
		this.campaign = campaign;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
