// Dalton Gus
public class BigBinary {
//	
	private int[] value;
	private int length;
	private int sumOfOnes;
	private String binaryString;
//	
	public BigBinary(String input) {
		binaryString = input;
		length = input.length();
		// 32 bits per int
		int chunks = (length + 31)/32; // Basically divides by 32 and rounds up
		value = new int[chunks];
		// Filling up value one int (32 bits) at a time.
		for (int i = chunks - 1; i >= 0; i--) {
			int chunkSize = Math.min(input.length(), 32);
			String subString = input.substring(input.length() - chunkSize); // gets the last chunkSize characters in input
			value[i] = Integer.parseUnsignedInt(subString, 2);
			input = input.substring(0, input.length() - chunkSize); // chop off end of string for next iteration
		}
		// Figure out sumOfOnes
		for (int i : value) {
			sumOfOnes += Integer.bitCount(i);
		}
	}

	public int getSumOfOnes() {
		return sumOfOnes;
	}
	
	public String toString() {
		return binaryString;
	}

	public int getValBefore(int rightOffset, int numberOfDigits) {
		if (rightOffset >= binaryString.length()) {
			return 0;
		}
		int endIndex = binaryString.length() - rightOffset;
		numberOfDigits = Math.min(numberOfDigits, endIndex);
		String subString = binaryString.substring(rightOffset - numberOfDigits, rightOffset);
		return Integer.parseUnsignedInt(subString, 2);
	}
}