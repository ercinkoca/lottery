package com.lottery.model;

import java.util.List;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LotteryResponseModel {

	private List<Integer> col1;
	private List<Integer> col2;
	private List<Integer> col3;
	private List<Integer> col4;
	private List<Integer> col5;
	private List<Integer> col6;
}
