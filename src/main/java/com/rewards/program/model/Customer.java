/**
 * 
 */
package com.rewards.program.model;

/**
 * @author abhir
 *model class to accomodate details for a customer
 */
public class Customer {
	
	private int id;
	private String name;
	private String phoneNumber;
	private String address;
	private String isPrime;
	
	
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIsPrime() {
		return isPrime;
	}
	public void setIsPrime(String isPrime) {
		this.isPrime = isPrime;
	}
	@Override
	public String toString() {
		return "CustomerAccount [name=" + name + ", phoneNumber=" + phoneNumber + ", address=" + address
				+ ", isPrime=" + isPrime + "]";
	}
	
	
	
	
	
	

}
