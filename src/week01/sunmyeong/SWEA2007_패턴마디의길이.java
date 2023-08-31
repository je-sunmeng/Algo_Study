package week01.sunmyeong;
import java.io.*;
import java.util.*;

public class SWEA2007_패턴마디의길이 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test = 1; test <= T; test++) {
			String str = br.readLine();
			char start = str.charAt(0);
			go : for(int i = 1; i < 30; i++) {
				if(str.charAt(i) == start) {
					for(int j = 1; j < 10; j++) {
						if(str.charAt(i+j) != str.charAt(j)) break;
						if(j == 9) {
							sb.append("#").append(test).append(" ").append(i).append("\n");
							break go;
						}
					}
				}
			}
		}
		
		System.out.println(sb);
	}

}
