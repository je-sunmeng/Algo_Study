/*
 * https://www.acmicpc.net/problem/2931
 * 메모리 11512KB
 * 실행시간 76ms
 */

import java.io.*;
import java.util.*;

public class BOJ2931_가스관 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //버퍼드리더 호출
		
		String str = br.readLine();	// R C 가 적힌 문자열 입력
		StringTokenizer stk = new StringTokenizer(str);	// 문자열을 토큰화
		
		int R = Integer.parseInt(stk.nextToken());	// 행 길이 R 선언
		int C = Integer.parseInt(stk.nextToken());	// 열 길이 C 선언
		
		char[][] map = new char[R][C];	// R*C크기의 map 선언

		int blank[] = new int[] {-1, -1};	// 찾아야하는 빈칸의 {row, col}
		boolean[] enableBlock = new boolean[7]; // |, -, +, 1, 2, 3, 4 중 사용가능한 것을 체크하는 배열
		String blocks = "|-+1234";

		for(int i = 0; i < R; i++) {	// 모든 행을 반복하며
			str = br.readLine();	// 각 행에 대한 입력을 받고
			for(int j = 0; j < C; j++) {	// 모든 열을 반복하며
				map[i][j] = str.charAt(j);	// map[행][열]에 값 대입
			}
		}		

		// 모든 행렬을 돌며 상 하 좌 우를 비교 -> 블럭이 있어야하는 부분에 .이 있다면 지워진 빈칸으로 정의
		go: for(int i = 0; i < R; i++) {	// 모든 행에 대해 반복
			for(int j = 0; j < C; j++) {	// 모든 열에 대해 반복
				char now = map[i][j];	// 현재 위치의 블록 종류
				if(now == '|') { // | 입력 블럭일때
					if(i>0 && map[i-1][j] == '.') blank = new int[] {i-1,j};	//위가 '.'이라면 그곳이 빈칸
					if(i<R-1 && map[i+1][j] == '.')	blank = new int[] {i+1,j};	//아래가 '.'이라면 그곳이 빈칸						
				}
				else if(now == '-') { // - 입력 블럭일때
					if(j>0 && map[i][j-1] == '.') blank = new int[] {i,j-1};	// 왼쪽이 '.'이라면 그곳이 빈칸
					if(j<C-1 && map[i][j+1] == '.') blank = new int[] {i,j+1};	// 오른쪽이 '.'이라면 그곳이 빈칸				
				}
				else if(now == '+') {	// + 입력 블럭일때
					if(i>0 && map[i-1][j] == '.') blank = new int[] {i-1,j};	// 위가 '.'이라면 그곳이 빈칸
					if(i<R-1 && map[i+1][j] == '.') blank = new int[] {i+1,j};	// 아래가 '.'이라면 그곳이 빈칸
					if(j>0 && map[i][j-1] == '.') blank = new int[] {i,j-1};	// 왼쪽이 '.'이라면 그곳이 빈칸
					if(j<C-1 && map[i][j+1] == '.') blank = new int[] {i,j+1};	// 오른쪽이 '.'이라면 그곳이 빈칸
				}
				else if(now == '1') {// 1 입력 블럭일때
					if(j<C-1 && map[i][j+1] == '.') blank = new int[] {i,j+1};	// 오른쪽이 '.'이라면 그곳이 빈칸
					if(i<R-1 && map[i+1][j] == '.') blank = new int[] {i+1,j};	// 아래가 '.'이라면 그곳이 빈칸
				}
				else if(now == '2') { // 2 입력 블럭일때
					if(i>0 && map[i-1][j] == '.') blank = new int[] {i-1,j};	//위	가 '.'이라면 그곳이 빈칸
					if(j<C-1 && map[i][j+1] == '.') blank = new int[] {i,j+1};	// 오른쪽이 '.'이라면 그곳이 빈칸
				}
				else if(now == '3') { // 3 입력 블럭일때
					if(i>0 && map[i-1][j] == '.') blank = new int[] {i-1,j};	//위	가 '.'이라면 그곳이 빈칸
					if(j>0 && map[i][j-1] == '.') blank = new int[] {i,j-1};	// 왼쪽이 '.'이라면 그곳이 빈칸
				}
				else if(now == '4') { // 4 입력 블럭일때
					if(j>0 && map[i][j-1] == '.') blank = new int[] {i,j-1};	// 왼쪽이 '.'이라면 그곳이 빈칸
					if(i<R-1 && map[i+1][j] == '.') blank = new int[] {i+1,j};	// 아래가 '.'이라면 그곳이 빈칸
				}
				if(blank[0] != -1) break go;
			}
		}
		
		// 빈칸이 맨 위 / 맨 아래 일때 위 / 아래로 향하는 블록 사용불가 
		if(blank[0] == 0) enableBlock[0]=enableBlock[2]=enableBlock[4]=enableBlock[5]=true;
		if(blank[0] == R-1) enableBlock[0]=enableBlock[2]=enableBlock[3]=enableBlock[6]=true;
		// 빈칸이 맨 왼쪽 / 맨 오른쪽일때 왼/오른쪽으로 향하는 블록 사용불가
		if(blank[1] == 0) enableBlock[1]=enableBlock[2]=enableBlock[5]=enableBlock[6]=true;
		if(blank[1] == C-1) enableBlock[1]=enableBlock[2]=enableBlock[3]=enableBlock[4]=true;


		if(blank[0] > 0) { // 빈칸의 위 검사
			switch(map[blank[0]-1][blank[1]]) {
			// 아래로 길이 나있는 블럭 이면, 또는 집/유치원 이라면			
			case '|': case '+': case '1': case '4':
				// 위로 길이 나 있지 않은 블럭은 사용 불가
				enableBlock[1]=enableBlock[3]=enableBlock[6]=true;
				break;
			// 아래로 길이 나있지 않은 블럭 이면, 또는 빈 블럭이라면
			case '-': case '2': case '3': case '.': case 'M':case 'Z':
				// 위로 길이 나있는 블럭은 사용 불가
				enableBlock[0]=enableBlock[2]=enableBlock[4]=enableBlock[5]=true;
				break;
			}
				
		}
		if(blank[0] < R-1) {	// 빈칸의 아래검사
			switch(map[blank[0]+1][blank[1]]) {
			// 위로 길이 나있는 블럭이면, 또는 집/유치원 이라면
			case '|': case '+': case '2': case '3': 
				// 아래로 길이 나있지 않은 블럭은 사용 불가
				enableBlock[1]=enableBlock[4]=enableBlock[5]=true;
				break;
			// 위로 길이 나있지 않은 블럭이면, 또는 빈 블럭이라면
			case '-': case '1': case '4': case '.': case 'M':case 'Z':
				// 아래로 길이 나있는 블럭은 사용불가
				enableBlock[0]=enableBlock[2]=enableBlock[3]=enableBlock[6]=true;
				break;
			}
		}
		if(blank[1] > 0) {	// 빈칸의 왼쪽 검사
			switch(map[blank[0]][blank[1]-1]) {
			// 오른쪽으로 길이 나있는 블럭이면, 또는 집/유치원 이라면
			case '-': case '+': case '1': case '2':
				// 왼쪽으로 길이 나있지 않은 블럭은 사용 불가
				enableBlock[0]=enableBlock[3]=enableBlock[4]=true;
				break;
			// 오른쪽으로 길이 나있지 않은 불럭이면, 또는 빈 블럭이라면
			case '|': case '3': case '4': case '.': case 'M':case 'Z':
				// 왼쪽으로 길이 나있는 블럭은 사용불가
				enableBlock[1]=enableBlock[2]=enableBlock[5]=enableBlock[6]=true;
				break;
			}
		}
		if(blank[1] < C-1) {	// 빈칸의 오른쪽 검사
			switch(map[blank[0]][blank[1]+1]) {
			// 왼쪽으로 길이 나있는 블럭이면, 또는 집/유치원 이라면
			case '-': case '+': case '3': case '4':
				// 오른쪽으로 길이 나있지 않은 블럭은 사용 불가
				enableBlock[0]=enableBlock[5]=enableBlock[6]=true;
				break;
			// 왼쪽으로 길이 나있지 않은 불럭이면, 또는 빈 블럭이라면
			case '|': case '1': case '2': case '.': case 'M':case 'Z':
				// 오른쪽으로 길이 나있는 블럭은 사용불가
				enableBlock[1]=enableBlock[2]=enableBlock[3]=enableBlock[4]=true;
				break;
			}
		}

		int index = 0;
		for(int i = 0; i < 7; i++) {	// enableBlock배열을 돌면서
			if(!enableBlock[i]) {	// 사용가능한 블럭이라면
				index = i;
			}
		}
		
		System.out.println((blank[0]+1) + " " + (blank[1]+1) + " " + blocks.charAt(index)); // 1부터 시작하도록 좌표 조정후 출력
				
	}

}
