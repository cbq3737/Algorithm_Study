package step29;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
//PRIM Ver
public class num_1774_prim {
	static class Node{
		int u,v;
		double weight;
		public Node(int u,int v,double weight) {
			this.u =u;
			this.v =v;
			this.weight= weight;
		}
	}
	static class Path implements Comparable<Path>{
		int v;
		double weight;
		public Path(int v,double weight) {
			this.v = v;
			this.weight = weight;
		}
		@Override
		public int compareTo(Path o) { //double형 비교
			return Double.compare(this.weight, o.weight);
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		int nNum = Integer.parseInt(tk.nextToken());
		int mNum = Integer.parseInt(tk.nextToken());
		long[][] prim = new long[nNum][2];
		double[] minPay = new double[nNum];
		boolean[] visited = new boolean[nNum];
		
		List<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();//간선 정보
		List<ArrayList<Integer>> already_list = new ArrayList<ArrayList<Integer>>(); //이미 연결된 정보
		for(int i=0;i<nNum;i++) {
			list.add(new ArrayList<Node>());
			already_list.add(new ArrayList<Integer>());
		}
		
		for(int i=0;i<nNum;i++) {
			tk= new StringTokenizer(br.readLine());
			for(int j=0;j<2;j++) {				
				prim[i][j] = Long.parseLong(tk.nextToken());			
			}
		}
		
		for(int i=0;i<mNum;i++) {
			tk = new StringTokenizer(br.readLine());
			int ni = Integer.parseInt(tk.nextToken())-1;
			int nj = Integer.parseInt(tk.nextToken())-1;
			already_list.get(ni).add(nj);
			already_list.get(ni).add(ni);
			list.get(ni).add(new Node(ni,nj,0));
			list.get(nj).add(new Node (nj,ni,0));			
		}
		//가중치 구하기
		for(int i=0;i<nNum;i++) {
			for(int j=i+1;j<nNum;j++) {
				if(already_list.get(i).contains(j)) { //이미 연결된 애는 길이를 안구해줘도 된다.
					continue;
				}
				long x_d = prim[j][0] - prim[i][0];
				long y_d = prim[j][1] - prim[i][1];
				double weight = Math.sqrt((x_d*x_d)+(y_d*y_d));
				list.get(i).add(new Node(i,j,weight));
				list.get(j).add(new Node(j,i,weight));
			}
		}
		Arrays.fill(minPay, Double.MAX_VALUE);//무한대로 채워넣기
		
		double result =0;
//		minPay[0] = 0;//임의의 점
		PriorityQueue<Path> pq = new PriorityQueue<Path>();
		pq.add(new Path(0,0)); //v=0, wieght=0, minPay[0] = 0
		while(!pq.isEmpty()) {
			Path p = pq.poll();
			int u= p.v;//목적지
			double u_weight = p.weight; //가중치
			if(minPay[u]<u_weight) {
				continue;
			}
			if(visited[u]) {
				continue;
			}
			visited[u] = true;
			result+=u_weight;
			for(Node nd:list.get(u)) {
				int vertex = nd.v;
				double weight = nd.weight;
				if(minPay[vertex] > weight && !visited[vertex]) {
					pq.add(new Path(vertex,weight));
					minPay[vertex] = weight;
				}
			}
		}
		System.out.printf("%.2f",result);			
	}
}



