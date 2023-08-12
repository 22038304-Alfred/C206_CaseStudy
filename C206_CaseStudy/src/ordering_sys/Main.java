package ordering_sys;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import ordering_sys.*;




public class Main{

	private static final int Max_option = 5;
	private static final int Max_option_Vendor = 6;
	private static ArrayList<School> schoolList = new ArrayList<>();
	private static ArrayList<Menu> MenuList = new ArrayList<Menu>();
	private static Menu [] WeeklyMenuList = new Menu[5];
	private static ArrayList<Vendor> VendorList = new ArrayList<Vendor>();
	private static ArrayList<Parents> ParentAccounts = new ArrayList<Parents>();
	private static ArrayList<Admin> AdminAccounts = new ArrayList<Admin>();
	private static int option = 0;
	private static Meals[] selectedItems;
	
	 public static void main(String[] args) {
		 GeneralUI();
	 }
	
	
	private static void mainMenu() {
		Helper.line(60, "=");
		System.out.println("WELCOME TO SCHOOL LUNCHBOX ONLINE");
		Helper.line(60, "=");
		System.out.println("LOGIN AS: ");
		System.out.println("1. Administrator");
		System.out.println("2. Vendor");
		System.out.println("3. User");
		System.out.println("4. Register");
		System.out.println("5. End");
	}
	private static void userMenu() {
		Helper.line(60, "=");
		System.out.println("WELCOME TO SCHOOL LUNCHBOX ONLINE (USER PAGE)");
		Helper.line(60, "=");
		System.out.println("1. View Menu");
		System.out.println("2. Start Ordering");
		System.out.println("3. Tracking/View Order");
		System.out.println("4. Change payment");
		System.out.println("5. Rate/Feedbacks");
		System.out.println("6. End");
	}
	private static void adminMenu() {
		Helper.line(60, "=");
		System.out.println("WELCOME TO SCHOOL LUNCHBOX ONLINE (ADMIN PAGE)");
		Helper.line(60, "=");
		System.out.println("1. Manage School Information");
		System.out.println("2. Manage Accounts Overview");
		System.out.println("3. Manage Vendors");
		System.out.println("4. Generate Report");
		System.out.println("5. End");
	}
	private static void vendorMenu() {
		Helper.line(60, "=");
		System.out.println("WELCOME TO SCHOOL LUNCHBOX ONLINE (VENDOR PAGE)");
		Helper.line(60, "=");
		System.out.println("1. Add Items");
		System.out.println("2. View All Items");
		System.out.println("3. Delete Items");
		System.out.println("4. View Rate/FeedBacks");
		System.out.println("5. End");	
	}

