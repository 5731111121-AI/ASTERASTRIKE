package logic;

import exception.NoSavFileException;
import exception.SavParsingException;
import utility.SavUtility;

public class ResourceLoader implements Runnable {

	@Override
	public void run() {
		try {
			SavUtility.loadGame();
		} catch (SavParsingException | NoSavFileException e) {
			e.printStackTrace();
			e.getMessage();
			SavUtility.createDefaultSavFile();
		}
	}

}
