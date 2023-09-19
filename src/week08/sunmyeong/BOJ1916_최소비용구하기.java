package week08.sunmyeong;

import java.io.*;
import java.util.*;

public class BOJ1916_최소비용구하기 {
	
	static class Node{
		private int nxt, weight;
		public Node(int nxt, int weight) {
			this.nxt = nxt;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		List<Node> adjList[] = new ArrayList[N];
		
		for(int i = 0; i < N; i++) adjList[i] = new ArrayList<Node>();
		
		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			StringTokenizer stk = new StringTokenizer(str);
			adjList[Integer.parseInt(stk.nextToken())-1].add(new Node(Integer.parseInt(stk.nextToken())-1, Integer.parseInt(stk.nextToken())-1));
		}
		
		String str = br.readLine();
		StringTokenizer stk = new StringTokenizer(str);
		int start = Integer.parseInt(stk.nextToken());
		int end = Integer.parseInt(stk.nextToken()); 
		
		int dis[] = new int[N];
		boolean[] visited = new boolean[N];
		Arrays.fill(dis, Integer.MAX_VALUE);
		
		Queue<Node> que = new ArrayDeque<>();
		
		dis[start] = 0;
		visited[start] = true;
		que.offer(new Node(start, 0));
		int minIndex, cur = start;
		
		while(true) {
			Node next = que.poll();
			if(dis[next.nxt] > next.weight) dis[next.nxt] = next.weight;
			else dis[next.nxt] += next.weight;
		}
		
		
		

	}

}
