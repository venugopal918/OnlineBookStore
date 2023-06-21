import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
	private Connection connection;
	
	public CustomerDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void addCustomer(Customer customer) {
		String query = "INSERT INTO customers(customer_id,name,email,password) VALUES (?,?,?,?)";
		try(PreparedStatement statement = connection.prepareStatement(query)){
			statement.setInt(1, customer.getCustomerId());
			statement.setString(2, customer.getName());
			statement.setString(3, customer.getEmail());
			statement.setString(4, customer.getPassword());
			statement.executeUpdate();
			System.out.println("Customer add successfully");
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Customer addCustomerById(int customer_id) {
		String query = "SELECT * FROM customers WHERE customer_id=?";
		try(PreparedStatement statement = connection.prepareStatement(query)){
			statement.setInt(1, customer_id);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				String password = resultSet.getString("password");
				return new Customer(customer_id,name,email,password);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateCustomer(Customer customer) {
		String query = "UPDATE customers SET name=?, email=?, password=? WHERE customer_id=?";
		try(PreparedStatement statement = connection.prepareStatement(query)){
			statement.setString(1, customer.getName());
			statement.setString(2, customer.getEmail());
			statement.setString(3, customer.getPassword());
			statement.setInt(4, customer.getCustomerId());
			statement.executeUpdate();
			System.out.println("Customer updated successfully");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteCustomer(int customer_id) {
		String query = "DELETE FROM customers WHERE customer_id=?";
		try(PreparedStatement statement = connection.prepareStatement(query)){
			statement.setInt(1, customer_id);
			statement.executeUpdate();
			System.out.println("Customer deleted Successfully");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Customer> displayAllCustomers() {
		List<Customer> customer = new ArrayList<>();
		String query = "SELECT * FROM customers";
		try(PreparedStatement statement = connection.prepareStatement(query)){
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				int customer_id = resultSet.getInt("customer_id");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				String password = resultSet.getString("password");
				customer.add(new Customer(customer_id,name,email,password));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}
}
