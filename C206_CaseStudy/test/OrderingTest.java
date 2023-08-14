import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrderingTest {
	private static ArrayList<Ordering> orderList = new ArrayList<Ordering>();
	private static ArrayList<Vendor> VendorList = new ArrayList<Vendor>();
	private static ArrayList<Menu> MenuList = new ArrayList<Menu>();
	private static ArrayList<User> userList = new ArrayList<User>();
	private static ArrayList<Payment> paymentList = new ArrayList<Payment>();

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

		paymentList.add(new Payment("12345", 40, "Visa", "54321"));
		paymentList.add(new Payment("56789", 20, "Credit Card", "98765"));
		paymentList.add(new Payment("34567", 60, "PayNow", "76543"));

		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void c206_test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
	}
	
	@Test
	public void testStartOrder() {
		//Test that userList/orderList is not null
		assertNotNull("Test if VendorList is not null", orderList);
		assertTrue("Test if VendorList is not empty", !orderList.isEmpty());
		
        // StartOrder Normal Condition
        assertTrue("Check if the order goes through",OrderingMain.StartOrder("User1"));

        // StartOrder Error Condition (User not found)
        assertFalse("Check if user does not exist will be an error",OrderingMain.StartOrder("NonExistentUser"));
		
		
		
		
	}
	
	@Test
	public void testDelOrder() {
		//Test if vendor is not null/empty
		assertNotNull("Test if VendorList is not null", orderList);
		assertTrue("Test if VendorList is not empty", !orderList.isEmpty());
		
		//Test Case Normal Condition
		boolean remove = OrderingMain.delOrder("User1", orderList.get(0).getOrderId());
		assertTrue("Test if orderList is removed successfully",remove);
		
		//Test Case Error Condition
		boolean removeError = OrderingMain.delOrder("User1", orderList.get(3).getOrderId());//does not exist
		assertTrue("Test that the order did not remove",removeError);
	}
	
	@Test
	public void testViewOrder() {
		//Test that orderList is not null/empty
		assertNotNull("Test if orderList is not null", orderList);
		assertEquals("Test if orderList is not empty", 0, orderList.size());
		
		//Test Case Normal Condition
		
		//Test if orders are present in orderList to view
		String order = OrderingMain.viewOrder("User1");
		assertEquals("Test that it is displaying the orderList is correct", "", order);
		
		
		//Test Case Error Condition
		
		String orderError = OrderingMain.viewOrder("User3");
		assertEquals("Test that it is displaying the orderList is ", order, orderError);
		
		//Test Case Boundary Condition
		
	}
	

}
