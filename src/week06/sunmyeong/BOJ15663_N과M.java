package week06.sunmyeong;

import java.io.*;
import java.util.*;

public class BOJ15663_N과M {
	static int N, M;
	static String result[];
	static List<String> nums;
	static String tmp;
	static StringBuilder sb = new StringBuilder();
	static Set<String> set = new LinkedHashSet<>();
	
	public static void printNums() {
		tmp = "";
		for(int i = 0; i < M; i++) {
			tmp += result[i] + " ";
		}
		if(set.add(tmp))
		sb.append(tmp).append("\n");
	}
	
	public static void Per(int cnt, int flag) {
		if(cnt == M) {
			printNums();
			return;
		}
		
		for(int i = 0 ; i < nums.size(); i++) {
			if((flag & 1<<i)!=0) continue;
			result[cnt] = nums.get(i);
			Per(cnt+1, flag|1<<i);
			if(cnt > 0 && result[cnt-1] == result[cnt]) flag |= 1<<(i+1);
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer stk = new StringTokenizer(str);
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		
		nums = new ArrayList<>();
		result = new String[M];
		
		str = br.readLine();
		stk = new StringTokenizer(str);
		for(int i = 0; i < N; i++) {
			nums.add(stk.nextToken());
		}
		Collections.sort(nums);
		
		Per(0,0);
		
		System.out.println(sb);
	}

}