	private static void GeneralUI() {
	    Loop1: while (option != Max_option) {
	        mainMenu();
	        option = Helper.readInt("Enter choice: ");
	        switch (option) {
	            case 1:
			        AdminAccounts.add(new Admin("queenie", "P@ssw0rd"));
			        AdminAccounts.add(new Admin("alfred", "P@ssw0rd"));
			        AdminAccounts.add(new Admin("hedil", "P@ssw0rd"));
			        AdminAccounts.add(new Admin("gemma", "P@ssw0rd"));
			        AdminAccounts.add(new Admin("jichin", "P@ssw0rd"));

	                System.out.println("Login as administrator..");  
	                String username = Helper.readString("Enter your username: ");
	    		    String password = Helper.readString("Enter your password: ");
	    		    boolean authenticateAdmin = false;

	    		    for (Admin admin : AdminAccounts) {
	    		        if (admin.getUser().equalsIgnoreCase(username) && admin.getPass().equalsIgnoreCase(password)) {
	    		            System.out.println("Login successful as " + username);
	    		            authenticateAdmin = true;
	    		            //adminMenu();
	    		            break; 
	    		        }
	    		    }
	    		

	    		    if (!authenticateAdmin) {
	    		        System.out.println("Invalid username or password. Exiting admin UI.");
	    		        return;
	    		    }
	                AdminUI();
	                break;
	                
	                
	            case 2:
	                System.out.println("Login as vendor..");
	               
	       		 VendorList.add(new Vendor("Alex", "P@ssw0rd","rp"));
	       		 VendorList.add(new Vendor("Bob", "P@ssw0rd","rp"));
	       		 
	       		    String uname = Helper.readString("Enter your username: ");
	       		    String pass = Helper.readString("Enter your password: ");
	       		    boolean authenticateVendor = false;

	       		    for (Vendor v: VendorList) {
	       		        if (v.getName().equalsIgnoreCase(uname) && v.getPass().equalsIgnoreCase(pass)) {
	       		            System.out.println("Login successful as " + uname);
	       		            authenticateVendor = true;
	       		            //vendorMenu();
	       		            break; 
	       		        }
	       		    }
	       		    if (!authenticateVendor) {
	       		        System.out.println("Invalid username or password. Exiting Vendor UI.");
	       		        return;
	       		    }

	                VendorUI();
	                break;
	                
	                
	                
	            case 3:
	                System.out.println("Login as user..");

	                String enteredName = Helper.readString("Enter username: ");
	                String enteredPassword = Helper.readString("Enter password: ");
	                Parents currentUser = null; 

	                for (Parents parent : ParentAccounts) {
	                    if (parent.getName().equals(enteredName) && parent.getPassword().equals(enteredPassword)) {
	                        currentUser = parent; 
	                        userMenu();
	                        option = Helper.readInt("Enter your choice: ");
	                        userUI();
	                        break;
	                    }
	                }

	                if (currentUser == null) {
	                    System.out.println("Invalid username or password. Exiting user UI.");
	                }
	                break;


	            case 4:
	                System.out.println("Register a new account..");
	                String name = "";
	                String pw = "";
	                boolean isValidUsername = false;
	                while (!isValidUsername) {
	                    name = Helper.readString("Enter username: ");

	                    String usernamePattern = "^[a-zA-Z0-9]{6,}$";
	                    isValidUsername = name.matches(usernamePattern);
	                    if (!isValidUsername) {
	                        System.out.println("Invalid username. Username must be at least 6 characters long and contain only letters and digits.");
	                    }
	                }

	                boolean isValidPassword = false;
	                while (!isValidPassword) {
	                	pw = Helper.readString("Enter password: ");
	                    String passwordPattern = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$"; //at least 8 characters contains one letter, one digit, one special char
	                    isValidPassword = pw.matches(passwordPattern);
	                    if (!isValidPassword) {
	                        System.out.println("Invalid password. Password must be at least 8 characters long and contain at least one letter, one digit, and one special character (@, $, !, %, *, ?, &).");
	                    }
	                }

	                Parents newUser = new Parents(name, pw);
	                ParentAccounts.add(newUser);
	                System.out.println("Account registered successfully!");
	                break;

	            case 5:
	                System.out.println("Session ended");
	                break;
	            default:
	                System.out.println("Invalid choice. Please try again.");
	                break;
	  }
   }
}


	private static void AdminUI() {
		Loop2: while (option != Max_option) {
			  int option = 0;			   
			  adminMenu();
			  option = Helper.readInt("Enter choice: ");
	    
	    switch (option) {
	        case 1:
	            ManageSchInfo();
	            break;
	        case 2:
	            ManageAcc();
	            break;
	        case 3:
	            ManageVendor();
	            break;
	        case 4:
	            Report();
	            break;
	        case 5:
	            System.out.println("Session ended");
	            break Loop2;
	        default:
	            System.out.println("Invalid choice. Please try again.");
	            break;
	    }
	  }
	}
	private static void ManageSchInfo() {
	    System.out.println("MANAGE SCHOOL INFORMATION");
	    System.out.println("1. Add School");
	    System.out.println("2. View All Schools");
	    System.out.println("3. Delete School");
	    System.out.println("4. Back");

	    int choice = Helper.readInt("Enter your choice: ");
	    
	    switch (choice) {
	        case 1:
	            addSchool();
	            break;
	        case 2:
	        	viewAllSchool();
	        	break;
	        case 3:
	            deleteSchool();
	            break;
	        case 4:
	        	AdminUI();
	        	break;
	        default:
	            System.out.println("Invalid choice. Please try again.");
	            break;
	    }
	}
	private static void viewAllSchool() {
	    System.out.println("List of all schools:");
	    for (School school : schoolList) {
	        System.out.println("School Name: " + school.getName());
	        System.out.println("School Address: " + school.getAddress());
	        System.out.println("---------------------------");

	    }    
	}

