package step13_map;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class num_19583 {//싸이버 개강총회
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input="";
		StringTokenizer tk = new StringTokenizer(br.readLine());
		String S = tk.nextToken();
		String E = tk.nextToken();
		String Q = tk.nextToken();
		Set<String> attend = new HashSet<>();//참여한 애들
		int cnt= 0;
		while((input=br.readLine())!= null) {//EOF처리
			String[] str = input.split(" ");
			if(str[0].compareTo(S)<=0) { //개강전
				attend.add(str[1]);
				
			}else if(str[0].compareTo(E)>=0&&str[0].compareTo(Q)<=0) {
				if(attend.contains(str[1])) {//개강시작후 스트리밍 전 이미 존재한다면					
					attend.remove(str[1]);//지워줌
					cnt++;
				}
			}
		}
		System.out.println(cnt);

		
	}
}
