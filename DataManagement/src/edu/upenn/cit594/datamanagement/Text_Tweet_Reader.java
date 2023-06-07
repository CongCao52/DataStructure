package edu.upenn.cit594.datamanagement;

import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Text_Tweet_Reader implements Tweet_Reader {

	protected String filename; 
	public Text_Tweet_Reader(String fn) {
		filename = fn;
	}
	
	@Override
	public List<tweets> getTweets() {
     List<tweets> tweet = new ArrayList<tweets>();
	 Scanner s = null;
	 try {
		 s = new Scanner(new File(filename));
		 while(s.hasNextLine()) {
			 String line =s.nextLine();
			
			 String[] words = line.split("\t");
			 String loc = words[0]; 
			 tweets tw = new tweets(Double.parseDouble(loc.substring(1,loc.indexOf(",")-1)),Double.parseDouble(loc.substring(loc.indexOf(",")+2,loc.indexOf("]")-1)),words[2],words[3]);		 
			 tweet.add(tw);}
	    } catch(Exception e){
			
			throw new IllegalStateException(e);
			
		} finally {
			
			s.close(); 
			
		}
	 
	 
	 return tweet;}
	
	
	
}
	