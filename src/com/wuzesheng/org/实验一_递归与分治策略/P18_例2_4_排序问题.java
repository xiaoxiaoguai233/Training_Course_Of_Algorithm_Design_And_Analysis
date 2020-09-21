package com.wuzesheng.org.实验一_递归与分治策略;

/**
 * @author 吴泽胜
 * @FileName P18_例2_4_排序问题
 * @date 2020-09-21 1:14 下午
 * @Software: IntelliJ IDEA
 */

public class P18_例2_4_排序问题 {

    public static void main(String[] arg){

        int[] arr = {1, 2, 5, 0, 10};
        perm(arr, 0 , arr.length);
    }

    public static void perm(int[] list , int k , int m){
        if (k == m ){
            for (int i = 0; i <= m ; i++)
                System.out.println(list[i]);
            System.out.println();
        }
        else
            for (int i = k; i <= m ; i++) {
                swap(list, k, i);
                swap(list, k+1, m);
                swap(list, k, i);
            }
    }

    private static void swap(int[] list, int i, int m) {
        int temp = (int) list[i];
        list[i] = list[m];
        list[m] = temp;
    }
}
