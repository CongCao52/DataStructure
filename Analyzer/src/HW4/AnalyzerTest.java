package HW4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

class AnalyzerTest {

	
	@Test
	void testReadFile() {
		
		List<Sentence> sentences = Analyzer.readFile("test1.txt");
		
		
		
		assertEquals(sentences.size(),5);
		assertEquals(sentences.get(0).getText(),"A series of escapades demonstrating the adage that what is good for the goose is also good for the gander , some of which occasionally amuses but none of which amounts to much of a story .");
		assertEquals(sentences.get(1).getText(),"This quiet , introspective and entertaining independent is worth seeking .");
	
		assertEquals(sentences.get(0).getScore(),-1);
		assertEquals(sentences.get(1).getScore(),2);
		
		sentences = Analyzer.readFile("23231.txt");
		assertTrue(sentences.isEmpty());
		
		sentences = Analyzer.readFile(null);
		assertTrue(sentences.isEmpty());
		
		sentences = Analyzer.readFile("test0.txt");
		//assertEquals(sentences.size(),1);
		assertTrue(sentences.isEmpty());
	
	}


	@Test
	void testAllWords() {
		List<Sentence> sentences = Analyzer.readFile("test2.txt");
		assertEquals(sentences.size(),7);
	
		Set<Word> words = Analyzer.allWords(null);
		assertTrue(words.isEmpty());

		
		//sentences = new ArrayList<Sentence>();
		sentences = Analyzer.readFile("test3.txt");
		sentences.add(null);
		
		List<Sentence> sentences2 = new ArrayList<Sentence>();
		sentences2.add(null);
		sentences2.add(sentences.get(0));
		
		words = Analyzer.allWords(sentences2);
		assertEquals(words.size(),1);
		
		sentences = Analyzer.readFile("test2.txt");
		words = Analyzer.allWords(sentences);
		for (Word word: words) {
			if (word.text.equals("fun")) {
				assertEquals(word.count,8);
				assertEquals(word.total,7);
			}
		}
		
	}

	@Test
	void testCalculateScores() {
		List<Sentence> sentences = Analyzer.readFile("test2.txt");
		Set<Word> words = Analyzer.allWords(sentences);
		Map<String, Double> scoreMap = Analyzer.calculateScores(words);
		for (Word word: words) {
			if (word.text.equals("fun")) {
				assertEquals(scoreMap.get(word.text),0.875);
			}
		}
		
		sentences = Analyzer.readFile("test3.txt");
		words = Analyzer.allWords(sentences);
		scoreMap = Analyzer.calculateScores(words);
		for (Word word: words) {
			if (word.text.equals("car")) {
				assertEquals(scoreMap.get(word.text),0.25);
			}
			if (word.text.equals("bad")) {
				assertEquals(scoreMap.get(word.text),0);
			}
		}
		
	}

	@Test
	void testCalculateSentenceScore() {
		List<Sentence> sentences = Analyzer.readFile("test4.txt");
		Set<Word> words = Analyzer.allWords(sentences);
		Map<String, Double> scoreMap = Analyzer.calculateScores(words);
		
		double score = Analyzer.calculateSentenceScore(scoreMap, "Happy positive");
		assertEquals(score,1.5);
		
		score = Analyzer.calculateSentenceScore(scoreMap, "Happy happy days");
		assertEquals(score, 0.666666, 0.0001);
		
		score = Analyzer.calculateSentenceScore(scoreMap, "Positive sad");
		assertEquals(score,0.5);
		
		score = Analyzer.calculateSentenceScore(scoreMap, "Positively sad");
		assertEquals(score,-0.5);
		
		score = Analyzer.calculateSentenceScore(scoreMap, "$!$ #$@ 2 1 3");
		assertEquals(score,0,0);
		
		
	}

}
