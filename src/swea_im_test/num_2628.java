package swea_im_test;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class num_2628 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk= new StringTokenizer(br.readLine());
		int nNum = Integer.parseInt(tk.nextToken());
		int mNum = Integer.parseInt(tk.nextToken());
		int tc = Integer.parseInt(br.readLine());
		List<Integer> row = new ArrayList<>();
		List<Integer> col = new ArrayList<>();
		col.add(nNum);
		row.add(mNum);
		for(int t=0;t<tc;t++) {
			tk = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(tk.nextToken());
			int num = Integer.parseInt(tk.nextToken());
			if(dir == 0) {
				row.add(num);
			}else {
				col.add(num);
			}
		}
		col.add(0);
		row.add(0);
		Collections.sort(col);
		Collections.sort(row);
		int w =0;
		int h =0;
		for(int i=1;i<col.size();i++) {
			w = Math.max(col.get(i)-col.get(i-1), w);
		}
		for(int i=1;i<row.size();i++) {

			h = Math.max(row.get(i)-row.get(i-1), h);
		}
		System.out.println(w*h);
	}
}
