import java.io.*;

public class B_Javavsc_3613 {
    static boolean type = true; // false = c->java, true java->c
    static char input_c[];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        input_c = input.toCharArray();

        if(input.contains("_")) type = false;

        if('A'<=input_c[0]&&input_c[0]<='Z' || input_c[0]=='_' || input_c[input_c.length-1]=='_') {
            System.out.print("Error!");
            return;
        }

        if(!type){
            sb.append(input_c[0]);
            for(int i=1;i<input_c.length;i++){
                if(check_err(i)) {
                    System.out.print("Error!");
                    return;
                }
                else if(input_c[i-1]=='_') {
                    sb.setLength(sb.length()-1);
                    sb.append((char)(input_c[i]+'A'-'a'));
                }
                else sb.append(input_c[i]);
            }
        }else{
            for(int i=0;i<input_c.length;i++){
                if(check_err(i)){
                    System.out.print("Error!");
                    return;
                }
                else if('A'<=input_c[i]&&input_c[i]<='Z') {
                    sb.append('_').append((char)(input_c[i]-('A'-'a')));
                }
                else sb.append(input_c[i]);
            }
        }
        System.out.println(sb.toString());
    }
    static boolean check_err(int idx){ //false = c->java, true java->c
        if(type){
            if(input_c[idx]=='_') return true;
        }else{
            if(input_c[idx-1]=='_' && input_c[idx]=='_') return true;
            else if('A'<=input_c[idx]&&input_c[idx]<='Z') return true;
        }
        return false;
    }
}
