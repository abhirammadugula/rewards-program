/**
 * 
 */
package com.rewards.program.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rewards.program.model.RewardsProgramModel;

/**
 * @author abhir
 *Interface to implement database transaction methods
 */
public interface RewardsProgramRepository extends CrudRepository<RewardsProgramModel, Long>{
	List<RewardsProgramModel> findByCustomerId(long customerId);
	
	@Query(value = "select * from purchasehistory where customerId=:customerId and date like :datepattern")
	List<RewardsProgramModel> findByCustomerIdAndMonth(@Param("customerId") long customerId, 
			@Param("datepattern") String datePattern);

//	@Query(value = "select "
//	List<Integer> findDistinctMonths();

}
