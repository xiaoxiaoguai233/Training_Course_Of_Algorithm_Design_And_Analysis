package com.wuzesheng.org.上机考试预测;

import java.util.Arrays;

public class _2_3_二分搜索_递归与分治策略 {

    public static void main(String[] args){

        // 定义变量
        int[] arr = {5,45,87,3,45,954,546,78,465,478};
        // Arrays类中sort方法对数组进行双轴快速排序
        Arrays.sort(arr);
        System.out.println(  Arrays.toString(arr) );
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
