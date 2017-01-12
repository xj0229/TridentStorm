package com.xiejun.storm.trident.spout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.storm.trident.operation.TridentCollector;
import org.apache.storm.trident.spout.ITridentSpout.Emitter;
import org.apache.storm.trident.topology.TransactionAttempt;

public class DiagnosisEventEmitter implements Emitter<Long>,Serializable{
	
	private static final long serialVersionUID = 1L;
	
	AtomicInteger successfulTransaction = new AtomicInteger(0);

	public void close() {
		// TODO Auto-generated method stub
		
	}

	public void emitBatch(TransactionAttempt arg0, Long arg1, TridentCollector arg2) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 10000; i++){
			List<Object> events = new ArrayList<Object>();
			
			double lat = new Double(-30 + (int)(Math.random() * 75));
			
			double lng = new Double(-120 + (int)(Math.random() * 70));
			
			long time = System.currentTimeMillis();
			
			String diag = new Integer(320 + (int)(Math.random() * 7)).toString();
			
			DiagnosisEvent event = new DiagnosisEvent(lat,lng,time,diag);
			
			events.add(event);
			
			arg2.emit(events);
			
		}
		
	}

	public void success(TransactionAttempt arg0) {
		// TODO Auto-generated method stub
		successfulTransaction.incrementAndGet();
	}

}
