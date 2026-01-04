package recursion.basic;

public class Ntofive {
    public static void main(String[] args) {
        printNum(5);
        printNum2(5);

    }

    public  static void printNum(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        printNum(n-1);
    }

    public  static void printNum2(int n){
        if(n==0){
            return;
        }
        printNum2(n-1);
        System.out.println(n);
    }
}
