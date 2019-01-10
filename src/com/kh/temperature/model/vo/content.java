package com.kh.temperature.model.vo;

public class content {
	int temperatureMin;
	int temperatureMax;
	String contents;
	public content(int temperatureMin, String contents) {
		
		this.temperatureMin = temperatureMin;
		this.contents = contents;
	}
	
	public content(int temperatureMin, int temperatureMax, String contents) {
		super();
		this.temperatureMin = temperatureMin;
		this.temperatureMax = temperatureMax;
		this.contents = contents;
	}
	public int getTemperatureMin() {
		return temperatureMin;
	}
	public void setTemperatureMin(int temperatureMin) {
		this.temperatureMin = temperatureMin;
	}
	public int getTemperatureMax() {
		return temperatureMax;
	}
	public void setTemperatureMax(int temperatureMax) {
		this.temperatureMax = temperatureMax;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	@Override
	public String toString() {
		return "content [temperatureMin=" + temperatureMin + ", temperatureMax=" + temperatureMax + ", contents="
				+ contents + "]";
	}
	
	
	
	
	
	
	
	
	
}
