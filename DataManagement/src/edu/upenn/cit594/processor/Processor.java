package edu.upenn.cit594.processor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.upenn.cit594.datamanagement.*;
import edu.upenn.cit594.logging.Logging;


public class Processor {
	protected Tweet_Reader tweetreader;
	protected State_Reader statesreader;
	protected List<tweets> t; 
	protected List<states> s;
	protected List<tweets> flut;
	
	
	public Processor(Tweet_Reader tweetreader, State_Reader statesreader) {
		this.tweetreader = tweetreader;
		this.statesreader = statesreader;
		t = tweetreader.getTweets();
		s =statesreader.getStates();
		flut = getFlut(t);
	}

	public List<tweets> getFlut(List<tweets> t){
		List<tweets> rr = new ArrayList<tweets>();
		Pattern p = Pattern.compile("\\b#?flu\\W?\\b");
		for(tweets tweet:t) {
			Matcher m = p.matcher(tweet.gett().toLowerCase());
			if(m.find()==true) {
				rr.add(tweet);
			}
		}
		
		return rr;
	}
	
	public double distance(double stLat,double stLon,double twLat,double twLon) {
		
		return (Math.sqrt(Math.pow((stLat - twLat), 2) + Math.pow((stLon - twLon), 2)));
	}
	
	public String findState(tweets t) {
		double dis = Double.MAX_VALUE;
		String state = "";
		
		
		for(states stat :s) {
			
			double d = distance(stat.getlat(),stat.getlon(),t.getlat(),t.getlon());
			if(dis > d) {
				
				dis = d;
				state = stat.getstate();
				
			}
			
		}
		
		return state;
	}
	
	
	public Map<String, Integer> getflutwithState(){
		Map<String, Integer> m = new TreeMap<>();
		
		Logging log = Logging.getstart();
		String st = "";
		for(tweets f:flut) {
		
			st = findState(f);
			if(m.containsKey(st)==false) {
				m.put(st, 1);
			}else {
				int count = m.get(st);
				m.put(st, count+1);
			}
			String logg = st+"\t"+f.gett();
			
		log.printlog(logg);
		}
		return m;
	}
	
	
	public void printresult(Map<String, Integer> r) {
		for (String ss : r.keySet()) {
			System.out.println(ss + ": " + r.get(ss)); 
		}
		
	}
	
}