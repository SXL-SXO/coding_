import java.util.*;
class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        Arrays.sort(numlist);
        
        int front=-1, next=numlist.length;
        
        for(int i=0;i<numlist.length-1;i++){
            if(n>=numlist[i]&&numlist[i+1]>n){
                front=i;
                next=i+1;
                break;
            }
            if(i==numlist.length-2){
                front=n-1;
                next=numlist.length;
                break;
            }
        }
        
        for(int i=0;i<numlist.length;i++){
            if(front==-1){
                answer[i]=numlist[next];
                next++;
                continue;
            }
            else if(next==numlist.length){
                answer[i]=numlist[front];
                front--;
                continue;
            }
            else if(n-numlist[front]<numlist[next]-n){
                answer[i]=numlist[front];
                front--;
                continue;
            }
            else {
                answer[i]=numlist[next];
                next++;
                continue;
            }
        }
       
        return answer;
    }
}
}