	private static School findSchoolByName(String schoolName) {
	    for (School school : schoolList) {
	        if (school.getName().equalsIgnoreCase(schoolName)) {
	            return school;
	        }
	    }
	    return null; 
	}
	private static void deleteSchool() {
	    String schoolName = Helper.readString("Enter the name of the school you want to delete: ");
	    School schoolToDelete = findSchoolByName(schoolName);

	    if (schoolToDelete != null) {
	    	
	        schoolList.remove(schoolToDelete);
	        System.out.println("School deleted successfully!");
	    } else {
	        System.out.println("School not found. Please check the name and try again.");
	    }
	}

	private static void addSchool() {
	    String schoolName = Helper.readString("Enter the name of the new school: ");
	    String schoolAddress = Helper.readString("Enter the address of the new school: ");

	    School newSchool = new School(schoolName, schoolAddress);
	    schoolList.add(newSchool);

	    System.out.println("New school added successfully!");
	}

		private static void ManageAcc() {
		    System.out.println("MANAGE ACCOUNTS");
		    System.out.println("1. Add User");
		    System.out.println("2. View All Users");
		    System.out.println("3. Delete Users");
		    System.out.println("4. Back");

		    int choice = Helper.readInt("Enter your choice: ");

		    switch (choice) {
		        case 1:
		            addUser();
		            break;
		        case 2:
		            viewAllUser();
		            break;
		        case 3:
		        	deleteUser();
		            break;
		        case 4:
		            break;
		        default:
		            System.out.println("Invalid choice. Please try again.");
		            break;
		    }
	}

		private static void addUser() {
		    String username = Helper.readString("Enter the username for the new user: ");
		    String password = Helper.readString("Enter the password for the new user: ");

		    Parents newUser = new Parents(username, password);
		    ParentAccounts.add(newUser);

		    System.out.println("User added successfully.");
		}

		private static void viewAllUser() {
			System.out.println("List of all users:");
			for (Parents parent : ParentAccounts) {
	        System.out.println("Username: " + parent.getName());
	        System.out.println("Password: " + parent.getPassword());
	        
	        System.out.println("----------------------");
	    }
	}

	private static void deleteUser() {
	    String username = Helper.readString("Enter the username of the user you want to delete: ");

	    Parents userToDelete = null;
	    for (Parents parent : ParentAccounts) {
	        if (parent.getName().equalsIgnoreCase(username)) {
	            userToDelete = parent;
	            break;
	        }
	    }

	    if (userToDelete != null) {
	        ParentAccounts.remove(userToDelete);
	        System.out.println("User deleted successfully.");
	    } else {
	        System.out.println("User not found.");
	    }
	}
	
	private static void ManageVendor() {
	    int option = 0;
	 
	        Helper.line(60, "=");
	        System.out.println("MANAGE VENDORS");
	        Helper.line(60, "=");
	        System.out.println("1. Add Vendor");
	        System.out.println("2. View All Vendors");
	        System.out.println("3. Delete Vendor");
	        System.out.println("4. View Vendor Feedbacks");
	        System.out.println("5. Back");

	        option = Helper.readInt("Enter your choice: ");

	        switch (option) {
	            case 1:
	                addVendor();
	                break;
	            case 2:
	                viewAllVendors();
	                break;
	            case 3:
	            	 deleteVendor();
	                break;
	            case 4:
	                viewVendorFeedbacks();
	                break;
	            case 5:
	            	break;
	            default:
	                System.out.println("Invalid choice. Please try again.");
	                break;
	        }
	   }
	

	private static void addVendor() {
	    String vendorName = Helper.readString("Enter the name of the new vendor: ");
	    String vendorPass = Helper.readString("Enter the password of the new vendor: ");
	    String vendorAddress = Helper.readString("Enter the address of the new vendor: ");


	    Vendor newVendor = new Vendor(vendorName, vendorPass, vendorAddress);
	    VendorList.add(newVendor);

	    System.out.println("New vendor added successfully!");
	}

