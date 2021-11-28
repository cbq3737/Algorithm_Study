package step18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class num_1966 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();
		for (int t = 0; t < tc; t++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			int nNum = Integer.parseInt(tk.nextToken());
			int mNum = Integer.parseInt(tk.nextToken());
			LinkedList<Integer> list = new LinkedList();
			tk = new StringTokenizer(br.readLine());
			for (int i = 0; i < nNum; i++) {
				list.offer(Integer.parseInt(tk.nextToken()));	
			}

			int cnt = 0;
			while (true) {
				boolean flag = false;
				for (int i = 1; i < list.size(); i++) {
					if (list.get(0) < list.get(i)) {				
							list.offer(list.poll()); // 뒤로 옮겨져버림.
							flag = true;
							if(mNum==0) {
								mNum = list.size()-1;
							}else {
								mNum-=1;
							}
							break;
					}
				}
				if(!flag) { //맨 앞이 가장 큰 애들
					cnt++;
					list.poll();
					if(mNum==0) { //mNum이 맨앞이라면
						break;
					}
					mNum-=1;
				}
			}
			sb.append(cnt+"\n");
		}
		System.out.println(sb);
	}

}
