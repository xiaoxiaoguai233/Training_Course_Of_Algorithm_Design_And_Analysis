package com.wuzesheng.org.实验一_递归与分治策略;

/**
 * @author 吴泽胜
 * @FileName P16_例2_1_递归函数
 * @date 2020-09-21 12:41 下午
 * @Software: IntelliJ IDEA
 */

public class P16_例2_1_递归函数 {

    public static void main(String[] arg){
        System.out.println(factorial(7));
    }

    public static int factorial(int n){
        if( n  == 0 ) return 1;
        return n*factorial(n-1);
    }

}
