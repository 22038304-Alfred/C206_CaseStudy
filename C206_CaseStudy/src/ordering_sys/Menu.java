package ordering_sys;

import java.util.ArrayList;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class Menu {
    private LocalDate date;
    private ArrayList<Meals> foodMenu;
    private String itemName;
    private double itemPrice;
    private DayOfWeek dayOfWeek;
    private String itemDescription;

    public Menu(String itemName, String itemDescription, double itemPrice ) {
            this.itemName = itemName;
            this.itemDescription = itemDescription;
            this.itemPrice = itemPrice;
            //this.dayOfWeek = dayOfWeek;
        }

        public String getItemName() {
            return itemName;
        }

        public double getItemPrice() {
            return itemPrice;
        }

    public Menu(LocalDate date) {
        this.date = date;
        this.foodMenu = new ArrayList<>();
    }

	public LocalDate getDate() {
        return date;
    }

    public ArrayList<Meals> getFoodMenu() {
        return foodMenu;
    }

    public void addMeal(Meals meal) {
        foodMenu.add(meal);
    }
    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }
}

