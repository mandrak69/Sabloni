package exceptions;

import java.util.InputMismatchException;
import java.util.zip.DataFormatException;

public class DatumPogresnogFormata extends DataFormatException {


	public DatumPogresnogFormata() {
		// TODO Auto-generated constructor stub
		throw new InputMismatchException();
	}

	public DatumPogresnogFormata(String arg0) {
		super(arg0);
		throw new InputMismatchException();
		// TODO Auto-generated constructor stub
	}

}
