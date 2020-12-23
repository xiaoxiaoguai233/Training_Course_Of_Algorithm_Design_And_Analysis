package com.wuzesheng.org.上机考试预测;

import java.util.Collections;
import java.util.LinkedList;
/**
 * @author 吴泽胜
 * @FileName _6_7_旅行售货员问题_分支限界法
 * @date 2020-12-23 10:36 下午
 * @Software: IntelliJ IDEA
 */

public class _6_7_旅行售货员问题_分支限界法 {
    float[][] a;//图G的邻接矩阵

    public _6_7_旅行售货员问题_分支限界法(float[][] a){
        this.a = a;
    }
    public static class HeapNode implements Comparable{
        float lcost;//子树费用的下界
        float cc;//当前费用
        float rcost;//x[s:n-1]中顶点最小出边费用和
        int s;//根节点到当前节点的路径为x[0:s]
        int[] x;//需要进一步搜索的顶点是x[s+1:n-1]

        //构造方法
        public HeapNode(float lc,float ccc,float rc,int ss,int[] xx){
            lcost = lc;
            cc = ccc;
            s = ss;
            x = xx;
        }
        public int compareTo(Object x){
            float xlc = ((HeapNode) x).lcost;
            if(lcost < xlc) return -1;
            if(lcost == xlc) return 0;
            return 1;
        }
    }

    public float bbTsp(int[] v){
        int n = v.length-1;//节点数
        LinkedList<HeapNode> heap = new LinkedList<HeapNode>();
        //minOut[i]=i的最小出边费用
        float[] minOut = new float[n+1];
        float minSum = 0;//最小出边费用和
        for( int i = 1 ; i <= n ; i++ ){//针对每个节点，找到最小出边
            //计算minOut[i]和minSum
            float min = Float.MAX_VALUE;
            for(int j = 1 ; j <= n ; j++){
                if(a[i][j] < Float.MAX_VALUE&&a[i][j]<min)
                    min = a[i][j];
            }
            if(min==Float.MAX_VALUE)
                return Float.MAX_VALUE;
            minOut[i]=min;
            minSum+=min;
        }

        //初始化
        int[] x=new int[n];
        for(int i=0;i<n;i++)
            x[i]=i+1;
        HeapNode enode=new HeapNode(0,0,minSum,0,x);
        float bestc=Float.MAX_VALUE;

        //搜索排列空间树
        while(enode!=null&&enode.s<n-1){
            //非叶节点
            x=enode.x;
            if(enode.s==n-2){
                //当前扩展结点是叶节点的父节点
                //再加两条边构成回路
                //所构成回路是否优于当前最优解
                if(a[x[n-2]][x[n-1]]!=-1&&a[x[n-1]][1]!=-1&&enode.cc+a[x[n-2]][x[n-1]]+a[x[n-1]][1]<bestc){
                    //找到费用更小的回路
                    bestc=enode.cc+a[x[n-2]][x[n-1]]+a[x[n-1]][1];
                    enode.cc=bestc;
                    enode.lcost=bestc;
                    enode.s++;
                    heap.add(enode);
                    Collections.sort(heap);
                }
            }else{//内部结点
                //产生当前扩展结点的儿子结点
                for(int i=enode.s+1;i<n;i++){
                    if(a[x[enode.s]][x[i]]!=-1){
                        //可行儿子结点
                        float cc=enode.cc+a[x[enode.s]][x[i]];
                        float rcost=enode.rcost=minOut[x[enode.s]];
                        float b=cc+rcost;//下界
                        if(b<bestc){
                            //子树可能含有最优解，结点插入最小堆
                            int[] xx=new int[n];
                            for(int j=0;j<n;j++)
                                xx[j]=x[j];
                            xx[enode.s+1]=x[i];
                            xx[i]=x[enode.s+1];
                            HeapNode node=new HeapNode(b,cc,rcost,enode.s+1,xx);
                            heap.add(node);
                            Collections.sort(heap);
                        }
                    }
                }

            }

            //取下一个扩展结点
            enode=heap.poll();
        }
        //将最优解复制到v[1...n]
        for(int i=0;i<n;i++)
            v[i+1]=x[i];
        return bestc;
    }
    public static void main(String[] args) {
        int n = 5;
        float[][] a = {{0,0,0,0,0,0},{0,-1,5,-1,7,9},{0,5,-1,10,3,6},{0,-1,10,-1,8,-1},{0,7,3,8,-1,4},{0,9,6,-1,4,-1}};   //a下标从1开始，0用来凑数；-1表示不同，1表示连通
        _6_7_旅行售货员问题_分支限界法 b = new _6_7_旅行售货员问题_分支限界法(a);
        int []v = new int[n+1];
        System.out.println("最短回路长为："+b.bbTsp(v));
        System.out.print("最短回路为：");
        for( int i = 1 ; i <= n ; i++ ){
            System.out.print( v[i] + " " );
        }
    }
}
