
import java.util.ArrayList;
import java.time.LocalDate;
import GA.Helper;
import GA.Ordering;
import GA.School;
import GA.Vendor;

public class C206_CaseStudy {

	// MAIN
	private static int option = 0;
	private static final int Max_option_admin = 5;
	private static final int Max_option = 4;
	private static ArrayList<Admin> AdminAccounts = new ArrayList<Admin>();
	private static ArrayList<User> userList = new ArrayList<User>();
	private static ArrayList<School> schoolList = new ArrayList<School>();
	private static ArrayList<Vendor> VendorList = new ArrayList<Vendor>();
	private static ArrayList<Ordering> orderList = new ArrayList<Ordering>();
	private static ArrayList<Payment> paymentList = new ArrayList<Payment>();
	private static ArrayList<Menu> MenuList = new ArrayList<Menu>();

	// GEMMA
	private static final int OPTION_DELETE = 3;
	private static final int OPTION_ADD = 2;
	private static final int OPTION_VIEW = 1;
	private static final int OPTION_QUIT = 4;

	public static void main(String[] args) {
		// QUEENIE
		AdminAccounts.add(new Admin("queenie", "P@ssw0rd"));
		AdminAccounts.add(new Admin("alfred", "P@ssw0rd"));
		AdminAccounts.add(new Admin("hedil", "P@ssw0rd"));
		AdminAccounts.add(new Admin("gemma", "P@ssw0rd"));
		AdminAccounts.add(new Admin("jichin", "P@ssw0rd"));

		// ALFRED
		userList.add(new User("queenie", "P@ssw0rd"));
		userList.add(new User("Alfred", "P@ssw0rd"));
		userList.add(new User("jc", "P@ssw0rd"));

		// GEMMA
		schoolList.add(new School("Republic Polytechnic", "9 Woodlands Ave 9", "Singapore 738964"));
		schoolList.add(new School("Temasek Polytechnic", "21 Tampines Ave 1", "Singapore 529757"));
		schoolList.add(new School("Nanyang Polytechnic", "180 Ang Mo Kio Ave 8", "Singapore 569830"));

		// JICHIN
		// HEDIL
		orderList.add(new Ordering());
		orderList.add(new Ordering());

		// Vendor
		VendorList.add(new Vendor());
		VendorList.add(new Vendor());

		// QUEENIE
		paymentList.add(new Payment("12345", 40, "Visa", "54321"));
		paymentList.add(new Payment("56789", 20, "Credit Card", "98765"));
		paymentList.add(new Payment("34567", 60, "PayNow", "76543"));

		GeneralUI();
	}

	private static void mainMenu() {
		Helper.line(60, "=");
		System.out.println("WELCOME TO SCHOOL LUNCHBOX ONLINE");
		Helper.line(60, "=");
		System.out.println("LOGIN AS: ");
		System.out.println("1. Administrator");
		System.out.println("2. Vendor");
		System.out.println("3. User");
		System.out.println("4. Register");
		System.out.println("5. End");
	}

	private static void userMenu() {
		Helper.line(60, "=");
		System.out.println("WELCOME TO SCHOOL LUNCHBOX ONLINE (USER PAGE)");
		Helper.line(60, "=");
		System.out.println("1. Manage Orders");
		System.out.println("2. Manage Payment");
		System.out.println("3. End");
	}

	private static void adminMenu() {
		Helper.line(60, "=");
		System.out.println("WELCOME TO SCHOOL LUNCHBOX ONLINE (ADMIN PAGE)");
		Helper.line(60, "=");
		System.out.println("1. Manage School Information");
		System.out.println("2. Manage Accounts Overview");
		System.out.println("3. End");

	}

	private static void adminVendorMenu() {
		Helper.line(60, "=");
		System.out.println("WELCOME TO SCHOOL LUNCHBOX ONLINE (ADMIN PAGE)");
		Helper.line(60, "=");
		System.out.println("1. Add Vendor");
		System.out.println("2. Delete Vendor");
		System.out.println("3. View All Vendors");
		System.out.println("4. End");
	}
	
	private static void mgtAccMenu() {
		Helper.line(60, "=");
		System.out.println("WELCOME TO SCHOOL LUNCHBOX ONLINE (ADMIN PAGE)");
		Helper.line(60, "=");
		System.out.println("1. Start Order");
		System.out.println("2. Delete Order");
		System.out.println("3. View and Track Orders");
		System.out.println("4. End");
	}

