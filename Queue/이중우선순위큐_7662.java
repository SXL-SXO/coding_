import java.io.*;
import java.util.*;

// remove를 통한 구현 : 시간초과
// frontinout, backinout로 최대 최소별로 큐를 구현한 후 각 값에서 최대 최소 값 구하기 : 값이 틀림
// f_count, b_count을 만들어서 각 없어지는 수를 카운트 하고 제외 한 후 최대 최소 : 값이 틀림
// 최대는 -num, 최소는 num으로 만들어서 포함하고 있으면 제거 아니면 넘어가서 다음 수 체크 : 값이 틀림
// node를 만들어서 node내 number을 비교한 후 contains : 구현하다가 너무 어려워서 다른 방법
// Map으로 숫자별로 count 후 Map의 키값별 최대 최소 구하기

public class 이중우선순위큐_7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Integer> frontinout = new PriorityQueue<Integer>();
        PriorityQueue<Integer> backinout = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        boolean inout;
        int num;
        int check;

        
        for(int j=0;j<T;j++){
            frontinout.clear();
            backinout.clear();
            map = new HashMap<>();
            int K = Integer.parseInt(br.readLine());
            for(int i=0;i<K;i++){
                st = new StringTokenizer(br.readLine());

                if(st.nextToken().equals("I")) inout = true;
                else inout = false;

                num = Integer.parseInt(st.nextToken());
                if(inout){ // 넣기
                    frontinout.offer(num);
                    backinout.offer(num);
                    if(map.containsKey(num))
                        map.put(num,map.get(num)+1);   
                    else
                        map.put(num,1);                
                }else{ //빼기
                    if(num==1) {//최댓값 빼기
                        while(true){
                            if(backinout.size()==0) break;
                            check = backinout.poll();
                            if(!map.containsKey(check)) continue;
                            else if(map.get(check)==1) map.remove(check);
                            else map.put(check, map.get(check)-1);
                            
                            break;
                        }
                    }
                    else{ //최솟값 빼기
                        while(true){
                            if(frontinout.size()==0) break;
                            check = frontinout.poll();
                            if(!map.containsKey(check)) continue;
                            else if(map.get(check)==1) map.remove(check);
                            else map.put(check, map.get(check)-1);

                            break;
                        }
                    }
                }
                //System.out.println(map.toString());
                //System.out.println(backinout.toString());
                //System.out.println(frontinout.toString());
            }
            if(map.size()==0) answer.append("EMPTY");
            else{
                while(true){
                    check = backinout.poll();
                    if(!map.containsKey(check)) continue;
                    else answer.append(check); 
                    break;
                }
                answer.append(" ");
                while(true){
                    check = frontinout.poll();
                    if(!map.containsKey(check)) continue;
                    else answer.append(check);
                    
                    break;
                }
            }
            if(j!=T-1)
                answer.append("\n");
        }
        System.out.println(answer.toString());
    }
    
}
