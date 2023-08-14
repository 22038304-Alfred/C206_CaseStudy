import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;



public class C206_CaseStudyTest {
	
	//GEMMA
	private School sch1;
	private School sch2;
	private School sch3;
	private ArrayList<School> schoolList;
	
	//ALFRED
	
	private User user1;
	private User user2;
	private User user3;
	private ArrayList<User> userList;

	
	
	//JICHIN
	
	
	//HEDIL
	ArrayList<Vendor> VendorList = new ArrayList<Vendor>();
	
	
	
	//QUEENIE 
	private Payment pay1;
	private Payment pay2;
	private Payment pay3;
	private ArrayList<Payment> paymentList;


	public C206_CaseStudyTest() {
		super();
	}


	@Before
	public void setUp() throws Exception {
		//----------------------------------------------------------------------------------------------------------------//
		//GEMMA
		sch1 = new School("Republic Polytechnic", "9 Woodlands Ave 9", "Singapore 738964");
		sch2 = new School("Temasek Polytechnic", "21 Tampines Ave 1", "Singapore 529757");
		sch3 = new School("Nanyang Polytechnic", "180 Ang Mo Kio Ave 8", "Singapore 569830");
		

		schoolList= new ArrayList<School>();
		//----------------------------------------------------------------------------------------------------------------//	
		//ALFRED
		user1 = new User("queenie", "P@ssw0rd");
	    user2 = new User("Alfred", "P@ssw0rd");
	    user3 = new User("jc", "P@ssw0rd");
	    
	    
	    userList = new ArrayList<User>();
		
	  //----------------------------------------------------------------------------------------------------------------//	
		//JICHIN
		
		
		
		
		
		//----------------------------------------------------------------------------------------------------------------//
		//HEDIL
		// Parents Account
		ArrayList<Ordering> P1Order = new ArrayList<>();
		ArrayList<Ordering> P2Order = new ArrayList<>();

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


		// Creating Meals for vendors and Vendors' account
		VendorList.add(new Vendor("Vendor1", "ABC@coporation.org", 83294920, "AMK Hub #1-23,123567", VendorMeal1));
		VendorList.add(new Vendor("Vendor2", "EFG@coporation.org", 93034040, "Bishan Junction 8 #1-23,123564", VendorMeal2));
	
		
		//----------------------------------------------------------------------------------------------------------------//
		//QUEENIE

		pay1 = new Payment("12345", 40, "Visa", "54321");
		pay2 = new Payment("56789", 20, "Credit Card","98765");
		pay3 = new Payment("34567", 60, "PayNow", "76543");

		paymentList= new ArrayList<Payment>();
		//----------------------------------------------------------------------------------------------------------------//

	}


	//----------------------------------------------------------------------------------------------------------------//
	//GEMMA
	@Test
	public void testaddSchool() {
		// School list is not null and it is empty
		assertNotNull("Test if there is valid School arraylist to add to", schoolList);
		assertEquals("Test that the School arraylist is empty.", 0, schoolList.size());
		//Given an empty list, after adding 1 school, the size of the list is 1
		C206_CaseStudy.addSchool(schoolList, sch1);		
		assertEquals("Test that the School arraylist size is 1.", 1, schoolList.size());

		
		// Add a school
		C206_CaseStudy.addSchool(schoolList, sch2);
		assertEquals("Test that the School arraylist size is now 2.", 2, schoolList.size());
		//The item just added is as same as the last item in the list
		assertSame("Test that School is added to the end of the list.", sch2, schoolList.get(1));

		// Add a school that already exists in the list
		C206_CaseStudy.addSchool(schoolList, sch2);
		assertEquals("Test that the School arraylist size is unchange.", 2, schoolList.size());

		// Add a school that has missing detail
		School sch_missing = new School("Singapore Polytechnic", "", "Singapore 139651");
		C206_CaseStudy.addSchool(schoolList, sch_missing);
		assertEquals("Test that the School arraylist size is unchange.", 2, schoolList.size());
	}

