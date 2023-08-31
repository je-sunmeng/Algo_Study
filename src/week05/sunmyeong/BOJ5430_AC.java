/*
 * 메모리	123496KB
 * 실행시간 928ms
 */

package week05.sunmyeong;

import java.io.*;
import java.util.*;

public class BOJ5430_AC {
	
	public static int countChar(String str, char ch) {
		return str.length() - str.replace(String.valueOf(ch), "").length();
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); // 테케수 입력
		List<Integer> nums = new ArrayList<>();
		
		for(int test = 1; test <= T; test++) {
			String com = br.readLine();	// RD명령어 입력
			int len = Integer.parseInt(br.readLine());	// 숫자 개수 입력
			String str = br.readLine();	// 숫자 입력
			int start = 0;	// 뒤집힘 여부 확인
			
			str = str.replace("[", "").replace("]", "");
			StringTokenizer stk = new StringTokenizer(str, ",");
			
			for(int i = 0; i < len; i++) {
				nums.add(Integer.parseInt(stk.nextToken()));
			}
			int[] index = {0, nums.size()-1};
			
			int D = countChar(com, 'D');
			
			if(D > nums.size()) {
				sb.append("error").append("\n");
				nums.clear();
				continue;
			}
			
			if(D == len || len == 0) {
				sb.append("[").append("]").append("\n");
				nums.clear();
				continue;
			}
			
			for(int c = 0; c < com.length(); c++) {
				char command = com.charAt(c);
				if(command == 'R') {
					start ^= 1;
				}
				else {
					if(start == 0) index[0]++;
					else index[1]--;
				}
			}
			
			sb.append("[");
			if(start == 0) {
				for(int i = index[0]; i < index[1]; i++) {
					sb.append(nums.get(i)).append(",");
				}
				sb.append(nums.get(index[1]));
			}
			else {
				for(int i = index[1]; i > index[0]; i--) {
					sb.append(nums.get(i)).append(",");
				}
				sb.append(nums.get(index[0]));
			}
			sb.append("]").append("\n");
			nums.clear();
		}
		System.out.println(sb);
	}

}
