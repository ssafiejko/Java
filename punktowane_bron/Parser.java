package punktowane_bron;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import punktowane_bron.weapons.Weapon;

public class Parser {
	public static List<Weapon> parseWeapon(String path){
		LinkedList<Weapon> weapons= new LinkedList<Weapon>();
		
		
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path),StandardCharsets.UTF_8))) {
			while (reader.ready()) {
				try {
					String line= reader.readLine();
					weapons.add(new Weapon(line));
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return weapons;
		
		
	}

	
	
	public static Map<String,Weapon> Grouper(List<Weapon> weapons) {
		
		Map<String, Weapon> calibersguns= new HashMap<>();
		for (Weapon w: weapons) {
			
				calibersguns.put(w.getCaliber().getValue(), w);
			
			
			w.getCaliber().getValue();
		}
		
		return calibersguns;
	}
	
	
	public static void Fileswriter(Map<String,Weapon> calibersguns) {
		for (String e: calibersguns.keySet()) {
			try (FileOutputStream file = new FileOutputStream("/Users/natalia/Desktop/serializacjabroni/" + e)) {
				ObjectOutputStream out = new ObjectOutputStream(file);
				out.writeObject(calibersguns.get(e).toString());
				
			} catch (FileNotFoundException p) {
				p.printStackTrace();
			} catch(IOException p) {
				p.printStackTrace();
			}
		}
	
	
	File file1= new File("/Users/natalia/Desktop/serializacjabroni");
	int counter= file1.listFiles().length;
	
	for (int i =0; i<counter; i++) {
	try(FileInputStream fileInputStream = new FileInputStream(file1.listFiles()[i])){
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		Object readObject = objectInputStream.readObject();
		if(readObject instanceof String) {
			String readString = (String)readObject;
			System.out.println("Read string: " + readString);
		}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}}

}}
