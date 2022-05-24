package punktowane_bron.weapons;

import java.util.Scanner;

public class Caliber {
	private String value;
	private String additionalValue;
	
	
	public Caliber(String line) {
		Scanner scanner= new Scanner(line);
		int counter;
		counter= line.split(" ").length;
		this.value= scanner.next();
		if (counter==2) {
			this.additionalValue= scanner.next();
			
		}
	}


	public String getValue() {
		return this.value;
	}


	public String getAdditionalValue() {
		return additionalValue;
	}


	@Override
	public String toString() {
		return "Caliber [value=" + value + ", additionalValue=" + additionalValue + "]";
	}
	
	
	

}
