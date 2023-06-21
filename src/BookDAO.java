import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
	private Connection connection;
	
	public BookDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void addBook(Book book) {
		String query = "INSERT INTO books (book_id,title,author,price) VALUES (?,?,?,?)";
		try(PreparedStatement statement = connection.prepareStatement(query)){
			statement.setInt(1, book.getBookId());
			statement.setString(2, book.getTitle());
			statement.setString(3,book.getAuthor());
			statement.setDouble(4, book.getPrice());
			statement.executeUpdate();
			System.out.println("Book inserted successfully.");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateBook(Book book) {
		String query = "UPDATE books SET title=?, author=?, price=? WHERE book_id=?";
		try(PreparedStatement statement = connection.prepareStatement(query)){
			statement.setString(1, book.getTitle());
			statement.setString(2, book.getAuthor());
			statement.setDouble(3, book.getPrice());
			statement.setInt(4, book.getBookId());
			statement.executeUpdate();
			System.out.println("Book updated successfully");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteBook(int bookId) {
		String query = "DELETE FROM books WHERE book_id=?";
		try(PreparedStatement statement = connection.prepareStatement(query)){
			statement.setInt(1, bookId);
			statement.executeUpdate();
			System.out.println("Book deleted successfully");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Book getBookById(int bookId) {
		String query = "SELECT * FROM books WHERE book_id=?";
		try(PreparedStatement statement = connection.prepareStatement(query)){
			statement.setInt(1, bookId);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				String title = resultSet.getString("title");
				String author = resultSet.getString("author");
				double price = resultSet.getDouble("price");
				return new Book(bookId, title, author, price);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Book> displayBooks(){
		List<Book> book = new ArrayList<>();
		String query = "SELECT * FROM books";
		try(PreparedStatement statement = connection.prepareStatement(query)){
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt("book_id");
				String title = resultSet.getString("title");
				String author = resultSet.getString("author");
				double price = resultSet.getDouble("price");
				book.add(new Book(id,title,author,price));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return book;
	}
}
