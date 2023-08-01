package ordering_sys;

import java.util.ArrayList;

public class Parents{
	private String username;
	private String password;
	private boolean tracking;
	private String feedback;
	private ArrayList<Ordering> orderList = new ArrayList<Ordering>();
	
	public Parents(String username, String password, boolean tracking, String feedback, ArrayList<Ordering> orderList) {
			this.username =username;
			this.password = password;
			this.tracking = false;
			this.feedback = "";
			this.orderList = orderList;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean authentication(String name, String password) {
	    return this.username.equals(name) && this.password.equals(password);
	}

	public void setOrderList(ArrayList<Ordering> orderList) {
		this.orderList = orderList;
	}

	public String getName() {
		return username;
	}

	public void setName(String name) {
		this.username = name;
	}

	public boolean isTracking() {
		return tracking;
	}

	public void setTracking(boolean tracking) {
		this.tracking = tracking;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public ArrayList<Ordering> getOrderList() {
		return orderList;
	}

}
