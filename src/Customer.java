
public class Customer {
	private int customerId;
	private String name;
	private String email;
	private String password;
	
	public Customer() {}
	
	public Customer(int customerId, String name, String email, String password) {
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String toString() {
		return "[Customer: id= "+customerId+", name= "+name+", email= "+email+", password= "+password+" ]";
	}
}
