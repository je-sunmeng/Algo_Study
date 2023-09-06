package week06.sunmyeong;

import java.io.*;
import java.util.*;

public class BOJ1865_웜홀 {
	
	static Node[] road, worm;
	
	static class Node{
		int from;
		int to;
		int weight;
		
		public Node(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
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
			road = new Node[M];
			worm = new Node[W];
			
			for(int i = 0; i < M; i++) {
				str = br.readLine();
				stk = new StringTokenizer(str);
				int S = Integer.parseInt(stk.nextToken());
				int E = Integer.parseInt(stk.nextToken());
				int T = Integer.parseInt(stk.nextToken());
				road[i] = new Node(S, E, T);			
			}
			
			for(int i = 0; i < W; i++) {
				str = br.readLine();
				stk = new StringTokenizer(str);
				int S = Integer.parseInt(stk.nextToken());
				int E = Integer.parseInt(stk.nextToken());
				int T = Integer.parseInt(stk.nextToken());
				worm[i] = new Node(S, E, -T);			
			}
			
		}
	}
}
