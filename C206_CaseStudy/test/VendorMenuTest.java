import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
 

public class VendorMenuTest {
 
	private Menu menu1;
	private Menu menu2;
	private Menu menu3;

	private ArrayList<Menu> menuList;

	public VendorMenuTest()
	{
		super();
	} 

	@Before
	public void setUp() throws Exception {
		menu1 = new Menu("Hamburger", "Delicious Beef Burger", 8.99, 5, "Western","Vendor 1");
		menu2 = new Menu("Garden fruit Salad", "Crispy Crunchy Fruti Salad", 3.99, 5,"Fruits", "Vendor 2");
		menu3 = new Menu("Fruit Juice", "Crisp Fruit Juice", 0.99, 5, "Drinks", "Vendor 3");
		menuList = new ArrayList<Menu>();
	}

	@Test
	public void testaddMenu() {
		//Menu list is not null and it is empty
		assertNotNull("Test if there is valid Menu arraylist to add to", menuList);
		assertEquals("Test that the menu arraylist is empty.", 0, menuList.size());
		//Given an empty list, after adding 1 school, the size of the list is 1
		vendorMenu.addMenu(menuList, menu1);		
		assertEquals("Test that the Menu arraylist size is 1.", 1, menuList.size());

		// Add a Menu
		vendorMenu.addMenu(menuList, menu2);
		assertEquals("Test that the Menu arraylist size is now 2.", 2, menuList.size());
		//The item just added is as same as the last item in the list
		assertSame("Test that Menu is added to the end of the list.", menu2, menuList.get(1));

		// Add a menu that already exists in the list
		vendorMenu.addMenu(menuList, menu2);
		assertEquals("Test that the Menu arraylist size is unchange.", 2, menuList.size());

		// Add a menu that has missing detail
		Menu menu_missing = new Menu("Hamburger", "Delicious Beef Burger", 8.99, 5, "Western","Vendor 1");
		vendorMenu.addMenu(menuList, menu_missing);
		assertEquals("Test that the Menu arraylist size is unchange.", 2, menuList.size());
	}

	@Test
	public void testRetrieveAllMenu() {
		//Test Case 1
		// Test if Menu list is not null and empty
		assertNotNull("Test if there is valid menu arraylist to add to", menuList);
		assertEquals("Test that the menu arraylist is empty.", 0, menuList.size());
		// Attempt to retrieve the Menu 
		String allMenu= vendorMenu.retrieveAllMenu(menuList);
		String testOutput = "";
		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allMenu);

		//Test Case 2
		vendorMenu.addMenu(menuList, menu1);
		vendorMenu.addMenu(menuList, menu2);
		// Test that the list is not empty
		assertEquals("Test that menu arraylist size is 2.", 2, menuList.size());
		// Attempt to retrieve the Menu
		allMenu= vendorMenu.retrieveAllMenu(menuList);
		testOutput = String.format("%-30s %-30s %-20s %-20s %-20s %-20s\n", "Hamburger", "Delicious Beef Burger", 8.99, 5, "Western","Vendor 1");
		testOutput += String.format("%-30s %-30s %-20s %-20s %-20s %-20s\n", "Garden fruit Salad", "Crispy Crunchy Fruti Salad", 3.99, 5,"Fruits", "Vendor 2");
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allMenu);
		
	}
	@Test
	public void testDeleteMenu() {

		ArrayList<Menu> menuList = new ArrayList<Menu>();

		menuList.add(new Menu("Hamburger", "Delicious Beef Burger", 8.99, 5, "Western","Vendor 1"));
		menuList.add(new Menu("Garden fruit Salad", "Crispy Crunchy Fruti Salad", 3.99, 5,"Fruits", "Vendor 2"));
		menuList.add(new Menu("Fruit Juice", "Crisp Fruit Juice", 0.99, 5, "Drinks", "Vendor 3"));

		// MEnu list is not null and it is not empty
		assertNotNull("Test if there is valid menu arraylist to delete from", menuList);
		assertEquals("Test that the menu arraylist is not empty.", 3, menuList.size());
		//Given a not empty list, after deleting 1 Menu, the size of the list is 2
		vendorMenu.deleteMenu("Hamburger", menuList);		
		assertEquals("Test that the menu arraylist size is 2.", 2, menuList.size());
		// Delete a Menu
		vendorMenu.deleteMenu("Hamburger", menuList);
		assertEquals("Test that the Menu arraylist size is now 1.", 1, menuList.size());

		// Delete a Menu that is not in the list
		vendorMenu.deleteMenu("Hamburger", menuList);
		assertEquals("Test that the Menu arraylist size is unchange.", 1, menuList.size()); 

	}

	@After
	public void tearDown() throws Exception {
		menu1 = null;
		menu2 = null;
		menu3 = null;
		menuList = null;
	}
}