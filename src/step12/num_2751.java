package step12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class num_2751 {
	public static void merge_sort() {
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<nNum;i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(list);
		for(int i=0;i<list.size();i++) {
			sb.append(list.get(i)+"\n");
		}
		System.out.println(sb);
	}
}
