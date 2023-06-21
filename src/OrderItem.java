
public class OrderItem {
	private int orderId;
	private int bookId;
	private int quantity;
	
	public OrderItem(int orderId, int bookId, int quantity) {
		this.orderId = orderId;
		this.bookId = bookId;
		this.quantity = quantity;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public int getOrderId() {
		return orderId;
	}
	
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	public int getBookId() {
		return bookId;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public String toString() {
		return "[OrderItem: orderId= "+orderId+", bookId= "+bookId+", quantity= "+quantity+" ]";
	}
}
