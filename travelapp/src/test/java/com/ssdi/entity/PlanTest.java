package com.ssdi.entity;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssdi.TravelWebAppApplication;
import com.ssdi.entity.Plan;
import com.ssdi.service.PlanService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TravelWebAppApplication.class)
public class PlanTest {

	private Plan plan;
	
	@Autowired
	private PlanService planService;
	
	@Before
	public void setUp() throws Exception{
		plan = new Plan();
		java.sql.Date date = java.sql.Date.valueOf( "2010-01-31" );
		plan.setUserId(1);
		plan.setPlace("test");
		plan.setAddress("test");
		plan.setHotel("test");
		plan.setDateTravel(date);
		plan.setDateAdded(date);
		plan.setClimate("test");
	}
	
	@Test
    public void testValidUserId() throws Exception{
    	boolean exceptionCaught = false;
    	try{
    		planService.addPlan(plan);
    	}catch(Exception e){
    		exceptionCaught = true;
    	}
    	assertFalse(exceptionCaught);
    }
	
	@Test
    public void testInvalidPlaceId() throws Exception{
    	boolean exceptionCaught = false;
    	try{
    		plan.setPlaceId(null);
    		planService.addPlan(plan);
    	}catch(Exception e){
    		exceptionCaught = true;
    	}
    	assertFalse(exceptionCaught);
    }
	@Test
    public void testValidPlace() throws Exception{
    	boolean exceptionCaught = false;
    	try{
    		planService.addPlan(plan);
    	}catch(Exception e){
    		exceptionCaught = true;
    	}
    	assertFalse(exceptionCaught);
    }
	
	@Test
    public void testInvalidPlace() throws Exception{
    	boolean exceptionCaught = false;
    	try{
    		plan.setPlace(null);
    		planService.addPlan(plan);
    	}catch(Exception e){
    		exceptionCaught = true;
    	}
    	assertTrue(exceptionCaught);
    }
	
	@Test
    public void testValidCountry() throws Exception{
    	boolean exceptionCaught = false;
    	try{
    		planService.addPlan(plan);
    	}catch(Exception e){
    		exceptionCaught = true;
    	}
    	assertFalse(exceptionCaught);
    }
	
	@Test
    public void testInvalidCountry() throws Exception{
    	boolean exceptionCaught = false;
    	try{
    		plan.setAddress(null);
    		planService.addPlan(plan);
    	}catch(Exception e){
    		exceptionCaught = true;
    	}
    	assertTrue(exceptionCaught);
    }
	
	@Test
    public void testValidHotel() throws Exception{
    	boolean exceptionCaught = false;
    	try{
    		planService.addPlan(plan);
    	}catch(Exception e){
    		exceptionCaught = true;
    	}
    	assertFalse(exceptionCaught);
    }
	
	@Test
    public void testInvalidHotel() throws Exception{
    	boolean exceptionCaught = false;
    	try{
    		plan.setHotel(null);
    		planService.addPlan(plan);
    	}catch(Exception e){
    		exceptionCaught = true;
    	}
    	assertTrue(exceptionCaught);
    }
	
	@Test
    public void testValidDateTravel() throws Exception{
    	boolean exceptionCaught = false;
    	try{
    		planService.addPlan(plan);
    	}catch(Exception e){
    		exceptionCaught = true;
    	}
    	assertFalse(exceptionCaught);
    }
	
	@Test
    public void testInvalidDateTravel() throws Exception{
    	boolean exceptionCaught = false;
    	try{
    		plan.setDateTravel(null);
    		planService.addPlan(plan);
    	}catch(Exception e){
    		exceptionCaught = true;
    	}
    	assertTrue(exceptionCaught);
    }
	
	@Test
    public void testValidDateAdded() throws Exception{
    	boolean exceptionCaught = false;
    	try{
    		planService.addPlan(plan);
    	}catch(Exception e){
    		exceptionCaught = true;
    	}
    	assertFalse(exceptionCaught);
    }
	
	@Test
    public void testInvalidDateAdded() throws Exception{
    	boolean exceptionCaught = false;
    	try{
    		plan.setDateAdded(null);
    		planService.addPlan(plan);
    	}catch(Exception e){
    		exceptionCaught = true;
    	}
    	assertTrue(exceptionCaught);
    }
	
	@Test
    public void testValidClimate() throws Exception{
    	boolean exceptionCaught = false;
    	try{
    		planService.addPlan(plan);
    	}catch(Exception e){
    		exceptionCaught = true;
    	}
    	assertFalse(exceptionCaught);
    }
	
	@Test
    public void testInvalidClimate() throws Exception{
    	boolean exceptionCaught = false;
    	try{
    		plan.setClimate(null);
    		planService.addPlan(plan);
    	}catch(Exception e){
    		exceptionCaught = true;
    	}
    	assertTrue(exceptionCaught);
    }
}
