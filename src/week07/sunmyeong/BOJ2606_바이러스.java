/*
 * 메모리 11596KB
 * 실행시간 76ms
 */

package week07.sunmyeong;

import java.io.*;
import java.util.*;

public class BOJ2606_바이러스 {
	
	static int N, parent[];
	
	public static void make() {
		parent = new int[N];
		for(int i = 0; i < N; i++) {
			parent[i] = i;
		}
	}
	
	public static int find(int a) {
		if(a == parent[a]) return a;
		else return parent[a] = find(parent[a]);
	}
	
	public static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA == rootB) return false;
		parent[rootB] = rootA;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		make();
		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			StringTokenizer stk = new StringTokenizer(str);
			union(Integer.parseInt(stk.nextToken())-1, Integer.parseInt(stk.nextToken())-1);
		}
		
		int root = find(0);
		for(int i = 1; i < N; i++) {
			if(find(i) == root) cnt++;
		}
		
		System.out.println(cnt);
	}

}
