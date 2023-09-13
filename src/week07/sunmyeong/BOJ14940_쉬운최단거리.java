/*
 * 메모리 51836KB
 * 실행시간 692ms
 */
package week07.sunmyeong;

import java.io.*;
import java.util.*;

public class BOJ14940_쉬운최단거리 {
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		StringTokenizer stk = new StringTokenizer(str);
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		
		int[][] origin = new int[N][M];
		int[][] result = new int[N][M];
		int start_r=0, start_c=0;
		
		for(int i = 0; i < N; i++) {
			Arrays.fill(result[i], -1);
		}
		
		for(int i = 0; i < N; i++) {
			str = br.readLine();
			stk = new StringTokenizer(str);
			for (int j = 0; j < M; j++) {
				origin[i][j] = Integer.parseInt(stk.nextToken());
				if(origin[i][j] == 0) {
					result[i][j] = 0;
				} else if(origin[i][j] == 2) {
					start_r = i;
					start_c = j;
				}
			}
		}
		
		Queue<int[]> que = new ArrayDeque<int[]>();
		
		que.offer(new int[] {start_r, start_c, 0});
		result[start_r][start_c] = 0;
		
		while(!que.isEmpty()) {
			int[] tmp = que.poll();
			int row = tmp[0];
			int col = tmp[1];
			int cnt = tmp[2];
			for(int dir = 0; dir < 4; dir++) {
				int nr = row+dr[dir];
				int nc = col+dc[dir];
				if(nr<0||nr>=N||nc<0||nc>=M||result[nr][nc]!=-1||origin[nr][nc]==0) continue;
				
				int min = Integer.MAX_VALUE;
				for(int d = 0; d < 4; d++) {
					int tr = nr+dr[d];
					int tc = nc+dc[d];
					if(tr<0||tr>=N||tc<0||tc>=M||result[tr][tc] ==-1||origin[tr][tc]==0) continue;
					if(result[tr][tc] < min) min = result[tr][tc];
				}
				
				result[nr][nc] = min+1;
				que.offer(new int[] {nr, nc, min+1});
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}

}
