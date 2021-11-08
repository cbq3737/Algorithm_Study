package step12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class num_18870 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[nNum];
		StringTokenizer tk = new StringTokenizer(br.readLine());
		for(int i=0;i<nNum;i++) {
			arr[i] =  Integer.parseInt(tk.nextToken());
		}
		
		int[] sortNums = arr.clone();
		Arrays.sort(sortNums);
		
		Map<Integer,Integer> map = new HashMap<>();
		
		int idx =0;
		for(int i=0;i<sortNums.length;i++) {
			if(!map.containsKey(sortNums[i])) {
				map.put(sortNums[i],idx++);
			}
		}
		for(int i=0;i<nNum;i++) {
			sb.append(map.get(arr[i])).append(' ');
		}
		System.out.println(sb.toString());
		
	}
}
