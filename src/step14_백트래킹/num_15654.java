package step13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class num_15654 {
	public static int nNum;
	public static int[] arr;
	public static int[] array;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		nNum = Integer.parseInt(tk.nextToken());
		int mNum = Integer.parseInt(tk.nextToken());
		array = new int[nNum];
		tk = new StringTokenizer(br.readLine());
		for(int i=0;i<nNum;i++) {
			array[i] = Integer.parseInt(tk.nextToken());
		}
		Arrays.sort(array);
		makeCombi(0,new int[mNum],new boolean[nNum]);
	}
	public static void makeCombi(int isSelect,int[] selected,boolean[] visited) {
		if(isSelect==selected.length) {
			for(int i=0;i<selected.length;i++) {
				System.out.print(selected[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=0;i<array.length;i++) {
			if(!visited[i]) {
				selected[isSelect]= array[i];
				visited[i] = true;
				makeCombi(isSelect+1,selected,visited);
				visited[i] = false;
			}
		}
	}
}
