package week05.sunmyeong;

import java.io.*;
import java.util.*;

public class BOJ5430_AC {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); // 테케수 입력
		Deque<Integer> nums = new ArrayDeque<>();
		
		go:for(int test = 1; test <= T; test++) {
			String com = br.readLine();	// RD명령어 입력
			int len = Integer.parseInt(br.readLine());	// 숫자 개수 입력
			String str = br.readLine();	// 숫자 입력
			int start = 0;	// 뒤집힘 여부 확인
			
			str = str.replace("[", "").replace("]", "");
			StringTokenizer stk = new StringTokenizer(str, ",");
			
			for(int i = 0; i < len; i++) {
				nums.add(Integer.parseInt(stk.nextToken()));
			}
			
			for(int c = 0; c < com.length(); c++) {
				char command = com.charAt(c);
				if(command == 'R') {
					start ^= 1;
				}
				else {
					if(nums.size() == 0) {
						sb.append("error").append("\n");
						continue go;
					}
					if(start == 0) nums.pollFirst();
					else nums.pollLast();
				}
			}
			
			sb.append("[");
			if(start == 0) {
				while(nums.size() != 1) {
					sb.append(nums.pollFirst()).append(",");
				}
			}
			else {
				while(nums.size() != 1) {
					sb.append(nums.pollLast()).append(",");
				}
			}
			sb.append(nums.poll()).append("]").append("\n");
			nums.clear();
		}
		System.out.println(sb);
	}

}
