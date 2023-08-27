/*
 * 메모리 24620KB
 * 실행시간 141ms
 */

package week4.sunmyeong;

import java.io.*;
import java.util.*;

public class SWEA1953_탈주범검거 {
	
	static int up, down, left, right;	
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		up = 1<<1 | 1<<2 | 1<<4 | 1<<7;
		down = 1<<1 | 1<<2 | 1<<5 | 1<<6;
		left = 1<<1 | 1<<3 | 1<<6 | 1<<7;
		right = 1<<1 | 1<<3 | 1<<4 | 1<<5;
		
		int T = Integer.parseInt(br.readLine());
		for(int test = 1; test <= T; test++) {
			String str = br.readLine();
			StringTokenizer stk = new StringTokenizer(str);
			
			int N = Integer.parseInt(stk.nextToken());	// 세로크기
			int M = Integer.parseInt(stk.nextToken());	// 가로크기
			int R = Integer.parseInt(stk.nextToken());	// 멘홀뚜껑 세로위치
			int C = Integer.parseInt(stk.nextToken());	// 멘홀뚜껑 가로위치
			int L = Integer.parseInt(stk.nextToken());	// 시간
			
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
			visited[R][C] = true;

			while(!que.isEmpty()) {
				count++;
				int[] cur = que.poll();						
				int time = cur[2];
				if(time == L-1) {
					continue;
				}
				int row = cur[0];
				int col = cur[1];
			
				int now = map[row][col];
				for(int dir = 0; dir < 4; dir++) {
					int nr = row +dr[dir];
					int nc = col +dc[dir];
					if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 0 || visited[nr][nc]) continue;
					int nxt = map[nr][nc];
					if(dir == 0 && (up & 1<<now) != 0 && (down & 1<<nxt) != 0) {
						visited[nr][nc] = true;
						que.offer(new int[] {nr,nc,time+1});
					}
					if(dir == 1 && (down & 1<<now) != 0 && (up & 1<<nxt) != 0) {
						visited[nr][nc] = true;
						que.offer(new int[] {nr,nc,time+1});
					}
					if(dir == 2 && (left & 1<<now) != 0 && (right & 1<<nxt) != 0)	{
						visited[nr][nc] = true;
						que.offer(new int[] {nr,nc,time+1});
					}
					if(dir == 3 && (right & 1<<now) != 0 && (left & 1<<nxt) != 0) {
						visited[nr][nc] = true;
						que.offer(new int[] {nr,nc,time+1});
					}
				}
			}
			
			System.out.println("#"+test+" "+count);
			
		}

	}

}