	private static void vendorMenu() {
		Helper.line(60, "=");
		System.out.println("WELCOME TO SCHOOL LUNCHBOX ONLINE (VENDOR PAGE)");
		Helper.line(60, "=");
		System.out.println("1. Manage Vendors");
		System.out.println("2. Manage Menu");
		System.out.println("3. End");
	}

	private static void GeneralUI() {
		Loop1: while (option != Max_option) {
			mainMenu();
			option = Helper.readInt("Enter choice: ");
			switch (option) {
			case 1:

				System.out.println("Login as administrator..");
				String username = Helper.readString("Enter your username: ");
				String password = Helper.readString("Enter your password: ");
				boolean authenticateAdmin = false;

				for (Admin admin : AdminAccounts) {
					if (admin.getUser().equalsIgnoreCase(username) && admin.getPass().equalsIgnoreCase(password)) {
						System.out.println("Login successful as " + username);
						authenticateAdmin = true;
						AdminUI();
						break;
					}
				}

				if (!authenticateAdmin) {
					System.out.println("Invalid username or password. Exiting admin UI.");
					GeneralUI();
					return;
				}
				break;

			case 2:
				System.out.println("Login as vendor..");
				String Vusername = Helper.readString("Enter your username: ");
				for (Vendor v : VendorList) {
					if (Vusername == v.getName()) {
						VendorUI();
					} else {
						GeneralUI();
					}
				}
				break;

			case 3:
				System.out.println("Login as user..");

				String uName = Helper.readString("Enter username: ");
				String uPassword = Helper.readString("Enter password: ");
				User currentUser = null;

				for (User user : userList) {
					if (user.getName().equals(uName) && user.getpw().equals(uPassword)) {
						currentUser = user;
						userMenu();
						option = Helper.readInt("Enter your choice: ");
						break;
					}
				}

				if (currentUser == null) {
					System.out.println("Invalid username or password. Exiting user UI.");
				}
				UserUI();
				break;

			case 4:
				System.out.println("Register a new account..");
				String name = "";
				String pw = "";
				boolean isValidUsername = false;
				while (!isValidUsername) {
					name = Helper.readString("Enter username: ");

					String usernamePattern = "^[a-zA-Z0-9]{6,}$";
					isValidUsername = name.matches(usernamePattern);
					if (!isValidUsername) {
						System.out.println(
								"Invalid username. Username must be at least 6 characters long and contain only letters and digits.");
					}
				}

				boolean isValidPassword = false;
				while (!isValidPassword) {
					pw = Helper.readString("Enter password: ");
					String passwordPattern = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$"; // at
																												// least
																												// 8
																												// characters
																												// contains
																												// one
																												// letter,
																												// one
																												// digit,
																												// one
																												// special
																												// char
					isValidPassword = pw.matches(passwordPattern);
					if (!isValidPassword) {
						System.out.println(
								"Invalid password. Password must be at least 8 characters long and contain at least one letter, one digit, and one special character (@, $, !, %, *, ?, &).");
					}
				}
				if (isValidUsername == true && isValidPassword == true) {

					User newUser = new User(name, pw);
					userList.add(newUser);
					System.out.println("Account registered successfully!");
				}

				break;

			case 5:
				System.out.println("Session ended");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				GeneralUI();
				break;
			}
		}
	}

