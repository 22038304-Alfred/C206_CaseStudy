import java.util.ArrayList;

public class Child {
	private String id;
	private String name;
	private String SchName;
	private ArrayList<String> Restrictions;
	
	public Child(String id, String name, String SchName) {
		this.id = id;
		this.name = name;
		this.SchName = SchName;
		this.Restrictions = null;
	}
	
	public Child(String id, String name, String SchName, ArrayList<String> Restrictions) {
		this.id = id;
		this.name = name;
		this.SchName = SchName;
		this.Restrictions = new ArrayList<String>();
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
	
	public ArrayList<String> getRestrictions(){
		return Restrictions;
	}
	
	public void addRestrictions(String RestrictionInput) {
		this.Restrictions.add(RestrictionInput);
	}
	
	public void delRestrictions(String RestrictionInput) {
		this.Restrictions.remove(RestrictionInput);
	}
}
