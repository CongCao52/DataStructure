package HW3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Queue;
import java.util.Stack;

import org.junit.jupiter.api.Test;
import java.io.IOException;

class HtmlValidatorTest {

	@Test
	void testIsValidHtml() throws IOException {
		String test1 = "test1.html";
		String test2 = "test2.html";
		String test3 = "test3.html";
		String test4 = "test4.html";
		
		Queue<HtmlTag> queue = HtmlValidator.getTagsFromHtmlFile(test1);
		Stack<HtmlTag> stack = HtmlValidator.isValidHtml(queue);

		assertEquals(stack.size(),0);
		//assertTrue(stack.get(1).matches(stack.get(2)));
		

		
		queue = HtmlValidator.getTagsFromHtmlFile(test2);
		stack = HtmlValidator.isValidHtml(queue);

		assertEquals(stack.get(0).getElement(),"html");
		assertEquals(stack.get(1).getElement(),"b");
		assertEquals(stack.size(),2);

		
		
		queue = HtmlValidator.getTagsFromHtmlFile(test3);
		stack = HtmlValidator.isValidHtml(queue);

		assertEquals(stack.get(0).getElement(),"b");
		assertEquals(stack.get(1).getElement(),"i");
		assertEquals(stack.size(),2);
		
		
		queue = HtmlValidator.getTagsFromHtmlFile(test4);
		stack = HtmlValidator.isValidHtml(queue);

		assertEquals(stack.get(3).getElement(),"b");
		assertEquals(stack.get(2).getElement(),"p");
		assertEquals(stack.get(1).getElement(),"body");
		assertEquals(stack.get(0).getElement(),"html");
		assertEquals(stack.size(),4);
		/*
		queue = HtmlValidator.getTagsFromHtmlFile("test0.html");
		stack = HtmlValidator.isValidHtml(queue);

		//assertNull(stack);
		assertEquals(stack.size(),0);
		*/
		queue = HtmlValidator.getTagsFromHtmlFile("test7.html");
		stack = HtmlValidator.isValidHtml(queue);
		assertNull(stack);
		//assertNull(HtmlValidator.isValidHtml(queue));
		//assertEquals(stack.size(),0);
		
		
	
	}

}
