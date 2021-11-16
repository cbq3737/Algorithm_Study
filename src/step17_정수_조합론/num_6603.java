package step16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_6603 {
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = -1;
		StringTokenizer tk = new StringTokenizer(br.readLine());
		while((num = Integer.parseInt(tk.nextToken()))!=0) {
			int[] arr = new int[num];
			for(int i=0;i<num;i++) {
				arr[i] = Integer.parseInt(tk.nextToken());
			}
			
			makeCombi(0,new int[num],0,arr);
			sb.append("\n");
			tk = new StringTokenizer(br.readLine());
		}
		System.out.println(sb);
	}
	public static void makeCombi(int isSelect,int[] select,int startIdx,int[] arr) {
		if(isSelect==6) {
			for(int i=0;i<6;i++) {
				sb.append(select[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=startIdx;i<arr.length;i++) {
			select[isSelect] = arr[i];
			makeCombi(isSelect+1,select,i+1,arr);
		}
	}
}
