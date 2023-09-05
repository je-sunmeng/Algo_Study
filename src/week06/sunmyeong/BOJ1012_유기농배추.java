/*
 * 메모리 13364KB
 * 실행시간 116ms
 */

package week06.sunmyeong;

import java.io.*;
import java.util.*;

public class BOJ1012_유기농배추 {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int test = 0; test < T; test++) {
			String str = br.readLine();
			StringTokenizer stk = new StringTokenizer(str);
			
			int N = Integer.parseInt(stk.nextToken());
			int M = Integer.parseInt(stk.nextToken());
			int K = Integer.parseInt(stk.nextToken());
			int cnt = 0;
			boolean[][] visited = new boolean[N][M];
			boolean[][] map = new boolean[N][M];
			
			for(int k = 0; k < K; k++) {
				str = br.readLine();
				stk = new StringTokenizer(str);
				int row = Integer.parseInt(stk.nextToken());
				int col = Integer.parseInt(stk.nextToken());
				map[row][col] = true;
			}
			Queue<int[]> que = new ArrayDeque<int[]>();
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(!visited[i][j] && map[i][j]) {
						cnt++;
						que.offer(new int[] {i, j});
						visited[i][j] = true;
						while(!que.isEmpty()) {
							int[] tmp = que.poll();
							int row = tmp[0];
							int col = tmp[1];
							for(int dir = 0; dir < 4; dir++) {
								int nr = row+dr[dir];
								int nc = col+dc[dir];
								if(nr<0||nr>=N||nc<0||nc>=M||!map[nr][nc]||visited[nr][nc]) continue;
								visited[nr][nc] = true;
								que.offer(new int[] {nr, nc});								
							}
						}
					}
				}
			}

			sb.append(cnt).append("\n");					
		}
		System.out.println(sb);
	}

}
