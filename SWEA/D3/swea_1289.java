
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//D3
public class swea_1289 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int nNum = Integer.parseInt(br.readLine());
		int index = 0;
		for (int i = 0; i < nNum; i++) {
			int cnt = 0;
			String num = br.readLine();
			for (int j = 0; j < num.length(); j++) {
				if (num.charAt(j) == '1') {
					index = j;
					break;
				}
			}
			cnt = check_bit(num, index, cnt);
			sb.append("#" + (i + 1)).append(" " + cnt + "\n");
		}
		System.out.println(sb);
	}

	public static int check_bit(String num, int index, int cnt) {
		char[] init = new char[num.length()]; // 인덱스 변경용
		for (int i = 0; i < num.length(); i++) {
			init[i] = '0';
		}
		String str = ""; // 비교용
		while (!str.equals(num)) {
			if (init[index] != num.charAt(index)) {
				cnt++;
				for (int i = index; i < num.length(); i++) {
					char c = num.charAt(index);
					init[i] = c;
				}
			}
			index++;
			str = new String(init);
		}
		return cnt;
	}
}
