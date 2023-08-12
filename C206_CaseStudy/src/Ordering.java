/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 22013393, 1 Aug 2023 5:52:56 pm
 */
import java.time.LocalDate;
import java.util.ArrayList;

public class Ordering {
	private String orderId;
	private String name;
	private String ChildName;
	private LocalDate date;
	private ArrayList<Meals> items;
	private boolean trackingOrder;
	private double totalAmount;

	public Ordering(String name, String ChildName, LocalDate date) {
		this.orderId = Helper.toHex((name + ChildName + date + (items).toString()));
		this.name = name;
		this.ChildName = ChildName;
		this.date = date;
		this.items = new ArrayList<>(items);
		this.trackingOrder = true;
		this.totalAmount = 0;
	}

	public Ordering(String name, String ChildName, LocalDate date, double totalAmount) {
		this.orderId = Helper.toHex((name + ChildName + date + (items).toString()));
		this.name = name;
		this.ChildName = ChildName;
		this.date = date;
		this.items = new ArrayList<>(items);
		this.trackingOrder = true;
		this.totalAmount = totalAmount;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTrackOrder(boolean trackingOrder) {
		this.trackingOrder = trackingOrder;
	}

	public boolean getTrackingOrder() {
		return trackingOrder;
	}

	public String getOrderId() {
		return orderId;
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

}
