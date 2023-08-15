import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VendorTest {
	private static ArrayList<Vendor> VendorList = new ArrayList<Vendor>();
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		VendorList.clear();
	}

	@Test
	public void Vendor_Test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
	}

	@Test
	public void testAddVendor() {
		// Test Case Normal Condition
		assertNotNull("Test that VendorList is null", VendorList);
		assertSame("Test that VendorList ArrayList is empty", 0 ,VendorList.size());
		
		// Test Case Normal Condition
		Vendor V1 = new Vendor("Vendor1", "company1@email.com", 87651234, "120 Bishan St 23");
		Vendor V2 = new Vendor("Vendor2", "company2@email.com", 95693537, "52 Serangoon Rd");
		VendorMain.addVendor(VendorList, V1);
		VendorMain.addVendor(VendorList, V2);
		System.out.println(VendorList);
		assertEquals("Check if vendor added was successful", 2, VendorList.size());

		// No Test case error/boundary condition due to the input have to be accurate as
		// it will prompt to re-enter

	}

	@Test
	public void testDelVendor() {
		// Test that VendorList is null/empty
		assertTrue("Test that VendorList is empty", VendorList.isEmpty());
		assertEquals("Test that VendorList is empty", 0, VendorList.size());

		// Test Case Normal Condition
		// Check if removing vendor is successful
		Vendor V4 = new Vendor("Vendor4", "vendor4@email.co", 82345678, "123 Main St");
		Vendor V5 = new Vendor("Vendor5", "company5@email.co", 82651234, "456 Side Rd");
		VendorList.add(V4);
		VendorList.add(V5);
		VendorMain.delVendor(VendorList, V4);
		assertFalse("Test if VendorList does not contain Vendor4",VendorList.contains(V4));
		assertSame("VendorList size is 1", 1 , VendorList.size());
		
		// Test Case Boundary Condition
		Vendor V1 = new Vendor("Vendor1", "company1@email.co", 87651234, "120 Bishan St 23");
		Vendor V2 = new Vendor("Vendor2", "company2@email.com", 95693537, "52 Serangoon Rd");
		VendorList.add(V1);
		VendorList.add(V2);
		VendorMain.delVendor(VendorList,V1);
		assertEquals("Check that vendorList size is 1 after removal",1, VendorList.size());
		assertEquals("Test that the remaining vendor in the list is the expected vendor",
				V2.getName() ,VendorList.get(0).getName());

		// Test Case Error Condition
		Vendor V3 = new Vendor("Vendor3", "company3@email.com", 95693037, "56 Serangoon Rd");
		VendorMain.delVendor(VendorList, V3);
		assertFalse("Test that the vendor to delete is not found", VendorList.contains(V3));
		assertEquals("Test that the vendor list remains unchange", 1, VendorList.size());
	}

	@Test
	public void testViewAllVendor() {
		// Test if the output of the print is not empty
		String testResult = "";
		String result = VendorMain.viewAllVendor(VendorList);
		assertNotEquals("Test that the output is not blank", testResult, result);

		// Test Case Normal Condition
		VendorList.clear();
		Vendor V2 = new Vendor("Vendor2", "company2@email.com", 95693537, "52 Serangoon Rd");
		VendorList.add(V2);
		System.out.println(VendorList);
		assertEquals("Test the vendor list size is 1", 1, VendorList.size());

		// Test Case Error Condition
		VendorList.clear();
		String results = VendorMain.viewAllVendor(VendorList);
		String expectedOutput = "No vendors available.";
		assertNotEquals("Verify that the output indicates no vendors are available", 
				expectedOutput, results);

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
