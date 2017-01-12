package com.xiejun.storm.trident.function;

import java.util.ArrayList;
import java.util.List;

import org.apache.storm.trident.operation.BaseFunction;
import org.apache.storm.trident.operation.TridentCollector;
import org.apache.storm.trident.tuple.TridentTuple;

public class OutbreakDetector extends BaseFunction{
	
	private static final long serialVersionUID = 1L;
	
	public static final int THRESHOLD = 10000;

	public void execute(TridentTuple arg0, TridentCollector arg1) {
		// TODO Auto-generated method stub
		String key = (String)arg0.getValue(0);
		
		Long count = (Long)arg0.getValue(1);
		
		if(count > THRESHOLD){
			List<Object> values = new ArrayList<Object>();
			
			values.add("Outbreak detected for [" + key + "]!");
			
			arg1.emit(values);
		}
	}

}
