package com.test.devops.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.test.devops.entity.LogEntity;
import com.test.devops.entity.LogEntityStore;
import com.test.devops.intrf.LogRepository;
@Service
public class ValidateAndStoreLogEntry{

@Autowired
LogRepository logRepository;



@Value("${event.threshold.millis}")
Long thresholdTime;



public void extractLogDataAndPersist (LogEntity logEntity, LogEntity logEntity1) {

	Long timestampStart = Long.valueOf("STARTED".equalsIgnoreCase (String.valueOf(logEntity.getState()))?logEntity.getTimestamp():logEntity1.getTimestamp());
	
	Long timestampEnd = Long.valueOf("FINISHED".equalsIgnoreCase(String.valueOf(logEntity.getState()))?logEntity.getTimestamp():logEntity1.getTimestamp());
	
	Date timestamp1 = new Date(timestampStart);
	
	Date timestamp2 = new Date(timestampEnd);
	
	Long difference = Math.abs(timestamp1.getTime() - timestamp2.getTime()); LogEntityStore logEntityStore = new LogEntityStore (logEntity.getId(),
	
	logEntity.getType(),
	
	logEntity.getHost(),
	
	difference,
	
	difference > thresholdTime? true: false);
			logRepository.save(logEntityStore);
}
}
