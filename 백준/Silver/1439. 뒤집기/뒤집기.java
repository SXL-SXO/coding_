import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char input[];
    static int count, zero = 0, one = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine().toCharArray();
        count = 1;
        // 0연결 갯수, 1연결갯수 각각 구해서 더 큰놈을 1로 바꿔서 정답계산
        for(int i=1;i<input.length;i++){
            if(input[i-1]==input[i]) continue;
            else {
                count = 1;
                if(input[i-1]=='1') one++;
                else zero++;
            }
        }
        if(input[input.length-1]== '1') one++;
        else zero++;
        System.out.println(Math.min(one, zero));
    }
}