	private static void AdminUI() {
		Loop2: while (option != Max_option_admin) {
			int option = 0;
			adminMenu();
			option = Helper.readInt("Enter choice: ");

			switch (option) {
			case 1:
				ManageSchInfo();
				break;
			case 2:
				ManageAcc();
				break;
			case 3:
				ManageVendor();
			case 4:
				System.out.println("Session ended");
				break Loop2;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		}
	}

	private static void VendorUI() {
		Loop3: while (option != Max_option) {
			int option = 0;
			vendorMenu();
			option = Helper.readInt("Enter choice: ");

			switch (option) {
			case 1:
				// ManageVendor();
				break;
			case 2:
				// ManageMenu();
				break;
			case 3:
				System.out.println("Session ended");
				break Loop3;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		}
	}

	private static void UserUI() {
		Loop4: while (option != Max_option) {
			int option = 0;
			vendorMenu();
			option = Helper.readInt("Enter choice: ");

			switch (option) {
			case 1:
				ManageOrder();
				break;
			case 2:
				ManagePayment();
			case 3:
				System.out.println("Session ended");
				break Loop4;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		}
	}

	// --------------------------------------------------------------------------------------------------------------------//

	// school by GEMMA
	private static void ManageSchInfo() {
		while (option != OPTION_QUIT) {

			menu();
			option = Helper.readInt("Enter an option > ");

			if (option == OPTION_VIEW) {
				viewAllSchool(schoolList);

			} else if (option == OPTION_ADD) {

				School sch = inputSchool();
				addSchool(schoolList, sch);
				System.out.println("School added");

			} else if (option == OPTION_DELETE) {
				deleteSchool(Helper.readString("Please enter the school name to delete: "), schoolList);

			} else if (option == OPTION_QUIT) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid input");
			}

		}
	}

	public static String retrieveAllSchool(ArrayList<School> schoolList) {
		String output = "";

		for (School school : schoolList) {
			output += String.format("%-30s %-30s %-20s\n", school.getName(), school.getAddress(),
					school.getpostalCode());
		}
		return output;
	}

	public static void viewAllSchool(ArrayList<School> schoolList) {
		System.out.println("\nSCHOOL LIST:\n");
		String output = String.format("%-30s %-30s %-20s\n", "NAME", "ADDRESS", "POSTAL CODE");
		output += retrieveAllSchool(schoolList);
		System.out.println(output);
	}

	public static School inputSchool() {
		String name = Helper.readString("Enter school name > ");
		String address = Helper.readString("Enter address > ");
		String postalCode = Helper.readString("Enter postal code > ");

		School sch = new School(name, address, postalCode);
		return sch;

	}

	public static void addSchool(ArrayList<School> schoolList, School sch) {
		School s;
		for (int i = 0; i < schoolList.size(); i++) {
			s = schoolList.get(i);
			if (s.getName().equalsIgnoreCase(sch.getName()))
				return;
		}
		if ((sch.getName().isEmpty()) || (sch.getAddress().isEmpty()) || (sch.getpostalCode().isEmpty())) {
			return;
		}

		schoolList.add(sch);
	}

	public static void deleteSchool(String name, ArrayList<School> schoolList) {
		boolean schoolfound = false;
		for (int i = 0; i < schoolList.size(); i++) {
			School school = schoolList.get(i);
			if (school != null && schoolList.get(i).getName().equalsIgnoreCase(name)) {
				schoolList.remove(i);
				schoolfound = true;
				System.out.println("School has been deleted");
			}
		}
		if (!schoolfound) {
			System.out.println("School not found");
		}
	}

	public static void menu() {
		Helper.line(80, "-");
		System.out.println("Manage School Information:");
		Helper.line(80, "-");
		System.out.println("1. View All Schools");
		System.out.println("2. Add School");
		System.out.println("3. Delete School");
		System.out.println("4. Quit");
		Helper.line(80, "-");

	}

	// School end
	// --------------------------------------------------------------------------------------------------------------------//

	// user by ALFRED
	private static void ManageAcc() {

		while (option != 5) {
			accMenu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				User acc = inputUser();
				addUser(userList, acc);

			} else if (option == 2) {
				viewAllUser(userList);

			} else if (option == 3) {
				removeUser(Helper.readString("Please enter the user name to delete: "), userList);

			} else if (option == 4) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		}
	}

	public static void accMenu() {
		Helper.line(80, "-");
		System.out.println("MANAGE ACCOUNTS");
		System.out.println("1. Add User");
		System.out.println("2. View All Users");
		System.out.println("3. Delete Users");
		System.out.println("4. Back");
		Helper.line(80, "-");
	}

	// input
	public static User inputUser() {

		String name = Helper.readString("Enter account name > ");
		String pw = Helper.readString("Enter password > ");

		User acc = new User(name, pw);
		return acc;

	}

	// add
	public static void addUser(ArrayList<User> userList, User acc) {
		User newUser;
		for (User u : userList) {
			newUser = u;
			if (newUser.getName().equalsIgnoreCase(acc.getName()))
				return;
		}
		if (acc.getName().isEmpty() || acc.getpw().isEmpty()) {
			return;
		}
		userList.add(acc);
	}

	// retrieve
	public static String retrieveAllUser(ArrayList<User> userList) {

		String output = "";
		for (User u : userList) {
			if (u.isAuthenticate(u.getName(), u.getpw())) {
				output += u.toString();
			}
		}
		return output;
	}

	public static void viewAllUser(ArrayList<User> userList) {

		String output = String.format("%-10s %-20s \n", "NAME", "PASSWORD");
		output += retrieveAllUser(userList);
		System.out.println(output);
	}

	// delete
	public static void removeUser(String name, ArrayList<User> userList) {
		boolean userFound = false;

		for (User user : userList) {
			if (user != null && user.getName().equalsIgnoreCase(name)) {
				userFound = true;
				break;
			}
		}

		if (userFound) {
			userList.removeIf(user -> user != null && user.getName().equalsIgnoreCase(name));
			System.out.println("User has been deleted");
		} else {
			System.out.println("User not found");
		}
	}
	// user end
	// --------------------------------------------------------------------------------------------------------------------//

	// vendor by HEDIL
	private static void ManageVendor() {

		while (option != 5) {
			adminVendorMenu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				addVendor();

			} else if (option == 2) {
				delVendor();

			} else if (option == 3) {
				viewAllVendor();

			} else if (option == 4) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		}
	}

