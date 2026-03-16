package com.travelport.dashboard.datadiff.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TestDetail {
	@JsonProperty("id")
    private Long id;
	
	@JsonProperty("testName")
	private String testName;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("date")
	private LocalDate date;
	
	@JsonProperty("epochDateMilis")
	private Long epochDateMilis;
	
	@JsonProperty("missedKeys")
	private String missedKeys;
	
	@JsonProperty("additionKeys")
	private String additionKeys;
	
	@JsonProperty("valueDiffs")
	private String valueDiffs;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Long getEpochDateMilis() {
		return epochDateMilis;
	}
	public void setEpochDateMilis(Long epochDateMilis) {
		this.epochDateMilis = epochDateMilis;
	}
	public String getMissedKeys() {
		return missedKeys;
	}
	public void setMissedKeys(String missedKeys) {
		this.missedKeys = missedKeys;
	}
	public String getAdditionKeys() {
		return additionKeys;
	}
	public void setAdditionKeys(String additionKeys) {
		this.additionKeys = additionKeys;
	}
	public String getValueDiffs() {
		return valueDiffs;
	}
	public void setValueDiffs(String valueDiffs) {
		this.valueDiffs = valueDiffs;
	}
	@Override
	public String toString() {
		return "TestDetail [id=" + id + ", testName=" + testName + ", status=" + status + ", date=" + date
				+ ", epochDateMilis=" + epochDateMilis + ", missedKeys=" + missedKeys + ", additionKeys=" + additionKeys
				+ ", valueDiffs=" + valueDiffs + "]";
	}
}
