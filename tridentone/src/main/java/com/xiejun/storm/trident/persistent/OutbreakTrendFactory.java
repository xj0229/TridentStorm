package com.xiejun.storm.trident.persistent;

import java.util.Map;

import org.apache.storm.task.IMetricsContext;
import org.apache.storm.trident.state.State;
import org.apache.storm.trident.state.StateFactory;

public class OutbreakTrendFactory implements StateFactory{

	public State makeState(Map arg0, IMetricsContext arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		return new OutbreakTrendState(new OutbreakTrendBackingMap());
	}

}
