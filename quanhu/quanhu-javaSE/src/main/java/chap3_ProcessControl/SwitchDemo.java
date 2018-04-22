package chap3_ProcessControl;

import java.util.Scanner;

/**
 * auther:chenshi
 * date:2018-03-26 18:31
 * package:chap3_ProcessControl
 */
public class SwitchDemo {
    //如果分支>2则用switch，如果分支<2则采用if
    public static void  main(String[] args){
        System.out.println("输入1-4等级..");
        Scanner scanner = new Scanner(System.in);
        long leave = scanner.nextLong();
        switch ((int) leave){
            case 1:
                System.out.println("冠军");
                break;
            case 2:
                System.out.println("亚军");
                break;
            case 3:
                System.out.println("季军");
                break;
            default:
                System.out.println("未知因素");
                break;
        }
    }
}
