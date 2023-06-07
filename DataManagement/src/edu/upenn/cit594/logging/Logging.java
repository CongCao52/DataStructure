package edu.upenn.cit594.logging;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logging {
public static String name; 
private PrintWriter p; 
private static Logging start; 

public static Logging getstart() {
	if (start == null) { start = new Logging();}
	
	
	try {
		start.p = new PrintWriter(new FileWriter(name,false));
			
			
	}catch(IOException error) {
		error.printStackTrace();
	}
	
	return start;
}

public void printlog(String s) {
	p.println(s);
	p.flush();
	
}	
}

