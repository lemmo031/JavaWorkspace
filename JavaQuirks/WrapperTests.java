import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.Test;


public class WrapperTests {

	@Test
	public void testBYTES() {
		assertEquals(4, Integer.BYTES);
	}

	@Test
	public void testSIZE() {
		assertEquals(32, Integer.SIZE);
	}
	
	@Test
	public void testNameTYPE() {
		assertEquals(int.class, Integer.TYPE);
	}
	
	@Test (expected = Error.class)
	public void testStringConstructor() {
		assertEquals(5, new Integer("5"));
	}
	
	@Test
	public void testStringConstructorAgain() {
		assertEquals(new Integer(5), new Integer("5"));
	}
	
	@Test
	public void testStringConstructorYetAgain() {
		assertEquals(new Integer(20), new Integer("020")); //same as parseInt for radix 10
	}
	
	@Test
	public void testStringPooling() {
		String first = "hi";
		String second = "hi";
		assertTrue(first == second);
		String third = String.valueOf('h') + String.valueOf('i'); // doesn't get pooled
		String fourth = new String("hi"); // doesn't get pooled
		assertFalse(first == third);
		assertFalse(first == fourth);
	}
	
	@Test
	public void testIntegerPooling() {
		Integer first = 1;
		Integer second = 1;
		assertTrue(first == second);
		Integer third = new Integer(1); // doesn't get pooled
		int i = 1;
		Integer fourth = 0 + 1; // gets pooled, since autoboxing occurs and fits in a byte
		assertFalse(first == third);
		assertTrue(first == fourth);
		Integer fifth = 128; // not pooled, over 127
		Integer sixth = 128;
		assertFalse(fifth == sixth);
	}
	
	@Test
	public void testBoxing() {
		Integer first = 5;
		int i = 1;
		Integer second = i;
		List<Integer> myList = new ArrayList<Integer>();
		
		
		
	}
}