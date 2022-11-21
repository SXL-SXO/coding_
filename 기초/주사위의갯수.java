class Solution {
    public int solution(int[] box, int n) {
        int answer = 0;
        int ga=0, se=0, high=0;
        ga=box[0]/n;
        se=box[1]/n;
        high=box[2]/n;
        answer=ga*se*high;
        return answer;
    }
}