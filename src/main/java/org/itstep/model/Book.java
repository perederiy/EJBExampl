package org.itstep.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@NamedNativeQuery(name = "find_all_book", query = "SELECT * FROM book")
@Table(name = "book")
public class Book implements Serializable{

	@Id @GeneratedValue
	@Column(name = "id")
	private Long id;
	
	@NotNull
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "price")
	private Integer price;
	
	@Size(max = 2000)
	@Column(name = "discription", length = 2000)
	private String discription;
	
	@Column(name = "isbn")
	private String isbn;
	
	@Column(name = "illustrations")
	private Boolean illustrations;

	public Book() {
	}

	public Book(String title, Integer price, String discription, String isbn, Boolean illustrations) {
		this.title = title;
		this.price = price;
		this.discription = discription;
		this.isbn = isbn;
		this.illustrations = illustrations;
	}
	
}
