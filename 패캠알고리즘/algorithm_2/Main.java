package step14;

public class Main {
	public static void main(String args[]) {
		int[] numbers = {12,25,31,48,54,66,70,83,95,100};
		
		int target = 83;
		int left = 0;
		int right = numbers.length-1;
		int mid = (left+right) /2;
		
		int temp = numbers[mid];
		boolean flag = false;
		
		while(left <= right) {
			if(target == temp) {
				flag = true;
				break;
			}else if(target < temp) {
				right = mid -1;
			}else {
				left = mid+1;
			}
			mid = (left+right)/2;
			temp = numbers[mid];
		}
		if(flag == true) {
			System.out.println("찾는 수는"+(mid+1)+"번째 있습니다.");
		}else {
			System.out.println("찾을 수 없습니다.");
		}
	}
}
