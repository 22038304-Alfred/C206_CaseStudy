import java.util.ArrayList;
public class Parents{
	private String name;
	private String password;
	private boolean tracking;
	private String feedback;
	private ArrayList<Ordering> orderList = new ArrayList<Ordering>();
	private String SchName;
	
	public Parents(String name, String password, String SchName) {
			this.name = name;
			this.password = password;
			this.tracking = false;
			this.feedback = "";
			this.orderList = new ArrayList<Ordering>();
			this.SchName = SchName;
	}

	public String getPassword() {
		return password;
	}

	public String getSchName() {
		return SchName;
	}

	public void setSchName(String schName) {
		SchName = schName;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean authentication(String name, String password) {
	    return this.name.equals(name) && this.password.equals(password);
	}

	public void setOrderList(ArrayList<Ordering> orderList) {
		this.orderList = orderList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
