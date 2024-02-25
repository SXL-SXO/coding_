import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class S_contact_1238
{
    static int N, S, answer;
    static boolean visit[];
    static boolean link[][];
    static StringBuilder sb = new StringBuilder();
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int T=10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());
            answer = S;
			link = new boolean[101][101];
            visit= new boolean[101];
            st = new StringTokenizer(br.readLine());
            for(int i= 0; i<N/2; i++){
            	int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                if(link[A][B]) continue;
                visit[A] = true;
                visit[B] = true;
                link[A][B] =true;
                //System.out.println(A+" "+B+" /");
            }
            bfs();
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
    static void bfs(){
    	Queue<Integer> call = new ArrayDeque<>();
        call.offer(S);
        visit[S] = false;
        while(!call.isEmpty()){
            int size = call.size();
            for(int j=0;j<size;j++) {
	        	int temp = call.poll();
	        	if(j==0) answer = temp;
	        	answer = Math.max(temp, answer);
                //System.out.print(temp+" ");
	            for(int i=1;i<=100;i++){
	            	if(!link[temp][i] || !visit[i]) continue;
                    visit[i] = false;
	            	call.offer(i);
	            }
            }
            //System.out.println("");
        }
    }
}