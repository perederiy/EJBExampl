package org.itstep.service;

import java.util.List;

import javax.ejb.Remote;

import org.itstep.model.Book;

@Remote
public interface BookEJBRemote {

	List<Book> findBooks();
	Book createBook(Book book);
	void deleteBook(Book book);
	Book updateBook(Book book);
}
