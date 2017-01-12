package com.xiejun.storm.trident.filter;

import org.apache.storm.trident.operation.BaseFilter;
import org.apache.storm.trident.tuple.TridentTuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xiejun.storm.trident.spout.DiagnosisEvent;

public class DiseaseFilter extends BaseFilter{
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOG = LoggerFactory.getLogger(DiseaseFilter.class);

	public boolean isKeep(TridentTuple arg0) {
		// TODO Auto-generated method stub
		DiagnosisEvent diagnosis = (DiagnosisEvent)arg0.getValue(0);
		
		Integer code = Integer.parseInt(diagnosis.diagnosisCode);
		
		if(code.intValue() <= 322){
			LOG.debug("Emitting disease [" + diagnosis.diagnosisCode + "]");
			return true;
			
		}else{
			LOG.debug("Filtering disease [" + diagnosis.diagnosisCode + "]");
			return false;
		}
		
	}

}
