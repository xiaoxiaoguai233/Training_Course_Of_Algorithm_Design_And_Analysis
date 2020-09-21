package com.wuzesheng.org.实验一_递归与分治策略;

import java.util.Arrays;

/**
 * @author 吴泽胜
 * @FileName P28_2_7_合并排序
 * @date 2020-09-21 6:32 下午
 * @Software: IntelliJ IDEA
 */

public class P28_2_7_合并排序 {

    public static void main(String[] args) {
        int original[] = new int[] { 6, 10, 25, 3, 33, 90, 60, 100, 56 };
        mergeSort(original);
        print(original);
    }

    private static void mergeSort(int[] original) {
        if (original == null) {
            throw new NullPointerException("The array can not be null !!!");
        }
        int length = original.length;
        if (length > 1) {
            int middle = length / 2;
            int partitionA[] = Arrays.copyOfRange(original, 0, middle);// 拆分问题规模
            int partitionB[] = Arrays.copyOfRange(original, middle, length);
            // 递归调用
            mergeSort(partitionA);
            mergeSort(partitionB);
            sort(partitionA, partitionB, original);
        }
    }

    private static void sort(int[] partitionA, int[] partitionB, int[] original) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < partitionA.length && j < partitionB.length) {
            if (partitionA[i] <= partitionB[j]) {
                original[k] = partitionA[i];
                i++;
            } else {
                original[k] = partitionB[j];
                j++;
            }
            k++;
        }
        if (i == partitionA.length) {
            while (k < original.length) {
                original[k] = partitionB[j];
                k++;
                j++;
            }
        } else if (j == partitionB.length) {
            while (k < original.length) {
                original[k] = partitionA[i];
                k++;
                i++;
            }
        }
    }

    private static void print(int[] array) {
        if (array == null) {
            throw new NullPointerException("The array can not be null !!!");
        }
        StringBuilder sb = new StringBuilder("[");
        for (int element : array) {
            sb.append(element + ", ");
        }
        sb.replace(sb.length() - 2, sb.length(), "]");
        System.out.println(sb.toString());
    }
}