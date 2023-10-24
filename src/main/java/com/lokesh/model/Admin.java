package com.lokesh.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adminId_generator")
	@SequenceGenerator(name = "adminId_generator", initialValue = 1000, allocationSize = 1, sequenceName = "admin_id_generator")
	private int adminId;
	@NotBlank(message = "First name should not be empty")
	@Size(min = 4, max = 50, message = "Name should be between 4 to 50 digits")
	private String firstName;
	private String lastName;
	@NotBlank(message = "Age should not be empty")
	@Digits(integer = 10, fraction = 0, message = "{admin.age.invalid}")
	private int age;

	@NotEmpty(message = "gender must be choosen")
	private String gender;

	@Column(unique = true)
	@Size(min = 10, max = 10, message = "Contact number should be exactly 10 digits")
    @NotBlank(message = "contact number required")
	private String contactNumber;

	@NotEmpty(message = "password should not be empty")
//	@Pattern(regexp = "[@#$%^&+=]*", message = "password should contain at least one special character")
	@Size(min = 6, message = "password should be at least 6 character")
	private String password;

	@Email(message = "Enter the valid mail")
	private String email;
	
	private String address;
	
	


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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", gender=" + gender + ", contactNumber=" + contactNumber + ", password=" + password + ", email="
				+ email + ", address=" + address + "]";
	}

}
