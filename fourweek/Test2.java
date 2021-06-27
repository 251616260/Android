package fourweek;

import java.io.*;
import java.util.Scanner;

/**
 * @author CHENHAOJIA
 * @date 2021-04-07 23:05
 */
public class Test2 {
    public static void main(String[] args) {
        String[] strings = new String[10];
        try {
            strings = readFile();
            luckDraw(strings);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    private static void luckDraw(String[] strings) {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        System.out.println("欢迎来到抽奖系统！");
        while (true) {
            System.out.println("请输入您的电话号码:");
            String number = sc.next();

            if (number.startsWith("0")) {
                System.out.println("退出抽奖系统");
                System.exit(0);
            }
            if (number.length() < 11) {
                System.out.println("请输入11位数的手机号");
                continue;
            }
            for (int j = 0; j < strings.length; j++) {
                if (number.equals(strings[j])) {
                    System.out.println("恭喜你，中奖了");
                    System.exit(0);
                }
            }
            System.out.println("没有中奖");
        }
    }

    private static String[] readFile() throws IOException {
        File file = new File("D:\\Java_code\\ruike\\MyWork\\src\\fourweek\\a.txt");
        FileInputStream fis = new FileInputStream(file);//字节流
        InputStreamReader read = new InputStreamReader(fis, "gbk");//字符流
        //  BufferedReader类从字符输入流中读取文本并缓冲字符，以便有效地读取字符，数组和行
        BufferedReader bufferedReader = new BufferedReader(read);

        String lineText = null;
        String[] strings = new String[10];
        int i = 0;
        //读取文本每一行，直到最后一行
        while ((lineText = bufferedReader.readLine()) != null) {
            //将文件中每一行添加到String数组
            strings[i++] = lineText;
        }
        //关闭io流
        read.close();
        return strings;
    }
}
