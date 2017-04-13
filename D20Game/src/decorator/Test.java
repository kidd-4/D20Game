package decorator;

import enumclass.Enchantment;

public class Test {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Weapon weapon = new Empty();
		
		
		weapon = new Freezing(weapon);
		weapon.add(Enum.valueOf(Enchantment.class, "Freezing"));
		System.out.println(weapon.arrayList.get(0));
//		System.out.println(weapon.arrayList.get(1));
		System.out.println(weapon.arrayList.size());
		
		weapon = new Burning(weapon);
		weapon.add(Enum.valueOf(Enchantment.class, "Burning"));
		System.out.println(weapon.arrayList.get(0));
		System.out.println(weapon.arrayList.get(1));
//		System.out.println(weapon.arrayList.get(2));
//		System.out.println(weapon.arrayList.get(3));
		System.out.println(weapon.arrayList.size());
		
		
		weapon = new Slaying(weapon);
		weapon.add(Enum.valueOf(Enchantment.class, "Slaying"));
		System.out.println(weapon.arrayList.get(0));
		System.out.println(weapon.arrayList.get(1));
		System.out.println(weapon.arrayList.get(2));
		System.out.println(weapon.arrayList.size());
	}

}
