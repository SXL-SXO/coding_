class Solution {
    public String solution(String rsp) {
        String answer = "";
        rsp=rsp.replaceAll("2", "rk");
        rsp=rsp.replaceAll("0", "qk");
        rsp=rsp.replaceAll("5", "qh");
        
        answer=rsp.replaceAll("rk", "0");
        answer=answer.replaceAll("qk", "5");
        answer=answer.replaceAll("qh", "2");
        
        return answer;
    }
}