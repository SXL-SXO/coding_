class Solution {
    public int solution(int n) {
        int fin[] = new int[n+1];
        fin[1] = 1;
        
        for(int i=2;i<=n;i++) fin[i] = (fin[i-1]+fin[i-2])%1234567;
        
        return fin[n];
    }
}