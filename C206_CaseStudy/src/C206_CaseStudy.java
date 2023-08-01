import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Random;

public class C206_CaseStudy {
	private static final int Max_option = 5;
	private static final int Max_option_Vendor = 6;
	private static ArrayList<Vendor> VendorList = new ArrayList<Vendor>();
	private static ArrayList<Menu> MenuList = new ArrayList<Menu>();
	private static ArrayList<Admin> AdminList = new ArrayList<Admin>();
	private static ArrayList<Parents> ParentAccounts = new ArrayList<Parents>();
	private static int option = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ParentAccounts.add(new Parents("Gerald","Pass123"));
		AdminList.add(new Admin("Manager","Pw123"));
		VendorList.add(new Vendor("McDonald","password","MCD@yahoo.org","Bishan St 53,123567"));
		
		loop_start: while (true) {
			String pattern = "(?i)(admin|vendor|user|end)";
			String UserSelect = Helper.readStringRegEx("Enter Login type [Admin, User, Vendor or end]: ", pattern);
			if (UserSelect.equalsIgnoreCase("user")) {
				String username = Helper.readString("Enter Username: ");
				String password = Helper.readString("Enter Password: ");
				for(Parents P: ParentAccounts) {
					if (P.authentication(username,password)) {
						GeneralUI();
					}else {
						System.out.println("Incorrect!");
					}
				}
			}else if(UserSelect.equalsIgnoreCase("vendor")) {
				String username = Helper.readString("Enter Username: ");
				String password = Helper.readString("Enter Password: ");
				for(Vendor V: VendorList) {
					if(V.authentication(username, password)) {
						VendorUI(username);
					}else {
						System.out.println("Incorrect!");
					}
				}
			}else if(UserSelect.equalsIgnoreCase("admin")) {
				String username = Helper.readString("Enter Username: ");
				String password = Helper.readString("Enter Password: ");
				for(Admin A: AdminList) {
					if(A.authentication(username, password)) {
						AdminUI();
					}else {
						System.out.println("Incorrect!");
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
		Helper.line(60, "~");
		System.out.println("Administrator Mode");
		Helper.line(60, "~");
		System.out.println("1. Manage School Information");
		System.out.println("2. Manage Accounts Overview");
		System.out.println("3. Manage Vendors");
		System.out.println("4. Generate Report");
		System.out.println("5. End");
	}
	
	private static void AdminUI() {
		MenuAdmin();
		option = Helper.readInt("Enter choice: ");
		loop2: while(option != Max_option) {
			if(option == 1) {
				ManageSchInfo();
			}else if(option == 2){
				ManageAcc();
			}else if(option == 3) {
				ManageVendor();
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
		System.out.println("6. End");
		
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
			}else if(option == Max_option_Vendor){
				break Loop3;
			}
		}
	}
//Main Start
	
	private static void ViewMenu(String dayofweek, ArrayList<Menu> MenuList) {
		DayOfWeek date = DayOfWeek.valueOf(dayofweek);
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
		
	}
//Main End
	
	
//Vendor Start
	private static void AddItems(String VendorName) {
		String name = Helper.readString("Enter name of dish: ");
		String description = Helper.readString("Enter description of dish: ");
		double price = Helper.readDouble("Set price of dish: ");
		int qty = Helper.readInt("Enter quantity set for dish: ");
		for(Vendor V : VendorList) {
			if(V.getName().equals(VendorName)) {
				V.getMenu().add(new Meals(name, description, price, qty));
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
				int MaxIndex = 0;
				int endIndex = Math.min(5, V.getReviews().size());
				Page_Loop:while(true) {
					for(int i = MaxIndex; i<endIndex; i++) {
						Review R = V.getReviews().get(i);
						System.out.printf("Food Rating: %d\nExperience Rating: %d\nDescription:\n%s",
								R.getRateFood(),R.getRateExperience(),R.getImprovements());
					}
					
					if(endIndex >= V.getReviews().size()) {
						System.out.printf();
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
//Vendor End
}
