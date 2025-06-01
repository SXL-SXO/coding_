//11:27
class Solution {
    static String c1[], c2[], g[];
    static int A, B, N;
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        c1 = cards1;
        c2 = cards2;
        g = goal;
        
        A = c1.length;
        B = c2.length;
        N = g.length;
        
        if(make(0, 0, 0)) return "Yes";
        else return "No";
    }
    static boolean make(int a, int b, int c){
        if(c==N) return true;
         
        boolean res = false;
        if(a<A && c1[a].equals(g[c])) res |= make(a+1, b, c+1);
        if(b<B && c2[b].equals(g[c])) res |= make(a, b+1, c+1);
        return res;
    }
}