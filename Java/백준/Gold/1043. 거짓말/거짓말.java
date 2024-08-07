import java.util.*;
import java.io.*;
public class Main
{
	static int N, M, K, answer;
	static List<List<Integer>> partywith = new ArrayList<>();
	static List<List<Integer>> link = new ArrayList<>();
    static List<List<Integer>> partywhere = new ArrayList<>();
	static boolean check_party[];
	static boolean people[];
	static Queue<Integer> queue = new ArrayDeque<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		answer = M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		people = new boolean[N];
		check_party = new boolean[M];
		for(int j=0; j<N; j++) {
			link.add(new ArrayList<>());
			partywhere.add(new ArrayList<>());
		}
		
		int num;
		for(int i=0; i<K; i++) {
		    num = Integer.parseInt(st.nextToken())-1;
			people[num] = true;
			queue.offer(num);
		}
		for(int j=0; j<M; j++) {
            st = new StringTokenizer(br.readLine());
		    K = Integer.parseInt(st.nextToken());
		    partywith.add(new ArrayList());
		    for(int i=0;i<K;i++){
		        num = Integer.parseInt(st.nextToken())-1;
		        partywith.get(j).add(num);
		        partywhere.get(num).add(j);
		    }
		}
		while(!queue.isEmpty()){
		    num = queue.poll();
		    for(int i : partywhere.get(num)){
		        if(check_party[i]) continue;
		        check_party[i] = true;
		        answer--;
		        for(int j:partywith.get(i)){
		            if(people[j]) continue;
		            people[j] = true;
		            queue.offer(j);
		        }
		    }
		}
		
		System.out.print(answer);
	}
}
