package step11_브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class num_2309 {
	static int[] real_dwarf= new int[7];
	static int idx= 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int[] dwarf = new int[9];
			
			boolean[] flag = new boolean[9];
			for(int i=0;i<9;i++) {
				dwarf[i] =Integer.parseInt(br.readLine());
			}
		
			dwarfCheck(dwarf,flag,0,0);
			Arrays.sort(real_dwarf);
			for(int i=0;i<7;i++) {
				System.out.println(real_dwarf[i]);
			}
	}
	public static void dwarfCheck(int[] dwarf,boolean[] flag,int weight, int count) {
		if(count ==7) {
			if(weight==100 && idx!=7) {				
				for(int i=0;i<9;i++) {
					if(flag[i]) {
						real_dwarf[idx++] = dwarf[i];
					}
				}
				return;
			}
			else return;
		}
		
		for(int i=0;i<9;i++) {
			if(!flag[i]) {				
				flag[i] = true;
				dwarfCheck(dwarf,flag,weight+dwarf[i],count+1);
				flag[i] = false;
			}
		}
	}
}
