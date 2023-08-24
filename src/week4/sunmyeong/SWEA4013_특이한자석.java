package week4.sunmyeong;

import java.io.*;
import java.util.*;

public class SWEA4013_특이한자석 {
	static List<Integer>[] magnet;
	
	public static void spin(int magnetNum, int dir) {
		if(dir == 1) {
			magnet[magnetNum].add(0, magnet[magnetNum].remove(7));
		}
		else magnet[magnetNum].add(7, magnet[magnetNum].remove(0));		
	}
	
	public static boolean leftCheck (int magnetNum) {
		if(magnetNum > 0) {
			if(magnet[magnetNum].get(6) != magnet[magnetNum-1].get(2)) return true;
		}
		return false;
	}
	
	public static boolean rightCheck (int magnetNum) {
		if(magnetNum < 3) {
			if(magnet[magnetNum].get(2) != magnet[magnetNum+1].get(6)) return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		magnet = new ArrayList[4];
		for(int test = 1; test <= T; test++) {
			int K = Integer.parseInt(br.readLine());
			for(int i = 0; i < 4; i++) {
				String str = br.readLine();
				StringTokenizer stk = new StringTokenizer(str);
				magnet[i].add(Integer.parseInt(stk.nextToken()));				
			}
			for(int i = 0; i < K; i++) {
				String str = br.readLine();
				StringTokenizer stk = new StringTokenizer(str);
				int mum = Integer.parseInt(stk.nextToken());
				int dir = Integer.parseInt(stk.nextToken());
				
				int[] spinAble = new int[4];
				
				
					

				
			}
			
		}
		
		
		
	}

}
