package step13_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;

public class num_1302 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nNum = Integer.parseInt(br.readLine());
		HashMap<String,Integer> hmap = new HashMap<String, Integer>();
		for(int i=0;i<nNum;i++) {
			String title = br.readLine();
			if(hmap.containsKey(title)) {
				hmap.put(title, hmap.get(title)+1);
			}else {
				hmap.put(title,1);
			}
		}
		Set<String> str = hmap.keySet();
		
		String max_title="";
		int max =0;
		for(String title:str) {
			int cnt = hmap.get(title);
			if(max<=cnt) {
				if(max_title=="") {
					max_title= title;
				}else {
					if(max==cnt) {						
						max_title = max_title.compareTo(title)>0?title:max_title;
					}else {
						max_title = title;
					}
				}
				max = cnt;
			}
		}
		System.out.println(max_title);
	}
}
