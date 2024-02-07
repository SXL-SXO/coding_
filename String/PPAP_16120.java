import java.io.*;
import java.util.*;

public class PPAP_16120 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Stack<String> stack = new Stack<String>();
        char[] arr = s.toCharArray();
        String[] before = new String[4];

        for(int i=0;i<s.length();i++){
            stack.push(arr[i]+"");
            
            if(stack.size()>=4){
                before[0]=stack.pop();
                before[1]=stack.pop();
                before[2]=stack.pop();
                before[3]=stack.pop();

                if(before[0].equals("P") && before[1].equals("A") && before[2].equals("P") && before[3].equals("P")){
                    i-=1;
                    continue;
                }else{
                    stack.push(before[3]);
                    stack.push(before[2]);
                    stack.push(before[1]);
                    stack.push(before[0]);
                }
                    
            }
        }
        if(stack.size()==0)
            System.out.println("PPAP");
        else if(stack.size()==1){
            if(stack.pop().equals("P"))
                System.out.println("PPAP");
            else
                System.out.println("NP");
        }
        else{
            System.out.println("NP");
        }

    }
}
