package edu.upenn.cit594.datamanagement;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class CSV_State_Reader implements State_Reader 
{
	protected String filename;
	public CSV_State_Reader(String f) {
		filename = f;
	}

	@Override
	public List<states> getStates() {
		// TODO Auto-generated method stub
		Scanner S =null; 
		List<states> state= new ArrayList<states>();
		try {
			S = new Scanner(new File(filename)); 
			while(S.hasNextLine()) {
				String theline = S.nextLine();
				
				//
				String[] sentence = theline.split(",");
			    //states st = new states(Double.parseDouble(sentence[2]), Double.parseDouble(sentence[1]), sentence[0]);
				states st = new states(Double.parseDouble(sentence[1]), Double.parseDouble(sentence[2]), sentence[0]);
			    state.add(st);
			}
		}catch(FileNotFoundException error) {
			error.printStackTrace();	
		}
		return state;
	}
}
