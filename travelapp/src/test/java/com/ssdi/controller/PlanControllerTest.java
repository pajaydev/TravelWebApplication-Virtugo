package com.ssdi.controller;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.ssdi.entity.Plan;
import com.ssdi.service.PlanService;

@RunWith(JUnit4.class)
@WebMvcTest(PlanController.class)
public class PlanControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private PlanService planService;
	
	private Plan plan;
	private Plan plan2;
	private PlanController planController;
	private List<Plan> plans;
	
	@Before
	public void setup() throws Exception {
		planController = new PlanController();
		planService = mock(PlanService.class);
		
		plan = new Plan();
		plan.setUserId(1);
		//plan.setUserId(1);
		plan2 = new Plan();
		plan2.setUserId(2);
		plan2.setHotel(null);
		
		/*plan.setPlace("Mumbai");
		plan.setAddress("India");
		plan.setClimate("Winter");
		plan.setHotel("Taj");
		*/
		plan.setDateTravel(new java.sql.Date(new Date().getTime()));
		plan2.setDateTravel(new java.sql.Date(new Date().getTime()));
		
		plans = new ArrayList<Plan>();
		planController.setPlanService(planService);
		when(planService.addPlan(plan)).thenReturn(plan);
		when(planService.addPlan(plan2)).thenReturn(null);
		when(planService.getPlansById(plan.getUserId())).thenReturn(new ArrayList<Plan>());
		when(planService.getPlansById(plan2.getUserId())).thenReturn(new ArrayList<Plan>());
		
	}
	
	@Test
	public void testGetPlans() {
		when(planService.getPlansById(plan.getUserId())).thenReturn(plans);
		assertEquals(plans, planController.GetPlans(plan));
	}
	
	@Test
	public void testAddPlans() {
		when(planService.addPlan(plan)).thenReturn(plan);
		assertEquals(plan, planController.AddPlans(plan));
	}
	
	@Test
	public void testInvalidAddPlans() {
		assertEquals(null, planController.AddPlans(plan2));
	}
	
	@Test
	public void testInvalidGetPlans() {
		when(planService.getPlansById(plan.getUserId())).thenReturn(plans);
		when(planService.getPlansById(plan2.getUserId())).thenReturn(plans);
		assertEquals(planController.GetPlans(plan2), planController.GetPlans(plan));
	}
	
	@Test
	public void testDeletePlans() {
		assertEquals(true, planController.deletePlan(1,plan));
	}
	
	
	/*@Test
	public void TestGetPlans() throws Exception{
		Plan plan = new PlanBuilder()
				.userId(1)
				.place("Mumbai")
				.build();
	
	given(planService.getPlansById(1)).willReturn(Arrays.asList(plan));

	mockMvc.perform(post("/plan"))
			.andDo(print())
			.andExpect(status().isOk());
	
	verify(planService, times(1)).getPlansById(1);
	verifyNoMoreInteractions(planService);
	}*/
}
