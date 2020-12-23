package com.wuzesheng.org.上机考试预测;

import com.wuzesheng.org.考试预测.Queue8;

import java.util.Arrays;

public class _5_5_n后问题_回溯法 {

    // 计数这是几个皇后的问题
    static int max = 8;
    // 创建皇后的大小
    int []array = new int[max];
    // 计数有几种排列方式
    static int count = 0;

    public static void main(String[] args) {
        _5_5_n后问题_回溯法 queue8 = new _5_5_n后问题_回溯法();
        // 从第0行第0个开始遍历
        queue8.check(0);
        System.out.println( max + "个皇后问题共有解法：" +count);
    }
    /**
     * 开始检索。dfs
     * @param n
     */
    private void check( int n ){
        // 出口，如果n的值等于max的话，说明已经遍历完成
        if( n == max ){
            print();		// 打印
            return;			// 返回
        }
        // 便利每行每个位置（8个位置）的情况，进行递归与回溯。
        for( int i = 0 ; i < max ; i++ ){
            // 将这一行的某个位置赋值
            array[n] = i;
            // 检查与前边的位置是否冲突
            if( judge(n) ){
                // 如果没有冲突，进行下一行。递归。
                check(n+1 );
            }
        }
    }
    // 判断当前位置是否与之前的位置冲突
    private boolean judge( int n ){
        for( int i = 0 ; i < n ; i++)
            if( array[n] == array[i] || Math.abs( n - i ) == Math.abs( array[n] - array[i] ) )
                return false;
        return true;
    }
    // 打印输出当前map的情况
    private void print(){
        count++;
        System.out.println( Arrays.toString(array) );
    }
}
