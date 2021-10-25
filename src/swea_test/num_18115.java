package swea_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class num_18115 {//카드 놓기
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int nNum = Integer.parseInt(br.readLine());
		int[] oper = new int[nNum];//기술 배열
		Deque<Integer> deque = new LinkedList<Integer>();//처음 배열
		int[] arr = new int[nNum];//결과 배열
		StringTokenizer tk = new StringTokenizer(br.readLine());
		for(int i=0;i<nNum;i++) {
			arr[i] = (i+1);//결과 배열 수 채우기
			oper[i] = Integer.parseInt(tk.nextToken());
		}
		for(int i=0;i<nNum;i++) {
			int num = arr[i];
			int skill = oper[(nNum-1)-i];//기술을 반대로
			if(skill==1) {//맨위에 넣어줘야댐
				deque.addFirst(num);
			}else if(skill==2) {//두번째에 넣어주기
				int temp = deque.pollFirst();
				deque.addFirst(num);
				deque.addFirst(temp);
			}else if(skill==3) {//마지막에 넣어주기
				deque.addLast(num);
			}
		}
		int size = deque.size();
		for(int i=0;i<size;i++) {
			sb.append(deque.poll()+" ");
		}
		System.out.println(sb);
	}
}
