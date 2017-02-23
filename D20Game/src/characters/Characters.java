package characters;



import java.util.ArrayList;
import enumclass.Orientation;

public class Characters {
	Orientation orient;//hostile or friendly
	public String name;

	public int level;
	public int hitpoints;
	public int movement;

	public int strength;
	public int dexterity;//敏捷
//	public int constitution;
	public int wisdom;
//	public int intelligence;
//	public int charisma;//魅力
	
	public int armorclass;
	public int attackbonus;
	public int damagebonus;

	// mod value = ability value / 3
	public int modStr;
	public int modDex;
	public int modCon;
	public int modInt;
	public int modWis;
	public int modCha;

//	public Items[] inventory;
//	public Items[] backpack;
	public ArrayList<Items> arrayList;
	public Items weapon;
	public Items shield;
	public Items helmet;
	public Items armor;
	public Items ring;
	public Items belt;
	public Items boots;
	
	public Characters() {
	}

	public Characters(String name,int level,int hitpoints,int strength,int dexterity,int wisdom,
			Orientation orient,ArrayList<Items> arrayList) {

		this.name = name;
		this.level = level;
		this.hitpoints = hitpoints;
		this.strength = strength;
		this.dexterity = dexterity;
		this.wisdom = wisdom;
		this.orient = orient;
		this.arrayList = arrayList;
		
//		level = 1;
//		hitpoints = -1;
//		movement = fourD6() / 6;
//
//		strength = fourD6();
//		dexterity = fourD6();
//		constitution = fourD6();
//		wisdom = fourD6();
//		intelligence = fourD6();
//		charisma = fourD6();

		modStr = strength / 3;
		modDex = dexterity / 3;
		modWis = wisdom / 3;
//		modCha = charisma / 3;
//		modCon = constitution / 3;
//		modInt = intelligence / 3;

//		inventory = new Items[10];
//		backpack = new Items[1000];

//		for (int i = 0; i < 10; i++) {
//			inventory[i] = new Items();
//		}
//
//		weapon = new Items();
//		shield = new Items();
//		helmet = new Items();
//		armor = new Items();
//		ring = new Items();
//		belt = new Items();
//		boots = new Items();

	}

	public Orientation getOrient() {
		return orient;
	}

	public void setOrient(Orientation orient) {
		this.orient = orient;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getHitpoints() {
		return hitpoints;
	}

	public void setHitpoints(int hitpoints) {
		this.hitpoints = hitpoints;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public int getWisdom() {
		return wisdom;
	}
	
	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}

	public ArrayList<Items> getArrayList() {
		return arrayList;
	}

	public void setArrayList(ArrayList<Items> arrayList) {
		this.arrayList = arrayList;
	}

	

}
