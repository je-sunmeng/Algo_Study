import java.io.*;
import java.util.*;

public class 나무의키 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test = 1; test <= T; test++) {
			int N = Integer.parseInt(br.readLine());
			int[] tree = new int[N];
			String str = br.readLine();
			StringTokenizer stk = new StringTokenizer(str);
			for(int i = 0; i < N; i++) {
				tree[i] = Integer.parseInt(stk.nextToken());
			}
			Arrays.sort(tree);
			int day = 0;	// 현재 날짜
			int[] gap = new int[N];	// 최대값과 차이 배열
			int odd = 0, even = 0;
			int max = tree[N-1];	// 최대 나무 크기
			
			for(int i = 0; i < N; i++) {
				odd += (max-tree[i])%2;	// 홀수날짜
				even += (max-tree[i])/2;	// 짝수날짜
			}
			
			if(even > odd) {	// 이틀의 홀수일을 하루의 짝수일로 전환
				int tmp = (even-odd)/3;
				odd += 2*tmp;
				even -= tmp;
			}
			
			if(odd > even) {	// 홀수일이 남았을 때
				day = even*2 + (odd-even)*2-1;	// 짝수일*2(홀짝) + 남은 홀수일하나당 이틀 소모 -1
			}
			else {	// 짝수일이 남았을 때
				day = odd*2 + (even - odd)/2*3 + (even-odd)%2 * 2;	// 홀수일*2 + 남은짝수일 2개를 3일소모 + 짝수일이 홀수개라면 이틀 소모  
			}
			
			System.out.println("#"+test+" "+day);

		}
	}
}
