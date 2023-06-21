import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
	private Connection connection;
	
	public OrderDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void addOrder(Order order) {
		String query = "INSERT INTO orders(order_id, customer_id, order_date, total_price, status) VALUES (?,?,?,?,?)";
		try(PreparedStatement statement = connection.prepareStatement(query)){
			statement.setInt(1, order.getOrderId());
			statement.setInt(2, order.getCustomerId());
			statement.setObject(3, order.getOrderDate());
			statement.setDouble(4, order.getTotalPrice());
			statement.setString(5, order.getStatus());
			statement.executeUpdate();
			System.out.println("Order created successfully");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Order getOrderById(int order_id) {
		String query = "SELECT * FROM orders WHERE order_id=?";
		try(PreparedStatement statement = connection.prepareStatement(query)){
			statement.setInt(1, order_id);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				int customer_id = resultSet.getInt("customer_id");
				LocalDateTime order_date = (LocalDateTime) resultSet.getObject("order_date");
				double total_price = resultSet.getDouble("total_price");
				String status = resultSet.getString("status");
				return new Order(order_id, customer_id, order_date, total_price, status);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateOrder(Order order) {
		String query = "UPDATE orders SET customer_id=?, order_date=?, total_price=?, status=? WHERE order_id=?";
		try(PreparedStatement statement = connection.prepareStatement(query)){
			statement.setInt(1, order.getCustomerId());
			statement.setObject(2, order.getOrderDate());
			statement.setDouble(3, order.getTotalPrice());
			statement.setString(4, order.getStatus());
			statement.setInt(5, order.getOrderId());
			statement.executeUpdate();
			System.out.println("Order updated successfully");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteOrder(int order_id) {
		String query = "DELETE FROM orders WHERE order_id=?";
		try(PreparedStatement statement = connection.prepareStatement(query)){
			statement.setInt(1, order_id);
			statement.executeUpdate();
			System.out.println("Order deleted Successfully");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Order> displayAllOrders(){
		List<Order> order = new ArrayList<>();
		String query = "SELECT * FROM orders";	
		try(PreparedStatement statement = connection.prepareStatement(query)){
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				int order_id = resultSet.getInt("order_id");
				int customer_id = resultSet.getInt("customer_id");
				LocalDateTime order_date = (LocalDateTime) resultSet.getObject("order_date");
				double total_price = resultSet.getDouble("total_price");
				String status = resultSet.getString("status");
				order.add(new Order(order_id, customer_id, order_date, total_price, status));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return order;
	}
}
