package fourweek;

import java.util.Scanner;

/**
 * @author CHENHAOJIA
 * @date 2021-04-07 23:25
 */
public class Test3 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个整数：");
        int number = sc.nextInt();
        System.out.print("该素数的全部因子：");
        isPrimeFactor(number);
    }

    private static void isPrimeFactor(int number) {
        for (int i = 2; i <= number;) {
            if(number%i==0){
                number=number/i;
                System.out.print(i+" ");
                i=2;
            }else i++;
        }
    }
}

