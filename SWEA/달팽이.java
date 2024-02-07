package my_study;

import java.util.Scanner;
class 달팽이
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N=sc.nextInt();
            int answer[][] = new int[N][N];
            answer[0][0]=1;
            sb.append("#").append(test_case).append("\n");
            dalpang(answer, 2,0,0);
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                   	sb.append(answer[i][j]).append(" ");
                }
                sb.append("\n");
            }
		}
        System.out.print(sb.toString());
	}
    static void dalpang(int [][]answer, int num, int r, int c){
        int dr[] = {0,1,0,-1};
        int dc[] = {1,0,-1,0};
        int type=0;
    	while(true){
            if(num>=answer.length*answer.length+1) break;
        	if(type==0 && answer.length <= dc[type]+c) type++;
            if(type==1 && answer.length <= dr[type]+r) type++;
            if(type==2 && 0 > dc[type]+c) type++;
            if(type==3 && 0 > dr[type]+r) type++;
            if(type==4){
                type=0;
                continue;
            }
            if(answer[dr[type]+r][dc[type]+c]!=0){
            	type++;
                continue;
            }
			r+=dr[type];
            c+=dc[type];
            answer[r][c]=num++;
        }
    }
}