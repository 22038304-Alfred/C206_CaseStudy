/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 22013393, 1 Aug 2023 5:52:56 pm
 */
public class Menu {
	private String name;
	private String description;
	private double price;
	private String Type;
	private String VendorName;
	
	public Menu(String name, String description, double price, String Type, String VendorName) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.Type = Type;
		this.VendorName = VendorName;
	}
	
	public String getVendorName() {
		return VendorName;
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


}
