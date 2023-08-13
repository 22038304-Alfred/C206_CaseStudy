import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;

public class C206_CaseStudy {
	private static int option = 0;
	private static final String IC_Pattern = "(?i)[tgm][0-9]{7}[a-zA-Z]";
	private static final String Name_Pattern = "[a-zA-Z]";
	private static ArrayList<Vendor> VendorList = new ArrayList<Vendor>();
	private static ArrayList<Menu> MenuList = new ArrayList<Menu>();
	private static ArrayList<Parents> ParentAccounts = new ArrayList<Parents>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		// Parents Account
		ParentAccounts.add(new Parents("Default1", "Pass123"));
		ParentAccounts.add(new Parents("Default2", "Pass123"));

		// Creating a Meals for vendors and Vendors' account
		ArrayList<Meals> VendorMeal1 = new ArrayList<Meals>();
		ArrayList<Meals> VendorMeal2 = new ArrayList<Meals>();
		VendorMeal1.add(new Meals("Chicken Rice", "Traditional and Fragrant Dish!", 1200, "Chineses"));
		VendorMeal1.add(new Meals("Nasi Lemak", "Delicious and flavourful!", 1300, "Malay"));
		VendorMeal2.add(new Meals("Meatless Don", "Unique and Tasty!", 1400, "Japanese"));
		VendorMeal2.add(new Meals("Veg Quiche", "Flaky and crumbly!", 1500, ""));
		VendorList.add(new Vendor("Vendor1", "ABC@coporation.org", 83294920,"AMK Hub #1-23,123567", VendorMeal1));
		VendorList.add(
				new Vendor("Vendor2", "EFG@coporation.org", 93034040, "Bishan Junction 8 #1-23,123564", VendorMeal2));
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
	
	private static void viewCuisine() {
		ArrayList<String> cuisineType = new ArrayList<>();
		for(Menu ML: MenuList) {
			for(Meals M: ML.getFoodMenu()) {
				String types = M.getType();
				if(!cuisineType.contains(types.toLowerCase())) {
					cuisineType.add(types);
				}
			}
		}
		int i=0;
		System.out.println("No. Cuisine Type\n");
		for(String ct: cuisineType) {
			System.out.printf("%d. %s\n", i+1, ct);
		}
	}

