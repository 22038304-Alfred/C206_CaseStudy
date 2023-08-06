package ordering_sys;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

public class Ordering{
	private String name;
	private String vendorName;
	private int orderID;
	private LocalDate date;
	private Review review;
	private boolean rated;
	private double totalAmount;
	private ArrayList<Meals> items;
    private DayOfWeek orderDate; 
    private Vendor chosenVendor;
    private ArrayList<Meals> selectedItems;
    private String orderStatus;
 
	

    public Ordering(int orderID, DayOfWeek orderDate, Vendor chosenVendor, ArrayList<Meals> selectedItems, double totalAmount, String orderStatus) {
	        this.orderID = orderID;
	        this.orderDate = orderDate;
	        this.chosenVendor = chosenVendor;
	        this.selectedItems = selectedItems;
	        this.totalAmount = totalAmount;
	        this.orderStatus = orderStatus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVendorName() {
		return vendorName;
	}

	public LocalDate getDate() {
		return date;
	}

	public ArrayList<Meals> getItems() {
		return items;
	}
	public int getOrderID() {
		return orderID;
	}

	public void addItem(Meals meal, int quantity) {
	  
	    for (Meals eachMeal : items) {
	        if (eachMeal.getName().equals(meal.getName())) {
	            eachMeal.setQty(quantity);
	            break; 
	        }
	    }
	}


	public void setReview(Review review) {
		this.review = review;
		
	}

	public boolean isRated() {
		return false;
	}
	public void setRated(boolean b) {
		this.rated = b;
		
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public String getStatus() {
	    return orderStatus; 
	}

}