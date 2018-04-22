package com.cmc.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A Customer.
 */
@Entity
@Table(name = "[Customer]")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotNull
	@Size(min = 3)
	@Column(name = "name", nullable = false)
	private String name;

	@NotNull
	@Size(min = 3)
	@Column(name = "email", nullable = false)
	private String email;

	@NotNull
	@Size(min = 3)
	@Column(name = "phone", nullable = false)
	private String phone;

	@NotNull
	@Size(min = 3)
	@Column(name = "address", nullable = false)
	private String address;

	public Customer() {
		super();
	}

	public Customer(String name, String email, String phone, String address) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer{" + "id=" + getId() + ", name='" + getName() + "'" + ", email='" + getEmail() + "'"
				+ ", phone='" + getPhone() + "'" + "}";
	}

}
