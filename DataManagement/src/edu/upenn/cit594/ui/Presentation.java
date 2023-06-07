package edu.upenn.cit594.ui;

import java.util.Map;

import edu.upenn.cit594.processor.Processor;



public class Presentation {
	protected Processor p;
	Map<String, Integer> results;
	public Presentation(Processor p) {
		this.p = p; 
	}
	
	public void printresult() {
		results = p.getflutwithState();
		for (String ss : results.keySet()) {
			System.out.println(ss + ": " + results.get(ss)); 
		}
		
	}
}
