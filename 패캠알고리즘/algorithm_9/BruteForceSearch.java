package step15;

public class BruteForceSearch {

	public static void main(String[] args) {
		int[] bills = { 1, 2, 5, 10, 20, 50 };

		int count = 0;
		int money = 100;

		for (int i0 = money; i0 >= 0; i0 -= bills[0]) {
			for (int i1 = i0; i1 >= 0; i1 -= bills[1]) {
				for (int i2 = i1; i2 >= 0; i2 -= bills[2]) {
					for (int i3 = i2; i3 >= 0; i3 -= bills[3]) {
						for (int i4 = i3; i4 >= 0; i4 -= bills[4]) {
							if (i4 % bills[5] == 0) {
								count++;
							}
						}
					}
				}
			}
		}
		
		System.out.println("지불 가능한 가지 수: "+count);
	}

}
