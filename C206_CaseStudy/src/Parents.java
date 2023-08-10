import java.util.ArrayList;
public class Parents{
	private String name;
	private String password;
	private ArrayList<Ordering> orderHistory = new ArrayList<Ordering>();
	private ArrayList<Child> Children = new ArrayList<Child>();
	private ArrayList<PaymentGateway> CC = new ArrayList<PaymentGateway>();

	public Parents(String name, String password) {
			this.name = name;
			this.password = password;
			this.orderHistory = new ArrayList<Ordering>();
			this.Children = new ArrayList<Child>();
			this.CC = null;
	}

	public Parents(String name, String password, ArrayList<Child> Children) {
		this.name = name;
		this.password = password;
		this.orderHistory = new ArrayList<Ordering>();
		this.Children = new ArrayList<>(Children);
		this.CC = null;
	}
	
	public ArrayList<PaymentGateway> getCC() {
		return CC;
	}
	
	public ArrayList<Child> getChildren() {
		return Children;
	}


	public void setChildren(ArrayList<Child> children) {
		Children = children;
	}

	public void addChildren(Child child) {
		Children.add(child);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean authentication(String name, String password) {
		boolean authenticate = false;
	    if(this.name.equals(name) && this.password.equals(password)) {
	    	authenticate = true;
	    	return authenticate;
	    }else {
	    	authenticate = false;
	    	return authenticate;
	    }
	}

	public void setOrderHistory(ArrayList<Ordering> orderHistory) {
		this.orderHistory = orderHistory;
	}
	
	public void addOrder(Ordering order) {
		orderHistory.add(order);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public ArrayList<Ordering> getOrderHistory() {
		return orderHistory;
	}

}
