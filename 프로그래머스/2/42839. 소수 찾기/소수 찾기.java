// 12:45
class Solution {
    static int N;
    static int input[];
    static boolean visit[] = new boolean[10000000];
    static boolean sosu[] = new boolean[10000000];
    public int solution(String numbers) {
        N = numbers.length();
        input = new int[N];
        for(int i=0;i<N;i++){
            input[i] = numbers.charAt(i)-'0';
        }
        
        check();
        
        for(int i=0;i<N;i++){
            for(int j=N;j>0;j--){
                make(j-1, 1<<i, (int)Math.pow(10, j-1)*input[i]);
            }
        }
                 
        int answer = 0;
        for(int i=2;i<10000000;i++){
            if(!sosu[i] && visit[i]) {
                System.out.print(i+" / ");
                answer++;
            }
        }
        return answer;
    }
    static void make(int idx, int bit, int num){
        visit[num] = true;
        if(idx<=0) return;
        
        for(int i=0;i<N;i++){
            if((bit&(1<<i))==0) make(idx-1, bit|(1<<i), num+(int)Math.pow(10, idx-1)*input[i]);
        }
    }
    static void check(){
        for(int i=2;i<10000000;i++){
            for(int j=2;i*j<10000000;j++){
                sosu[i*j] = true;
            }
        }
    }
}