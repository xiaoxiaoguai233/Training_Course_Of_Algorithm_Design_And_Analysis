package com.wuzesheng.org.上机考试预测;

/**
 * @author 吴泽胜
 * @FileName _5_5_最小生成树_回溯法
 * @date 2020-12-23 10:40 下午
 * @Software: IntelliJ IDEA
 */

public class _4_6_最小生成树_贪心算法 {

    public static void prim(int n,float[][] c){
        float[] lowcost=new float[n+1];
        int[] closest=new int[n+1];//表示i到其他所有未添加进来的顶点的最短距离
        boolean[] s=new boolean[n+1];//

        //初始化
        s[1]=true;
        for(int i=2;i<=n;i++){
            lowcost[i]=c[1][i];
            closest[i]=1;
            s[i]=false;
        }
        for(int i=1;i<n;i++){//循环n-1次
            float min=Float.MAX_VALUE;
            int j=1;
            for(int k=2;k<=n;k++){
                if(lowcost[k]!=-1&&(lowcost[k]<min)&&(!s[k])){
                    min=lowcost[k];
                    j=k;
                }
            }
            System.out.println(closest[j]+", "+j);
            s[j]=true;//将j添加到S中
            //逐个更改lowcost[k],如果c[j][k]<lowcost[k]则更改lowcost[k]为最小
            for(int k=2;k<=n;k++){
                if(!s[k]&&c[j][k]!=-1){
                    if(c[j][k]<lowcost[k]||lowcost[k]==-1){
                        lowcost[k]=c[j][k];
                        closest[k]=j;
                    }
                }

            }
        }

    }
    public static void main(String[] args) {
        // 定点个数
        int n = 6;
        // 图的路径长度
        float[][] a =
        {   // 列不动
            { 0 },      // 不动  （第0行第0列）
            { 0, -1,6,1,5,-1,-1 },
            { 0, 6,-1,5,-1,3,-1 },
            { 0, 1,5,-1,5,6,4 },
            { 0, 5,-1,5,-1,-1,2 },
            { 0, -1,3,6,-1,-1,6 },
            { 0, -1,-1,4,2,6,-1 }
        };
        System.out.println("依次构成树的边为（用两个顶点表示边）：");
        prim( n , a );
    }

}
