package chap3_ProcessControl;

/**
 * auther:chenshi
 * date:2018-03-26 18:50
 * package:chap3_ProcessControl
 */
public class WhileDemo {
    /**
     *1，能够确定循环次数的用for，不能确定的用while
     * 2,如果循环体至少需要执行一次，则用do-while
     */
    public static void  main(String[] args){
        int i=0;
        while (true) {
            System.out.println("helloword"+i);
            i++;
            if (i>10) break;
        }
    }
}
