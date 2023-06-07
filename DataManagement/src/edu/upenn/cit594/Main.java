package edu.upenn.cit594;

import edu.upenn.cit594.datamanagement.*;
import edu.upenn.cit594.logging.Logging;
import edu.upenn.cit594.processor.*;
import edu.upenn.cit594.ui.Presentation;


public class Main {
	public static void main(String[] args) {

	try {
	
	State_Reader s = new CSV_State_Reader(args[1]);
	
	Tweet_Reader r = null;

	if(args[0].contains(".json")) {
		r = new Json_Tweet_Reader(args[0]);
	}else if(args[0].contains(".txt")){
		
		r = new Text_Tweet_Reader(args[0]);
	}
	
	Logging.name = args[2];
	
	Processor pro = new Processor(r,s);
	Presentation u = new Presentation(pro);
	u.printresult();
	} catch(Exception e){
		
		throw new IllegalStateException(e);
		
	} 
	
	
	
	}
}
