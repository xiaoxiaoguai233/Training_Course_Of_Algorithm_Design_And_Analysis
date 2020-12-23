package com.wuzesheng.org.上机考试预测;

/**
 * @author 吴泽胜
 * @FileName _3_1_矩阵连乘_动态规划
 * @date 2020-12-23 10:28 下午
 * @Software: IntelliJ IDEA
 */

public class _3_1_矩阵连乘_动态规划 {

    private static int[][]m = { {1,2,3}, {4,5,6}, {7,8,9}, {10,11,12}, {13,14,15}};
    private static int[][]s = { {1,2,3}, {4,5,6}, {7,8,9}, {10,11,12}, {13,14,15}};
    // 此方法用来求解矩阵连乘的最小数乘次数
    public String matrixChain(int p[]) {
        int n = p.length - 1;  //为p的实际最大下标
        int m[][] = new int[n + 1][n + 1];
        int s[][] = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            m[i][i] = 0;
        }
        for (int r = 2; r <= n; r++) // r为当前计算的链长
        {
            for (int i = 1; i <= n - r + 1; i++)// n-r+1为最后一个r链的前边界
            {
                int j = i + r - 1;// 计算前边界为r，链长为r的链的后边界
                m[i][j] = m[i + 1][j] + p[i - 1] * p[i] * p[j];// 将链ij划分为A(i) *( A[i+1:j] )
                s[i][j] = i;
                for (int k = i + 1; k < j; k++) {
                    // 将链i、j划分为( A[i:k] )* (A[k+1:j])
                    int t = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (t < m[i][j]) {
                        m[i][j] = t;
                        s[i][j] = k;
                    }
                }
            }
        }
        String answer = "";
        answer = answer + "此矩阵连乘所需的最小次数为：" + m[1][n] + "\n";
        matrixTraceBack(1, n, s);
        return answer;
    }
    private void matrixTraceBack(int i, int j, int s[][]) {
        if (i == j) {
            return;
        }
        matrixTraceBack(i, s[i][j], s);
        matrixTraceBack(s[i][j] + 1, j, s);
        int x = s[i][j] + 1;
        System.out.print("Multipy A" + i + "," + s[i][j]);
        System.out.println(" and A" + x + "," + j);
    }

    public static void main(String[] args) {
        _3_1_矩阵连乘_动态规划 temp = new _3_1_矩阵连乘_动态规划();
        System.out.println(temp.matrixChain(m[0]));
    }
}
