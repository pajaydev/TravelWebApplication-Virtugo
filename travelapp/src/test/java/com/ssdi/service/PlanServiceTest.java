package com.ssdi.service;

import static org.junit.Assert.assertTrue;
import java.util.List;
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
public class PlanServiceTest {

	@Autowired
	private PlanService planService;
	
	
	
	@Test
	public void testInvalidGetPlansByUserId() throws Exception {
		boolean condition = false;
		List<Plan> m = planService.getPlansById(3);
		if (m.size() == 0)
			condition = true;
		assertTrue(condition);
	}
	
	@Test
	public void testValidAddMovie() throws Exception {
		boolean condition = false;
		Plan plan = new Plan();
		java.sql.Date date = java.sql.Date.valueOf( "2010-01-31" );
		plan.setUserId(1);
		plan.setPlace("test");
		plan.setAddress("test");
		plan.setHotel("test");
		plan.setDateTravel(date);
		plan.setDateAdded(date);
		plan.setClimate("test");
		Plan response = planService.addPlan(plan);
		List<Plan> plans = planService.getPlansById(response.getUserId());
		for (Plan p : plans) {
			if (p.getPlaceId()== response.getPlaceId())
				condition = true;
		}
		assertTrue(condition);
	}

	@Test
	public void testInvalidAddPlan() throws Exception {
		boolean condition = false;
		Plan plan = new Plan();
		try {
			planService.addPlan(plan);
		} catch (Exception e) {
			condition = true;
		}
		assertTrue(condition);
	}
}
