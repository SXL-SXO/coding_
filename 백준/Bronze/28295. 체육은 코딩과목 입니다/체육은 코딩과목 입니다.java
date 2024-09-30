import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int d[] = {1, 2, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int w = 0;
        for(int i=0;i<10;i++){
            w += d[Integer.parseInt(br.readLine())-1];
            
            w = w>=4 ? w-4 : w;
            w = w<0 ? w+4 : w;
        }
        if(w==0) System.out.print("N");
        else if(w==1) System.out.print("E");
        else if(w==2) System.out.print("S");
        else if(w==3) System.out.print("W");
    }
}