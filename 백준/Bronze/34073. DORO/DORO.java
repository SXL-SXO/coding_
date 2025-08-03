import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input[] = br.readLine().split(" ");
        
        for(String s : input) sb.append(s).append("DORO ");
        
        System.out.println(sb);
    }
}