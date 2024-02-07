import java.util.*;
import java.io.*;

public class d {
	public static final int[] dx = { -1, 0, 1, 0 }; // 북동남서
	public static final int[] dy = { 0, 1, 0, -1 };
	public static char[][] map;
	public static int visit[][];
	public static int N, M;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			char ch[] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = ch[j];
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken()) -1;
		int col = Integer.parseInt(st.nextToken()) -1;
		
	    Queue<int[]> q = new LinkedList<>();
		int ans = Integer.MIN_VALUE;
		int dir = 0;
		for (int i = 0; i < 4; i++) {
			visit = new int[N][M];
			
			int t = dfs(row , col, i , 1);
			if(t == -1) { //무한궤도일때 빠져나온다.
				changeCh(i);
				System.out.print("Voyager");
				return;
			}
			else if(ans < t) {
				ans = t;
				dir = i;
				q.add(new int[] {dir,ans});
			}
		}
		int size = q.size();
		for (int i = 0; i < size; i++) {
			int elem[] = q.poll();
			if(elem[1] == ans) {
				q.add(elem);
			}
		}
		int result[] = q.poll();
		changeCh(result[0]);
		System.out.print(result[1]);
	}

	private static void changeCh(int dir) {
		switch (dir) {
		case 0: System.out.println('U'); break;
		case 1: System.out.println('R'); break;
		case 2: System.out.println('D'); break;
		case 3: System.out.println('L'); break;
		}
	}

	public static int dfs(int row, int col, int dir, int cnt) {
		visit[row][col] = dir+1; // 방문체크

		if (map[row][col] == '\\') {
			dir = ((dir + 1) * 3) % 4;
			
		}else if (map[row][col] == '/') {
			dir = ((dir * 3) + 1) % 4;
		}
		
		int nx = row + dx[dir];
		int ny = col + dy[dir];

		if (check(nx, ny) || map[nx][ny] == 'C') {
			return cnt; // 선을넘거나 블랙홀을 만났을 때
		} else if (visit[nx][ny] == dir+1) {
			return -1; // 방문한 곳 + 같은 방향(무한루프를 돈다.)
		}
		int distance = dfs(nx, ny, dir, cnt + 1);
		return distance;
	}

	private static boolean check(int nx, int ny) {
		return nx < 0 || nx >= N || ny < 0 || ny >= M;
	}
}