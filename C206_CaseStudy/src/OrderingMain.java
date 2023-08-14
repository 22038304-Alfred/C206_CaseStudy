import java.util.ArrayList;
import java.time.LocalDate;

public class OrderingMain {
	private static ArrayList<Ordering> orderList = new ArrayList<Ordering>();
	private static ArrayList<Vendor> VendorList = new ArrayList<Vendor>();
	private static ArrayList<Menu> MenuList = new ArrayList<Menu>();
	private static ArrayList<User> userList = new ArrayList<User>();
	private static ArrayList<Payment> paymentList = new ArrayList<Payment>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		userList.add(new User("User1", "abc123"));

		MenuList.add(new Menu("Chicken Rice", "Traditional and Fragrant Dish!", 4.50, "Chinese", "Vendor1"));
		MenuList.add(new Menu("Siew Mai", "Savoury and bite-sized delight!", 2.70, "Chinese", "Vendor1"));
		MenuList.add(new Menu("Minced Braised Pork", "Braised pork with aromatic spices and herbs served on rice", 4.00,
				"Taiwanese", "Vendor1"));
		MenuList.add(new Menu("Mapo Tofu", "Spicy tofu dish with minced meat and sichuan peppers", 5.10, "Chinese",
				"Vendor1"));
		MenuList.add(new Menu("Scallian Pancake", "Savoury flaky pancakes with chopped scallions", 2.90, "Taiwanese",
				"Vendor1"));
		MenuList.add(new Menu("Oyster Omelette", "Savoury omelette with fresh oysters and vegetables", 4.30,
				"Taiwanese", "Vendor1"));

		MenuList.add(new Menu("Meatless Don", "Unique and Tasty!", 4.30, "Japanese", "Vendor2"));
		MenuList.add(new Menu("Seafood Don", "Flaky and crumbly!", 6.80, "Japanese", "Vendor2"));
		MenuList.add(new Menu("Tempura Rice",
				"Lightly battered and deep-fried seafood, vegetables and prawns served with a bed of rice", 3.80,
				"Japanese", "Vendor2"));
		MenuList.add(new Menu("Ramen", "Noodles in flavourful broth topping with pork, egg and vegetables", 4.80,
				"Japanese", "Vendor2"));

		VendorList.add(new Vendor("Vendor1", "company1@email.co", 87651234, "120 Bishan St 23", MenuList));
		VendorList.add(new Vendor("Vendor2", "company2@email.com", 95693537, "52 Serangoon Rd", MenuList));

		ArrayList<Menu> Order1 = new ArrayList<>();
		Order1.add(MenuList.get(0)); // Chicken Rice
		Order1.add(MenuList.get(1)); // Siew Mai
		Order1.add(MenuList.get(3)); // Mapo Tofu

		ArrayList<Menu> Order2 = new ArrayList<>();
		Order2.add(MenuList.get(6)); // Meatless Don
		Order2.add(MenuList.get(7)); // Seafood Don
		Order2.add(MenuList.get(9)); // Ramen

		paymentList.add(new Payment("12345", 40, "Visa", "54321"));
		paymentList.add(new Payment("56789", 20, "Credit Card", "98765"));
		paymentList.add(new Payment("34567", 60, "PayNow", "76543"));

		orderList.add(new Ordering("User1", "Child1", LocalDate.now(), Order1,
				(MenuList.get(0).getPrice() + MenuList.get(1).getPrice() + MenuList.get(3).getPrice())));
		orderList.get(0).setTrackOrder(false);
		orderList.add(new Ordering("User1", "Child2", LocalDate.now(), Order2,
				(MenuList.get(6).getPrice() * 2 + MenuList.get(7).getPrice() + MenuList.get(9).getPrice())));

		// StartOrder("User1");

		// delOrder("User1", orderList.get(0).getOrderId());
		System.out.println(orderList.get(0).getOrderId());
		viewOrder("User1");
	}

	public static void StartOrder(String user) {
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

	public static void delOrder(String user, String orderID) {
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

	public static void viewOrder(String user) {
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
	public static void printMenu(Menu meal) {
		System.out.println("Name: " + meal.getName());
		System.out.println("Description: " + meal.getDescription());
		System.out.println("Price: " + meal.getPrice());
		System.out.println("----------------------");
	}

	public static void verifyOrderVendorqty(User parent, String child, double ttAmt, Menu selectMeal, String vendor) {
		// Deduct quantity from vendor and update meal quantity

		// Create and add the order to the order list
		Ordering order = new Ordering(parent.getName(), child, LocalDate.now(), ttAmt);
		orderList.add(order);

		System.out.println("Order placed successfully.");
	}

// refactor the loop for parents by Name
	public static User getUserByName(String username) {
		for (User parent : userList) {
			if (parent.getName().equals(username)) {
				return parent;
			}
		}
		return null;
	}

//refactor user to order
	public static Ordering getOrderByUser(String username, String orderID) {
		User user = getUserByName(username);
		for (Ordering OL : orderList) {
			if (user.getName().equalsIgnoreCase(OL.getName()) && OL.getOrderId().equals(orderID)) {
				return OL;
			}
		}
		return null;
	}

}
