import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	ArrayList<Parents> ParentAccounts = new ArrayList<Parents>();
	ArrayList<VendorTest> VendorList = new ArrayList<VendorTest>();

	@Before
	public void setUp() throws Exception {
		// Parents Account
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
		ArrayList<Menu> VendorMeal1 = new ArrayList<>();
		VendorMeal1.add(new Menu("Chicken Rice", "Traditional and Fragrant Dish!", 4.50, "Chinese"));
		VendorMeal1.add(new Menu("Siew Mai", "Savoury and bite-sized delight!", 2.70, "Chinese"));
		VendorMeal1.add(new Menu("Minced Braised Pork", "Braised pork with aromatic spices and herbs served on rice",
				4.00, "Taiwanese"));
		VendorMeal1
				.add(new Menu("Mapo Tofu", "Spicy tofu dish with minced meat and sichuan peppers", 5.10, "Chinese"));
		VendorMeal1
				.add(new Menu("Scallian Pancake", "Savoury flaky pancakes with chopped scallions", 2.90, "Taiwanese"));
		VendorMeal1.add(
				new Menu("Oyster Omelette", "Savoury omelette with fresh oysters and vegetables", 4.30, "Taiwanese"));

		ArrayList<Menu> VendorMeal2 = new ArrayList<>();
		VendorMeal2.add(new Menu("Meatless Don", "Unique and Tasty!", 4.30, "Japanese"));
		VendorMeal2.add(new Menu("Seafood Don", "Flaky and crumbly!", 6.80, "Japanese"));
		VendorMeal2.add(new Menu("Tempura Rice",
				"Lightly battered and deep-fried seafood, vegetables and prawns served with a bed of rice", 3.80,
				"Japanese"));
		VendorMeal2.add(new Menu("Ramen", "Noodles in flavourful broth topping with pork, egg and vegetables", 4.80,
				"Japanese"));

		ArrayList<Menu> Order1 = new ArrayList<>();
		Order1.add(VendorMeal1.get(0)); // Chicken Rice
		Order1.add(VendorMeal1.get(1)); // Siew Mai
		Order1.add(VendorMeal1.get(3)); // Minced Braised Pork

		ArrayList<Menu> Order2 = new ArrayList<>();
		Order2.add(VendorMeal2.get(0)); // Meatless Don
		Order2.add(VendorMeal2.get(1)); // Seafood Don
		Order2.add(VendorMeal2.get(3)); // Ramen

		ArrayList<Menu> Order3 = new ArrayList<>();
		Order3.add(VendorMeal1.get(3)); // Chicken Rice
		Order3.add(VendorMeal1.get(5)); // Mapo Tofu

		// Generate sample orders for parents with items
		P1Order.add(new Ordering("Default1", "Child1", LocalDate.now(), Order1,
				(VendorMeal1.get(0).getPrice() + VendorMeal1.get(1).getPrice() + VendorMeal1.get(2).getPrice())));
		P1Order.add(new Ordering("Default1", "Child2", LocalDate.now(), Order2,
				(VendorMeal2.get(0).getPrice() * 2 + VendorMeal2.get(1).getPrice() + VendorMeal2.get(3).getPrice())));
		P2Order.add(new Ordering("Default2", "Child3", LocalDate.now(), Order3,
				(VendorMeal1.get(0).getPrice() + VendorMeal1.get(3).getPrice())));

		ParentAccounts.add(new Parents("Parent1", "Pass123", children1, P1Order));
		ParentAccounts.add(new Parents("Parent2", "Pass123", children2, P2Order));

		// Creating Meals for vendors and Vendors' account
		VendorList.add(new VendorTest("Vendor1", "ABC@coporation.org", 83294920, "AMK Hub #1-23,123567", VendorMeal1));
		VendorList.add(
				new VendorTest("Vendor2", "EFG@coporation.org", 93034040, "Bishan Junction 8 #1-23,123564", VendorMeal2));
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
	public void testMenuListCreation() {
		LocalDate date = LocalDate.of(2023, 7, 18);
		ArrayList<Menu> menuList = new ArrayList<>();

		menuList = C206_CaseStudy.MenuListCreation(VendorList, menuList, date);

		assertEquals("Check if MenuList size is 1 when added", 1, menuList.size());
		assertEquals("Check if date is the same with the Menu's date", date, menuList.get(0).getDate());
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

	@Test
	public void testAddVendor() {
		// Test Case Normal Condition
		assertNotNull("Test that VendorList is null", VendorList);
		assertNotEquals("Test that VendorList is not empty", 0, VendorList.size());
		// Test Case Normal Condition
		Vendor V1 = new Vendor("Vendor1", "company1@email.co", 87651234, "120 Bishan St 23");
		Vendor V2 = new Vendor("Vendor2", "company2@email.com", 95693537, "52 Serangoon Rd");
		VendorMain.addVendor(VendorList, V21);
		VendorMain.addVendor(VendorList, V2);
		assertEquals("Check if vendor added was successful", 2, VendorList.size());

		// No Test case error/boundary condition due to the input have to be accurate as
		// it will prompt to re-enter

	}

	@Test
	public void testDelVendor() {
		// Test that VendorList is not null/empty
		assertNotNull("Test that VendorList is null", VendorList);
		assertEquals("Test that VendorList is 2", 2, VendorList.size());

		// Test Case Normal Condition
		// Check if removing vendor is successful
		VendorList.add(new Vendor("Vendor3", "vendor3@email.co", 82345678, "123 Main St"));
		VendorMain.delVendor(VendorList);
		assertTrue(VendorList.isEmpty());

		// Test Case Boundary Condition
		VendorMain.delVendor(VendorList);
		assertEquals(1, VendorList.size());
		assertEquals("Test that the remaining vendor in the list is the expected vendor", VendorList.get(0).getName());

		// Test Case Error Condition
		VendorMain.delVendor(VendorList);
		assertEquals("Test that the vendor to delete is not found", VendorList);
		assertEquals("Test that the vendor list remains unchange", 2, VendorList.size());
	}

	@Test
	public void testViewAllVendor() {
		// Test if the output of the print is not empty
		String testResult = "";
		String result = VendorMain.viewAllVendor(VendorList);
		assertNotEquals("Test that the output is not blank", testResult, result);

		// Test Case Normal Condition
		assertEquals("Test the vendor list size is 1", 2, VendorList.size());

		// Test Case Error Condition
		VendorList.clear();
		String results = VendorMain.viewAllVendor(VendorList);
		String expectedOutput = "No vendors available.";
		assertEquals("Verify that the output indicates no vendors are available", expectedOutput, result);

		// Test Case Boundary Condition
		// Check if added and if is more than the index
		for (int i = 0; i < 5; i++) {
			VendorList.add(new Vendor("Vendor" + i, "vendor" + i + "@email.co", 82345678, "123 Main St"));
		}
		String output = VendorMain.viewAllVendor(VendorList);
		assertTrue("Test if vendor4 is added successfully", output.contains("Vendor4"));
		assertFalse("Test if Vendor5 is not added due to out of bounds", output.contains("Vendor5"));
	}


}
