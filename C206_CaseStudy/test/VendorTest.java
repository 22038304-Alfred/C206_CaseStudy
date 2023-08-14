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
	ArrayList<VendorTest> VendorList = new ArrayList<VendorTest>();

	@Before
	public void setUp() throws Exception {
		vendorList.add(new Vendor("Vendor1", "company1@email.co", 87651234, "120 Bishan St 23"));
		vendorList.add(new Vendor("Vendor2", "company2@email.com", 95693537, "52 Serangoon Rd"));

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
		
	}

	@Test
	public void testDelVendor() {
		
	}
	
	@Test
	public void testViewAllVendor() {
		
	}

}
