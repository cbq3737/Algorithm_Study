package step14;

public class Main {

	public static void insertionSort(int[] numbers, int size) {
		int temp = 0;
		for (int i = 1; i < size; i++) {
			temp = numbers[i];
			int j = i;
			while ((j > 0) && numbers[j - 1] > temp) {
				numbers[j] = numbers[j - 1];
				numbers[j - 1] = temp;
				j = j - 1;
			}
			System.out.println("반복 - " + i);
			for (int k = 0; k < size; k++) {
				System.out.print(numbers[k] + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String args[]) {
		int[] numbers = { 80, 50, 70, 10, 60, 20, 40, 30 };

		insertionSort(numbers, numbers.length);

	}
}