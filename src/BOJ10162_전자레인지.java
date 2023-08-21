/*
 * https://www.acmicpc.net/problem/10162
 * 메모리 11512KB
 * 실행시간 84ms
 */

import java.io.*;

public class BOJ10162_전자레인지 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //버퍼드리더 호출
		StringBuilder sb = new StringBuilder();	// 스트링빌더 선언
		int T = Integer.parseInt(br.readLine());	// 베이킹 레시피의 걸리는 시간 입력
		
		if(T%10 != 0) {	// 버튼 별 가능한 시간이 10초의 배수이므로 T가 10으로 나눠떨어지지 않는다면 실패 
			System.out.println(-1);	// -1을 출력하고
			return;	// 프로그램 종료
		}
		
		sb.append(T/300).append(" ");	// 5분 버튼을 누를 수 있는 최대 값 출력
		T %= 300;	// 걸리는 시간을 5분버튼을 최대로 누르고 남은 시간으로 조정
		sb.append(T/60).append(" ");	// 1분 버튼을 누를 수 있는 최대 값 출력
		T %= 60;	// 걸리는 시간을 5분버튼과 1분버튼을 최대로 누르고 남은 시간으로 조정
		sb.append(T/10).append(" ");	// 10초 버튼을 누를 수 있는 최대 값 출력

		System.out.println(sb);	// 출력형식에 맞게 버튼 수 출력
		
	}

}
