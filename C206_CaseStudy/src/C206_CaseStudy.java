import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;

public class C206_CaseStudy {
	private static final int Max_option_admin = 5;
	private static final int Max_option_vendor = 7;
	private static final int Max_option_general = 8;
	private static int option = 0;
	private static final String IC_Pattern = "(?i)[tgm][0-9]{7}[a-zA-Z]";
	private static final String Name_Pattern = "[a-zA-Z]";
	private static ArrayList<Vendor> VendorList = new ArrayList<Vendor>();
	private static ArrayList<Menu> MenuList = new ArrayList<Menu>();
	private static ArrayList<Admin> AdminList = new ArrayList<Admin>();
	private static ArrayList<Parents> ParentAccounts = new ArrayList<Parents>();
	private static ArrayList<String> SchoolList = new ArrayList<String>();


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Parents Account
		ParentAccounts.add(new Parents("Default1", "Pass123"));
		ParentAccounts.add(new Parents("Default2", "Pass123"));

		// Admin Account
		AdminList.add(new Admin("Manager", "Pw123"));

		// Creating a Meals for vendors and Vendors' account
		ArrayList<Meals> VendorMeal1 = new ArrayList<Meals>();
		ArrayList<Meals> VendorMeal2 = new ArrayList<Meals>();
		VendorMeal1.add(new Meals("Chicken Rice", "Traditional and Fragrant Dish!", 3.50, 1200));
		VendorMeal1.add(new Meals("Nasi Lemak", "Delicious and flavourful!", 2.80, 1300));
		VendorMeal2.add(new Meals("Meatless Don", "Unique and Tasty!", 4.50, 1400));
		VendorMeal2.add(new Meals("Veg Quiche", "Flaky and crumbly!", 3.20, 1500));
		VendorList.add(new Vendor("Vendor1", "password", "ABC@coporation.org", "AMK Hub #1-23,123567", VendorMeal1));
		VendorList.add(
				new Vendor("Vendor2", "pass123", "EFG@coporation.org", "Bishan Junction 8 #1-23,123564", VendorMeal2));

