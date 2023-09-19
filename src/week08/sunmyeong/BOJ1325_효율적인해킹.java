package week08.sunmyeong;

import java.io.*;
import java.util.*;

public class BOJ1325_효율적인해킹 {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer stk = new StringTokenizer(str);
		
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());

		List<Integer> adjList[] = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			str = br.readLine();
			stk = new StringTokenizer(str);
			int A = Integer.parseInt(stk.nextToken())-1;
			int B = Integer.parseInt(stk.nextToken())-1;
			adjList[B].add(A);
		}
		
		int[] cnts = new int[N];
		int max = 0;
		for(int i = 0; i < N; i++) {
			boolean[] visited = new boolean[N];
			int cnt = 0;
			Queue<Integer> que = new ArrayDeque<>();
			que.offer(i);
			visited[i] = true;
			while(!que.isEmpty()) {
				int nxt = que.poll();
				cnt++;
				for(int j = 0; j < adjList[nxt].size(); j++) {
					if(visited[adjList[nxt].get(j)]) continue;
					que.offer(adjList[nxt].get(j));
				}
			}
			cnts[i] = cnt;
			if(max < cnt) max = cnt;
		}
		
		for(int i = 0; i < N; i++) {
			if(cnts[i]==max) System.out.print((i+1) + " ");
		}


	}

}
