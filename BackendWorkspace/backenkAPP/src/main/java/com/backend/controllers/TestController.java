package com.backend.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@RestController
@Slf4j
public class TestController {
	
	List<TestDo> ls=new ArrayList<>();
	
	public TestController() {
		ls.add(TestDo.builder().name("A").age(10l).build());
		ls.add(TestDo.builder().name("B").age(20l).build());
		ls.add(TestDo.builder().name("C").age(30l).build());
		ls.add(TestDo.builder().name("D").age(40l).build());
	}
	
	@GetMapping("test")
	public ResponseEntity<List<TestDo>> f1() {
		System.out.println(ls);
		return ResponseEntity.ok(ls);
	}
	@GetMapping("test2")
	public String f2() {
		System.out.println(ls);
		return "Hello world";
	}
}