	public static void addVendor() {
		String name = Helper.readString("Enter Name of Vendor: ");
		String email = Helper.readStringRegEx("Enter Email address: ", "[a-zA-Z0-9]+@[a-zA-Z0-9]+.(com|org)");
		int contactNo = Integer.parseInt(Helper.readStringRegEx("Enter Contact No.", "[89][0-9]{7}"));
		String address = Helper.readString("Enter Address: ");
		VendorList.add(new Vendor(name, email, contactNo, address));
		System.out.println("Vendor Added!");

	}

	public static void delVendor() {
		String name = Helper.readString("Enter Name of Vendor: ");
		String email = Helper.readStringRegEx("Enter Email address: ", "[a-zA-Z0-9]+@[a-zA-Z0-9]+.(com|org)");
		int contactNo = Integer.parseInt(Helper.readStringRegEx("Enter Contact No.", "[89][0-9]{7}"));
		String address = Helper.readString("Enter Address: ");
		for (int i = 0; i < VendorList.size(); i++) {
			Vendor V = VendorList.get(i);
			if (V.getName().equalsIgnoreCase(name) && V.getEmail().equalsIgnoreCase(email) && V.getContactNo() == contactNo
					&& V.getAddress().equals(address)) {
				VendorList.remove(i);
				System.out.println("Vendor Removed!");
			} else {
				System.out.println("Information incorrect!");
			}
		}
	}

	public static void viewAllVendor() {
		String format = "%-7s| %-20s | %-20s | %-15s | %-50s\n";
		String format1 = "No. %-3d| %-20s | %-20s | %-15d | %-50s\n";
		Helper.line(100, "-");
		System.out.printf(format,"No.", "Vendor Name", "Vendor Email", "Contact No.", "Address");
		Helper.line(100, "-");
		for (int i = 0; i < VendorList.size(); i++) {
			Vendor V = VendorList.get(i);
			System.out.printf(format1, i+1, V.getName(), V.getEmail(), V.getContactNo(), V.getAddress());
		}
	}
	// vendor end

	// order by HEDIL
	/*
	 * public static void ViewMenu() { LocalDate date =
	 * Helper.readLocalDate("Enter Day: "); String ChildName =
	 * Helper.readString("Enter your Child's name: "); // The creation of MenuList
	 * MenuListCreation(VendorList, MenuList, date); User parent if (C != null) {
	 * for (Menu menu : MenuList) { // Check if Date exist in Menu viewCuisine();
	 * boolean checkMenuGotDate = Helper.containDate(menu.getDate(), date); if
	 * (checkMenuGotDate) { String category =
	 * Helper.readString("Enter type of Cuisine: "); for (Meals M :
	 * menu.getFoodMenu()) { if (M.getType().equalsIgnoreCase(category)) {
	 * printMenu(M); } } } else {
	 * System.out.println("Meals not available for that day!"); break; } } } else {
	 * System.out.println("Child does not exist!"); } } }
	 */

