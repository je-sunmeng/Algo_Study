package week3.sunmyeong;

import java.io.*;
import java.util.*;

public class BOJ2206_벽부수고이동하기 {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringTokenizer stk = new StringTokenizer(str);
		
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		int min = Integer.MAX_VALUE;
		
		Queue<int[]> wall = new ArrayDeque<>();
		
		int[][] map = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		int row = 0, col = 0;
		
		for(int i = 0; i < N; i++) {
			str = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j)-'0';
				if(map[i][j] == 1) wall.offer(new int[] {i,j});
			}
		}
		
		if(wall.isEmpty()) {
			System.out.println(N+M-1);
			return;
		}
		
		while(!wall.isEmpty()) {
			int[] tmp = wall.poll(); 
			int n = tmp[0];
			int m = tmp[1];

			map[n][m] = 0;
			Queue<int[]> que = new ArrayDeque<int[]>();

			int rank = 1;
			
			que.offer(new int[] {0, 0, 1});
			visited[0][0] = true;
			while(!que.isEmpty()) {
				int[] temp = que.poll();
				row = temp[0];
				col = temp[1];
				rank = temp[2];
				if(rank > min) break;
//				System.out.println("crush: ["+ n +" , " +m+"] "+ row +" "+ col +" "+rank);
				if(row == N-1 && col == M-1) {
					if(rank < min) min = rank;
					break;
				}
				for(int i = 0; i < 4; i++) {
					int nr = row + dr[i];
					int nc = col + dc[i];
					if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || map[nr][nc] == 1) continue;
					que.offer(new int[] {nr,nc,rank+1});
					visited[nr][nc] = true;
				}
			}
			for(int i = 0; i < N; i++)
				Arrays.fill(visited[i], false);
			map[n][m] = 1;
		}

		if(min == Integer.MAX_VALUE) min = -1;
		System.out.println(min);
	}

}