		loop_start: while (true) {
			loginMenu();
			int loginOption = Helper.readInt("Login Option: ");
			if (loginOption == 1) {
				String username = Helper.readString("Enter Username: ");
				String password = Helper.readString("Enter Password: ");
				for (Parents P : ParentAccounts) {
					boolean authentication = P.authentication(username, password);
					if (authentication == true) {
						GeneralUI(username);
					} else if (authentication == false) {
						System.out.println("Invalid Password or Username!");
					}
				}
			} else if (loginOption == 2) {
				String username = Helper.readString("Enter Username: ");
				String password = Helper.readString("Enter Password: ");
				for (Vendor V : VendorList) {
					boolean authentication = V.authentication(username, password);
					if (authentication == true) {
						VendorUI(username);
					} else if (authentication == false) {
						System.out.println("Invalid Password or Username!");
					}
				}
			} else if (loginOption == 3) {
				String username = Helper.readString("Enter Username: ");
				String password = Helper.readString("Enter Password: ");
				for (Admin A : AdminList) {
					boolean authentication = A.authentication(username, password);
					if (authentication == true) {
						AdminUI(username);
					} else if (authentication == false) {
						System.out.println("Invalid Password or Username!");
					}
				}
			} else if (loginOption == 4) {
				boolean create = Helper.readBoolean("Create Account? (y/n): ");
				if (create == true) {
					// Parent will be added first Requirement 1
					System.out.println("Parent Account Sign Up!");
					String Username_pattern = "[a-zA-Z0-9]{8,}";
					String Users = Helper.readStringRegEx("Username: ", Username_pattern);
					String Pass = Helper.readString("Password: ");

					// Child will be added second Requirement 2
					System.out.println("Required to enter a Child details!");
					String ic = Helper.readStringRegEx("Enter Child's NRIC [e.g T/G/M######A]:", IC_Pattern);
					String name = Helper.readStringRegEx("Enter Full Name per NRIC: ", Name_Pattern);
					String sch = Helper.readString("Enter Child's School: ").trim();

					ArrayList<Child> child1 = new ArrayList<>();
					child1.add(new Child(ic, name, sch));

					ParentAccounts.add(new Parents(Users, Pass, child1));
					System.out.println("User Registered!");
				} else {
					break loop_start;
				}
			} else if (loginOption == 5) {
				System.out.println("Thank you!");
				break loop_start;
			} else {
				System.out.println("Invalid Option!");
			}
		}

	}

	private static void loginMenu() {
		Helper.line(60, "=");
		System.out.println("LOG IN TO SCHOOL LUNCHBOX ONLINE");
		Helper.line(60, "=");
		System.out.println("1. User");
		System.out.println("2. Vendor");
		System.out.println("3. Administrator");
		System.out.println("4. Register");
		System.out.println("5. End");
	}

	private static void Menu() {
		Helper.line(60, "=");
		System.out.println("WELCOME TO SCHOOL LUNCHBOX ONLINE");
		Helper.line(60, "=");
		System.out.println("1. View Menu");
		System.out.println("2. Start Ordering");
		System.out.println("3. Tracking/View Order");
		System.out.println("4. Rate/Feedbacks");
		System.out.println("5. Add Child");
		System.out.println("6. Add Child's Allergies");
		System.out.println("7. Add Credit Card");
		System.out.println("8. End");
	}

	private static void GeneralUI(String ParentName) {
		Loop1: while (option != Max_option_general) {
			Menu();
			option = Helper.readInt("Enter choice: ");
			if (option == 1) {
				ViewMenu();
			} else if (option == 2) {
				StartOrder();
			} else if (option == 3) {
				String OrderId = Helper.readString("Enter Order ID: ");
				trackOrder(ParentName, OrderId);
			} else if (option == 4) {
				Rating(ParentName);
			} else if (option == 5) {
				addChild(ParentName);
			} else if (option == 6) {
				addAllergies(ParentName);
			} else if (option == 7) {
				CreditCard(ParentName);
			} else if (option == Max_option_general) {
				break Loop1;
			}
		}
	}

	private static void MenuAdmin() {
		Helper.line(60, "=");
		System.out.println("Administrator Mode");
		Helper.line(60, "=");
		System.out.println("1. Manage School Information");
		System.out.println("2. Manage Accounts Overview");
		System.out.println("3. Manage Vendors");
		System.out.println("4. Generate Report");
		System.out.println("5. End");
	}

	private static void AdminUI(String AdminName) {
		MenuAdmin();
		option = Helper.readInt("Enter choice: ");
		loop2: while (option != Max_option_admin) {
			if (option == 1) {
				ManageSchInfo();
			} else if (option == 2) {
				ManageAcc();
			} else if (option == 3) {
				ManageVendor();
			} else if (option == 4) {
				generateReport();
			} else if (option == Max_option_admin) {
				break loop2;
			}
		}
	}

	private static void MenuVendor() {
		Helper.line(60, "-");
		System.out.println("Vendor Mode");
		Helper.line(60, "-");
		System.out.println("1. Add Items");
		System.out.println("2. Delete Items");
		System.out.println("3. Edit Items");
		System.out.println("4. FeedBacks");
		System.out.println("5. Edit Email/Location address");
		System.out.println("6. View Menu");
		System.out.println("7. End");

	}

	private static void VendorUI(String VendorName) {
		Loop3: while (option != Max_option_vendor) {
			MenuVendor();
			option = Helper.readInt("Enter choice: ");
			if (option == 1) {
				AddItems(VendorName);
			} else if (option == 2) {
				DelItems(VendorName);
			} else if (option == 3) {
				EditItems(VendorName);
			} else if (option == 4) {
				ViewFB(VendorName);
			} else if (option == 5) {
				EditInfo(VendorName);
			} else if (option == 6) {
				ViewMenu(VendorName);
			} else if (option == Max_option_vendor) {
				break Loop3;
			}
		}
	}

