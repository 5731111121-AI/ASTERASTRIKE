package exception;

public class NoSavFileException extends SavException {

	public NoSavFileException() {
		super();
	}
	
	public NoSavFileException(String s) {
		super(s);
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "sav file not found.";
	}
}
