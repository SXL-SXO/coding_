// 05:33~9 18~
class Solution {
    static StringBuilder sb;
    static int N;
    public String solution(String n, int K) {
        sb = new StringBuilder(n);
        N = n.length();
        /*
        i<j
        input[i]<input[j] => 앞에 녀석 지우기 count++
        input[i]>input[j] => 넘어가기
        i++
        j++
        
        j==N-1 i=0, j=1;
        */
        int count = 0;
        for(int i=0;i<sb.length()-1;i++){
            if(i<0) i=0;
            if(sb.charAt(i)<sb.charAt(i+1)){
                sb.deleteCharAt(i);
                count++;
                if(count==K) break;
                i-=2;
            }
        }
        sb.setLength(N-K);
        return sb.toString();
    }
}