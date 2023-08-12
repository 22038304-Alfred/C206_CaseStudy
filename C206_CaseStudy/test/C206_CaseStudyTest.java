import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

	ParentAccounts.add(new Parents("Default1", "Pass123"));
	ParentAccounts.add(new Parents("Default2", "Pass123"));

	// Creating a Meals for vendors and Vendors' account
	ArrayList<Meals> VendorMeal1 = new ArrayList<Meals>();
	ArrayList<Meals> VendorMeal2 = new ArrayList<Meals>();
	VendorMeal1.add(new Meals("Chicken Rice", "Traditional and Fragrant Dish!", 1200, "Chineses"));
	VendorMeal1.add(new Meals("Nasi Lemak", "Delicious and flavourful!", 1300, "Malay"));
	VendorMeal2.add(new Meals("Meatless Don", "Unique and Tasty!", 1400, "Japanese"));
	VendorMeal2.add(new Meals("Veg Quiche", "Flaky and crumbly!", 1500, ""));
	VendorList.add(new Vendor("Vendor1", "password", "ABC@coporation.org", "AMK Hub #1-23,123567", VendorMeal1));
	VendorList.add(
			new Vendor("Vendor2", "pass123", "EFG@coporation.org", "Bishan Junction 8 #1-23,123564", VendorMeal2));
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	
	
	//Refactored codes
	@Test
	public void testGetVendorByName() {
		
	}

}
