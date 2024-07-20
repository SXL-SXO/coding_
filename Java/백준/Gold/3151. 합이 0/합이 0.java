import java.util.*;
import java.io.*;
class Main
{
    static int N;
    static Long answer = 0L;
    static List<Integer> input = new ArrayList<>();
    static int num[] = new int[20001];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int number;
        for(int i=0;i<N;i++){
            number = Integer.parseInt(st.nextToken());
            if(num[number+10000]==0) input.add(number);
            num[number+10000]++;
        }

        if(num[10000]>=3) {
            answer += num[10000];
            answer *= (num[10000]-1);
            answer *= (num[10000]-2);
            answer /= 6;
        }

        Collections.sort(input);

        int size = input.size(), a, b;
        for(int i=0;i<size;i++){
            a = input.get(i);
            if(a>=0) break;
            for(int j=i+1;j<size;j++){
                b = input.get(j);
                if(a+b>10000) break;
                if(a+b<-10000 || num[10000-(a+b)]==0 ) continue;
                if(a == b) answer += (long)(num[a+10000]-1)*(long)(num[b+10000]-1)*(long)num[10000-(a+b)];
                else if(-a == a+b){
                    if(num[a+10000]>1) answer += ((long)(num[a+10000]-1)*(long)num[b+10000]*(long)num[10000+a])/2;
                }
                else if(-b == a+b){
                    if(num[b+10000]>1) answer += ((long)num[a+10000]*(long)(num[b+10000]-1)*(long)num[10000+b])/2;
                }
                else if(b < -a-b) answer += (long)num[a+10000]*(long)num[b+10000]*(long)num[10000-(a+b)];
            }
        }
        System.out.println(answer);
    }
}
