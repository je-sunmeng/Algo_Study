/*
 * 메모리 42608KB
 * 실행시간 464ms
 */

package week07.sunmyeong;

import java.io.*;
import java.util.*;

public class BOJ1931_회의실배정 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<int[]> heap = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] > o2[1]) return 1;
				else if(o1[1] < o2[1]) return -1;
				else {
					if(o1[0] > o2[0]) return 1;
					else if(o1[0] < o2[0]) return -1;
					return 0;
				}
			}
		});
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			StringTokenizer stk = new StringTokenizer(str);
			heap.offer(new int[] {Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())});
		}
		int time = 0;
		int cnt = 0;
		while(!heap.isEmpty()) {
			int[] temp = heap.poll();
			if(time > temp[0]) continue;
			time = temp[1];
			cnt++;
		}
		
		System.out.println(cnt);
	}

}
