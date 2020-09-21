package com.wuzesheng.org.实验一_递归与分治策略;

/**
 * @author 吴泽胜
 * @FileName P23_大整数的乘法
 * @date 2020-09-21 5:10 下午
 * @Software: IntelliJ IDEA
 */

public class P23_大整数的乘法 {

    public static void main(String[] args) {
        String str1 = "23451515412151511212";
        String str2 = "3614844151515151515151";

        int len1 = str1.length();
        int len2 = str2.length();

        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        convert(s1, len1);//高低位对调
        convert(s2, len2);
        int csize = len1 + len2 + 3;
        //创建一个数组，处理相乘后的结果，两个数相乘之后的结果的位数不超过两个数的位数的和加3
        //比如两个两位数相乘是定小于100*100的
        int c[] = new int[csize];
        // 乘积数组填充0
        for (int ii = 0; ii < csize; ii++)
            c[ii] = 0;
        for (int i = 0; i < len1; i++)
            for (int j = 0; j < len2; j++) {
                int a = Integer.parseInt(String.valueOf(s1[i]));
                int b = Integer.parseInt(String.valueOf(s2[j]));
                c[i + j] += a * b;
            }

        //高位处理
        int m = 0;
        for(;m<csize;m++) {
            int carry = c[m]/10;
            c[m] = (char) (c[m]%10);
            if(carry>0)
                c[m+1] += (char) carry;
        }

        // 找到最高位
        for (m = csize - 1; m >= 0;m--)
            if (c[m] > 0)
                break;

        // 由最高位开始打印乘积
        for (int n = 0; n <= m; n++)
            System.out.print(c[m - n]);
        System.out.println("");
    }

    public static void convert(char[] s,int len) {
        for(int i=0;i<len/2;i++) {
            s[i] += s[len-i-1];
            s[len-i-1] = (char) (s[i]-s[len-i-1]);
            s[i] = (char) (s[i] - s[len-i-1]);
        }
    }
}
