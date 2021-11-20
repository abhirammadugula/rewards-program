/**
 * 
 */
package com.rewards.program.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rewards.program.model.Customer;
import com.rewards.program.model.GenericResponse;
import com.rewards.program.model.RewardsProgramModel;
import com.rewards.program.model.RewardsResponse;
import com.rewards.program.service.RewardsProgramService;

/**
 * @author abhir
 * class to route the REST requests for customers
 */
@RestController
@RequestMapping("/customers")
public class RewardsProgramController {
	
	//logger
	
	@Autowired
	private RewardsProgramService rewardsProgramService;
	
	@PostMapping(value="/rewardPoints")
	public ResponseEntity<List<RewardsResponse>> fetchCustomerRewardPoints(@RequestBody @Valid List<RewardsProgramModel> transactions){
		return rewardsProgramService.fetchCustomerRewardPoints(transactions);
		
	}
	

	
//	@GetMapping(value="/login")
//	public ResponseEntity<GenericResponse> login(CustomerAccount customerAccount){
//		//Basic Authentication 
//		if(success) {
//			//Generate Token and successfully login response
//		}
//		else {
//			//login Failed Response with relevant message
//		}
//	}
	
//	@GetMapping(value="/signUp")
//	public ResponseEntity<GenericResponse> login(CustomerAccount customerAccount){
//		//Basic Authentication 
//		if(customerAccount.isPremium) {
//			//Generate Token and successfully login response
//		}
//		else {
//			//login Failed Response with relevant message
//		}
//	}
	
//	@GetMapping(value="/getCustomer/{id}")
//	public ResponseEntity<CustomerAccount> getCustomerDetails(@PathVariable String id){
//		logger.info("RewardsProgramController::getCustomerDetails::/getCustomer/{id}: "+id);
//		return rewardsProgramService.fetchCustomer()
//	}
	
	
	
	
	
	
}
