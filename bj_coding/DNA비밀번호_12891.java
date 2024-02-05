import java.io.*;
import java.util.*;
public class DNA비밀번호_12891 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        Map<String,Integer> map = new HashMap<>();
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String DNA = br.readLine();
        char DNA_c[] = DNA.toCharArray();
        StringBuilder DNA_p = new StringBuilder(DNA.substring(0,P));
        st = new StringTokenizer(br.readLine());
        int ACGT[] = new int[4];
        for(int i=0;i<4;i++){
            ACGT[i]=Integer.parseInt(st.nextToken());
        }
        int password[] = new int[4];
        for(int i=0;i<P;i++){
            switch(DNA_c[i]){
                case 'A' : password[0]+=1; break;
                case 'C' : password[1]+=1; break;
                case 'G' : password[2]+=1; break;
                case 'T' : password[3]+=1; break;
            }
        }
        if(password[0]>=ACGT[0] && password[1]>=ACGT[1] &&
        password[2]>=ACGT[2] && password[3]>=ACGT[3])
            map.put(DNA_p.toString(),0);
        for(int i=0;i<S-P;i++){
            switch(DNA_c[i]){
                case 'A' : password[0]-=1; break;
                case 'C' : password[1]-=1; break;
                case 'G' : password[2]-=1; break;
                case 'T' : password[3]-=1; break;
            }
            switch(DNA_c[i+P]){
                case 'A' : password[0]+=1; break;
                case 'C' : password[1]+=1; break;
                case 'G' : password[2]+=1; break;
                case 'T' : password[3]+=1; break;
            }
            DNA_p.deleteCharAt(0);
            DNA_p.append(DNA_c[i+P]);
            if(password[0]>=ACGT[0] && password[1]>=ACGT[1] && password[2]>=ACGT[2] && password[3]>=ACGT[3])
                map.put(DNA_p.toString(),0);
        }
        System.out.println(map.size());
    }
}
