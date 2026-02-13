package com.example.demo.example.impl;

import com.example.demo.example.Example;
import com.example.demo.service.SomeService;

//@Component
public class ConstructionInjectionOmitExample implements Example {
	/** フィールド */
	private final SomeService someService;
	
	/** コンストラクタインジェクション（@Autowired省略版） */
	public ConstructionInjectionOmitExample(SomeService someService) {
		this.someService = someService;
	}
	
	/** 実行 */
	public void run() {
		someService.doService();
	}
}