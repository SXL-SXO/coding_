import java.io.*;
import java.util.*;

/**
 * B_다리만들기2_17472
 */
public class B_다리만들기2_17472 {
    static int N, M, visit, id = 1, answer = 0, count =0;;
    static int map[][];
    static int parent[];
    static List<island> Land = new ArrayList<>();
    static PriorityQueue<Node> pqueue = new PriorityQueue<>((o1,o2)-> o1.c-o2.c);

    static int dy[] = {-1,1,0,0};
    static int dx[] = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<M;j++){
                map[i][j] = -Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0;i<N;i++){
            for(int j = 0;j<M;j++){
                if(map[i][j]==-1){
                    whereIsIsland(i,j);
                }
            }
        }
        
        // for(int i = 0;i<N;i++){
        //     for(int j = 0;j<M;j++){
        //         System.out.print(map[i][j]+" ");
        //     }
        //     System.out.println("");
        // }

        for(int i=0; i<Land.size(); i++){
            check(i);
        }

        visit = 0;

        Node temp;
        parent = new int[Land.size()+1];
        makeSet();
        
        while(!pqueue.isEmpty()&&count!=Land.size()-1){
            temp = pqueue.poll();
            
            // 둘 다 연결되어있다면 노드 무시
            if(findSet(temp.v1)==findSet(temp.v2)) continue;
            union(temp.v1, temp.v2);
            findSet(temp.v1);
            findSet(temp.v2);
            answer += temp.c;            
            count++;
            //System.out.println(temp.v1+" "+temp.v2+" "+temp.c+" "+answer);
        }
        if(count!=Land.size()-1) answer=-1;
        for(int i=1;i<=Land.size();i++){
            findSet(i);
            if(parent[i]!=1) {
                answer=-1;
                break;
            }
        }

        System.out.println(answer);
    }
    static void makeSet(){
        for(int i=1;i<=Land.size();i++)
            parent[i]=i;
    }
    static int findSet(int x){
        if(parent[x]==x) return x;
        return parent[x] = findSet(parent[x]);
    }
    static void union(int x, int y){
        int px = findSet(x);
        int py = findSet(y);
        if(px<py) parent[py] = px;
        else parent[px] = py;
    }

    static void check(int idx){
        island temp = Land.get(idx);
        idx+=1;
        //->
        int start = temp.sc, end = temp.ec;
        for(int i=temp.sr;i<=temp.er;i++){
            for(int j=temp.sc;j<M;j++){
                //System.out.println(i+" "+j+" "+start);
                if(map[i][j]==idx) start = j;
                if(map[i][j]==0 || map[i][j]==idx) continue;
                if(start>=j-2) break;
                
                //System.out.println("움직임 -> "+idx+" "+map[i][j]+" "+(j-start-1));
                pqueue.offer(new Node(idx, map[i][j], j-start-1));
                break;
            }
        }

        //<-
        for(int i=temp.sr;i<=temp.er;i++){
            for(int j=temp.ec;j>-1;j--){
                //System.out.println(i+" "+j+" "+end);
                if (map[i][j]==idx) end = j;
                if (map[i][j]==0 || map[i][j]==idx) continue;
                if (end<=j+2) break;
                
                //System.out.println("움직임 <- "+idx+" "+map[i][j]+" "+(end-j-1));
                pqueue.offer(new Node(idx, map[i][j], end-j-1));
                break;
            }
        }

        // v
        start = temp.sr; end = temp.er;
        for(int i=temp.sc;i<=temp.ec;i++){
            for(int j=temp.sr;j<N;j++){
                if(map[j][i]==idx) start = j;
                if(map[j][i]==0 || map[j][i]==idx) continue;
                if(start>=j-2) break;
                
                //System.out.println("움직임 v "+idx+" "+map[j][i]+" "+(j-start-1));
                
                pqueue.offer(new Node(idx, map[j][i], j-start-1));
                break;
            }
        }
        

        // ^
        for(int i=temp.sc;i<=temp.ec;i++){
            for(int j=temp.er;j>-1;j--){
                if(map[j][i]==idx) end = j;
                if(map[j][i]==0 || map[j][i]==idx) continue;
                if(end<=j+2) break;
                
                //System.out.println("움직임 ^ "+idx+" "+map[j][i]+" "+(end-j-1));
                
                pqueue.offer(new Node(idx, map[j][i], end-j-1));
                break;
            }
        }
    }
    static void whereIsIsland(int y, int x){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(y*M+x);
        map[y][x] = id;
        int temp, ny, nx, sr = y, er = y, sc = x, ec = x;
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            temp = queue.poll();
            list.add(temp);
            for(int i=0;i<4;i++){
                ny = temp/M+dy[i];
                nx = temp%M+dx[i];
                if (ny>=N || ny<0 || nx>=M || nx<0) continue;
                if (map[ny][nx]!=-1) continue;
                if (sr>ny) sr=ny;
                if (er<ny) er=ny;
                if (sc>nx) sc=nx;
                if (ec<nx) ec=nx;
            
                map[ny][nx] = id;
                queue.offer(ny*M+nx);
            }
        }
        //System.out.println(list.toString()+" "+id+" "+sr+" "+er+" "+sc+" "+ec);
        Land.add(new island(id, list, sr, er, sc, ec));
        id++;
    }
    static class Node {
        int v1, v2, c;
        Node(int v1, int v2, int c){
            this.v1=v1;
            this.v2=v2;
            this.c=c;
        }
    }
    static class island {
        int idx, sr, er, sc, ec;
        List<Integer> list;

        island(int idx, List<Integer> list, int sr, int er, int sc, int ec){
            this.idx = idx;
            this.list = list;
            this.sr = sr;
            this.er = er;
            this.sc = sc;
            this.ec = ec;
        }
    }
}