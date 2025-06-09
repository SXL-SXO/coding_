import java.util.*;
import java.io.*;

public class Main
{
    static int N, M;
    static int rank[], point[];
    static PriorityQueue<before> pq = new PriorityQueue<>(
            (o1, o2) -> o1.c==o2.c ? o2.p==o1.p ? o2.l-o1.l : o2.p-o1.p : o1.c-o2.c
        );
    static PriorityQueue<Node> pq2 = new PriorityQueue<>(
            (o1, o2) -> o2.p==o1.p ? o1.rank-o2.rank : o2.p-o1.p 
        
        );
    static Queue<before> queue = new ArrayDeque<>();
    static List<List<submit>> list = new ArrayList<>();
    static before b[];
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    rank = new int[N+1];
	    point = new int[N+1];
	    b = new before[N+1];
	    for(int i=0;i<=N;i++) {
	        b[i] = new before(i);
	        list.add(new ArrayList<>());
	    }
	    
	    String temp[];
	    int time=0, x, y, z;
	    for(int i=0;i<M;i++){
	        st = new StringTokenizer(br.readLine());
	        
	        temp = st.nextToken().split(":");
	        time = Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]);
	        
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());
	        
	        if(time<=180){
	            b[x].c++;
	            b[x].p += time + (z-1)*20;
	            b[x].l = i;
	        }else {
	            list.get(x).add(new submit(i, time, y, z));
	        }
	    }
	    
	    for(int i=1;i<=N;i++){
	        Collections.sort(list.get(i), (o1, o2) -> o1.idx-o2.idx);
	        pq.offer(b[i]);
	    }
	    
	    before be;
	    submit su;
	    int rank = N;
	    while(!pq.isEmpty()){
	        be = pq.poll();
	        
	        if(list.get(be.idx).size()>0) {
	            su = list.get(be.idx).get(0);
	            be.c++;
	            be.p += su.t + (su.s-1)*20;
	            be.l = su.idx;
	            list.get(be.idx).remove(0);
	        
	            check(be);
	            pq.offer(be);
	        }else{
	            pq2.offer(new Node(be.idx, point[be.idx], rank--));
	        }
	    }
	    
	    
// 		System.out.println(Arrays.toString(point));
		System.out.print(pq2.poll().idx);
	}
	static void check(before be){
	    before bb;
	    
	    while(!pq.isEmpty()){
	        bb = pq.peek();
	        if(bb.c<be.c) queue.offer(pq.poll());
	        else if(bb.c==be.c && bb.p>be.p) queue.offer(pq.poll());
	        else if(bb.c==be.c && bb.p==be.p && bb.l>be.l) queue.offer(pq.poll());
	        else break;
	    }
	    
	    point[be.idx] += queue.size();
	    
	    while(!queue.isEmpty()){
	        pq.offer(queue.poll());
	    }
	    
	    return;
	}
	static class Node{
	    int idx, p, rank;
	    Node(int idx, int p, int rank){
	        this.idx = idx;
	        this.p = p;
	        this.rank = rank;
	    }
	}
	static class submit{
	    int idx, t, p, s;
	    submit(int idx, int t, int p, int s){
	        this.idx = idx;
	        this.t = t;
	        this.p = p;
	        this.s = s;
	    }
	}
	static class before{
	    int idx, c, p, l;
	    before(int idx){
	        this.idx = idx;
	        c=0;
	        p=0;
	        l=-1;
	    }
	    before(int c, int p, int l){
	        this.c = c;
	        this.p = p;
	        this.l = l;
	    }
	}
}
