package tamplate;

import java.util.Scanner;

public class MinCoinTest {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		int money = sc.nextInt();
		int[] D = new int[money+1];
		D[0] = 0;
		
		for(int i = 1; i <= money; i++) {
			//1원시도
			D[i] = D[i-1] + 1;
			//4원시도
			if(i >= 4 && D[i] > D[i-4]+1) D[i] = D[i-4]+1;
			//6원시도
			if(i >= 6 && D[i] > D[i-6]+1) D[i] = D[i-6]+1;
		}
		System.out.println(D[money]);
	}

}
