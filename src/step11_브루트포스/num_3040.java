package step11_브루트포스;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class num_3040 {
	public static int[] dwarf= new int[7];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[9];
		for(int i=0;i<arr.length;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		find_dwarf(arr,0,new int[7],0,0);
		for(int i=0;i<dwarf.length;i++) {
			System.out.println(dwarf[i]);
		}
	}
	public static void find_dwarf(int[] arr,int isSelect,int[] selected,int startIdx,int sum) {
		if(isSelect == 7) {
			if(sum==100) {
				for(int i=0;i<7;i++) {
					dwarf[i] = selected[i];
				}
			}
			return ;
		}
		for(int i=startIdx;i<arr.length;i++) {
			selected[isSelect] = arr[i];
			find_dwarf(arr,isSelect+1,selected,i+1,sum+arr[i]);
		}
	}
}
