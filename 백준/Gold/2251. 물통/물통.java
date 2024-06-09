import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    static int A, B, C;
    static Queue<Integer> queue = new ArrayDeque<>();
    static boolean num[] = new boolean[8_120_602];
    static boolean answer[] = new boolean[201];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        queue.offer(C);
        Node temp;
        int a, b, c;
        while(!queue.isEmpty()){
            temp = decoding(queue.poll());
            a = temp.a;
            b = temp.b;
            c = temp.c;

            if(num[encoding(a,b,c)]) continue;
            num[encoding(a,b,c)] = true;

            if(a == 0) {
//                System.out.println(a+" "+b+" "+c);
                answer[c] = true;
            }

            //A->B
            if(temp.a > 0 && temp.b < B) {
                a=temp.a; b=temp.b; c=temp.c;
                b += a;
                if(b > B) {
                    a = b - B;
                    b = B;
                }
                else
                    a = 0;
                queue.offer(encoding(a,b,c));
            }
            //A->C
            if(temp.a > 0 && temp.c < C) {
                a=temp.a;b=temp.b;c=temp.c;
                c += a;
                if(c > C) {
                    a = c - C;
                    c = C;
                }
                else
                    a = 0;
                queue.offer(encoding(a,b,c));
            }
            //B->A
            if(temp.b > 0 && temp.a < A) {
                a=temp.a;b=temp.b;c=temp.c;

                a += b;
                if(a > A) {
                    b = a - A;
                    a = A;
                }
                else
                    b = 0;

                queue.offer(encoding(a,b,c));
            }
            //B->C
            if(temp.b > 0 && temp.c < C) {
                a=temp.a;b=temp.b;c=temp.c;

                c += b;
                if(c > C) {
                    b = c - C;
                    c = C;
                }
                else
                    b = 0;

                queue.offer(encoding(a,b,c));
            }
            //C->A
            if(temp.c > 0 && temp.a < A) {
                a=temp.a;b=temp.b;c=temp.c;

                a += c;
                if(a > A) {
                    c = a - A;
                    a = A;
                }
                else
                    c = 0;

                queue.offer(encoding(a,b,c));
            }
            //C->B
            if(temp.c > 0 && temp.b < B) {
                a = temp.a;
                b = temp.b;
                c = temp.c;

                b += c;
                if (b > B){
                    c = b - B;
                    b = B;
                }
                else
                    c = 0;

                queue.offer(encoding(a, b, c));
            }
        }

        for(int i=0;i<201;i++){
            if(answer[i]) sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
    static int encoding(int a, int b, int c){
        return 40401*a + 201*b + c;
    }
    static Node decoding(int sum){
        return new Node(sum/40401, (sum%40401)/201, sum%201);
    }
    static class Node {
        int a, b, c;
        Node(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

    }
}