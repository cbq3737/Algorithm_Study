package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class jungol_1205 {
	public static int joker_num;
	public static boolean[] cards = new boolean[1000001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int kNum = Integer.parseInt(br.readLine());
		StringTokenizer tk= new StringTokenizer(br.readLine());
		for(int i=0;i<kNum;i++) {
			int num = Integer.parseInt(tk.nextToken());
			if(num==0) {
				joker_num++;
			}else {
				cards[num]=true;				
			}
		}
		int length = 0;
		int max_length = joker_num;
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1;i<cards.length;i++) {
			if(cards[i]) {
				length++;
			}else {
				if(queue.size()<joker_num) {//사용한 조커가 없으면, 아직 조커를 사용하지않았다는 의미
					length++;
					queue.offer(i);
				}else {
					if(!queue.isEmpty()) {
						length = i-queue.poll();
						queue.offer(i);
					}else {
						length=0;
					}
				}
			}
			max_length = Math.max(length, max_length);
		}
		System.out.println(max_length);
	}
}