	@Test
	public void testRetrieveAllSchool() {
		//Test Case 1
		// Test if School list is not null and empty
		assertNotNull("Test if there is valid School arraylist to add to", schoolList);
		assertEquals("Test that the School arraylist is empty.", 0, schoolList.size());
		// Attempt to retrieve the Schools 
		String allSchool= C206_CaseStudy.retrieveAllSchool(schoolList);
		String testOutput = "";
		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allSchool);

		//Test Case 2
		C206_CaseStudy.addSchool(schoolList, sch1);
		C206_CaseStudy.addSchool(schoolList, sch2);
		// Test that the list is not empty
		assertEquals("Test that School arraylist size is 2.", 2, schoolList.size());
		// Attempt to retrieve the Schools
		allSchool= C206_CaseStudy.retrieveAllSchool(schoolList);
		testOutput = String.format("%-30s %-30s %-20s\n", "Republic Polytechnic", "9 Woodlands Ave 9", "Singapore 738964");
		testOutput += String.format("%-30s %-30s %-20s\n", "Temasek Polytechnic", "21 Tampines Ave 1", "Singapore 529757");
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allSchool);
		
	}
	
	@Test
	public void testDeleteSchool() {
		
		ArrayList<School> schoolList = new ArrayList<School>();
		
		schoolList.add(new School("Republic Polytechnic", "9 Woodlands Ave 9", "Singapore 738964"));
		schoolList.add(new School("Temasek Polytechnic", "21 Tampines Ave 1", "Singapore 529757"));
		schoolList.add(new School("Nanyang Polytechnic", "180 Ang Mo Kio Ave 8", "Singapore 569830"));
		
		// School list is not null and it is not empty
		assertNotNull("Test if there is valid School arraylist to delete from", schoolList);
		assertEquals("Test that the School arraylist is not empty.", 3, schoolList.size());
		//Given a not empty list, after deleting 1 school, the size of the list is 2
		C206_CaseStudy.deleteSchool("Nanyang Polytechnic", schoolList);		
		assertEquals("Test that the School arraylist size is 2.", 2, schoolList.size());
		// Delete a school
		C206_CaseStudy.deleteSchool("Temasek Polytechnic", schoolList);
		assertEquals("Test that the School arraylist size is now 1.", 1, schoolList.size());
		
		// Delete a school that is not in the list
        C206_CaseStudy.deleteSchool("Temasek Polytechnic", schoolList);
        assertEquals("Test that the School arraylist size is unchange.", 1, schoolList.size()); 
        
	}
	//----------------------------------------------------------------------------------------------------------------//
	//ALFRED
	 @Test
	 public void testAddUser() {
	  // C206_CaseStudy list is not null and it is empty
	  assertNotNull("Test if there is valid User arraylist to add to", userList);
	  assertEquals("Test that the User arraylist is empty.", 0, userList.size());
	  //Given an empty list, after adding 1 user, the size of the list is 1
	  C206_CaseStudy.addUser(userList, user1);  
	  assertEquals("Test that the User arraylist size is 1.", 1, userList.size());

	  
	  // Adding a user 
	  C206_CaseStudy.addUser(userList, user2);
	  assertEquals("Test that the User arraylist size is now 2.", 2,  userList.size() );
	  //The item just added is as same as the last item in the list
	  assertSame("Test that User is added to the end of the list.", user2, userList.get(1));

	  // Add user that already exists in the list
	  C206_CaseStudy.addUser(userList, user2);
	  assertEquals("Test that the User arraylist size is unchange.", 2, userList.size());
	  
	 
	   //Add an item that has missing detail
	  User user_missing = new User("", "P@ssw0rd");
	  C206_CaseStudy.addUser(userList, user_missing);
	  assertEquals("Test that the User arraylist size is unchange.", 2, userList.size());
	}
	 
	 
	 @Test
	 public void testretrieveAllUser() {
	  //Test Case 1
	  // Test if User list is not null and empty
	  assertNotNull("Test if there is valid User arraylist to add to", userList);
	  assertEquals("Test that the User arraylist is empty.", 0, userList.size());
	  // Attempt to retrieve the C206_CaseStudy 
	  String allUser= C206_CaseStudy.retrieveAllUser(userList);
	  String testOutput = "";
	  // Test if the output is empty
	  assertEquals("Test that nothing is displayed", testOutput, allUser);

	  //Test Case 2
	  C206_CaseStudy.addUser(userList, user1);
	  C206_CaseStudy.addUser(userList, user2);
	  // Test that the list is not empty
	  assertEquals("Test that user arraylist size is 2.", 2, userList.size());
	  // Attempt to retrieve the C206_CaseStudys
	  allUser= C206_CaseStudy.retrieveAllUser(userList);
	  testOutput = String.format("%-10s %-20s \n", "queenie", "P@ssw0rd");
	  testOutput += String.format("%-10s %-20s \n", "Alfred", "P@ssw0rd");
	  // Test that the details are displayed correctly
	  assertEquals("Test that the display is correct.", testOutput, allUser);

	 //Test Case 3
	  User user_missing = new User("", "P@ssw0rd");
	  C206_CaseStudy.addUser(userList, user_missing);
	  assertEquals("Test that User arraylist size is 2.", 2, userList.size());
	  assertFalse("Test that the last item in the arraylist is not available", !user_missing.isAuthenticate(user_missing.getName(), user_missing.getpw()));
	  // Attempt to retrieve the Users  
	  allUser= C206_CaseStudy.retrieveAllUser(userList);
	  testOutput = String.format("%-10s %-20s \n", "queenie", "P@ssw0rd");
	  testOutput += String.format("%-10s %-20s \n", "Alfred", "P@ssw0rd");
	  // Test that the details are displayed correctly
	  assertEquals("Test that the display is correct.", testOutput, allUser);
	 
	 }

	@Test
	 public void testremoveUser() {
		//Test Case 1
	  // Test if User list is not null and empty
	  assertNotNull("Test if there is valid User arraylist to add to", userList);
	  assertEquals("Test that the User arraylist is empty.", 0, userList.size());
	  
	  // Adding users to the list 
	  userList.add(user1);
	  userList.add(user2);
	  userList.add(user3);
	  
	  assertEquals("Test that User arraylist size is 3.", 3, userList.size());
	  
	  // Test removal of a user
	  C206_CaseStudy.removeUser(user1.getName(),userList);
	  assertEquals("Test that the User arraylist size is now 2 after removal", 2, userList.size());
	  assertFalse("Test that the user 1 is removed from the list", userList.contains(user1));
	  
	//Test removal of a non-existing user
	  String name = "IamN0nExist";
	  C206_CaseStudy.removeUser(name,userList);
	  assertEquals("Test that the Uesr arraylist size is remain unchange.", 2, userList.size());
	}
	
	
	
	//----------------------------------------------------------------------------------------------------------------//
	//JICHIN
	//----------------------------------------------------------------------------------------------------------------//
	
	
	
	
	
	//HEDIL
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
	//----------------------------------------------------------------------------------------------------------------//
	//QUEENIE
	@Test
	public void testAddPayment() { 
		//Test Payment list is not null and it is empty
		assertNotNull("Test if there is valid Payment arraylist to add to", paymentList);
		assertEquals("Test that the Payment arraylist is empty.", 0, paymentList.size());
		//Given an empty list, after adding 1 Payment, the size of the list is 1
		C206_CaseStudy.addPayment(paymentList, pay1);		
		assertEquals("Test that the Payment arraylist size is 1.", 1, paymentList.size());

		// Add a Payment
		C206_CaseStudy.addPayment(paymentList, pay2);
		assertEquals("Test that the Payment arraylist size is now 2.", 2, paymentList.size());
		//The Payment just added is as same as the last Payment in the list
		assertSame("Test that Payment is added to the end of the list.", pay2, paymentList.get(1));

		// Add a Payment that already exists in the list
		C206_CaseStudy.addPayment(paymentList, pay2);
		assertEquals("Test that the Payment arraylist size is unchange.", 2, paymentList.size());

		// Add a Payment that has missing detail
		Payment pay_missing = new Payment("33344", 40, "PayLah","");
		C206_CaseStudy.addPayment(paymentList, pay_missing);
		assertEquals("Test that the Payment arraylist size is unchange.", 2, paymentList.size());

	}

	@Test
	public void testretrieveAllPayment() {
		//Test Case 1
		// Test if Payment list is not null and empty
		assertNotNull("Test if there is valid Payment arraylist to add to", paymentList);
		assertEquals("Test that the Payment arraylist is empty.", 0, paymentList.size());
		// Attempt to retrieve the Payments  
		String allPayment=C206_CaseStudy.retrieveAllPayment(paymentList);
		String testOutput = "";
		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allPayment);

		//Test Case 2
		//Test retrieve payment after adding payment
		C206_CaseStudy.addPayment(paymentList, pay1);
		C206_CaseStudy.addPayment(paymentList, pay2);
		// Test that the list is not empty
		assertEquals("Test that Payment arraylist size is 2.", 2, paymentList.size());
		// Attempt to retrieve the Payments 
		allPayment= C206_CaseStudy.retrieveAllPayment(paymentList);
		testOutput = String.format("%-10s %-30d %-10s %-10s %-10s \n", "12345", 40, "Yes", "Visa", "54321");
		testOutput += String.format("%-10s %-30d %-10s %-10s %-10s \n","56789", 20, "Yes", "Credit Card", "98765");
		//Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allPayment); 

		//Test Case 3
		//Test retrieve payment for a false record
		pay3.setRecord(false);
		C206_CaseStudy.addPayment(paymentList, pay3);
		assertEquals("Test that Payment arraylist size is 3.", 3, paymentList.size());
		assertFalse("Test that the last Payment in the arraylist is not available", paymentList.get(2).getRecord());
		// Attempt to retrieve the Payments  
		allPayment= C206_CaseStudy.retrieveAllPayment(paymentList);
		testOutput = String.format("%-10s %-30d %-10s %-10s %-10s \n", "12345", 40, "Yes", "Visa", "54321");
		testOutput += String.format("%-10s %-30d %-10s %-10s %-10s \n","56789", 20, "Yes", "Credit Card", "98765");
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allPayment);
	}


	@Test
	public void testDeletePayment() {

		// Test if Payment list is not null and empty
		assertNotNull("Test if there is valid Payment arraylist to add to", paymentList);
		assertEquals("Test that the Payment arraylist is empty.", 0, paymentList.size());

		//Add payments into payment List and Delete a Payment
		C206_CaseStudy.addPayment(paymentList, pay1);
		C206_CaseStudy.addPayment(paymentList, pay2);
		C206_CaseStudy.addPayment(paymentList, pay3);

		assertEquals("Test that the Payment arraylist size is 3.", 3, paymentList.size());

		//Test removal of payment
		C206_CaseStudy.deletePayment(paymentList, pay1);
		assertEquals("Test that the Payment arraylist size is now 2 after removal.", 2, paymentList.size());
		assertFalse("Test that the pay1 is removed from the list", paymentList.contains(pay1));

		// Delete a Payment that is not exist in the list
		C206_CaseStudy.deletePayment(paymentList, new Payment("88888", 40, "PayNow", "99999"));
		assertEquals("Test that the Payment arraylist size is remain unchange.", 2, paymentList.size());
	}
	//QUEENIE
	//----------------------------------------------------------------------------------------------------------------//

	@After
	
	public void tearDown() throws Exception {
		//GEMMA
		sch1 = null;
		sch2 = null;
		sch3 = null;
		schoolList = null;
		//--------------------------------------------------------//
		//ALFRED
		user1 = null;
		user2 = null;
		user3 = null;
		userList = null;
		//--------------------------------------------------------//
		//JICHIN
		//--------------------------------------------------------//
		//HEDIL
		//--------------------------------------------------------//
		//QUEENIE
		pay1 = null;
		pay2 = null;
		paymentList = null;




	}//end of main method
}//end of class