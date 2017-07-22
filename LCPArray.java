import java.util.Arrays;
import java.util.Scanner;

public class LCPArray {

	public static void main(String[] args) {
		String[] strings;
		Scanner scanner = new Scanner(System.in);
		int numberOfStrings = scanner.nextInt();
		strings = new String[numberOfStrings];
		for (int i = 0; i < strings.length; i++) {
			strings[i] = scanner.next();
		}
		int[] lcpArray = findLCPArray(strings);
		for (int i = 0; i < lcpArray.length; i++) {
			System.out.println(lcpArray[i]);
		}
		scanner.close();
	}

	public static int[] findLCPArray(String[] strings) {
		int[] lcpArray = null;
		if (strings != null) {

			// LCPArray
			lcpArray = new int[strings.length];

			// I use java built in library function to sort the string
			// lexicographically
			Arrays.sort(strings);

			for (int i = 0; i < strings.length - 1; i++) {
				String tempOne = strings[i];
				String tempTwo = strings[i + 1];
				int length = (tempOne.length() < tempTwo.length()) ? tempOne.length() : tempTwo.length();
				for (int j = 0; j < length; j++) {
					if (tempOne.charAt(j) == tempTwo.charAt(j)) {
						lcpArray[i + 1]++;
					} else {
						break;
					}
				}
			}
		}
		return lcpArray;
	}
}
