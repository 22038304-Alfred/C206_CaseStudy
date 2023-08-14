package ordering_sys;


public class School {
	
	private String name;
    private String address;
    private String postalCode;
    

    public School(String name, String address, String postalCode) {
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        
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
    
    public String getpostalCode() {
    	return postalCode;
    }
    
    public void setpostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    
    public String toString() {
		String output = String.format("%-30s %-30s %-20\n", name, address, postalCode);
		return output;
    }

   
}
