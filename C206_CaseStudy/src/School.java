import java.util.ArrayList;

public class School {
	
	private String name;
    private String address;
    

    public School(String name, String address) {
        this.name = name;
        this.address = address;
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    private ArrayList<School> schoolList = new ArrayList<School>();
   
    

   
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
