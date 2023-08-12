package ordering_sys;

import java.util.ArrayList;

public class Vendor {
    private String name;
    private String address;
    private String pass;  
    private ArrayList<Menu> menuList;
    private ArrayList<Review> reviews;
    private ArrayList<Ordering> orderHistory;

    public Vendor(String name, String password, String address) {
        this.name = name;
        this.pass = password;
        this.address = address;
        this.menuList = new ArrayList<Menu>();
        this.reviews = new ArrayList<Review>();
        this.orderHistory = new ArrayList<Ordering>();
    }

    public ArrayList<Menu> getMenu() {
        return menuList;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void publishReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Ordering[] getOrderHistory() {
        return orderHistory.toArray(new Ordering[0]);
    }

    public void deleteItem(String itemName) {
        Menu itemToRemove = null;
        for (Menu menu : menuList) {
            if (menu.getItemName().equalsIgnoreCase(itemName)) {
                itemToRemove = menu;
                break;
            }
        }

        if (itemToRemove != null) {
            menuList.remove(itemToRemove);
            System.out.println("Item deleted successfully!");
        } else {
            System.out.println("Item not found in the menu.");
        }
    }

    public void addItem(String itemName, String itemDescription, double itemPrice) {
        for (Menu item : menuList) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                System.out.println("Item with the same name already exists in the menu.");
                return;
            }
        }

        Menu newItem = new Menu(itemName, itemDescription, itemPrice);
        menuList.add(newItem);
        System.out.println("Item added successfully!");
    }
}
