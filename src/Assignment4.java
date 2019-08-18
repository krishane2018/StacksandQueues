import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Arrays;

public class Assignment4 {

	private static <T extends Comparable<? super T>> int indexOfLargest(T[] theArray, int n) {
		int largestIndex = 0; 										// returns the index of the
		for (int i = 1; i < n; i++) { 								// largest element in the array
			if (theArray[i].compareTo(theArray[largestIndex]) > 0) {
				largestIndex = i;
			}
		}
		return largestIndex;
	}

	public static <T extends Comparable<? super T>> 
	void recursiveSelectionSort(T[] theArray, int n) {
		if (n < 2) { 								// if the array size is less than 2, the array
			return; 								// is already sorted
		}
		int largest = indexOfLargest(theArray, n);  // otherwise find the largest element in the
		T temp = theArray[largest]; 				// array and swap it with the n-1 element in
		theArray[largest] = theArray[n - 1]; 		// the array (starting at the end of the
		theArray[n - 1] = temp; // array)
		recursiveSelectionSort(theArray, n - 1);
	}

	public static <T extends Comparable<? super T>> void recursiveBubbleSort(T[] theArray, int n) {
		boolean sorted = true; 								// Makes multiples passes through the
		int currentIndex = n - 1; 							// array and swaps elements depending on
		int nextIndex = n - 2; 								// if the current element is greater
															// than the next element
		
		for (int i = 0; i < n - 1; i++) { 					
			if (theArray[i].compareTo(theArray[i + 1]) > 0) { // If no swaps are made in a pass,
				T temp = theArray[currentIndex]; 			  // then the array is deemed sorted
				theArray[currentIndex] = theArray[nextIndex];
				theArray[nextIndex] = temp;
				sorted = false;
			}
			System.out.println(Arrays.toString(theArray));
		}
		
		
		if (sorted) {
			return;
		}
		recursiveBubbleSort(theArray, n - 1);
	}

	public static boolean isInLanguage(String str) {

		Queue<Character> thisQueue = new LinkedList<Character>();
		Stack<Character> thisStack = new Stack<Character>();

		boolean isEqual = true;
		int isDollar = 0;
		char queueFront;
		char stackTop;

		if (str.equals("$")) {
			return true; 							// known case
		}

		for (int i = 0; i < str.length(); i++) {
			thisQueue.add(str.charAt(i)); 			// adds string to queue and stack while keeping
			thisStack.push(str.charAt(i)); 			// track of how many $ characters are in the
			if (str.charAt(i) == '$') { 			// string
				isDollar++;
			}
		}
		if (isDollar != 1) {						// if there are more/less than one $ character
			return false; 							// in the string, then the string is not in the
		} 											// language

		while ((!thisQueue.isEmpty()) && isEqual) { // if the word is spelled the same backwards as
			queueFront = thisQueue.remove(); 		// forwards, it is in the language. Thus,
			stackTop = thisStack.pop(); 			// popping/removing from stack should always be
			if (queueFront != stackTop) { 			// equal to each other. Otherwise, the word
				isEqual = false; 					// the word is not in the language.
			}
		}
		return isEqual;
	}

	public static long convertToNumber(String str) {
		char currentChar;
		long num = 0;
		Queue<Integer> thisQueue = new LinkedList<Integer>();
		for (int i = 0; i < str.length(); i++) {
			currentChar = str.charAt(i); 				// adds character into queue if it is not a
			if (currentChar != ' ') { 					// space
				thisQueue.add(Character.getNumericValue(str.charAt(i)));
			}
		}
		while (!(thisQueue.isEmpty())) {	// adds numbers together to get desired final integer
			num *= 10;
			num += (thisQueue.remove());

		}
		return num;
	}

}
