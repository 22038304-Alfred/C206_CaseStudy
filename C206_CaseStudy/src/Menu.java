import java.util.ArrayList;
import java.time.LocalDate;


public class Menu {
	private LocalDate date;
	private ArrayList<Meals> FoodMenu;
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
		this.FoodMenu.add(FoodMenu);
	}

	
	public void addMeals(LocalDate date, ArrayList<Meals> foodMenu, ArrayList<Menu> dayMenuList) {
		dayMenuList.add(new Menu(date,foodMenu));
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
}
