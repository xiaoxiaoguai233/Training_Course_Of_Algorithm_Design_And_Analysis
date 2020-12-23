package com.wuzesheng.org.上机考试预测;

public class _5_8_图的m着色问题_回溯法 {

    static int n;              //图的顶点数
    static int m;              //可用颜色数
    static int[][] a;          //图的邻接矩阵
    static int[] x;            //当前解
    static long sum;           //当前已找到的可m着色方案数

    // 初始化赋值
    public long init(int mm,int nn,int[][] aa){
        n = nn;
        a = aa;
        x = new int[n+1];
        m = mm;
        sum = 0;
        backtrack(1);
        return sum;
    }
    // 回溯，深搜，dfs
    public void backtrack(int t){
        if( t > n ){
            sum++;
            // 输出解
            for( int i = 1 ; i <= n ; i++ )
                System.out.print( x[i] + "\t" );
            System.out.println();
        }else{
            for( int i = 1 ; i <= m ; i++ ){
                x[t] = i;
                //剪枝函数
                if( judge(t) )
                    backtrack(t+1);
                x[t] = 0;
            }
        }
    }
    // 判断是否冲突
    public boolean judge( int k ){
        for( int j = 1 ; j <= n ; j++ )
            if( a[k][j] == 1 && x[j] == x[k] )      //某条边的两个顶点着不同颜色；a[k][j]=1表示某条边（即边集E中的边）
                return false;
        return true;
    }
    // 主函数
    public static void main(String[] args) {
        int n = 5;
        int m = 5;
        int[][] a = { {-1,-1,-1,-1,-1,-1},
                    {-1,0,1,1,1,0},
                    {-1,1,0,1,1,1},
                    {-1,1,1,0,1,0},
                    {-1,1,1,1,0,1},
                    {-1,0,1,0,1,0}
        };
        System.out.println("着色方案如下：");
        long sum = new _5_8_图的m着色问题_回溯法().init( m, n, a );
        System.out.println( "可行的着色方案数目为：" + sum );
    }
}
