import java.io.*;
import java.util.*;

public class MSTKruskalTest {
	
	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
//			return this.weight - o.weight;
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static Edge[] edgeList;
	static int V, E;
	static int parents[];
	
	static void make() {
		parents = new int[V];
		for(int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer stk = new StringTokenizer(str);
		V = Integer.parseInt(stk.nextToken());
		E = Integer.parseInt(stk.nextToken());
		
		edgeList = new Edge[E];
		
		for(int i = 0; i < E; i++) {
			str = br.readLine();
			stk = new StringTokenizer(str);
			
			int from = Integer.parseInt(stk.nextToken());
			int to = Integer.parseInt(stk.nextToken());
			int weight = Integer.parseInt(stk.nextToken());
			edgeList[i] = new Edge(from, to, weight);
		}
		// 간선리스트를 가중치 기준 오름차순 정렬
		Arrays.sort(edgeList);
		
		// V개의 정점으로 make set 작업
		make();
		
		int result = 0;	// MST 비용
		int count = 0;	// 연결된 간선의 개수
		for(Edge edge : edgeList) {
			if(union(edge.from, edge.to)) {	// 비용이 작은 간선 순으로 꺼내어서 처리
				result += edge.weight;
				if(++count == V-1) break;
			}
		}
		
		System.out.println(result);
	}

}
