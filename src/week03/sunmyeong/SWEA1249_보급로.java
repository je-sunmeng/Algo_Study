/*
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15QRX6APsCFAYD
 */

package week03.sunmyeong;

import java.io.*;
import java.util.*;

public class SWEA1249_보급로 {
					//우 하 좌 상
	static int dr[] = {0, -1, 0, 1};
	static int dc[] = {1, 0, -1, 0};
	

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int test = 1; test <= T; test++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] map = new int[N][N];
			int[][] distance = new int[N][N];
			for(int i = 0; i < N; i++)
				Arrays.fill(distance[i], Integer.MAX_VALUE);
			boolean[][] visited = new boolean[N][N];
			
			for(int i = 0; i < N; i++) {
				String str = br.readLine();
				for(int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			
			PriorityQueue<int[]> heap = new PriorityQueue<int[]>((o1, o2) -> Integer.compare(distance[o1[0]][o1[1]], distance[o2[0]][o2[1]]));
			heap.offer(new int[] {0,0});
			distance[0][0] = 0;
			while(!heap.isEmpty()) {
				int[] cur = heap.poll();
				
				int row = cur[0];
				int col = cur[1];
				
				if(row == N-1 && col == N-1) break;
				
				if(distance[row][col] < map[row][col]) continue;
				
				for(int dir = 0; dir < 4; dir++) {
					int nr = row + dr[dir];
					int nc = col + dc[dir];
					if(nr<0 || nr >=N || nc<0 || nc>=N) continue;
					if(distance[nr][nc] > map[row][col] + map[nr][nc]) {
						distance[nr][nc] = map[row][col] + map[nr][nc];
						heap.offer(new int[] {nr, nc});
					}
				}
			}
			
			
			
			System.out.println("#"+test+" "+ distance[N-1][N-1]);
			
		}
		
	}

}
