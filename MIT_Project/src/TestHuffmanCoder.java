import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;


public class TestHuffmanCoder {
		
	private Map<Character, Double> frequencies = new HashMap<Character, Double>();
	private Map<Character, String> expectedCodeTable = new HashMap<Character, String>();
	private String expectedTree = "(100.0,(40.0,(10.0,a)+(30.0,b))+(60.0,c))";
	private HuffmanCoder coder;

	@Before
	public void setUp() {
		frequencies.put('a', 10.0);
		frequencies.put('b', 30.0);
		frequencies.put('c', 60.0);
		expectedCodeTable.put('a', "00");
		expectedCodeTable.put('b', "01");
		expectedCodeTable.put('c', "1");
		coder = new HuffmanCoder(frequencies);
		}
	
	@Test (expected = RuntimeException.class)
	public void frequenciesDontAddTo100() {
		Map<Character, Double> badFrequencies = new HashMap<Character, Double>();
		frequencies.put('b', 10.0);
		frequencies.put('a', 10.0);
		frequencies.put('d', 10.0);
		new HuffmanCoder(badFrequencies);
	}
	
	@Test
	public void testGetCodeTable() {
		System.out.println(coder.getCodeTable().get('a'));
		System.out.println(coder.getCodeTable().get('b'));
		System.out.println(coder.getCodeTable().get('c'));
		assertEquals(expectedCodeTable, coder.getCodeTable());
	}
	
	@Test
	public void testGetTree() {
		System.out.println(coder.getTree());
		assertEquals(expectedTree, coder.getTree());
		
	}
	
	@Test
	public void testEncode() {
		String phrase = "cabcab";
		assertEquals("1000110001", coder.encode(phrase));
	}
	
	@Test
	public void testEncodeIllegalCharacter() {
		String phrase = "cab#cab";
		assertEquals("10001NO_ENCODING_FOUND10001", coder.encode(phrase));
	}
	
	@Test
	public void testDecode() {
		String codedMessage = "0001100011";
		assertEquals("abcabc", coder.decode(codedMessage));
	}
	
	// Bad input causes it to throw an Exception, sorry :(
	@Test (expected = StringIndexOutOfBoundsException.class)
	public void testDecodeBadInput() {
		String codedMessage = "0001100010";
		coder.decode(codedMessage);
	}

}
