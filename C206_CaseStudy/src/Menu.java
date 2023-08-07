import java.util.ArrayList;
import java.time.LocalDate;


public class Menu {
	private LocalDate date;
	private ArrayList<Meals> FoodMenu;
	private Menu menuList;
	/*
	 Each meals will be within an array and will randomise setting the dates to each meals to put out
	  */
	public Menu(LocalDate date, ArrayList<Meals> FoodMenu) {
		this.date = date;
		this.FoodMenu = new ArrayList<Meals>();
	}
	
	public Menu(LocalDate date, Meals FoodMenu) {
		this.date = date;
		this.FoodMenu = new ArrayList<Meals>();
	}

	
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public ArrayList<Meals> getFoodMenu() {
		return FoodMenu;
	}
	
	public void setFoodMenu(ArrayList<Meals> foodMenu) {
		FoodMenu = foodMenu;
	}

	public void add(Menu menu) {
		menuList.add(menu);
		
	}

}
