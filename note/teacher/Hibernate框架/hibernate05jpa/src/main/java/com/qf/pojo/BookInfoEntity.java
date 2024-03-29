package com.qf.pojo;

import javax.persistence.*;

/**
 * Thanks for Everything.
 */
@Entity
@Table(name = "book_info")
public class BookInfoEntity {
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
//	@Column(name = "type_id")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="type_id" )
	private BookTypeEntity bookTypeByTypeId;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		BookInfoEntity that = (BookInfoEntity) o;

		if (bookId != null ? !bookId.equals(that.bookId) : that.bookId != null) return false;
		if (bookName != null ? !bookName.equals(that.bookName) : that.bookName != null) return false;
		if (bookAuthor != null ? !bookAuthor.equals(that.bookAuthor) : that.bookAuthor != null) return false;
		if (bookPrice != null ? !bookPrice.equals(that.bookPrice) : that.bookPrice != null) return false;
		if (bookDate != null ? !bookDate.equals(that.bookDate) : that.bookDate != null) return false;
		if (bookPublish != null ? !bookPublish.equals(that.bookPublish) : that.bookPublish != null) return false;
		if (bookDesc != null ? !bookDesc.equals(that.bookDesc) : that.bookDesc != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = bookId != null ? bookId.hashCode() : 0;
		result = 31 * result + (bookName != null ? bookName.hashCode() : 0);
		result = 31 * result + (bookAuthor != null ? bookAuthor.hashCode() : 0);
		result = 31 * result + (bookPrice != null ? bookPrice.hashCode() : 0);
		result = 31 * result + (bookDate != null ? bookDate.hashCode() : 0);
		result = 31 * result + (bookPublish != null ? bookPublish.hashCode() : 0);
		result = 31 * result + (bookDesc != null ? bookDesc.hashCode() : 0);
		return result;
	}

	public BookTypeEntity getBookTypeByTypeId() {
		return bookTypeByTypeId;
	}

	public void setBookTypeByTypeId(BookTypeEntity bookTypeByTypeId) {
		this.bookTypeByTypeId = bookTypeByTypeId;
	}
}
