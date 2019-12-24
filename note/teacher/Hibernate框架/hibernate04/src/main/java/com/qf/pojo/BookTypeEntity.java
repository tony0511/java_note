package com.qf.pojo;

import java.util.Collection;

/**
 * Thanks for Everything.
 */
public class BookTypeEntity {
	private Long typeId;
	private String typeName;
	private String typeDesc;
	private Collection<BookInfoEntity> bookInfosByTypeId;

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeDesc() {
		return typeDesc;
	}

	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		BookTypeEntity that = (BookTypeEntity) o;

		if (typeId != null ? !typeId.equals(that.typeId) : that.typeId != null) return false;
		if (typeName != null ? !typeName.equals(that.typeName) : that.typeName != null) return false;
		if (typeDesc != null ? !typeDesc.equals(that.typeDesc) : that.typeDesc != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = typeId != null ? typeId.hashCode() : 0;
		result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
		result = 31 * result + (typeDesc != null ? typeDesc.hashCode() : 0);
		return result;
	}

	public Collection<BookInfoEntity> getBookInfosByTypeId() {
		return bookInfosByTypeId;
	}

	public void setBookInfosByTypeId(Collection<BookInfoEntity> bookInfosByTypeId) {
		this.bookInfosByTypeId = bookInfosByTypeId;
	}
}
