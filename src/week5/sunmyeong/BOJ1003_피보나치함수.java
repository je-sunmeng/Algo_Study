/*
 * 메모리 11408KB
 * 실행시간 76ms
 */

package week5.sunmyeong;

import java.io.*;

public class BOJ1003_피보나치함수 {
	static int num1, num0, call0[], call1[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		call0 = new int[41];
		call1 = new int[41];
		call0[0] = 1;
		call0[1] = 0;
		call1[0] = 0;
		call1[1] = 1;
		for(int i = 2; i <= 40; i++) {
			call0[i] = call0[i-1] + call0[i-2];
			call1[i] = call1[i-1] + call1[i-2];
		}
		for(int test = 1; test <= T; test++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(call0[n]).append(" ").append(call1[n]).append("\n");
		}
		System.out.println(sb);
	}

}
