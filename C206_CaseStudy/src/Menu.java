/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 22033872, 1 Aug 2023 5:52:56 pm
 */
public class Menu {
	private String name;
	private String description;
	private double price;
	private int qty;
	private String Type;
	private String vendorName;

	public Menu(String name, String description, double price, int qty,  String Type, String vendorName) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.qty = qty;
		this.Type = Type;
		this.vendorName = vendorName;
	}
	

	public String getVendorName() {
		return vendorName;
	}


	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}


	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
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

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}


}
