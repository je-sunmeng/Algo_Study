package week06.sunmyeong;

import java.io.*;
import java.util.*;

public class BOJ11403_경로찾기 {
	
	static int result[][];
	static List<Integer> adjList[];
	
	public static void DFS(int i, int j) {		
		for(int n = 0; n < adjList[j].size(); n++) {
			if(result[i][adjList[j].get(n)] == 1) continue;
			result[i][adjList[j].get(n)] = 1;
			DFS(i, adjList[j].get(n));
		}
	}
	

	public static void main(String[] args) throws Exception {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		
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
		
		for(int i = 0; i < N; i++) {
			if(!adjList[i].isEmpty()) {
				result[i][adjList[i].get(0)] = 1;
				DFS(i, adjList[i].get(0));
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(result[i][j] +" ");
			}
			System.out.println();
		}
	}

}
