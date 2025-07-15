class Solution {
    static int answer[], box[][];
    static int cal[] = {0, 0, 0};
    static int N;
    public int[] solution(int n) {
        N = n*(n+1)/2;
        
        answer = new int[N];
        box = new int[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                box[i][j] = -1;
            }
        }
        
        cal[0] = n;
        cal[1] = 1;
        cal[2] = -n-1; 
        
        int where = 0, type = 0, count = 0;
        for(int num=1;num<N;num++){
            box[where/n][where%n] = num;
            where += cal[type];
            
            while(where >= n*n || where < 0 || box[where/n][where%n] != 0) {
                 where -= cal[type];
                 type = (type+1)%3;
                 where += cal[type];
            }
        }
        box[where/n][where%n] = N;
        
        where = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(box[i][j]>0) answer[where++] = box[i][j];
            }
        }
        
        
        return answer;
    }
}