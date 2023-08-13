import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
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
        ArrayList<Vendor> vendorList = new ArrayList<>();
        Vendor vendor1 = new Vendor("Vendor1", "vendor1@example.com", 12345678, "Vendor1 Address");
        Meals meal1 = new Meals("Meal1", "Description1", 10.0, "Cuisine1");
        vendor1.getMenu().add(meal1);
        vendorList.add(vendor1);

        menuList = C206_CaseStudy.MenuListCreation(vendorList, menuList, date);

        assertEquals("Check if MenuList size is 1 when added",1, menuList.size());
        assertEquals("Check if date is the same with the Menu's date",date, menuList.get(0).getDate());
    }
	
	@Test
	public void testViewVendorMenu() {
		//Test if it is not null
	}
	
	// Refactored codes
	@Test
	public void testGetVendorByName() {
		System.out.println("VendorList: "+ VendorList);
		
		assertNotNull("Check if VendorList is not null",VendorList);
		assertTrue("Check if VendorList is not empty", !VendorList.isEmpty());
		
		//Test if Vendor1 and 2 is present in VendorList
		Vendor result1 = C206_CaseStudy.getVendorByName("Vendor1");
		assertNotNull("Check if Vendor1 is not Null", result1);
		assertSame("Check if Vendor1 exist in VendorList", VendorList.get(0).getName(), result1.getName());
		
		Vendor result2 = C206_CaseStudy.getVendorByName("Vendor2");
		assertSame("Check if Vendor1 exist in VendorList", VendorList.get(1).getName(), result2.getName());
		
		//Check for non-existing Vendor
		Vendor nonExistingVendor = C206_CaseStudy.getVendorByName("Non-existent");
		assertNull("Check if Vendor does exist will return null",nonExistingVendor);
		
		
	}

	@Test
	public void testGetParentByName() {
		System.out.println("Parent Accounts: "+ParentAccounts);
		assertNotNull("Check if Parent Accounts is not null", ParentAccounts);
		assertTrue("Check if Parent Accounts is not empty", !ParentAccounts.isEmpty());
		
		//Test if Parent1 and 2 is present in ParentAccounts
	    Parents result1 = C206_CaseStudy.getParentByName("Parent1");
	    assertEquals("Check if Parent1 is present", ParentAccounts.get(0).getName(), result1.getName());
		
	    Parents result2 = C206_CaseStudy.getParentByName("Parent2");
	    assertEquals("Check if Parent2 is present", ParentAccounts.get(1).getName(), result2.getName());
	}
	
	@Test
	public void testGetChildByName() {
		//Checking if ParentAccounts is not empty and null
	    assertNotNull("Check if ParentAccounts is not null",ParentAccounts);
	    assertTrue("Check if ParentAccounts is not empty", !ParentAccounts.isEmpty());
		
	    //Test if Parent1 is present in ParentAccounts
	    Parents result1 = C206_CaseStudy.getParentByName("Parent1");
	    assertEquals("Check if Parent1 is present", ParentAccounts.get(0).getName(), result1.getName());
	    assertNotNull(result1);
	    
	    //Test Children present from Parent: C1
	    Child C1Result1 = C206_CaseStudy.getChildByName("C1", "Parent1");
	    assertEquals("Check if C1 is present from Parent1", 
	    		ParentAccounts.get(0).getChildren().get(0).getChildName(), C1Result1.getChildName());
	    
	    //Test Children present from Parent: C2
	    Child C2Result1 = C206_CaseStudy.getChildByName("C2", "Parent1");
	    assertEquals("Check if C2 is present from Parent1", 
	    		ParentAccounts.get(0).getChildren().get(1).getChildName(), C2Result1.getChildName());
	    
	    //Test if Parent2 is present in ParentAccounts
	    Parents result2 = C206_CaseStudy.getParentByName("Parent2");
	    assertEquals("Check if Parent2 is present", ParentAccounts.get(1).getName(), result2.getName());
	    
	    //Test Children present from Parent: C3
	    Child C3Result2 = C206_CaseStudy.getChildByName("C3", "Parent2");
	    assertEquals("Check if C3 is present from Parent2",
	    		ParentAccounts.get(1).getChildren().get(0).getChildName(), C3Result2.getChildName());
	    
	    //Test Children present from Parent: C4
	    Child C4Result2 = C206_CaseStudy.getChildByName("C4", "Parent2");
	    assertEquals("Check if C4 is present from Parent2",
	    		ParentAccounts.get(1).getChildren().get(1).getChildName(), C4Result2.getChildName());
	    
	    
	}

	
	@Test
	public void getOrderByIDnParent() {

	}
	
}
