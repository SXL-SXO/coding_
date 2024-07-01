import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Collections;
public class Main{

    public static long factorial(long n){
        if(n==0||n==1){
            return 1;
        }
        else{
            return n*factorial(n-1);
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
       long n=scanner.nextLong();
        System.out.println(factorial(n));


    }

}