	private static void deleteVendor() {
	    String vendorName = Helper.readString("Enter the name of the vendor you want to delete: ");
	    Vendor vendorToDelete = null;

	    for (Vendor vendor : VendorList) {
	        if (vendor.getName().equalsIgnoreCase(vendorName)) {
	            vendorToDelete = vendor;
	            break;
	        }
	    }

	    if (vendorToDelete != null) {
	        VendorList.remove(vendorToDelete);
	        System.out.println("Vendor deleted successfully!");
	    } else {
	        System.out.println("Vendor not found. Please check the name and try again.");
	    }
	}

	private static void viewAllVendors() {
	    System.out.println("List of all vendors:");
	    for (Vendor vendor : VendorList) {
	        System.out.println("Vendor Name: " + vendor.getName());
	        System.out.println("Vendor Password: " + vendor.getPass());
	        System.out.println("Vendor Address: " + vendor.getAddress());
	        System.out.println("---------------------------");
	    }
	}


	private static void viewVendorFeedbacks() {
	    String vendorName = Helper.readString("Enter the name of the vendor to view feedbacks: ");

	    viewFeedback(vendorName);
	}

	private static void Report() {
	    System.out.println("REPORTS");
	    System.out.println("1. Sales Report");
	    System.out.println("2. Order History Report");
	    System.out.println("3. Feedback Report");
	    System.out.println("4. Vendor Ratings Report");
	    System.out.println("5. Back");

	    int choice = Helper.readInt("Enter your choice: ");

	    switch (choice) {
	        case 1:
	            generateSalesReport();
	            break;
	        case 2:
	            generateOrderHistoryReport();
	            break;
	        case 3:
	            generateFeedbackReport();
	            break;
	        case 4:
	            generateVendorRatingsReport();
	            break;
	        case 5:
	        	AdminUI();
	            break;
	        default:
	            System.out.println("Invalid choice. Please try again.");
	            break;
	    }
	}
	

	private static void generateSalesReport() {
	    System.out.println("Sales Report:");
	    for (Vendor vendor : VendorList) {
	        double totalSales = calculateTotalSales(vendor);
	        System.out.println("Vendor: " + vendor.getName());
	        System.out.println("Total Sales: " + totalSales);
	        System.out.println("------------------------");
	    }
	}

	private static double calculateTotalSales(Vendor vendor) {
	    double totalSales = 0;
	    for (Ordering order : vendor.getOrderHistory()) {
	        totalSales += order.getTotalAmount();
	    }
	    return totalSales;
	}
	private static void generateOrderHistoryReport() {
	    System.out.println("Order History Report:");
	    for (Parents parent : ParentAccounts) {
	        System.out.println("User: " + parent.getName());
	        ArrayList<Ordering> orderList = parent.getOrderList();
	        for (Ordering order : orderList) {
	            System.out.println("Order ID: " + order.getOrderID());
	            System.out.println("Date: " + order.getDate());
	            System.out.println("Vendor: " + order.getVendorName());
	            System.out.println("Items: " + order.getItems());
	            System.out.println("Total Amount: " + order.getTotalAmount());
	            System.out.println("Status: " + order.getOrderID());
	            System.out.println("------------------------");
	        }
	    }
	}
	private static void generateFeedbackReport() {
	    System.out.println("Feedback Report:");
	    for (Vendor vendor : VendorList) {
	        System.out.println("Vendor: " + vendor.getName());
	        for (Review review : vendor.getReviews()) {
	            System.out.println("Food Rating: " + review.getRateFood());
	            System.out.println("Experience Rating: " + review.getRateExperience());
	            System.out.println("Feedback: " + review.getImprovements());
	            System.out.println("------------------------");
	        }
	    }
	}

	private static void generateVendorRatingsReport() {
	    System.out.println("Vendor Ratings Report:");
	    for (Vendor vendor : VendorList) {
	        double avgFoodRating = calculateAverageFoodRating(vendor);
	        double avgExperienceRating = calculateAverageExperienceRating(vendor);

	        System.out.println("Vendor: " + vendor.getName());
	        System.out.println("Average Food Rating: " + avgFoodRating);
	        System.out.println("Average Experience Rating: " + avgExperienceRating);
	        System.out.println("------------------------");
	    }
	}

	private static double calculateAverageFoodRating(Vendor vendor) {
	    double totalFoodRating = 0;
	    int count = 0;
	    for (Review review : vendor.getReviews()) {
	        totalFoodRating += review.getRateFood();
	        count++;
	    }
	    return count > 0 ? totalFoodRating / count : 0;
	}

