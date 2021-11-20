/**
 * 
 */
package com.rewards.program.model;

import java.util.Map;

/**
 * @author abhir
 *
 */
public class RewardsResponse {
	private long customerId;
	private Map<Integer, Double> rewardsPerMonth;
	private Double totalRewards;
	
	
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	
	public Map<Integer, Double> getRewardsPerMonth() {
		return rewardsPerMonth;
	}
	public void setRewardsPerMonth(Map<Integer, Double> rewardsPerMonth) {
		this.rewardsPerMonth = rewardsPerMonth;
	}
	public void setTotalRewards(Double totalRewards) {
		this.totalRewards = totalRewards;
	}
	public double getTotalRewards() {
		return totalRewards;
	}
	
	@Override
	public String toString() {
		return "RewardsResponse [customerId=" + "customerId + ," + ", totalrewards="
				+ totalRewards + "]";
	}
	
	
	
	

}
