/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 22013393, 1 Aug 2023 5:52:56 pm
 */
import java.util.ArrayList;

public class Vendor{
	private String name;
	private String email;
	private String address;
	private String pass;
	private ArrayList<Meals> Menu;
	private ArrayList<Review> reviews;
	
	public Vendor(String name, String pass, String email, String address, ArrayList<Meals> Menu) {
		this.name = name;
		this.pass = pass;
		this.email = email;
		this.address = address;
		this.Menu = new ArrayList<Meals>();
		this.reviews = new ArrayList<Review>();
	}


	public ArrayList<Meals> getMenu() {
		return Menu;
	}

	public ArrayList<Review> getReviews() {
		return reviews;
	}
	
	public void addReview(Review review) {
		reviews.add(review);
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
		boolean authenticate = false;
	    if(this.name.equals(name) && this.pass.equals(pass)) {
	    	authenticate = true;
	    	return authenticate;
	    }else {
	    	authenticate = false;
	    	return authenticate;
	    }
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
