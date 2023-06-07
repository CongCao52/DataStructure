package edu.upenn.cit594.datamanagement;

public class states {
	private double lat; 
	private double lon;
	private String s;
	
	public states(double lat, double lon, String s) {
		
		this.lat = lat;
		this.lon = lon;
		this.s = s;
	}
	
	public double getlat() {
		return lat;
	}
	
	public double getlon() {
		return lon;
	}
	
	public String getstate() {
		return s;
	}
}