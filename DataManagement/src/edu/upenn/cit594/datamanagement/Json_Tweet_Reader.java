package edu.upenn.cit594.datamanagement;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Json_Tweet_Reader implements Tweet_Reader {
	protected String filename; 
	public Json_Tweet_Reader(String fn) {
		filename = fn;
	}
	
	@Override
	public List<tweets> getTweets() {
		
		// TODO Auto-generated method stub
		List<tweets> tweet = new ArrayList<tweets>();
		
		JSONParser p = new JSONParser();
	try {
		JSONArray t = (JSONArray) p.parse(new FileReader(filename));
		Iterator<JSONObject> i = t.iterator();
		
		
		
		while(i.hasNext()) {
			JSONObject o = (JSONObject) i.next();
			JSONArray loc = (JSONArray) o.get("location");
			tweets tw = new tweets((double) loc.get(0), (double)loc.get(1), (String)o.get("time"),(String)o.get("text"));
			
			tweet.add(tw);
		}
	}catch(FileNotFoundException e) {e.printStackTrace();}
	catch(ParseException e) {e.printStackTrace();}
	catch(IOException e) {e.printStackTrace();}
		
		
		return tweet;
	}
}
