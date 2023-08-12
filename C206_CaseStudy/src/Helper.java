import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {

	@SuppressWarnings("resource")
	public static String readString(String prompt) {
		System.out.print(prompt);
		return new java.util.Scanner(System.in).nextLine();
	}

	public static String readStringRegEx(String prompt, String pattern) {
		String input = readString(prompt);	
		boolean matched = Pattern.matches(pattern, input);

		while (!matched) {
			System.out.println("Invalid input!");
			input = readString(prompt);
			matched = Pattern.matches(pattern, input);
		}
		return input;

	}
	
	public static boolean readBooleanRegEx(String prompt, String pattern) {
		String input = readString(prompt);	
		boolean matched = Pattern.matches(pattern, input);

		while (!matched) {
			System.out.println("Invalid input!");
			input = readString(prompt);
			matched = Pattern.matches(pattern, input);
		}
		return matched;

	}

	public static int readInt(String prompt) {
		int input = 0;
		boolean valid = false;
		while (!valid) {
			try {
				input = Integer.parseInt(readString(prompt));
				valid = true;
			} catch (NumberFormatException e) {
				System.out.println("*** Please enter an integer ***");
			}
		}
		return input;
	}

	public static int readIntRange(String prompt, int min, int max) {
		int input = 0;
		boolean valid = false;
		while (!valid) {
			try {
				input = Integer.parseInt(readString(prompt));
				if(input >= min && input <= max) {
					valid = true;
				}else {
					System.out.println("*** Please enter a valid integer within the specified range ***");
				}
				
			} catch (NumberFormatException e) {
				System.out.println("*** Please enter an integer ***");
			}
		}
		return input;
	}
	
	public static double readDouble(String prompt) {
		double input = 0;
		boolean valid = false;
		while (!valid) {
			try {
				input = Double.parseDouble(readString(prompt));
				valid = true;
			} catch (NumberFormatException e) {
				System.out.println("*** Please enter a double ***");
			}
		}
		return input;
	}

	public static float readFloat(String prompt) {
		float input = 0;
		boolean valid = false;
		while (!valid) {
			try {
				input = Float.parseFloat(readString(prompt));
				valid = true;
			} catch (NumberFormatException e) {
				System.out.println("*** Please enter a float ***");
			}
		}
		return input;
	}

	public static long readLong(String prompt) {
		long input = 0;
		boolean valid = false;
		while (!valid) {
			try {
				input = Long.parseLong(readString(prompt));
				valid = true;
			} catch (NumberFormatException e) {
				e.printStackTrace();
				System.out.println("*** Please enter a long ***");
			}
		}
		return input;
	}

	public static char readChar(String prompt) {
		char input = 0;
		boolean valid = false;
		while (!valid) {
			String temp = readString(prompt);
			if (temp.length() != 1) {
				System.out.println("*** Please enter a character ***");
			} else {
				input = temp.charAt(0);
				valid = true;
			}
		}
		return input;
	}

	public static boolean readBoolean(String prompt) {
		boolean valid = false;
		while (!valid) {
			String input = readString(prompt);
			if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y") || input.equalsIgnoreCase("true")
					|| input.equalsIgnoreCase("t")) {
				return true;
			} else if (input.equalsIgnoreCase("no") || input.equalsIgnoreCase("n") || input.equalsIgnoreCase("false")
					|| input.equalsIgnoreCase("f")) {
				return false;
			} else {
				System.out.println("*** Please enter Yes/No or True/False ***");
			}
		}
		return false;
	}

	public static Date readDate(String prompt) {
		java.util.Date date = null;
		boolean valid = false;
		while (!valid) {
			try {
				String input = readString(prompt).trim();
				if (input.matches("\\d\\d/\\d\\d/\\d\\d\\d\\d")) {
					int day = Integer.parseInt(input.substring(0, 2));
					int month = Integer.parseInt(input.substring(3, 5));
					int year = Integer.parseInt(input.substring(6, 10));
					java.util.Calendar cal = java.util.Calendar.getInstance();
					cal.setLenient(false);
					cal.set(year, month - 1, day, 0, 0, 0);
					date = cal.getTime();
					valid = true;
				} else {
					System.out.println("*** Please enter a date (DD/MM/YYYY) ***");
				}
			} catch (IllegalArgumentException e) {
				System.out.println("*** Please enter a date (DD/MM/YYYY) ***");
			}
		}
		return date;
	}

	public static LocalDate readLocalDate(String prompt) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = null;
		boolean valid = false;
		while (!valid) {
			try {
				String input = readString(prompt).trim();
				date = LocalDate.parse(input, formatter);
			} catch (IllegalArgumentException e) {
				System.out.println("*** Please enter a date (DD/MM/YYYY) ***");
			}
		}
		return date;
	}
	
	public static LocalDate readLocalDateCC(String prompt) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
		LocalDate date = null;
		boolean valid = false;
		while (!valid) {
			try {
				String input = readString(prompt).trim();
				date = LocalDate.parse(input, formatter);
			} catch (IllegalArgumentException e) {
				System.out.println("*** Please enter a date (MM/YYYY) ***");
			}
		}
		return date;
	}
	
	public static boolean readBoolLocalDateCC(String ccDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
		boolean valid = false;
		while (!valid) {
			try {
				String input = readString(ccDate.trim());
				LocalDate date = LocalDate.parse(input, formatter);
				valid = true;
			} catch (IllegalArgumentException e) {
				System.out.println("*** Please enter a date (MM/YYYY) ***");
			}
		}
		return valid;
	}

	public static LocalDate readLocalDateFormatter(String prompt, String pattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		LocalDate date = null;
		boolean valid = false;
		while (!valid) {
			try {
				String input = readString(prompt).trim();
				date = LocalDate.parse(input, formatter);
			} catch (IllegalArgumentException e) {
				System.out.println("*** Please enter a date ("+pattern.toUpperCase()+") ***");
			}
		}
		return date;
	}
	
	private static String quit = "0";

	public static int getUserOption(String title, String[] menu) {
		displayMenu(title, menu);
		int choice = readInt("Enter Choice --> ");
		while (choice > menu.length || choice < 0) {
			choice = readInt("Invalid Choice, Re-enter --> ");
		}
		return choice;
	}

	private static void displayMenu(String title, String[] menu) {
		line(80, "=");
		System.out.println(title.toUpperCase());
		line(80, "-");
		for (int i = 0; i < menu.length; i++) {
			System.out.println("[" + (i + 1) + "] " + menu[i]);
		}
		System.out.println("[" + quit + "] Quit");
		line(80, "-");
	}

	public static void line(int len, String c) {
		System.out.println(String.format("%" + len + "s", " ").replaceAll(" ", c));
	}

	public static Date thisDate(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setLenient(false);
		cal.set(year, month - 1, day, 0, 0, 0);
		return cal.getTime();
	}

	public static Date thisDate(int year, int month, int day, int hour, int min) {
		Calendar cal = Calendar.getInstance();
		cal.setLenient(false);
		cal.set(year, month - 1, day, hour, min, 0);
		return cal.getTime();
	}

	public static Date today() {
		Calendar cal = Calendar.getInstance();
		cal.setLenient(false);
		cal.setTime(new Date(System.currentTimeMillis()));
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	public static Date addDays(Date date, long days) {
		long time = date.getTime() + (days * 24 * 60 * 60 * 1000);
		return new Date(time);
	}

	public static Date setHourMinute(Date date, int hour, int min) {
		Calendar cal = Calendar.getInstance();
		cal.setLenient(false);
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.MINUTE, min);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	public static int getYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setLenient(false);
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
	}

	public static int getMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setLenient(false);
		cal.setTime(date);
		return cal.get(Calendar.MONTH) + 1;
	}

	public static int getDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setLenient(false);
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_MONTH);
	}

	public static Date now() {
		return new Date(System.currentTimeMillis());
	}
	
	public static int calcDayDifference(Date former, Date latter) {
		long diff = latter.getTime() - former.getTime();
		int days = (int) (diff / (24 * 60 * 60 * 1000));
		return days;
	}

	public static int calcYearDifference(Date former, Date latter) {
		int years = getYear(latter) - getYear(former);

		if (years > 0) {
			if ((getMonth(former) > getMonth(latter))
					|| (getMonth(former) == getMonth(latter) && getDay(former) > getDay(latter))) {
				years -= 1;
			}
		} else if (years < 0) {
			if ((getMonth(former) < getMonth(latter))
					|| (getMonth(former) == getMonth(latter) && getDay(former) < getDay(latter))) {
				years += 1;
			}
		}
		return years;
	}

	public static boolean sameDate(Date one, Date two) {
		return getDay(one) == getDay(two) && getMonth(one) == getMonth(two) && getYear(one) == getYear(two);
	}
	
	public static boolean containDate(LocalDate initialDate, LocalDate MainDate) {
		return initialDate.getYear() == MainDate.getYear() &&
				initialDate.getMonth() == MainDate.getMonth() &&
				initialDate.getDayOfMonth() == MainDate.getDayOfMonth();
	}

	public static boolean equalIgnoreCaseRegEx(String prompt, String pattern) {
		if(prompt == null || pattern == null) return prompt == pattern;
		
		Pattern patterns = Pattern.compile(Pattern.quote(prompt), Pattern.CASE_INSENSITIVE);
		Matcher match = patterns.matcher(pattern);
		return match.matches();
	}
	
	public static String capitalizedWords(String Word) {
		String[] words = Word.split(" ");
		String output = "";

		for (String word : words) {
			if (!word.isEmpty()) {
				char firstLetter = Character.toUpperCase(word.charAt(0));
				String FullWord = word.substring(1).toLowerCase();
				output += firstLetter + FullWord + " ";
			}
		}

		if (!output.isEmpty()) {
			output = output.substring(0, output.length() - 1);
		}

		return output;
	}

	public static boolean isValidRangeDate(LocalDate date) {
		LocalDate now = LocalDate.now();
		long calDate = date.toEpochDay() - now.toEpochDay();
		return calDate >= 0 && calDate <= 7;
	}
	
	public static String toHex(String input) {
		StringBuilder hexDeci = new StringBuilder();
		
		for(char c: input.toCharArray()) {
			hexDeci.append(String.format("%02X", c));
		}
		return hexDeci.toString();
	}


}