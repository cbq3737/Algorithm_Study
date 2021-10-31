package step6_함수;

public class num_4673 {
	
	public static int self_Num(int num) {
		int sum = num;
		while(num!=0) {
			sum = sum+(num%10);
			num = num/10;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Boolean[] bl = new Boolean[10001];
		for(int i=1;i<10001;i++) {
			int num = self_Num(i);
			if(num<10001) {				
				bl[num]=true;
			}
		}
		for(int i=1;i<10001;i++) {
			if(bl[i]==null) {
				System.out.println(i);	
			}
		}
	}
}
