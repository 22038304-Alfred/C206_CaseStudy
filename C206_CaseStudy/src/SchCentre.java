import java.util.ArrayList;

public class SchCentre {

	private static final int OPTION_DELETE = 3;
	private static final int OPTION_ADD = 2;
	private static final int OPTION_VIEW = 1;
	private static final int OPTION_QUIT = 4;


	public static void main(String[] args) {

		ArrayList<School> schoolList = new ArrayList<School>();
		

		schoolList.add(new School("Republic Polytechnic", "9 Woodlands Ave 9", "Singapore 738964"));
		schoolList.add(new School("Temasek Polytechnic", "21 Tampines Ave 1", "Singapore 529757"));
		schoolList.add(new School("Nanyang Polytechnic", "180 Ang Mo Kio Ave 8", "Singapore 569830"));
		
		
		int option = 0;

		while (option != OPTION_QUIT) {

			SchCentre.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == OPTION_VIEW) {
				SchCentre.viewAllSchool(schoolList);
				

			} else if (option == OPTION_ADD) {

				School sch = inputSchool();
				SchCentre.addSchool(schoolList, sch);
				System.out.println("School added");
					
			} else if (option == OPTION_DELETE) {
				SchCentre.deleteSchool(Helper.readString("Please enter the school name to delete: "), schoolList);

			} else if (option == OPTION_QUIT) {
					System.out.println("Bye!");
			} else {
				System.out.println("Invalid input");
			}
			
		}
}
				
				
			
		public static String retrieveAllSchool(ArrayList<School> schoolList) {
			String output = "";

			for (School school : schoolList) {
		        output += String.format("%-30s %-30s %-20s\n",
		            school.getName(),
		            school.getAddress(),
		            school.getpostalCode());
		    }
		    return output;
		}
		
				
		public static void viewAllSchool(ArrayList<School> schoolList) {
					System.out.println("\nSCHOOL LIST:\n");
					String output = String.format("%-30s %-30s %-20s\n", "NAME", "ADDRESS", "POSTAL CODE");
					 output += retrieveAllSchool(schoolList);	
					System.out.println(output);
				}
		
		
		public static School inputSchool() {
			String name = Helper.readString("Enter school name > ");
			String address = Helper.readString("Enter address > ");
			String postalCode = Helper.readString("Enter postal code > ");

			School sch= new School(name, address, postalCode);
			return sch;
			
		}
		public static void addSchool(ArrayList<School> schoolList, School sch) {
			School s;
			for(int i = 0; i < schoolList.size(); i++) {
				s = schoolList.get(i);
				if (s.getName().equalsIgnoreCase(sch.getName()) )
					return;
			}
			if ((sch.getName().isEmpty()) || (sch.getAddress().isEmpty()) || (sch.getpostalCode().isEmpty())) {
				return;
			}
			
			schoolList.add(sch);
		}
		
			
	    public static void deleteSchool(String name, ArrayList<School> schoolList) {
	        boolean schoolfound = false;
	        for (int i = 0; i < schoolList.size(); i++) {
	        	School school = schoolList.get(i);
	            if (school != null && schoolList.get(i).getName().equalsIgnoreCase(name)) {
	                schoolList.remove(i);
	                schoolfound = true;
	                System.out.println("School has been deleted");
	            }
	        }
	        if (!schoolfound) {
	            System.out.println("School not found");
	        }
	    }
				
				
				public static void menu() {
					Helper.line(80, "-");
					System.out.println("Manage School Information:");
					Helper.line(80, "-");
					System.out.println("1. View All Schools");
					System.out.println("2. Add School");
					System.out.println("3. Delete School");
					System.out.println("4. Quit");
					Helper.line(80, "-");

				}
	
}
