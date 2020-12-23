package com.wuzesheng.org.考试预测;

/**
 * @author 吴泽胜
 * @FileName Queue8
 * @date 2020-12-05 12:32 下午
 * @Software: IntelliJ IDEA
 */

public class Queue8 {

    private static int count = 0;
    private static int max = 8;
    private static int[] array = new int[max];

    public static void main(String[] args) {

        Queue8 queue8 = new Queue8();
        queue8.check(0);

        System.out.println(count);
    }

    /**
     * dfs 回溯
     * @param n
     */
    public void check( int n ){

        // 出口
        if ( n == max ){
            print();
            count++;
            return;
        }

        for (int i = 0; i < max; i++) {
            array[n] = i;
            if ( judge( n ))
                check( n + 1);
        }
    }

    /**
     * 检查是否有误
     * @param n
     * @return
     */
    public boolean judge( int n ){

        for (int i = 0; i < n; i++) {
            if ( array[i] == array[n] || Math.abs( n - i ) == Math.abs( array[n] - array[i]) )
                return false;
        }
        return true;
    }

    /**
     * 打印
     */
    public void print(){

        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + "  ");
        System.out.println();
    }
}
