/*
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV4yBSgaCaYDFAUx
 * 메모리 119392 KB
 * 실행시간 595 ms
 */

package week3.sunmyeong;

import java.io.*;
import java.util.*;

public class SWEA1803_ShortestPathFaster {
	static int N, M;
	
	static class Node{
		int index;
		long cost;
		
		public Node(int index, long cost) {
			this.index = index;
			this.cost = cost;
		}
	}
	
	public static long dijkstra(List<List<Node>> adjList, int start, int end){
		long[] distance = new long[N];	// 거리를 담을 배열
		Arrays.fill(distance, Long.MAX_VALUE);	// 모든 거리를 무한대로 초기화
		
		PriorityQueue<Node> heap = new PriorityQueue<Node>((o1, o2)-> Long.compare(o1.cost, o2.cost));	// Node의 비용을 비교하여 저장하는 minheap 선언
		
		heap.offer(new Node(start, 0));	// 시작 지점을 minheap에 offer
		distance[start] = 0;	// 시작지점의 거리는 0
		while(!heap.isEmpty()) {	// minheap이 빌때까지 반복
			Node curNode = heap.poll();	// 방문할 노드를 poll
			
			if(curNode.index == end) {	// 현재 노드가 목표 노드라면 break;
				break;
			}
			
			if(distance[curNode.index] < curNode.cost)continue;	// 해당 노드에 대한 당시 비용이 현재까지의 최소거리보다 크다면 continue
			
			for(int i = 0; i < adjList.get(curNode.index).size(); i++) {	// 현재 노드의 인접 노드들을 탐색
				Node nxtNode = adjList.get(curNode.index).get(i);	// 다음 노드 선정
				if(distance[nxtNode.index] > curNode.cost + nxtNode.cost) {	// 다음 노드까지의 거리가 (현재노드까지의 거리 + 해당 노드까지의 거리) 보다 크다면 
					distance[nxtNode.index] = curNode.cost + nxtNode.cost;	// 다음 노드까지의 거리를 갱신
					
					heap.offer(new Node(nxtNode.index, distance[nxtNode.index]));	// 그 거리를 cost로 하여 minheap에 offer
				}
			}
			
		}
		return distance[end];
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int test = 1; test <= T; test++) {
			String str = br.readLine().trim();
			StringTokenizer stk = new StringTokenizer(str);
			N = Integer.parseInt(stk.nextToken());
			M = Integer.parseInt(stk.nextToken());
			int start = Integer.parseInt(stk.nextToken())-1;
			int end = Integer.parseInt(stk.nextToken())-1;

			List<List<Node>> adjList = new ArrayList<>();
			for(int i = 0; i < N; i++) adjList.add(new ArrayList<Node>());
			
			
			for(int i = 0; i < M; i++) {
				str = br.readLine().trim();
				stk = new StringTokenizer(str);
				int n1 = Integer.parseInt(stk.nextToken())-1;
				int n2 = Integer.parseInt(stk.nextToken())-1;
				int weight = Integer.parseInt(stk.nextToken());
				adjList.get(n1).add(new Node(n2, weight));
				adjList.get(n2).add(new Node(n1, weight));
			}
			long result = dijkstra(adjList, start, end);
			sb.append("#").append(test).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}
