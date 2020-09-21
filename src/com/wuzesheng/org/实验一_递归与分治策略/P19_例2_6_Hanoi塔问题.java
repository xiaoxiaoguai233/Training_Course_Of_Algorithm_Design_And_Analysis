package com.wuzesheng.org.实验一_递归与分治策略;

import java.util.Scanner;

/**
 * @author 吴泽胜
 * @FileName P19_例2_6_Hanoi塔问题
 * @date 2020-09-21 2:46 下午
 * @Software: IntelliJ IDEA
 */

public class P19_例2_6_Hanoi塔问题 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        hanoi(n, 'A', 'B', 'C');
        scanner.close();
    }

    public static void move(char x, int n, char y){
        System.out.println("把编号为["+n+"]盘从"+x+" 移动到 "+y);
    }

    public static void hanoi(int n,char A,char B,char C){
        if(n==1)
            move(A,1,C);
        else{
            /*   步骤
             *   第一步，移走最上面的盘子，剩下一个最大的
             *   第二步，把最大的盘子移到目标盘
             *   第三步，移回第一步的盘子到目标盘
             */
            hanoi(n-1,A,C,B);//借助 【C】 把n-1个盘从【A】移到 【B】
            move(A,n,C);//把最大的盘子移动到【C】
            hanoi(n-1,B,A,C);//借助 【A】 把n-1个盘从【B】移到 【C】

        }
    }
}