	private static double calculateAverageExperienceRating(Vendor vendor) {
	    double totalExperienceRating = 0;
	    int count = 0;
	    for (Review review : vendor.getReviews()) {
	        totalExperienceRating += review.getRateExperience();
	        count++;
	    }
	    return count > 0 ? totalExperienceRating / count : 0;
	}

	
	
	
	
	private static void VendorUI() {
		
		Loop3: while(option != Max_option_Vendor) {
		int option = 0;
		String username = "";
		vendorMenu();
		option = Helper.readInt("Enter choice: ");
			switch (option) {
		        case 1:
		        	if (!VendorList.isEmpty()) {
	                    username = VendorList.get(0).getName();
	                } else {
	                    System.out.println("No vendors available.");
	                    break;
	                }
		        	 AddItems(username);
		        	 break;
		        case 2:
		        	ViewAllItems(MenuList);
		            break;
		        case 3:
		        	if (!VendorList.isEmpty()) {
	                    username = VendorList.get(0).getName();
	                } else {
	                    System.out.println("No vendors available.");
	                    break;
	                }
		        	DelItems(username);
		        	break;
		        case 4:
		        	if (!VendorList.isEmpty()) {
	                    username = VendorList.get(0).getName();
	                } else {
	                    System.out.println("No vendors available.");
	                    break;
	                }
		        	ViewFB(username);
		            break;

		        case 5:
		        	 System.out.println("Session ended");
		             break Loop3;
		        default:
		            System.out.println("Invalid choice. Please try again.");
		            break;
		    }
		}
	}
	private static void AddItems(String vendorName) {
	    String itemName = Helper.readString("Enter the name of the new item: ");
	    String itemDescription = Helper.readString("Enter the description of the new item: ");
	    double itemPrice = Helper.readDouble("Enter the price of the new item: ");

	    for (Vendor vendor : VendorList) {
	        if (vendor.getName().equalsIgnoreCase(vendorName)) {
	            vendor.addItem(itemName, itemDescription, itemPrice);
	            System.out.println("New item added successfully!");
	            return;
	        }
	    }

	    System.out.println("Vendor with the name " + vendorName + " not found.");
	}


	private static void ViewAllItems(ArrayList<Menu> menuList) {
	    System.out.println("List of all items:");
	    for (Menu menu : menuList) {
	        System.out.println("Item Name: " + menu.getItemName());
	        System.out.println("Item Price: " + menu.getItemPrice());
	        System.out.println("---------------------------");
	    }
	}
	private static void DelItems(String vendorName) {
	    String itemName = Helper.readString("Enter the name of the item you want to delete: ");

	    for (Vendor vendor : VendorList) {
	        if (vendor.getName().equalsIgnoreCase(vendorName)) {
	            vendor.deleteItem(itemName);
	            System.out.println("Item deleted successfully!");
	            break;
	        }
	    }
	}

	private static void ViewFB(String vendorName) {

	    for (Vendor vendor : VendorList) {
	        if (vendor.getName().equalsIgnoreCase(vendorName)) {
	            for (Review review : vendor.getReviews()) {
	                System.out.println("Food Rating: " + review.getRateFood());
	                System.out.println("Experience Rating: " + review.getRateExperience());
	                System.out.println("Feedback: " + review.getImprovements());
	                System.out.println("------------------------");
	            }
	            break;
	        }
	    }
	}
	
	private static ArrayList<Vendor> getAvailableVendorsForDate(String chosenDate) {
	    ArrayList<Vendor> availableVendors = new ArrayList<>();

	    DayOfWeek date = DayOfWeek.valueOf(chosenDate.toUpperCase());

	    for (Vendor vendor : VendorList) {
	        ArrayList<Menu> menu = vendor.getMenu();

	        for (Menu meal : menu) {
	            if (meal.getDayOfWeek() == date) {
	                availableVendors.add(vendor);
	                break;
	            }
	        }
	    }

	    return availableVendors;
	}

