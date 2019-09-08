package com.lottery.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lottery.exceptions.GenericException;
import com.lottery.model.LotteryResponseModel;
import com.lottery.repository.LotteryRepository;
import com.lottery.service.LotteryService;

@Service
public class LotteryServiceImpl implements LotteryService {
	
	@Autowired
	private LotteryRepository lotteryRepository;

	@Override
	public LotteryResponseModel calculateResponse() {
		try {
			LotteryResponseModel response=new LotteryResponseModel();
			List<Integer> col1List=lotteryRepository.col1List();
			List<Integer> col2List=lotteryRepository.col2List();
			List<Integer> col3List=lotteryRepository.col3List();
			List<Integer> col4List=lotteryRepository.col4List();
			List<Integer> col5List=lotteryRepository.col5List();
			List<Integer> col6List=lotteryRepository.col6List();
			response.setCol1(calculateResult(col1List));
			response.setCol2(calculateResult(col2List));
			response.setCol3(calculateResult(col3List));
			response.setCol4(calculateResult(col4List));
			response.setCol5(calculateResult(col5List));
			response.setCol6(calculateResult(col6List));
			return response;
		} catch (Exception e) {
			throw new GenericException(-3000, e.getMessage(), e.getLocalizedMessage());
		}
	}
	
	private List<Integer> calculateResult(List<Integer> colList){
		HashMap<Integer, Integer> usageMap=findUsageCount(colList); //Create a hashmap with usage count.
		Collection<Integer> listToCollect=usageMap.values(); // to get hash map values and create a collection list with that values.
		List<Integer> intList=new ArrayList<Integer>(); 
		intList.addAll(listToCollect); // Assigns the data in the collection to the normal integer list.
		Integer biggestNumber=findBiggestNumber(intList); // find the biggest usage count of given hash map's values.
		Set<Integer> response=new HashSet<Integer>();
		response=getKeysByValue(usageMap, biggestNumber); // find keys by biggest value from given hashmap.
		List<Integer> responseList=new ArrayList<Integer>();
		responseList.addAll(response);
		return responseList;
	}
	
	private HashMap<Integer, Integer> findUsageCount(List<Integer> integerList) {
		int count=0;
		HashMap<Integer, Integer> hash=new HashMap<Integer, Integer>();
		for(int i=0;i<integerList.size();i++) {
			for(int j=0;j<integerList.size();j++) {
				if(integerList.get(i)==integerList.get(j)) {
					count+=1;
				}
			}
			hash.put(integerList.get(i), count);
			count=0;
		}
		return hash;
	}
	
	private Integer findBiggestNumber(List<Integer> integerList) {
		List<Integer> sortedList = integerList.stream().distinct().sorted().collect(Collectors.toList());
		return sortedList.get(sortedList.size()-1);
	}
	
	private <K, V> Set<K> getKeysByValue(Map<K, V> map, V value) {
	    Set<K> keys = new HashSet<>();
	    for (Entry<K, V> entry : map.entrySet()) {
	        if (entry.getValue().equals(value)) {
	            keys.add(entry.getKey());
	        }
	    }
	    return keys;
	}

}
