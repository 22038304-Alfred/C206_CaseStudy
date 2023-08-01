package ordering_sys;

import java.util.ArrayList;

public class Vendor{
	private String name;
	private String email;
	private String school;
	private String pass;
	private ArrayList<Meals> Menu;
	private ArrayList<Review> reviews;
	
	public Vendor(String name, String email, String school) {
		this.name = name;
		this.email = email;
		this.school = school;
		this.pass = "Pass123";
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

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
}
