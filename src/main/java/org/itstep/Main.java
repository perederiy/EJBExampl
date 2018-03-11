package org.itstep;

import java.util.List;
import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.itstep.model.Book;
import org.itstep.service.BookEJBRemote;

public class Main {
	
	public static void main(String[] args) {
		
		try {
			//Properties property = new Properties();
			//property.setProperty(EJBContainer.PROVIDER, "org.itstep.service.BookEJBRemote");
			//EJBContainer ec = EJBContainer.createEJBContainer(property);
			Context ctx = new InitialContext();
			BookEJBRemote bookEJB = (BookEJBRemote)ctx.lookup("java:global/BookEJB!org.itstep.service.BookEJBRemote");
			List<Book> books = bookEJB.findBooks();
			for (Book book : books) {
				System.out.println(book);
			}
			Book book = new Book("H2G2", 12, "Fantastica", "34-67-43", true);
			book = bookEJB.createBook(book);
			System.out.println("Create book " + book.getTitle());
			book.setTitle("H2G3");
			book = bookEJB.updateBook(book);
			System.out.println("Create book " + book.getTitle());
			bookEJB.deleteBook(book);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}
