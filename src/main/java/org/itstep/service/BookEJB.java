package org.itstep.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.constraints.NotNull;

import org.itstep.model.Book;

@Stateless
@LocalBean
public class BookEJB implements BookEJBRemote {

	@PersistenceContext(unitName = "book_db")
	private EntityManager em;
	
	public List<Book> findBooks(){
		Query query = em.createNativeQuery("find_all_book", Book.class);
		return query.getResultList();
	}
	
	public @NotNull Book createBook(@NotNull Book book) {
		em.persist(book);
		return book;
	}
	
	public void deleteBook(@NotNull Book book) {
		em.remove(em.merge(book));
	}
	
	public Book updateBook(Book book) {
		return em.merge(book);
	}
}
