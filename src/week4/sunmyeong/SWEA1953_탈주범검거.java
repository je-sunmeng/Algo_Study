package week4.sunmyeong;

import java.io.*;
import java.util.*;

public class SWEA1953_탈주범검거 {
	
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int test = 1; test <= T; test++) {
			String str = br.readLine();
			StringTokenizer stk = new StringTokenizer(str);
			
			int N = Integer.parseInt(stk.nextToken());
			int M = Integer.parseInt(stk.nextToken());
			int R = Integer.parseInt(stk.nextToken());
			int C = Integer.parseInt(stk.nextToken());
			int L = Integer.parseInt(stk.nextToken());
			
			int[][] map = new int[N][M];
			boolean[][] visited = new boolean[N][M];
			
			for(int i = 0; i < N; i++) {
				str = br.readLine();
				stk = new StringTokenizer(str);
				for(int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(stk.nextToken());
				}
			}
			
			int count = 0;
			Queue<int[]> que = new ArrayDeque<>();
			que.offer(new int[] {R,C,0});

			while(!que.isEmpty()) {
				int[] cur = que.poll();						
				int row = cur[0];
				int col = cur[1];
				int time = cur[2];
				
				if(time == L)break;				
				count++;
				visited[row][col] = true;
				
				for(int dir = 0; dir < 4; dir++) {
					int nr = row +dr[dir];
					int nc = col +dc[dir];
					if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || map[nr][nc] == 0) continue;
					int num = map[row][col];
					switch (map[row][col]) {
					case 1:
						que.offer(new int[] {nr, nc, time+1});
					case 2:
						if((dir == 0 && num !=3 && num != 4 && num != 7)|| (dir == 1 && num != 3 && num !=5 && num != 6))
							que.offer(new int[] {nr, nc, time+1});
						break;
					case 3:
						if(dir == 2 || dir == 3)
							que.offer(new int[] {nr, nc, time+1});
						break;
					case 4:
						if(dir == 0 || dir == 3)
							que.offer(new int[] {nr, nc, time+1});
						break;
					case 5:
						if(dir == 1 || dir == 3)
							que.offer(new int[] {nr, nc, time+1});
						break;
					case 6:
						if(dir == 1 || dir == 2)
							que.offer(new int[] {nr, nc, time+1});
						break;
					case 7:
						if(dir == 0 || dir == 2)
							que.offer(new int[] {nr, nc, time+1});
						break;
					default:
						break;
					}
				}
			}
			
			System.out.println(count);
			
		}

	}

}
