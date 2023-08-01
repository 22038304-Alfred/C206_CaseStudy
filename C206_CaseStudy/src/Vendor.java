import java.util.ArrayList;

public class Vendor{
	private String name;
	private String email;
	private String address;
	private String pass;
	private ArrayList<Meals> Menu;
	private ArrayList<Review> reviews;
	
	public Vendor(String name, String pass, String email, String address) {
		this.name = name;
		this.email = email;
		this.address = address;
		this.pass = pass;
		this.Menu = new ArrayList<Meals>();
		this.reviews = new ArrayList<Review>();
	}


	public ArrayList<Meals> getMenu() {
		return Menu;
	}

	public ArrayList<Review> getReviews() {
		return reviews;
	}

	public void publishReviews(ArrayList<Review> reviews) {
		this.reviews = reviews;
	}
	
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public boolean authentication(String name, String pass) {
	    return this.name.equals(name) && this.pass.equals(pass);
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
