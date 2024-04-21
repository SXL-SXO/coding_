import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{
    static int N, answer = 0;
    static int alpha[];
    static char input[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        for(int i=0; i<N; i++){
            input = br.readLine().toCharArray();
            alpha = new int[26];
            
            int j = 0;
            alpha[input[j++]-'a']++;
            for(; j<input.length; j++){
                if(input[j-1]!=input[j] && alpha[input[j]-'a']!=0) break;
                alpha[input[j]-'a']++;
            }
            if(j==input.length) answer++;
        }

        System.out.println(answer);
    }
}