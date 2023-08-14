import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VendorTest {
	ArrayList<Vendor> VendorList = new ArrayList<Vendor>();

	@Before
	public void setUp() throws Exception {

		
	}

	@After
	public void tearDown() throws Exception {
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
		assertNotEquals("Test that VendorList is not empty", 0, VendorList.size());
		// Test Case Normal Condition
		VendorList.add(new Vendor("Vendor1", "company1@email.co", 87651234, "120 Bishan St 23"));
		VendorList.add(new Vendor("Vendor2", "company2@email.com", 95693537, "52 Serangoon Rd"));
		VendorMain.addVendor(VendorList);
		assertEquals("Check if vendor added was successful", 3, VendorList.size());

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
