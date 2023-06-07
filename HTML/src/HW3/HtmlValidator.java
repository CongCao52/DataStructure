package HW3;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.Queue;
import java.util.Stack;

public class HtmlValidator {
	
	/* 
	 * Implement this method!
	 */
	

	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {
		   HtmlTag ta =tags.peek();
	       Stack<HtmlTag> s = new Stack<HtmlTag>();
			
			while(!tags.isEmpty()){
				ta = tags.remove();
				if(ta.isSelfClosing()==true){ continue;} 
				else if(ta.isOpenTag()==true){ s.push(ta);} 
				else { 
					if(s.isEmpty()==true){ return null;} 
					else if(ta.matches(s.peek())==true){s.pop();} 
					else{return s;}
				}
			}
			return s;
		}	
	


	
			
			

	
	/*
	 * Instructor-provided code:
	 * This function reads an HTML file and outputs its structure as the HtmlTags only.
	 * You do not need to modify this code for this assignment but can use it for your testing!
	 */
	public static Queue<HtmlTag> getTagsFromHtmlFile(String filename) throws IOException {
	     InputStream stream = new FileInputStream(filename);
	     StringBuffer buffer = new StringBuffer();
	     int ch;
	     while ((ch = stream.read()) > 0) {
	         buffer.append((char) ch);
	     }
	     stream.close();
	     String htmlFileString = buffer.toString();
	     return HtmlTag.tokenize(htmlFileString);
	}

}
