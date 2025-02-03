import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static int alpha[];
    static Node tree[];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    char input[];
	    N = Integer.parseInt(br.readLine());
	   
	    tree = new Node[N]; // 이 알파벳은 트리 어디에 있는가
	    
	    for(int i=0;i<N;i++){
	        input = br.readLine().toCharArray();
	        
	        tree[input[0]-'A'] = new Node(input[2]-'A', input[4]-'A');
	    }
	    
	    pre(0); sb.append("\n");
	    in(0); sb.append("\n");
	    post(0); 
	    
		System.out.print(sb);
	}
	static class Node{
	    int left , right;
	    
	    Node(int left, int right){
	        this.left = left;
	        this.right = right;
	    }
	}
	
	static void pre(int idx){
	    if( idx<0 ) return;
	    sb.append((char)(idx+'A'));
	    pre(tree[idx].left);
	    pre(tree[idx].right);
	}
	static void in(int idx){
	    if( idx<0 ) return;
	    in(tree[idx].left);
	    sb.append((char)(idx+'A'));
	    in(tree[idx].right);
	}
	static void post(int idx){
	    if( idx<0 ) return;
	    post(tree[idx].left);
	    post(tree[idx].right);
	    sb.append((char)(idx+'A'));
	}
}
