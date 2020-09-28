package com.wuzesheng.org.习题二;

/**
 * @author 吴泽胜
 * @FileName P49_2_32
 * @date 2020-09-29 12:50 上午
 * @Software: IntelliJ IDEA
 */

public class P49_2_32 {

    public static void main(String[] args)
    {
        int a[][]=new int [7][7];
        table(7,a);
        print(a);
    }

    public static void print(int a[][])
    {
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<a[0].length;j++)
                System.out.print(a[i][j]+ "\t");
            System.out.println();
        }
    }

    public static void table(int n,int [][]a)
    {
        int b=2;
        int k=(int)(Math.log(n)/Math.log(b));
        for(int i=0;i<n;i++)
        {
            a[0][i]=i;
        }
        int m=1;
        for(int s=1;s<=k;s++)
        {
            n/=2;
            for(int t=1;t<=n;t++)
            {
                for(int i=m;i<2*m;i++)
                {
                    for(int j=m;j<2*m;j++)
                    {
                        a[i][j+(t-1)*m*2]=a[i-m][j+(t-1)*m*2-m];
                        a[i][j+(t-1)*m*2-m]=a[i-m][j+(t-1)*m*2];
                    }
                }
            }
            m*=2;
        }
    }
}