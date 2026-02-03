package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Service.BusinessLogic;

@SpringBootApplication
public class JavaConfigSampleApplication {

	/** 起動メソッド */
	public static void main(String[] args) {
		SpringApplication.run(JavaConfigSampleApplication.class, args)
		.getBean(JavaConfigSampleApplication.class).exe();
	}
	
	/** DI */
	@Autowired
	@Qualifier("test")
	private BusinessLogic business1;	// TestLogicImplのインスタンス
	
	/** DI */
	@Autowired
	@Qualifier("sample")
	private BusinessLogic business2;	// SampleLogicImplのインスタンス
	

	private void exe() {
		business1.doLogic();
		business2.doLogic();
	}
}
