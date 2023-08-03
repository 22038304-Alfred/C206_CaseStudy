import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Random;

public class C206_CaseStudy {
	private static final int Max_option = 5;
	private static final int Max_option_Vendor = 7;
	private static int option = 0;
	private static boolean authenticate = false;
	private static ArrayList<Vendor> VendorList = new ArrayList<Vendor>();
	private static ArrayList<Menu> MenuList = new ArrayList<Menu>();
	private static ArrayList<Admin> AdminList = new ArrayList<Admin>();
	private static ArrayList<Parents> ParentAccounts = new ArrayList<Parents>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ParentAccounts.add(new Parents("Default1","Pass123","St Hilda's School"));
		ParentAccounts.add(new Parents("Default2","Pass123","St Patricks's School"));
		AdminList.add(new Admin("Manager","Pw123"));
		ArrayList<Meals> VendorMeal1 = new ArrayList<Meals>();
		ArrayList<Meals> VendorMeal2 = new ArrayList<Meals>();
		VendorMeal1.add(new Meals("Chicken Rice","Traditional and Fragrant Dish!",3.50,1200));
		VendorMeal1.add(new Meals("Nasi Lemak","Delicious and flavourful!",2.80,1300));
		VendorMeal2.add(new Meals("Meatless Don","Unique and Tasty!",4.50,1400));
		VendorMeal2.add(new Meals("Veg Quiche","Flaky and crumbly!",3.20,1500));
		VendorList.add(new Vendor("Vendor1","password","ABC@coporation.org","AMK Hub #1-23,123567",VendorMeal1));
		VendorList.add(new Vendor("Vendor2","pass123","EFG@coporation.org","Bishan Junction 8 #1-23,123564",VendorMeal2));
		
		
		loop_start: while (true) {
			String pattern = "(?i)(admin|vendor|user|end)";
			String UserSelect = Helper.readStringRegEx("Enter Login type [Admin, User, Vendor or end]: ", pattern);
			if (UserSelect.equalsIgnoreCase("user")) {
				String username = Helper.readString("Enter Username: ");
				String password = Helper.readString("Enter Password: ");
				for(Parents P: ParentAccounts) {
					boolean authentication = P.authentication(username,password);
					if (authentication == true) {
						GeneralUI();
					}else if(authentication == false) {
						System.out.println("Invalid Password or Username!");
					}
				}
			}else if(UserSelect.equalsIgnoreCase("vendor")) {
				String username = Helper.readString("Enter Username: ");
				String password = Helper.readString("Enter Password: ");
				for(Vendor V: VendorList) {
					boolean authentication = V.authentication(username, password);
					if(authentication == true) {
						VendorUI(username);
					}else if(authentication == false) {
						System.out.println("Invalid Password or Username!");
					}
				}
			}else if(UserSelect.equalsIgnoreCase("admin")) {
				String username = Helper.readString("Enter Username: ");
				String password = Helper.readString("Enter Password: ");
				for(Admin A: AdminList) {
					boolean authentication = A.authentication(username, password);
					if(authentication == true) {
						AdminUI(username);
					}else if(authentication == false) {
						System.out.println("Invalid Password or Username!");
					}
				}
			}else if(UserSelect.equalsIgnoreCase("end")) {
				break loop_start;
			}
		}
			
	}

	
	private static void Menu() {
		Helper.line(60, "=");
		System.out.println("WELCOME TO SCHOOL LUNCHBOX ONLINE");
		Helper.line(60, "=");
		System.out.println("1. View Menu");
		System.out.println("2. Start Ordering");
		System.out.println("3. Tracking/View Order");
		System.out.println("4. Rate/Feedbacks");
		System.out.println("5. End");
	}

	private static void GeneralUI() {
		Loop1: while(option != Max_option) {
			Menu();
			option = Helper.readInt("Enter choice: ");
			if(option == 1) {
				String datePattern = "(?i)(mon|tues|wednes|fri)day";
				String ChosenDate = Helper.readStringRegEx("Enter Date: ", datePattern);
				ViewMenu(ChosenDate, VendorList);
			}else if(option == 2){
				StartOrder();
			}else if(option == 3) {
				tracking_View();
			}else if(option == 4){
				Rating();
			}else if(option == Max_option){
				break Loop1;
			}
		}
	}
	
	private static void MenuAdmin() {
		Helper.line(60, "=");
		System.out.println("Administrator Mode");
		Helper.line(60, "=");
		System.out.println("1. Manage School Information");
		System.out.println("2. Manage Accounts Overview");
		System.out.println("3. Manage Vendors");
		System.out.println("4. Generate Report");
		System.out.println("5. End");
	}
	
	private static void AdminUI(String AdminName) {
		MenuAdmin();
		option = Helper.readInt("Enter choice: ");
		loop2: while(option != Max_option) {
			if(option == 1) {
				ManageSchInfo(AdminName);
			}else if(option == 2){
				ManageAcc(AdminName);
			}else if(option == 3) {
				ManageVendor(AdminName);
			}else if(option == 4){
				Report();
			}else if(option == Max_option) {
				break loop2;
			}
		}
	}
	
	private static void MenuVendor() {
		Helper.line(60, "-");
		System.out.println("Vendor Mode");
		Helper.line(60, "-");
		System.out.println("1. Add Items");
		System.out.println("2. Delete Items");
		System.out.println("3. Edit Items");
		System.out.println("4. FeedBacks");
		System.out.println("5. Edit Email/Location address");
		System.out.println("6. View Menu");
		System.out.println("7. End");
		
	}
	
	private static void VendorUI(String VendorName) {
		Loop3: while(option != Max_option_Vendor) {
			MenuVendor();
			option = Helper.readInt("Enter choice: ");
			if(option == 1) {
				AddItems(VendorName);
			}else if(option == 2){
				DelItems(VendorName);
			}else if(option == 3) {
				EditItems(VendorName);
			}else if(option == 4){
				ViewFB(VendorName);
			}else if(option == 5) {
				EditInfo(VendorName);
			}else if(option == 6) {
				ViewMenu(VendorName);
			}else if(option == Max_option_Vendor){
				break Loop3;
			}
		}
	}
