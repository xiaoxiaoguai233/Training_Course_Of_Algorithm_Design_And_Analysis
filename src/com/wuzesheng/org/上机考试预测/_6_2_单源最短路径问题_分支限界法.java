package com.wuzesheng.org.上机考试预测;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author 吴泽胜
 * @FileName _6_2_单源最短路径问题_分支限界法
 * @date 2020-12-23 9:56 下午
 * @Software: IntelliJ IDEA
 */

public class _6_2_单源最短路径问题_分支限界法 {

    public static class Heapnode implements Comparable{
        int id;//顶点编号
        float length;//当前路长
        public Heapnode(int i,float l){
            id = i;
            length = l;
        }
        @Override
        public int compareTo(Object x) {
            float xl=((Heapnode)x).length;
            if( length < xl ) return -1;
            if( length == xl ) return 0;
            return 1;
        }
    }
    public static void shortest(float[][] a,int v,float[] dist,int[] p){
        //dist[j]保存从源到顶点j的距离;p[j]记录从源到顶点j的路径上的前驱顶点
        int n = p.length-1 ;
        LinkedList<Heapnode> nodes = new LinkedList<Heapnode>();//用LinkedList存储最小堆
        Heapnode enode = new Heapnode(v,0);
        for( int j = 1 ; j <= n ; j++ ){
            dist[j] = Float.MAX_VALUE;
        }
        while(true){//搜索问题解空间
            for(int j=1;j<=n;j++){
                if( a[enode.id][j] != -1 && enode.length + a[enode.id][j] < dist[j] ){
                    //顶点i到j可达，同时长度小于dist[j]
                    dist[j] = enode.length + a[enode.id][j];
                    p[j] = enode.id;
                    Heapnode e = new Heapnode(j,dist[j]);
                    nodes.add(e);
                    Collections.sort(nodes);
                }
            }
            //取下一个扩展结点
            if(nodes.isEmpty())
                break;
            else
                enode = (Heapnode) nodes.poll();
        }
        for( int i = 2 ; i <= n ; i++)
            System.out.println( i + "节点的最短距离是：" + dist[i] + "；前驱点是：" + p[i] );
    }
    public static void main(String[] args) {

        int n = 5;  // 图顶点的个数
        float[] dist = new float[n+1];
        int[] prev = new int[n+1];

        float[][] a =
        {   // 列不动
            { 0 },                      // 不动  （第0行第0列）
            { 0, -1, 10, -1, 30, 100 },
            { 0, -1, -1, 50, -1, -1 },
            { 0, -1, -1, -1, -1, 10 },
            { 0, -1, -1, 20, -1, 60 },
            { 0, -1, -1, -1, -1, -1 }
        };
        // 顶点从1开始
        int v = 1;
        shortest( a , v , dist , prev );
    }
}