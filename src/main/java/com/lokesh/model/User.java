package com.lokesh.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int userId;
	@Column(nullable = false)
	@NotBlank(message = "First name should not be empty")
	@Size(min = 4, max = 50, message = "Name should be between 4 to 50 digits")
	private String firstName;
	private String lastName;
	@Column(unique = true)
	@Size(min = 10, max = 10, message = "Contact number should be exactly 10 digits")
	@NotBlank(message = "contact number required")
	private String contactNumber;
	@Column(nullable = false, unique = true)
	@NotBlank(message = "Email Id should not be empty")
	@Email(message = "enter the mail")
	private String email;
	@Column(nullable = false)
	@NotEmpty(message = "password should not be empty")
	@Size(min = 6, message = "password should be at least 6 character")
	private String password;
	@NotNull(message = "Date of birth should no be null")
	@Past
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dob;
	
//	private 

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", contactNumber="
				+ contactNumber + ", email=" + email + ", password=" + password + ", dob=" + dob + "]";
	}

}
