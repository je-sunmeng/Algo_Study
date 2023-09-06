/*
 * 메모리 	438204KB
 * 실행시간 2372ms
 */

package week06.sunmyeong;

import java.io.*;
import java.util.*;

public class BOJ7662_이중우선순위큐 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			int K = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> tmap = new TreeMap<>();

			for (int i = 0; i < K; i++) {
				String str = br.readLine();
				StringTokenizer stk = new StringTokenizer(str);
				char com = stk.nextToken().charAt(0);
				int num = Integer.parseInt(stk.nextToken());
				if (com == 'I') {
					if (tmap.containsKey(num))
						tmap.put(num, tmap.get(num) + 1);
					else
						tmap.put(num, 1);
				} else if (tmap.size() > 0) {

					Map.Entry<Integer, Integer> tmp = null;
					if (num > 0)
						tmp = tmap.lastEntry();
					else
						tmp = tmap.firstEntry();

					if (tmp.getValue() == 1)
						tmap.remove(tmp.getKey());
					else
						tmap.put(tmp.getKey(), tmp.getValue() - 1);
				}
			}

			if (tmap.size() == 0)
				sb.append("EMPTY").append("\n");
			else
				sb.append(tmap.lastKey()).append(" ").append(tmap.firstKey()).append("\n");
		}

		System.out.println(sb);
	}
}