import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{
    static int ans_c = 0;
    static int alp[] = new int[26];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while((input = br.readLine()) != null){
            for(char i : input.toCharArray()){
                if(i == ' ') continue;
                alp[i-'a']++;
            }
        }
        for(int i = 0; i < 26; i++){
            if(alp[i] > ans_c) {
                ans_c = alp[i];
                sb.setLength(0);
                sb.append((char)(i+'a'));
            }else if(alp[i] == ans_c) {
                sb.append((char)(i+'a'));
            }
        }
        System.out.println(sb);
    }
}