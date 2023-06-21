import java.time.LocalDateTime;

public class Order {
	private int orderId;
	private int customerId;
	private LocalDateTime orderDate;
	private double totalPrice;
	private String status;
	
	public Order(int orderId, int customerId, LocalDateTime i, double totalPrice, String status) {
		this.orderId = orderId;
		this.customerId = customerId;
		this.orderDate = i;
		this.totalPrice = totalPrice;
		this.status = status;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public int getOrderId() {
		return orderId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
	
	public String toString() {
		return "Order: orderId= "+orderId+", customerId= "+customerId+", orderDate= "+orderDate+", totalPrice= "+totalPrice+", status= "+status+" ]";
	}
	
}
