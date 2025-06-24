// 06:16
class Solution {
    static int input[], now[];
    static boolean isRight;
    static StringBuilder sb = new StringBuilder();
    public String solution(int[] numbers, String hand) {
        input = numbers;
        isRight = hand.equals("right");    
        now = new int[2];
        now[0] = 10;
        now[1] = 12;
        
        move();
        
        return sb.toString();
    }
    static void move(){
        int l_c, r_c;
        for(int n : input){
            if(n == 0) n = 11;
            
            if(n%3==1) {
                sb.append('L');
                now[0] = n;
            }else if(n%3==0) {
                sb.append('R');
                now[1] = n;
            }else{
                l_c = Math.abs((n-1)/3 - (now[0]-1)/3) + Math.abs((n-1)%3 - (now[0]-1)%3);
                r_c = Math.abs((n-1)/3 - (now[1]-1)/3) + Math.abs((n-1)%3 - (now[1]-1)%3);
                
                if(l_c < r_c) {
                    now[0] = n;
                    sb.append('L');
                }else if(l_c > r_c) {
                    now[1] = n;
                    sb.append('R');
                }else{
                    now[isRight ? 1 : 0] = n;
                    sb.append(isRight ? 'R' : 'L');
                }
            }
        }
    }
}