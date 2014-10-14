import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class Group4 {

	private static String inputFile;
	private static String outputFile;
	private static int numberOfLoops;
	private static double lambda;
	private static int n = 0;
	private static ArrayList<String> rawInput = new ArrayList<String>();
	private static EnhancedString[] data;


	public static void main(String[] args) throws IOException, InterruptedException {

		// Store command-line args
		inputFile = args[0];
		outputFile = args[1];
		numberOfLoops = Integer.parseInt(args[2]);

		// Get the input from the file
		Path inFile = Paths.get(inputFile);
		try (BufferedReader reader = Files.newBufferedReader(inFile)) {
			lambda = Double.parseDouble(reader.readLine());
			String line = null;
			while ((line = reader.readLine()) != null) {
				rawInput.add(line);
				n++;
			}
		}

		data = new EnhancedString[n];
		Thread.sleep(10);

		long startTime = System.currentTimeMillis();

		// Algorithm
		for (int loop = 0; loop < numberOfLoops; loop++) {
			for (int i = rawInput.size() - 1; i >= 0; i--) {
				data[i] = new EnhancedString(rawInput.get(i));
			}
//			Arrays.sort(data, new EverythingComparator());
			mergeSort(data, 0, data.length - 1, new EverythingComparator());
//			insertionSort(data, 0, data.length, new EverythingComparator());
//			QuickSort.sort(data, new EverythingComparator());
			
			
			
//			sedgeMergeSort(data, auxiliary, 0, data.length - 1, new EverythingComparator());
//			compareAll(data, new LengthComparator());
//			compareAll(data, new EverythingComparator());
//			Arrays.sort(data, new AlphabeticalComparator());
//			quickSort(data, 0, data.length - 1, new AlphabeticalComparator());
//			Arrays.sort(data, new LengthAndSumComparator());
//			quickSort(data, 0, data.length - 1, new SumOfOnesComparator());
//			quickSort(data, 0, data.length - 1, new LengthComparator());
//			quickSort(data, 0, data.length - 1, new EverythingComparator());
//			Arrays.sort(data, new AlphabeticalComparator());
//			insertionSort(data, 0, data.length, new AlphabeticalComparator());
//			Arrays.sort(data, new SumOfOnesComparator());
//			insertionSort(data, 0, data.length, new SumOfOnesComparator());
//			Arrays.sort(data, new LengthComparator());
//			insertionSort(data, 0, data.length, new LengthComparator());
		}
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		Path outFile = Paths.get(outputFile);
		try (BufferedWriter writer = Files.newBufferedWriter(outFile)) {
			for (EnhancedString line : data) {
				writer.write(line.binaryString);
				writer.newLine();
			}
		}
	}


	private static <T> void mergeSort(T[] array, int lowIndex, int highIndex, Comparator<T> comparator) {
		T[] temp = array.clone();
		mergeSort(array, temp, lowIndex, highIndex, comparator);
	}


	private static <T> void mergeSort(T[] array, T[] temp, int lowIndex, int highIndex, Comparator<T> comparator) {
		/* Doesn't really make it faster */
//		if (highIndex <= lowIndex + 12) {
//			insertionSort(array, lowIndex, highIndex + 1, comparator);
//			return;
//		}
		if (highIndex <= lowIndex) {
			return;
		}
		int midIndex = (lowIndex + highIndex) / 2;
		mergeSort(temp, array, lowIndex, midIndex, comparator);
		mergeSort(temp, array, midIndex + 1, highIndex, comparator);
		merge(array, temp, lowIndex, midIndex, highIndex, comparator);
	}


	private static <T> void merge(T[] array, T[] temp, int lowIndex, int midIndex, int highIndex, Comparator<T> comparator) {
		int i = lowIndex;
		int j = midIndex + 1;
		for (int k = lowIndex; k <= highIndex; k++) {
			if (i > midIndex) {
				array[k] = temp[j++];
			} else if (j > highIndex) {
				array[k] = temp[i++]; 
			} else if (comparator.compare(temp[j], temp[i]) < 0) {
				array[k] = temp[j++];
			} else {
				array[k] = temp[i++]; 
			}
		}
	}

//	public static <T> void quickSort(T[] array, int startIndex, int endIndex, Comparator<T> comparator) {
//		if (startIndex < endIndex) {
//			int pivot = partition(array, startIndex, endIndex, comparator);
//			quickSort(array, startIndex, pivot - 1, comparator);
//			quickSort(array, pivot + 1, endIndex, comparator);
//		}
//	}
//
//	private static <T> int partition(T[] array, int startIndex, int endIndex, Comparator<T> comparator) {
//		T key = array[endIndex];
//		int i = startIndex - 1;
//		for (int j = startIndex; j < endIndex; j++) {
//			if (comparator.compare(array[j], key) <= 0) {
//				i++;
//				T temp = array[i];
//				array[i] = array[j];
//				array[j] = temp;
//			}
//		}
//		T temp = array[i + 1];
//		array[i + 1] = array[endIndex];
//		array[endIndex] = temp;
//		return i + 1;
//	}


	
//	private static void sedgeMergeSort(EnhancedString[] array, EnhancedString[] auxiliary, int startIndex, int endIndex) {
//		if (endIndex <= startIndex) {
//			return;
//		}
//		int midIndex = (startIndex + endIndex) / 2;
//		sedgeMergeSort(auxiliary, array, startIndex, midIndex);
//		sedgeMergeSort(auxiliary, array, midIndex + 1, endIndex);
//		sedgeMerge(array, auxiliary, startIndex, midIndex, endIndex);
//
//	}

//	private static void sedgeMerge(EnhancedString[] array, EnhancedString[] auxiliary, int startIndex, int midIndex, int endIndex) {
//		int i = startIndex;
//		int j = midIndex + 1;
//		for (int k = startIndex; k <= endIndex; k++) {
//			if (i > midIndex) {
//				auxiliary[k] = array[j++];
//			} else if (j > endIndex) {
//				auxiliary[k] = array[i++];
//			} else if ()
//		}
//	}


	// Just used for testing, makes n! comparisons
//	private static <T> void compareAll(T[] array, Comparator<T> comparator) {
//		for (int i = 0; i < array.length - 1; i++) {
//			for (int j = i + 1; j < array.length; j++) {
//				int comparison = comparator.compare(array[i], array[j]);
//			}
//		}
//	}



	// endIndex is exclusive
	public static <T> void insertionSort(T[] array, int startIndex, int endIndex, Comparator<T> comparator) {
		for (int j = startIndex + 1; j < endIndex; j++) {
			T key = array[j];
			int i = j - 1;
			while (i > startIndex - 1 && comparator.compare(array[i], key) > 0) {
				array[i + 1] = array[i--];
			}
			array[i + 1] = key;
		}
	}
}