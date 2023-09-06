/*
 * 메모리 14192KB
 * 실행시간 136ms
 */

package week06.sunmyeong;

import java.io.*;
import java.util.*;

public class BOJ11403_경로찾기 {
	
	static int result[][], from;
	static List<Integer> adjList[];
	
	public static void DFS(int i) {		
		for(int n = 0; n < adjList[i].size(); n++) {
			if(result[from][adjList[i].get(n)] == 1) continue;
			result[from][adjList[i].get(n)] = 1;
			DFS(adjList[i].get(n));
		}
	}
	

	public static void main(String[] args) throws Exception {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		result = new int[N][N];
		adjList = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<Integer>();
			String str = br.readLine();
			StringTokenizer stk = new StringTokenizer(str);
			for(int j = 0; j < N; j++) {
				if(Integer.parseInt(stk.nextToken()) == 1) {
					adjList[i].add(j);
				}
			}
		}
		
		for(from = 0; from < N; from++) {
			if(!adjList[from].isEmpty()) {
				DFS(from);
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
