package ordering_sys;


public class Admin {
	private String User;
	private String Pass;
	
	public Admin(String User, String Pass) {
		this.User = User;
		this.Pass = Pass;
	}

	public String getUser() {
		return User;
	}

	public void setUser(String user) {
		User = user;
	}

	public String getPass() {
		return Pass;
	}
	public void setPass(String pass) {
		Pass = pass;
	}
}
