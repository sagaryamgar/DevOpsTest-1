package com.test.devops.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.devops.entity.LogEntityStore;
import com.test.devops.intrf.LogRepository;
@RestController
public class RestLogController {

	@Autowired
	LogRepository LogRepository;

	@GetMapping("getEvents")
		@ResponseBody
		List<LogEntityStore> getAllEvents() { 
		return LogRepository.findAll();
		}


	@GetMapping("getEventsByThreshold")
		@ResponseBody
		List<LogEntityStore> getAllEventsFilter() { 
		return LogRepository.findAllByAlertTrue(Sort.by(Sort.Direction.DESC,"timeInMillis"));
		}
}
