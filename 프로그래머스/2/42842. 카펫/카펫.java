// 11:17~
class Solution {
    public int[] solution(int b, int y) {
        int[] answer = new int[2];
        
        // (가로+세로)*2-4 = 갈색
        // (가로-2)*(세로-2) = 노란색
            
        //2*y+2*x-4=B
        //y*x-2*y-2*x+4=Y
        //y*x = B+Y
        //y+x = ((B+Y-4)-Y+4)/2
        //x(((B+Y-4)-Y+4)/2-x) = B+Y-4
        //x*x - x*((B+Y-4)-Y+4)/2 + B+Y-4 = 0
        
        int j = 0;
        for(int i=3;i<=2500;i++){
            j = (int)(b+y)/i;
            System.out.println(i+" "+j);
            if((i+j)*2-4==b && i*j==b+y) {
                answer[1] = i;
                answer[0] = j;
                break;
            }
        }
        
        return answer;
    }
}