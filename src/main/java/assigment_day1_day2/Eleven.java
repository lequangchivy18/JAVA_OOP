package assigment_day1_day2;

public class Eleven {
    
    public static void main(String[] args) {
        int x = 10;
        System.out.println("Before call process: " + x);
        process(x);
        System.out.println("After call process: " + x);
        //System.out.println("After call process: " + process(x));
    }

    public static void process(int y) {
        y = 7;
        //return x;
    }
}
