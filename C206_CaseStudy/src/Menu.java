import java.util.ArrayList;
//import java.time.LocalDate;


public class Menu {
	private String date;
	private ArrayList<Meals> FoodMenu;
	/*
	 Each meals will be within an array and will randomise setting the dates to each meals to put out
	  */
	public Menu(String date, ArrayList<Meals> FoodMenu) {
		this.date = date;
		this.FoodMenu = new ArrayList<Meals>();
	}
	
	public Menu(String date, Meals FoodMenu) {
		this.date = date;
		this.FoodMenu = new ArrayList<Meals>();
		this.FoodMenu.add(FoodMenu);
	}

	
	public void addMeals(String date, ArrayList<Meals> foodMenu, ArrayList<Menu> dayMenuList) {
		dayMenuList.add(new Menu(date,foodMenu));
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public ArrayList<Meals> getFoodMenu() {
		return FoodMenu;
	}
	
	public void setFoodMenu(ArrayList<Meals> foodMenu) {
		FoodMenu = foodMenu;
	}
}