//Main Start

	// The creation of Menu
	private static ArrayList<Menu> MenuListCreation(ArrayList<Vendor> VendorList, ArrayList<Menu> menuList2,
			LocalDate date) {
		// Check if the date is within range
		boolean checkValid = Helper.isValidRangeDate(date);
		if (checkValid == true) {
			for (Vendor V : VendorList) {
				for (Meals M : V.getMenu()) {
					Menu Menu = new Menu(date, M);
					menuList2.add(Menu);
				}
			}
		}

		return menuList2;
	}

	// For Menu Viewing
	private static void ViewMenu() {
		LocalDate date = Helper.readLocalDate("Enter Day: ");
		String ChildName = Helper.readString("Enter your Child's name: ");
		// The creation of MenuList
		MenuListCreation(VendorList, MenuList, date);
		for (Parents P : ParentAccounts) {
			Child C = getChildByName(ChildName, P.getName());
			// Verify if child has restrictions or not
			boolean hasRestrictions = !C.getRestrictions().isEmpty();

			for (Menu menu : MenuList) {
				// Check if Date exist in Menu
				boolean checkMenuGotDate = Helper.containDate(menu.getDate(), date);
				if (checkMenuGotDate) {
					getMenuExist(C, hasRestrictions, menu);
				} else {
					System.out.println("Meals not available for that day!");
				}
			}
		}
	}

	/**
	 * @param C
	 * @param hasRestrictions
	 * @param menu
	 */
	private static void getMenuExist(Child C, boolean hasRestrictions, Menu menu) {
		System.out.println("Menu for " + menu.getDate() + ":");
		for (Meals meal : menu.getFoodMenu()) {
			// If restriction is true then it will find tags containing all the description
			// from child
			if (!hasRestrictions || meal.getMealTags().containsAll(C.getRestrictions())) {
				printMenu(meal);
				// If child does not have restriction
			} else if (hasRestrictions) {
				printMenu(meal);
			}
		}
	}

	// This is for the printMenu list
	private static void printMenu(Meals meal) {
		System.out.println("Name: " + meal.getName());
		System.out.println("Description: " + meal.getDescription());
		System.out.println("Price: " + meal.getPrice());
		System.out.println("----------------------");
	}

	private static void StartOrder() {
		String parentName = Helper.readString("Enter your Name: ");
		String childName = Helper.readString("Enter Child's Name per NRIC: ");

		Parents parent = getParentByName(parentName);
		if (parent == null) {
			System.out.println("Parent not found");
			return;
		}
		Child child = getChildByName(childName, parentName);
		if (child == null) {
			System.out.println("Child not found");
			return;
		}
		ArrayList<Meals> childMenu = new ArrayList<>();
		for (Menu ML : MenuList) {
			for (Meals M : ML.getFoodMenu()) {
				if (!M.getMealTags().containsAll(child.getRestrictions())) {
					childMenu.add(M);
				}
			}
		}

		System.out.println("Child's Menu");
		for (int i = 0; i < childMenu.size(); i++) {
			System.out.printf("%d. %s", (i + 1), childMenu.get(i).getName());
		}

		int mealChoice = Helper.readIntRange("Enter the number of the meal you want to order: ", 1, childMenu.size());
		int qty = Helper.readIntRange("Enter the quantity: ", 1, Integer.MAX_VALUE);

		Meals selectMeal = childMenu.get(mealChoice - 1);
		Vendor vendor = getVendorByMeal(VendorList, selectMeal);
		if (vendor == null) {
			System.out.println("Vendor not found.");
			return;
		}

		if (selectMeal.getQty() < qty) {
			System.out.println("Vendor has insufficient quantity for this meal!");
			return;
		}

		double ttAmt = selectMeal.getPrice() * qty;
		double gst = ttAmt * 1.08;
		System.out.println("Total Amount: $" + gst);
		System.out.println("GST:        : 8%");

		boolean cfm = Helper.readBoolean("Confirm purchase? [y/n]: ");
		if (!cfm) {
			System.out.println("Purchase canceled!");
			return;
		}

		boolean authenticate = PaymentVerification(parent.getName(), gst);
		if (!authenticate) {
			System.out.println("Payment failed!");
			return;
		}

		verifyOrderVendorqty(parent, child, qty, gst, selectMeal, vendor);
	}

	/**
	 * @param parent
	 * @param child
	 * @param qty
	 * @param selectMeal
	 * @param vendor
	 */
	private static void verifyOrderVendorqty(Parents parent, Child child, int qty, double ttAmt, Meals selectMeal,
			Vendor vendor) {
		// Deduct quantity from vendor and update meal quantity
		int newVendorQty = vendor.getMenu().get(vendor.getMenu().indexOf(selectMeal)).getQty() - qty;
		vendor.updateMealQty(selectMeal.getName(), newVendorQty);
		selectMeal.setQty(selectMeal.getQty() - qty);

		// Create and add the order to the order list
		Ordering order = new Ordering(parent.getName(), child.getChildName(), LocalDate.now(), ttAmt);
		order.addItem(selectMeal, qty, order.getItems());
		parent.getOrderHistory().add(order);

		System.out.println("Order placed successfully.");
	}

	private static boolean PaymentVerification(String parentName, double amount) {
		String ccNH = Helper.readString("Enter Card Holder Name: ");
		String cc = Helper.readString("Enter CreditCard Number: ");
		String cvc = Helper.readString("Enter CVC Number: ");
		LocalDate date = Helper.readLocalDateCC("Enter Expiry date (mm/yyyy): ");

		boolean validation = false;
		for (Parents P : ParentAccounts) {
			if (P.getName().equalsIgnoreCase(parentName)) {
				for (PaymentGateway PG : P.getCC()) {
					boolean Verified = PG.authenticate(ccNH, cc, cvc, date);
					if (Verified) {
						System.out.println("Payment successful!");
						validation = true;
						PG.setCreditAmt(PG.getCreditAmt() - amount);
					}
				}
			}
		}
		return validation;
	}

	private static void trackOrder(String parentName, String orderID) {
		Parents parent = getParentByName(parentName);
		int i = 0;
		if (parent != null) {
			for (Ordering O : parent.getOrderHistory()) {
				if (O != null) {
					boolean trackingOrder = O.getTrackingOrder();
					String status = trackingOrder ? "Pending" : "Arrived";
					System.out.println(
							String.format("Order Details:\n" + "No. order: %s\n" + "OrderID: %s\n" + "Status: %s",
									i + 1, orderID, status));
				} else {
					System.out.println("Order not found.");
				}
			}
		} else {
			System.out.println("Parent not found.");
		}
	}

	private static void Rating(String parentName) {
		String orderId = Helper.readString("Enter Order ID: ");
		Ordering order = getOrderbyIDnParent(parentName, orderId);

		if (order != null) {
			int mealIndex = 1;
			System.out.println("Rate the following meals: ");
			for (Meals OM : order.getItems()) {
				for (Vendor V : VendorList) {
					for (Meals VM : V.getMenu()) {
						if (OM.getName().equalsIgnoreCase(VM.getName())) {
							System.out.printf("%d. Vendor: %s\n    Meal: %s\n    Description: %s\n", mealIndex,
									V.getName(), VM.getName(), VM.getDescription());
							Helper.line(45, "-");
							mealIndex++;
						}
					}
				}
			}

			int selectMealNo = Helper.readIntRange("Enter the number of the meal you want to review: ", 1,
					mealIndex - 1);
			mealIndex = 1;

			for (Meals OM : order.getItems()) {
				for (Vendor V : VendorList) {
					for (Meals VM : V.getMenu()) {
						if (OM.getName().equalsIgnoreCase(VM.getName()) && mealIndex == selectMealNo) {
							System.out.println("Review for: Vendor - " + V.getName() + ", Meal - " + VM.getName());
							int rateFood = Helper.readIntRange("Rate the food (1-5): ", 1, 5);
							int rateExperience = Helper.readIntRange("Rate the experience (1-5): ", 1, 5);
							String improvements = Helper.readString("Enter improvements: ");

							Review review = new Review(rateExperience, rateFood, improvements, parentName);
							V.addReview(review);

							System.out.println("Thank you for your review!");
							return;
						}
						mealIndex++;
					}
				}
			}

			System.out.println("Invalid Meal Number!");
		} else {
			System.out.println("Order not found!");
			return;
		}
	}

	private static void addChild(String ParentName) {
		for (Parents P : ParentAccounts) {
			if (P.getName().equalsIgnoreCase(ParentName)) {
				for (Child C : P.getChildren()) {
					String ic = Helper.readStringRegEx("Enter Child's NRIC [e.g T/G/M######A]:", IC_Pattern);
					String name = Helper.readStringRegEx("Enter Full Name per NRIC: ", Name_Pattern);
					String schName = Helper.readString("Enter School Name: ");
					boolean forRestrictions = Helper.readBoolean("Does you child have allergies? [y/n]: ");
					if (forRestrictions == true) {
						String restriction = Helper.readString(
								"Enter Child's Restrictions if more than one add a ',' inbetween(e.g halal, peanut allergy):");
						String[] restrict = restriction.split(",");
						for (String R : restrict) {
							C.addRestrictions(R.toString());
						}
						P.addChildren(new Child(ic, name, schName, C.getRestrictions()));
						System.out.println("Child added!");
						break;
					} else {
						System.out.println("Child added!");
						P.addChildren(new Child(ic, name, schName));
						break;
					}
				}
			}
		}
	}

	private static void addAllergies(String ParentName) {
		String ic = Helper.readStringRegEx("Enter Child's NRIC: ", IC_Pattern);
		String name = Helper.readStringRegEx("Enter Child name per NRIC: ", Name_Pattern);
		Parents P = getParentByName(ParentName);
		for (Child C : P.getChildren()) {
			if (C.getChildName().equalsIgnoreCase(name) && C.getId().equalsIgnoreCase(ic)) {
				String restriction = Helper.readString(
						"Enter Child's Restrictions if more than one add a ',' inbetween(e.g halal, peanut allergy):")
						.toLowerCase();
				String[] restrict = restriction.split(",");
				for (String R : restrict) {
					C.addRestrictions(R);
				}
				System.out.println("Child's Restrictions Updated!");
			} else {
				System.out.println("Child does not exist!");
			}
		}
	}

	private static void CreditCard(String parentName) {
		int options = -1;
		while (options != 3) {
			System.out.println("1. Add Credit Card?");
			System.out.println("2. Add Credits?");
			options = Helper.readInt("Enter options:");
			if (options == 1) {
				creditCardOption1(parentName);
			} else if (options == 2) {
				creditCardOption2(parentName);
			} else if (options == 3) {
				break;
			} else {
				System.out.println("Invalid options!");
			}
		}
	}

	/**
	 * @param parentName
	 */
	private static void creditCardOption1(String parentName) {
		String ccvp = "^4[0-9]{12}(?:[0-9]{3})?$";
		String ccmp = "^5[1-5][0-9]{14}$";
		String cvcp = "^[0-9]{3,4}$";
		String ccNH = Helper.readString("Enter Card Holder Name: ");
		String cc = Helper.readString("Enter CreditCard Number: ");
		String cvc = Helper.readStringRegEx("Enter CVC Number: ", cvcp);
		LocalDate date = Helper.readLocalDateCC("Enter Expiry date (mm/yyyy): ");
		if (Helper.readBooleanRegEx(cc, ccmp) || Helper.readBooleanRegEx(cc, ccvp)) {
			Parents parent = getParentByName(parentName);
			parent.getCC().add(new PaymentGateway(ccNH, cc, cvc, date));
			System.out.println("Credit Card Added!");
		}
	}

	/**
	 * @param parentName
	 */
	private static void creditCardOption2(String parentName) {
		String ccNH = Helper.readString("Enter Card Holder Name: ");
		String cc = Helper.readString("Enter CreditCard Number: ");
		String cvc = Helper.readString("Enter CVC Number: ");
		LocalDate date = Helper.readLocalDateCC("Enter Expiry date (mm/yyyy): ");
		Parents P = getParentByName(parentName);
		for (PaymentGateway PG : P.getCC()) {
			if (PG.authenticate(ccNH, cc, cvc, date)) {
				double ccAmt = Helper.readDouble("Enter Credit Amount: ");
				System.out.println("Payment Successful!\nCredit Added to wallet!");
				PG.setCreditAmt(ccAmt);
			}
		}
	}

