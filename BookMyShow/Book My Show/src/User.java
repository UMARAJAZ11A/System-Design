
public abstract class User {

	private int id ;
	private String name ;
	private String password ;
	private String type ;
	public String getName() {
		return name;
	}
	public User(int id, String name, String password,String type) {
		
		this.id = id;
		this.name = name;
		this.type = type ;
		this.password = password ;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public void display() {
		System.out.println("Name : " + name);
		System.out.println("Type : " + name);
		
	}

}
