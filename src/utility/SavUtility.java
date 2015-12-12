package utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import config.GlobalConfig;
import exception.NoSavFileException;
import exception.SavParsingException;

public class SavUtility {

	public static void createDefaultSavFile() {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("bin/save.sav"));
			String str = "Current Ship: 0Credits: 0Sound on: true";
			out.write(getXORed(str));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void saveGame() throws NoSavFileException{
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("bin/save.sav"));
			String str = "Current Ship: " + GlobalConfig.currentShip + "Credits: " + GlobalConfig.credits + "Sound on: " + GlobalConfig.isSoundOn;
			out.write(getXORed(str));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void loadGame() throws SavParsingException, NoSavFileException{
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File("bin/save.sav")));
			String str = "";
			int c;
			while((c = in.read()) != -1){
				str += (char) c;
			}
			in.close();
			str = getXORed(str);
			int currentShip = Integer.parseInt(str.substring(str.indexOf("Current Ship:") + "Current Ship:".length(), str.indexOf("Credits:")).trim());
			int credits = Integer.parseInt(str.substring(str.indexOf("Credits:") + "Credits:".length(), str.indexOf("Sound on:")).trim());
			boolean isSoundOn = Boolean.parseBoolean(str.substring(str.indexOf("Sound on: ") + "Sound on: ".length()).trim());
			GlobalConfig.currentShip = currentShip;
			GlobalConfig.credits = credits;
			GlobalConfig.isSoundOn = isSoundOn;
		} catch (FileNotFoundException e) {
			createDefaultSavFile();
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static final byte[] key = "Ac3DherRztra1ch3".getBytes();

	// This method does both encryption and decryption.
	private static String getXORed(String in) {
		byte[] inData = in.getBytes();
		for (int i = 0; i < inData.length; i++)
			inData[i] = (byte) (inData[i] ^ key[i % key.length]);
		return new String(inData);
	}
}
