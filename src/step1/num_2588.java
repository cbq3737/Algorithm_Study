package step1;

import java.util.Scanner;

public class num_2588 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int aNum = sc.nextInt();//472
			int bNum = sc.nextInt();//385
			int aresult = aNum *(bNum%10); 
			int bresult = aNum *((bNum/10)%10);
			int cresult = aNum *(bNum/100);
			int total = aresult+(bresult*10)+(cresult*100);
			
			System.out.println(aresult);
			System.out.println(bresult);
			System.out.println(cresult);
			System.out.println(total);
		}
		
	}
}
