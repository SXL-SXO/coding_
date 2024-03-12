import java.io.*;
import java.util.*;

public class B_가장가까운세사람의심리적거리_20529 {
    static int T,N,answer;
    static int mbti[];
    static int dis[][] = new int[16][16];
    static List<List<Integer>> list;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //esfp기준으로 0
        T = Integer.parseInt(br.readLine());
        dist();
        for(int t=0;t<T;t++){
            N = Integer.parseInt(br.readLine());
            answer = 15;
            st = new StringTokenizer(br.readLine());
            mbti = new int[16];
            list = new ArrayList<>();
            list.add(new ArrayList<>());
            list.add(new ArrayList<>());
            list.add(new ArrayList<>());
            for(int i=0;i<N;i++){
                String mbti_input = st.nextToken();
                int index = 0;
                if(mbti_input.charAt(0)!='E') index=index|1<<0;
                if(mbti_input.charAt(1)!='S') index=index|1<<1;
                if(mbti_input.charAt(2)!='F') index=index|1<<2;
                if(mbti_input.charAt(3)!='P') index=index|1<<3;
                mbti[index]++;
            }
            for(int i=0;i<16;i++){
                if(mbti[i]>=3) list.get(2).add(i); 
                else if(mbti[i]==2) list.get(1).add(i); 
                else if(mbti[i]==1) list.get(0).add(i); 
            }
            if(list.get(2).size()>0){
                sb.append(0).append("\n");
                continue;
            }
            for(int i=0;i<list.get(1).size();i++){
                int check = list.get(1).get(i);
                for(int j=0;j<16;j++){
                    if(check==j || mbti[j]<1) continue;
                    answer = Math.min(answer,dis[check][j]*2);
                }
            }
            for(int i=0;i<list.get(0).size();i++){
                for(int j=i+1;j<list.get(0).size();j++){
                    for(int k=j+1;k<list.get(0).size();k++){
                        answer = Math.min(answer,dis[list.get(0).get(i)][list.get(0).get(j)] + dis[list.get(0).get(k)][list.get(0).get(j)] +dis[list.get(0).get(i)][list.get(0).get(k)]);
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
    static void dist(){
        for(int i=0;i<16;i++){
            for(int j=i;j<16;j++){
                for(int k=0;k<4;k++){
                    dis[i][j] = ((i^j)|(1<<k)) == (i^j) ? dis[i][j]+1 : dis[i][j];
                }
                dis[j][i] = dis[i][j];
            }
        }
    }
}
