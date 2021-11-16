package step16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class num_9375 {
	public static int cnt;
	public static String[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int nNum = Integer.parseInt(br.readLine());
		for(int i=0;i<nNum;i++) {
			Map<String,Integer> hmap = new HashMap<String, Integer>();
			int tcase= Integer.parseInt(br.readLine());
			arr = new String[tcase];
			for(int j=0;j<tcase;j++) {
				StringTokenizer tk = new StringTokenizer(br.readLine());
				tk.nextToken();
				String key = tk.nextToken();
				if(hmap.containsKey(key)) {
					hmap.put(key, hmap.get(key)+1);
				}else {
					hmap.put(key,1);
				}
			}
			int sum =1;
			List<String> list = new ArrayList<String>(hmap.keySet());
			for(int j=0;j<list.size();j++) {
				int value = hmap.get(list.get(j));
				sum*= (value+1);
			}
			sb.append(sum-1+"\n");
		}
		System.out.println(sb);
	}
}
