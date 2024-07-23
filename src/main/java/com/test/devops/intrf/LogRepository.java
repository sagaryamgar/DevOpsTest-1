package com.test.devops.intrf;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.test.devops.entity.LogEntity;
import com.test.devops.entity.LogEntityStore;

public interface LogRepository extends JpaRepository<LogEntityStore, String>{
	
	List<LogEntityStore> findAllByAlertTrue(Sort millis);

}
