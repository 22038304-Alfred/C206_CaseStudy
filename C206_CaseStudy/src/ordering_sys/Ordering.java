package ordering_sys;

import java.time.LocalDate;
import java.util.ArrayList;

public class Ordering{
	private String name;
	private String vendorName;
	private LocalDate date;
	private ArrayList<Meals> items;
	
	public Ordering(String name, String vendorName, LocalDate date) {
		this.name = name;
		this.vendorName = vendorName;
		this.date = date;
		this.items = new ArrayList<Meals>();
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

    public void addItem(Meals meal, int quantity, ArrayList<Meals> items) {
    	for (Meals eachMeals : items) {
    		String nameFood = eachMeals.getName();
			if (meal.equals(nameFood)){
    			eachMeals.setQty(quantity);
    		}
    	}
    }
	



}