	private static void StartOrder() {
	    String datePattern = "(?i)(mon|tues|wednes|fri)day";
	    String chosenDate = Helper.readStringRegEx("Enter the day you want to order (e.g. Monday): ", datePattern);

	    Parents currentUser = getCurrentUser();

	    ArrayList<Vendor> availableVendors = getAvailableVendorsForDate(chosenDate);

	    if (availableVendors.isEmpty()) {
	        System.out.println("No vendors available on the chosen date.");
	        return;
	    }

	    int vendorOption = 1;
	    for (Vendor vendor : availableVendors) {
	        System.out.println(vendorOption + ". " + vendor.getName());
	        vendorOption++;
	    }

	    int chosenVendorOption = Helper.readInt("Select a vendor: ");

	    if (chosenVendorOption >= 1 && chosenVendorOption <= availableVendors.size()) {
	        Vendor chosenVendor = availableVendors.get(chosenVendorOption - 1);

	        Menu vendorMenu = getMenuForDate(chosenVendor, DayOfWeek.valueOf(chosenDate.toUpperCase()));

	        System.out.println("Menu for " + chosenVendor.getName() + " on " + chosenDate + ":");
	        for (Meals meal : vendorMenu.getFoodMenu()) {
	            System.out.println("Name: " + meal.getName());
	            System.out.println("Description: " + meal.getDescription());
	            System.out.println("Price: " + meal.getPrice());
	            System.out.println("----------------------");
	        }

	        addItemsToUserOrder(currentUser, chosenVendor, vendorMenu.getFoodMenu(), chosenDate);
	        System.out.println("Order placed successfully!");
	    } else {
	        System.out.println("Invalid vendor selection.");
	    }
	}

	private static void addItemsToUserOrder(Parents currentUser, Vendor chosenVendor, ArrayList<Meals> selectedItems, String chosenDate) {
	    double totalAmount = 0;
	    for (Meals selectedMeal : selectedItems) {
	        totalAmount += selectedMeal.getPrice();
	    }

	    int orderID = generateUniqueOrderID();

	    DayOfWeek orderDate = DayOfWeek.valueOf(chosenDate.toUpperCase());

	    Ordering userOrder = new Ordering(orderID, orderDate, chosenVendor, selectedItems, totalAmount, "Pending");

	    currentUser.addOrder(userOrder);
	}


	private static int orderCounter = 1;

	private static int generateUniqueOrderID() {
	    return orderCounter++;
	}

	private static Menu getMenuForDate(Vendor chosenVendor, DayOfWeek chosenDay) {
	    for (Menu menu : chosenVendor.getMenu()) {
	        if (menu.getDayOfWeek() == chosenDay) {
	            return menu;
	        }
	    }
	    return null;
	}

		private static Parents getCurrentUser() {
		    String username = Helper.readString("Enter your username: ");
		    String password = Helper.readString("Enter your password: ");

		    for (Parents parent : ParentAccounts) {
		        if (parent.authentication(username, password)) {
		            return parent;
		        }
		    }
		    return null;
		}
		private static void trackingParents() {
		    String username = Helper.readString("Enter your username: ");
		    String password = Helper.readString("Enter your password: ");

		    Parents currentUser = authenticateParent(username, password);

		    if (currentUser != null) {
		        ArrayList<Ordering> orderList = currentUser.getOrderList();

		        if (orderList.isEmpty()) {
		            System.out.println("You have no past orders.");
		        } else {
		            System.out.println("Your past orders:");
		            for (Ordering order : orderList) {
		                System.out.println("Order ID: " + order.getOrderID());
		                System.out.println("Date: " + order.getDate());
		                System.out.println("Vendor: " + order.getVendorName());
		                System.out.println("Items:");

		                for (Meals meal : order.getItems()) {
		                    System.out.println("  - " + meal.getName() + " (" + meal.getPrice() + ")");
		                }

		                System.out.println("Total Amount: " + order.getTotalAmount());
		                System.out.println("Status: " + order.getOrderID());
		                System.out.println("----------------------");
		            }
		        }
		    } else {
		        System.out.println("Invalid username or password. Please try again.");
		    }
		}

