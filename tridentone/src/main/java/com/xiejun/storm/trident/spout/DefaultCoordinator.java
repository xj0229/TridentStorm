package com.xiejun.storm.trident.spout;

import java.io.Serializable;

import org.apache.storm.trident.spout.ITridentSpout.BatchCoordinator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultCoordinator implements BatchCoordinator<Long>,Serializable{
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOG = LoggerFactory.getLogger(DefaultCoordinator.class);

	public void close() {
		// TODO Auto-generated method stub
		
	}

	public Long initializeTransaction(long arg0, Long arg1, Long arg2) {
		LOG.info("Initializing Transaction [" + arg0 + "]");
		
		return null;
	}

	public boolean isReady(long arg0) {
		// TODO Auto-generated method stub
		return true;
	}

	public void success(long arg0) {
		
		LOG.info("Successful Transaction [" + arg0 + "]");
		
	}
	
	
}
