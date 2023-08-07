package GA;

public class User {
	
	private String name;
	private String nric4; 
	
	public User(String name, String nric4) {
		this.name = name;
		this.nric4 = nric4;
	}
	
	public String getName() {
		return name;
	}
	public String getNric4() {
		return nric4;
	}
	public void display() {
		System.out.println("Welcome:   " + name);
	}
}