	private static void ManageAcc(String user) {

		while (option != 5) {
			mgtAccMenu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				StartOrder(user);
				
			} else if (option == 2) {
				viewAllUser(userList);

			} else if (option == 3) {
				removeUser(Helper.readString("Please enter the user name to delete: "), userList);

			} else if (option == 4) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		}
	}
	
	private static void StartOrder(String user) {
		String childName = Helper.readString("Enter Child's Name: ");
		User parent = getUserByName(user);
		if (parent == null) {
			System.out.println("User not found");
			return;
		}
		ArrayList<Menu> childMenu = new ArrayList<>();
		String category = Helper.readString("Enter type of Meal e.g [Indian, Malay, Chinese]: ");
		for (Menu M : MenuList) {
			if (M.getType().equalsIgnoreCase(category)) {
				childMenu.add(M);
			}
		}
		System.out.println("Child's Menu");
		for (int i = 0; i < childMenu.size(); i++) {
			System.out.printf("%d. %s\n", (i + 1), childMenu.get(i).getName());
		}
		int mealChoice = Helper.readIntRange("Enter the number of the meal you want to order: ", 1, childMenu.size());
		int qty = Helper.readIntRange("Enter the quantity: ", 1, Integer.MAX_VALUE);

		Menu selectMeal = childMenu.get(mealChoice - 1);

		double ttAmt = selectMeal.getPrice() * qty;
		double gst = ttAmt * 1.08;
		System.out.println("Total Amount: $" + gst);
		System.out.println("GST:        : 8%");
		boolean cfm = Helper.readBoolean("Confirm purchase? [y/n]: ");
		if (!cfm) {
			System.out.println("Purchase canceled!");
			return;
		}

		payment(ttAmt);

		verifyOrderVendorqty(parent, childName, gst, selectMeal, selectMeal.getVendorName());

	}

	/**
	 * @param ttAmt
	 */
	private static void payment(double ttAmt) {
		String buyer = Helper.readString("Enter buyer account > ");
		String method = Helper.readString("Enter payment method > ");
		String seller = Helper.readString("Enter seller account > ");
		Payment transaction = new Payment(buyer, ttAmt, method, seller);
		C206_CaseStudy.makePayment(paymentList, transaction);
	}

	private static void delOrder(String user, String orderID) {
		User parent = getUserByName(user);
		String mealTitle = "\nMenu:\n%-2s %-10s %-5s\n";
		String format = "%-2d %-10s %-5.2f\n";
		if (parent == null) {
			System.out.println("User not found!");
			return;
		}

		if (parent != null) {
			for (int i = 0; i < orderList.size();) {
				Ordering O = orderList.get(i);
				boolean filterUserOrder = O != null && O.getOrderId().equalsIgnoreCase(orderID);
				if (filterUserOrder) {
					boolean trackingOrder = O.getTrackingOrder();
					// Check if the order has arrived(false) or pending(true)
					// To check if the order has arrived already
					String status = trackingOrder ? "Not Shipped" : "Delivered";
					if (status.equals("Delivered")) {
						System.out.println("Order Details:\nOrderID: " + O.getOrderId());
						System.out.printf(mealTitle, "No.", "Meal Name", "Price");
						for (Menu M : O.getItems()) {
							System.out.printf(format, i + 1, M.getName(), M.getPrice());
							i++;
						}
						boolean delVerification = Helper
								.readBoolean("Do you want to remove this order from your order history? [y/n]: ");
						if (delVerification) {
							orderList.remove(i);
							System.out.println("Order removed from history!");
							return;
						} else {
							return;
						}
					} else {
						System.out.println("Order is still pending!");
						return;
					}

				} else {
					System.out.println("Order does not exist!");
					;
					return;
				}
			}
		}

	}

	private static void viewOrder(String user) {
		User parent = getUserByName(user);
		int i = 0;
		if (parent == null) {
			System.out.println("User does not exist");
			return;
		}
		// Iterate through the parent's Order History
		if (parent != null) {
			for (Ordering O : orderList) {
				if (O != null && O.getName().equals(parent.getName())) {
					boolean trackingOrder = O.getTrackingOrder();
					// Check if the order has arrived(false) or pending(true)
					String status = trackingOrder ? "Shipping" : "Delievered";
					Helper.line(40,"=");
					System.out.println(String.format("Order Details:\nNo. order: %s\nOrderID: %s\nStatus: %s\n", i + 1,
							O.getOrderId(), status));
					i++;
				} else {
					// If the orderHistory is null
					System.out.println("Order not found.");
					return;
				}
			}
		}
		Helper.line(40, "-");
		boolean toView = Helper.readBoolean("Would you like to view the Meals? [y/n]: ");
		if (toView) {
			// Verify OrderID filter for specific order
			String orderId = Helper.readString("Enter Order ID: ");
			for (Ordering O : orderList) {
				boolean orderExist = O.getOrderId().equalsIgnoreCase(orderId);
				if (orderExist) {
					for (Menu M : O.getItems()) {
						printMenu(M);
					}
				} else {
					System.out.println("Order does not exist");
					return;
				}
			}
		} else {
			return;
		}

	}

