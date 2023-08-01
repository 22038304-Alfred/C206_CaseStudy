package ordering_sys;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Random;

import c209_L08.Helper;

public class Main {
	private static final int Max_option = 5;
	private static final int Max_option_Vendor = 6;
	private static ArrayList<Vendor> VendorList = new ArrayList<Vendor>();
	private static ArrayList<Menu> MenuList = new ArrayList<Menu>();
	private static Menu [] WeeklyMenuList = new Menu[5];
	private static ArrayList<Parents> ParentAccounts = new ArrayList<Parents>();
	private static int option = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		System.out.println("5. End");
		
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
	private static void DailyMenu(String dayofweek, ArrayList<Vendor> VendorList, Menu[] WeeklyMenu) {
		
	}
	
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
		int MaxIndex = 0;
		int rangeIndex = Math.min(5, VendorList.get(i).getReviews().size());
		for(Vendor V: VendorList) {
			if(V.getName().equals(VendorName)) {
				for(Review R: V.getReviews()) {
					System.out.printf("Food Rating: %d\nExperience Rating: %d\nDescription:\n%s",
							R.getRateFood(),R.getRateExperience(),R.getImprovements());
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
