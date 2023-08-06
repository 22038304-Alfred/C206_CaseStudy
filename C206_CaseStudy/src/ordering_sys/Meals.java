package ordering_sys;

import java.time.DayOfWeek;

public class Meals {
	private String name;
	private String description;
	private DayOfWeek date; 
	private double price;
	private int qty;
	private Meals[] foodMenu;
    private boolean[] availability;
	public Object getFoodMenu;
	private DayOfWeek dayOfWeek;
	
    
	public Meals(String itemName, String itemDescription, double itemPrice) {
	    availability = new boolean[DayOfWeek.values().length];
	    for (int i = 0; i < availability.length; i++) {
	    availability[i] = true;
	        }
	    }
	public Meals(String name, String description, DayOfWeek date, double price, int qty) {
		this.name = name;
		this.description = description;
		this.date = date;
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
	public DayOfWeek getDate() {
		return date;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	 
	public void setAvailability(DayOfWeek day, boolean isAvailable) {
		availability[day.getValue() - 1] = isAvailable;
	}

	public boolean isAvailableOnDay(DayOfWeek day) {
		return availability[day.getValue() - 1];
	    }
	public Meals[] getFoodMenu() {
		return foodMenu;
	}
	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}
	}
