/**
 * 
 */
package com.rewards.program.service;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.rewards.program.model.RewardsProgramModel;
import com.rewards.program.model.RewardsResponse;
import com.rewards.program.repository.RewardsProgramRepository;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * @author abhir
 *Junit Tests for business logic in service
 */
public class RewardsProgramServiceTest {
	
	@InjectMocks
	RewardsProgramService rewardsProgramService;
	
	@Mock
	RewardsProgramRepository rewardsProgramRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testFetchCustomerRewardPointsWithInValidInput() {
		List<RewardsProgramModel> transactions = new ArrayList<>();
		ResponseEntity<List<RewardsResponse>> resp = rewardsProgramService.fetchCustomerRewardPoints(transactions);
		assertTrue(resp.getBody().isEmpty());
		assertEquals(HttpStatus.BAD_GATEWAY, resp.getStatusCode());
	}
	
	@Test
	public void testFetchCustomerRewardPointsWithValidInput() {
		List<RewardsProgramModel> transactions = new ArrayList<>();
		RewardsProgramModel rewardsProgramModel = new RewardsProgramModel();
		rewardsProgramModel.setCustomerId(85326);
		rewardsProgramModel.setDate(new Date());
		rewardsProgramModel.setTransactionAmount(340);
		transactions.add(rewardsProgramModel);
		ResponseEntity<List<RewardsResponse>> resp = rewardsProgramService.fetchCustomerRewardPoints(transactions);
		assertTrue(!resp.getBody().isEmpty());
		assertEquals(HttpStatus.OK, resp.getStatusCode());

	}
	
	
	
	
	

}