		private static Parents authenticateParent(String username, String password) {
		    for (Parents parent : ParentAccounts) {
		        if (parent.authentication(username, password)) {
		            return parent;
		        }
		    }
		    return null;
		}

	
		private static void Rating() {
		    String username = Helper.readString("Enter your username: ");
		    String password = Helper.readString("Enter your password: ");

	
		    Parents currentUser = authenticateParent(username, password);

		    if (currentUser != null) {
		        ArrayList<Ordering> orderList = currentUser.getOrderList();

		        if (orderList.isEmpty()) {
		            System.out.println("You have no past orders to rate.");
		        } else {
		            int orderIDToRate = Helper.readInt("Enter the Order ID you want to rate: ");
		            Ordering orderToRate = findOrderByID(orderList, orderIDToRate);

		            if (orderToRate != null && !orderToRate.isRated()) {
		                int rateFood = Helper.readInt("Rate the food (1 to 5): ");
		                int rateExperience = Helper.readInt("Rate the overall experience (1 to 5): ");
		                String improvements = Helper.readString("Any suggestions for improvement: ");

	
		                Review review = new Review(rateFood, rateExperience, improvements);

		                orderToRate.setReview(review);

		                orderToRate.setRated(true);

		                System.out.println("Thank you for providing your feedback!");
		            } else {
		                System.out.println("Invalid Order ID or you have already rated this order.");
		            }
		        }
		    } else {
		        System.out.println("Invalid username or password. Please try again.");
		    }
		}

