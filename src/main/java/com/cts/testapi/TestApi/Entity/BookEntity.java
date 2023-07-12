package com.cts.testapi.TestApi.Entity;


import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class BookEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column 
	private String name;
	@Column 
	private Integer yearOfPublication;
	
	
	public BookEntity() {
	}
	public BookEntity(int id, String name, int yearOfPublication) {
		super();
		this.id = id;
		this.name = name;
		this.yearOfPublication = yearOfPublication;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYearOfPublication() {
		return yearOfPublication;
	}
	public void setYearOfPublication(int yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}
	@Override
	public String toString() {
		return "BookEntity [id=" + id + ", name=" + name + ", yearOfPublication=" + yearOfPublication + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, name, yearOfPublication);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookEntity other = (BookEntity) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(yearOfPublication, other.yearOfPublication);
	}
	
	
	
	
}
