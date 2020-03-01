package utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Optional;


public class Validater {

	public static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private Boolean valid;
	private String string;
	private ArrayList<String> validationMessages = new ArrayList<>();
	private String label;
	
	
	public Validater() {
		super();
		
	}
	public Validater check() {
		this.valid=true;
		return this;
	}
	
	public Validater( String string) {
		super();
		this.valid = true;
		this.string = string;
	}

	public Validater(int a) {
		this.string=""+a;
		this.valid = true;
	}
	public Validater(String ocena, String label) {
		this.string=ocena;
		this.valid = true;
		this.label=label;
	}
	public Boolean getValid() {
		boolean b=this.valid;
		this.valid=true;
		return b;
	}
	
	
	
	public Validater forString(String string) {
		this.string = string;
		return this;
	}
	/**
	 * Checks if the string has at least 1 character
	 * 
	 * @return ValidatedInput instance with updated properties
	 */
	public Validater  isRequired() {
		
		if (string.length()==0) {
			this.valid=false;
		}
		return this;
	}
	
	private void checkCase(Boolean validationCase, String errorMessage) {
		if (!validationCase) {
			this.valid = false;
			this.validationMessages.add(errorMessage.replace("*label*", "'" + label + "'"));
		}
	}
	
	/**
	 * Checks if the string contains only upper or lower case letters or numbers
	 * 
	 * @return ValidatedInput instance with updated properties
	 */
	public Validater isAlphanum() {
		this.checkCase(string.matches("^[a-zA-Z0-9]*$"), "*label* must include only letters and numbers.");
		return this;
	}
	
	/**
	 * Checks if the string contains only upper or lower case letters
	 * 
	 * @return ValidatedInput instance with updated properties
	 */
	public Validater isAlpha() {
		this.checkCase(string.matches("^[a-zA-Z]*$"), "*label* must include only letters.");
		return this;
	}
	
	public Validater isEmptyString() {
		this.checkCase(string.equals("") || string.isEmpty() || string.equals(" "),"*label* must include only letters.");
		
		return this;
	}
	
	
	
	/**
	 * Checks if the string contains only numbers
	 * 
	 * @return ValidatedInput instance with updated properties
	 */
	public Validater isInteger() {
		this.checkCase(string.matches("^[0-9]*$"), "*label* must be an integer.");
		return this;
	}
	/**
	 * Checks if the string length is more than given length
	 * 
	 * @param length length to be used in the validation
	 * @return ValidatedInput instance with updated properties
	 */
	public Validater isMinLength(Integer length) {
		this.checkCase(string.length() > length, "*label* must have more than " + length + " characters.");
		return this;
	}
	/**
	 * Checks if the string length is less than the given length
	 * 
	 * @param length length to be used in the validation
	 * @return ValidatedInput instance with updated properties
	 */
	public Validater isMaxLength(Integer length) {
		this.checkCase(string.length() < length, "*label* must have less than " + length + " characters.");
		return this;
	}

	/**
	 * Checks if the string is a valid email (beta)
	 * 
	 * @return ValidatedInput instance with updated properties
	 */
	public Validater isEmail() {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";
		this.checkCase(string.matches(emailRegex), "*label* must be valid email.");
		return this;
	}

	public Validater isInRange(Integer begRange, Integer endRange) {

		this.checkCase((Integer.parseInt(string) >= begRange) & (Integer.parseInt(string) <= endRange),
				"*label* must be in range " + begRange + " - " + endRange + ".");
		return this;
	}

	public static boolean isValid(String email) {
		/*
		 * String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ "[a-zA-Z0-9_+&*-]+)*@" +
		 * "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";
		 * 
		 * Pattern pat = Pattern.compile(emailRegex); if (email == null) return false;
		 * return pat.matcher(email).matches();
		 */
		return true;
	}

	/**
	 * Tells if the string meets the validations or not
	 * 
	 * @return true if all validations have passed successfully and false otherwise
	 */
	public Boolean isValid() {
		return valid;
	}

	/**
	 * Gives all validation error messages
	 * 
	 * @return ArrayList of validation error messages
	 */
	public ArrayList<String> getValidationMessages() {
		return validationMessages;
	}

	public static Optional<LocalDate> StringToDate(String d) {

		try {

			LocalDate datumOd = LocalDate.parse(d, dtf);
			System.out.println("--"+datumOd.format(dtf));
			Optional<LocalDate> opt = Optional.of(datumOd);
			return opt;
		} catch (DateTimeParseException  e) {
			System.out.println("Pogresan format datuma ");
			return Optional.empty();
		}

	}
	

	
}
