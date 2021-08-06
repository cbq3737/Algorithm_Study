import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_3499 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < tc; t++) {
			int nNum = Integer.parseInt(br.readLine());
			String[] str1;
			String[] str2;
			int bound = 0;
			if (nNum % 2 == 0) {
				bound = nNum / 2;
			} else {
				bound = nNum / 2 + 1;
			}
			str1 = new String[bound];
			str2 = new String[bound];
			StringTokenizer tk = new StringTokenizer(br.readLine());
			for (int i = 0; i < nNum; i++) {
				if (str1.length > i) {
					str1[i] = tk.nextToken();
				} else {
					str2[i - bound] = tk.nextToken();
				}
			}
			sb.append("#" + (t + 1) + " ");
			for (int i = 0; i < bound; i++) {
				if (str1[i] != null) {
					sb.append(str1[i] + " ");
				}
				if (str2[i] != null) {
					sb.append(str2[i] + " ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
