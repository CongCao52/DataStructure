package edu.upenn.cit594.datamanagement;

public class tweets {
	private double lat;
	private double lon;
	private String d; 
	private String t; 
	
	public tweets(double lat, double lon, String d, String t) {
		this.lat =lat; 
		this.lon = lon;
		this.d = d;
		this.t = t;
		
	}
	
	public double getlat() {
		return lat;
	}
	
	public double getlon() {
		return lon;
	}
	
	public String getd() {
		return d;
	}
	
	public String gett() {
		return t;
	}
}

