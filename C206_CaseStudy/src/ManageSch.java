import java.util.ArrayList;

public class ManageSch {

	private ArrayList<School> schoolList = new ArrayList<School>();
    
    public static void main(String[] args) {

    	ManageSch manager = new ManageSch();

        int option = 0;

        while (option != 4) {
            Helper.line(30, "-");
            System.out.println("OPTIONS");
            Helper.line(30, "-");
            System.out.println("1. Add School");
            System.out.println("2. View School");
            System.out.println("3. Delete School");
            
            option = Helper.readInt("\nEnter an option > ");

            if (option == 1) {
                manager.addSchool(Helper.readString("Please enter the school name: "), Helper.readString("Please enter the school address: "));

            } else if (option == 2) {
                manager.viewAllSchools();

            } else if (option == 3) {
                manager.deleteSchool(Helper.readString("Please enter the school name to delete: "));

            } else {
                System.out.println("\n*** Invalid option selected ***\n");
            }
        }
    }
    
    //add a new school
    public void addSchool(String name, String address) {
        schoolList.add(new School(name, address));
        System.out.println("School has been added");
    }

    //view all schools
    public void viewAllSchools() {
        String sentence = String.format("%-15s %-20s\n", "School Name", "Address");
       

        for (int i = 0; i < schoolList.size(); i++) {
            if (schoolList.get(i) != null) {
                String schoolName = schoolList.get(i).getName();
                String schoolAddress = schoolList.get(i).getAddress();
                
                sentence += String.format("%-15s %-20s\n", schoolName, schoolAddress);
            }
        }
        System.out.println(sentence);
    }

    //delete an existing school
    public void deleteSchool(String name) {
        boolean schoolfound = false;
        for (int i = 0; i < schoolList.size(); i++) {
            if (schoolList.get(i) != null && schoolList.get(i).getName().equalsIgnoreCase(name)) {
                schoolList.remove(i);
                schoolfound = true;
                System.out.println("School has been deleted");
            }
        }
        if (!schoolfound) {
            System.out.println("School not found");
        }
    }
}
    
//    public void editSchoolForChild(String parentName, String childName) {
//        if (!this.parentAuthentication(parentName)) {
//            return;
//        }
//
//        Child child = this.findChildByName(childName);
//        if (child == null) {
//            System.out.println("Child not found");
//            return;
//        }
//
//        System.out.println("Please enter the new school name: ");
//        String newSchoolName = Helper.readString();
//
//        child.setSchName(newSchoolName);
//
//        System.out.println("School has been updated");
//    }
//
//}