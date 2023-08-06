package ordering_sys;


public class School { 
    private String name;
    private String address;

    public School(String name, String address) {
        this.name = name; 
        this.address = address;
    }

    // Getters and Setters for name and address
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
}
