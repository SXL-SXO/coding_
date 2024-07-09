import java.util.*;
class Solution {
    static int N;
    static Stack<Node> stack = new Stack<>();
    public String[] solution(String[][] plans) {
        N = plans.length;
        String[] answer = new String[N];
        
        Node time[] = new Node[N];
        String st[];
        for(int i=0;i<N;i++){
            st = plans[i][1].split(":");
            time[i] = new Node(i, Integer.parseInt(st[0])*60 + Integer.parseInt(st[1]));
        }
        Arrays.sort(time, (o1, o2)->o1.time-o2.time);
        
        int now = time[0].time, j = 0;
        Node temp;
        for(int i=0;i<N-1;i++){
            now += Integer.parseInt(plans[time[i].i][2]);
            answer[j++] = plans[time[i].i][0];
            
            if(now > time[i+1].time){
                stack.push(new Node(time[i].i, now-time[i+1].time));   
                now = time[i+1].time;
                j--;
            }else if(now < time[i+1].time){
                while(!stack.isEmpty()){
                    temp = stack.pop();
                    now += temp.time;
                    answer[j++] = plans[temp.i][0];
                    
                    if(now > time[i+1].time){
                        stack.push(new Node(temp.i, now-time[i+1].time));
                        now = time[i+1].time;
                        j--;
                        break;
                    }else if(now == time[i+1].time) break;
                }
                now = time[i+1].time;
            }
        }
        answer[j++] = plans[time[N-1].i][0];
        while(!stack.isEmpty()){
            answer[j++] = plans[stack.pop().i][0];
        }
        return answer;
    }
    static class Node{
        int i, time;
        Node(int i, int time){
            this.i = i;
            this.time = time;
        }
    }
}