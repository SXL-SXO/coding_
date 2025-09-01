//01:25
class Solution {
    static int N;
    static StringBuilder sb = new StringBuilder();
    public int solution(String s) {
        char input[] = s.toCharArray();
        
        N = input.length;
        for(int i=0;i<N;i++){
            if(input[i]=='z') {
                sb.append(0);
                i+=3;
            }else if(input[i]=='o'){
                sb.append(1);
                i+=2;
            }else if(input[i]=='t' && input[i+1]=='w'){
                sb.append(2);
                i+=2;
            }else if(input[i]=='t'){
                sb.append(3);
                i+=4;
            }else if(input[i]=='f' && input[i+1]=='o'){
                sb.append(4);
                i+=3;
            }else if(input[i]=='f'){
                sb.append(5);
                i+=3;
            }else if(input[i]=='s' && input[i+1]=='i'){
                sb.append(6);
                i+=2;
            }else if(input[i]=='s'){
                sb.append(7);
                i+=4;
            }else if(input[i]=='e'){
                sb.append(8);
                i+=4;
            }else if(input[i]=='n' && input[i+1]=='i'){
                sb.append(9);
                i+=3;
            }else sb.append(input[i]);
        }
        
        return Integer.parseInt(sb.toString());
    }
}