package exception;

public class SavParsingException extends SavException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SavParsingException() {
		super();
	}
	
	public SavParsingException(String s) {
		super(s);
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Parsing error!";
	}
}
