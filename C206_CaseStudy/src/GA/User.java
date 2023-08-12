package GA;

public class User {
	
	private String name;
	private String pw; 

	
	public User(String name, String pw) {
		this.name = name;
		this.pw = pw;
	}
	
	public String getName() {
		return name;
	}
	public String getpw() {
		return pw;
	}

	public String toString() {
		String output = String.format("%-10s %-20s \n", name, pw);
		return output;
	
	}
	public boolean isAuthenticate(String inputName, String inputPw) {
	    return name.equals(inputName) && pw.equals(inputPw);
	 }
/*	public boolean isAuthenticate(String Uname, String Upw) {
		if (!name.equals(Uname) || !pw.equals(Upw)) {
			return false;
		}else {
			return true;
		}
	*/	
	
}
