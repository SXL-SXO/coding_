import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Main{
    static int N;
    static Map <String, Integer> prefix = new HashMap<>();
    static Map <String, Integer> nickname = new HashMap<>();
    static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            String input = br.readLine();
            if(nickname.containsKey(input)){
                answer.append(input).append(nickname.get(input)+1).append("\n");
                nickname.put(input, nickname.get(input)+1);
                continue;
            }

            StringBuilder sb = new StringBuilder(input);
            boolean check = false;
            for(int j=0;j<input.length();j++){
                if(!prefix.containsKey(sb.substring(0,j+1))){
                    prefix.put(sb.substring(0,j+1), 0);
                    if(!check){
                        answer.append(sb.substring(0,j+1)).append("\n");
                        nickname.put(input, 1);

                        check = true;
                    }
                }
            }
            if(!check){
                answer.append(input).append("\n");
                nickname.put(input, 1);
            }
        }

        System.out.println(answer);
    }
}