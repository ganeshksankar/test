package com.travelport.dashboard.datadiff.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.travelport.dashboard.datadiff.entity.TestDetail;

@Service
public class DashboardService {
	private static List<TestDetail> testDetails = new ArrayList<TestDetail>();
	
	public List<String> getTestCycleByDate(LocalDate date) {
		return testDetails.stream()
				.filter(o -> date.toEpochDay() == (o.getDate().toEpochDay()))
				.mapToLong(td -> td.getEpochDateMilis())
				.distinct()
				.sorted()
				.mapToObj(l -> String.valueOf(l))
				.collect(Collectors.toList());
    }


    public List<TestDetail> getTestDetailsByCycle(String cycleNumber) {
    	return testDetails.stream().filter(test -> String.valueOf(test.getEpochDateMilis()).equals(cycleNumber))
    	.collect(Collectors.toList());
    }
	
	static {
		TestDetail td1 = new TestDetail();
		Long tdl1 = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
		td1.setId(1L);
		td1.setTestName("test-1");
		td1.setStatus("fail");
		td1.setDate(LocalDate.now());
		td1.setEpochDateMilis(tdl1);
		td1.setMissedKeys("All missed keys here");
		td1.setAdditionKeys("All Added keys here");
		td1.setValueDiffs("All value Diffs");
		
		TestDetail td2 = new TestDetail();
		td2.setId(1L);
		td2.setTestName("test-2");
		td2.setStatus("pass");
		td2.setDate(LocalDate.now());
		td2.setEpochDateMilis(tdl1);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		TestDetail td3 = new TestDetail();
		Long tdl2 = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
		td3.setId(1L);
		td3.setTestName("test-1");
		td3.setStatus("fail");
		td3.setDate(LocalDate.now().minusDays(1));
		td3.setEpochDateMilis(tdl2);
		td3.setMissedKeys("All missed keys here-yesterday");
		td3.setAdditionKeys("All Added keys here-yesterday");
		td3.setValueDiffs("All value Diffs-yesterday");
		
		TestDetail td4 = new TestDetail();
		td4.setId(1L);
		td4.setTestName("test-2");
		td4.setStatus("fail");
		td4.setDate(LocalDate.now().minusDays(1));
		td4.setEpochDateMilis(tdl2);
		td4.setMissedKeys("All missed keys here-yesterday");
		td4.setAdditionKeys("All Added keys here-yesterday");
		td4.setValueDiffs("All value Diffs-yesterday");
		
		testDetails.addAll(Arrays.asList(td1, td2, td3, td4));
	}
}
