/*
 * https://www.acmicpc.net/problem/16928
 * 메모리 	11828KB
 * 실행시간 80ms
 */

package week05.sunmyeong;

import java.io.*;
import java.util.*;

public class BOJ16928_뱀과사다리게임 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer stk = new StringTokenizer(str);
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		
		Map<Integer, Integer> map = new HashMap<>();
		boolean[] visited = new boolean[100];

		for(int i = 0; i < M+N; i++) {
			str = br.readLine();
			stk = new StringTokenizer(str);
			int key = Integer.parseInt(stk.nextToken())-1;
			int value = Integer.parseInt(stk.nextToken())-1;
			map.put(key, value);
		}
		
		Queue<int[]> que = new ArrayDeque<>();
		que.offer(new int[] {0,0});
		visited[0] = true;
		int result = 0;
		
		while(!que.isEmpty()) {
			int[] tmp = que.poll();
			int cur = tmp[0];
			int cnt = tmp[1];
			if(cur == 99) {
				result = cnt;
				break;
			}
			for(int dice = 1; dice <=6; dice++) {
				int nxt = cur + dice;
				if(nxt >= 100 || visited[nxt]) continue;
				visited[nxt] = true;
				if(map.containsKey(nxt)) {
					if(visited[map.get(nxt)]) continue;
					visited[map.get(nxt)] = true;
					que.offer(new int[] {map.get(nxt), cnt+1});
				}
				else {
					que.offer(new int[] {nxt, cnt+1});
				}
			}
		}
		
		System.out.println(result);
	}

}
