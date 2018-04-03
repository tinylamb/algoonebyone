package recursion;

import java.util.Scanner;

/**
 * Created by samo on 2018/4/3.
 *
 * @author samo
 * @date 2018/04/03
 */
public class ComputeFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("input a integer : ");
            int input = scanner.nextInt();
            System.out.println(String.format("%d! = %d", input, fib(input)));
        }


    }

    public static int fib(int n) {
        if (n == 0) {
            return 1;
        } else {
            return fib(n - 1) * n;
        }

    }
}
