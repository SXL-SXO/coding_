import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder input = new StringBuilder(br.readLine());
        List<String> output = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < input.length() ;i++){
            output.add(input.substring(i, input.length()));
        }
        Collections.sort(output);

        for(String s : output){
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}