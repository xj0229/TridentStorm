package com.xiejun.storm.trident.persistent;

import org.apache.storm.trident.state.map.NonTransactionalMap;

public class OutbreakTrendState extends NonTransactionalMap<Long>{

	protected OutbreakTrendState(OutbreakTrendBackingMap outbreakBackingMap) {
		super(outbreakBackingMap);
		// TODO Auto-generated constructor stub
	}

}
