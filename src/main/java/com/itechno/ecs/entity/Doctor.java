package com.itechno.ecs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Doctor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DoctorId")
	private int doctorid;
	@Column(name="FirstName")
	private String firstname;
	@Column(name="LastName")
	private String lastname;
	@Column(name="UserName")
	private String username;
	@Column(name="Password")
	private String password;
	@Column(name="Specialist")
	private String specialist;
	@Column(name="MobileNo")
	private String mobileno;
	@Column(name="City")
	private String city;
	@Column(name="Pincode")
	private String pincode;
	
	@OneToOne
	@JoinColumn(name = "admin_id")
	private Admin Admin;
	
	
	public int getId() {
		return doctorid;
	}
	public void setId(int id) {
		this.doctorid = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSpecialist() {
		return specialist;
	}
	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	
}