//Main Start
	
	private static void ViewMenu(LocalDate date, ArrayList<Menu> MenuList) {
		for (Menu menu : MenuList) {
			if (date.equals(menu.getDate())) {
				System.out.println("Menu for "+menu.getDate()+":");
				for (Meals meal : menu.getFoodMenu()) {
		            System.out.println("Name: " + meal.getName());
		            System.out.println("Description: " + meal.getDescription());
		            System.out.println("Price: " + meal.getPrice());
		            System.out.println("----------------------");
					}
				
			}
		}
		return;
	}
	
	private static void StartOrder() {
		
	}
	
	private static void tracking_View() {
		
	}
	
	private static void Rating() {
		for(Parents P: ParentAccounts) {
			if(P.isTracking() == false &&
					!P.getOrderList().isEmpty()) {
				
			}
		}
	}
//Main End

//Admin Start
	private static void ManageSchInfo(String AdminName) {
		for(Admin A:AdminList) {
			if(AdminName.equals(A.getUser())) {
				
			}
		}
	}
	
	private static void ManageAcc(String AdminName) {
		for(Admin A: AdminList) {
			if(AdminName.equals(A.getUser())){
				LoopStart:while(true) {
					int MinIndex = 0;
					int MaxIndex = Math.min(10, ParentAccounts.size());
					for(int i = MinIndex; i<MaxIndex; i++) {
						Parents PA = ParentAccounts.get(i);
						System.out.printf("%d. Name:%s",
								i+1, PA.getName());
					}
					
					if(MaxIndex >= ParentAccounts.size()) {
						System.out.println("No More Vendors");
						break LoopStart;
					}
					
					boolean input = Helper.readBoolean("Show 10 more? (y/n): ");
					 if(input==true) {
						 MinIndex = MaxIndex;
						 MaxIndex = Math.min((MinIndex+10), ParentAccounts.size());
					 }else {
						 System.out.println("END");
						 break LoopStart;
					 }
					
				}
			}else {
				System.out.println("Invalid Admin!");
			}
		}
	}
	
	private static void ManageVendor(String AdminName) {
		int i = 1;
		Helper.line(60, "-");
		System.out.format("%-4s|%-15s|%-15s|%-15s|\n","No.","Name","Email","Address");
		for(Admin A: AdminList) {
			if(AdminName.equals(A.getUser())){
				for(int v = 0; v<VendorList.size(); v++) {
					Vendor V = VendorList.get(v);
					System.out.format("%-4d|%-15s|%-15s|%-15s|\n",i+1,V.getName(),V.getEmail(),V.getAddress());
					Helper.line(60, "-");
				}
			}else {
				System.out.println("Invalid Admin!");
			}
		}
	}
	
	private static void Report() {
		
	}
//Admin End
	
