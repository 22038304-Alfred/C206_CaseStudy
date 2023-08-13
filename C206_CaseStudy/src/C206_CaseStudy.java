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
		
		ArrayList<Ordering> P1Order = new ArrayList<>();
		ArrayList<Ordering> P2Order = new ArrayList<>();

		ArrayList<Child> children1 = new ArrayList<>();
		ArrayList<Child> children2 = new ArrayList<>();

		// Generate sample children for parents
		Child child1 = new Child("C1", "Child1", "School1");
		Child child2 = new Child("C2", "Child2", "School1");
		Child child3 = new Child("C3", "Child3", "School2");
		Child child4 = new Child("C4", "Child4", "School2");

		children1.add(child1);
		children1.add(child2);

		children2.add(child3);
		children2.add(child4);

		// Generate sample meals for orders
		ArrayList<Meals> VendorMeal1 = new ArrayList<>();
		VendorMeal1.add(new Meals("Chicken Rice", "Traditional and Fragrant Dish!", 4.50, "Chinese"));
		VendorMeal1.add(new Meals("Siew Mai", "Savoury and bite-sized delight!", 2.70, "Chinese"));
		VendorMeal1.add(new Meals("Minced Braised Pork", "Braised pork with aromatic spices and herbs served on rice", 4.00, "Taiwanese"));
		VendorMeal1.add(new Meals("Mapo Tofu", "Spicy tofu dish with minced meat and sichuan peppers", 5.10, "Chinese"));
		VendorMeal1.add(new Meals("Scallian Pancake", "Savoury flaky pancakes with chopped scallions", 2.90, "Taiwanese"));
		VendorMeal1.add(new Meals("Oyster Omelette", "Savoury omelette with fresh oysters and vegetables", 4.30, "Taiwanese"));

		ArrayList<Meals> VendorMeal2 = new ArrayList<>();
		VendorMeal2.add(new Meals("Meatless Don", "Unique and Tasty!", 4.30, "Japanese"));
		VendorMeal2.add(new Meals("Seafood Don", "Flaky and crumbly!", 6.80, "Japanese"));
		VendorMeal2.add(new Meals("Tempura Rice", "Lightly battered and deep-fried seafood, vegetables and prawns served with a bed of rice", 3.80, "Japanese"));
		VendorMeal2.add(new Meals("Ramen", "Noodles in flavourful broth topping with pork, egg and vegetables", 4.80, "Japanese"));

		ArrayList<Meals> Order1 = new ArrayList<>();
		Order1.add(VendorMeal1.get(0)); // Chicken Rice
		Order1.add(VendorMeal1.get(1)); // Siew Mai
		Order1.add(VendorMeal1.get(3)); // Minced Braised Pork

		ArrayList<Meals> Order2 = new ArrayList<>();
		Order2.add(VendorMeal2.get(0)); // Meatless Don
		Order2.add(VendorMeal2.get(1)); // Seafood Don
		Order2.add(VendorMeal2.get(3)); // Ramen

		ArrayList<Meals> Order3 = new ArrayList<>();
		Order3.add(VendorMeal1.get(3)); // Chicken Rice
		Order3.add(VendorMeal1.get(5)); // Mapo Tofu

		// Generate sample orders for parents with items
		P1Order.add(new Ordering("Default1", "Child1", LocalDate.now(), Order1, (VendorMeal1.get(0).getPrice() + VendorMeal1.get(1).getPrice() + VendorMeal1.get(2).getPrice())));
		P1Order.add(new Ordering("Default1", "Child2", LocalDate.now(), Order2, (VendorMeal2.get(0).getPrice() * 2 + VendorMeal2.get(1).getPrice() + VendorMeal2.get(3).getPrice())));
		P2Order.add(new Ordering("Default2", "Child3", LocalDate.now(), Order3, (VendorMeal1.get(0).getPrice() + VendorMeal1.get(3).getPrice())));

	    ParentAccounts.add(new Parents("Parent1", "Pass123", children1, P1Order));
	    ParentAccounts.add(new Parents("Parent2", "Pass123", children2, P2Order));

		// Creating Meals for vendors and Vendors' account
		VendorList.add(new Vendor("Vendor1", "ABC@coporation.org", 83294920, "AMK Hub #1-23,123567", VendorMeal1));
		VendorList.add(new Vendor("Vendor2", "EFG@coporation.org", 93034040, "Bishan Junction 8 #1-23,123564", VendorMeal2));
		
		
		
		
		String parentName = "Parent1";
		String childName = "C1";
		String vendorName = "Vendor1";
		
	    // Refactored
	    Parents parent = getParentByName(parentName);
	    Child child = getChildByName(parentName, childName);
	    Vendor vendor = getVendorByName(vendorName);
	    Ordering order = getOrderbyIDnParent(parentName, P1Order.get(0).getOrderId());
	    ArrayList<Menu> m = MenuListCreation(VendorList, MenuList, LocalDate.now());
		System.out.println(parent+"\n"+child+"\n"+vendor+"\n"+order+"\n"+m+"\n");
		
	}
