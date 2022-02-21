package if_statement;

public class Test01 {
    public static void main(String[] args) {
        int a=30;
        int b=35;
        int c=10;

        if(a>b&& a>c)
        {
            System.out.println(a);
        }
        else if(b>c)
        {
            System.out.println(b);
        }
        else {
            System.out.println(c);
        }
    }
}
