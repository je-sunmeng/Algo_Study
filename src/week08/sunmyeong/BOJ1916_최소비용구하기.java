/*
 * 메모리 	46088KB
 * 실행시간 356ms
 */

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
			int cur = Integer.parseInt(stk.nextToken())-1;
			int nxt = Integer.parseInt(stk.nextToken())-1;
			int weight = Integer.parseInt(stk.nextToken());
			adjList[cur].add(new Node(nxt, weight));
		}
		
		String str = br.readLine();
		StringTokenizer stk = new StringTokenizer(str);
		int start = Integer.parseInt(stk.nextToken())-1;
		int end = Integer.parseInt(stk.nextToken())-1; 
		
		int dist[] = new int[N];
		boolean[] visited = new boolean[N];
		Arrays.fill(dist, Integer.MAX_VALUE);

		dist[start] = 0;

		for(int i = 0; i < N; i++) {
			int min = Integer.MAX_VALUE;
			int minIndex = -1;
			for(int j = 0; j < N; j++) {
				if(!visited[j] && dist[j] < min) {
					min = dist[j];
					minIndex = j;
				}
			}
			if(minIndex == -1) break;
			visited[minIndex] = true;
			
			for(int j = 0; j < adjList[minIndex].size(); j++) {
				Node tmp = adjList[minIndex].get(j);
				
				if(dist[tmp.nxt] > dist[minIndex]+tmp.weight) {
					dist[tmp.nxt] = dist[minIndex]+tmp.weight;
				}
			}
		}
		
		System.out.println(dist[end]);

	}

}
