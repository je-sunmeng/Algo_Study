/*
 * 메모리 	11508KB
 * 실행시간 76ms
 */

package week07.sunmyeong;

import java.io.*;

public class BOJ2941_크로아티아알파벳 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		String[] len2 = {"c=","c-","d-","lj","nj","s=","z="};
		String len3 = "dz=";

		int cnt = 0;
		for(int i = 0; i < str.length(); i++) {
			if(i+3 <= str.length()) {
				if(str.substring(i,i+3).equals(len3)) {
					i+=2;
					cnt++;
					continue;
				}
			}
			if(i+2 <= str.length()) {
				for(int j = 0; j < len2.length; j++) {
					if(str.substring(i,i+2).equals(len2[j])) {
						i+=1;
						break;
					}
				}
				cnt++;
				continue;
			}
			cnt++;
			
		}
		
		System.out.println(cnt);
		

	}

}
