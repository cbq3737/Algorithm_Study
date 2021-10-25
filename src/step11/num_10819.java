package step11;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num_10819 {//차이를 최대로
	public static int[] arr;
	public static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		arr = new int[nNum];
		StringTokenizer tk = new StringTokenizer(br.readLine());
		for(int i=0;i<nNum;i++) {
			arr[i] = Integer.parseInt(tk.nextToken());
		}
		max = Integer.MIN_VALUE;
		makePermutation(0,new int[nNum],new boolean[nNum]);
		System.out.println(max);
	}
	public static void makePermutation(int isSelect,int[] isselect,boolean[] visited) {
		if(isSelect==isselect.length) {
//			System.out.println(Arrays.toString(isselect));
			int cnt = check_sub(isselect);
			if(max<cnt) {
				max = cnt;
			}
			return;
		}
		for(int i=0;i<arr.length;i++) {
			if(!visited[i]) {
				isselect[isSelect] = arr[i];
				visited[i] = true;
				makePermutation(isSelect+1,isselect,visited);
				visited[i] = false;
			}
		}
	}
	public static int check_sub(int[] isselect) {
		int sum =0;
		for(int i=1;i<isselect.length;i++) {
			sum+=Math.abs(isselect[i-1]-isselect[i]);
		}
		return sum;
	}
	
}
