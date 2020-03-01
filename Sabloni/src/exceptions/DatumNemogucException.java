package exceptions;

import java.time.format.DateTimeParseException;

public class DatumNemogucException extends DateTimeParseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DatumNemogucException(String message, CharSequence parsedData, int errorIndex, Throwable cause) {
		super(message, parsedData, errorIndex, cause);
		// TODO Auto-generated constructor stub
	}

	public DatumNemogucException(String message, CharSequence parsedData, int errorIndex) {
		super(message, parsedData, errorIndex);
		// TODO Auto-generated constructor stub
	}

	

}
