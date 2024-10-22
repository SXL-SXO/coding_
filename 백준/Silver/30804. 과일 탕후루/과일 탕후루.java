import java.io.*;
import java.util.*;

public class Main
{
    static int N, start = 0, answer = 0;
    static int input[];
    static Node fruit[] = new Node[2];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        input = new int[N];
        for(int i=0;i<N;i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        
        fruit[0] = new Node(input[0],1);
        fruit[1] = new Node(-1, -1);
        for(int i=1;i<N;i++){
            if(input[i]==fruit[0].value) fruit[0].count++;
            else if(input[i]==fruit[1].value) fruit[1].count++;
            else if(fruit[1].value==-1) fruit[1] = new Node(input[i], 1);
            else{
                answer = Math.max(answer, i-start);
                for(;start<i;start++){
                    if(input[start]==fruit[0].value) {
                        if(--fruit[0].count==0) {
                            fruit[0] = fruit[1];
                            fruit[1] = new Node(input[i], 1);
                            start++;
                            break;
                        }
                    }
                    else if(input[start]==fruit[1].value) {
                        if(--fruit[1].count==0) {
                            fruit[1] = new Node(input[i], 1);
                            start++;
                            break;
                        }
                    }
                }
            }
        }
        
        answer = Math.max(answer, N-start);
        System.out.print(answer);
    }
    static class Node{
        int value, count;
        Node(int value, int count){
            this.value = value;
            this.count = count;
        }
    }
}
