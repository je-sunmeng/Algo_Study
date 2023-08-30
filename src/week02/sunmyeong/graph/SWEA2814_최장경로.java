package week02.sunmyeong.graph;

import java.io.*;
import java.util.*;

public class SWEA2814_최장경로 {
	static int max = 0;
	
	static class Node{
		Queue<Node> prev;
		Queue<Node> next;
		
		public Node() {
			prev = new LinkedList<>();
			next = new LinkedList<>();
		}
		
		public void addNextNode(Node node) {
			this.next.offer(node);
		}
		public void addPrevNode(Node node) {
			this.prev.offer(node);
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test = 1; test <= T; test++) {
			
			List<Queue<Integer>> graph = new LinkedList<>();
			
			String str = br.readLine();
			StringTokenizer stk = new StringTokenizer(str);
			int N = Integer.parseInt(stk.nextToken());
			int M = Integer.parseInt(stk.nextToken());
			
			for(int i = 1; i <= N; i++) {
				graph.add(new LinkedList<>());
			}
			
			for(int m = 0; m < M; m++) {
				str = br.readLine();
				stk = new StringTokenizer(str);
				int x = Integer.parseInt(stk.nextToken());
				int y = Integer.parseInt(stk.nextToken());
				
				graph.get(x).offer(y);
				graph.get(y).offer(x);
			}
			
			System.out.println("#"+test+" "+max);
		}
		
	}

}
