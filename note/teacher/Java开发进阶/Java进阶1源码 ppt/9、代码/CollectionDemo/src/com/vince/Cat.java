package com.vince;

public class Cat {
	private String name;
	private int age;
	private int id;
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	@Override
	public String toString() {
		return "Cat [name=" + name + ", age=" + age + ", id=" + id + "]";
	}
	public Cat(String name, int age, int id) {
		super();
		this.name = name;
		this.age = age;
		this.id = id;
	}
	public Cat() { super(); }
	@Override
	public int hashCode() {
		final int prime = 31; // 系数  31*1+5  * 31+1   11111
		int result = 1;
		result = prime * result + age;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Cat other = (Cat) obj;
		if (age != other.age) return false;
		if (id != other.id) return false;
		if (name == null) {
			if (other.name != null) return false;
		} else if (!name.equals(other.name)) return false;
		return true;
	}
}
