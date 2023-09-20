package week08.sunmyeong;

import java.io.*;
import java.util.*;

public class BOJ1300_K번째수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
//		int[] nums = new int[N*N];
		int[][] map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = (i+1)*(j+1);
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(map[i][j]+"\t");
			}
			System.out.println();
		}
		
//		Arrays.sort(nums);
//		System.out.println(nums[k-1]);
	}

}
