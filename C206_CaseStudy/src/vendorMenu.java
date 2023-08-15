import java.util.ArrayList;

public class vendorMenu {

	private static final int OPTION_ADD = 1;
	private static final int OPTION_DELETE = 2;
	private static final int OPTION_VIEW = 3;
	private static final int OPTION_QUIT = 4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Helper.line(60, "=");
		System.out.println("WELCOME TO SCHOOL LUNCHBOX ONLINE");
		Helper.line(60, "=");
		System.out.println("1. Add Items");
		System.out.println("2. Delete Items");
		System.out.println("3. View All Items");
		System.out.println("4. End");

		ArrayList<Menu> menuList = new ArrayList<Menu>();

		menuList.add(new Menu("Hamburger", "Delicious Beef Burger", 8.99, 5, "Western","Vendor 1"));
		menuList.add(new Menu("Garden fruit Salad", "Crispy Crunchy Fruti Salad", 3.99, 5,"Fruits", "Vendor 2"));
		menuList.add(new Menu("Fruit Juice", "Crisp Fruit Juice", 0.99, 5, "Drinks", "Vendor 3"));

		int option = 0;

		while (option != OPTION_QUIT) {

			vendorMenu.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == OPTION_VIEW) 
			{
				vendorMenu.viewAllMenu(menuList);
			}
			else if (option == OPTION_ADD)
			{
				Menu menu = inputMenu();
				vendorMenu.addMenu(menuList, menu);
				System.out.println("New Menu added!");	
			} 
			else if (option == OPTION_DELETE)
			{
				vendorMenu.deleteMenu(Helper.readString("Please enter the Menu that you want to delete: "), menuList);

			} 
			else if (option == OPTION_QUIT)
			{
				System.out.println("Bye!");
			} 
			else 
			{
				System.out.println("Invalid input");
			}

		}
	}


	public static String retrieveAllMenu(ArrayList<Menu> menuList) {
		String output = "";

		for (Menu menu : menuList) {
			output += String.format("%-30s %-30s %-20s %-20s %-20s %-20s\n",
					menu.getName(),
					menu.getDescription(),
					menu.getPrice(),
					menu.getQty(),
					menu.getType(),
					menu.getVendorName());
		}
		return output;
	}

	private static void viewAllMenu(ArrayList<Menu> menuList)
	{
		System.out.println("\n List of Menu: \n");
		String output = String.format("%-30s %-30s %-20s %-20s %-20s %-20s \n", "NAME", "DESCRIPTION", "PRICE", "QTY", "TYPE", "VENDORNAME");
		output += retrieveAllMenu(menuList);
		System.out.println(output);
	}

	private static Menu inputMenu() 
	{
		// TODO Auto-generated method stub
		String name = Helper.readString("Enter Menu name > ");
		String description = Helper.readString("Enter description > ");
		double price = Helper.readDouble("Enter price > ");
		int qty = Helper.readInt("Enter quantity > ");
		String type = Helper.readString("Enter type > ");
		String vendorName = Helper.readString("Enter name of vendor > ");

		Menu menu = new Menu (name, description, price, qty, type, vendorName);
		return menu;
	}

	public static void addMenu(ArrayList<Menu> menuList, Menu menu) {
		Menu m;
		for(int i = 0; i < menuList.size(); i++) {
			m = menuList.get(i);
			if (m.getName().equalsIgnoreCase(menu.getName()) )
				return;
		}
		if ((menu.getName().isEmpty()) || (menu.getDescription().isEmpty()) || (menu.getPrice()  == 0) || (menu.getQty () == 0) || (menu.getType().isEmpty()) || (menu.getVendorName().isEmpty())) {

			return;
		}

		menuList.add(menu);
	}

	public static void deleteMenu(String name, ArrayList<Menu> menuList) {
		boolean menufound = false;
		for (int i = 0; i < menuList.size(); i++) {
			Menu menu = menuList.get(i);
			if (menu != null && menuList.get(i).getName().equalsIgnoreCase(name)) {
				menuList.remove(i);
				menufound = true;
				System.out.println("Menu has been deleted");
			}
		}
		if (!menufound) {
			System.out.println("menu not found");
		}
	} 


	public static void menu() {
		Helper.line(80, "-");
		System.out.println("Manage Menu: "); 
		Helper.line(80, "-");
		System.out.println("1. Add Menu");
		System.out.println("2. Delete Menu");
		System.out.println("3. View All Menu");
		System.out.println("4. Quit");
		Helper.line(80, "-");

	}

}
