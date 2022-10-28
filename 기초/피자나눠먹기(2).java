class Solution {
    public int solution(int n) {
        int answer = 0;
        if(n==1||n==2||n==3||n==6)
            answer=1;
        else if (n%6==0)
            answer=n/6;
        else if (n%2==0)
            answer=n/2;
        else if (n%3==0)
            answer=n/3;
        else
            answer=n;
        return answer;
    }
}