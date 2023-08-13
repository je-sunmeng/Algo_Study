/*
 * 시간초과
 */

package week2.sunmyeong.graph;

import java.io.*;
import java.util.*;

public class BOJ2178_미로탐색 {
	static int N, M, min = Integer.MAX_VALUE;
	static boolean map[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer stk = new StringTokenizer(str);
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		int row = 0, col = 0, rank = 1;
		
		map = new boolean[N][M];	//true:길, false:벽
		ArrayDeque<int[]> BFS = new ArrayDeque<>();
		
		for(int i = 0; i < N; i++) {
			str = br.readLine();
			for(int j = 0; j < M; j++) {
				if(str.charAt(j)-'0' == 1) {
					map[i][j] = true;
				}				
			}
		}
		
		BFS.add(new int[] {row,col,rank});
		
		while(true) {
			int[] now = BFS.poll();
			row = now[0];
			col = now[1];
			rank = now[2];

			if(row == N-1 && col == M-1) {
				min = rank;
				break;
			}

			map[row][col] = false;

			if(row < N-1 && map[row+1][col]) BFS.add(new int[] {row+1, col, rank+1});	//아래
			if(col < M-1 && map[row][col+1]) BFS.add(new int[] {row, col+1, rank+1});	//오른쪽
			if(row > 0 && map[row-1][col]) BFS.add(new int[] {row-1, col, rank+1});	//위
			if(col > 0 && map[row][col-1]) BFS.add(new int[] {row, col-1, rank+1});	//왼쪽
			
		}
		
		System.out.println(min);		
	}

}
