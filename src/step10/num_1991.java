package step10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class num_1991 {
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		List<char[]> list = new ArrayList();
		for (int i = 0; i <= nNum; i++) {
			list.add(new char[3]);
		}
		for (int i = 1; i <= nNum; i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine());
			char c = tk.nextToken().charAt(0);
			list.get((c - 'A') + 1)[0] = c;
			list.get((c - 'A') + 1)[1] = tk.nextToken().charAt(0);
			list.get((c - 'A') + 1)[2] = tk.nextToken().charAt(0);
		}
		preorder(1, list);
		sb.append("\n");
		inorder(1, list);
		sb.append("\n");
		postorder(1, list);
		System.out.println(sb);
	}

	public static void preorder(int current, List<char[]> list) {
		char c = list.get(current)[0];
		sb.append(c);
		if (list.get(current)[1] != '.') {
			preorder((list.get(current)[1] - 'A') + 1, list);
		}
		if (list.get(current)[2] != '.') {
			preorder((list.get(current)[2] - 'A') + 1, list);
		}
	}

	public static void inorder(int current, List<char[]> list) {
		char c = list.get(current)[0];
		if (list.get(current)[1] != '.') {
			inorder((list.get(current)[1] - 'A') + 1, list);
		}
		sb.append(c);
		if (list.get(current)[2] != '.') {
			inorder((list.get(current)[2] - 'A') + 1, list);
		}
	}

	public static void postorder(int current, List<char[]> list) {
		char c = list.get(current)[0];
		if (list.get(current)[1] != '.') {
			postorder((list.get(current)[1] - 'A') + 1, list);
		}
		if (list.get(current)[2] != '.') {
			postorder((list.get(current)[2] - 'A') + 1, list);
		}
		sb.append(c);
	}
}