//Main End

//Admin Start
	private static void ManageSchInfo() {
		int d = 1;
		Helper.line(60, "-");
		System.out.printf("%-2s.|%20s|\n", "No", "School Name");
		for (Parents P : ParentAccounts) {
			for (Child C : P.getChildren()) {
				String SchoolName = Helper.capitalizedWords(C.getSchName());

				if (!SchoolList.contains(SchoolName)) {
					SchoolList.add(SchoolName);
					System.out.printf("%-2d.|%20s|\n", d, SchoolName);
					d++;
				}
			}
		}
	}

	private static void ManageAcc() {
		LoopStart: while (true) {
			int MinIndex = 0;
			int MaxIndex = Math.min(10, ParentAccounts.size());
			for (int i = MinIndex; i < MaxIndex; i++) {
				Parents PA = ParentAccounts.get(i);
				System.out.printf("%d. Name:%s\n", i + 1, PA.getName());
			}

			if (MaxIndex > ParentAccounts.size()) {
				System.out.println("No More Vendors");
				break LoopStart;
			}

			boolean input = Helper.readBoolean("Show 10 more? (y/n): ");
			if (input == true) {
				MinIndex = MaxIndex;
				MaxIndex = Math.min((MinIndex + 10), ParentAccounts.size());
			} else {
				System.out.println("END");
				break LoopStart;
			}

		}
	}

	private static void ManageVendor() {
		boolean valid = true;
		LoopStart: while (valid) {
			int MinIndex = 0;
			int MaxIndex = Math.min(10, VendorList.size());
			Helper.line(60, "-");
			System.out.format("%-4s|%-15s|%-20s|%-25s|\n", "No.", "Name", "Email", "Address");
			for (int i = MinIndex; i < MaxIndex; i++) {
				Vendor V = VendorList.get(i);
				System.out.format("%-4d|%-15s|%-20s|%-25s|\n", i + 1, V.getName(), V.getEmail(), V.getAddress());
				Helper.line(60, "-");
			}
			if (!(MaxIndex < VendorList.size())) {
				boolean input = Helper.readBoolean("Show 10 more? (y/n): ");
				if (input == true) {
					MinIndex = MaxIndex;
					MaxIndex = Math.min((MinIndex + 10), VendorList.size());
				} else {
					System.out.println("END");
					valid = false;
					break LoopStart;
				}
			} else if (MaxIndex > VendorList.size()) {
				System.out.println("No More Vendors");
				valid = false;
				break LoopStart;
			}
		}
	}

	private static void generateReport() {
		while (true) {
			reportMenu();
			int option = Helper.readInt("Enter Report Option: ");
			if (option == 1) {
				LocalDate targetDate = Helper.readLocalDateFormatter("Enter date (YYYY-MM-DD) for daily sales report: ",
						"yyyy-MM-dd");
				generateDailyReport(targetDate);
			} else if (option == 2) {
				int year = Integer
						.parseInt(Helper.readStringRegEx("Enter the year for the monthly sales report:", "20[0-9]{2}"));
				int month = Integer.parseInt(Helper
						.readStringRegEx("Enter the month (1-12) for the monthly sales report:", "^(1[0-2]|[1-9])$"));
				YearMonth targetDate = YearMonth.of(year, month);
				generateMonthlyReport(targetDate);
			} else if (option == 3) {
				System.out.println("End Reports");
				break;
			}
		}
		return;
	}

	private static void reportMenu() {
		Helper.line(45, "=");
		System.out.println("Sales report");
		Helper.line(45, "=");
		System.out.println("1. Daily Report");
		System.out.println("2. Monthly Report");
		System.out.println("3. End");

	}

	private static void generateMonthlyReport(YearMonth targetMonth) {
		System.out.println("Sales Report for " + targetMonth);

		double totalSales = 0.0;

		for (Parents parent : ParentAccounts) {
			for (Ordering order : parent.getOrderHistory()) {
				LocalDate orderDate = order.getDate();
				YearMonth orderYearMonth = YearMonth.of(orderDate.getYear(), orderDate.getMonth());

				if (orderYearMonth.equals(targetMonth)) {
					double orderTotal = order.getTotalAmount();
					totalSales += orderTotal;

					System.out.println("Parent: " + parent.getName());
					System.out.println("Order ID: " + order.getOrderId());
					System.out.println("Order Date: " + orderDate);
					System.out.println("Order Total: $" + orderTotal);
					System.out.println("-----------------------------------");
				}
			}
		}

		System.out.println("Total Sales for " + targetMonth + ": $" + totalSales);
	}

	private static void generateDailyReport(LocalDate targetDate) {
		System.out.println("Sales Report for " + targetDate);

		double totalSales = 0.0;

		for (Parents parent : ParentAccounts) {
			for (Ordering order : parent.getOrderHistory()) {
				LocalDate orderDate = order.getDate();

				if (orderDate.equals(targetDate)) {
					double orderTotal = order.getTotalAmount();
					totalSales += orderTotal;

					System.out.println("Parent: " + parent.getName());
					System.out.println("Order ID: " + order.getOrderId());
					System.out.println("Order Date: " + orderDate);
					System.out.println("Order Total: $" + orderTotal);
					System.out.println("-----------------------------------");
				}
			}
		}

		System.out.println("Total Sales for " + targetDate + ": $" + totalSales);
	}

