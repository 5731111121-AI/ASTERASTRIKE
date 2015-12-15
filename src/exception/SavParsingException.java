package exception;

public class SavParsingException extends SavException {

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
