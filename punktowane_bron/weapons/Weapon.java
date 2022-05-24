package punktowane_bron.weapons;

import java.util.Scanner;



public class Weapon {
	private String name;
	private Caliber caliber;
	private int serialNumber;
	private String unfit;
	private boolean hasFingerprints;
	
	public Weapon(String line) {
		Scanner scanner= new Scanner(line);
		scanner.useDelimiter(";");
		
		try {
			this.name= scanner.next();
			this.caliber=new Caliber(scanner.next());
			String serialNumber_help= scanner.next();
			this.serialNumber= Integer.parseInt((serialNumber_help.split(":"))[1]);
			this.unfit=scanner.next();
			this.hasFingerprints=scanner.nextBoolean();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(line);
			scanner.close();
			
		}
		
	}
	
	
	
	//@Override
	public double compareTo(Weapon o) {
	String value1= this.caliber.getValue();
	String value2= o.caliber.getValue();
		return Double.parseDouble(value1)- Double.parseDouble(value2);
		
	}
	@Override
	public String toString() {
		return "Weapon [name=" + name + ", caliber=" + caliber + ", serialNumber=" + serialNumber + ", unfit=" + unfit
				+ ", hasFingerprints=" + hasFingerprints + "]";
	}



	public Caliber getCaliber() {
		return caliber;
	}
	
	
	

}
