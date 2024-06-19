import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int happy = input.length()-input.replace(":-)","").length(),
        sad = input.length()-input.replace(":-(","").length();
        if(happy==0 && sad==0) System.out.println("none");
        else if(happy>sad)
            System.out.println("happy");
        else if(happy<sad)
            System.out.println("sad");
        else
            System.out.println("unsure");
    }
}