//Vendor Start
	private static void AddItems(String VendorName) {
		String name = Helper.readString("Enter name of dish: ");
		String description = Helper.readString("Enter description of dish: ");
		double price = Helper.readDouble("Set price of dish: ");
		int qty = Helper.readInt("Enter quantity set for dish: ");
		for(Vendor V : VendorList) {
			if(V.getName().equals(VendorName)) {
				for(Meals M: V.getMenu()) {
					if(name.equalsIgnoreCase(M.getName())) {
						V.getMenu().add(new Meals(name, description, price, qty));
					}else {
						System.out.println("Item exist!");
					}
				}
			}else{
				System.out.println("Vendor does not exist!");
			}
		}
	}
	
	private static void DelItems(String VendorName) {
		String name = Helper.readString("Enter name of dish: ");
		for(Vendor V: VendorList) {
			if(V.getName().equals(VendorName)) {
				for(int M = 0; M < V.getMenu().size(); M++) {
					Meals m = V.getMenu().get(M);
					if(m.getName().equalsIgnoreCase(name)) {
						V.getMenu().remove(m);
						System.out.println("Item Removed!");
					}else{
						System.out.println("Item does not exist!");
					}
				}
			}else{
				System.out.println("Vendor does not exist!");
			}
		}
	}
	
	private static void EditItems(String VendorName) {
		String pattern = "(?i)(name|description|price|quantity|qty)";
		String edit = Helper.readStringRegEx("Which option you want to edit?[e.g Description]:", pattern);
		String nameItem = Helper.readString("Enter name of item: ");
		for(Vendor V: VendorList) {
			if(V.getName().equals(VendorName)) {
				for(Meals M: V.getMenu()) {
					if(nameItem.equalsIgnoreCase(M.getName())) {
						if(edit.equalsIgnoreCase("name")) {
							String NameChange = Helper.readString("Enter new name: ");
							M.setName(NameChange);
						}else if(edit.equalsIgnoreCase("description")) {
							String DescChage = Helper.readString("Update description: ");
							M.setDescription(DescChage);
						}else if(edit.equalsIgnoreCase("price")) {
							double newPrice = Helper.readDouble("Update price: ");
							M.setPrice(newPrice);
						}else if(edit.equalsIgnoreCase("quantity") || edit.equalsIgnoreCase("qty")) {
							int newQty = Helper.readInt("Update quantity: ");
							M.setQty(newQty);
						}
					}
				}
			}else{
				System.out.println("Vendor does not exist!");
			}
		}
	}
	
	private static void ViewFB(String VendorName) {
		for(Vendor V: VendorList) {
			if(V.getName().equals(VendorName)) {
				int MinIndex = 0;
				int x = 1;
				int MaxIndex = Math.min(5, V.getReviews().size());
				Page_Loop:while(true) {
					for(int i = MinIndex; i<MaxIndex; i++) {
						Review R = V.getReviews().get(i);
						System.out.printf("%d. Food Rating: %d\nExperience Rating: %d\nDescription:\n%s",
								x+1 ,R.getRateFood(),R.getRateExperience(),R.getImprovements());
					}
					
					if(MaxIndex >= V.getReviews().size()) {
						System.out.println("Null");
						break Page_Loop;
					}
					
					boolean input = Helper.readBoolean("Show 5 more? (y/n): ");
					 if(input==true) {
						 MinIndex = MaxIndex;
						 MaxIndex = Math.min((MinIndex+5), V.getReviews().size());
					 }else {
						 System.out.println("END");
						 break Page_Loop;
					 }
				}
			}else {
				System.out.println("Vendor does not exist!");
			}
		}
	}
	
	private static void	EditInfo(String VendorName) {
		String Pattern = "(?i)(email|address)";
		String Choice = Helper.readStringRegEx("Which option you want to edit?[e.g Address]", Pattern);
		for(Vendor V: VendorList) {
			if(V.getName().equals(VendorName)) {
				if(Choice.equalsIgnoreCase("Email")) {
					String EmailPattern = "[a-zA-Z0-9]+@[a-zA-Z0-9.-]+\\\\.(com|sg|co|org)";
					String NewEmail = Helper.readStringRegEx("Update Email", EmailPattern);
					V.setEmail(NewEmail);
				}else if(Choice.equalsIgnoreCase("Address")) {
					String NewAddress = Helper.readString("Update Address: ");
					V.setAddress(NewAddress);
				}
			}else{
				System.out.println("Vendor does not exist!");
			}
		}
	}
	
	private static void ViewMenu(String VendorName) {
		for(Vendor V: VendorList) {
			if(VendorName.equals(V.getName())) {
				for(Meals M: V.getMenu()) {
					System.out.printf("Name: %s\nDescription: %s\nPrice: %f.2\nQuantity: %d\n", M.getName(),M.getDescription(),
							M.getPrice(),M.getQty());
				}
			}
		}
	}
//Vendor End
}
