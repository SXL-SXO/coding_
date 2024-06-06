import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main{
    static int sum = 0;
    static Node score[] = new Node[8];
    static boolean num[] = new boolean[8];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<8; i++){
            score[i] = new Node(i, Integer.parseInt(br.readLine()));
            sum += score[i].num;
        }
        Arrays.sort(score, (o1,o2) -> o1.num - o2.num);

        for(int i=0; i<3; i++){
            num[score[i].i] = true;
            sum -= score[i].num;
        }
        sb.append(sum).append("\n");
        for(int i=0; i<8; i++){
            if(!num[i]){
                sb.append(i+1).append(" ");
            }
        }
        System.out.println(sb);
    }
    static class Node{
        int i, num;
        Node(int i, int num){
            this.i = i;
            this.num = num;
        }
    }
}