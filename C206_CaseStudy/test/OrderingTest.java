import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrderingTest {
	private static ArrayList<Ordering> orderList = new ArrayList<Ordering>();
	private static ArrayList<Vendor> VendorList = new ArrayList<Vendor>();
	private static ArrayList<Menu> MenuList = new ArrayList<Menu>();
	private static ArrayList<User> userList = new ArrayList<User>();

	@Before
	public void setUp() throws Exception {
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

	}

	@After
	public void tearDown() throws Exception {
		orderList.clear();
	}

	@Test
	public void c206_test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
	}

	@Test
	public void testStartOrder() {
		// Test that userList/orderList is not null
		assertNotNull("Test if VendorList is not null", orderList);
		assertTrue("Test if VendorList is empty", orderList.isEmpty());
		// Condition Normal
		String[] inputLine = { "Child1", "Chinese", "1", "1", "y" };
		//If the order goes well
		boolean result = OrderingMain.StartOrder("User1", inputLine);
		assertTrue("Check if the order goes through", result);
		assertEquals("Check if orderList adds 1", 1 ,orderList.size());
		
		// Boundary Condition: Cancel transaction
		String[] inputLinesErrorCancel = { "Child1", "Chinese", "1", "1", "n" };
		// If input is a 'n' for transaction
		boolean resultEC = OrderingMain.StartOrder("User1", inputLinesErrorCancel);
		assertFalse("Test that cancelled purchase", resultEC);

		// Error condition: User does not exist Error
		String[] inputLinesErrorUser = { "Child1", "Chinese", "1", "1", "y" };
		// If input is incorrect
		boolean resultEU = OrderingMain.StartOrder("NonExistentUser", inputLinesErrorUser);
		assertFalse("Test that user does not exist", resultEU);

	}

	@Test
	public void testDelOrder() {
		// Test if vendor is not null/empty
		assertNotNull("Test if orderList is not null", orderList);
		assertEquals("Test if orderList is empty", 0, orderList.size());
		// Test Case Error Condition
		// Where User is correct but order is incorrect
		boolean removeErrorID = OrderingMain.delOrder("User1", "3242io");// does not exist
		assertFalse("Test that the order does not exist", removeErrorID);

		// Where both User and order is incorrectS
		boolean removeErrorUser = OrderingMain.delOrder("User00", "afsgrbt1243");
		assertFalse("Test that the User does not exist", removeErrorUser);
		// Setup
		MenuList.add(new Menu("Chicken Rice", "Traditional and Fragrant Dish!", 4.50, "Chinese", "Vendor1"));
		MenuList.add(new Menu("Siew Mai", "Savoury and bite-sized delight!", 2.70, "Chinese", "Vendor1"));
		ArrayList<Menu> Order1 = new ArrayList<>();
		ArrayList<Menu> Order2 = new ArrayList<>();
		Order1.add(MenuList.get(0)); // Chicken Rice
		Order2.add(MenuList.get(1));
		orderList.add(new Ordering("User1", "Child1", LocalDate.now(), Order1, (MenuList.get(0).getPrice())));
		orderList.get(0).setTrackOrder(false);
		orderList.add(new Ordering("User1", "Child2", LocalDate.now(), Order2, (MenuList.get(1).getPrice())));
		// Test Case Normal Condition
		boolean result = OrderingMain.delOrder("User1", orderList.get(0).getOrderId(),false);
		// Test if they did not accept to remove the orders
		assertFalse("Test if the item has not been removed", result);
		assertEquals("Test that the item has not been removed", 2, orderList.size());
		
		boolean results = OrderingMain.delOrder("User1", orderList.get(1).getOrderId(),true);
		//Test if they accept to remove the orders
		assertTrue("Test of the order has been removed successfully", results);
		assertEquals("Test that order has been removed", 1 , orderList.size());
		// Test Case Boundary Condition
		boolean resultB = OrderingMain.delOrder("User1", orderList.get(1).getOrderId());
		assertFalse("Test will reject if is Not Shipped", resultB);

		orderList.add(new Ordering("User2", "Child1", LocalDate.now(), new ArrayList<>(), 0.0));
		String boundaryResult = OrderingMain.viewOrder("User2");
		assertEquals("Test that is the orders are empty it will result a blank", "Order Not Found",
				boundaryResult);

	}


	@Test
	public void testViewOrder() {
		// Test that orderList is not null/empty
		assertNotNull("Test if orderList is not null", orderList);
		assertEquals("Test if orderList is empty", 0, orderList.size());
		// Error Condition: User does not exist
		String errorResult = OrderingMain.viewOrder("NonExistentUser");
		assertEquals("Test that the user does not exist", "Order Not Found", errorResult);

		// Boundary Condition: User exists with orders but no meals
		orderList.add(new Ordering("User2", "Child1", LocalDate.now(), new ArrayList<>(), 0.0));
		String boundaryResult = OrderingMain.viewOrder("User2");
		assertEquals("Test that is the orders are empty it will result a blank", "User does not exist",
				boundaryResult);
		// setup
		MenuList.add(new Menu("Chicken Rice", "Traditional and Fragrant Dish!", 4.50, "Chinese", "Vendor1"));
		MenuList.add(new Menu("Siew Mai", "Savoury and bite-sized delight!", 2.70, "Chinese", "Vendor1"));
		MenuList.add(new Menu("Minced Braised Pork", "Braised pork with aromatic spices and herbs served on rice",
				4.00, "Taiwanese", "Vendor1"));
		ArrayList<Menu> Order1 = new ArrayList<>();
		Order1.add(MenuList.get(0)); // Chicken Rice
		ArrayList<Menu> Order2 = new ArrayList<>();
		Order2.add(MenuList.get(2)); // Minced Braised Pork

		orderList.add(new Ordering("User1", "Child1", LocalDate.now(), Order1, (MenuList.get(0).getPrice())));
		orderList.get(0).setTrackOrder(false);
		orderList.add(new Ordering("User1", "Child2", LocalDate.now(), Order2, (MenuList.get(2).getPrice() * 2)));
		Ordering O1 = orderList.get(0);
		Ordering O2 = orderList.get(1);
		// Normal Condition: User exists with orders and meals
		String expectResult = "\n========================================\n";
		expectResult += String.format("Order Details:\nNo. order: %s\nOrderID: %s\nStatus: %s\n", 1, O1.getOrderId(),
				"Delivered");
		expectResult += "\n========================================\n";
		expectResult += String.format("Order Details:\nNo. order: %s\nOrderID: %s\nStatus: %s\n", 2, O2.getOrderId(),
				"Not Shipped");
		expectResult += "\n----------------------------------------\n";
		expectResult += "Would you like to view the Meals? [y/n]: ";
		String normalResult = OrderingMain.viewOrder("User1");
		assertEquals("Test if OrderID can be produced", expectResult, normalResult);
	}

}
