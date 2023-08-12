/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 22013393, 1 Aug 2023 5:52:56 pm
 */
import java.util.ArrayList;
import java.time.LocalDate;


public class Menu {
	private LocalDate date;
	private ArrayList<Meals> FoodMenu;
	private Menu menuList;

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
