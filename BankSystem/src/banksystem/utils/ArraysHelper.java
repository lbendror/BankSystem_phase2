package banksystem.utils;

public class ArraysHelper {

	public static int getNextEmptyArrayIndex(Object[] array) {
		
		for (int i=0; i<array.length; i++) {
			if (array[i] == null) {
				return i;
			}
		}
		
		return -1;
	}
}
