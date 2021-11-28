package step19_큐_덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class num_5430 { // AC
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Deque<Integer> queue = new LinkedList(); // 기존 배열
		for (int i = 0; i < tcase; i++) {
			String oper = br.readLine();// 함수 명령어
			int nNum = Integer.parseInt(br.readLine());
			if (nNum > 0) {//비어있지않은 배열을 파싱할 때
				String[] str = br.readLine().split(",|[|]");
				for (int j = 0; j < str.length; j++) {
					if (j == 0 || j == str.length - 1) {
						str[j] = str[j].replace("[", "");
						str[j] = str[j].replace("]", "");
					}
					queue.offer(Integer.parseInt(str[j]));
				}
			}else {//빈 것일때
				br.readLine();
			}
			boolean flag = false;
			boolean reverse = false;//true면 뒤에꺼 삭제, false면 앞에꺼 삭제
			for (int j = 0; j < oper.length(); j++) {
				char c = oper.charAt(j);
				if (c == 'R') {// 거꾸로
					reverse = !reverse;
				} else if (c == 'D') {// 앞에꺼 하나 버리기
					if (queue.size() > 0) {
						if(reverse) {//뒤바뀐 상태
							queue.removeLast();							
						}else {//원래 상태
							queue.removeFirst();
						}
					} else {// 에러
						sb.append("error" + "\n");
						queue.clear();
						flag = true;
						break;
					}
				}
			}
			if (!flag) {
				sb.append("[");
				int size = queue.size();
				if(reverse) {//뒤바뀐 상태
					for (int j = 0; j < size - 1; j++) {
						sb.append(queue.pollLast() + ",");
					}
				}else {					
					for (int j = 0; j < size - 1; j++) {
						sb.append(queue.poll() + ",");
					}
				}
				if (queue.size() > 0) {
					sb.append(queue.poll());
				}
				sb.append("]" + "\n");
			}
		}
		System.out.println(sb);
	}
}
