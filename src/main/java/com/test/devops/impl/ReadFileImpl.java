package com.test.devops.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.devops.entity.LogEntity;
import com.test.devops.entity.LogIdValue;
import com.test.devops.intrf.ReadFile;

@Component
public class ReadFileImpl implements ReadFile {

	@Autowired
	ValidateAndStoreLogEntry validateAndStoreLogEntry;

	@Autowired
	LogIdValue logIdValueMap;

	@Override
	public String readFile(String filePath) {
		try {
			List<String> lines = Files.readAllLines(Paths.get(filePath));
			for (String line : lines) {
				parseToJson(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private LogEntity parseToJson(String line) {
		ObjectMapper mapper = new ObjectMapper();
		LogEntity logEntity;
		try {
			logEntity = mapper.readValue(line, LogEntity.class);
			addToMap(logEntity);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
		return logEntity;
	}

	private void addToMap(LogEntity logEntity) {
		if (LogIdValue.getLogIdValueMap().containsKey(logEntity.getId())) {
			LogEntity logEntity1 = (LogEntity) LogIdValue.getLogIdValueMap().get(logEntity.getId());
			validateAndStoreLogEntry.extractLogDataAndPersist(logEntity, logEntity1);
			logIdValueMap.removeFromMap(logEntity.getId());
		} else {
			logIdValueMap.addToMap(logEntity.getId(), logEntity);
		}
	}
}