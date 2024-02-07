<<<<<<< HEAD
package bj_coding;

import java.io.*;
import java.util.*;

public class 회사에있는사람_7785 {
     public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int M = 0;

        HashMap<String,ArrayList<String>> people = new HashMap<String,ArrayList<String>>();
        
        for(int i=0;i<N;i++){
            StringTokenizer getNum = new StringTokenizer(br.readLine());
            
            String name = getNum.nextToken();
            String state = getNum.nextToken();
            ArrayList<String> namelist = new ArrayList<>();
            if(state.equals("enter")){
                M+=1;
                if(people.containsKey(name.toUpperCase())){
                    namelist=people.get(name.toUpperCase());
                    namelist.add(name);
                    people.put(name.toUpperCase(),namelist);
                }
                else{
                    namelist.add(name);
                    people.put(name.toUpperCase(), namelist);
                }
            }
            else{
                M-=1;
                namelist=people.get(name.toUpperCase());
                for(int l=0;l<namelist.size();l++)
                    if(namelist.get(l).equals(name))
                        namelist.remove(l);
                if(namelist.size()>0)
                    people.put(name.toUpperCase(),namelist);
            }
        }
        String answer_s[] = new String [people.size()];
        StringBuilder answer = new StringBuilder();

        int j=0;

        for(String value : people.keySet()){
            answer_s[j++] = value;
        }
        Arrays.sort(answer_s);

        for(int k=answer_s.length-1;k>-1;k--){
            ArrayList<String> namelist = people.get(answer_s[k]);
            for(String name : namelist)
                answer.append(name+"\n");
        }
        System.out.print(answer);
    }   
}
=======
import java.io.*;
import java.util.*;

public class 회사에있는사람_7785 {
    public static void main(String[] args) throws Exception {
        PriorityQueue<String> queue = new PriorityQueue<>((o1,o2) -> o2-o1);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            if(st.nextToken().equals("leave"))
                queue.remove(name);
            else
                queue.offer(name);
        }
    }
}
>>>>>>> fb68284e4863ad1d144eb4e205273080d43d2d9d
