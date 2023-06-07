package HW4;






import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.NoSuchElementException;



public class Analyzer {
	
	/*
	 * Implement this method in Part 1
	 */
	public static List<Sentence> readFile(String filename) {
		
		List<Sentence> s = new ArrayList<Sentence>();
		if(filename ==null) {return s;}
		File f =new File(filename); 
		
		Scanner scanbyfile;
		String line; 
		
		try {
			scanbyfile = new Scanner(f);
			while(scanbyfile.hasNextLine())
			{
				Sentence sen;
				String t; 
				int number;
				Scanner scanbyline; 
				line = scanbyfile.nextLine();
				scanbyline = new Scanner(line).useDelimiter(" ");
				
				
				try {
					number = Integer.parseInt(scanbyline.next().trim());
				
				if(number>=-2 && number <=2) {
						t = scanbyline.next().trim();
						while(scanbyline.hasNextLine()) {
							t = t+ " ";
							t = t + scanbyline.next();
						}	
						sen = new Sentence(number, t);
						s.add(sen);
					}
				else {continue;}
				}
			    catch(NumberFormatException e) {
				continue;}
				catch(NoSuchElementException e) {
					continue;
				}
			
				scanbyline.close();
			}		
			scanbyfile.close();
			return s;
		}
		catch(FileNotFoundException e) {return new ArrayList<Sentence>();}
	}
	/*
	 * Implement this method in Part 2
	 */
	public static Set<Word> allWords(List<Sentence> sentences) {
	Set<Word> theset = new HashSet<>();
	if(sentences ==null || sentences.isEmpty()||sentences.size()==0) {return theset;}
	HashMap<String,Word> wordm = new HashMap<>();
	
	for(Sentence s:sentences) {
		if (s ==null || s.getText().isEmpty()) {continue; }
		String[] splits = s.getText().split(" "); 
		for(String w :splits) {
			int num = s.getScore();
			w = w.toLowerCase();
			//the word should start with a letter
			if(Character.isLetter(w.charAt(0))==true){
			
			 int w_size = w.length();
			 
			if(Character.isLetter(w.charAt(w_size-1))==false) {
				w = w.substring(0, w_size-1);
			}
			
			Word word; 
			if (wordm.containsKey(w)) {
				word =wordm.get(w);
			}else {
				word = new Word(w);
			}
			word.increaseTotal(num);
			wordm.put(w, word);
			}
		}}
		for (String w1 : wordm.keySet()) {
			theset.add(wordm.get(w1));
			
		}
		return theset;
		
	}
	
	/*
	 * Implement this method in Part 3
	 */
	public static Map<String, Double> calculateScores(Set<Word> words) {
		Map<String, Double> scoremap = new HashMap<String, Double>();
		if(words == null || words.isEmpty()==true){
			return scoremap;
		}
		
		for(Word word : words){
			if(word != null){
			scoremap.put(word.getText(), word.calculateScore());
			}
		}
		return scoremap;
	}
	
	/*
	 * Implement this method in Part 4
	 */
	public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {
	if (wordScores == null || sentence == null || wordScores.isEmpty() || sentence.isEmpty() || wordScores.size()==0) {
			return 0.0;}
	
	double scores = 0.0;
	int num = 0;
	String[] sentence_split = sentence.split(" ");
	for(String w: sentence_split) {
		String w_low = w.toLowerCase();
		if(Character.isLetter(w.charAt(0))==true){
			num = num+1;
			int w_size = w_low.length();
			if(Character.isLetter(w_low.charAt(w_size-1))==false) {
				w_low = w_low.substring(0,w_size-1);
			}
		}
		if(wordScores.containsKey(w_low)) {
			scores = scores+wordScores.get(w_low);
		}
	}
	
	if(num ==0) {return 0.0;}    //no word in the string sentence
		
	return scores/(double)num;
		
	}

	/*
	 * You do not need to modify this code but can use it for testing your program!
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Please specify the name of the input file");
			System.exit(0);
		}
		String filename = args[0];
		System.out.print("Please enter a sentence: ");
		Scanner in = new Scanner(System.in);
		String sentence = in.nextLine();
		in.close();
		List<Sentence> sentences = Analyzer.readFile(filename);
		Set<Word> words = Analyzer.allWords(sentences);
		Map<String, Double> wordScores = Analyzer.calculateScores(words);
		double score = Analyzer.calculateSentenceScore(wordScores, sentence);
		System.out.println("The sentiment score is " + score);
	}
}