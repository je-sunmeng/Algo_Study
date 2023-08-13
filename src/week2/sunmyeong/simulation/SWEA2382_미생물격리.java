/*
 * 메모리 74228KB
 * 실행시간 1426ms 
 */

package week2.sunmyeong.simulation;

import java.io.*;
import java.util.*;

public class SWEA2382_미생물격리 {
	static int N, M, K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			String str = br.readLine();
			StringTokenizer stk = new StringTokenizer(str);
			N = Integer.parseInt(stk.nextToken());	//map의 크기
			M = Integer.parseInt(stk.nextToken());	//이동 횟수(시간)
			K = Integer.parseInt(stk.nextToken());	//미생물 개수
			int sum = 0;
			temp map[][] = new temp[N][N];	//해당위치에서 (미생물의 번호, 최대 미생물 숫자, 미생물 누적 합)을 변수로 같는 클래스 배열 
			List<MicroBe> micro = new LinkedList<>();	// 미생물들 관리 (위치[], 숫자, 방향, 유효한지)를 변수로 같은 클래스 배열
			for (int i = 0; i < K; i++) {	
				str = br.readLine();
				stk = new StringTokenizer(str);
				int row = Integer.parseInt(stk.nextToken());
				int col = Integer.parseInt(stk.nextToken());
				int count = Integer.parseInt(stk.nextToken());
				int dir = Integer.parseInt(stk.nextToken());
				micro.add(new MicroBe(row, col, count, dir));	// 행, 열, 숫자, 방향으로 미생물 생성
			}
			for(int time = 0; time < M; time++) {		// M번 반복시행
				for(int i = micro.size()-1; i >= 0; i--) {
					micro.get(i).move();	// 미생물을 움직임
					if(micro.get(i).count == 0) micro.remove(i);	//움직인 후 미생물의 숫자가 0이면 제거
				}
				for(int i = 0; i < micro.size(); i++) {	// 남아있는 미생물 만큼 반복
					if(micro.get(i).isTerminated) continue;	// remove했을때 index가 꼬이는걸 방지하기위해 유효성만 저장
					int r = micro.get(i).pos[0]; 	// i번 미생물의 row
					int c = micro.get(i).pos[1];	// i번 미생물의 col

					if(map[r][c] == null) {
						map[r][c] = new temp(i, micro.get(i).count);	// i번미생물의 숫자로 Sum, Max
					}
					else { // 중복위치
						map[r][c].sumCount += micro.get(i).count;
						if(micro.get(i).count > map[r][c].maxCount) {	//새로들어온 미생물의 숫자가 기존의 최대숫자보다 크다면
							micro.get(map[r][c].index).count = 0;
							micro.get(map[r][c].index).isTerminated = true;
							map[r][c].maxCount = micro.get(i).count;
							map[r][c].index = i;
						}
						else { // index.maxcount > i.count
							micro.get(i).count = 0;
							micro.get(i).isTerminated = true;
						}
					}
				}
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++) {
						if(map[i][j] != null) {
							micro.get(map[i][j].index).count = map[i][j].sumCount;
							map[i][j] = null;
						}
					}
				}
			}
			for(int i = 0; i < micro.size(); i++) {
				sum += micro.get(i).count;
			}
			System.out.println("#"+test+" "+sum);
		}
	}
}
class temp{
	int index;	// 가장 많은 숫자의 미생물 번호
	int maxCount;	// index번 미생물의 갯수
	int sumCount;	// 해당 칸을 방문한 미생물의 누적합
	public temp(int index, int count) {
		this.index = index;
		this.maxCount = count;
		this.sumCount = count;
	}
}

class MicroBe extends SWEA2382_미생물격리{
	int[] pos = new int[2]; // pos[0]: row, pos[1]: col
	int count;	// 개수
	int dir;	// 방향
	boolean isTerminated = false;	// 유효성

	public MicroBe(int row, int col, int count, int dir) {
		this.pos[0] = row;
		this.pos[1] = col;
		this.count = count;
		this.dir = dir;
	}

	public void move() {
		switch (this.dir) {	// 위 아래 좌 우
		case 1:
			this.pos[0]--;
			if (this.pos[0] == 0) {
				this.dir = 2;
				this.count /= 2;
			}
			break;
		case 2:
			this.pos[0]++;
			if (this.pos[0] == N - 1) {
				this.dir = 1;
				this.count /= 2;
			}
			break;
		case 3:
			this.pos[1]--;
			if (this.pos[1] == 0) {
				this.dir = 4;
				this.count /= 2;
			}
			break;
		case 4:
			this.pos[1]++;
			if (this.pos[1] == N - 1) {
				this.dir = 3;
				this.count /= 2;
			}
			break;
		default:
			break;
		}
	}
}