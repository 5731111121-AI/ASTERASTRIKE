package exception;

public class NoSavFileException extends SavException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
