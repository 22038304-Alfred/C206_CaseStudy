import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import GA.User;
import GA.UserCentre;

public class UserTest {
	
 private User user1;
 private User user2;
 private User user3;
 
 private ArrayList<User> userList;
 
 public UserTest() {
	  super();
	 }
	 

 @Before
 public void setUp() throws Exception {
	    user1 = new User("queenie", "P@ssw0rd");
	    user2 = new User("Alfred", "P@ssw0rd");
	    user3 = new User("jc", "P@ssw0rd");
	    
	    
	    userList = new ArrayList<User>();
 }
 
 

 @Test
 public void testAddUser() {
  // UserCentre list is not null and it is empty
  assertNotNull("Test if there is valid User arraylist to add to", userList);
  assertEquals("Test that the User arraylist is empty.", 0, userList.size());
  //Given an empty list, after adding 1 user, the size of the list is 1
  UserCentre.addUser(userList, user1);  
  assertEquals("Test that the User arraylist size is 1.", 1, userList.size());

  
  // Adding a user 
  UserCentre.addUser(userList, user2);
  assertEquals("Test that the User arraylist size is now 2.", 2,  userList.size() );
  //The item just added is as same as the last item in the list
  assertSame("Test that User is added to the end of the list.", user2, userList.get(1));

  // Add user that already exists in the list
  UserCentre.addUser(userList, user2);
  assertEquals("Test that the User arraylist size is unchange.", 2, userList.size());
  
 
   //Add an item that has missing detail
  User user_missing = new User("", "P@ssw0rd");
  UserCentre.addUser(userList, user_missing);
  assertEquals("Test that the User arraylist size is unchange.", 2, userList.size());
}
 
 
 @Test
 public void testretrieveAllUser() {
  //Test Case 1
  // Test if User list is not null and empty
  assertNotNull("Test if there is valid User arraylist to add to", userList);
  assertEquals("Test that the User arraylist is empty.", 0, userList.size());
  // Attempt to retrieve the UserCentre 
  String allUser= UserCentre.retrieveAllUser(userList);
  String testOutput = "";
  // Test if the output is empty
  assertEquals("Test that nothing is displayed", testOutput, allUser);

  //Test Case 2
  UserCentre.addUser(userList, user1);
  UserCentre.addUser(userList, user2);
  // Test that the list is not empty
  assertEquals("Test that user arraylist size is 2.", 2, userList.size());
  // Attempt to retrieve the UserCentres
  allUser= UserCentre.retrieveAllUser(userList);
  testOutput = String.format("%-10s %-20s \n", "queenie", "P@ssw0rd");
  testOutput += String.format("%-10s %-20s \n", "Alfred", "P@ssw0rd");
  // Test that the details are displayed correctly
  assertEquals("Test that the display is correct.", testOutput, allUser);

 //Test Case 3
  User user_missing = new User("", "P@ssw0rd");
  UserCentre.addUser(userList, user_missing);
  assertEquals("Test that User arraylist size is 2.", 2, userList.size());
  assertFalse("Test that the last item in the arraylist is not available", !user_missing.isAuthenticate(user_missing.getName(), user_missing.getpw()));
  // Attempt to retrieve the Users  
  allUser= UserCentre.retrieveAllUser(userList);
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
  UserCentre.removeUser(userList,user1);
  assertEquals("Test that the User arraylist size is now 2 after removal", 2, userList.size());
  assertFalse("Test that the user 1 is removed from the list", userList.contains(user1));
  
//Test removal of a non-existing user
  UserCentre.removeUser(userList, new User("NonExistentUser", "IamN0nExist"));
  assertEquals("Test that the Uesr arraylist size is remain unchange.", 2, userList.size());
}
  @After
	public void tearDown() throws Exception {
		user1 = null;
		user2 = null;
		user3 = null;
		userList = null;


	}

}