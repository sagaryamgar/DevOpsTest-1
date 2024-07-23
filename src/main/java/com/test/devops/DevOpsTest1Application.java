package com.test.devops;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.test.devops.intrf.ReadFile;

@SpringBootApplication
public class DevOpsTest1Application implements CommandLineRunner {

	@Value(value = "${file.path}")
	String filePath;

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

		}

		readFile.readFile(filePath);
	}

}