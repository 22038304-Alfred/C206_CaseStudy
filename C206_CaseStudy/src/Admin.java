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
	
	public boolean authentication(String User, String Pass) {
		boolean authenticate = false;
	    if(this.User.equals(User) && this.Pass.equals(Pass)) {
	    	authenticate = true;
	    	return authenticate;
	    }else {
	    	authenticate = false;
	    	return authenticate;
	    }
	}
}
