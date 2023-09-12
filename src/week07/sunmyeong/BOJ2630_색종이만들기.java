package week07.sunmyeong;

import java.io.*;
import java.util.*;

public class BOJ2630_색종이만들기 {
	static int map[][], W=0, B=0;
	
	public static void Divide(int rs, int re, int cs, int ce) {
		if(rs+1 == re || cs+1 == ce) return;
		int index = map[rs][cs];
		boolean flag = false;
		go: for(int i = rs; i < re; i++) {
			for(int j = cs; j < ce; j++) {
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
		Divide(rs, re/2, cs, ce/2);
		Divide(re/2, re, cs, ce/2);
		Divide(rs, re/2, ce/2, ce);
		Divide(re/2, re, ce/2, ce);
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
		
		Divide(0, N, 0, N);
		
		System.out.println(W);
		System.out.println(B);
		
	}
}
