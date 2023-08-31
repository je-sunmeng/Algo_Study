package week05.sunmyeong;

import java.io.*;
import java.util.*;

public class BOJ1107_리모컨 {
	static boolean[] broken = new boolean[11];
	static String target;
	static int targetNum, min;
	
	public static void DFS(int index, String click) {
		for(int i = 0; i < 10; i++) {
			if(broken[i]) continue;
			String newStr = click + Integer.toString(i);
			int cnt = Math.abs(targetNum - Integer.parseInt(newStr)) + newStr.length();
			min = min > cnt ? cnt : min;
			if(index < 6) DFS(index+1, newStr);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String target = br.readLine();
		targetNum = Integer.parseInt(target);
		int M = Integer.parseInt(br.readLine());
		min = Math.abs(targetNum-100);
		if(M == 0) {
			System.out.println(Math.min(min, Integer.toString(targetNum).length()));
			return;
		}
		if(M == 10) {
			System.out.println(min);
			return;
		}
		if(targetNum == 100) {
			System.out.println(0);
			return;
		}
		String str = br.readLine();
		StringTokenizer stk = new StringTokenizer(str);
		for(int i = 0; i < M; i++) {
			broken[Integer.parseInt(stk.nextToken())] = true;
		}
		
		DFS(0,"");

		System.out.println(min);

	}

}
