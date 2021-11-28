package step18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class num_1021 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int nNum = Integer.parseInt(tk.nextToken());
		int mNum = Integer.parseInt(tk.nextToken());
		ArrayList<Integer> list = new ArrayList();
		int sum =0;
		for(int i=1;i<=nNum;i++) {
			list.add(i);
		}
		tk = new StringTokenizer(br.readLine());
		for(int i=0;i<mNum;i++) {
			int loc= list.indexOf(Integer.parseInt(tk.nextToken()));
			while(true) {
				if(loc==0) {
					list.remove(0);
					break;
				}else if(loc <= list.size()/2){
					sum++;
					loc-=1;
					list.add(list.remove(0));
				}else if(loc >= list.size()/2) {
					list.add(0,list.remove(list.size()-1));
					sum++;
					if(loc==list.size()-1) {
						loc =0;
					}else {
						loc+=1;
					}
				}
			}
		}
		System.out.println(sum);
	}
}
