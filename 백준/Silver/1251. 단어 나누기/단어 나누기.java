import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{
    static String in;
    static char input[], answer[], be[];
    static int min_alp_1, min_idx_1, min_alp_2, min_idx_2;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        in = br.readLine();
        input = in.toCharArray();
        answer = in.toCharArray();
        for (int i = 0; i < input.length-1; i++){
            answer[i+1] = input[input.length-2-i];
        }
        for(int i = 0; i < input.length-2; i++){
            for(int j = i+1; j < input.length-1; j++){
                sb.setLength(0);
                for(int a = 0;a<input.length;a++){
                    if(a<=i) sb.append(input[i-a]);
                    else if(a<=j) sb.append(input[j+1+i-a]);
                    else sb.append(input[input.length+j-a]);
                }
                be = sb.toString().toCharArray();
                for(int a = 0;a<be.length;a++){
                    if(be[a]<answer[a]) {
                        answer = sb.toString().toCharArray();
                        break;
                    }else if(be[a]==answer[a])continue;
                    break;
                }
            }
        }
        sb.setLength(0);
        for(int i = 0; i < input.length; i++){sb.append(answer[i]);}

        System.out.println(sb);
//        min_alp_1 = 'z';
//        min_idx_1 = 0;
//        min_alp_2 = 'z';
//        min_idx_2 = 1;
//
//        for(int i = 0; i < input.length-2; i++){
//            if(min_alp_1>=input[i]){
//                min_alp_1 = input[i];
//                min_idx_1 = i;
//            }
//        }
//        for(int i=min_idx_1+1;i<input.length-1;i++){
//            if(min_alp_2>=input[i]){
//                min_alp_2 = input[i];
//                min_idx_2 = i;
//            }
//        }
//        for(int i=0;i<input.length;i++){
//            if(i<=min_idx_1) sb.append(input[min_idx_1-i]);
//            else if(i<=min_idx_2) sb.append(input[min_idx_2+1+min_idx_1-i]);
//            else sb.append(input[input.length+min_idx_2-i]);
//        }

//        System.out.println(sb);
    }
}