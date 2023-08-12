import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//queenie 22044804
public class PaymentTest {

	private Payment pay1;
	private Payment pay2;
	private Payment pay3;
	
	private ArrayList<Payment> paymentList;
	
	public PaymentTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {

        pay1 = new Payment("12345", 40, "Visa", "54321");
        pay2 = new Payment("56789", 20, "Credit Card","98765");
        pay3 = new Payment("34567", 60, "PayNow", "76543");
        
        
        
        paymentList= new ArrayList<Payment>();

	}
	
	@Test
	public void testAddPayment() {  
		//Test Payment list is not null and it is empty
		assertNotNull("Test if there is valid Payment arraylist to add to", paymentList);
		assertEquals("Test that the Payment arraylist is empty.", 0, paymentList.size());
		//Given an empty list, after adding 1 Payment, the size of the list is 1
		PaymentMain.addPayment(paymentList, pay1);		
		assertEquals("Test that the Payment arraylist size is 1.", 1, paymentList.size());

		// Add an Payment
		PaymentMain.addPayment(paymentList, pay2);
		assertEquals("Test that the Payment arraylist size is now 2.", 2, paymentList.size());
		//The Payment just added is as same as the last Payment in the list
		assertSame("Test that Payment is added to the end of the list.", pay2, paymentList.get(1));

		// Add an Payment that already exists in the list
		PaymentMain.addPayment(paymentList, pay2);
		assertEquals("Test that the Payment arraylist size is unchange.", 2, paymentList.size());

		// Add an Payment that has missing detail
		Payment pay_missing = new Payment("33344", 40, "PayLah","");
		PaymentMain.addPayment(paymentList, pay_missing);
		assertEquals("Test that the Payment arraylist size is unchange.", 2, paymentList.size());
	
	}
	
	@Test
	public void testretrieveAllPayment() {
		//Test Case 1
		// Test if Payment list is not null and empty
		assertNotNull("Test if there is valid Payment arraylist to add to", paymentList);
		assertEquals("Test that the Payment arraylist is empty.", 0, paymentList.size());
		// Attempt to retrieve the Payments  
		String allPayment= PaymentMain.retrieveAllPayment(paymentList);
		String testOutput = "";
		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allPayment);

		//Test Case 2
		//Test retrieve payment after adding payment
		PaymentMain.addPayment(paymentList, pay1);
		PaymentMain.addPayment(paymentList, pay2);
		// Test that the list is not empty
		assertEquals("Test that Payment arraylist size is 2.", 2, paymentList.size());
		// Attempt to retrieve the Payments 
		allPayment= PaymentMain.retrieveAllPayment(paymentList);
		testOutput = String.format("%-10s %-30d %-10s %-10s %-10s \n", "12345", 40, "Yes", "Visa", "54321");
		testOutput += String.format("%-10s %-30d %-10s %-10s %-10s \n","56789", 20, "Yes", "Credit Card", "98765");
		//Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allPayment); 

		//Test Case 3
		//Test retrieve payment for a false record
		pay3.setRecord(false);
		PaymentMain.addPayment(paymentList, pay3);
		assertEquals("Test that Payment arraylist size is 3.", 3, paymentList.size());
		assertFalse("Test that the last Payment in the arraylist is not available", paymentList.get(2).getRecord());
		// Attempt to retrieve the Payments  
		allPayment= PaymentMain.retrieveAllPayment(paymentList);
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
		
		//Add payments into payment List and Delete an Payment
		PaymentMain.addPayment(paymentList, pay1);
		PaymentMain.addPayment(paymentList, pay2);
		PaymentMain.addPayment(paymentList, pay3);
		
		assertEquals("Test that the Payment arraylist size is 3.", 3, paymentList.size());

		//Test removal of payment
		PaymentMain.deletePayment(paymentList, pay1);
		assertEquals("Test that the Payment arraylist size is now 2 after removal.", 2, paymentList.size());
		assertFalse("Test that the pay1 is removed from the list", paymentList.contains(pay1));
		
		// Delete a Payment that is not exist in the list
		PaymentMain.deletePayment(paymentList, new Payment("88888", 40, "PayNow", "99999"));
		assertEquals("Test that the Payment arraylist size is remain unchange.", 2, paymentList.size());
	}
	
	
		@After
		public void tearDown() throws Exception {
			pay1 = null;
			pay2 = null;
			paymentList = null;

		}//end of main method
	}//end of class

	