//Admin End

//Vendor Start
	private static void AddItems(String VendorName) {
		String name = Helper.readString("Enter name of dish: ");
		String description = Helper.readString("Enter description of dish: ");
		double price = Helper.readDouble("Set price of dish: ");
		int qty = Helper.readInt("Enter quantity set for dish: ");
		boolean valid = Helper.readBoolean("Do you want to add Allergy Tags? [y/n]: ");
		Vendor V = getVendorByName(VendorName);
		for (Meals M : V.getMenu()) {
			if (name.equalsIgnoreCase(M.getName()) && valid == false) {
				V.getMenu().add(new Meals(name, description, price, qty));
			} else if (name.equalsIgnoreCase(M.getName()) && valid == true) {
				String tags = Helper.readString(
						"Enter Restriction tags if more than one add a ',' inbetween(e.g halal, peanut allergy): ")
						.toLowerCase();
				String[] addTags = tags.split(",");
				for (int i = 0; i < addTags.length; i++) {
					addTags[i] = addTags[i].trim();
					M.addMealTags(addTags[i]);
				}
				V.getMenu().add(new Meals(name, description, price, qty, M.getMealTags()));
			} else {
				System.out.println("Item exist!");
			}
		}
	}

	private static void DelItems(String VendorName) {
		String name = Helper.readString("Enter name of dish: ");
		boolean valid = Helper.readBoolean("Remove certain Restrictions? [y/n]: ");
		Vendor V = getVendorByName(VendorName);
		for (int M = 0; M < V.getMenu().size(); M++) {
			Meals m = V.getMenu().get(M);
			if (m.getName().equalsIgnoreCase(name) && valid == false) {
				V.getMenu().remove(m);
				System.out.println("Item Removed!");
			} else if (m.getName().equalsIgnoreCase(name) && valid == true) {
				String tags = Helper.readString(
						"Enter Restriction tags to remove, if more than one add a ',' inbetween(e.g halal, peanut allergy): ")
						.toLowerCase();
				String[] addTags = tags.split(",");
				for (int i = 0; i < addTags.length; i++) {
					addTags[i] = addTags[i].trim();
					if (m.getMealTags().contains(addTags[i])) {
						V.getMenu().remove(i);
					}
				}
				System.out.println("Restrictions removed!");
			} else {
				System.out.println("Item does not exist!");
			}
		}
	}

	private static void EditItems(String VendorName) {
		String pattern = "(?i)(name|description|price|quantity|qty|restrict|restriction(s))";
		String edit = Helper.readStringRegEx("Which option you want to edit?[e.g Description]:", pattern);
		String nameItem = Helper.readString("Enter name of item: ");
		Vendor V = getVendorByName(VendorName);
		for (Meals M : V.getMenu()) {
			if (nameItem.equalsIgnoreCase(M.getName())) {
				if (edit.equalsIgnoreCase("name")) {
					String NameChange = Helper.readString("Enter new name: ");
					M.setName(NameChange);
				} else if (edit.equalsIgnoreCase("description")) {
					String DescChage = Helper.readString("Update description: ");
					M.setDescription(DescChage);
				} else if (edit.equalsIgnoreCase("price")) {
					double newPrice = Helper.readDouble("Update price: ");
					M.setPrice(newPrice);
				} else if (Helper.equalIgnoreCaseRegEx(edit, "(?i)(quantity|qty)")) {
					int newQty = Helper.readInt("Update quantity: ");
					M.setQty(newQty);
				} else if (Helper.equalIgnoreCaseRegEx(edit, "(?i)(restrict(ion(s)?)")) {
					String tags = Helper.readString(
							"Enter Restriction tags if more than one add a ',' inbetween(e.g halal, peanut allergy): ")
							.toLowerCase();
					String[] addTags = tags.split(",");
					for (int i = 0; i < addTags.length; i++) {
						addTags[i] = addTags[i].trim();
						M.addMealTags(addTags[i]);
					}

				}
			}
		}
	}

	private static void ViewFB(String VendorName) {
		Vendor V = getVendorByName(VendorName);
		int MinIndex = 0;
		int x = 1;
		int MaxIndex = Math.min(5, V.getReviews().size());
		Page_Loop: while (true) {
			for (int i = MinIndex; i < MaxIndex; i++) {
				Review R = V.getReviews().get(i);
				System.out.printf("%d. Food Rating: %d\nExperience Rating: %d\nDescription:\n%s", x + 1,
						R.getRateFood(), R.getRateExperience(), R.getImprovements());
			}

			if (MaxIndex >= V.getReviews().size()) {
				System.out.println("Null");
				break Page_Loop;
			}

			boolean input = Helper.readBoolean("Show 5 more? (y/n): ");
			if (input == true) {
				MinIndex = MaxIndex;
				MaxIndex = Math.min((MinIndex + 5), V.getReviews().size());
			} else {
				System.out.println("END");
				break Page_Loop;
			}
		}
	}

	private static void EditInfo(String VendorName) {
		String Pattern = "(?i)(email|address)";
		String Choice = Helper.readStringRegEx("Which option you want to edit?[e.g Address]", Pattern);
		Vendor V = getVendorByName(VendorName);
		if (V == null) {
			System.out.println("Vendor does not exist");
			return;
		}
		if (Choice.equalsIgnoreCase("Email")) {
			String EmailPattern = "[a-zA-Z0-9]+@[a-zA-Z0-9.-]+\\\\.(com|sg|co|org)";
			String NewEmail = Helper.readStringRegEx("Update Email", EmailPattern);
			V.setEmail(NewEmail);
		} else if (Choice.equalsIgnoreCase("Address")) {
			String NewAddress = Helper.readString("Update Address: ");
			V.setAddress(NewAddress);
		}
	}

	private static void ViewMenu(String VendorName) {
		Vendor V = getVendorByName(VendorName);
		if (V == null) {
			System.out.println("Vendor does not exist");
			return;
		}

		for (Meals M : V.getMenu()) {
			System.out.printf("Name: %s\nDescription: %s\nPrice: %f.2\nQuantity: %d\n", M.getName(), M.getDescription(),
					M.getPrice(), M.getQty());
		}

	}
