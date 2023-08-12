/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 22013393, 1 Aug 2023 5:52:56 pm
 */
public class Child {
	private String id;
	private String name;
	private String SchName;
	
	public Child(String id, String name, String SchName) {
		this.id = id;
		this.name = name;
		this.SchName = SchName;
	}
	
	public String getChildName() {
		return name;
	}
	
	public void setChildName(String name) {
		this.name = name;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSchName() {
		return SchName;
	}
	
	public void setSchName(String SchName) {
		this.SchName = SchName;
	}
	
}
