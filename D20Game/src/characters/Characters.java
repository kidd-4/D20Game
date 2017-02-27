package characters;



import java.io.Serializable;
import java.util.ArrayList;
import enumclass.Orientation;

@SuppressWarnings("serial")
public class Characters implements Serializable {
	Orientation orient;//hostile or friendly
	public String name;

	public int level;
	public int hitpoints; // hitpoints = 10*level + constitution
	public int movement;

	public int strength;
	public int dexterity;//敏捷
	public int constitution;//体质
	public int wisdom;
	public int intelligence;
	public int charisma;//魅力

	
	
	public int armorClass; // armorClass = modDex+armor+shield
	public int attackBonus; //attackBonus = level + modStr
	public int damageBonus;//damageBonus = modStr + weapon

	// mod value = ability value / 3
	public int modStr;
	public int modDex;
	public int modCon;
	public int modInt;
	public int modWis;
	public int modCha;

	
	public ArrayList<Items> inventory; // worn items arraylist
	public ArrayList<Items> backpack; //maximum 10 items
	public Items weapon;	// increase damage bonus
	public Items shield; //increase armor class
	public Items helmet; //increase intelligence
	public Items armor;  // increase armor class
	public Items ring; // increase wisdom
	public Items belt; // increase strength
	public Items boots; // increase dexterity
	
	public Characters() {
	}

	public Characters(String name,int level,int hitpoints,int movement,int strength,int modStr,int dexterity,int modDex,
			int constitution,int modCon,int wisdom,int modWis,int intelligence,int modInt,int charisma,int modCha,
			Orientation orient,int armorClass,int attackBonus,int damageBonus,ArrayList<Items> inventory,ArrayList<Items> backpack) {

		this.name = name;
		this.level = level;
		this.hitpoints = hitpoints;
		this.movement = movement;
		this.strength = strength;
		this.constitution = constitution;
		this.intelligence = intelligence;
		this.charisma = charisma;
		this.dexterity = dexterity;
		this.wisdom = wisdom;
		this.orient = orient;
		this.armorClass = armorClass;
		this.attackBonus = attackBonus;
		this.damageBonus = damageBonus;
		this.inventory = inventory;
		this.backpack = backpack;
		
		this.modCha = modCha;
		this.modCon = modCon;
		this.modDex = modDex;
		this.modInt = modInt;
		this.modStr = modStr;
		this.modWis = modWis;

	}

	public int getConstitution() {
		return constitution;
	}

	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getCharisma() {
		return charisma;
	}

	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}

	public int getArmorClass() {
		return armorClass;
	}

	public void setArmorClass(int armorClass) {
		this.armorClass = armorClass;
	}

	public int getAttackBonus() {
		return attackBonus;
	}

	public void setAttackBonus(int attackBonus) {
		this.attackBonus = attackBonus;
	}

	public int getDamageBonus() {
		return damageBonus;
	}

	public void setDamageBonus(int damageBonus) {
		this.damageBonus = damageBonus;
	}

	public int getModStr() {
		return modStr;
	}

	public void setModStr(int modStr) {
		this.modStr = modStr;
	}

	public int getModDex() {
		return modDex;
	}

	public void setModDex(int modDex) {
		this.modDex = modDex;
	}

	public int getModCon() {
		return modCon;
	}

	public void setModCon(int modCon) {
		this.modCon = modCon;
	}

	public int getModInt() {
		return modInt;
	}

	public void setModInt(int modInt) {
		this.modInt = modInt;
	}

	public int getModWis() {
		return modWis;
	}

	public void setModWis(int modWis) {
		this.modWis = modWis;
	}

	public int getModCha() {
		return modCha;
	}

	public void setModCha(int modCha) {
		this.modCha = modCha;
	}

	public int getMovement() {
		return movement;
	}

	public void setMovement(int movement) {
		this.movement = movement;
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

	public ArrayList<Items> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<Items> inventory) {
		this.inventory = inventory;
	}

	public ArrayList<Items> getBackpack() {
		return backpack;
	}

	public void setBackpack(ArrayList<Items> backpack) {
		this.backpack = backpack;
	}

	

}
