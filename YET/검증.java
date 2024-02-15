import java.io.*;
import java.util.*;

public class 검증 {
	static int T,H,W,N,R,C;
	static char[] input;
	static char[][] map;
	static int dy[] = {-1, 1, 0, 0};
	static int dx[] = {0, 0, -1, 1};
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][];
			for(int i=0;i<H;i++) {
				map[i] = br.readLine().toCharArray();
				for(int j=0;j<W;j++) {
					if(map[i][j]=='<'||map[i][j]=='>'||map[i][j]=='^'||map[i][j]=='v') {
						R=i; C=j;
					}
				}
			}
			N = Integer.parseInt(br.readLine());
			input = br.readLine().toCharArray();

			for(char c:input) {
				switch(c) {
					case 'U': map[R][C] = '^'; move(0); break;
					case 'D': map[R][C] = 'v'; move(1); break;
					case 'L': map[R][C] = '<'; move(2); break;
					case 'R': map[R][C] = '>'; move(3); break;
					case 'S': shoot(); break;
				}
			}
			sb.append("#").append(t).append(" ");
			for(char[] ma : map) {
				for(char m : ma) {
					sb.append(m);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
		
	}
	static void move(int type) {
		int my = R+dy[type];
		int mx = C+dx[type];
		if( mx>=W || mx<0 || my>=H || my<0 ) return;
		else if(map[my][mx]=='*'||map[my][mx]=='#'||map[my][mx]=='-') return;
		map[my][mx] = map[R][C];
		map[R][C] = '.';
		R=my; C=mx;
	}
	static void shoot() {
		char type = map[R][C];
		switch(type) {
			case '^' : 
				for(int i=R-1;i>-1;i--) {
					if(map[i][C]=='*') {
						map[i][C]='.';
						break;
					}else if(map[i][C]=='#')
						break;
				}
				break;
			case 'v' : 
				for(int i=R+1;i<H;i++) {
					if(map[i][C]=='*') {
						map[i][C]='.';
						break;
					}else if(map[i][C]=='#')
						break;
				}
				break;
			case '<' : 
				for(int i=C-1;i>-1;i--) {
					if(map[R][i]=='*') {
						map[R][i]='.';
						break;
					}else if(map[R][i]=='#')
						break;
				}
				break;
			case '>' : 
				for(int i=C+1;i<W;i++) {
					if(map[R][i]=='*') {
						map[R][i]='.';
						break;
					}else if(map[R][i]=='#')
						break;
				}

		}
	}
}
