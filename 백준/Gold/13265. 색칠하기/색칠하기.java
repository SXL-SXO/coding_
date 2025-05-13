import java.util.*;
import java.io.*;

public class Main
{
	static int T, N, M;
	static List<List<Integer>> list = new ArrayList<>();
	static boolean visit[], check[];
	static Queue<Integer> queue = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			list.clear();
			for(int i=0; i<=N; i++) list.add(new ArrayList<>());
			visit = new boolean[N+1];
			check = new boolean[N+1];

			int a, b;
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				list.get(a).add(b);
				list.get(b).add(a);
			}

			if(go()) sb.append("possible\n");
			else sb.append("impossible\n");
		}
		
		System.out.print(sb);
	}
	static boolean bfs(int idx) {
		queue.clear();
		queue.offer(idx);

		boolean even = true;
		int temp, size;

		while(!queue.isEmpty()) {
			size = queue.size();
			for(int s=0; s<size; s++) {
				temp = queue.poll();

				if(visit[temp] && check[temp] != even) return false;
				else if(visit[temp]) continue;
				
			    visit[temp] = true;
			    check[temp] = even;
			    for(int n : list.get(temp)){
			        queue.offer(n);
			    }
			}
			even = !even;
		}
		return true;
	}
	static boolean go() {
		for(int i=1; i<=N; i++) {
			if(visit[i]) continue;
			if(!bfs(i)) return false;
		}
		return true;
	}
}
