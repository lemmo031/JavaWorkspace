import static org.junit.Assert.*;

import javax.crypto.AEADBadTagException;

import org.junit.Test;


public class SomeJavaTesting {

	@Test
	public void test() {
		assertTrue(true);
	}

	@Test
	public void byteRollover() {
		byte myByte = 127;
		myByte++;
		assertEquals(-128, myByte);
	}
	
	@Test
	public void byteMultiplicationRollover() {
		byte myByte = 64;
		myByte *= 2;
		assertEquals(-128, myByte);
	}
	
	@Test
	public void shortRollover() {
		short myShort = -32768;
		myShort--;
		assertEquals(32767, myShort);
	}
	
	@Test
	public void intRollover() {
		int myInt = 2147483647;
		myInt++;
		assertEquals(-2147483648, myInt);
	}
	
	@Test
	public void longRollover() {
		long myLong = 9223372036854775807L;
		myLong++;
		assertEquals(-9223372036854775808L, myLong);
	}
	
	@Test
	public void upConvert() {
		byte myByte = 5;
		short myShort = myByte;
		int myInt = myShort;
		long myLong = myInt;
		assertEquals(5, myLong);
	}
	
//	@Test
//	public void cantDownConvert() {
//		int myInt = 5;
//		short myShort = myInt;
//	}
	
//	@Test
//	public void cantDownCovertToByte() {
//		byte myByte = 2349087;
//	}
	
//	@Test
//	public void stillCantDownConvertToByte() {
//		//byte myByte = 128;
//	}
	
	
}
