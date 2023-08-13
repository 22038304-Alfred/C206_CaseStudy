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
	private int contactNo;
	private String address;
	private ArrayList<Meals> Menu;
	private ArrayList<Review> reviews;
	
	public Vendor(String name, String email, int contactno, String address, ArrayList<Meals> Menu) {
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.address = address;
		this.Menu = new ArrayList<Meals>();
		this.reviews = new ArrayList<Review>();
	}

	public Vendor(String name, String email, int contactno, String address) {
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.address = address;
		this.Menu = new ArrayList<Meals>();
		this.reviews = new ArrayList<Review>();
	}
	
	public int getContactNo() {
		return contactNo;
	}

	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
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
