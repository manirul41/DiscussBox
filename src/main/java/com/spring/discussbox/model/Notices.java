package com.spring.discussbox.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="notices_info")
public class Notices {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="notice_id")
	private int id;
	@Column(name="ntitle")
	private String ntitle;
	@Column(name="nbody", columnDefinition="VARCHAR(5000)")
	private String nbody;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumns({
		@JoinColumn(name="email", referencedColumnName="email"),
		@JoinColumn(name="fullname", referencedColumnName="fullname")		
	})
	private Users users;
	
	@Column(name="cat_value")
	private String cat_value;
	
	@Column(name="c_date")
	private Date date;
	
	public Notices() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNtitle() {
		return ntitle;
	}

	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}

	public String getNbody() {
		return nbody;
	}

	public void setNbody(String nbody) {
		this.nbody = nbody;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getCat_value() {
		return cat_value;
	}

	public void setCat_value(String cat_value) {
		this.cat_value = cat_value;
	}

}
