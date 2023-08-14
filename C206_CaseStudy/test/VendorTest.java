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

public class VendorTest {
	ArrayList<Vendor> VendorList = new ArrayList<Vendor>();

	@Before
	public void setUp() throws Exception {
		VendorList.add(new Vendor("Vendor1", "company1@email.co", 87651234, "120 Bishan St 23"));
		VendorList.add(new Vendor("Vendor2", "company2@email.com", 95693537, "52 Serangoon Rd"));

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
		//Test Case Normal Condition
		//Test that VendorList is not null/empty
		assertEquals("Test that VendorList is not empty", 0, VendorList.size());
		assertNotNull("Test that VendorList is not null", VendorList);
		
		//Test Case Error Condition
		//Check if adding vendor fails
		
		
		//Test Case Boundary Condition
		
		
	}

	@Test
	public void testDelVendor() {
		//Test Case Normal Condition
		//Test that VendorList is not null/empty
		assertNotNull("Test that VendorList is null", VendorList);
		assertEquals("Test that VendorList is not null", 0, VendorList);
		
		//Test Case Error Condition
		//Check if removing vendor fails
		
		
		//Test Case Boundary Condition
	}
	
	@Test
	public void testViewAllVendor() {
		//Test Case Normal Condition
		//Test that VendorList is not null/empty
		assertNotNull("Test that VendorList is null", VendorList);
		assertEquals("Test that VendorList is not null", 0, VendorList);
		
		//Test Case Error Condition
		//Check if it displays, not null from the list
		
		
		//Test Case Boundary Condition
	}

}
