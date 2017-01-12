package com.xiejun.storm.trident.spout;

import java.util.Map;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.trident.spout.ITridentSpout;
import org.apache.storm.tuple.Fields;

public class DiagnosisEventSpout implements ITridentSpout<Long>{
	private static final long serialVersionUID = 1L;
	
	SpoutOutputCollector collector;
	
	BatchCoordinator<Long> coordinator = new DefaultCoordinator();
	
	Emitter<Long> emitter = new DiagnosisEventEmitter();
	
	public Map<String, Object> getComponentConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}
	public org.apache.storm.trident.spout.ITridentSpout.BatchCoordinator<Long> getCoordinator(String arg0, Map arg1,
			TopologyContext arg2) {
		// TODO Auto-generated method stub
		return coordinator;
	}
	public org.apache.storm.trident.spout.ITridentSpout.Emitter<Long> getEmitter(String arg0, Map arg1,
			TopologyContext arg2) {
		// TODO Auto-generated method stub
		return emitter;
	}
	public Fields getOutputFields() {
		// TODO Auto-generated method stub
		return new Fields("event");
	}
	
}
