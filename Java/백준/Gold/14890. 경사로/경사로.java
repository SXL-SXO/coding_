import java.util.*;
import java.io.*;

class Main{
    static int N, M, answer = 0;
    static int[][] map;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N];

        total : for(int i = 0; i < N; i++){

            Arrays.fill(visited, false);
            for(int j = 0; j < M-1; j++){
                if(map[i][j] - map[i][j+1] > 1 || map[i][j] - map[i][j+1] < 0) {
                    continue total;
                }else if(map[i][j] == map[i][j+1]+1){
                    for(int k = j+1; k < j+1+M; k++){
                        if(k>=N || visited[k] || map[i][j+1]!=map[i][k]) continue total;
                        visited[k] = true;
                    }
                }
            }
            for(int j = M-1; j <= N-M; j++){
                if(j>=N-1) continue ;
                if(Math.abs(map[i][j] - map[i][j+1])>1) {
                    continue total;
                }else if(map[i][j] == map[i][j+1]+1){
                    for(int k = j+1; k < j+1+M; k++){
                        if(k>=N || visited[k] || map[i][j+1]!=map[i][k]) continue total;
                        visited[k] = true;
                    }
                }else if(map[i][j] == map[i][j+1]-1){
                    for(int k=j ; k >= j+1-M; k--){
                        if(k<0 || visited[k] || map[i][j]!=map[i][k]) continue total;
                        visited[k] = true;
                    }
                }
            }
            for (int j = N-M+1; j < N-1; j++){
                if(map[i][j+1] - map[i][j] > 1 || map[i][j+1] - map[i][j] < 0) {
                    continue total;
                }else if(map[i][j] == map[i][j+1]-1){
                    for(int k=j ; k >= j+1-M; k--){
                        if(k<0 || visited[k] || map[i][j]!=map[i][k]) continue total;
                        visited[k] = true;
                    }
                }
            }

//            System.out.println(i);
            answer++;
        }
        total : for(int i = 0; i < N; i++){
            Arrays.fill(visited, false);
            for(int j = 0; j < M-1; j++){
                if(map[j][i] - map[j+1][i] > 1 || map[j][i] - map[j+1][i] < 0) {
                    continue total;
                }else if(map[j][i] == map[j+1][i]+1){
                    for(int k = j+1; k < j+1+M; k++){
                        if(k>=N || visited[k] || map[j+1][i]!=map[k][i]) continue total;
                        visited[k] = true;
                    }
                }
            }
            for(int j = M-1; j <= N-M; j++){
                if(j>=N-1) continue ;
                if(Math.abs(map[j][i] - map[j+1][i])>1) {
                    continue total;
                }else if(map[j][i] == map[j+1][i]+1){
                    for(int k = j+1; k < j+1+M; k++){
                        if(k>=N || visited[k] || map[j+1][i]!=map[k][i]) continue total;
                        visited[k] = true;
                    }
                }else if(map[j][i] == map[j+1][i]-1){
                    for(int k=j ; k >= j+1-M; k--){
                        if(k<0 || visited[k] || map[j][i]!=map[k][i]) continue total;
                        visited[k] = true;
                    }
                }
            }
            for (int j = N-M+1; j < N-1; j++){
                if(map[j+1][i] - map[j][i] > 1 || map[j+1][i] - map[j][i] < 0) {
                    continue total;
                } else if(map[j][i] == map[j+1][i]-1){
                    for(int k=j ; k >= j+1-M; k--){
                        if(k<0 || visited[k] || map[j][i]!=map[k][i]) continue total;
                        visited[k] = true;
                    }
                }
            }
            Arrays.fill(visited, false);
//            System.out.println("/"+i);
            answer++;
        }
        System.out.println(answer);
    }
}