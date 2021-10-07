package step13_map;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class num_1269 {//대칭차집합
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int nNum = Integer.parseInt(tk.nextToken());
		int mNum = Integer.parseInt(tk.nextToken());
		HashMap<Integer,Integer> hmap = new HashMap();
		int over = 0;
		tk = new StringTokenizer(br.readLine());
		for(int i=0;i<nNum;i++) {//첫번째꺼 넣어주기
			hmap.put(Integer.parseInt(tk.nextToken()),1);
		}
		tk = new StringTokenizer(br.readLine());
		for(int i=0;i<mNum;i++) {
			int key= Integer.parseInt(tk.nextToken());
			if(hmap.containsKey(key)) {
				over++;
			}else {				
				hmap.put(key,1);
			}
		}
		System.out.println(hmap.size()- over);
	}
}
