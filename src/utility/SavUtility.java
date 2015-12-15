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
			BufferedWriter out = new BufferedWriter(new FileWriter("save.sav"));
			String str = "Current Ship: 0Credits: 0Sound on: true Ship0: true Ship1: false Ship2: false Ship3: false Ship4: false";
			out.write(getXORed(str));
			out.close();
			GlobalConfig.currentShip = 0;
			GlobalConfig.credits = 0;
			GlobalConfig.isSoundOn = true;
			GlobalConfig.isBought = new boolean[5];
			for (int i = 0; i < 5; i++) {
				if (i == 0)
					GlobalConfig.isBought[i] = true;
				else
					GlobalConfig.isBought[i] = false;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void saveGame() throws NoSavFileException {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("save.sav"));
			String str = "Current Ship: " + GlobalConfig.currentShip + "Credits: " + GlobalConfig.credits + "Sound on: "
					+ GlobalConfig.isSoundOn + "Ship0: true Ship1: " + GlobalConfig.isBought[1] + "Ship2: "
					+ GlobalConfig.isBought[2] + "Ship3: " + GlobalConfig.isBought[3] + "Ship4: "
					+ GlobalConfig.isBought[4];
			out.write(getXORed(str));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new NoSavFileException();
		}
	}

	public static void loadGame() throws SavParsingException, NoSavFileException {
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File("save.sav")));
			String str = "";
			int c;
			while ((c = in.read()) != -1) {
				str += (char) c;
			}
			in.close();
			str = getXORed(str);
			int currentShip = Integer.parseInt(
					str.substring(str.indexOf("Current Ship:") + "Current Ship:".length(), str.indexOf("Credits:"))
							.trim());
			int credits = Integer.parseInt(
					str.substring(str.indexOf("Credits:") + "Credits:".length(), str.indexOf("Sound on:")).trim());
			boolean isSoundOn = Boolean.parseBoolean(
					str.substring(str.indexOf("Sound on: ") + "Sound on: ".length(), str.indexOf("Ship0: ")).trim());
			GlobalConfig.isBought = new boolean[5];
			GlobalConfig.isBought[0] = Boolean.parseBoolean(
					str.substring(str.indexOf("Ship0: ") + "Ship0: ".length(), str.indexOf("Ship1: ")).trim());
			GlobalConfig.isBought[1] = Boolean.parseBoolean(
					str.substring(str.indexOf("Ship1: ") + "Ship1: ".length(), str.indexOf("Ship2: ")).trim());
			GlobalConfig.isBought[2] = Boolean.parseBoolean(
					str.substring(str.indexOf("Ship2: ") + "Ship2: ".length(), str.indexOf("Ship3: ")).trim());
			GlobalConfig.isBought[3] = Boolean.parseBoolean(
					str.substring(str.indexOf("Ship3: ") + "Ship3: ".length(), str.indexOf("Ship4: ")).trim());
			GlobalConfig.isBought[4] = Boolean
					.parseBoolean(str.substring(str.indexOf("Ship4: ") + "Ship4: ".length()).trim());
			GlobalConfig.currentShip = currentShip;
			GlobalConfig.credits = credits;
			GlobalConfig.isSoundOn = isSoundOn;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new NoSavFileException();
		} catch (IOException e) {
			e.printStackTrace();
			throw new SavParsingException();
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
