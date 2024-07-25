package com.test.devops;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.core.JsonParseException;
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

	@Value("classpath:log-with-error.txt")
	Resource resourceFile;

	@Value("classpath:mandatory-field-missing-log.txt")
	Resource fieldMissingFile;
	
	@Test
	void readFile() {
		readFile.readFile(filePath);
	};

	/*
	 * @Test void readErrorFile_thenException() { JsonParseException thrown =
	 * assertThrows( JsonParseException.class, () ->
	 * readFile.readFile(resourceFile.getFile().getAbsolutePath()),
	 * "Unexpected end-of-input within/between Object entries" );
	 * assertTrue(thrown.getMessage(). contains("Unexpected")); }
	 */
	@Test
	void readErrorFile_thenException() {
	    Exception exception = assertThrows(Exception.class, () -> {
	        readFile.readFile(resourceFile.getFile().getAbsolutePath());
	    });

	    String expectedMessage = "Unexpected";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void madatoryFieldMissing_thenException() {
	    Exception exception = assertThrows(Exception.class, () -> {
	        readFile.readFile(fieldMissingFile.getFile().getAbsolutePath());
	    });

	    String expectedMessage = "Cannot invoke";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void whenFindingLogEntityById_thenCorrect() {
		logRepository.save(new LogEntityStore("stgra", "APPLICATION_LOG", "12345", 1491377495210L, true));
		assert (logRepository.findById("stgra").isPresent());
	}
}
