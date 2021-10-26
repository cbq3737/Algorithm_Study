package step18;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class num_5430 { // AC
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Deque<Integer> queue = new LinkedList(); // 기존 배열
		for (int i = 0; i < tcase; i++) {
			String oper = br.readLine();// 함수 명령어
			int nNum = Integer.parseInt(br.readLine());
			Deque<Integer> new_queue = new LinkedList();// 새로운 배열
			if (nNum > 0) {
				String[] str = br.readLine().split(",|[|]");
				for (int j = 0; j < str.length; j++) {
					if (j == 0 || j == str.length - 1) {
						str[j] = str[j].replace("[", "");
						str[j] = str[j].replace("]", "");
					}
					queue.offer(Integer.parseInt(str[j]));
				}
			}else {
				String empty = br.readLine();
			}
			boolean flag = false;
			for (int j = 0; j < oper.length(); j++) {
				char c = oper.charAt(j);
				if (c == 'R') {// 거꾸로
					int size = queue.size();
					for (int d = 0; d < size; d++) {
						new_queue.addFirst(queue.poll());

					}
					for (int d = 0; d < size; d++) {
						queue.addLast(new_queue.poll());
					}
				} else if (c == 'D') {// 앞에꺼 하나 버리기
					if (queue.size() > 0) {
						queue.poll();
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
				for (int j = 0; j < size - 1; j++) {
					sb.append(queue.poll() + ",");
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
