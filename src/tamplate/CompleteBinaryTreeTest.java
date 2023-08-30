package tamplate;

import java.util.ArrayDeque;
import java.util.Queue;

public class CompleteBinaryTreeTest<T> {
	private Object[] nodes;
	private int lastIndex;
	private final int SIZE;
	
	public CompleteBinaryTreeTest(int size) {
		this.SIZE = size;
		nodes = new Object[size+1];
	}
	
	public boolean isEmpty() {
		return lastIndex == 0;
	}
	
	public boolean isFull() {
		return lastIndex == SIZE;
	}
	
	public boolean add(T data) {
		if(isFull()) return false;
		nodes[++lastIndex] = data;
		return true;
	}
	
	public void BFS() {
		if(isEmpty()) return;
		Queue<Integer> que = new ArrayDeque<Integer>();
		que.offer(1);
		
		while(!que.isEmpty()) {
			int current = que.poll();
			
			System.out.println(nodes[current]);
			if(current*2 <= lastIndex) que.offer(current*2);
			if(current*2+1 <= lastIndex) que.offer(current*2+1);
		}
		
	}
	
	public static void main(String[] args) {
		int size = 9;
		
		CompleteBinaryTreeTest<Character> tree = new CompleteBinaryTreeTest<>(size);
		for(int i = 0; i < size; i++) {
			tree.add((char)('A'+i));
		}
		
		tree.BFS();

	}

}
