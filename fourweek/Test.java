package fourweek;

import java.util.Scanner;

/**
 * @author CHENHAOJIA
 * @date 2021-04-07 17:01
 */
public class Test {
    public static void main(String[] args) {
        luckDraw1();
    }

    private static void luckDraw1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("欢迎来到抽奖系统！");

        StringBuffer sb = new StringBuffer();
        sb.append('1');
        for (int i = 0; i <10 ; i++) {
            Integer random = (int) (Math.random()*(10-1)+1);
            sb.append(random);
        }
        String num1 = sb.toString();
        System.out.println("管理员模式查看中奖手机号"+num1);
        while(true){
            System.out.println("请输入您的手机号");
            String num = sc.next();

            if (num.startsWith("0")) {
                System.out.println("退出抽奖系统");
                System.exit(0);
            }
            if(num.length()<11){
                System.out.println("请输入11位数的手机号");
                continue;
            }
            if(num.equals(num1)){
                System.out.println("中奖了");
                System.exit(0);
            }else{
                System.out.println("没有中奖");
            }
        }
    }
}
