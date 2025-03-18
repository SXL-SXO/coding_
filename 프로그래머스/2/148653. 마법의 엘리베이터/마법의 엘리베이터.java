// 02:05~
class Solution {
    static int N = 1, answer = 100000001;
    public int solution(int storey) {
        
        // 1. 구현?
        // 0 1 2 3 4 -> i 갯수 만큼
        // 5 6 7 8 9 -> 10-i+1 만큼 이동해야함
        
        // 2. 2가지 선택, 최대 N=10
        
        for(;;N++){
            if((int)Math.pow(10, N)>=storey) break;
        }
        
        check(storey%(int)Math.pow(10,N-1), N-1, (int)(storey/Math.pow(10,N-1)));
        
        int other = (int)Math.abs(Math.pow(10,N)-storey);
        check(other%(int)Math.pow(10,N-1), N-1, (1+other/(int)Math.pow(10,N-1))%10+(1+other/(int)Math.pow(10,N-1))/10);
        
        return answer;
    }
    static void check(int val, int idx, int count){
        System.out.println(val+" "+idx+" "+count);
        if(idx==1){
            System.out.println("---"+(count+val)+" "+(count+(10-val)+1));
            answer = Math.min(answer, Math.min(count+val, count+(10-val)+1));
            return;
        }
        
        check(val%(int)Math.pow(10,idx-1), idx-1, count+(int)(val/Math.pow(10,idx-1)));
        
        int other = (int)Math.abs(Math.pow(10,idx)-val);
        check(other%(int)Math.pow(10,idx-1), idx-1, count+(1+other/(int)Math.pow(10,idx-1))/10+(1+other/(int)Math.pow(10,idx-1))%10);
    }
}