public class Meals {
	private String name;
	private String description;
	private double price;
	private int qty;
	
	/*
	 Establish the menu items in it:
	 its name, description and prices
	  */
	public Meals(String name, String description, double price, int qty) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.qty = qty;
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
