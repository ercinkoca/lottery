package com.lottery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lottery.model.LotteryResponseModel;
import com.lottery.service.LotteryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/lottery")
@Api(value = "Lottery Calculation", description = "", tags = "lottery") 
public class LotteryController {
	
	@Autowired
	private LotteryService lotteryService;
	
	@ApiOperation(value = "Calculate maximum wining numbers for each column.", response = LotteryResponseModel.class)
	@PostMapping(value = "/calculate", produces =MediaType.APPLICATION_JSON_UTF8_VALUE )
	public LotteryResponseModel calculateResponse() {
		return lotteryService.calculateResponse();
	}

}
