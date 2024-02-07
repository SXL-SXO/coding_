import java.util.*;
import java.io.*;

public class 분수찾기_1193 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
        int son=1, mom=1;
        boolean type = true;
        for(int i=0;i<count-1;i++){
		    if(type==true){
                if(son==1){
                    mom+=1;
                    type=false;
                    continue;
                }
                mom+=1;
                son-=1;
            }
            else{
                if(mom==1){
                    son+=1;
                    type=true;
                    continue;
                }
                mom-=1;
                son+=1;
            }
        }
        System.out.print(son+"/"+mom);
    }
}