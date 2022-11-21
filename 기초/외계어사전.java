class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        for(String a : dic){
            if(!a.contains(spell[0]))
                continue;
            for(String b : spell){
                if(!a.contains(b)){
                    break;
                }
                if(b.equals(spell[spell.length-1]))
                    answer=1;
            }
                    
        }
        return answer;
    }
}