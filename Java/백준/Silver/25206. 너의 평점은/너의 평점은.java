import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double total = 0, grade = 0, answer = 0;
		String input[], num[];
		for(int i=0;i<20;i++){
		    input = br.readLine().split(" ");
		    num = input[1].split("\\.");
		    if(input[2].equals("A+")){
		        total += Integer.parseInt(num[0])*4.5;
		        grade += Integer.parseInt(num[0]);
		    }else if(input[2].equals("A0")){
		        total += Integer.parseInt(num[0])*4.0;
		        grade += Integer.parseInt(num[0]);
		    }else if(input[2].equals("B+")){
		        total += Integer.parseInt(num[0])*3.5;
		        grade += Integer.parseInt(num[0]);
		    }else if(input[2].equals("B0")){
		        total += Integer.parseInt(num[0])*3.0;
		        grade += Integer.parseInt(num[0]);
		    }else if(input[2].equals("C+")){
		        total += Integer.parseInt(num[0])*2.5;
		        grade += Integer.parseInt(num[0]);
		    }else if(input[2].equals("C0")){
		        total += Integer.parseInt(num[0])*2.0;
		        grade += Integer.parseInt(num[0]);
		    }else if(input[2].equals("D+")){
		        total += Integer.parseInt(num[0])*1.5;
		        grade += Integer.parseInt(num[0]);
		    }else if(input[2].equals("D0")){
		        total += Integer.parseInt(num[0])*1.0;
		        grade += Integer.parseInt(num[0]);
		    }else if(input[2].equals("F")){
		        grade += Integer.parseInt(num[0]);
		    }
		}
	    System.out.print(total/grade);
	}
}
