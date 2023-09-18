package week08.sunmyeong;

import java.io.*;
import java.util.*;

public class BOJ1325_효율적인해킹 {
	
	static int parents[], N;
	
	public static void make() {
		parents = new int[N];
		for(int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	
	public static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA == rootB) return false;
		parents[rootB] = rootA;
		return true;
	}
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer stk = new StringTokenizer(str);
		
		N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		make();
		int[] cnt = new int[N];
		for(int i = 0; i < M; i++) {
			str = br.readLine();
			stk = new StringTokenizer(str);
			int A = Integer.parseInt(stk.nextToken())-1;
			int B = Integer.parseInt(stk.nextToken())-1;
			union(A, B);
		}
		for(int i = 0; i < N; i++) {
			System.out.print(parents[i] + " ");
		}

	}

}
