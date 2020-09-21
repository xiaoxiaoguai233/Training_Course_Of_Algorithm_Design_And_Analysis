package com.wuzesheng.org.实验一_递归与分治策略;

/**
 * @author 吴泽胜
 * @FileName P18_例2_5_整数划分问题
 * @date 2020-09-21 1:25 下午
 * @Software: IntelliJ IDEA
 */

public class P18_例2_5_整数划分问题 {

    public static void main(String[] arg){

        System.out.println(q(5,2));
    }

    public static int q(int n , int m){
        if (n < 1 || m < 1 ) return 0;
        if (n == 1 || m == 1 ) return 1;
        if (n < m ) return q(n,n);
        if (n == m ) return q(n,m-1) + 1;
        return q(n,m-1) + q(n-m,m);
    }
}
