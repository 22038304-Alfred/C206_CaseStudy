package GA;
import java.util.ArrayList;

public class UserCentre { 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
/*		
		int option = -99; 
		
		
		while (option != 3) {
			boolean userfound = true;
			option = Helper.readInt("\nEnter an option");
			
			if(option == 1) {
				addUser(userList);
				
			} else if (option == 2) {
				displayUserList(userList);
				
			} else if (option == 3) {
				removeUser(userList);
				
			} else {
				System.out.println("\n*** Invalid option selected ***\n");
			}
		}
	}
	*/
	ArrayList<User> userList = new ArrayList<User>();

    userList.add(new User("queenie", "P@ssw0rd"));
    userList.add(new User("Alfred", "P@ssw0rd"));
    userList.add(new User("jc", "P@ssw0rd"));
   
}
	 //input
		public static User inputUser() {	
			
			String name = Helper.readString("Enter account name > ");
			String pw = Helper.readString("Enter password > ");


			User acc = new User(name, pw);
			return acc;
			
		}
		
		
		//add
	    public static void addUser(ArrayList<User> userList, User acc) {
	    	User newUser;
	        for (User u : userList) {
	        	newUser = u ;  
	        if (newUser.getName().equalsIgnoreCase(acc.getName()) )
				return;
	        }
	        if (acc.getName().isEmpty() || acc.getpw().isEmpty()) {
	            return;
	        }
	        userList.add(acc);
	    }
	    
	    
	    //retrieve
	    public static String retrieveAllUser(ArrayList<User> userList) {
			
			String output = "";
			for (User u : userList) {
				if (u.isAuthenticate(u.getName(), u.getpw())) {
					output += u.toString();
				}
			}
			return output; 
		}
		public static void viewAllUser(ArrayList<User> userList) {
			
		String output = String.format("%-10s %-20s \n", "NAME", "PASSWORD");
			 output += retrieveAllUser(userList);	
			System.out.println(output); 
		}
	    
	    
		//delete
		public static void removeUser(ArrayList<User> userList, User acc) {
		    User delUser;
		    for (User u : userList) {
		        delUser = u;
		        if (delUser.getName().equals(acc.getName())) {
		            userList.remove(acc);
		            return; 
		        }
		    }
		}
	}
	/*
	//adding of the user 
	public static void addUser(ArrayList<User> userList) {
		String name = Helper.readString("Please enter your name:");
		String NRIC = Helper.readString("Please enter your NRIC:");
		
		boolean isAdded = userList.add(new User(name,NRIC));
		
		if (isAdded) {
			System.out.println("Welcome");
		}else {
			System.out.println("Failed to add");
		}
	}
		
	
	// display the user 
	public static void displayUserList(ArrayList<User> userList) {
		String sentence = String.format("%-15s %-10s\n", "Name", "IC");
		
		for ( int i = 0; i < userList.size(); i++) {
			if (userList.get(i) != null) {
				String name = userList.get(i).getName();
				String nric4 = userList.get(i).getNric4();
				sentence += String.format("%-15s %-10s\n", name, nric4);
			}
		}
		System.out.println(sentence);
	}
		
	
	// delete user
	public static boolean removeUser(ArrayList<User> userList) {
		
		boolean userfound = false;
		String name = Helper.readString("Please enter your name to remove a user:");
		for (int i = 0; i < userList.size(); i++) {
			if ( userList.get(i) != null & userList.get(i).getName().equalsIgnoreCase(name)) {
				userList.get(i).display();
				userfound = true;
				char cfmDeletion = Helper.readChar("Confirm deletion (y/n):");
				userList.remove(i);
				if (cfmDeletion == 'y') {
					System.out.println("*** User has been deleted ***");
				}	
			}
		}
		return userfound;
	}
}
*/



	
	

	



