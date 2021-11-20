/**
 * 
 */
package com.rewards.program.model;

import java.time.Month;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

/**
 * @author abhir
 *model for accepting transactions for customers for 3 months time
 */

@Entity(name="purchasehistory")
public class RewardsProgramModel {

	
	@NotBlank(message = "customerId must not be blank")
	private long customerId;
	
	private double transactionAmount;
	
	private Date date;
	
	
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@SuppressWarnings("deprecation")
	public int getMonth() {
		return this.date.getMonth();
	}
	
	
	
	
	
	
	
	
	
}
