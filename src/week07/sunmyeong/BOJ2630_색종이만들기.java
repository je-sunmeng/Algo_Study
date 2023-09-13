/*
 * 메모리 13260KB
 * 실행시간 112ms
 */

package week07.sunmyeong;

import java.io.*;
import java.util.*;

public class BOJ2630_색종이만들기 {
	static int map[][], W=0, B=0;
	
	public static void Divide(int row, int col, int len) {
		if(len == 0) return;
		int index = map[row][col];
		boolean flag = false;
		go: for(int i = row; i < row+len; i++) {
			for(int j = col; j < col+len; j++) {
				if(map[i][j] != index) {
					flag = true;
					break go;
				}
			}
		}
		
		if(!flag) {
			if(index == 0) W++;
			else B++;
			return;
		}
		Divide(row,col,len/2);
		Divide(row,col+len/2,len/2);
		Divide(row+len/2,col,len/2);
		Divide(row+len/2,col+len/2,len/2);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			StringTokenizer stk = new StringTokenizer(str);
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		Divide(0, 0, N);
		
		System.out.println(W);
		System.out.println(B);
		
	}
}
