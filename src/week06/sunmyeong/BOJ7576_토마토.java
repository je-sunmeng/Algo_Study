/*
 * 메모리 108844KB
 * 실행시간 532ms
 */

package week06.sunmyeong;

import java.io.*;
import java.util.*;

public class BOJ7576_토마토 {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringTokenizer stk = new StringTokenizer(str);
		
		int M = Integer.parseInt(stk.nextToken());
		int N = Integer.parseInt(stk.nextToken());
		
		Queue<int[]> que = new ArrayDeque<>();
		
		int[][] map = new int[N][M];
		
		int cnt = N*M;
		
		int day = 0;
		for(int i = 0; i < N; i++) {
			str = br.readLine();
			stk = new StringTokenizer(str);
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
				if(map[i][j] == 1) {
					que.offer(new int[] {i,j,day});
					cnt--;
				}
				else if(map[i][j] == -1) cnt--;
			}
		}
		
		while(!que.isEmpty()) {
			int[] tmp = que.poll();
			int row = tmp[0];
			int col = tmp[1];
			day = tmp[2];
			for(int dir = 0; dir < 4; dir++) {
				int nr = row+dr[dir];
				int nc = col+dc[dir];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] != 0) continue;
				map[nr][nc] = 1;
				cnt--;
				que.offer(new int[] {nr,nc,day+1});
			}
		}
		
		if(cnt == 0) System.out.println(day);
		else System.out.println(-1);
	}

}
