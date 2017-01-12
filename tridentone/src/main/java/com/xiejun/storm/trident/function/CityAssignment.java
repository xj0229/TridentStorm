package com.xiejun.storm.trident.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.storm.trident.operation.BaseFunction;
import org.apache.storm.trident.operation.TridentCollector;
import org.apache.storm.trident.tuple.TridentTuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xiejun.storm.trident.spout.DiagnosisEvent;

public class CityAssignment extends BaseFunction{
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOG = LoggerFactory.getLogger(CityAssignment.class);
	
	private static Map<String, double[]> CITIES = new HashMap<String, double[]>();
	
	{
		double[] phl = {39.875365, -75.249524};
		CITIES.put("PHL", phl);
		
		double[] nyc = {31.875365, -45.249524};
		CITIES.put("NYC", nyc);
		
		double[] sf = {20.875365, -60.249524};
		CITIES.put("SF", sf);
		
		double[] la = {10.875365, -10.249524};
		CITIES.put("LA", la);
	}

	public void execute(TridentTuple arg0, TridentCollector arg1) {
		// TODO Auto-generated method stub
		DiagnosisEvent diagnosis = (DiagnosisEvent)arg0.getValue(0);
		
		double leastDistance = Double.MAX_VALUE;
		
		String closestCity = "NONE";
		
		for(Entry<String, double[]> city : CITIES.entrySet()){
			double R = 6371; //km
			
			double x = (city.getValue()[0] - diagnosis.lng) * Math.cos((city.getValue()[0] + diagnosis.lng) / 2);
			
			double y = (city.getValue()[1] - diagnosis.lat);
			
			double d = Math.sqrt(x * x + y*y)*R;
			
			if(d < leastDistance){
				leastDistance = d;
				closestCity = city.getKey();
			}
		}
		
		//Emit the value
		List<Object> values = new ArrayList<Object>();
		
		values.add(closestCity);
		
		LOG.debug("Closest city to lat=[" + diagnosis.lat + "], lng=[" + diagnosis.lng + "] == [" + closestCity + "], d=[" + leastDistance + "]");
		
		arg1.emit(values);
	}

}
