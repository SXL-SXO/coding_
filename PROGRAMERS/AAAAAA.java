public class AAAAAA {
    // int add(int a, int b){return a+b;}
    // //int add(int x, int y){return x+y;}

    // //long add(int a, int b){return a+b;}

    // long add(long a, int b){return a+b;}
    // long add(int a, Long b){return a+b;}
    // int iv;
    // static int cv;

    // {
    //     System.out.println("instance");
    //     iv=100;
    // }

    // static{
    //     System.out.println("static");
    //     cv=100;
    // }

    // public AAAAAA(){
    //     System.out.printf("생성자 iv %d, cv %d \n", iv, cv);
    //     this.iv=300;
    // }
    // public static void main(String[] args) {
    //     AAAAAA aa1 = new AAAAAA(); 
    //     System.out.printf("1 iv %d, cv %d\n", aa1.iv, cv);
        
    //     AAAAAA aa2 = new AAAAAA(); 
    //     System.out.printf("2 iv %d, cv %d\n", aa2.iv, cv);
    // }
    static {System.out.println("static");}
    String name;
    {
        System.out.println(this.name);
    }
    static {System.out.println("static2");}
    {
        System.out.println("6");}
    static int y=5;
    public static void main(String[] args) {
        System.out.println(AAAAAA.y);
    }
}
