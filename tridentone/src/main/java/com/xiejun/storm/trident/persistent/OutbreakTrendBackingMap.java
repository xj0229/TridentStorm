package com.xiejun.storm.trident.persistent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.storm.trident.state.map.IBackingMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OutbreakTrendBackingMap implements IBackingMap<Long>{
	
	private static final Logger LOG = LoggerFactory.getLogger(OutbreakTrendBackingMap.class);
	
	Map<String, Long> storage = new ConcurrentHashMap<String, Long>();

	public List<Long> multiGet(List<List<Object>> arg0) {
		// TODO Auto-generated method stub
		List<Long> values = new ArrayList<Long>();
		for(List<Object> key : arg0){
			Long value = storage.get(key.get(0));
			
			if(value == null){
				values.add(new Long(0));
			}else{
				values.add(value);
			}
		}
		return values;
	}

	public void multiPut(List<List<Object>> arg0, List<Long> arg1) {
		// TODO Auto-generated method stub
		for(int i = 0; i < arg0.size(); i++){
			LOG.info("Persisting [" + arg0.get(i).get(0) + "] ==> [" + arg1.get(i) + "]");
			
			storage.put((String)arg0.get(i).get(0), arg1.get(i));
		}
	}

}
