/**
 * 
 */
package com.rewards.program.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rewards.program.model.RewardsProgramModel;
import com.rewards.program.model.RewardsResponse;

/**
 * @author abhir
 *Interface for Rewards Service Implementation
 */

@Service
public interface RewardsProgramService {

	public ResponseEntity<List<RewardsResponse>> fetchCustomerRewardPoints(
		 List<RewardsProgramModel> transactions);	
	
}
