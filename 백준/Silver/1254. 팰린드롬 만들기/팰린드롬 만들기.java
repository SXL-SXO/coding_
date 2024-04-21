import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{
    static char[] input;
    static int front, back, idx, answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine().toCharArray();

        // 제일 마지막 값이 앞에 있으면 계싼 없으면 input.length;
        // 계산
        // 제일 먼 위치 (i) 부터 front로 지정해서 front, back 압박
        // front = back || front+1 = back answer = i

        for(int i = 0; i < input.length; i++){
            if(input[i] == input[input.length-1]){
                if(check(i)) break;
            }
        }
        System.out.println(input.length+answer);
    }
    static boolean check(int i){
        idx = 0 ;
        front = i; back = input.length - 1;
        while(input[front] == input[back]){
            if(front==back || front+1==back) {
                answer = i;
                return true;
            }
            front++;
            back--;
        }
        return false;
    }
}