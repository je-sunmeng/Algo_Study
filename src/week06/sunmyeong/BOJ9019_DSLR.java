/*
 * 메모리 298444KB
 * 실행시간 3660ms
 */

package week06.sunmyeong;

import java.io.*;
import java.util.*;

public class BOJ9019_DSLR {
	static boolean[] visited;
	static String[] Com = {"D","S","L","R"};
	
	static class DSLR{
		int num;
		String stack;
		public DSLR(int num, String stack) {
			this.num = num;
			this.stack = stack;
		}
	}
	
	public static int cal(int num, int com) {
		int out = num;
		switch (com) {
		case 0:	// num을 두배로
			out = num*2%10000;
			break;
		case 1:	// num-1;
			out = num-1;
			if(out < 0) out = 9999;
			break;
		case 2:	// 왼쪽으로 회전
			int tmp1 = num/1000;
			out = (num%1000)*10+tmp1;
			break;
		case 3:	// 오른쪽으로 회전
			int tmp2 = num%10;
			out = num/10 + tmp2*1000;
			break;
		default:
			break;
		}
		return out;
	}
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int test = 1; test <= T; test++) {
			String str = br.readLine();
			StringTokenizer stk = new StringTokenizer(str);

			int before = Integer.parseInt(stk.nextToken());
			int after = Integer.parseInt(stk.nextToken());
			String result="";
			visited = new boolean[10000];
			Queue<DSLR> que = new ArrayDeque<>();
			que.offer(new DSLR(before, ""));
			visited[before] = true;
			
			while(!que.isEmpty()) {
				DSLR tmp = que.poll();
				int num = tmp.num;
				String stack = tmp.stack;
				if(num == after) {
					result = stack;
					break;
				}
				for(int com = 0; com < 4; com++) {
					int dnum = cal(num, com);
					if(visited[dnum]) continue;
					visited[dnum] = true;
					que.offer(new DSLR(dnum, stack+Com[com]));
				}
			}
			sb.append(result).append("\n");					
		}
		System.out.println(sb);
	}
}
