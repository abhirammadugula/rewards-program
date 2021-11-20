/**
 * 
 */
package com.rewards.program.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.rewards.program.model.RewardsProgramModel;
import com.rewards.program.model.RewardsResponse;
import com.rewards.program.repository.RewardsProgramRepository;
import com.rewards.program.utils.RewardProgramConstants;

/**
 * @author abhir
 * Service class to implement the rewards related business logic
 */
public class RewardsProgramServiceImpl implements RewardsProgramService {
	
	@Autowired
	private RewardsProgramRepository rewardsProgramRepository;

	@Override
	public ResponseEntity<List<RewardsResponse>> fetchCustomerRewardPoints(List<RewardsProgramModel> transactions) {
		List<RewardsResponse> rewardsResponses = new ArrayList<>();
		if(transactions.isEmpty()) {
			return new ResponseEntity<>(rewardsResponses, HttpStatus.BAD_REQUEST);
		}
		Set<Long> visitedcustomer = new HashSet<>();
		Set<Integer> monthSet = new HashSet<>();
		transactions.forEach(element -> {
			monthSet.add(element.getMonth());
		});
		for(RewardsProgramModel purchaseEntry: transactions) {
			RewardsResponse rewardsResponse = new RewardsResponse();
			if(!visitedcustomer.contains(purchaseEntry.getCustomerId())){ 
				rewardsResponses.add(this.customerRewardsEachMonth(purchaseEntry, monthSet));
				visitedcustomer.add(purchaseEntry.getCustomerId());
			}	
		}
		return new ResponseEntity<>(rewardsResponses, HttpStatus.OK);
	}

	private RewardsResponse customerRewardsEachMonth(RewardsProgramModel purchaseEntry, Set<Integer> monthSet) {
		RewardsResponse rewardsResponse = new RewardsResponse();
		double totalPoints = 0;
		double monthPoints = 0;
		Map<Integer, Double> rewardsPerMonth = new HashMap<>();
		for(Integer month: monthSet) {
			List<RewardsProgramModel> filteredTransactions = rewardsProgramRepository.findByCustomerIdAndMonth(purchaseEntry.getCustomerId(), 
					RewardProgramConstants.monthSymbol + month.toString() + RewardProgramConstants.monthSymbol);
			monthPoints = 0;
			for(RewardsProgramModel rewardTransaction: filteredTransactions) {
				double currentAmount = rewardTransaction.getTransactionAmount();
				if(currentAmount > 50 && currentAmount <= 100) {
					monthPoints = monthPoints + (currentAmount - 50);
				}
				else if(currentAmount > 100) {
					monthPoints = monthPoints + 50 + (100 - currentAmount) * 2;
				}
			}
			totalPoints = totalPoints + monthPoints;
			rewardsPerMonth.put(month, monthPoints);
			
		}
		rewardsResponse.setCustomerId(purchaseEntry.getCustomerId());
		rewardsResponse.setRewardsPerMonth(rewardsPerMonth);
		rewardsResponse.setTotalRewards(totalPoints);
		
		return rewardsResponse;
		
		
	}

}
