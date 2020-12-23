package com.wuzesheng.org.上机考试预测;

/**
 * @author 吴泽胜
 * @FileName _3_4_凸多边形最优三角形问题_动态规划
 * @date 2020-12-23 10:30 下午
 * @Software: IntelliJ IDEA
 */

public class _3_4_凸多边形最优三角形问题_动态规划 {

    public static int weight[][] =  {{0,2,2,3,1,4},{2,0,1,5,2,3},{2,1,0,2,1,4},{3,5,2,0,6,2},{1,2,1,6,0,1},{4,3,4,2,1,0}};
    public static int weight(int a,int b,int c){
        return weight[a][b] + weight[b][c] + weight[a][c];
    }
    public static int MinWeightTriangulation(int n, int[][] t, int[][] s) {
        for(int i = 1; i <= n; i++) {
            t[i][i] = 0;
        }
        for(int r = 2; r <= n; r++) {
            for(int i = 1; i <=n-r+1;i++) {
                int j = i + r -1;
                t[i][j] = t[i+1][j] + weight(i - 1, i, j);
                s[i][j] = i;
                for(int k = i+1; k < i+r-1; k++) {
                    int u = t[i][k] + t[k+1][j] + weight(i - 1, k, j);
                    if(u < t[i][j]) {
                        t[i][j] = u;
                        s[i][j] = k;
                    }
                }
            }
        }
        return t[1][5];
    }
    public static void Traceback(int i, int j, int[][] s) {
        if(i == j) return;
        Traceback(i,s[i][j],s);
        Traceback(s[i][j] + 1,j,s);
        System.out.println("三角剖分顶点：V" + (i-1) + ",V" + j + ",V" + s[i][j]);
    }
    public static void main(String args[]) {
        int[][] s = new int[7][7];
        int[][] t = new int[7][7];
        for(int i = 1; i < 7; i ++) {
            s[i] = new int[7];
            t[i] = new int[7];
        }
        System.out.println("此多边形的最优三角剖分值为：" + MinWeightTriangulation(5,t,s));
        Traceback(1,5,s);
    }
}
