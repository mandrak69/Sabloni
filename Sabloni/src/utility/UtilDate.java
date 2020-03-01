package utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UtilDate {

	private static final Pattern DATE_PATTERN = Pattern.compile("\\d{2}([-\\/])\\d{2}\\1\\d{4}"); // http://regex101.com/r/xB8dR3/1

	public static void main(final String[] args) {
		final Scanner sis = new Scanner(System.in);

		while (sis.hasNext()) {
			if (sis.hasNext(DATE_PATTERN)) {
				final String next = sis.next("\\d{2}([-\\/])\\d{2}\\1\\d{4}");
				System.out.println("You entered a Date representation = %s" + next);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

				try {
				    LocalDate date = formatter.parse(next, LocalDate::from);
				    System.out.println(date.format(formatter));
				} catch (DateTimeParseException e) {
				    // Thrown if text could not be parsed in the specified format
				}
			} else {
				System.out.println("You entered an unclassified String = %s");
				break;
			}
		}

	}

}
