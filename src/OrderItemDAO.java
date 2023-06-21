import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderItemDAO {
	private Connection connection;
	
	public OrderItemDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void addOrderItem(OrderItem orderItem) {
		String query = "INSERT INTO order_items(order_id,book_id,quantity) VALUES (?,?,?)";
		try(PreparedStatement statement = connection.prepareStatement(query)){
			statement.setInt(1, orderItem.getOrderId());
			statement.setInt(2, orderItem.getBookId());
			statement.setInt(3, orderItem.getQuantity());
			statement.executeUpdate();
			System.out.println("Orderitem added successfully");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateOrderItem(OrderItem orderItem) {
		String query = "UPDATE order_items SET book_id=?, quanitiy=? WHERE order_id=?";
		try(PreparedStatement statement = connection.prepareStatement(query)){
			statement.setInt(1, orderItem.getBookId());
			statement.setInt(2, orderItem.getQuantity());
			statement.setInt(3, orderItem.getOrderId());
			statement.executeUpdate();
			System.out.println("Orderitem updated successfully");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteOrderItem(int order_id) {
		String query = "SELECT * FROM order_items WHERE order_id=?";
		try(PreparedStatement statement = connection.prepareStatement(query)){
			statement.setInt(1, order_id);
			statement.executeUpdate();
			System.out.println("Orderitem deleted successfully");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<OrderItem> displayOrderItem() {
		List<OrderItem> orderItem = new ArrayList<>();
		String query = "SELECT * FROM order_items";
		try(PreparedStatement statement = connection.prepareStatement(query)){
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				int order_id = resultSet.getInt("order_id");
				int book_id = resultSet.getInt("book_id");
				int quantity = resultSet.getInt("quantity");
				orderItem.add(new OrderItem(order_id,book_id,quantity));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return orderItem;
	}
}
