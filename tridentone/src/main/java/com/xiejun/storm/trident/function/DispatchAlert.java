package com.xiejun.storm.trident.function;

import org.apache.storm.trident.operation.BaseFunction;
import org.apache.storm.trident.operation.TridentCollector;
import org.apache.storm.trident.tuple.TridentTuple;

import com.esotericsoftware.minlog.Log;

public class DispatchAlert extends BaseFunction{
	
	private static final long serialVersionUID = 1L;

	public void execute(TridentTuple arg0, TridentCollector arg1) {
		// TODO Auto-generated method stub
		String alert = (String)arg0.getValue(0);
		
		Log.error("ALERT RECEIVED [" + alert + "]");
		
		Log.error("Dispatch the national guard!");
		
		System.exit(0);
		
	}

}