//Refactored
	private static void printMenu(Menu meal) {
		System.out.println("Name: " + meal.getName());
		System.out.println("Description: " + meal.getDescription());
		System.out.println("Price: " + meal.getPrice());
		System.out.println("----------------------");
	}

	private static void verifyOrderVendorqty(User parent, String child, double ttAmt, Menu selectMeal, String vendor) {
		// Deduct quantity from vendor and update meal quantity

		// Create and add the order to the order list
		Ordering order = new Ordering(parent.getName(), child, LocalDate.now(), ttAmt);
		orderList.add(order);

		System.out.println("Order placed successfully.");
	}

// refactor the loop for parents by Name
	private static User getUserByName(String username) {
		for (User parent : userList) {
			if (parent.getName().equals(username)) {
				return parent;
			}
		}
		return null;
	}

//refactor user to order
	private static Ordering getOrderByUser(String username, String orderID) {
		User user = getUserByName(username);
		for (Ordering OL : orderList) {
			if (user.getName().equalsIgnoreCase(OL.getName()) && OL.getOrderId().equals(orderID)) {
				return OL;
			}
		}
		return null;
	}
	// order end

	// --------------------------------------------------------------------------------------------------------------------//
	// menu by JICHIN
	
	
	// menu end
	// --------------------------------------------------------------------------------------------------------------------//
	// payment by QUEENIE

	private static void ManagePayment() {
		while (option != 5) {
			paymentMenu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				Payment trans = inputPayment();
				addPayment(paymentList, trans);

			} else if (option == 2) {
				viewAllPayment(paymentList);

			} else if (option == 3) {
				deletePayment(Helper.readString("Please enter the user name to delete: "), paymentList);

			} else if (option == 4) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		}
	}

	public static void paymentMenu() {
		Helper.line(60, "=");
		System.out.println("MANAGE PAYMENT");
		Helper.line(60, "=");
		System.out.println("1. Add Payment");
		System.out.println("2. View All Payment");
		System.out.println("3. Delete Payment");
		System.out.println("4. Back");

	}

	// input
	public static Payment inputPayment() {

		String buyer = Helper.readString("Enter buyer account > ");
		double price = Helper.readInt("Enter price > ");
		String method = Helper.readString("Enter payment method > ");
		String seller = Helper.readString("Enter seller account > ");

		Payment trans = new Payment(buyer, price, method, seller);
		return trans;

	}

	// add
	public static void addPayment(ArrayList<Payment> paymentList, Payment trans) {
		makePayment(paymentList, trans);
	}

	public static void makePayment(ArrayList<Payment> paymentList, Payment trans) {
		Payment newPay;
		String transBuyerAcc = trans.getBuyerAcc();
		for (Payment p : paymentList) {
			newPay = p;
			if (newPay.getBuyerAcc().equalsIgnoreCase(transBuyerAcc))
				return;
		}
		String transSellerAcc = trans.getSellerAcc();
		if (transBuyerAcc.isEmpty() || transSellerAcc.isEmpty()) {
			return;
		}
		paymentList.add(trans);
	}

	// retrieve
	public static String retrieveAllPayment(ArrayList<Payment> paymentList) {

		String output = "";

		for (Payment p : paymentList) {
			if (p.getRecord()) {
				output += p.toString();
			}
		}
		return output;
	}

	public static void viewAllPayment(ArrayList<Payment> paymentList) {
		output(paymentList);
	}

	public static void output(ArrayList<Payment> paymentList) {
		String output = String.format("%-10s %-30s %-10s %-10s %-10s \n", "BUYER ACC", "AMOUNT", "RECORD", "METHOD",
				"SELLER ACC");
		output += retrieveAllPayment(paymentList);
		System.out.println(output);
	}

	// delete
	public static void deletePayment(String acc, ArrayList<Payment> paymentList) {
		boolean paymentFound = false;

		for (int i = paymentList.size() - 1; i >= 0; i--) {
			Payment p = paymentList.get(i);
			if (p != null && p.getBuyerAcc().equalsIgnoreCase(acc)) {
				paymentFound = true;
				paymentList.remove(i);
				System.out.println("Payment has been deleted");
			}
		}

		if (!paymentFound) {
			System.out.println("Payment not found");
		}

		// --------------------------------------------------------------------------------------------------------------------//
	}// end of main method
}// end of class
