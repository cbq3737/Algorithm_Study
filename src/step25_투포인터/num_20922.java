package step25_투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_20922 { //겹치는 건 싫어, 투포인터
	public static int[] check = new int[200001];
	public static int max =Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int nNum = Integer.parseInt(tk.nextToken()); //배열 갯수
		int kNum = Integer.parseInt(tk.nextToken()); //중복 갯수
		int[] arr = new int[nNum];
		tk = new StringTokenizer(br.readLine());
		for(int i=0;i<nNum;i++) {
			arr[i] = Integer.parseInt(tk.nextToken());
		}
		int start=0;
		int end =0;
		int cnt =0;//갯수
		while(true) {
		 if(end<nNum&&check[arr[end]]<kNum) {//end포인터가 범위를 넘지않고, 중복갯수 조건에 맞는다면
			 check[arr[end]]++;//중복 갯수 카운팅
			 end++;//end포인터
			 cnt++;//길이
		 }else if(end==nNum&&start==nNum) {//두 포인터 다 끝까지 다 갔다면
			 break;
		 }else {
			 check[arr[start]]--;//start포인터 중복개수 카운팅 빼기
			 start++;//스타트 포인터 한 칸 앞으로
			 cnt--;//길이 1빼주기
		 }
		 max = Math.max(max, cnt);
		}
		System.out.println(max);
	}
}
