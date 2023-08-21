/*
 * https://www.acmicpc.net/problem/17952
 * 메모리 205516KB
 * 실행시간 1140ms
 */

import java.io.*;
import java.util.*;

public class BOJ17952_과제는끝나지않아 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	//버퍼드리더 호출
		
		int N = Integer.parseInt(br.readLine());	// 전체 시간 입력
		int score = 0;	// 평가점수를 저장할 변수
		
		Stack<int[]> task = new Stack<>();	//작업을 쌓을 스택 선언 / 작업{평가점수, 소요시간}
		
		for(int t = 0; t < N; t++) {	// 전체 시간을 돌며
			String str = br.readLine();	// 입력값을 받음
			StringTokenizer stk = new StringTokenizer(str);	// 입력값 토큰화
			if(Integer.parseInt(stk.nextToken()) == 1) {	// 입력값이 1로 시작한다면
				int A = Integer.parseInt(stk.nextToken());	// 해당 작업의 평가점수와
				int T = Integer.parseInt(stk.nextToken());	// 해당 작업을 해결하는데 걸리는 시간을
				
				task.push(new int[] {A,T});	// 스택에 push
			}
			if(task.isEmpty()) continue;
			task.peek()[1]--;	// 가장 마지막에 주어진 작업의 남은 시간을 1 감소
			if(task.peek()[1] == 0) score += task.pop()[0];	// 해닥 작업의 시간이 0이라면 작업을 완료한 것이므로 스택에서 빼고 점수 증가
		}
		
		System.out.println(score);	// 최종 점수 출력
	}

}
