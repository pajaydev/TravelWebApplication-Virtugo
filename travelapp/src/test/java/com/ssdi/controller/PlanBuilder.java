package com.ssdi.controller;

import org.springframework.test.util.ReflectionTestUtils;

import com.ssdi.entity.Plan;

public class PlanBuilder {

	private Plan plan;
	
	public PlanBuilder(){
		plan = new Plan();
	}
	
	public PlanBuilder userId(int id){
		ReflectionTestUtils.setField(plan, "userId", id);
		return this;
	}
	
	public PlanBuilder place(String place){
		ReflectionTestUtils.setField(plan, "place", place);
		return this;
	}
	
	public Plan build(){
		return plan;
	}

}
