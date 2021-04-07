package step7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num_1157 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().toLowerCase();
		Character strArray[] = new Character[26];
		int[] countArray = new int[26];
		int max = -1;
		int array_num=0;
		int count=0;
		for(int i=0;i<strArray.length;i++) {
			strArray[i]=(char)('a'+i);
			countArray[i] = 0;
			for(int j=0;j<str.length();j++) {
				if(strArray[i]==str.charAt(j)) {
					++countArray[i];
				}
			}
			if(max<countArray[i]) {
				max= countArray[i];
				array_num=i;
			}
		}
		for(int i=0;i<countArray.length;i++) {
			if(max==countArray[i]) {
				++count;
			}
		}
		if(count>=2) {
			System.out.println("?");
		}
		else {
			System.out.println(Character.toUpperCase(strArray[array_num]));
		}
	}
}