		private static Ordering findOrderByID(ArrayList<Ordering> orderList, int orderID) {
		    for (Ordering order : orderList) {
		        if (order.getOrderID() == orderID) {
		            return order;
		        }
		    }
		    return null;
	}


	
	private static void viewFeedback(String vendorName) {
	    for (Vendor vendor : VendorList) {
	        if (vendor.getName().equals(vendorName)) {
	            ArrayList<Review> reviews = vendor.getReviews();
	            int maxReviewsToShow = 5;
	            
	            for (int i = 0; i < Math.min(maxReviewsToShow, reviews.size()); i++) {
	                Review review = reviews.get(i);
	                System.out.printf("Food Rating: %d\nExperience Rating: %d\nDescription: %s\n",
	                        review.getRateFood(), review.getRateExperience(), review.getImprovements());
	            }
	            return; 
	        }
	    }
	}

private static void userUI() {
    int option = 0;
    userMenu();
    Parents currentUser = getCurrentUser(); 
    
        switch (option) {
            case 1: 
                String datePattern = "(?i)(mon|tues|wednes|fri)day";
                String chosenDate = Helper.readStringRegEx("Enter the day you want to order (e.g. Monday): ", datePattern);
                ArrayList<Vendor> availableVendors = getAvailableVendorsForDate(chosenDate);

                if (!availableVendors.isEmpty()) { 
                    displayAvailableVendors(availableVendors);
                    int chosenVendorOption = Helper.readInt("Select a vendor: ");

                    if (chosenVendorOption >= 1 && chosenVendorOption <= availableVendors.size()) {
                        Vendor chosenVendor = availableVendors.get(chosenVendorOption - 1);
                        displayMenuForVendor(chosenVendor, null);
                        makeOrder(currentUser, chosenVendor, chosenDate);
                    } else {
                        System.out.println("Invalid vendor selection.");
                    }
                } else {
                    System.out.println("No vendors available on the chosen date.");
                }
                break;
            case 2:
                displayOrderHistory(currentUser);
                break;
            case 3:
                viewFeedback(currentUser);
                break;
            case 4:
                giveFeedback(currentUser);
                break;
            case 5:
                System.out.println("Exiting user UI.");
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
    }


private static void displayAvailableVendors(ArrayList<Vendor> availableVendors) {
    System.out.println("Available Vendors for the chosen date:");
    int vendorOption = 1;
    for (Vendor vendor : availableVendors) {
        System.out.println(vendorOption + ". " + vendor.getName());
        vendorOption++;
    }
}

private static void displayMenuForVendor(Vendor vendor,  DayOfWeek chosenDate) {
    Menu vendorMenu = getMenuForDate(vendor, chosenDate);
    System.out.println("Menu for " + vendor.getName() + " on " + chosenDate + ":");
    for (Meals meal : vendorMenu.getFoodMenu()) {
        System.out.println("Name: " + meal.getName());
        System.out.println("Description: " + meal.getDescription());
        System.out.println("Price: " + meal.getPrice());
        System.out.println("----------------------");
    }
}

private static void makeOrder(Parents currentUser, Vendor chosenVendor, String chosenDate) {

    Meals vendorMenu = getMenuForDate(chosenVendor, chosenDate);

    if (vendorMenu == null) {
        System.out.println("Invalid vendor or date selection.");
        return;
    }

    System.out.println("Menu for " + chosenVendor.getName() + " on " + chosenDate + ":");
    Meals[] foodMenu = vendorMenu.getFoodMenu();
    for (int i = 0; i < foodMenu.length; i++) {
        System.out.println("Item " + (i + 1) + ":");
        System.out.println("Name: " + foodMenu[i].getName());
        System.out.println("Description: " + foodMenu[i].getDescription());
        System.out.println("Price: " + foodMenu[i].getPrice());
        System.out.println("----------------------");
    }

    ArrayList<Meals> selectedItems = new ArrayList<>(); // Change this line

    int itemChoice = 0;
    while (itemChoice != -1) {
        itemChoice = Helper.readInt("Enter item number to add to order (-1 to finish): ");
        if (itemChoice >= 1 && itemChoice <= foodMenu.length) {
            Meals selectedMeal = foodMenu[itemChoice - 1];
            selectedItems.add(selectedMeal);
        } else if (itemChoice != -1) {
            System.out.println("Invalid item number. Please try again.");
        }
    }

    double totalAmount = 0;
    for (Meals selectedMeal : selectedItems) {
        totalAmount += selectedMeal.getPrice();
    }

    int orderID = generateUniqueOrderID();

    Ordering userOrder = new Ordering(orderID, DayOfWeek.valueOf(chosenDate.toUpperCase()),
                                      chosenVendor, selectedItems, totalAmount, "Pending");

    currentUser.addOrder(userOrder);

    System.out.println("Order placed successfully!");
}


private static Meals getMenuForDate(Vendor chosenVendor, String chosenDate) {
	// TODO Auto-generated method stub
	return null;
}


private static void displayOrderHistory(Parents currentUser) {
    ArrayList<Ordering> orderList = currentUser.getOrderList();

    if (orderList.isEmpty()) {
        System.out.println("You have no past orders.");
    } else {
        System.out.println("Your past orders:");
        for (Ordering order : orderList) {
            System.out.println("Order ID: " + order.getOrderID());
            System.out.println("Date: " + order.getDate());
            System.out.println("Vendor: " + order.getVendorName());
            System.out.println("Items:");
            for (Meals meal : order.getItems()) {
                System.out.println("  - " + meal.getName() + " (" + meal.getPrice() + ")");
            }
            System.out.println("Total Amount: " + order.getTotalAmount());
            System.out.println("Status: " + order.getStatus());
            System.out.println("----------------------");
        }
    }
}

private static void viewFeedback(Parents currentUser) {
    System.out.println("Feedback for vendors:");
    for (Vendor vendor : VendorList) {
        System.out.println("Vendor: " + vendor.getName());
        ArrayList<Review> reviews = vendor.getReviews();
        if (reviews.isEmpty()) {
            System.out.println("No feedback available.");
        } else {
            for (Review review : reviews) {
                System.out.println("Food Rating: " + review.getRateFood());
                System.out.println("Experience Rating: " + review.getRateExperience());
                System.out.println("Description: " + review.getImprovements());
                System.out.println("------------------------");
            }
        }
    }
}


private static void giveFeedback(Parents currentUser) {
    int orderIDToRate = Helper.readInt("Enter the Order ID you want to rate: ");
    Ordering orderToRate = findOrderByID(currentUser.getOrderList(), orderIDToRate);

    if (orderToRate != null && !orderToRate.isRated()) {
        int rateFood = Helper.readInt("Rate the food (1 to 5): ");
        int rateExperience = Helper.readInt("Rate the overall experience (1 to 5): ");
        String improvements = Helper.readString("Any suggestions for improvement: ");

        Review review = new Review(rateFood, rateExperience, improvements);

        orderToRate.setReview(review);
        orderToRate.setRated(true);

        System.out.println("Thank you for providing your feedback!");
    } else if (orderToRate == null) {
        System.out.println("Invalid Order ID. Please try again.");
    } else {
        System.out.println("You have already rated this order.");
    }
}
}

