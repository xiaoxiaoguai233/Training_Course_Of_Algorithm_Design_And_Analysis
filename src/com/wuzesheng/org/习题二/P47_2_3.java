package com.wuzesheng.org.习题二;

/**
 * @author 吴泽胜
 * @FileName P47_2_3
 * @date 2020-09-23 7:14 下午
 * @Software: IntelliJ IDEA
 */

public class P47_2_3 {

    private static int min = -1;
    private static int max = -1;

    public static void main(String[] args){

        int arr[] = {0,1,8,95,100,210,215,245,265,300};
        int value = binarySeachch(arr,116,arr.length);
        System.out.println( value == -1 ? ("-1  " + min + "  " + max) : value);
    }

    private static int binarySeachch(int[] a, int x, int n) {

        int left = 0;
        int right = n-1;
        while (left <= right){
            int middle = (left + right)/2;
            if (x == a[middle]) return middle;
            if (x > a[middle]){
                left = middle + 1;
                min = left - 1;
            }
            else{
                right = middle - 1;
                max = right + 1;
            }
        }
        return -1;

    }
}
