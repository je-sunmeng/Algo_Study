/*
 * 메모리 	12204KB
 * 실행시간 84ms
 */

package week02.sunmyeong.graph;

import java.io.*;
import java.util.*;

public class BOJ2178_미로탐색 {
	//상 하 좌 우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static class Pos{
		int row;
		int col;
		int rank;
		public Pos(int row, int col, int rank) {
			this.row = row;
			this.col = col;
			this.rank = rank;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer stk = new StringTokenizer(str);
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		boolean[][] map = new boolean[N][M];	//true:길, false:벽
		int row, col, nr, nc;
		
		Queue<Pos> BFS = new LinkedList<>();	//BFS를 위한 Queue
		
		for(int i = 0; i < N; i++) {
			str = br.readLine();
			for(int j = 0; j < M; j++) {
				if(str.charAt(j)-'0' == 1) {
					map[i][j] = true;
				}				
			}
		}
		
		Pos now = null;
		BFS.add(new Pos(0, 0, 1));
				
		while(true) {
			now = BFS.poll();
			row = now.row;
			col = now.col;
			if(row == N-1 && col == M-1) {
				break;
			}
//			map[row][col] = false; // 이곳에 넣으면 메모리 초과
			for(int dir = 0; dir < 4; dir++) {
				nr = row+dr[dir];
				nc = col+dc[dir];
				if(nr<0||nr>N-1||nc<0||nc>M-1||!map[nr][nc]) continue;	//map외부 또는 이미 방문한 곳이라면 continue
				map[nr][nc] = false;	//이곳에 넣어야 메모리 초과가 나지 않음
				BFS.add(new Pos(nr, nc, now.rank+1));
			}
		}
		
		System.out.println(now.rank);		
	}
}
