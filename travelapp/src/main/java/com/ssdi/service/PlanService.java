package com.ssdi.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssdi.entity.Plan;
import com.ssdi.repository.PlanRepository;

@Service
public class PlanService {

	PlanRepository planRepository;

	@Autowired
	public PlanService(PlanRepository myPlanRepository) {
		super();
		this.planRepository = myPlanRepository;
	}

	public PlanService() {

	}

	public List<Plan> getPlansById(Integer id) {
		List<Plan> plans = planRepository.findPlansByUserId(id);
		return plans;
	}

	public Plan getPlansByPlaceId(Integer id) {
		Plan plan = planRepository.findPlansByPlaceId(id);
		return plan;
	}

	public Plan addPlan(Plan plan) {
		return planRepository.save(plan);
	}

	public boolean deletePlan(int id) {
		planRepository.delete(id);
		return true;
	}

	public void setRepository(PlanRepository repository) {
		this.planRepository = repository;
	}
}
