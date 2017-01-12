package com.xiejun.storm.trident.function;

import java.util.ArrayList;
import java.util.List;

import org.apache.storm.trident.operation.BaseFunction;
import org.apache.storm.trident.operation.TridentCollector;
import org.apache.storm.trident.tuple.TridentTuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xiejun.storm.trident.spout.DiagnosisEvent;

public class HourAssignment extends BaseFunction {
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOG = LoggerFactory.getLogger(HourAssignment.class);

	public void execute(TridentTuple arg0, TridentCollector arg1) {
		
		DiagnosisEvent diagnosis = (DiagnosisEvent)arg0.getValue(0);
		
		String city = (String)arg0.getValue(1);
		
		long timestamp = diagnosis.time;
		
		long hourSinceEpoch = timestamp / 1000 / 60 / 60;
		
		LOG.debug("Key = [" + city + ":" + hourSinceEpoch + "]");
		
		String key = city + ":" + diagnosis.diagnosisCode + ":" + hourSinceEpoch;
		
		List<Object> values = new ArrayList<Object>();
		
		values.add(hourSinceEpoch);
		
		values.add(key);
		
		arg1.emit(values);

	}

}