	// For Menu Viewing
	private static void ViewMenu() {
		LocalDate date = Helper.readLocalDate("Enter Day: ");
		String ChildName = Helper.readString("Enter your Child's name: ");
		// The creation of MenuList
		MenuListCreation(VendorList, MenuList, date);
		for (Parents P : ParentAccounts) {
			Child C = getChildByName(ChildName, P.getName());
			if (C != null) {
				for (Menu menu : MenuList) {
					// Check if Date exist in Menu
					viewCuisine();
					boolean checkMenuGotDate = Helper.containDate(menu.getDate(), date);
					if (checkMenuGotDate) {
						String category = Helper.readString("Enter type of Cuisine: ");
						for (Meals M : menu.getFoodMenu()) {
							if (M.getType().equalsIgnoreCase(category)) {
								printMenu(M);
							}
						}
					} else {
						System.out.println("Meals not available for that day!");
						break;
					}
				}
			} else {
				System.out.println("Child does not exist!");
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
		String category = Helper.readString("Enter type of Meal e.g [Indian, Malay, Chinese]: ");
		for (Menu ML : MenuList) {
			for (Meals M : ML.getFoodMenu()) {
				if (M.getType().equalsIgnoreCase(category)) {
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

		verifyOrderVendorqty(parent, child, gst, selectMeal, vendor);
	}

	/**
	 * @param parent
	 * @param child
	 * @param selectMeal
	 * @param vendor
	 */
	private static void verifyOrderVendorqty(Parents parent, Child child, double ttAmt, Meals selectMeal,
			Vendor vendor) {
		// Deduct quantity from vendor and update meal quantity

		// Create and add the order to the order list
		Ordering order = new Ordering(parent.getName(), child.getChildName(), LocalDate.now(), ttAmt);
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
					}
				}
			}
		}
		return validation;
	}

	private static void viewOrder(String parentName) {
		Parents parent = getParentByName(parentName);
		int i = 0;
		
		// Check if parent exist
		if(parent == null){
			System.out.println("Parent not found.");
			return;
		}
		
		// Iterate through the parent's Order History
		if (parent != null) {
			for (Ordering O : parent.getOrderHistory()) {
				if (O != null) {
					boolean trackingOrder = O.getTrackingOrder();
					// Check if the order has arrived(false) or pending(true)
					String status = trackingOrder ? "Not Shipped" : "Delievered";
					System.out.println(
							String.format("Order Details:\nNo. order: %s\nOrderID: %s\nStatus: %s\n",
									i + 1, O.getOrderId(), status));
				} else {
					// If the orderHistory is null
					System.out.println("Order not found.");
					return;
				}
			}
		}

	}
	
	private static void delOrder(String parentName, String orderID) {
		Parents parent = getParentByName(parentName);
		String mealTitle = "\nMeals:\n%-2s %-10s %-5s\n";
		String format = "%-2d %-10s %-5.2f\n";
		if(parent == null) {
			System.out.println("Parent not found!");
			return;
		}
		
		if(parent != null) {
			for (int i = 0; i < parent.getOrderHistory().size(); i++) {
				Ordering O = parent.getOrderHistory().get(i);
				if(O != null && O.getOrderId().equalsIgnoreCase(orderID)) {
					boolean trackingOrder = O.getTrackingOrder();
					// Check if the order has arrived(false) or pending(true)
					// To check if the order has arrived already
					String status = trackingOrder ? "Not Shipped" : "Delivered";
					if(status.equals("Delivered")) {
						System.out.println("Order Details:\nOrderID: "+O.getOrderId());
						System.out.printf(mealTitle, "No.", "Meal Name", "Price");
						for(Meals M : O.getItems()) {
							System.out.printf(format, i+1, M.getName(), M.getPrice());
						}
						boolean delVerification = Helper.readBoolean("Do you want to remove this order from your order history? [y/n]: ");
						if(delVerification == true) {
							parent.getOrderHistory().remove(i);
							System.out.println("Order removed from history!");
							return;
						}else {
							return;
						}
					}else {
						System.out.println("Order is still pending!");
					}
					
				}else {
					System.out.println("Order does not exist!");;
					return;
				}
			}
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

	private static void addVendor() {
		String name = Helper.readString("Enter Name of Vendor");
		String email = Helper.readStringRegEx("Enter Email address: ","[a-ZA-Z0-9]@[a-zA-Z0-9].(com|org)");
		int contactNo = Integer.parseInt(Helper.readStringRegEx("Enter Contact No.", "[89][0-9]{7}"));
		String address = Helper.readString("Enter Address: ");
		VendorList.add(new Vendor(name,email,contactNo,address));
		System.out.println("Vendor Added!");
		
	}
	
	private static void delVendor() {
		String name = Helper.readString("Enter Name of Vendor");
		String email = Helper.readStringRegEx("Enter Email address: ","[a-ZA-Z0-9]@[a-zA-Z0-9].(com|org)");
		int contactNo = Integer.parseInt(Helper.readStringRegEx("Enter Contact No.", "[89][0-9]{7}"));
		String address = Helper.readString("Enter Address: ");
		for(int i=0; i<VendorList.size(); i++) {
			Vendor V = VendorList.get(i);
			if(V.getName().equalsIgnoreCase(name) && V.getEmail().equals(email) &&
					V.getContactNo() == contactNo && V.getAddress().equals(address)) {
				VendorList.remove(i);
				System.out.println("Vendor Removed!");
			}else {
				System.out.println("Information incorrect!");
			}
		}
	}
	
	private static void viewAllVendor() {
		String format = "No. | %-20s | %-30s | %-15s | %-50s\n";
		Helper.line(45,"-");
		System.out.printf(format, "Vendor Name", "Vendor Email", "Contact No.", "Address");
		Helper.line(45,"-");
		for(int i = 0; i < VendorList.size(); i++) {
			Vendor V = VendorList.get(i);
			System.out.printf(format, V.getName(), V.getEmail(), V.getContactNo(),V.getAddress());
		}
	}
//Admin End

	//Vendor Start
		private static void AddItems(String VendorName) {
			String name = Helper.readString("Enter name of dish: ");
			String description = Helper.readString("Enter description of dish: ");
			double price = Helper.readDouble("Set price of dish: ");
			String type = Helper.readString("Enter type of Cuisine");

			Vendor V = getVendorByName(VendorName);
			for (Meals M : V.getMenu()) {
				if (name.equalsIgnoreCase(M.getName())) {
					V.getMenu().add(new Meals(name, description, price, type));
				} else {
					System.out.println("Item exist!");
				}
			}
		}

		private static void DelItems(String VendorName) {
			String name = Helper.readString("Enter name of dish: ");
			Vendor V = getVendorByName(VendorName);
			for (int M = 0; M < V.getMenu().size(); M++) {
				Meals m = V.getMenu().get(M);
				if (m.getName().equalsIgnoreCase(name)) {
					V.getMenu().remove(m);
					System.out.println("Item Removed!");
				} else {
					System.out.println("Item does not exist!");
				}
			}
		}

		private static void EditItems(String VendorName) {
			String pattern = "(?i)(name|description|price)";
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
				System.out.printf("Name: %s\nDescription: %s\nPrice: %f.2\n", M.getName(), M.getDescription(),
						M.getPrice());
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
	public static Vendor getVendorByName(String vendorName) {
		for (Vendor V : VendorList) {
			if (V.getName().equalsIgnoreCase(vendorName)) {
				return V;
			}
		}
		return null;
	}

	// refactor the loop for parents by Name
	public static Parents getParentByName(String parentName) {
		for (Parents P : ParentAccounts) {
			if (P.getName().equalsIgnoreCase(parentName)) {
				return P;
			}
		}
		return null;
	}

	// refactor the loop for children from parents class by Name
	public static Child getChildByName(String childName, String parentName) {
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
	public static Ordering getOrderbyIDnParent(String parentName, String orderId) {
		Parents parent = getParentByName(parentName);
		for (Ordering O : parent.getOrderHistory()) {
			if (O.getOrderId().equalsIgnoreCase(orderId)) {
				return O;
			}
		}
		return null;
	}
}
