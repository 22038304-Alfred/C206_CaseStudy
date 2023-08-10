import java.time.LocalDate;
import java.util.ArrayList;

public class Ordering{
	private String orderId;
	private String name;
	private String ChildName;
	private ArrayList<String> Restrictions;
	private LocalDate date;
	private ArrayList<Meals> items;
	
	public Ordering(String name, String ChildName, LocalDate date) {
		this.orderId = Helper.toHex((name+ChildName+date+(items).toString()));
		this.name = name;
		this.ChildName = ChildName;
		this.date = date;
		this.items = new ArrayList<>(items);
		this.Restrictions = new ArrayList<String>();
	}

	public String getOrderId() {
		return orderId;
	}

	public ArrayList<String> getRestrictions(){
		return Restrictions;
	}
	
	public void addRestrictions(String RestrictionInput) {
		this.Restrictions.add(RestrictionInput);
	}
	
	public void delRestrictions(String RestrictionInput) {
		this.Restrictions.remove(RestrictionInput);
	}
	
	public String getChildName() {
		return ChildName;
	}

	public void setChildName(String ChildName) {
		this.ChildName = ChildName;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate() {
		return date;
	}

	public ArrayList<Meals> getItems() {
		return items;
	}

    public void addItem(Meals meal, int quantity, ArrayList<Meals> items) {
    	for (Meals eachMeals : items) {
    		if ((meal.getName()).equals(eachMeals.getName())){
    			eachMeals.setQty(quantity);
    		}
    	}
    }
	



}
