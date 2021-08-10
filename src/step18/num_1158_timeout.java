package step18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


class Node{
	int data;
	Node link;
	public Node(int data,Node link) {
		this.data = data;
		this.link = link;
	}
}
class LinkedList_l{
	private Node head;
	
	public void addFirstNode(int data) {
		Node newNode = new Node(data,head);	
		head = newNode;
	}	
	public Node getLastNode() {
		for(Node curNode=head;curNode!=null;curNode = curNode.link) {
			if(curNode.link==null) { //내뒤에 아무도 없으면 내가 막내
				return curNode;
			}
		}
		return null;
	}
	public void addLastNode(int data,int nNum) {
		
		if(head==null) {
			addFirstNode(data);
			return;
		}
		Node lastNode = getLastNode();
		Node newNode;
		if(data==nNum) {			
			 newNode = new Node(data,head);//마지막 첫번째 노드와 연결
		}else {
			 newNode = new Node(data,null);		
		}
		lastNode.link=newNode;
	}
	public Node getNode(int data) {
		for(Node curNode=head;curNode!=null;curNode = curNode.link) {//탐색
			if(curNode.data==data) {
				return curNode;
			}
		}
		return null;
	}
	public Node getPreviousNode(Node target) {
		for(Node curNode=head;curNode!=null;curNode = curNode.link) {
			if(curNode.link == target) {
				return curNode;
			}
		}
		return null;
	}
	public void deleteNode(BufferedWriter bw,int kNum) throws IOException {
	
		int cnt =0; 
		Node curNode=head;
		while(curNode!=curNode.link) {//kNum번씩 돌면서 삭제
 				cnt++;
 				Node targetNode = getNode(curNode.data);
 				Node preNode = getPreviousNode(targetNode);				
 				if(cnt%kNum==0) {
 					preNode.link = targetNode.link;
 					if(targetNode==head) {
 						head = targetNode.link;
 					}
 					bw.write(targetNode.data+", ");
 					curNode = targetNode.link;
 					if(curNode==curNode.link) {
 						bw.write(curNode.data+">");
 					}
 					targetNode= null;
 					cnt = 0;
 				}
 				if(cnt!=0) { 					
 					curNode = curNode.link;
 				}
		}
	}
}
public class num_1158_timeout{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer tk = new StringTokenizer(br.readLine());
		LinkedList_l list = new LinkedList_l();
		int nNum = Integer.parseInt(tk.nextToken());
		int kNum = Integer.parseInt(tk.nextToken());
		for(int i=1;i<=nNum;i++) {
			list.addLastNode(i,nNum);
		}
		bw.write("<");
		if(nNum==1) {
			bw.write(nNum+">");
		}else {			
			list.deleteNode(bw,kNum);
		}
		
		bw.close();
	}
}

