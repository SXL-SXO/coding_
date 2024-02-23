package Feb_20;

import java.io.*;
import java.util.*;

public class B_줄세우기_2252_teacher {
	static int N,M;
	static int[] topo;
	static List<List<Integer>> graph = new ArrayList<>();
	static Queue<Integer> queue = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		topo = new int[N+1];
		for(int i=0;i<=N;i++) {
			graph.add(new ArrayList<>());
		}
		// bfs <= 진입차수가 0인 정점을 모두 queue에 넣고 시작
		// 출력은 꺼내면서 만들면 된다
		// queue 에서 꺼내서 이동할 수 있는 (학생 순서를 세우는 - 꺼낸 학생 뒤에 오는 학생) 정점으로 이동하면서
        // 그 정점의 진입 차수를 1개 줄임. 만약 줄이고 난 뒤 진입차수가 0이 되면 queue에 넣는다. 
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph.get(A).add(B);
			topo[B]++;
		}
		
		for(int i=1;i<=N;i++) {
			if(topo[i]==0) queue.offer(i);
		}
		while(!queue.isEmpty()) {
			int no = queue.poll();
			sb.append(no).append(" ");
			
			//꺼낸 번호에서 갈 수 있는 번호 탐색
			List<Integer> list = graph.get(no);
			int size = list.size();
			
			for(int i=0;i<size;i++) {
				int temp = list.get(i);
				
				topo[temp]--;
				
				if(topo[temp]==0)
					 queue.offer(temp);
			}
		}
		System.out.println(sb.toString());
	}
}
