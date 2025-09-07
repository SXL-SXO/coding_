import java.util.*;
import java.io.*;
public class Main
{
    static int N, M;
    static int front[] = new int[1000001];
    static int back[] = new int[1000001];
    // static Map<Integer, Integer> front = new HashMap<>();
    // static Map<Integer, Integer> back = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    
	    st = new StringTokenizer(br.readLine());
	    int start, fst, nd, rd;
	    if(N==1) {
	        fst = Integer.parseInt(st.nextToken());
	        front[fst] = fst;
	       // front.put(fst, fst);
	        back[fst] = fst;
	       // back.put(fst, fst);
	    }else if(N==2){
	        fst = Integer.parseInt(st.nextToken());
	        nd = Integer.parseInt(st.nextToken());
	        
	        front[fst] = nd;
	        front[nd] = fst;
	       // front.put(fst, nd);
	       // front.put(nd, fst);
	        back[fst] = nd;
	        back[nd] = fst;
	       // back.put(fst, nd);
	       // back.put(nd, fst);
	    }else if(N==3){
	        start = Integer.parseInt(st.nextToken());
	        
	        fst = Integer.parseInt(st.nextToken());
	        nd = Integer.parseInt(st.nextToken());
	        
	       // front.put(fst, start);
	       // front.put(nd, fst);
	       // front.put(start, nd);
	        front[fst] = start;
	        front[nd] = fst;
	        front[start] = nd;
	        
	       // back.put(start, fst);
	       // back.put(fst, nd);
	       // back.put(nd, start);
	        back[start] = fst;
	        back[fst] = nd;
	        back[nd] = start;
	    }else{
	        start = Integer.parseInt(st.nextToken());
	        
	        fst = Integer.parseInt(st.nextToken());
	        nd = Integer.parseInt(st.nextToken());
	        rd = Integer.parseInt(st.nextToken());
	        
	       // front.put(fst, start);
	       // back.put(start, fst);
	        
	        front[fst] = start;
	        back[start] = fst;
	        back[fst] = nd;
	        
	        for(int i=4;i<N;i++){
	           // front.put(nd, fst);
	           // back.put(nd, rd);
	            
	            front[nd] = fst;
	            back[nd] = rd;
	            
	            fst = nd;
	            nd = rd;
	            rd = Integer.parseInt(st.nextToken());
	        }
	        
	       // front.put(nd, fst);
	       // front.put(rd, nd);
	       // front.put(start, rd);
	        front[nd] = fst;
	        front[rd] = nd;
	        front[start] = rd;
	        
	       // back.put(fst, nd);
	       // back.put(nd, rd);
	       // back.put(rd, start);
	        back[fst] = nd;
	        back[nd] = rd;
	        back[rd] = start;
	    }
	    
	    int temp, next, ori;
	    for(int i=0;i<M;i++){
	        st = new StringTokenizer(br.readLine());
	        
	        String order = st.nextToken();
	        if(order.equals("BN")){
	            temp = Integer.parseInt(st.nextToken());
	            next = Integer.parseInt(st.nextToken());
	            ori = back[temp];
	            
	            sb.append(ori).append("\n");
	            
	            front[ori] = next;
	            front[next] = temp;
	            
	            back[next] = ori;
	            back[temp] = next;
	        }else if(order.equals("BP")){
	            temp = Integer.parseInt(st.nextToken());
	            next = Integer.parseInt(st.nextToken());
	            ori = front[temp];
	            
	            sb.append(ori).append("\n");
	            
	            back[ori] = next;
	            back[next] = temp;
	            
	            front[next] = ori;
	            front[temp] = next;
	        }else if(order.equals("CN")){
	            temp = Integer.parseInt(st.nextToken());
	            next = back[temp];
	            ori = back[next];
	            
	            sb.append(next).append("\n");
	            
	            front[ori] = temp;
	            back[temp] = ori;
	        }else{
	            temp = Integer.parseInt(st.nextToken());
	            next = front[temp];
	            ori = front[next];
	            
	            sb.append(next).append("\n");
	            
	            back[ori] = temp;
	            front[temp] = ori;
	        }
	    }
	    
	   // for(int i = 0;i<=N; i++) System.out.print(front[i]+" ");
	   // System.out.println("front");
	   // for(int i = 0;i<=N; i++) System.out.print(back[i]+" ");
	    
		System.out.println(sb);
	}
}
