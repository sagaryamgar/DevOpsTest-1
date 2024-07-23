package com.test.devops;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.devops.entity.LogEntityStore;
import com.test.devops.intrf.LogRepository;
import com.test.devops.intrf.ReadFile;

@SpringBootTest
class DevOpsTest1ApplicationTests {

	@Value(value = "${file.path}")
	String filePath;

	@Autowired
	LogRepository logRepository;

	@Autowired
	ReadFile readFile;

	@Test
	void readFile() { 
		readFile.readFile(filePath);
	};

	@Test
	public void whenFindingLogEntityById_thenCorrect() {
		logRepository.save(new LogEntityStore( "stgra",  "APPLICATION_LOG",  "12345", 1491377495210L,  true));
		assert(logRepository.findById("stgra").isPresent());
	}
}
