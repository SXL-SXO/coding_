// 풀이 시작시간 02시 09분

class Solution {
    static int t, a_count = 0, b_count = 0;
    static int a[], b[];
    public int solution(int[] topping) {
        int answer = 0;
        
        t = topping.length;
        a = new int[10001];
        b = new int[10001];
        
        for(int top : topping) {
            if(a[top]==0) a_count++;
            a[top]++;
        }
        
        for(int top : topping) {
            a[top]--;
            b[top]++;
            if(a[top]==0) a_count--;
            if(b[top]==1) b_count++;
            
            if(a_count==b_count) answer++;
        }
        
        return answer;
    }
}