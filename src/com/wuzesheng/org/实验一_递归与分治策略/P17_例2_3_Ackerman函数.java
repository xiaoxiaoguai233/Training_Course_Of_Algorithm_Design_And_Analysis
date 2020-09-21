package com.wuzesheng.org.实验一_递归与分治策略;

import java.util.Scanner;

/**
 * @author 吴泽胜
 * @FileName P17_例2_3_Ackerman函数
 * @date 2020-09-21 1:06 下午
 * @Software: IntelliJ IDEA
 */

public class P17_例2_3_Ackerman函数 {

    public static int ack(int n,int m){
        if(m==0&&n==1) return 2;
        if(m>=0&&n==0)return 1;
        if(m==0&&n>=2)return n+2;
        return ack(ack(n-1,m),m-1);
    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int a=s.nextInt();
        int b=s.nextInt();
        System.out.print(ack(a,b));
    }
}
