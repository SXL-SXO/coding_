package 기초;

public class 연속된수의합 {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        if(num%2==0)
            for(int i=0;i<num;i++)
                answer[i]=total/(num/2)/2-num/2+1+i;
        else
            for (int j=0;j<num;j++)
                answer[j]=total/num-num/2+j;
        return answer;
    }
}
