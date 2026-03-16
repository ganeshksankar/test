package com.travelport.dashboard.datadiff.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.travelport.dashboard.datadiff.entity.TestDetail;
import com.travelport.dashboard.datadiff.service.DashboardService;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
	
	@Autowired
	private DashboardService dashboardService;
	
	@GetMapping
    public String loadPage(Model model) {
        return "dashboard";
    }

    @GetMapping("/by-date")
    @ResponseBody
    public List<String> getOrdersByDate(Model model, @RequestParam String date) {
    	System.out.println("Date:"+date);
        LocalDate localDate = LocalDate.parse(date);
        return dashboardService.getTestCycleByDate(localDate);
    }

    @GetMapping("/details")
    @ResponseBody
    public String getOrderDetails(Model model, @RequestParam String cycleNumber) {
    	System.out.println("CycleNumber:"+cycleNumber);
    	List<TestDetail> testDetails = dashboardService.getTestDetailsByCycle(cycleNumber);
    	model.addAttribute("testDetails", testDetails);
        return "dashboard";
    }
}
