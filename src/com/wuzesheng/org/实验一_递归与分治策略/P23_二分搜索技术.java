package com.wuzesheng.org.实验一_递归与分治策略;

import java.util.Arrays;

/**
 * @author 吴泽胜
 * @FileName P23_二分搜索技术
 * @date 2020-09-21 4:57 下午
 * @Software: IntelliJ IDEA
 */

public class P23_二分搜索技术 {

    public static void main(String[] args){

        int[] arr = {5,45,87,3,45,954,546,78,465,478};
        Arrays.sort(arr);
        System.out.println(binarySeachch(arr,465,arr.length));
    }

    public static int binarySeachch(int[] a, int x, int n){
        int left = 0;
        int right = n-1;
        while (left <= right){
            int middle = (left + right)/2;
            if (x == a[middle]) return middle;
            if (x > a[middle]) left = middle + 1;
            else right = middle - 1;
        }
        return -1;
    }
}