//Vendor End

//Help function

	// Refactor the loop for vendor by specific meals
	private static Vendor getVendorByMeal(ArrayList<Vendor> VendorList, Meals selectedMeal) {
		for (Vendor V : VendorList) {
			for (Meals M : V.getMenu()) {
				if (M.getName().equalsIgnoreCase(selectedMeal.getName())) {
					return V;
				}
			}
		}
		return null;
	}

	// Refactor the loop for vendor by Name
	private static Vendor getVendorByName(String vendorName) {
		for (Vendor V : VendorList) {
			if (V.getName().equalsIgnoreCase(vendorName)) {
				return V;
			}
		}
		return null;
	}

	// refactor the loop for parents by Name
	private static Parents getParentByName(String parentName) {
		for (Parents P : ParentAccounts) {
			if (P.getName().equalsIgnoreCase(parentName)) {
				return P;
			}
		}
		return null;
	}

	// refactor the loop for children from parents class by Name
	private static Child getChildByName(String childName, String parentName) {
		Parents P = getParentByName(parentName);
		if (P != null) {
			for (Child C : P.getChildren()) {
				if (C.getChildName().equalsIgnoreCase(childName)) {
					return C;
				}
			}
		}
		return null;
	}

	// refactor the loop for orders from parent from order
	private static Ordering getOrderbyIDnParent(String parentName, String orderId) {
		Parents parent = getParentByName(parentName);
		for (Ordering O : parent.getOrderHistory()) {
			if (O.getOrderId().equalsIgnoreCase(orderId)) {
				return O;
			}
		}
		return null;
	}
}
