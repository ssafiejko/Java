package punktowane_bron;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import punktowane_bron.weapons.Weapon;

public class Demonstrator {

	public static void main(String[] args) {
		List<Weapon> weapons = Parser.parseWeapon("/Users/natalia/eclipse-workspace/Rejestr_broni/src/generated_weapon.txt");
		Map<String,Weapon> calibersguns = Parser.Grouper(weapons);
		Parser.Fileswriter(calibersguns);

	}

}
