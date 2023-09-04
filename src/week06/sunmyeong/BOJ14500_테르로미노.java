/*
 * 메모리 	32968KB
 * 실행시간 632ms
 */

package week06.sunmyeong;

import java.io.*;
import java.util.*;

public class BOJ14500_테르로미노 {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int N, M, max, map[][];
	static boolean[][] visited;
	
	public static void DFS(int depth, int sum, int row, int col) {
		if(depth == 4) {
			if(max < sum) max = sum;
			return;
		}
		
		for(int dir = 0; dir < 4; dir++) {
			int nr = row + dr[dir];
			int nc = col + dc[dir];
			if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;
			visited[nr][nc] = true;
			if(depth==2) DFS(depth+1, sum+map[nr][nc], row, col);
			DFS(depth+1, sum+map[nr][nc], nr, nc);
			visited[nr][nc] = false;
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringTokenizer stk = new StringTokenizer(str);
		
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		max = 0;
				
		for(int i = 0; i < N; i++) {
			str = br.readLine();
			stk = new StringTokenizer(str);
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				visited[i][j] = true;
				DFS(1, map[i][j], i, j);
				visited[i][j] = false;
			}
		}
		
		System.out.println(max);
				
		
	}

}
