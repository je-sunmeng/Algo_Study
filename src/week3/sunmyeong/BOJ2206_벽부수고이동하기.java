/*
 * https://www.acmicpc.net/problem/2206
 * 메모리 114172KB
 * 실행시간 652ms
 */

package week3.sunmyeong;

import java.io.*;
import java.util.*;

public class BOJ2206_벽부수고이동하기 {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N, M, min, map[][];
	static boolean visited[][][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		StringTokenizer stk = new StringTokenizer(str);

		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		min = Integer.MAX_VALUE;

		map = new int[N][M];
		visited = new boolean[N][M][2]; // 0:벽을 뚫지 않고 방문 / 1:벽을 뚫은 후에 방문
		Queue<int[]> que = new ArrayDeque<>(); // row, col, rank, isCrush

		for (int i = 0; i < N; i++) { // 입력받는 부분
			str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		que.offer(new int[] { 0, 0, 1, 0 });
		visited[0][0][0] = true;
		while (!que.isEmpty()) {
			int[] temp = que.poll();
			int row = temp[0];
			int col = temp[1];
			int rank = temp[2];
			int isCrushed = temp[3];

			if (row == N - 1 && col == M - 1) {
				if (rank < min)
					min = rank;
				break;
			}
			for (int dir = 0; dir < 4; dir++) {
				int nr = row + dr[dir];
				int nc = col + dc[dir];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				// 벽을 부순적이 없을 때 -> 방문하지 않은 곳이라면
				// 벽을 부순적이 있을 때 -> 벽을 부순적이 없을때도 방문하지 않은 곳이라면
				if (!visited[nr][nc][isCrushed] && !visited[nr][nc][0]) {	
					if (isCrushed + map[nr][nc] > 1) continue; // 벽을 부순상태로 벽을 만나면 continue
					que.offer(new int[] { nr, nc, rank + 1, isCrushed + map[nr][nc] }); // 0+0:벽을 안부숨/ 0+1:지금 벽을 부숨/ 1+0:벽을부순상태로빈칸 
					visited[nr][nc][isCrushed + map[nr][nc]] = true; // 해당위치를 벽을 부순 상태에 맞게 방문처리
				}

			}
		}

		if (min == Integer.MAX_VALUE)
			min = -1;
		System.out.println(min);
	}

}
