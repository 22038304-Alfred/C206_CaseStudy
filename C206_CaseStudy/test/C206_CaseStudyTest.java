
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class SchCentreTest {
	
	// prepare test data
		private School sch1;
		private School sch2;
		private School sch3;
	
		private ArrayList<School> schoolList;
		

		public SchCentreTest() {
			super();
		}

		@Before
		public void setUp() throws Exception {
			// prepare test data
			sch1 = new School("Republic Polytechnic", "9 Woodlands Ave 9", "Singapore 738964");
			sch2 = new School("Temasek Polytechnic", "21 Tampines Ave 1", "Singapore 529757");
			sch3 = new School("Nanyang Polytechnic", "180 Ang Mo Kio Ave 8", "Singapore 569830");
			

			schoolList= new ArrayList<School>();
			
		}


		@Test
		public void testaddSchool() {
			// School list is not null and it is empty
			assertNotNull("Test if there is valid School arraylist to add to", schoolList);
			assertEquals("Test that the School arraylist is empty.", 0, schoolList.size());
			//Given an empty list, after adding 1 school, the size of the list is 1
			SchCentre.addSchool(schoolList, sch1);		
			assertEquals("Test that the School arraylist size is 1.", 1, schoolList.size());

			
			// Add a school
			SchCentre.addSchool(schoolList, sch2);
			assertEquals("Test that the School arraylist size is now 2.", 2, schoolList.size());
			//The item just added is as same as the last item in the list
			assertSame("Test that School is added to the end of the list.", sch2, schoolList.get(1));

			// Add a school that already exists in the list
			SchCentre.addSchool(schoolList, sch2);
			assertEquals("Test that the School arraylist size is unchange.", 2, schoolList.size());

			// Add a school that has missing detail
			School sch_missing = new School("Singapore Polytechnic", "", "Singapore 139651");
			SchCentre.addSchool(schoolList, sch_missing);
			assertEquals("Test that the School arraylist size is unchange.", 2, schoolList.size());
		}

		@Test
		public void testRetrieveAllSchool() {
			//Test Case 1
			// Test if School list is not null and empty
			assertNotNull("Test if there is valid School arraylist to add to", schoolList);
			assertEquals("Test that the School arraylist is empty.", 0, schoolList.size());
			// Attempt to retrieve the Schools 
			String allSchool= SchCentre.retrieveAllSchool(schoolList);
			String testOutput = "";
			// Test if the output is empty
			assertEquals("Test that nothing is displayed", testOutput, allSchool);

			//Test Case 2
			SchCentre.addSchool(schoolList, sch1);
			SchCentre.addSchool(schoolList, sch2);
			// Test that the list is not empty
			assertEquals("Test that School arraylist size is 2.", 2, schoolList.size());
			// Attempt to retrieve the Schools
			allSchool= SchCentre.retrieveAllSchool(schoolList);
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
			SchCentre.deleteSchool("Nanyang Polytechnic", schoolList);		
			assertEquals("Test that the School arraylist size is 2.", 2, schoolList.size());
			// Delete a school
			SchCentre.deleteSchool("Temasek Polytechnic", schoolList);
			assertEquals("Test that the School arraylist size is now 1.", 1, schoolList.size());
			
			// Delete a school that is not in the list
	        SchCentre.deleteSchool("Temasek Polytechnic", schoolList);
	        assertEquals("Test that the School arraylist size is unchange.", 1, schoolList.size()); 
	        
		}


		@After
		public void tearDown() throws Exception {
			sch1 = null;
			sch2 = null;
			sch3 = null;
			schoolList = null;
			

		}

	}
