package com.test.devops;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;

import com.test.devops.intrf.ReadFile;

@SpringBootApplication
public class DevOpsTest1Application implements CommandLineRunner {

	@Value(value = "file.path")
	String filePath;

	@Value("classpath:log.txt")
	Resource resourceFile;

	@Autowired
	ReadFile readFile;

	public static void main(String[] args) {

		SpringApplication.run(DevOpsTest1Application.class, args);

		System.out.println("DevOpsTestApplication completed");

	}

	@Override
	public void run(String... args) {
//path by provinding from argument or its get default path from application.properties
		if (args != null && args.length >= 1) {
			filePath = args[0];
		}else{
			try {
			filePath = resourceFile.getFile().getCanonicalPath();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(filePath);
		readFile.readFile(filePath);
	}

}