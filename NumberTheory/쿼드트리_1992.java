import java.io.*;
import java.util.*;

public class 쿼드트리_1992 {
    static char[][] image;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        image = new char[N][];
        for(int i=0;i<N;i++){
            image[i] = br.readLine().toCharArray();
        }
        if (N==1){
            System.out.println(image[0][0]);
            return;
        }
        System.out.print(check(0,0,N-1,N-1,N));
    }   
    static String check(int sr, int sc, int er, int ec, int N){
        String tl, tr, bl, br;
        if(N==2){
            tl = image[sr][sc]+"";
            tr = image[sr][ec]+"";
            bl = image[er][sc]+"";
            br = image[er][ec]+"";
        }
        else{
            N/=2;
            tl = check(sr,   sc,   er-N, ec-N, N);
            tr = check(sr,   sc+N, er-N, ec,   N);
            bl = check(sr+N, sc,   er,   ec-N, N);
            br = check(sr+N, sc+N, er,   ec,   N);
        }
        if(tl.length()==1 && tl.equals(tr) && tr.equals(bl) && bl.equals(br) && br.equals(tl)) return tl;
        
        StringBuilder sb = new StringBuilder();
        sb.append("(").append(tl).append(tr).append(bl).append(br).append(")");
        return sb.toString();
    }
}
