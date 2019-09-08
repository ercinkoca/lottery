package com.lottery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lottery.entity.Lottery;

public interface LotteryRepository extends JpaRepository<Lottery, Long>{
	
	@Query(value="SELECT col_1 from lottery_results ",nativeQuery=true)
	List<Integer> col1List();
	
	@Query(value="SELECT col_2 from lottery_results ",nativeQuery=true)
	List<Integer> col2List();
	
	@Query(value="SELECT col_3 from lottery_results ",nativeQuery=true)
	List<Integer> col3List();
	
	@Query(value="SELECT col_4 from lottery_results ",nativeQuery=true)
	List<Integer> col4List();
	
	@Query(value="SELECT col_5 from lottery_results ",nativeQuery=true)
	List<Integer> col5List();
	
	@Query(value="SELECT col_6 from lottery_results ",nativeQuery=true)
	List<Integer> col6List();

}
