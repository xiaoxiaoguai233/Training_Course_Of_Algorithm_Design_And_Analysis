package com.wuzesheng.org.实验一_递归与分治策略;

/**
 * @author 吴泽胜
 * @FileName P17_例2_2_Fibonacci数列
 * @date 2020-09-21 12:54 下午
 * @Software: IntelliJ IDEA
 */

public class P17_例2_2_Fibonacci数列 {

    public static void main(String[] arg){
        System.out.println(Fibonacci(7));
    }

    public static int Fibonacci(int n){
        if( n  <= 1 ) return 1;
        return Fibonacci(n-1) + Fibonacci(n-2);
    }
}
