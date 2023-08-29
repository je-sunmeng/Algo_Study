package week5.sunmyeong;

import java.io.*;
import java.util.*;

public class BOJ1107_리모컨 {
	static boolean[] broken = new boolean[11];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ch = 100;
		int goal = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		StringTokenizer stk = new StringTokenizer(str);
		for(int i = 0; i < n; i++) {
			broken[Integer.parseInt(stk.nextToken())] = true;
		}
		

	}

}
