import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	ArrayList<Parents> ParentAccounts = new ArrayList<Parents>();
	ArrayList<Vendor> VendorList = new ArrayList<Vendor>();

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
		Order1.add(VendorMeal1.get(2)); // Minced Braised Pork

		ArrayList<Meals> Order2 = new ArrayList<>();
		Order2.add(VendorMeal2.get(0)); // Meatless Don
		Order2.add(VendorMeal2.get(1)); // Seafood Don
		Order2.add(VendorMeal2.get(3)); // Ramen

		ArrayList<Meals> Order3 = new ArrayList<>();
		Order3.add(VendorMeal1.get(0)); // Chicken Rice
		Order3.add(VendorMeal1.get(3)); // Mapo Tofu

		// Generate sample orders for parents with items
		P1Order.add(new Ordering("Default1", "Child1", LocalDate.now(), Order1, (VendorMeal1.get(0).getPrice() + VendorMeal1.get(1).getPrice() + VendorMeal1.get(2).getPrice())));
		P1Order.add(new Ordering("Default1", "Child2", LocalDate.now(), Order2, (VendorMeal2.get(0).getPrice() * 2 + VendorMeal2.get(1).getPrice() + VendorMeal2.get(3).getPrice())));
		P2Order.add(new Ordering("Default2", "Child3", LocalDate.now(), Order3, (VendorMeal1.get(0).getPrice() + VendorMeal1.get(3).getPrice())));

		ParentAccounts.add(new Parents("Default1", "Pass123", children1, P1Order));
		ParentAccounts.add(new Parents("Default2", "Pass123", children2, P2Order));

		// Creating Meals for vendors and Vendors' account
		VendorList.add(new Vendor("Vendor1", "ABC@coporation.org", 83294920, "AMK Hub #1-23,123567", VendorMeal1));
		VendorList.add(new Vendor("Vendor2", "EFG@coporation.org", 93034040, "Bishan Junction 8 #1-23,123564", VendorMeal2));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void c206_test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
	}

	// Refactored codes
	@Test
	public void testGetVendorByName() {
		
		//Test if Vendor1 and 2 is present in VendorList
		Vendor result1 = C206_CaseStudy.getVendorByName("Vendor1");
		assertEquals("Vendor1", result1.getName());
		
		Vendor result2 = C206_CaseStudy.getVendorByName("Vendor1");
		assertEquals("Vendor2", result1.getName());
		
		//Checking if VendorList is not empty
		assertNotNull(VendorList);
		
		
	}

	@Test
	public void testGetParentByName() {
		
	}
	
	@Test
	public void testGetChildByName() {
		
	}
	
	@Test
	public void getOrderByIDnParent() {
		
	}
	
}
