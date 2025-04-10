import java.util.*;
import java.io.*;
public class Main
{
	static boolean res = false;
	static int N, M, O;
	static char input[][];
	static int dy[] = {-1, 0, 1, 0};
	static int dx[] = {0, 1, 0, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Node n = new Node(-1, -1, -1, -1);
		input = new char[N][];
		for(int i=0; i<N; i++) {
			input[i] = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				if(input[i][j]=='R') {
					n.ry = i;
					n.rx = j;
				}else if(input[i][j]=='B') {
					n.by = i;
					n.bx = j;
				}else if(input[i][j]=='O') O = i*M+j; 
			}
		}
			
		turn(-1, 0, n);
		if(res) System.out.print(1);
		else System.out.print(0);
	}
	static void turn(int dir, int count, Node n) {
		if(res || count>10 || input[n.by][n.bx] == 'O') {
			// System.out.println("F "+count+" : "+n.ry+" "+n.rx+" "+n.by+" "+n.bx);

			return;
		} else if(input[n.ry][n.rx] == 'O') {
			// System.out.println("T "+count+" : "+n.ry+" "+n.rx+" "+n.by+" "+n.bx);
			res = true;
			return;
		}
        // System.out.println("count : "+count);
        // for(int i=0;i<N;i++) System.out.println(Arrays.toString(input[i]));

		Node next;
		for(int i=0; i<4; i++) {
			if(dir==i) continue;

			next = new Node();
			next.ry = n.ry;
			next.rx = n.rx;
			next.by = n.by;
			next.bx = n.bx;
			if(i%2 == 0) {
				// System.out.println( move_y(next.ry, next.rx, i)+" "+ move_y(next.by, next.bx, i) +" "+ move_y(next.ry, next.rx, i));
				next.ry = move_y(n.ry, n.rx, i);
			     // System.out.print(next.ry+" ");
				next.by = move_y(n.by, n.bx, i);
			     // System.out.print(next.by+" ");
				next.ry = move_y(next.ry, next.rx, i);
			     // System.out.println(next.ry+" ");
			} else {
			    next.rx = move_x(n.ry, n.rx, i);
			     // System.out.print(next.rx+" ");
				next.bx = move_x(n.by, n.bx, i);
			     // System.out.print(next.bx+" ");
				next.rx = move_x(next.ry, next.rx, i);
			     // System.out.println(next.rx+" ");
			}

// 			System.out.println(count + " : "+i+" : " + n.ry+" "+n.rx+" "+n.by+" "+n.bx+" / " + next.ry+" "+next.rx+" "+next.by+" "+next.bx);
            // System.out.println(input[n.ry][n.rx] +" "+input[n.by][n.bx]+" "+input[next.ry][next.rx] +" "+input[next.by][next.bx]);
			if(next.ry == n.ry && next.rx == n.rx && next.by == n.by && next.bx == n.bx) continue;
			turn(i, count+1, next);
			input[next.ry][next.rx] = '.';
			input[next.by][next.bx] = '.';
			input[n.ry][n.rx] = 'B';
			input[n.by][n.bx] = 'B';
			input[O/M][O%M] ='O';
		}

		return;
	}
	static int move_y(int b, int x, int dir) {
		if(input[b][x] == 'O') return b;
		input[b][x] = '.';

		int y = b, ny;
		while(true) {
			ny = y+dy[dir];

// 			System.out.println("y :"+y+", ny :"+ny);
			if( ny<1 || ny>=N-1 || input[ny][x]=='#' || input[ny][x]=='R' || input[ny][x]=='B') {
				// System.out.println(input[ny][x]);
				input[y][x] = 'B';
				return y;
			}

			y = ny;
			if(input[y][x]=='O') return y;
		}
	}
	static int move_x(int y, int b, int dir) {
		if(input[y][b] == 'O') return b;
		input[y][b] = '.';

		int x = b, nx;
		while(true) {
			nx = x+dx[dir];
// 			System.out.println("x :"+x+", nx :"+nx);
			if( nx<1 || nx>=M-1|| input[y][nx]=='#' || input[y][nx]=='R' || input[y][nx]=='B') {
				input[y][x] = 'B';
				return x;
			}

			x = nx;
			if(input[y][x]=='O') return x;
		}
	}
	static class Node {
		int ry, rx, by, bx;
		Node() {
			ry = -1;
			rx = -1;
			by = -1;
			bx = -1;
		}
		Node(int ry, int rx, int by, int bx) {
			this.ry=ry;
			this.by=by;
			this.rx=rx;
			this.bx=bx;
		}
	}
}
