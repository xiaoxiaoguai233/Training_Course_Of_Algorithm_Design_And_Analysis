package com.wuzesheng.org.上机考试预测;

public class _3_3_最长公共子序列_动态规划 {

    private static String findStr = "";

    public static int findLCS(String A, int n, String B, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = 0;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    findStr+= A.charAt(i - 1) + "";
                } else {
                    dp[i][j] = dp[i - 1][j] > dp[i][j - 1] ? dp[i - 1][j] : dp[i][j - 1];
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        String str1 = "abcdefghizkl";
        String str2 = "defghizklBC";
        System.out.println("最长公共子序列长度为：" + findLCS(str1, str1.length(), str2, str2.length()));
        System.out.println("最长公共子序列:" + findStr);
    }
}
