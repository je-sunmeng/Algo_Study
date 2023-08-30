package week01.sunmyeong;
import java.io.*;
import java.util.*;

public class 알고스탁 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int test = 1; test <= T; test++) {
			String str = br.readLine();
			StringTokenizer stk = new StringTokenizer(str);					
					
			int Ms = Integer.parseInt(stk.nextToken());
			int Ma = Integer.parseInt(stk.nextToken());
			str = br.readLine();
			stk = new StringTokenizer(str);
			int N = Integer.parseInt(stk.nextToken());
			int L = Integer.parseInt(stk.nextToken());
			int[][] table = new int[N][L+1];
			int[][] gap = new int[N][L+1];
			int origin = Ms+Ma*L;
			Queue<int[]> myStock = new ArrayDeque<>(); // 종목, 개수
			PriorityQueue<double[]> plus = new PriorityQueue<double[]>(new Comparator<double[]>() {
				@Override
				public int compare(double[] o1, double[] o2) {
					if(o1[1] > o2[1]) return -1;
					else if (o1[1] < o2[1]) return 1;
					else return 0;
				}
			}); 
			for(int i = 0; i < N; i++) {
				str = br.readLine();
				stk = new StringTokenizer(str);
				for(int j = 0; j <= L; j++) {
					table[i][j] = Integer.parseInt(stk.nextToken());
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < L; j++) {
					gap[i][j] = table[i][j+1] - table[i][j];
				}
			}
			
			for(int l = 0; l <= L; l++) {
				if(l!=0)Ms+= Ma;
				while(!myStock.isEmpty()) {	// 매도
					int[] tmp = myStock.poll();
					Ms += table[tmp[0]][l]*tmp[1];
				}
				
				for(int i = 0; i < N; i++) {
					if(gap[i][l] > 0) plus.offer(new double [] {i,(double)gap[i][l]/table[i][l]});	// 지금 사면 이득을 볼수있는 {종목, 상승률}
				}
				
				while(!plus.isEmpty()) {	// 매수
					double[] tmp = plus.poll();
					int stock = (int) tmp[0];
					if(Ms >= table[stock][l]) {
						myStock.offer(new int[] {stock, Ms/table[stock][l]});	// {종목, 개수}
						Ms %= table[stock][l];
					}
				}
			}
			
			System.out.println("#"+test+" "+(Ms-origin));
					
		}

	}

}
