package com.qf.pojo;

import javax.persistence.*;

/**
 * Thanks for Everything.
 */
@Entity
@Table(name = "book_info")
public class BookInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private Long bookId;
	@Column(name = "book_name")
	private String bookName;
	@Column(name = "book_author")
	private String bookAuthor;
	@Column(name = "book_price")
	private Double bookPrice;
	@Column(name = "book_date")
	private Long bookDate;
	@Column(name = "book_publish")
	private String bookPublish;
	@Column(name = "book_desc")
	private String bookDesc;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type_id")
	private BookType bookType;//多对一的关联,一定不要定义单个的type_id字段。

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public Double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(Double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public Long getBookDate() {
		return bookDate;
	}

	public void setBookDate(Long bookDate) {
		this.bookDate = bookDate;
	}

	public String getBookPublish() {
		return bookPublish;
	}

	public void setBookPublish(String bookPublish) {
		this.bookPublish = bookPublish;
	}

	public String getBookDesc() {
		return bookDesc;
	}

	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}

	public BookType getBookType() {
		return bookType;
	}

	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}
}
