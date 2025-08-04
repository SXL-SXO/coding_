class Solution {
    static int N, answer ;
    static int input[];
    static long M = 0;
    public int solution(int[] queue1, int[] queue2) {
        N = queue1.length*2;
        answer = N*2+1;
        
        input = new int[N];        
        
        for(int i=0;i<N/2;i++) {
            input[i] = queue1[i];
            input[i+N/2] = queue2[i];
            M += queue1[i];
            M += queue2[i];
        }
        M /= 2;
        
        long sum = input[0];
        int start = 0, end = 1, count = 0;
        while(end<N){
            if(sum == M) {
                if(end<N/2) answer = Math.min(answer, end + start + N/2);
                else if(end == N/2) answer = Math.min(answer, start);
                else if(end == N) answer = Math.min(answer, start - N/2);
                else answer = Math.min(answer, end + start - N/2);
                
                // System.out.println(start+" "+end+" "+count);
                
                sum -= input[start++];
                sum += input[end++];
            }
            else if(M<sum) {
                sum -= input[start++];
                if(start>=end) 
                    sum += input[end++];
            }else sum += input[end++];
        }
        
        if(answer == N*2+1) answer = -1;
        
        return answer;
    }
}