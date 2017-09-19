package com.spring.discussbox.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category_list")
public class Categories implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cat_id")
	private int id;
	@Column(name="cat_name")
	private String cat_name;
	@Column(name="cat_value")
	private int cat_value;
	
	public Categories() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCat_name() {
		return cat_name;
	}

	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}

	public int getCat_value() {
		return cat_value;
	}

	public void setCat_value(int cat_value) {
		this.cat_value = cat_value;
	}

	@Override
	public String toString() {
		return "Categories [id=" + id + ", cat_name=" + cat_name + ", cat_value=" + cat_value + "]";
	}
	
	
}
