package com.kakaopay.api.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FlexShare{
	
	public static List<Long> flexShareDivide(long amount, long counts){
		List<Integer> shares = new ArrayList<Integer>();
		List<Long> list = new ArrayList<Long>();
		Random rand = new Random(System.currentTimeMillis());
		long sum = 0;
		
		for (int i = 0; i<counts; i++) {
			int val = rand.nextInt(123)+1;
			shares.add(val);
			sum+=val;
		}
		
		long subsum = 0;
		for (int i = 0; i<counts-1; i++) {
			long val = shares.get(i)*amount/sum;
			list.add(val);
			subsum+=val;
		}
		list.add(amount-subsum);
		return list;
	}
}
