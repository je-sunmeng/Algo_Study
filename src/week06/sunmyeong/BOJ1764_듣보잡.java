package week06.sunmyeong;

/*
 * 메모리 28176KB
 * 실행시간 280ms 
 */

import java.io.*;
import java.util.*;

public class BOJ1764_듣보잡 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		StringTokenizer stk = new StringTokenizer(str);
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		Set<String> set = new HashSet<>();
		PriorityQueue<String> minheap = new PriorityQueue<>();
		int Total = N+M;
		int cnt = 0;
		for(int i = 0; i < Total; i++) {
			String string = br.readLine();
			if(!set.add(string)) {
				cnt++;
				minheap.offer(string);
			}
		}
		sb.append(cnt).append("\n");
		while(!minheap.isEmpty()) {
			sb.append(minheap.poll()).append("\n");
		}
		System.out.println(sb);
	}
}
