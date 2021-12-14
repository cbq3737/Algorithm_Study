package step13_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class num_14425 {//문자열 집합
	public static void main(String[] args) throws IOException {//map보단 Set을 이용하는게 효율적
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int nNum = Integer.parseInt(tk.nextToken());//N개의 문자열로 이루어짐
		int mNum = Integer.parseInt(tk.nextToken());//주어진 문자열 갯수
		
		Set<String> set = new HashSet<String>();
		for(int i=0;i<nNum;i++) {
			String str = br.readLine();
			set.add(str);
		}
		int cnt =0;
		for(int i=0;i<mNum;i++) {
			String str = br.readLine();
			if(set.contains(str)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
