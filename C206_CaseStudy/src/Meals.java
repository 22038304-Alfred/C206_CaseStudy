import java.util.ArrayList;

public class Meals {
	private String name;
	private String description;
	private double price;
	private int qty;
	private ArrayList<String> MealTags;
	
	/*
	 Establish the menu items in it:
	 its name, description and prices
	  */
	public Meals(String name, String description, double price, int qty) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.qty = qty;
		this.MealTags = null;
	}

	public Meals(String name, String description, double price, int qty, ArrayList<String> MealTags) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.qty = qty;
		this.MealTags = new ArrayList<String>();
	}
	
	public ArrayList<String> getMealTags() {
		return MealTags;
	}

	public void addMealTags(String restrictions) {
		for(int i=0; i<MealTags.size(); i++)
			if(!MealTags.get(i).contains(restrictions)) {
				MealTags.add(restrictions);
			}
	}
	
	public void removeMealTags(String restrictions) {
		MealTags.remove(restrictions);
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}
	

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


}
