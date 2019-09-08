package com.lottery.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="lottery_results")
public class Lottery {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="col_1")
	private Integer col1;
	
	@Column(name="col_2")
	private Integer col2;
	
	@Column(name="col_3")
	private Integer col3;
	
	@Column(name="col_4")
	private Integer col4;
	
	@Column(name="col_5")
	private Integer col5;
	
	@Column(name="col_6")
	private Integer col6;
	
	@Column(name="result_date")
	private Date resultDate;
	
}
