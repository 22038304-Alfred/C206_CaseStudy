import java.util.ArrayList;

public class VendorMain {
	private static ArrayList<Vendor> vendorList = new ArrayList<Vendor>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		vendorList.add(new Vendor("Vendor1", "company1@email.co", 87651234, "120 Bishan St 23"));
		vendorList.add(new Vendor("Vendor2", "company2@email.com", 95693537, "52 Serangoon Rd"));

		int options = -1;
		while(options != 4) {
			Menu();
			options = Helper.readInt("No. : ");
			if(options == 1) {
				String name = Helper.readString("Enter Name of Vendor: ");
				String email = Helper.readStringRegEx("Enter Email address: ", "[a-zA-Z0-9]+@[a-zA-Z0-9]+.(com|org)");
				int contactNo = Integer.parseInt(Helper.readStringRegEx("Enter Contact No.", "[89][0-9]{7}"));
				String address = Helper.readString("Enter Address: ");
				Vendor vendor = new Vendor(name, email, contactNo, address);
				addVendor(vendor);
			}else if(options == 2) {
				delVendor();
			}else if(options == 3) {
				viewAllVendor();
			}else if(options == 4) {
				System.out.println("End");
				break;
			}else {
				System.out.println("Invalid");
			}
		}
	}
	
	private static void Menu() {
		Helper.line(60, "=");
		System.out.println("WELCOME TO SCHOOL LUNCHBOX ONLINE (ADMIN PAGE)");
		Helper.line(60, "=");
		System.out.println("1. Add Vendor");
		System.out.println("2. Delete Vendor");
		System.out.println("3. View All Vendors");
		System.out.println("4. End");
	}
	
	public static void addVendor(ArrayList<Vendor> vendorList, Vendor vendor) {
		vendorList.add(vendor);
		System.out.println("Vendor Added!");

	}

	public static void delVendor(ArrayList<Vendor> vendorList) {
		String name = Helper.readString("Enter Name of Vendor: ");
		String email = Helper.readStringRegEx("Enter Email address: ", "[a-zA-Z0-9]+@[a-zA-Z0-9]+.(com|org)");
		int contactNo = Integer.parseInt(Helper.readStringRegEx("Enter Contact No.", "[89][0-9]{7}"));
		String address = Helper.readString("Enter Address: ");
		for (int i = 0; i < vendorList.size(); i++) {
			Vendor V = vendorList.get(i);
			if (V.getName().equalsIgnoreCase(name) && V.getEmail().equalsIgnoreCase(email) && V.getContactNo() == contactNo
					&& V.getAddress().equals(address)) {
				vendorList.remove(i);
				System.out.println("Vendor Removed!");
			} else {
				System.out.println("Information incorrect!");
			}
		}
	}

	public static String viewAllVendor(ArrayList<Vendor> vendorList) {
		String format = "%-7s| %-20s | %-20s | %-15s | %-50s\n";
		String format1 = "No. %-3d| %-20s | %-20s | %-15d | %-50s\n";
		Helper.line(100, "-");
		String output = String.format("No.", "Vendor Name", "Vendor Email", "Contact No.", "Address");
		Helper.line(100, "-");
		for (int i = 0; i < vendorList.size(); i++) {
			Vendor V = vendorList.get(i);
			output += String.format(format1, i+1, V.getName(), V.getEmail(), V.getContactNo(), V.getAddress());
		}
		return output;
	}
}
