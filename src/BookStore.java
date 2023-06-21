import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.List;

public class BookStore {
	public static void main(String[] args) {
		Connection connection = DatabaseConnection.getConnection();
		
		BookDAO bookDAO = new BookDAO(connection);
		CustomerDAO customerDAO = new CustomerDAO(connection);
		OrderDAO orderDAO = new OrderDAO(connection);
		OrderItemDAO orderItemDAO = new OrderItemDAO(connection);
		
		//adding book
		Book book1 = new Book(1,"life of pie","venu",120);
		bookDAO.addBook(book1);
		System.out.println("book1 = "+book1);
		
		Book book2 = new Book(2, "RRR", "rajamouli", 1000);
		bookDAO.addBook(book2);
		System.out.println("book2= "+book2);
		
		Book book3 = new Book(1, "one", "sukumar", 500);
		bookDAO.updateBook(book3);
		
		List<Book> book = bookDAO.displayBooks();
		for(Book book4: book) {
			System.out.println(book4);
		}
		
		Customer customer1 = new Customer(1,"venu","venu@gmail.com","1234");
		customerDAO.addCustomer(customer1);
		
		Customer customer2 = new Customer(2,"gopal","gopal@gmail.com","999");
		customerDAO.addCustomer(customer2);
		
		List<Customer> customer = customerDAO.displayAllCustomers();
		for(Customer customer3: customer) {
			System.out.println(customer3);
		}
		
		
		Order order1 = new Order(111, customer1.getCustomerId(), LocalDateTime.now(), 1000, "success");
		orderDAO.addOrder(order1);
		
		List<Order> order = orderDAO.displayAllOrders();
		for(Order order2: order) {
			System.out.println(order2);
		}
		
		OrderItem orderItem1 = new OrderItem(order1.getOrderId(), book1.getBookId(), 1);
		List<OrderItem> orderItem2 = orderItemDAO.displayOrderItem();
		for(OrderItem orderItem: orderItem2) {
			System.out.println(orderItem);
		}
		
		
		
		
		
		
	}

}
