
public class HeapSort {
	
	private int size;
	private int arr[];
	
	public HeapSort(){
		size=  0;
		arr = new int[50];
	}
	
	public void insertHeap(int input) {
		int i = ++size;
		while((i!=1)&& (input < arr[i/2])) {
			arr[i] = arr[i/2];
			i  = i/2;
		}
		arr[i] = input;
	}
	
	public int getHeapSize() {
		return size;
	}
	
	public void printHeap() {
		System.out.println("\n Min Heap: ");
		for(int i=1;i<=size;i++) {
			System.out.printf("[%d] ", arr[i]);
		}
	}
	
	public int deleteHeap() {
		int parent,child;
		int data, temp;
		
		data = arr[1];//뺄값
		temp = arr[size];
		size = size-1;
		parent = 1;
		child  = 2;
		while(child <= size) {
			if((child<size) &&(arr[child] > arr[child+1])) {
				child++;
			} 
			if(temp<= arr[child]) {
				break;
			}
			arr[parent] = arr[child];
			parent = child;
			child *= 2;
		}
		arr[parent] = temp;
		return data;
	}
	
	public static void main(String args[]) {
		HeapSort h = new HeapSort();
		h.insertHeap(80);
		h.insertHeap(50);
		h.insertHeap(70);
		h.insertHeap(10);
		h.insertHeap(60);
		h.insertHeap(20);
		
		h.printHeap();
		int data;
		int n = h.getHeapSize();
		for(int i=1;i<=n;i++) {
			data = h.deleteHeap();
			System.out.printf("\n 출력:[%d]",data);
		}
	}
}