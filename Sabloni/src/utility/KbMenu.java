package utility;

import static java.lang.String.format;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.regex.Pattern;

import exceptions.DataAlreadyExistsException;
import exceptions.DataNotFound;
import exceptions.NepravilanUnos;

public class KbMenu {
	private static final Set<String> EXIT_COMMANDS;
	private static final Set<String> HELP_COMMANDS;
	private static final Pattern DATE_PATTERN;
	private static final String HELP_MESSAGE;
	private static final int numOfTry = 3;
	private static final Validater VALIDATOR = new Validater();
	static {

		final SortedSet<String> ecmds = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		ecmds.addAll(Arrays.asList("exit", "quit", "end"));
		EXIT_COMMANDS = Collections.unmodifiableSortedSet(ecmds);
		final SortedSet<String> hcmds = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		hcmds.addAll(Arrays.asList("help", "?"));
		HELP_COMMANDS = Collections.unmodifiableSet(hcmds);
		DATE_PATTERN = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((18|19|20|21)\\\\d\\\\d)"); // http://regex101.com/r/xB8dR3/1
		HELP_MESSAGE = format("Please enter some data or enter one of the following commands to exit %s",
				EXIT_COMMANDS);
	}

	private static void output(final String format, final Object... args) {
		System.out.println(format(format, args));
	}

	public static final String[] MAINMENU = { "1. Rad sa zaposlenim", "2. Rad sa projektima", "3. Kraj " };

	public static final String[] MENU1 = { "1. Unos novog zaposlenog", "2. Izmena podataka o zaposlenom",
			"3. Brisanje podataka o zaposlenom ", "4. Prikaz svih zaposlenih", "5. Povratak u glavni menu " };

	public static final String[] MENU2 = { "1. Dodaj novog studenta", "2. Dodaj novi predmet",
			"3. Upisi novo polaganje ", "4. Pregled polozenih ispita za studenta", "5. Pregled svih prijava ",
			"6. Pregled studenata-polagaca po izabranom ispitu  ", "7. Pregled   ", "0   Kraj Rada" };

	public static int doByMenyChoice() throws DataNotFound, DataAlreadyExistsException {
		Scanner sc = KbInput.getScanner();
		
		int mainChoice = -1;
		int subChoice = -1;
		while (mainChoice != 0) {
			mainChoice = subMenu(MAINMENU);

			switch (mainChoice) {
			case 1:
				subChoice = -1;

				while (subChoice != 0) {
					subChoice = subMenu(MENU1);
					switch (subChoice) {
					case 1:

						break;
					case 2:
						break;
					case 3:
						break;
					case 4:
						break;

					case 5:

						mainChoice = 1;
						subChoice = 0;
						break;
					default:
						output("Choice must be a value between 1 and %s.", MENU1.length);
					}

				}
				break;
			case 2:
				subChoice = -1;

				while (subChoice != 0) {
					subChoice = subMenu(MENU2);
					switch (subChoice) {
					case 1:

						break;
					case 2:
						break;
					case 3:

						break;
					case 4:
						break;

					case 5:

						mainChoice = 2;
						subChoice = 0;
						break;
					default:
						output("Choice must be a value between 1 and %s.", MENU2.length);
					}
				}

				break;

			case 3:
				/*
				 * slucaj izalaska
				 */
				output("Hvala ....i do vidjenja.");
				mainChoice = 0;
				sc.close();
				break;
			default:
				output("Choice must be a value between 1 and %s.", MENU1.length);
			}

		}
		return mainChoice;

	}


	private static int subMenu(String[] menu) {
		// TODO Auto-generated method stub
		Scanner sc = KbInput.getScanner();
		int choice = -1;
		while (choice < 0) {
			for (int i = 0; i < menu.length; i++) {
				System.out.println(menu[i]);
			}
			int subChoice = KbMenu.unesiBroj("Vas izbor?");

			if (subChoice > 0 && subChoice <= menu.length) {
//   CAN DO AS VALIDATOR.forString(""+subChoice).isInteger().isInRange(0, menu.length)
				choice = subChoice;
			} else {
				output("Nemoguc izbor -" + subChoice);
			}
		}
		return choice;
	}



	public static int unesiBroj(String tekst) {
		int broj = -1;
		int ch = numOfTry;
		Scanner sc = KbInput.getScanner();

		do {
			System.out.println(tekst);
			while (!sc.hasNextInt()) {
				output("That's not a number!" + ch);
				sc.next(); // this is important!
				if (--ch <= 0) {
					break;
				}
			}

			if (ch > 0) {
				ch = -1;
				broj = sc.nextInt();
			}
			return broj;
		} while (ch > 0);
	}

	public static String unesiTekst(String t) {
		String tekst = null;
		try {
			Scanner sc = KbInput.getScanner();

			output(t);
			tekst = sc.next();
			// if (tekst == System.getProperty("line.separator")) {
			if (VALIDATOR.forString(tekst).isEmptyString().getValid()) {
				// samo prazan string
				output("-Prazan string", "");
				return "";
			}
			return tekst;
		} catch (InputMismatchException ex1) {
			// ex1.printStackTrace();

			throw new NepravilanUnos("Morate uneti tekst-:", ex1);
		} catch (RuntimeException ex) {
			// ex.printStackTrace();
			throw new NepravilanUnos("Morate uneti tekst:", ex);
		}
		// return broj;
	}

	

	public static double unesiDouble(String tekst) {
		double broj = -1;
		int ch = numOfTry;

		Scanner sc = KbInput.getScanner();

		do {
			output(tekst);
			while (!sc.hasNextDouble()) {
				output("That's not a number!%s", ch);
				sc.next(); // this is important!
				if (--ch <= 0) {
					break;
				}
			}

			if (ch > 0) {
				ch = -1;
				broj = sc.nextDouble();
			}
			return broj;
		} while (ch > 0);

	}

	public static int yesNoMenu(String t) {
		Scanner sc = KbInput.getScanner();
		int ch = numOfTry;
		System.out.println(t);
		while (!sc.hasNext("[ynYN]")) {
			output("nemoguc izbor y/n", "");
			sc.next();
			ch--;
			if (ch < 0) {
				return -1;
			}
		}
		String yesno = sc.next();
		if (yesno.equalsIgnoreCase("Y")) {

			return 1;
		}
		return -1;
	}

	public static LocalDate unesiDate(String tekst) {
		Scanner sc = KbInput.getScanner();
		final Pattern DATE_PATTERN = Pattern.compile("\\d{2}([-\\/])\\d{2}\\1\\d{4}"); // http://regex101.com/r/xB8dR3/1
		int brpok = numOfTry;
		do {
			output(tekst, "");
			while (sc.hasNext() && brpok > 0) {
				if (sc.hasNext(DATE_PATTERN)) {
					final String datum = sc.next("\\d{2}([-\\/])\\d{2}\\1\\d{4}");
					output("You entered a Date representation =%s", datum);
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					brpok--;
					try {
						LocalDate date = formatter.parse(datum, LocalDate::from);
						System.out.println(date.format(formatter));
						return date;
					} catch (DateTimeParseException e) {
						output("Pogresan datum", "");
						// Thrown if text could not be parsed in the specified format
						brpok--;
					}

				} else {
					sc.nextLine();
					brpok--;
					if (brpok <= 0) {
						break;
					}
					output("Pogresan format datuma ", "");

				}

			}
		} while (brpok > 0);
		return null;
	}
	
	
}