//Main Start

	// The creation of Menu
	public static ArrayList<Menu> MenuListCreation(ArrayList<Vendor> VendorList, ArrayList<Menu> menuList2, LocalDate date) {
	    boolean checkValid = Helper.isValidRangeDate(date);
	    if (checkValid) {
	        for (Vendor V : VendorList) {
	            for (int x = V.getMenu().size() - 1; x >= 0; x--) {
	                Meals M = V.getMenu().get(x);
	                Menu menu = new Menu(date, M);
	                menuList2.add(menu);
	            }
	        }
	    }
	    return menuList2;
	}


	
	public static void viewCuisine() {
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
	public static void ViewMenu() {
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
	public static void printMenu(Meals meal) {
		System.out.println("Name: " + meal.getName());
		System.out.println("Description: " + meal.getDescription());
		System.out.println("Price: " + meal.getPrice());
		System.out.println("----------------------");
	}

	//Parents can order directly from their child
	public static void StartOrder() {
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
	 * Verification of order and is added to parents
	 */
	public static void verifyOrderVendorqty(Parents parent, Child child, double ttAmt, Meals selectMeal,
			Vendor vendor) {
		// Deduct quantity from vendor and update meal quantity

		// Create and add the order to the order list
		Ordering order = new Ordering(parent.getName(), child.getChildName(), LocalDate.now(), ttAmt);
		parent.getOrderHistory().add(order);
		
		System.out.println("Order placed successfully.");
	}

	//Verify and authenticate payment in order
	public static boolean PaymentVerification(String parentName, double amount) {
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
	// Parent can view all the Orders and see if it have arrived or pending
	public static void viewOrder(String parentName) {
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
					i++;
					boolean toView = Helper.readBoolean("Would you like to view the meals? [y/n]: ");
					if(toView) {
						String orderId = Helper.readString("Enter Order ID: ");
						if(O.getOrderId().equalsIgnoreCase(orderId)) {
							for(Meals M: O.getItems()) {
								printMenu(M);
							}
						}
					}else {
						return;
					}
				} else {
					// If the orderHistory is null
					System.out.println("Order not found.");
					return;
				}
			}
		}

	}
	
	//Parents can delete orders from their order history
	public static void delOrder(String parentName, String orderID) {
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

	public static void Rating(String parentName) {
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

	public static void generateReport() {
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

	public static void reportMenu() {
		Helper.line(45, "=");
		System.out.println("Sales report");
		Helper.line(45, "=");
		System.out.println("1. Daily Report");
		System.out.println("2. Monthly Report");
		System.out.println("3. End");

	}

	public static void generateMonthlyReport(YearMonth targetMonth) {
		System.out.println("Sales Report for " + targetMonth);

		double totalSales = 0.0;

		for (Parents parent : ParentAccounts) {
			for (Ordering order : parent.getOrderHistory()) {
				LocalDate orderDate = order.getDate();
				YearMonth orderYearMonth = YearMonth.of(orderDate.getYear(), orderDate.getMonth());

				if (orderYearMonth.equals(targetMonth)) {
					double orderTotal = order.getTotalAmount();
					totalSales += orderTotal;

					reportMenu(order, orderDate, orderTotal);
				}
			}
		}

		System.out.println("Total Sales for " + targetMonth + ": $" + totalSales);
	}

	public static void generateDailyReport(LocalDate targetDate) {
		System.out.println("Sales Report for " + targetDate);

		double totalSales = 0.0;

		for (Parents parent : ParentAccounts) {
			for (Ordering order : parent.getOrderHistory()) {
				LocalDate orderDate = order.getDate();

				if (orderDate.equals(targetDate)) {
					double orderTotal = order.getTotalAmount();
					totalSales += orderTotal;

					reportMenu(order, orderDate, orderTotal);
				}
			}
		}

		System.out.println("Total Sales for " + targetDate + ": $" + totalSales);
	}

	/**
	 * @param parent
	 * @param order
	 * @param orderDate
	 * @param orderTotal
	 */
	private static void reportMenu(Ordering order, LocalDate orderDate, double orderTotal) {
		System.out.println("Order ID: " + order.getOrderId());
		System.out.println("Order Date: " + orderDate);
		System.out.println("Order Total: $" + orderTotal);
		System.out.println("-----------------------------------");
	}

	public static void addVendor() {
		String name = Helper.readString("Enter Name of Vendor");
		String email = Helper.readStringRegEx("Enter Email address: ","[a-ZA-Z0-9]@[a-zA-Z0-9].(com|org)");
		int contactNo = Integer.parseInt(Helper.readStringRegEx("Enter Contact No.", "[89][0-9]{7}"));
		String address = Helper.readString("Enter Address: ");
		VendorList.add(new Vendor(name,email,contactNo,address));
		System.out.println("Vendor Added!");
		
	}
	
	public static void delVendor() {
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
	
	public static void viewAllVendor() {
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
		public static void AddItems(String VendorName) {
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

		public static void DelItems(String VendorName) {
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

		public static void EditItems(String VendorName) {
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

		public static void ViewFB(String VendorName) {
			Vendor V = getVendorByName(VendorName);
			int x = 0;
				for (Review R : V.getReviews()) {
					System.out.printf("%d. Food Rating: %d\nExperience Rating: %d\nDescription:\n%s", x + 1,
							R.getRateFood(), R.getRateExperience(), R.getImprovements());
					x++;
				}
		}

		public static void EditInfo(String VendorName) {
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

		public static void ViewVendorMenu(String VendorName) {
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
	public static Vendor getVendorByMeal(ArrayList<Vendor> VendorList, Meals selectedMeal) {
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
			if (vendorName == V.getName()) {
				return V;
			}
		}
		return null;
	}

	// refactor the loop for parents by Name
	public static Parents getParentByName(String parentName) {
		for (Parents parent : ParentAccounts) {
			if (parent.getName().equals(parentName)) {
				return parent;
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
