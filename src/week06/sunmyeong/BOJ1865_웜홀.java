package week06.sunmyeong;

import java.io.*;
import java.util.*;

public class BOJ1865_웜홀 {
	
	static List<Node> road[];
	static boolean flag, visited[];
	static int[][] DP;
	
	static class Node{
		int to;
		int weight;
		
		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
		
	}
	
	public static void DFS(int origin, int cur, int weight) { // weight = origin -> cur 까지 시간합
		if(flag) return;
		if(cur == origin && weight<0) {
			flag = true;
			return;
		}
		System.out.println(origin +" "+cur+" "+DP[origin][cur]);
		for(int i = 0; i < road[cur].size(); i++) {
			Node next = road[cur].get(i);
			if(visited[next.to]) {
				if(DP[origin][next.to] - (weight+next.weight) > 0) {
					System.out.println(origin + " " + cur + " " +DP[origin][next.to] +" "+ weight);
					flag = true;
					return;
				}
				continue;
			}
			visited[next.to] = true;
			DP[origin][next.to] = weight+next.weight;
			DFS(origin, next.to, weight+next.weight);
			DP[origin][next.to] = 0;
			visited[next.to] = false;			
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int test = 1; test <= TC; test++) {
			String str = br.readLine();
			StringTokenizer stk = new StringTokenizer(str);
			int N = Integer.parseInt(stk.nextToken());
			int M = Integer.parseInt(stk.nextToken());
			int W = Integer.parseInt(stk.nextToken());
			road = new ArrayList[N];
			DP = new int[N][N];
			for(int i = 0; i < N; i++) {
				road[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < M; i++) {
				str = br.readLine();
				stk = new StringTokenizer(str);
				int S = Integer.parseInt(stk.nextToken())-1;
				int E = Integer.parseInt(stk.nextToken())-1;
				int T = Integer.parseInt(stk.nextToken());
				road[S].add(new Node(E, T));
				road[E].add(new Node(S, T));
			}
			
			for(int i = 0; i < W; i++) {
				str = br.readLine();
				stk = new StringTokenizer(str);
				int S = Integer.parseInt(stk.nextToken())-1;
				int E = Integer.parseInt(stk.nextToken())-1;
				int T = Integer.parseInt(stk.nextToken());
				road[S].add(new Node(E, -T));			
			}
			flag = false;
			for(int i = 0; i < N; i++) {
				if(road[i].isEmpty()) continue;
				visited = new boolean[N];
				for(int j = 0; j < road[i].size(); j++) {
					visited[road[i].get(j).to] = true;
					DP[i][road[i].get(j).to] = road[i].get(j).weight;
					DFS(i, road[i].get(j).to, road[i].get(j).weight);
					DP[i][road[i].get(j).to] = 0;
				}
			}
			if(flag) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}
