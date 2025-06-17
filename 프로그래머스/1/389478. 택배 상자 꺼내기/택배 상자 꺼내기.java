class Solution {
    static int N, W, target, answer = 0;
    public int solution(int n, int w, int num) {
        N = n;
        W = w;
        target = num-1;
        
        int temp = target;
        boolean even = target/W == 0;
        
        while(temp<N){
            answer++;
            
            if(!even) temp += 2*(W-(temp%W))-1;
            else temp = (temp+W)/W*W + W-(temp%W)-1;
            
            even = !even;
            
            System.out.println(even+" "+temp);
        }
        
        return answer;
    }
}