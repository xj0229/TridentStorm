package com.xiejun.storm.trident.aggregator;

import org.apache.storm.trident.operation.CombinerAggregator;
import org.apache.storm.trident.tuple.TridentTuple;

public class Count implements CombinerAggregator<Long>{

	public Long combine(Long arg0, Long arg1) {
		// TODO Auto-generated method stub
		return arg0 + arg1;
	}

	public Long init(TridentTuple arg0) {
		// TODO Auto-generated method stub
		return 1L;
	}

	public Long zero() {
		// TODO Auto-generated method stub
		return 0L;
	}

}
