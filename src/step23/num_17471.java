package step23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class num_17471 {//게리멘더링
	public static int[] people;
	public static int nNum;
	public static List<List<Integer>> graph;
	public static Queue<Integer> t_queue;
	public static Queue<Integer> f_queue;
	public static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		nNum = Integer.parseInt(br.readLine());
		people = new int[nNum];//인원 수
		StringTokenizer tk = new StringTokenizer(br.readLine());
		for(int i=0;i<nNum;i++) {
			people[i] = Integer.parseInt(tk.nextToken());
		}
		graph = new ArrayList<>();//인접리스트
		for(int i=0;i<nNum;i++) {
			graph.add(new ArrayList<Integer>());
		}
		for(int i=0;i<nNum;i++) {
			tk = new StringTokenizer(br.readLine());
			int acc = Integer.parseInt(tk.nextToken());//인접한 구역 수
			for(int j=0;j<acc;j++) {
				graph.get(i).add(Integer.parseInt(tk.nextToken())-1);
			} 
		}
		t_queue = new LinkedList<Integer>();
		f_queue = new LinkedList<Integer>();
		
		//부분집합 만든 후, bfs진행
		makeBubun(0,new boolean[nNum]);
		if(min!=Integer.MAX_VALUE) {
			sb.append(min);
		}else {
			sb.append(-1);
		}
		System.out.println(sb);
	}
	public static void makeBubun(int cnt,boolean[] isselect) {
		if(cnt==isselect.length) {
			boolean t_flag = false;
			boolean f_flag = false;
			boolean[] t_select = new boolean[isselect.length];
			boolean[] f_select = new boolean[isselect.length];
			
			for(int i=0;i<isselect.length;i++) {
				t_select[i] = isselect[i];
				f_select[i] = isselect[i];
			}
			for(int i=0;i<isselect.length;i++) {
				if(t_flag&&f_flag) {
					break;
				}
				else if(!f_flag&&!isselect[i]) {
					f_queue.offer(i); //맨처음 스타트 수
					f_flag= true; //여기에 들어오기라도 하면
				}
				else if(!t_flag&&isselect[i]) {
					t_queue.offer(i);
					t_flag = true;
				}
			}
			if(f_flag&&t_flag&&t_bfs(t_select)&&f_bfs(f_select)) {//두 구역이 잘 나누어진 경우
				int area_one = 0;
				int area_two =0;
				for(int i=0;i<isselect.length;i++) {
					if(isselect[i]) {//1구역
						area_one+=people[i];
					}else {//2구역
						area_two+=people[i];
					}
				}
				int result = Math.abs(area_one-area_two);
				if(min>result) {
					min = result;
				}
			}
			t_queue.clear();
			f_queue.clear();
			return;
		}
		isselect[cnt] = true;
		makeBubun(cnt+1,isselect);
		
		isselect[cnt] = false;
		makeBubun(cnt+1,isselect);
	}
	public static boolean t_bfs(boolean[] isselect) {
		while(!t_queue.isEmpty()) {//false인 애들 체크
			int num = t_queue.poll();
			if(graph.get(num).size()==0) {
				isselect[num] = false; 		
			}else {				
				for(int i=0;i<graph.get(num).size();i++) {
					int idx = graph.get(num).get(i);//이어져 있는 애
					if(isselect[idx]) {//이어져있는 애들 중 T라면 담아준다
						t_queue.offer(idx);//그담 이어져있는 애들 판단해줘야댐
					}
					isselect[num] = false; 			
				}
			}
		}
		
		for(int i=0;i<isselect.length;i++) {
			if(isselect[i]) {//한명이라도 T라면
				return false;
			}
		}
		return true;
	}
	public static boolean f_bfs(boolean[] isselect) {//배열에서 F인애들끼리 이어지는 체크	
		while(!f_queue.isEmpty()) {//false인 애들 체크
			int num = f_queue.poll();
			if(graph.get(num).size()==0) {
				isselect[num] = true; 
			}else {				
				for(int i=0;i<graph.get(num).size();i++) {
					int idx = graph.get(num).get(i);//이어져 있는 애
					if(!isselect[idx]) {//이어져있는 애들 중 F라면 담아준다
						f_queue.offer(idx);//그담 이어져있는 애들 판단해줘야댐
					}
					isselect[num] = true; 			
				}
			}
		}
		for(int i=0;i<isselect.length;i++) {
			if(!isselect[i]) {//한명이라도 F라면.
				return false;
			}
		}
		return true;
	}
}
