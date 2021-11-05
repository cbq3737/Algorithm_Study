package step13_map;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class num_2776 {

	public static void main(String[] args) throws NumberFormatException, IOException {// 암기왕
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < tcase; t++) {
			int nNum = Integer.parseInt(br.readLine());
			Map<Integer, Integer> note1 = new HashMap();// 수첩1
			StringTokenizer tk = new StringTokenizer(br.readLine());
			for (int i = 0; i < nNum; i++) {
				note1.put(Integer.parseInt(tk.nextToken()), 1);
			}
			int mNum = Integer.parseInt(br.readLine());//수첩2
			tk = new StringTokenizer(br.readLine());
			for (int i = 0; i < mNum; i++) {
				int num = Integer.parseInt(tk.nextToken());
				if (note1.containsKey(num)) {
					sb.append(1 + "\n");
				} else {
					sb.append(0 + "\n");
				}
			}
		}
		System.out.println(sb);
	}
}


//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.Map;
//import java.util.StringTokenizer;
//
//public class Main{ //이진탐색
//	public static void main(String[] args) throws NumberFormatException, IOException {//암기왕
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int tcase = Integer.parseInt(br.readLine());
//		StringBuilder sb = new StringBuilder();
//		for(int t=0;t<tcase;t++) {
//			int nNum = Integer.parseInt(br.readLine());
//			int[] note1 = new int[nNum];
//			StringTokenizer tk = new StringTokenizer(br.readLine());
//			for(int i=0;i<nNum;i++) {
//				note1[i] = Integer.parseInt(tk.nextToken());
//			}
//			int mNum = Integer.parseInt(br.readLine());
//			Arrays.sort(note1);
//            //수첩2
//			tk = new StringTokenizer(br.readLine());
//			for(int i=0;i<mNum;i++) {
//				int num = Integer.parseInt(tk.nextToken());
//				sb.append(Arrays.binarySearch(note1, num)>=0?1:0).append("\n");
//			}
//		}
//		System.out.println(sb);
//	}
//}
