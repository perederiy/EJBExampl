package org.itstep.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import org.itstep.model.Book;


@Singleton
@Startup
@DataSourceDefinition(
		className= "org.postgresql.Driver",
		name = "java:global/jdbc/book_dbs",
		url = "jdbc:postgresql://localhost:5432/book_db",
		user = "postgres",
		password = "qwerty27011983",
		databaseName = "book_db"
		
		)
public class DatabasePopulator {

	@Inject
	private BookEJB bookEJB;
	private Book h2g2;
	private Book lord;
	
	@PostConstruct
	private void populateDB() {
		h2g2 = new Book("Learn Java EE", 35, "Big Book", "12-34-56", true);
		lord = new Book("Lord rings", 78, "Middle Book", "90-87-56", true);
		bookEJB.createBook(h2g2);
		bookEJB.createBook(lord);
	}
	
	@PreDestroy
	private void clearDB() {
		bookEJB.deleteBook(h2g2);
		bookEJB.deleteBook(lord);
	}
	
}
