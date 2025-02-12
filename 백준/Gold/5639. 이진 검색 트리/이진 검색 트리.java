import java.io.*;
import java.util.*;

public class Main
{
    static Node root, now;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    root = new Node(Integer.parseInt(br.readLine()), null);
	    
	    String str;
	    int N;
	    while((str = br.readLine())!=null &&!(str.isEmpty()) ){
	        N = Integer.parseInt(str);
	        pre(N);
	    }
	    post();
	    System.out.print(sb);
	}
	static void pre(int N){
	    now = root;
	   // System.out.println("//"+N);
	    while(true){
	       // System.out.println("///"+now.value+" "+now.left+" "+now.right);
    	    if(now.value>N){
    	        if(now.left==null) {
    	            now.left = new Node(N, now);
    	            return;
    	        }
    	        now = now.left;
    	    }else{
    	        if(now.right==null){
    	            now.right = new Node(N, now);
    	            return;
    	        }
    	        now = now.right;
    	    }
	    }
	}
	static void post(){
	    now = root;
	    while(now != null){
	        if(now.left!=null) now = now.left;
	        else if(now.right!=null) now = now.right;
	        else {
	            sb.append(now.value).append("\n");
	            now = now.root;
	            if(now==null) return;
	            else if(now.left!=null) now.left = null;
	            else if(now.right!=null) now.right = null;
	        }
	    }
	}
	static class Node{
	    int value;
	    Node left, right, root;
	    
	    Node(int value, Node root){
	        this.root = root;
	        this.value = value;
	        this.right = null;
	        this.left = null;
	    }
	   
	}
}
