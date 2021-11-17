package step18_스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_9012 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());

		for (int i = 0; i < nNum; i++) {
			String str = br.readLine();
			int l_size = 0;
			int r_size = 0;
			boolean flag = true;
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == '(') {
					l_size++;
				} else {
					r_size++;
					if (l_size == 0) {
						flag = false;
					}

				}
				if (l_size > 0 && r_size > 0) {
					l_size--;
					r_size--;

				}
			}
			if (l_size > 0 || r_size > 0 || flag == false) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}
	}
}
